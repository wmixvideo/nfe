package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.nfe.wsdl.nfeautorizacao.NfeAutorizacao;
import br.inf.portalfiscal.nfe.wsdl.nfeautorizacao.NfeAutorizacaoLoteResult;
import br.inf.portalfiscal.nfe.wsdl.nfeautorizacao.NfeAutorizacaoSoap;
import br.inf.portalfiscal.nfe.wsdl.nfeautorizacao.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.nfeautorizacao.NfeDadosMsg;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFModelo;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvio;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvioRetornoDados;
import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.classes.nota.NFNotaInfoSuplementar;
import com.fincatto.nfe310.converters.ElementNSImplStringConverter;
import com.fincatto.nfe310.parsers.NotaParser;
import com.fincatto.nfe310.parsers.StringElementParser;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import com.fincatto.nfe310.utils.NFGeraChave;
import com.fincatto.nfe310.utils.NFGeraQRCode;
import com.fincatto.nfe310.validadores.xsd.XMLValidador;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import java.net.URL;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

class WSLoteEnvio {

    private static final String NFE_ELEMENTO = "NFe";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSLoteEnvio.class);
    private final NFeConfig config;

    WSLoteEnvio(final NFeConfig config) {
        this.config = config;
    }

    NFLoteEnvioRetorno enviaLoteAssinado(final String loteAssinadoXml, final NFModelo modelo) throws Exception {
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFLoteEnvioRetorno.class, this.comunicaLote(loteAssinadoXml, modelo));
    }

    NFLoteEnvioRetornoDados enviaLote(final NFLoteEnvio lote) throws Exception {
        // adiciona a chave e o dv antes de assinar
        for (final NFNota nota : lote.getNotas()) {
            final NFGeraChave geraChave = new NFGeraChave(nota);
            nota.getInfo().getIdentificacao().setCodigoRandomico(StringUtils.defaultIfBlank(nota.getInfo().getIdentificacao().getCodigoRandomico(), geraChave.geraCodigoRandomico()));
            nota.getInfo().getIdentificacao().setDigitoVerificador(geraChave.getDV());
            nota.getInfo().setIdentificador(geraChave.getChaveAcesso());
        }

        // assina o lote
        final String documentoAssinado = new AssinaturaDigital(this.config).assinarDocumento(lote.toString());
        final NFLoteEnvio loteAssinado = new NotaParser().loteParaObjeto(documentoAssinado);

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

        // guarda o modelo das notas
        final NFModelo modelo = qtdNFC > 0 ? NFModelo.NFCE : NFModelo.NFE;

        // comunica o lote
        final NFLoteEnvioRetorno loteEnvioRetorno = new Persister(new NFRegistryMatcher(), new Format(0)).read(NFLoteEnvioRetorno.class, this.comunicaLote(loteAssinado.toString(), modelo));
        return new NFLoteEnvioRetornoDados(loteEnvioRetorno, loteAssinado);
    }

    private String comunicaLote(final String loteAssinadoXml, final NFModelo modelo) throws Exception {
        //valida o lote assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        XMLValidador.validaLote(loteAssinadoXml);

        //envia o lote para a sefaz
        final NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();
        nfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        nfeCabecMsg.setVersaoDados(NFeConfig.VERSAO_NFE);
        
        final NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.getContent().add(StringElementParser.read(loteAssinadoXml));

        //define o tipo de emissao
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());

        final String endpoint = NFModelo.NFE.equals(modelo) ? autorizador.getNfeAutorizacao(this.config.getAmbiente()) : autorizador.getNfceAutorizacao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Autorizacao " + modelo.name() + ", autorizador " + autorizador.name());
        }

        NfeAutorizacaoSoap port = new NfeAutorizacao(new URL(endpoint)).getNfeAutorizacaoSoap12();
        NfeAutorizacaoLoteResult result = port.nfeAutorizacaoLote(nfeDadosMsg, nfeCabecMsg);

        return ElementNSImplStringConverter.read((ElementNSImpl) result.getContent().get(0));
    }

}
