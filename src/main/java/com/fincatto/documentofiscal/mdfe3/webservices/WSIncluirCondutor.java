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
    private static final String EVENTO_INCLUSAO_CONDUTOR = "110114";
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
        return this.incluirCondutor(chaveAcesso, nomeCondutor, cpfCondutor, 1);
    }

    MDFeRetorno incluirCondutor(final String chaveAcesso, final String nomeCondutor, final String cpfCondutor, final int numeroSequencialEvento) throws Exception {
        final String inclusaoCondutorXML = this.gerarDadosInclusaoCondutor(chaveAcesso, nomeCondutor, cpfCondutor, numeroSequencialEvento).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(inclusaoCondutorXML);
        final String xmlResultado = WSTransporteEvento.enviarEvento(this.httpClient, this.config, xmlAssinado, chaveAcesso, WSIncluirCondutor.VERSAO_LEIAUTE);
        return this.config.getPersister().read(MDFeRetorno.class, xmlResultado);
    }

    private MDFeEvento gerarDadosInclusaoCondutor(final String chaveAcesso, final String nomeCondutor, final String cpfCondutor, final int numeroSequencialEvento) {
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
        infoEvento.setCpf(chaveParser.getCpfEmitente());
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(String.format("ID%s%s%02d", WSIncluirCondutor.EVENTO_INCLUSAO_CONDUTOR, chaveAcesso, numeroSequencialEvento));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEvento);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa().getCodigoIbge());
        infoEvento.setCodigoEvento(WSIncluirCondutor.EVENTO_INCLUSAO_CONDUTOR);
        infoEvento.setDetEvento(mdFeDetalhamentoEvento);

        final MDFeEvento mdfeEventoInclusaoCondutor = new MDFeEvento();
        mdfeEventoInclusaoCondutor.setInfoEvento(infoEvento);
        mdfeEventoInclusaoCondutor.setVersao(WSIncluirCondutor.VERSAO_LEIAUTE);
        return mdfeEventoInclusaoCondutor;
    }
}
