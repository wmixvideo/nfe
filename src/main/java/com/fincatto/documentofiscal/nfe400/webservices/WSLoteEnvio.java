package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.assinatura.AssinaturaDigital;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvio;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvioRetornoDados;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoSuplementar;
import com.fincatto.documentofiscal.nfe400.parsers.DFParser;
import com.fincatto.documentofiscal.nfe400.utils.NFGeraChave;
import com.fincatto.documentofiscal.nfe400.utils.qrcode20.NFGeraQRCode20;
import com.fincatto.documentofiscal.nfe400.utils.qrcode20.NFGeraQRCodeContingenciaOffline20;
import com.fincatto.documentofiscal.nfe400.utils.qrcode20.NFGeraQRCodeEmissaoNormal20;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeAutorizacao4Stub;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeAutorizacao4Stub.NfeResultMsg;
import com.fincatto.documentofiscal.persister.DFPersister;
import com.fincatto.documentofiscal.validadores.xsd.XMLValidador;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;
import java.util.Iterator;

class WSLoteEnvio {

    private static final String NFE_ELEMENTO = "NFe";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSLoteEnvio.class);
    private final NFeConfig config;

    WSLoteEnvio(final NFeConfig config) {
        this.config = config;
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
     * @param lote
     * @return
     * @throws Exception
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
        final String documentoAssinado = new AssinaturaDigital(this.config).assinarDocumento(lote.toString());
        final NFLoteEnvio loteAssinado = new DFParser().loteParaObjeto(documentoAssinado);

        // verifica se nao tem NFCe junto com NFe no lote e gera qrcode (apos assinar mesmo, eh assim)
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
                    throw new IllegalArgumentException(String.format("Modelo de nota desconhecida: %s", nota.getInfo().getIdentificacao().getModelo()));
            }
        }
        // verifica se todas as notas do lote sao do mesmo modelo
        if ((qtdNF > 0) && (qtdNFC > 0)) {
            throw new IllegalArgumentException("Lote contendo notas de modelos diferentes!");
        }
        return loteAssinado;
    }

    private NFGeraQRCode20 getNfGeraQRCode20(NFNota nota) {

        NFGeraQRCode20 geraQRCode;

        if (NFTipoEmissao.EMISSAO_NORMAL.equals(nota.getInfo().getIdentificacao().getTipoEmissao())) {
            geraQRCode = new NFGeraQRCodeEmissaoNormal20(nota, this.config);
        } else if (NFTipoEmissao.CONTIGENCIA_OFFLINE.equals(nota.getInfo().getIdentificacao().getTipoEmissao())){
            geraQRCode = new NFGeraQRCodeContingenciaOffline20(nota, this.config);
        }else {
            throw new IllegalArgumentException("QRCode 2.0 Tipo Emissao não implementado: " + nota.getInfo().getIdentificacao().getTipoEmissao().getDescricao() );
        }
        return geraQRCode;
    }

    private NFLoteEnvioRetorno comunicaLote(final String loteAssinadoXml, final DFModelo modelo) throws Exception {
        // valida o lote assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        XMLValidador.validaLote400(loteAssinadoXml);

        // envia o lote para a sefaz
        final OMElement omElement = this.nfeToOMElement(loteAssinadoXml);

        final com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeAutorizacao4Stub.NfeDadosMsg dados = new com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeAutorizacao4Stub.NfeDadosMsg();
        dados.setExtraElement(omElement);

        // define o tipo de emissao
        final NFAutorizador400 autorizador = NFAutorizador400.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());

        final String endpoint = DFModelo.NFE.equals(modelo) ? autorizador.getNfeAutorizacao(this.config.getAmbiente()) : autorizador.getNfceAutorizacao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Autorizacao " + modelo.name() + ", autorizador " + autorizador.name());
        }

        final NfeResultMsg autorizacaoLoteResult = new NFeAutorizacao4Stub(endpoint).nfeAutorizacaoLote(dados);
        final NFLoteEnvioRetorno loteEnvioRetorno = new DFPersister().read(NFLoteEnvioRetorno.class, autorizacaoLoteResult.getExtraElement().toString());
        WSLoteEnvio.LOGGER.info(loteEnvioRetorno.toString());
        return loteEnvioRetorno;
    }

    private OMElement nfeToOMElement(final String documento) throws XMLStreamException {
        final XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_COALESCING, false);
        final XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(documento));
        final StAXOMBuilder builder = new StAXOMBuilder(reader);
        final OMElement ome = builder.getDocumentElement();
        final Iterator<?> children = ome.getChildrenWithLocalName(WSLoteEnvio.NFE_ELEMENTO);
        while (children.hasNext()) {
            final OMElement omElement = (OMElement) children.next();
            if ((omElement != null) && (WSLoteEnvio.NFE_ELEMENTO.equals(omElement.getLocalName()))) {
                omElement.addAttribute("xmlns", NFeConfig.NAMESPACE, null);
            }
        }
        return ome;
    }
}
