package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFInfoEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.NFDetEvento;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

abstract class AbstractWSEvento implements DFLog {
    protected final NFeConfig config;
    protected String chaveAcesso;
    protected int numeroSequencialEvento;
    protected DFUnidadeFederativa ufAutorEvento;

    protected abstract BigDecimal getVersaoLayout();
    protected abstract String getCodigoEvento();
    protected abstract String getDescricaoEvento();

    AbstractWSEvento(NFeConfig config) {
        this.config = config;
    }

    protected abstract String getChaveAcesso();
    protected abstract NFEnviaEvento gerarDadosXml();

    /**
     * Orquestra o processo de geração, assinatura e transmissão do evento para a SEFAZ.
     *
     * @return {@link NFEnviaEventoRetorno} contendo a resposta do web service.
     * @throws Exception
     */
    public NFEnviaEventoRetorno gerarEnviarEvento() throws Exception {
        final String atualizacaoDataPrevisaoEntregaXMl = this.gerarDadosXml().toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config)
                .assinarDocumento(atualizacaoDataPrevisaoEntregaXMl);
        final OMElement omElementResult = this.transmiteEvento(xmlAssinado, this.getChaveAcesso());

        return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }

    /**
     * Gera os dados padrão do XML de evento. Referente os grupos pais do detalhamento do evento (detEvento).
     * Classes pais relacionadas:
     * {@link NFEnviaEvento}
     * {@link NFEvento}
     * {@link NFInfoEvento}
     *
     * @param detEvento Detalhes específicos do evento.
     * @return Objeto NFEnviaEvento com os dados padrão preenchidos.
     */
    protected NFEnviaEvento gerarDadosPaiXml(NFDetEvento detEvento) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(this.chaveAcesso);
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(this.chaveAcesso);
        infoEvento.setCpf(chaveParser.getCpfEmitente());
        infoEvento.setCnpj(chaveParser.getCnpjEmitente());
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(ChaveAcessoUtils.geraIDevento(this.chaveAcesso, this.getCodigoEvento(), numeroSequencialEvento));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEvento);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(this.getCodigoEvento());
        infoEvento.setVersaoEvento(this.getVersaoLayout());
        infoEvento.setDadosEvento(detEvento);

        final NFEvento evento = new NFEvento();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(this.getVersaoLayout());

        final NFEnviaEvento enviaEvento = new NFEnviaEvento();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(this.getVersaoLayout());
        return enviaEvento;
    }

    /**
     * Realiza a transmissão do evento para o web service da SEFAZ.
     *
     * @param xmlAssinado XML do evento assinado digitalmente.
     * @param chaveAcesso Chave de acesso da NF-e relacionada ao evento.
     * @return OMElement contendo a resposta do web service.
     * @throws Exception Caso ocorra algum erro durante a transmissão.
     */
    private OMElement transmiteEvento(final String xmlAssinado, final String chaveAcesso) throws Exception {
        final NFeRecepcaoEvento4Stub.NfeDadosMsg dados = new NFeRecepcaoEvento4Stub.NfeDadosMsg();

        final OMElement omElementXML = AXIOMUtil.stringToOM(xmlAssinado);
        this.getLogger().debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);

        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador400 autorizador = NFAutorizador400.SVRS;
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ?
                autorizador.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException(
                    "Nao foi possivel encontrar URL para RecepcaoEvento "
                            + parser.getModelo().name() + ", autorizador "
                            + autorizador.name()
            );
        }

        final NFeRecepcaoEvento4Stub.NfeResultMsg nfeRecepcaoEvento = new NFeRecepcaoEvento4Stub(urlWebService, config)
                .nfeRecepcaoEvento(dados);
        final OMElement omElementResult = nfeRecepcaoEvento.getExtraElement();
        this.getLogger().debug(omElementResult.toString());

        return omElementResult;
    }
}
;