package com.fincatto.documentofiscal.nfe400.webservices;

import java.io.StringReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.commons.lang3.StringUtils;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvio;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvioRetornoDados;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoSuplementar;
import com.fincatto.documentofiscal.nfe400.utils.NFGeraChave;
import com.fincatto.documentofiscal.nfe400.utils.qrcode20.NFGeraQRCode20;
import com.fincatto.documentofiscal.nfe400.utils.qrcode20.NFGeraQRCodeContingenciaOffline20;
import com.fincatto.documentofiscal.nfe400.utils.qrcode20.NFGeraQRCodeEmissaoNormal20;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeAutorizacao4Stub.NfeResultMsg;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

class WSLoteEnvio implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4";
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

    NFLoteEnvioRetornoDados enviaLote(final NFLoteEnvio lote, boolean validarXML) throws Exception {
        final NFLoteEnvio loteAssinado = this.getLoteAssinado(lote);
        final NFLoteEnvioRetorno loteEnvioRetorno = this.comunicaLote(loteAssinado.toString(),
                loteAssinado.getNotas().get(0).getInfo().getIdentificacao().getModelo(), validarXML);
        return new NFLoteEnvioRetornoDados(loteEnvioRetorno, loteAssinado);
    }

    NFLoteEnvioRetornoDados enviaLote(final NFLoteEnvio lote) throws Exception {
        return this.enviaLote(lote, true);
    }

    /**
     * Retorna o Lote assinado.
     */
    NFLoteEnvio getLoteAssinado(final NFLoteEnvio lote) throws Exception {
        // adiciona a chave e o dv antes de assinar
        for (final NFNota nota : lote.getNotas()) {
            final NFGeraChave geraChave = new NFGeraChave(nota);
            nota.getInfo().getIdentificacao().setCodigoRandomico(StringUtils.defaultIfBlank(
                    nota.getInfo().getIdentificacao().getCodigoRandomico(), geraChave.geraCodigoRandomico()));
            nota.getInfo().getIdentificacao().setDigitoVerificador(geraChave.getDV());
            nota.getInfo().setIdentificador(geraChave.getChaveAcesso());
        }
        // assina o lote
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(lote.toString());
        final NFLoteEnvio loteAssinado = this.config.getPersister().read(NFLoteEnvio.class, documentoAssinado);

        // verifica se nao tem NFCe junto com NFe no lote e gera qrcode (apos assinar
        // mesmo, eh assim)
        int qtdNF = 0, qtdNFC = 0;
        for (final NFNota nota : loteAssinado.getNotas()) {
            switch (nota.getInfo().getIdentificacao().getModelo()) {
                case NFE:
                    qtdNF++;
                    break;
                case NFCE:
                    NFGeraQRCode20 geraQRCode = getNfGeraQRCode20(nota);

                    nota.setInfoSuplementar(new NFNotaInfoSuplementar());
                    nota.getInfoSuplementar().setUrlConsultaChaveAcesso(geraQRCode.urlConsultaChaveAcesso());
                    nota.getInfoSuplementar().setQrCode(geraQRCode.getQRCode());
                    qtdNFC++;
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Modelo de nota desconhecida: %s",
                            nota.getInfo().getIdentificacao().getModelo()));
            }
        }
        // verifica se todas as notas do lote sao do mesmo modelo
        if ((qtdNF > 0) && (qtdNFC > 0)) {
            throw new IllegalArgumentException("Lote contendo notas de modelos diferentes!");
        }
        return loteAssinado;
    }

    private NFGeraQRCode20 getNfGeraQRCode20(NFNota nota) {
        if (NFTipoEmissao.EMISSAO_NORMAL.equals(nota.getInfo().getIdentificacao().getTipoEmissao())) {
            return new NFGeraQRCodeEmissaoNormal20(nota, this.config);
        } else if (NFTipoEmissao.CONTIGENCIA_OFFLINE.equals(nota.getInfo().getIdentificacao().getTipoEmissao())) {
            return new NFGeraQRCodeContingenciaOffline20(nota, this.config);
        } else {
            throw new IllegalArgumentException("QRCode 2.0 Tipo Emissao nao implementado: "
                    + nota.getInfo().getIdentificacao().getTipoEmissao().getDescricao());
        }
    }

    private NFLoteEnvioRetorno comunicaLote(final String loteAssinadoXml, final DFModelo modelo, boolean validarXML)
            throws Exception {
        final String xmlResultado = this.efetuaComunicacaoLote(loteAssinadoXml, modelo, validarXML);
        final NFLoteEnvioRetorno loteEnvioRetorno = this.config.getPersister().read(NFLoteEnvioRetorno.class, xmlResultado);
        this.getLogger().debug(loteEnvioRetorno.toString());
        return loteEnvioRetorno;
    }

    private NFLoteEnvioRetorno comunicaLote(final String loteAssinadoXml, final DFModelo modelo) throws Exception {
        return this.comunicaLote(loteAssinadoXml, modelo, true);
    }

    NfeResultMsg comunicaLoteRaw(final String loteAssinadoXml, final DFModelo modelo, boolean validarXML)
            throws Exception {
        final String xmlResultado = this.efetuaComunicacaoLote(loteAssinadoXml, modelo, validarXML);
        return WSLoteEnvio.criarNfeResultMsg(xmlResultado);
    }

    /**
     * Valida (se pedido), envia o lote assinado para a sefaz via {@link DFHttpClient} e
     * devolve o XML de negocio ja desempacotado do envelope SOAP 1.2 de resposta.
     */
    private String efetuaComunicacaoLote(final String loteAssinadoXml, final DFModelo modelo, final boolean validarXML)
            throws Exception {
        if (validarXML) {
            // valida o lote assinado, para verificar se o xsd foi satisfeito, antes de
            // comunicar com a sefaz
            DFXMLValidador.validaLote400(loteAssinadoXml);
        }

        // define o tipo de emissao
        final NFAutorizador400 autorizador = NFAutorizador400.valueOfTipoEmissao(this.config.getTipoEmissao(),
                this.config.getCUF());

        final String endpoint = DFModelo.NFE.equals(modelo) ? autorizador.getNfeAutorizacao(this.config.getAmbiente())
                : autorizador.getNfceAutorizacao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Autorizacao " + modelo.name()
                    + ", autorizador " + autorizador.name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSLoteEnvio.NAMESPACE_WSDL, "nfeDadosMsg", loteAssinadoXml);
        final String resposta = this.httpClient.postSoap(endpoint, WSLoteEnvio.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    /**
     * Reconstroi o {@link NfeResultMsg} do Axis2 a partir do XML de negocio ja desempacotado,
     * sem nenhuma chamada de rede via Axis2 - mantido apenas para nao quebrar a assinatura
     * publica de {@link WSFacade#getNfeResultMsg}. Pacote-privado (em vez de {@code private})
     * para poder ser testado diretamente: e o unico ponto do projeto que ainda exercita
     * {@link StAXOMBuilder}/axiom-impl em tempo de execucao.
     */
    static NfeResultMsg criarNfeResultMsg(final String xmlNegocio) throws XMLStreamException {
        final XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_COALESCING, false);
        // Defesa em profundidade contra XXE: xmlNegocio hoje sempre chega aqui ja desempacotado
        // por DFSoapEnvelope.desempacotar (que ja endurece o parsing DOM da resposta), mas o
        // StAX do JDK nao desabilita DTD/entidades externas por padrao - se um refactor futuro
        // passar XML bruto para este metodo, essa protecao evita reabrir a superficie de XXE.
        factory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        final XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(xmlNegocio));
        final StAXOMBuilder builder = new StAXOMBuilder(reader);
        final NfeResultMsg resultMsg = new NfeResultMsg();
        resultMsg.setExtraElement(builder.getDocumentElement());
        return resultMsg;
    }
}
