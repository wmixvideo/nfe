package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.roubo.NFDetEventoRouboTransporteContratado;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito.NFDetEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.roubo.NFDetGrupoPerecimento;
import com.fincatto.documentofiscal.nfe400.classes.evento.roubo.NFEnviaEventoRouboTransporteContratado;

import java.math.BigDecimal;
import java.util.List;

/**
 * Classe responsável por informar a solicitação de apropriação de crédito presumido
 * Classe utiliza de herança de {@link AbstractWSEvento} para reaproveitar código comum a todos os eventos.
 * A classe {@link NFDetEventoSolicitacaoApropriacaoCreditoPresumido} é utilizada para representar os dados específicos do evento (detEvento).
 *
 * @author Marcos Della Justina Schulz
 */
class WSRouboTransporteAdquirente extends AbstractWsEventoRouboTransporteContratado implements DFLog {
    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Perecimento, perda, roubo ou furto durante o transporte contratado pelo adquirente";
    private static final String CODIGO_EVENTO = "211124";

    private List<NFDetGrupoPerecimento> gruposPerecimento;

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
     * Construtor da classe {@link WSRouboTransporteAdquirente}.
     *
     * @param config Configuração da NF-e utilizada para a comunicação com o web service.
     */
    WSRouboTransporteAdquirente(NFeConfig config) {
        super(config);
    }

    /**
     * Adiciona os dados necessários para a geração do XML do evento de solicitação de apropriação de crédito presumido.
     *
     * @param chaveAcesso            Chave de acesso da NF-e relacionada ao evento.
     * @param ufEmitenteEvento      Unidade federativa do emitente do evento.
     * @param gruposPerecimento Lista de grupos do percimento, perda, roubou ou furto.
     * @param numeroSequencialEvento Número sequencial do evento.
     * @return A própria instância de {@link WSRouboTransporteAdquirente} para permitir encadeamento de chamadas.
     */
    WSRouboTransporteAdquirente adicionarDadosEvento(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento,
            final List<NFDetGrupoPerecimento> gruposPerecimento, final int numeroSequencialEvento
    ) {
        super.chaveAcesso = chaveAcesso;
        this.gruposPerecimento = gruposPerecimento;
        super.numeroSequencialEvento = numeroSequencialEvento;
        super.ufAutorEvento = ufEmitenteEvento;
        return this;
    }

    /**
     * Gera os dados XML específicos do evento de solicitação de apropriação de crédito presumido.
     * @return {@link NFEnviaEventoRouboTransporteContratado} com os dados do evento preenchidos
     */
    protected NFEnviaEventoRouboTransporteContratado gerarDadosXml() {
        final NFDetEventoRouboTransporteContratado detEvento = new NFDetEventoRouboTransporteContratado();
        detEvento.setDescricaoEvento(WSRouboTransporteAdquirente.DESCRICAO_EVENTO);
        detEvento.setVersao(WSRouboTransporteAdquirente.VERSAO_LAYOUT);
        detEvento.setTipoAutor(NFEventoTipoAutor.EMPRESA_DESTINADA);
        detEvento.setVersaoAplicativo(WSRouboTransporteAdquirente.VERSAO_LAYOUT.toString());
        detEvento.setUfAutorEvento(super.ufAutorEvento);
        detEvento.setGruposPerecimento(this.gruposPerecimento);

        return gerarDadosPaiXml(detEvento);
    }
}
