package com.fincatto.documentofiscal.mdfe3.webservices;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.documentofiscal.assinatura.AssinaturaDigital;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioVeiculoCondutor;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.*;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import com.fincatto.documentofiscal.mdfe3.webservices.recepcaoevento.MDFeRecepcaoEventoStub;
import com.fincatto.documentofiscal.persister.DFPersister;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
class WSIncluirCondutor {

    private static final String DESCRICAO_EVENTO = "Inclusao Condutor";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_ENCERRAMENTO = "110114";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSIncluirCondutor.class);
    private final MDFeConfig config;

    WSIncluirCondutor(final MDFeConfig config) {
        this.config = config;
    }

    MDFeRetorno incluirCondutorAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaIncluirCondutor(eventoAssinadoXml, chaveAcesso);
        return new DFPersister().read(MDFeRetorno.class, omElementResult.toString());
    }

    MDFeRetorno incluirCondutor(final String chaveAcesso, final String nomeCondutor, final String cpfCondutor) throws Exception {
        final String encerramentoNotaXML = this.gerarDadosEncerramento(chaveAcesso, nomeCondutor, cpfCondutor).toString();
        final String xmlAssinado = new AssinaturaDigital(this.config).assinarDocumento(encerramentoNotaXML);
        final OMElement omElementResult = this.efetuaIncluirCondutor(xmlAssinado, chaveAcesso);
        return new DFPersister().read(MDFeRetorno.class, omElementResult.toString());
    }

    private OMElement efetuaIncluirCondutor(final String xmlAssinado, final String chaveAcesso) throws Exception {
        final MDFChaveParser mdfChaveParser = new MDFChaveParser(chaveAcesso);
        final MDFeRecepcaoEventoStub.MdfeCabecMsg cabec = new MDFeRecepcaoEventoStub.MdfeCabecMsg();
        cabec.setCUF(mdfChaveParser.getNFUnidadeFederativa().getCodigoIbge());
        cabec.setVersaoDados(BigDecimalParser.tamanho5Com2CasasDecimais(WSIncluirCondutor.VERSAO_LEIAUTE, "Versao do Evento"));

        final MDFeRecepcaoEventoStub.MdfeCabecMsgE cabecE = new MDFeRecepcaoEventoStub.MdfeCabecMsgE();
        cabecE.setMdfeCabecMsg(cabec);

        final MDFeRecepcaoEventoStub.MdfeDadosMsg dados = new MDFeRecepcaoEventoStub.MdfeDadosMsg();
        final OMElement omElementXML = AXIOMUtil.stringToOM(xmlAssinado);
        WSIncluirCondutor.LOGGER.debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);

        WSIncluirCondutor.LOGGER.info(cabec.toString());

        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(mdfChaveParser.getNFUnidadeFederativa());
        final String urlWebService = autorizador.getMDFeRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + mdfChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }
        final MDFeRecepcaoEventoStub.MdfeRecepcaoEventoResult mdfeRecepcaoEventoResult = new MDFeRecepcaoEventoStub(urlWebService).mdfeRecepcaoEvento(dados, cabecE);
        final OMElement omElementResult = mdfeRecepcaoEventoResult.getExtraElement();
        WSIncluirCondutor.LOGGER.debug(omElementResult.toString());
        return omElementResult;
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
