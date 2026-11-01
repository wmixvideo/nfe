package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.epec.*;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvio;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.nfe400.utils.NFGeraChave;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class WSEpec implements DFLog {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    public static final String TIPO_EVENTO_EPEC = "110140";
    public static final String DESCRICAO_EVENTO_EPEC = "EPEC";
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSEpec(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
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
            eventoEpec.getInfoEvento().setIdentificador(ChaveAcessoUtils.geraIDevento(chave, WSEpec.TIPO_EVENTO_EPEC, nSeqEvento));
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
        nfEnviaEventoEpec.setIdLote(StringUtils.isBlank(loteEnvio.getIdLote()) ? String.valueOf(System.currentTimeMillis()) : loteEnvio.getIdLote());
        nfEnviaEventoEpec.setVersao("1.00");
        nfEnviaEventoEpec.setEvento(new ArrayList<NFEventoEpec>());
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
            infEpec.setOrgao(DFUnidadeFederativa.RFB);
            infEpec.setVersaoEvento("1.00");
            infEpec.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
            NFInfoEpec nfInfoEpec = new NFInfoEpec();
            nfInfoEpec.setDataHoraEmissao(ZonedDateTime.ofInstant(nfNota.getInfo().getIdentificacao().getDataHoraEmissao().toInstant(), this.config.getTimeZone().toZoneId()));
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
     * Valida, envia o EPEC assinado para a SEFAZ via {@link DFHttpClient} e devolve o XML de
     * negocio ja desempacotado do envelope SOAP 1.2 de resposta. O evento EPEC embute a propria
     * NF-e/NFC-e (elemento {@code <NFe>}) dentro do XML assinado; como o novo caminho concatena
     * o XML ja serializado.
     */
    public String efetuaComunicacaoEpec(final String loteAssinadoXml, final DFModelo modelo) throws Exception {
        // valida o epec assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        DFXMLValidador.validaEpec(loteAssinadoXml);

        // define o tipo de emissao
        final NFAutorizador400 autorizador = NFAutorizador400.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());

        final String endpoint = DFModelo.NFE.equals(modelo) ? autorizador.getRecepcaoEvento(this.config.getAmbiente()) : autorizador.getNfceRecepcaoEvento(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + modelo.name() + ", autorizador " + autorizador.name());
        }

        return AbstractWSEvento.enviarEvento(this.httpClient, endpoint, loteAssinadoXml);
    }
}
