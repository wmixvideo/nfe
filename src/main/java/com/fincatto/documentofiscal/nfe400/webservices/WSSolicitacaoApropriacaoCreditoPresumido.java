package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito.NFDetEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito.NFDetGrupoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito.NFEnviaEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito.NFEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito.NFInfoEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Classe responsável por informar a solicitação de apropriação de crédito presumido
 * Classe utiliza de herança de {@link AbstractWSEvento} para reaproveitar código comum a todos os eventos.
 * A classe {@link NFDetEventoSolicitacaoApropriacaoCreditoPresumido} é utilizada para representar os dados específicos do evento (detEvento).
 *
 * @author Marcos Della Justina Schulz
 */
class WSSolicitacaoApropriacaoCreditoPresumido extends AbstractWSEvento implements DFLog {
    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Solicita\u00E7\u00E3o de Apropria\u00E7\u00E3o de cr\u00E9dito presumido";
    private static final String CODIGO_EVENTO = "211110";

    private List<NFDetGrupoCreditoPresumido> gruposCreditoPresumido;

    @Override
    protected BigDecimal getVersaoLayout() {
        return VERSAO_LAYOUT;
    }

    @Override
    protected String getCodigoEvento() {
        return CODIGO_EVENTO;
    }

    @Override
    protected String getDescricaoEvento() {
        return DESCRICAO_EVENTO;
    }

    @Override
    protected String getChaveAcesso() {
        return this.chaveAcesso;
    }

    /**
     * Construtor da classe {@link WSInfoEfetPagIntegral}.
     *
     * @param config Configuração da NF-e utilizada para a comunicação com o web service.
     */
    WSSolicitacaoApropriacaoCreditoPresumido(NFeConfig config) {
        super(config);
    }

    /**
     * Adiciona os dados necessários para a geração do XML do evento de solicitação de apropriação de crédito presumido.
     *
     * @param chaveAcesso            Chave de acesso da NF-e relacionada ao evento.
     * @param ufEmitenteEvento
     * @param gruposCreditoPresumido Lista de grupos do crédito presumido.
     * @param numeroSequencialEvento Número sequencial do evento.
     * @return A própria instância de {@link WSSolicitacaoApropriacaoCreditoPresumido} para permitir encadeamento de chamadas.
     */
    WSSolicitacaoApropriacaoCreditoPresumido adicionarDadosEvento(
            final String chaveAcesso, DFUnidadeFederativa ufEmitenteEvento, final List<NFDetGrupoCreditoPresumido> gruposCreditoPresumido, final int numeroSequencialEvento
    ) {
        super.chaveAcesso = chaveAcesso;
        this.gruposCreditoPresumido = gruposCreditoPresumido;
        super.numeroSequencialEvento = numeroSequencialEvento;
        super.ufAutorEvento = ufEmitenteEvento;
        return this;
    }

    /**
     * Gera os dados XML específicos do evento de solicitação de apropriação de crédito presumido.
     * @return {@link NFEnviaEvento} com os dados do evento preenchidos
     */
    protected NFEnviaEventoSolicitacaoApropriacaoCreditoPresumido gerarDadosXml() {
        final NFDetEventoSolicitacaoApropriacaoCreditoPresumido detEvento = new NFDetEventoSolicitacaoApropriacaoCreditoPresumido();
        detEvento.setDescricaoEvento(WSSolicitacaoApropriacaoCreditoPresumido.DESCRICAO_EVENTO);
        detEvento.setVersao(WSSolicitacaoApropriacaoCreditoPresumido.VERSAO_LAYOUT);
        detEvento.setTipoAutor(NFEventoTipoAutor.EMPRESA_DESTINADA);
        detEvento.setVersaoAplicativo(WSSolicitacaoApropriacaoCreditoPresumido.VERSAO_LAYOUT.toString());
        detEvento.setUfAutorEvento(super.ufAutorEvento);
        detEvento.setGruposCreditoPresumido(this.gruposCreditoPresumido);

        return gerarDadosPaiXml(detEvento);
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
     * {@link NFEnviaEventoSolicitacaoApropriacaoCreditoPresumido}
     * {@link NFInfoEventoSolicitacaoApropriacaoCreditoPresumido}
     * {@link NFEventoSolicitacaoApropriacaoCreditoPresumido}
     *
     * @param detEvento Detalhes específicos do evento.
     * @return Objeto NFEnviaEvento com os dados padrão preenchidos.
     */
    private NFEnviaEventoSolicitacaoApropriacaoCreditoPresumido gerarDadosPaiXml(NFDetEventoSolicitacaoApropriacaoCreditoPresumido detEvento) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(this.chaveAcesso);
        final NFInfoEventoSolicitacaoApropriacaoCreditoPresumido infoEvento = new NFInfoEventoSolicitacaoApropriacaoCreditoPresumido();
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

        final NFEventoSolicitacaoApropriacaoCreditoPresumido evento = new NFEventoSolicitacaoApropriacaoCreditoPresumido();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(this.getVersaoLayout());

        final NFEnviaEventoSolicitacaoApropriacaoCreditoPresumido enviaEvento = new NFEnviaEventoSolicitacaoApropriacaoCreditoPresumido();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(this.getVersaoLayout());
        return enviaEvento;
    }
}
