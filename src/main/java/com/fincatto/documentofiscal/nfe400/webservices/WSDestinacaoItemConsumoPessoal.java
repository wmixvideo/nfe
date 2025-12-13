package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.consumopessoal.NFDetEventoDestinacaoItemConsumoPessoal;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.apropriacaocredito.NFDetEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.consumopessoal.NFDetGrupoConsumo;

import java.math.BigDecimal;
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
     * @return {@link NFEnviaEvento} com os dados do evento preenchidos
     */
    @Override
    protected NFEnviaEvento gerarDadosXml() {
        NFEventoTipoAutor.validaTipoAutorEvento(this.tipoAutor, this.getCodigoEvento());
        final NFDetEventoDestinacaoItemConsumoPessoal detEvento = new NFDetEventoDestinacaoItemConsumoPessoal();
        detEvento.setDescricaoEvento(WSDestinacaoItemConsumoPessoal.DESCRICAO_EVENTO);
        detEvento.setVersao(WSDestinacaoItemConsumoPessoal.VERSAO_LAYOUT);
        detEvento.setTipoAutor(this.tipoAutor);
        detEvento.setVersaoAplicativo(WSDestinacaoItemConsumoPessoal.VERSAO_LAYOUT.toString());
        detEvento.setUfAutorEvento(super.ufAutorEvento);
        detEvento.setGruposConsumo(this.gruposConsumo);

        return super.gerarDadosPaiXml(detEvento);
    }
}
