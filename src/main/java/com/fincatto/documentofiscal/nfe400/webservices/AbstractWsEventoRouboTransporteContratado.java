package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.roubo.NFDetEventoRouboTransporteContratado;
import com.fincatto.documentofiscal.nfe400.classes.evento.roubo.NFEnviaEventoRouboTransporteContratado;
import com.fincatto.documentofiscal.nfe400.classes.evento.roubo.NFEventoRouboTransporteContratado;
import com.fincatto.documentofiscal.nfe400.classes.evento.roubo.NFInfoEventoRouboTransporteContratado;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.time.ZonedDateTime;
import java.util.Collections;

public abstract class AbstractWsEventoRouboTransporteContratado extends AbstractWSEvento {

    AbstractWsEventoRouboTransporteContratado(NFeConfig config) {
        super(config);
    }

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
     * {@link NFEnviaEventoRouboTransporteContratado}
     * {@link NFInfoEventoRouboTransporteContratado}
     * {@link NFEventoRouboTransporteContratado}
     *
     * @param detEvento Detalhes específicos do evento.
     * @return Objeto {@link NFEnviaEventoRouboTransporteContratado} com os dados padrão preenchidos.
     */
    protected NFEnviaEventoRouboTransporteContratado gerarDadosPaiXml(NFDetEventoRouboTransporteContratado detEvento) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(this.chaveAcesso);
        final NFInfoEventoRouboTransporteContratado infoEvento = new NFInfoEventoRouboTransporteContratado();
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
        infoEvento.setDetalhesEvento(detEvento);

        final NFEventoRouboTransporteContratado evento = new NFEventoRouboTransporteContratado();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(this.getVersaoLayout());

        final NFEnviaEventoRouboTransporteContratado enviaEvento = new NFEnviaEventoRouboTransporteContratado();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(this.getVersaoLayout());
        return enviaEvento;
    }

    protected abstract NFEnviaEventoRouboTransporteContratado gerarDadosXml();
}
