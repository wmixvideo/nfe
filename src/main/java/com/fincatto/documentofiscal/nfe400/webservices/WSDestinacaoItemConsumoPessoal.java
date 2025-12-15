package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.consumopessoal.NFDetEventoDestinacaoItemConsumoPessoal;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito.NFDetEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.consumopessoal.NFDetGrupoConsumo;
import com.fincatto.documentofiscal.nfe400.classes.evento.consumopessoal.NFEnviaEventoDestinacaoItemConsumoPessoal;
import com.fincatto.documentofiscal.nfe400.classes.evento.consumopessoal.NFEventoDestinacaoItemConsumoPessoal;
import com.fincatto.documentofiscal.nfe400.classes.evento.consumopessoal.NFInfoEventoDestinacaoItemConsumoPessoal;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Classe responsável por informar a Destinação do item para consumo pessoal
 * Classe utiliza de herança de {@link AbstractWSEvento} para reaproveitar código comum a todos os eventos.
 * A classe {@link NFDetEventoSolicitacaoApropriacaoCreditoPresumido} é utilizada para representar os dados específicos do evento (detEvento).
 *
 * @author Marcos Della Justina Schulz
 */
class WSDestinacaoItemConsumoPessoal extends AbstractWSEvento implements DFLog {
    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Perecimento, perda, roubo ou furto durante o transporte contratado pelo adquirente";
    private static final String CODIGO_EVENTO = "211124";

    private List<NFDetGrupoConsumo> gruposConsumo;
    private NFEventoTipoAutor tipoAutor;

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
     * Construtor da classe {@link WSDestinacaoItemConsumoPessoal}.
     *
     * @param config Configuração da NF-e utilizada para a comunicação com o web service.
     */
    WSDestinacaoItemConsumoPessoal(NFeConfig config) {
        super(config);
    }

    /**
     * Adiciona os dados necessários para a geração do XML do evento de destinação do item para consumo pessoal.
     *
     * @param chaveAcesso            Chave de acesso da NF-e relacionada ao evento.
     * @param ufEmitenteEvento      Unidade federativa do emitente do evento.
     * @param gruposConsumo Lista de grupos de itens destinados ao consumo pessoal.
     * @param numeroSequencialEvento Número sequencial do evento.
     * @return A própria instância de {@link WSDestinacaoItemConsumoPessoal} para permitir encadeamento de chamadas.
     */
    WSDestinacaoItemConsumoPessoal adicionarDadosEvento(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento, final List<NFDetGrupoConsumo> gruposConsumo,
            final int numeroSequencialEvento, final NFEventoTipoAutor tipoAutor
    ) {
        super.chaveAcesso = chaveAcesso;
        this.gruposConsumo = gruposConsumo;
        super.numeroSequencialEvento = numeroSequencialEvento;
        super.ufAutorEvento = ufEmitenteEvento;
        this.tipoAutor = tipoAutor;
        return this;
    }

    /**
     * Gera os dados XML específicos do evento de solicitação de apropriação de crédito presumido.
     * @return {@link NFEnviaEventoDestinacaoItemConsumoPessoal} com os dados do evento preenchidos
     */
    protected NFEnviaEventoDestinacaoItemConsumoPessoal gerarDadosXml() {
        NFEventoTipoAutor.validaTipoAutorEvento(this.tipoAutor, this.getCodigoEvento());
        final NFDetEventoDestinacaoItemConsumoPessoal detEvento = new NFDetEventoDestinacaoItemConsumoPessoal();
        detEvento.setDescricaoEvento(WSDestinacaoItemConsumoPessoal.DESCRICAO_EVENTO);
        detEvento.setVersao(WSDestinacaoItemConsumoPessoal.VERSAO_LAYOUT);
        detEvento.setTipoAutor(this.tipoAutor);
        detEvento.setVersaoAplicativo(WSDestinacaoItemConsumoPessoal.VERSAO_LAYOUT.toString());
        detEvento.setUfAutorEvento(super.ufAutorEvento);
        detEvento.setGruposConsumo(this.gruposConsumo);

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
     * {@link NFEnviaEventoDestinacaoItemConsumoPessoal}
     * {@link NFEventoDestinacaoItemConsumoPessoal}
     * {@link NFInfoEventoDestinacaoItemConsumoPessoal}
     *
     * @param detEvento Detalhes específicos do evento.
     * @return Objeto NFEnviaEvento com os dados padrão preenchidos.
     */
    protected NFEnviaEventoDestinacaoItemConsumoPessoal gerarDadosPaiXml(NFDetEventoDestinacaoItemConsumoPessoal detEvento) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(this.chaveAcesso);
        final NFInfoEventoDestinacaoItemConsumoPessoal infoEvento = new NFInfoEventoDestinacaoItemConsumoPessoal();
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

        final NFEventoDestinacaoItemConsumoPessoal evento = new NFEventoDestinacaoItemConsumoPessoal();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(this.getVersaoLayout());

        final NFEnviaEventoDestinacaoItemConsumoPessoal enviaEvento = new NFEnviaEventoDestinacaoItemConsumoPessoal();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(this.getVersaoLayout());
        return enviaEvento;
    }
}
