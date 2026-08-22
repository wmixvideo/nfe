package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteEnvio;
import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteEnvioRetornoDados;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoSuplementar;
import com.fincatto.documentofiscal.nfe310.utils.NFGeraChave;
import com.fincatto.documentofiscal.nfe310.utils.NFGeraQRCode;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.commons.lang3.StringUtils;

class WSLoteEnvio implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeAutorizacao";
    private static final String SOAP_ACTION = WSLoteEnvio.NAMESPACE_WSDL + "/nfeAutorizacaoLote";

    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSLoteEnvio(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFLoteEnvioRetorno enviaLoteAssinado(final String loteAssinadoXml, final DFModelo modelo) throws Exception {
        return this.comunicaLote(loteAssinadoXml, modelo);
    }

    NFLoteEnvioRetornoDados enviaLote(final NFLoteEnvio lote) throws Exception {
        final NFLoteEnvio loteAssinado = this.getLoteAssinado(lote);
        // comunica o lote
        final NFLoteEnvioRetorno loteEnvioRetorno = this.comunicaLote(loteAssinado.toString(), loteAssinado.getNotas().get(0).getInfo().getIdentificacao().getModelo());
        return new NFLoteEnvioRetornoDados(loteEnvioRetorno, loteAssinado);
    }

    /**
     * Retorna o Lote assinado.
     */
    NFLoteEnvio getLoteAssinado(final NFLoteEnvio lote) throws Exception {
        // adiciona a chave e o dv antes de assinar
        for (final NFNota nota : lote.getNotas()) {
            final NFGeraChave geraChave = new NFGeraChave(nota);
            nota.getInfo().getIdentificacao().setCodigoRandomico(StringUtils.defaultIfBlank(nota.getInfo().getIdentificacao().getCodigoRandomico(), geraChave.geraCodigoRandomico()));
            nota.getInfo().getIdentificacao().setDigitoVerificador(geraChave.getDV());
            nota.getInfo().setIdentificador(geraChave.getChaveAcesso());
        }
        // assina o lote
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(lote.toString());
        final NFLoteEnvio loteAssinado = this.config.getPersister().read(NFLoteEnvio.class, documentoAssinado);

        // verifica se nao tem NFCe junto com NFe no lote e gera qrcode (apos assinar mesmo, eh assim)
        int qtdNF = 0, qtdNFC = 0;
        for (final NFNota nota : loteAssinado.getNotas()) {
            switch (nota.getInfo().getIdentificacao().getModelo()) {
                case NFE:
                    qtdNF++;
                    break;
                case NFCE:
                    final NFGeraQRCode geraQRCode = new NFGeraQRCode(nota, this.config);
                    nota.setInfoSuplementar(new NFNotaInfoSuplementar());
                    nota.getInfoSuplementar().setQrCode(geraQRCode.getQRCode());
                    qtdNFC++;
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Modelo de nota desconhecida: %s", nota.getInfo().getIdentificacao().getModelo()));
            }
        }
        // verifica se todas as notas do lote sao do mesmo modelo
        if ((qtdNF > 0) && (qtdNFC > 0)) {
            throw new IllegalArgumentException("Lote contendo notas de modelos diferentes!");
        }
        return loteAssinado;
    }

    private NFLoteEnvioRetorno comunicaLote(final String loteAssinadoXml, final DFModelo modelo) throws Exception {
        // valida o lote assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        DFXMLValidador.validaLote(loteAssinadoXml);

        // define o tipo de emissao
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());

        final String endpoint = DFModelo.NFE.equals(modelo) ? autorizador.getNfeAutorizacao(this.config.getAmbiente()) : autorizador.getNfceAutorizacao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Autorizacao " + modelo.name() + ", autorizador " + autorizador.name());
        }

        final String cabecalho = "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>" + this.config.getVersao() + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSLoteEnvio.NAMESPACE_WSDL, "nfeCabecMsg", cabecalho, "nfeDadosMsg", loteAssinadoXml);
        final String resposta = this.httpClient.postSoap(endpoint, WSLoteEnvio.SOAP_ACTION, envelope);
        final String xmlResultado = DFSoapEnvelope.desempacotar(resposta);
        final NFLoteEnvioRetorno loteEnvioRetorno = this.config.getPersister().read(NFLoteEnvioRetorno.class, xmlResultado);
        this.getLogger().debug(loteEnvioRetorno.toString());
        return loteEnvioRetorno;
    }
}
