package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioVeiculoCondutor;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.*;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
class WSIncluirCondutor implements DFLog {

    private static final String DESCRICAO_EVENTO = "Inclusao Condutor";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_ENCERRAMENTO = "110114";
    private final MDFeConfig config;
    private final DFHttpClient httpClient;

    WSIncluirCondutor(final MDFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    MDFeRetorno incluirCondutorAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, eventoAssinadoXml, chaveAcesso, WSIncluirCondutor.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    MDFeRetorno incluirCondutor(final String chaveAcesso, final String nomeCondutor, final String cpfCondutor) throws Exception {
        final String encerramentoNotaXML = this.gerarDadosEncerramento(chaveAcesso, nomeCondutor, cpfCondutor).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(encerramentoNotaXML);
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, xmlAssinado, chaveAcesso, WSIncluirCondutor.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    private MDFeEvento gerarDadosEncerramento(final String chaveAcesso, final String nomeCondutor, final String cpfCondutor) {
        final MDFChaveParser chaveParser = new MDFChaveParser(chaveAcesso);

        final MDFInfoModalRodoviarioVeiculoCondutor condutor = new MDFInfoModalRodoviarioVeiculoCondutor();
        condutor.setCpf(cpfCondutor);
        condutor.setNomeCondutor(nomeCondutor);

        final MDFeEnviaEventoIncluirCondutor incluirCondutor = new MDFeEnviaEventoIncluirCondutor();
        incluirCondutor.setDescricaoEvento(WSIncluirCondutor.DESCRICAO_EVENTO);
        incluirCondutor.setCondutor(condutor);

        final MDFeDetalhamentoEvento mdFeDetalhamentoEvento = new MDFeDetalhamentoEvento();
        mdFeDetalhamentoEvento.setEnviaEventoIncluirCondutor(incluirCondutor);
        mdFeDetalhamentoEvento.setVersaoEvento(WSIncluirCondutor.VERSAO_LEIAUTE);

        final MDFeInfoEvento infoEvento = new MDFeInfoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s0%s", WSIncluirCondutor.EVENTO_ENCERRAMENTO, chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa().getCodigoIbge());
        infoEvento.setCodigoEvento(WSIncluirCondutor.EVENTO_ENCERRAMENTO);
        infoEvento.setDetEvento(mdFeDetalhamentoEvento);

        final MDFeEvento mdfeEventoEncerramento = new MDFeEvento();
        mdfeEventoEncerramento.setInfoEvento(infoEvento);
        mdfeEventoEncerramento.setVersao(WSIncluirCondutor.VERSAO_LEIAUTE);
        return mdfeEventoEncerramento;
    }
}
