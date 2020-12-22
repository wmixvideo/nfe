package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang3.StringUtils;

import com.fincatto.documentofiscal.nfe400.classes.evento.epec.NFEnviaEventoEpec;
import com.fincatto.documentofiscal.nfe400.classes.evento.epec.NFEnviaEventoEpecRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.epec.NFEventoEpec;
import com.fincatto.documentofiscal.nfe400.classes.evento.epec.NFInfoEpec;
import com.fincatto.documentofiscal.nfe400.classes.evento.epec.NFInfoEventoEpec;
import com.fincatto.documentofiscal.nfe400.classes.evento.epec.NFDestinatarioEpec;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvio;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe400.utils.NFGeraChave;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import java.io.StringReader;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Iterator;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

public class WSEpec implements DFLog {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    public static final String TIPO_EVENTO_EPEC = "110140";
    public static final String DESCRICAO_EVENTO_EPEC = "EPEC";
    private static final String NFE_ELEMENTO = "NFe";
    private final NFeConfig config;

    public WSEpec(NFeConfig config) {
        this.config = config;
    }

    NFEnviaEventoEpecRetorno enviaEpecAssinado(final String epecAssinadoXml) throws Exception {
        return this.comunicaEpec(epecAssinadoXml);
    }

    NFEnviaEventoEpecRetorno enviaEpec(NFLoteEnvio loteEnvio) throws Exception {
        final NFEnviaEventoEpec epec = criaEnvioEpec(loteEnvio);
        // adiciona a chave e o dv antes de assinar
        int nSeqEvento = 1;
        for (final NFEventoEpec eventoEpec : epec.getEvento()) {
            final NFNota nota = eventoEpec.getNota();
            final NFGeraChave geraChave = new NFGeraChave(nota);
            String chave = geraChave.getChaveAcesso();
            eventoEpec.getInfoEvento().setIdentificador(
                    "ID" + TIPO_EVENTO_EPEC + chave + (nSeqEvento < 10 ? "0" + nSeqEvento : nSeqEvento));
            eventoEpec.getInfoEvento().setNumeroSequencialEvento(nSeqEvento++);
            eventoEpec.getInfoEvento().setChave(chave);
        }
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(epec.toString());
        final NFEnviaEventoEpec epecAssinado = this.config.getPersister().read(NFEnviaEventoEpec.class, documentoAssinado);
        final NFEnviaEventoEpecRetorno epecEnvioRetorno = this.comunicaEpec(epecAssinado.toString());
        return epecEnvioRetorno;
    }

    private NFEnviaEventoEpec criaEnvioEpec(NFLoteEnvio loteEnvio) {
        NFEnviaEventoEpec nfEnviaEventoEpec = new NFEnviaEventoEpec();
        nfEnviaEventoEpec.setIdLote(StringUtils.isBlank(loteEnvio.getIdLote()) ? String.valueOf(new java.util.Date().getTime()) : loteEnvio.getIdLote());
        nfEnviaEventoEpec.setVersao("1.00");
        nfEnviaEventoEpec.setEvento(new ArrayList<NFEventoEpec>());
        int i = 1;
        for (NFNota nfNota : loteEnvio.getNotas()) {
            NFEventoEpec nfEventoEpec = new NFEventoEpec();
            nfEventoEpec.setNota(nfNota);
            nfNota.getInfo().getIdentificacao().setTipoEmissao(NFTipoEmissao.CONTINGENCIA_EPEC);
            nfEventoEpec.setVersao("1.00");
            NFInfoEventoEpec infEpec = new NFInfoEventoEpec();
            infEpec.setAmbiente(this.config.getAmbiente());
            if (StringUtils.isNotBlank(nfNota.getInfo().getEmitente().getCnpj())) {
                infEpec.setCnpj(nfNota.getInfo().getEmitente().getCnpj());
            } else {
                infEpec.setCpf(nfNota.getInfo().getEmitente().getCpf());
            }
            infEpec.setCodigoEvento(WSEpec.TIPO_EVENTO_EPEC);
            infEpec.setNumeroSequencialEvento(i++);
            infEpec.setOrgao(DFUnidadeFederativa.RFB);
            infEpec.setVersaoEvento("1.00");
            infEpec.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
            NFInfoEpec nfInfoEpec = new NFInfoEpec();
            nfInfoEpec.setDataHoraEmissao(ZonedDateTime.ofInstant(nfNota.getInfo().getIdentificacao().getDataHoraEmissao().toInstant(), ZoneId.systemDefault()));
            nfInfoEpec.setDescricaoEvento(WSEpec.DESCRICAO_EVENTO_EPEC);
            nfInfoEpec.setInscricaoEstadualEmitente(nfNota.getInfo().getEmitente().getInscricaoEstadual());
            nfInfoEpec.setOrgaoAutor(DFUnidadeFederativa.valueOfCodigo(nfNota.getInfo().getEmitente().getEndereco().getUf()).getCodigoIbge());
            nfInfoEpec.setTipoNota("1"); // Informar 1=Saída.
            nfInfoEpec.setTpAutor("1"); // Informar "1=Empresa Emitente"
            nfInfoEpec.setVersao(WSEpec.VERSAO_LEIAUTE);
            nfInfoEpec.setVersaoAplicativo("1.0");
            infEpec.setEpec(nfInfoEpec);
            if (nfNota.getInfo().getDestinatario() != null) {
                NFDestinatarioEpec nfDestinatarioEpec = new NFDestinatarioEpec();
                if (StringUtils.isNotBlank(nfNota.getInfo().getDestinatario().getCnpj())) {
                    nfDestinatarioEpec.setCnpj(nfNota.getInfo().getDestinatario().getCnpj());
                } else {
                    nfDestinatarioEpec.setCpf(nfNota.getInfo().getDestinatario().getCpfj());
                }
                nfDestinatarioEpec.setIdEstrangeiro(nfNota.getInfo().getDestinatario().getIdEstrangeiro());
                nfDestinatarioEpec.setInscricaoEstadualDestinatario(nfNota.getInfo().getDestinatario().getInscricaoEstadual());
                if (nfNota.getInfo().getDestinatario().getEndereco() != null) {
                    nfDestinatarioEpec.setUfDestinatario(nfNota.getInfo().getDestinatario().getEndereco().getUf());
                }
                if (nfNota.getInfo().getTotal() != null) {
                    nfDestinatarioEpec.setValorTotalIcms(nfNota.getInfo().getTotal().getIcmsTotal().getValorTotalICMS());
                    nfDestinatarioEpec.setValorTotalIcmsSubstituicaoTributaria(nfNota.getInfo().getTotal().getIcmsTotal().getValorTotalICMSST());
                    nfDestinatarioEpec.setValorTotalNFe(nfNota.getInfo().getTotal().getIcmsTotal().getValorTotalNFe());
                }
                nfInfoEpec.setDestinatario(nfDestinatarioEpec);
            }
            nfEventoEpec.setInfoEvento(infEpec);
            nfEnviaEventoEpec.getEvento().add(nfEventoEpec);
        }
        return nfEnviaEventoEpec;
    }

    private NFEnviaEventoEpecRetorno comunicaEpec(String epecAssinadoXml) throws Exception {
        final NFeRecepcaoEvento4Stub.NfeResultMsg recepcaoLoteResult = comunicaLoteRaw(epecAssinadoXml, DFModelo.NFE);
        final OMElement omElementResult = recepcaoLoteResult.getExtraElement();
        String xmlRetorno = omElementResult.toString();
        return this.config.getPersister().read(NFEnviaEventoEpecRetorno.class, xmlRetorno);
    }

    public NFeRecepcaoEvento4Stub.NfeResultMsg comunicaLoteRaw(String loteAssinadoXml, DFModelo modelo) throws Exception {
        // valida o epec assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        DFXMLValidador.validaEpec(loteAssinadoXml);

        // envia o lote para a sefaz
        final OMElement omElement = this.nfeToOMElement(loteAssinadoXml);

        final NFeRecepcaoEvento4Stub.NfeDadosMsg dados = new NFeRecepcaoEvento4Stub.NfeDadosMsg();
        dados.setExtraElement(omElement);

        // define o tipo de emissao
        final NFAutorizador400 autorizador = NFAutorizador400.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());

        final String endpoint = DFModelo.NFE.equals(modelo) ? autorizador.getRecepcaoEvento(this.config.getAmbiente()) : autorizador.getNfceAutorizacao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Autorizacao " + modelo.name() + ", autorizador " + autorizador.name());
        }

        return new NFeRecepcaoEvento4Stub(endpoint, config).nfeRecepcaoEvento(dados);
    }

    private OMElement nfeToOMElement(final String documento) throws XMLStreamException {
        final XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_COALESCING, false);
        final XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(documento));
        final StAXOMBuilder builder = new StAXOMBuilder(reader);
        final OMElement ome = builder.getDocumentElement();
        final Iterator<?> children = ome.getChildrenWithLocalName(WSEpec.NFE_ELEMENTO);
        while (children.hasNext()) {
            final OMElement omElement = (OMElement) children.next();
            if ((omElement != null) && (WSEpec.NFE_ELEMENTO.equals(omElement.getLocalName()))) {
                omElement.addAttribute("xmlns", NFeConfig.NAMESPACE, null);
            }
        }
        return ome;
    }
}
