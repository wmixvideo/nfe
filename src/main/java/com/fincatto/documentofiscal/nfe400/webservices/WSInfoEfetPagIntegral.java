package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.NFDetEventoInfoEfetPagIntegral;

import java.math.BigDecimal;

/**
 * Classe responsável por informar o efetivo pagamento integral para liberar crédito presumido do adquirente
 * Classe utiliza de herança de AbstractWSEvento para reaproveitar código comum a todos os eventos.
 * A classe NFEventoInfoEfetPagIntegral é utilizada para representar os dados específicos do evento (detEvento).
 *
 * @author Marcos Della Justina Schulz
 */
class WSInfoEfetPagIntegral extends AbstractWSEvento implements DFLog {
    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Informa\u00E7\u00E3o de efetivo pagamento integral para liberar cr\u00E9dito presumido do adquirente";
    private static final String CODIGO_EVENTO = "112110";

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
     * Construtor da classe WSInfoEfetPagIntegral.
     *
     * @param config Configuração da NF-e utilizada para a comunicação com o web service.
     */
    WSInfoEfetPagIntegral(NFeConfig config) {
        super(config);
    }

    /**
     * Adiciona os dados necessários para a geração do XML do evento de informação de efetivo pagamento integral.
     *
     * @param chaveAcesso Chave de acesso da NF-e relacionada ao evento.
     * @param ufEmitenteEvento Unidade federativa do emitente do evento.
     * @param numeroSequencialEvento Número sequencial do evento.
     * @return A própria instância de {@link WSInfoEfetPagIntegral} para permitir encadeamento de chamadas.
     */
    WSInfoEfetPagIntegral adicionarDadosEvento(
            final String chaveAcesso, final DFUnidadeFederativa ufEmitenteEvento, final int numeroSequencialEvento
    ) {
        super.chaveAcesso = chaveAcesso;
        this.ufAutorEvento = ufEmitenteEvento;
        this.numeroSequencialEvento = numeroSequencialEvento;
        return this;
    }

    /**
     * Gera os dados XML específicos para o evento de informação de efetivo pagamento integral e chama a criação dos dados comuns
     * @return {@link NFEnviaEvento} com os dados do evento preenchidos
     */
    @Override
    protected NFEnviaEvento gerarDadosXml() {
        final NFDetEventoInfoEfetPagIntegral detEvento = new NFDetEventoInfoEfetPagIntegral();
        detEvento.setDescricaoEvento(WSInfoEfetPagIntegral.DESCRICAO_EVENTO);
        detEvento.setVersao(WSInfoEfetPagIntegral.VERSAO_LAYOUT);
        detEvento.setUfAutorEvento(ufAutorEvento);
        detEvento.setTipoAutor(NFEventoTipoAutor.EMPRESA_EMITENTE);
        detEvento.setVersaoAplicativo(WSInfoEfetPagIntegral.VERSAO_LAYOUT.toString());
        detEvento.setIndicadorQuitacao(1);

        return super.gerarDadosPaiXml(detEvento);
    }
}
