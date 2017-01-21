package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.nfe.wsdl.recepcaoevento.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.recepcaoevento.NfeDadosMsg;
import br.inf.portalfiscal.nfe.wsdl.recepcaoevento.NfeRecepcaoEventoResult;
import br.inf.portalfiscal.nfe.wsdl.recepcaoevento.RecepcaoEvento;
import br.inf.portalfiscal.nfe.wsdl.recepcaoevento.RecepcaoEventoSoap;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFModelo;
import com.fincatto.nfe310.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.nfe310.classes.evento.cancelamento.NFEnviaEventoCancelamento;
import com.fincatto.nfe310.classes.evento.cancelamento.NFEventoCancelamento;
import com.fincatto.nfe310.classes.evento.cancelamento.NFInfoCancelamento;
import com.fincatto.nfe310.classes.evento.cancelamento.NFInfoEventoCancelamento;
import com.fincatto.nfe310.converters.ElementStringConverter;
import com.fincatto.nfe310.parsers.NotaFiscalChaveParser;
import com.fincatto.nfe310.persister.NFPersister;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Collections;
import org.w3c.dom.Element;

class WSCancelamento {
    private static final String DESCRICAO_EVENTO = "Cancelamento";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String EVENTO_CANCELAMENTO = "110111";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSCancelamento.class);
    private final NFeConfig config;

    WSCancelamento(final NFeConfig config) {
        this.config = config;
    }

    NFEnviaEventoRetorno cancelaNotaAssinada(final String eventoAssinadoXml, final String chaveAcesso) throws Exception {
        return new NFPersister().read(NFEnviaEventoRetorno.class, efetuaCancelamento(eventoAssinadoXml, chaveAcesso));
    }

    NFEnviaEventoRetorno cancelaNota(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
        final String cancelamentoNotaXML = this.gerarDadosCancelamento(chaveAcesso, numeroProtocolo, motivo).toString();
        final String xmlAssinado = new AssinaturaDigital(this.config).assinarDocumento(cancelamentoNotaXML);
        return new NFPersister().read(NFEnviaEventoRetorno.class, efetuaCancelamento(xmlAssinado, chaveAcesso));
    }

    private NFEnviaEventoCancelamento gerarDadosCancelamento(final String chaveAcesso, final String numeroProtocolo, final String motivo) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);

        final NFInfoCancelamento cancelamento = new NFInfoCancelamento();
        cancelamento.setDescricaoEvento(WSCancelamento.DESCRICAO_EVENTO);
        cancelamento.setVersao(WSCancelamento.VERSAO_LEIAUTE);
        cancelamento.setJustificativa(motivo);
        cancelamento.setProtocoloAutorizacao(numeroProtocolo);

        final NFInfoEventoCancelamento infoEvento = new NFInfoEventoCancelamento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(DateTime.now());
        infoEvento.setId(String.format("ID%s%s0%s", WSCancelamento.EVENTO_CANCELAMENTO, chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(WSCancelamento.EVENTO_CANCELAMENTO);
        infoEvento.setVersaoEvento(WSCancelamento.VERSAO_LEIAUTE);
        infoEvento.setCancelamento(cancelamento);

        final NFEventoCancelamento evento = new NFEventoCancelamento();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(WSCancelamento.VERSAO_LEIAUTE);

        final NFEnviaEventoCancelamento enviaEvento = new NFEnviaEventoCancelamento();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(DateTime.now().getMillis()));
        enviaEvento.setVersao(WSCancelamento.VERSAO_LEIAUTE);
        return enviaEvento;
    }

    private String efetuaCancelamento(final String xml, final String chaveAcesso) throws Exception {
        final NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();

        nfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        nfeCabecMsg.setVersaoDados(WSCancelamento.VERSAO_LEIAUTE.toPlainString());

        final NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.getContent().add(ElementStringConverter.read(xml));

        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfChaveAcesso(chaveAcesso);
        final String endpoint = NFModelo.NFCE.equals(parser.getModelo()) ? autorizador.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        RecepcaoEventoSoap port = new RecepcaoEvento(new URL(endpoint)).getRecepcaoEventoSoap12();
        NfeRecepcaoEventoResult result = port.nfeRecepcaoEvento(nfeDadosMsg, nfeCabecMsg);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }
    
}
