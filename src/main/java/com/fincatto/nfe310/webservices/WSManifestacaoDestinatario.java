package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.nfe.wsdl.recepcaoevento.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.recepcaoevento.NfeDadosMsg;
import br.inf.portalfiscal.nfe.wsdl.recepcaoevento.NfeRecepcaoEventoResult;
import br.inf.portalfiscal.nfe.wsdl.recepcaoevento.RecepcaoEvento;
import br.inf.portalfiscal.nfe.wsdl.recepcaoevento.RecepcaoEventoSoap;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.nfe310.classes.evento.manifestacaodestinatario.NFEnviaEventoManifestacaoDestinatario;
import com.fincatto.nfe310.classes.evento.manifestacaodestinatario.NFEventoManifestacaoDestinatario;
import com.fincatto.nfe310.classes.evento.manifestacaodestinatario.NFInfoEventoManifestacaoDestinatario;
import com.fincatto.nfe310.classes.evento.manifestacaodestinatario.NFInfoManifestacaoDestinatario;
import com.fincatto.nfe310.classes.evento.manifestacaodestinatario.NFTipoEventoManifestacaoDestinatario;
import com.fincatto.nfe310.converters.ElementStringConverter;
import com.fincatto.nfe310.parsers.NotaFiscalChaveParser;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Collections;
import org.joda.time.DateTime;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class WSManifestacaoDestinatario {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final Logger LOGGER = LoggerFactory.getLogger(WSManifestacaoDestinatario.class);
    private final NFeConfig config;

    public WSManifestacaoDestinatario(NFeConfig config) {
        this.config = config;
    }

    NFEnviaEventoRetorno manifestaDestinatarioNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFEnviaEventoRetorno.class, efetuaManifestacaoDestinatario(eventoAssinadoXml, chaveAcesso));
    }

    NFEnviaEventoRetorno manifestaDestinatarioNota(final String chaveAcesso, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj) throws Exception {
        final String manifestacaoDestinatarioNotaXML = this.gerarDadosManifestacaoDestinatario(chaveAcesso, tipoEvento, motivo, cnpj).toString();
        final String xmlAssinado = new AssinaturaDigital(this.config).assinarDocumento(manifestacaoDestinatarioNotaXML);
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFEnviaEventoRetorno.class, efetuaManifestacaoDestinatario(xmlAssinado, chaveAcesso));
    }

    private NFEnviaEventoManifestacaoDestinatario gerarDadosManifestacaoDestinatario(final String chaveAcesso, final NFTipoEventoManifestacaoDestinatario tipoEvento, final String motivo, final String cnpj) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);

        final NFInfoManifestacaoDestinatario manifestacaoDestinatario = new NFInfoManifestacaoDestinatario();
        manifestacaoDestinatario.setDescricaoEvento(tipoEvento.getDescricao());
        manifestacaoDestinatario.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        manifestacaoDestinatario.setJustificativa(motivo);

        final NFInfoEventoManifestacaoDestinatario infoEvento = new NFInfoEventoManifestacaoDestinatario();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(chaveAcesso);
        infoEvento.setCnpj(cnpj);
        infoEvento.setDataHoraEvento(DateTime.now());
        infoEvento.setId(String.format("ID%s%s0%s", tipoEvento.getCodigo(), chaveAcesso, "1"));
        infoEvento.setNumeroSequencialEvento(1);
        infoEvento.setOrgao(NFUnidadeFederativa.RFB);
        infoEvento.setCodigoEvento(tipoEvento.getCodigo());
        infoEvento.setVersaoEvento(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        infoEvento.setManifestacaoDestinatario(manifestacaoDestinatario);

        final NFEventoManifestacaoDestinatario evento = new NFEventoManifestacaoDestinatario();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);

        final NFEnviaEventoManifestacaoDestinatario enviaEvento = new NFEnviaEventoManifestacaoDestinatario();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(DateTime.now().getMillis()));
        enviaEvento.setVersao(WSManifestacaoDestinatario.VERSAO_LEIAUTE);
        return enviaEvento;
    }

    private String efetuaManifestacaoDestinatario(final String xml, final String chaveAcesso) throws Exception {
        final NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();

        nfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        nfeCabecMsg.setVersaoDados(WSManifestacaoDestinatario.VERSAO_LEIAUTE.toPlainString());

        final NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.getContent().add(ElementStringConverter.read(xml));

        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfChaveAcesso(chaveAcesso);
        final String endpoint = autorizador.getRecepcaoEventoAN(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        RecepcaoEventoSoap port = new RecepcaoEvento(new URL(endpoint)).getRecepcaoEventoSoap12();
        NfeRecepcaoEventoResult result = port.nfeRecepcaoEvento(nfeDadosMsg, nfeCabecMsg);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

}
