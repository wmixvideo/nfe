package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.axiom.om.impl.builder.StAXOMBuilder;
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
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub.NfeResultMsg;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSocketFactory;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

public class WSEpec implements DFLog {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    public static final String TIPO_EVENTO_EPEC = "110140";
    public static final String DESCRICAO_EVENTO_EPEC = "EPEC";
    private final NFeConfig config;
    // DFHttpClient recebido do WSFacade (compartilhado com os demais servicos migrados) quando
    // esta classe e construida atraves dele; fica null quando construida via
    // WSEpec(NFeConfig) diretamente por codigo externo.
    private final DFHttpClient httpClientCompartilhado;
    // Criado sob demanda (lazy) apenas quando ninguem injetou um DFHttpClient - so na primeira
    // chamada de rede, nunca no construtor. Mesma razao documentada em
    // WSManifestacaoDestinatario: preservar o comportamento anterior (falha de certificado/SSL
    // so aparece ao chamar a SEFAZ, nunca ao instanciar a classe) sem quebrar quem ja chama
    // WSEpec(NFeConfig) hoje.
    private DFHttpClient httpClientProprio;

    public WSEpec(final NFeConfig config) {
        this(config, null);
    }

    WSEpec(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClientCompartilhado = httpClient;
    }

    private synchronized DFHttpClient getHttpClient() throws Exception {
        if (this.httpClientCompartilhado != null) {
            return this.httpClientCompartilhado;
        }
        if (this.httpClientProprio == null) {
            final DFSocketFactory socketFactory = new DFSocketFactory(this.config);
            this.httpClientProprio = new DFHttpClient(socketFactory.getSslContext(), this.config);
        }
        return this.httpClientProprio;
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
        final String xmlRetorno = this.efetuaComunicacaoEpec(epecAssinadoXml, DFModelo.NFE);
        return this.config.getPersister().read(NFEnviaEventoEpecRetorno.class, xmlRetorno);
    }

    /**
     * Metodo publico legado que devolve o tipo do Axis2 ({@code NFeRecepcaoEvento4Stub.NfeResultMsg}).
     * Mantido por compatibilidade de API (WSEpec e classe publica, sem garantia de que so o
     * WSFacade a use) - a assinatura e o tipo de retorno nao mudam, mas o objeto e reconstruido
     * localmente a partir do XML de resposta, sem nenhuma chamada de rede via Axis2. Mesmo
     * padrao usado em WSLoteEnvio.comunicaLoteRaw.
     */
    public NFeRecepcaoEvento4Stub.NfeResultMsg comunicaLoteRaw(String loteAssinadoXml, DFModelo modelo) throws Exception {
        final String xmlRetorno = this.efetuaComunicacaoEpec(loteAssinadoXml, modelo);
        return WSEpec.criarNfeResultMsg(xmlRetorno);
    }

    /**
     * Valida, envia o EPEC assinado para a SEFAZ via {@link DFHttpClient} e devolve o XML de
     * negocio ja desempacotado do envelope SOAP 1.2 de resposta. O evento EPEC embute a propria
     * NF-e/NFC-e (elemento {@code <NFe>}) dentro do XML assinado; como o novo caminho concatena
     * o XML ja serializado (em vez de reconstruir a arvore via Axiom, como o Axis2 fazia), nao
     * e mais necessario forcar {@code xmlns} em cada {@code <NFe>} embutido - o namespace ja
     * vem herdado do elemento pai no XML original.
     */
    private String efetuaComunicacaoEpec(final String loteAssinadoXml, final DFModelo modelo) throws Exception {
        // valida o epec assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        DFXMLValidador.validaEpec(loteAssinadoXml);

        // define o tipo de emissao
        final NFAutorizador400 autorizador = NFAutorizador400.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());

        final String endpoint = DFModelo.NFE.equals(modelo) ? autorizador.getRecepcaoEvento(this.config.getAmbiente()) : autorizador.getNfceAutorizacao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Autorizacao " + modelo.name() + ", autorizador " + autorizador.name());
        }

        return AbstractWSEvento.enviarEvento(this.getHttpClient(), endpoint, loteAssinadoXml);
    }

    private static NfeResultMsg criarNfeResultMsg(final String xmlNegocio) throws Exception {
        final XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_COALESCING, false);
        final XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(xmlNegocio));
        final StAXOMBuilder builder = new StAXOMBuilder(reader);
        final NfeResultMsg resultMsg = new NfeResultMsg();
        resultMsg.setExtraElement(builder.getDocumentElement());
        return resultMsg;
    }
}
