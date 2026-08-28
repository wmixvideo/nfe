package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.*;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
class WSIncluirDFe implements DFLog {

    private static final String DESCRICAO_EVENTO = "Inclusao DF-e";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_INCLUSAO_DFE = "110115";
    private final MDFeConfig config;
    private final DFHttpClient httpClient;

    WSIncluirDFe(final MDFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    MDFeRetorno incluirDFeAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, eventoAssinadoXml, chaveAcesso, WSIncluirDFe.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    MDFeRetorno incluirDFe(final String chaveAcesso, final String nProt, final String cMunCarrega, final String xMunCarrega, final List<MDFeEnviaEventoIncluirDFeInfDoc> infDoc) throws Exception {
        return this.incluirDFe(chaveAcesso, nProt, cMunCarrega, xMunCarrega, infDoc, 1);
    }

    MDFeRetorno incluirDFe(final String chaveAcesso, final String nProt, final String cMunCarrega, final String xMunCarrega, final List<MDFeEnviaEventoIncluirDFeInfDoc> infDoc, final int numeroSequencialEvento) throws Exception {
        final String inclusaoDFeXML = this.gerarDadosInclusaoDFe(chaveAcesso, nProt, cMunCarrega, xMunCarrega, infDoc, numeroSequencialEvento).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(inclusaoDFeXML);
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, xmlAssinado, chaveAcesso, WSIncluirDFe.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    private MDFeEvento gerarDadosInclusaoDFe(final String chaveAcesso, final String nProt, final String cMunCarrega, final String xMunCarrega, final List<MDFeEnviaEventoIncluirDFeInfDoc> infDoc, final int numeroSequencialEvento) {
        final MDFChaveParser chaveParser = new MDFChaveParser(chaveAcesso);

        final MDFeEnviaEventoIncluirDFe incluirDFe = new MDFeEnviaEventoIncluirDFe();
        incluirDFe.setDescricaoEvento(WSIncluirDFe.DESCRICAO_EVENTO);
        incluirDFe.setnProt(nProt);
        incluirDFe.setCodigoMunicipioCarregamento(cMunCarrega);
        incluirDFe.setNomeMunicipioCarregamento(xMunCarrega);
        incluirDFe.setInfDoc(infDoc);

        final MDFeDetalhamentoEvento mdFeDetalhamentoEvento = new MDFeDetalhamentoEvento();
        mdFeDetalhamentoEvento.setEnviaEventoIncluirDFe(incluirDFe);
        mdFeDetalhamentoEvento.setVersaoEvento(WSIncluirDFe.VERSAO_LEIAUTE);

        final MDFeInfoEvento infoEvento = new MDFeInfoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCpf(chaveParser.getCpfEmitente());
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s%02d", WSIncluirDFe.EVENTO_INCLUSAO_DFE, chaveAcesso, numeroSequencialEvento));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEvento);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa().getCodigoIbge());
        infoEvento.setCodigoEvento(WSIncluirDFe.EVENTO_INCLUSAO_DFE);
        infoEvento.setDetEvento(mdFeDetalhamentoEvento);

        final MDFeEvento mdfeEventoInclusaoDFe = new MDFeEvento();
        mdfeEventoInclusaoDFe.setInfoEvento(infoEvento);
        mdfeEventoInclusaoDFe.setVersao(WSIncluirDFe.VERSAO_LEIAUTE);
        return mdfeEventoInclusaoDFe;
    }
}
