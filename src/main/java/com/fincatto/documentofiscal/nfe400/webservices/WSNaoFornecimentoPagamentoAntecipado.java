package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.naofornecido.NFDetEventoNaoFornecimentoPagamentoAntecipado;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.apropriacaocredito.NFDetEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.naofornecido.NFDetGrupoItemNaoFornecido;

import java.math.BigDecimal;
import java.util.List;

/**
 * Classe responsável por informar o Fornecimento não realizado com pagamento antecipado
 * Classe utiliza de herança de {@link AbstractWSEvento} para reaproveitar código comum a todos os eventos.
 * A classe {@link NFDetEventoSolicitacaoApropriacaoCreditoPresumido} é utilizada para representar os dados específicos do evento (detEvento).
 *
 * @author Marcos Della Justina Schulz
 */
class WSNaoFornecimentoPagamentoAntecipado extends AbstractWSEvento implements DFLog {
    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Fornecimento n\u00E3o realizado com pagamento antecipado";
    private static final String CODIGO_EVENTO = "112140";

    private List<NFDetGrupoItemNaoFornecido> gruposItensNaoInformados;

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
     * Construtor da classe {@link WSNaoFornecimentoPagamentoAntecipado}.
     *
     * @param config Configuração da NF-e utilizada para a comunicação com o web service.
     */
    WSNaoFornecimentoPagamentoAntecipado(NFeConfig config) {
        super(config);
    }

    /**
     * Adiciona os dados necessários para a geração do XML do evento de Fornecimento não realizado com pagamento antecipado
     *
     * @param chaveAcesso Chave de acesso da NF-e relacionada ao evento.
     * @param gruposItensnaoInformados  Lista de grupos do Consumo de combustivel.
     * @param numeroSequencialEvento Número sequencial do evento.
     * @return A própria instância de {@link WSNaoFornecimentoPagamentoAntecipado} para permitir encadeamento de chamadas.
     */
    WSNaoFornecimentoPagamentoAntecipado adicionarDadosEvento(
            final String chaveAcesso, final DFUnidadeFederativa ufAutorEvento, final List<NFDetGrupoItemNaoFornecido> gruposItensnaoInformados, final int numeroSequencialEvento
    ) {
        super.chaveAcesso = chaveAcesso;
        this.gruposItensNaoInformados = gruposItensnaoInformados;
        super.numeroSequencialEvento = numeroSequencialEvento;
        super.ufAutorEvento = ufAutorEvento;
        return this;
    }

    /**
     * Gera os dados XML específicos do evento de Fornecimento não realizado com pagamento antecipado
     * @return {@link NFEnviaEvento} com os dados do evento preenchidos
     */
    @Override
    protected NFEnviaEvento gerarDadosXml() {
        final NFDetEventoNaoFornecimentoPagamentoAntecipado detEvento = new NFDetEventoNaoFornecimentoPagamentoAntecipado();
        detEvento.setDescricaoEvento(WSNaoFornecimentoPagamentoAntecipado.DESCRICAO_EVENTO);
        detEvento.setVersao(WSNaoFornecimentoPagamentoAntecipado.VERSAO_LAYOUT);
        detEvento.setTipoAutor(NFEventoTipoAutor.EMPRESA_EMITENTE);
        detEvento.setUfAutorEvento(super.ufAutorEvento);
        detEvento.setVersaoAplicativo(WSNaoFornecimentoPagamentoAntecipado.VERSAO_LAYOUT.toString());
        detEvento.setGruposItemNaoInformado(this.gruposItensNaoInformados);

        return super.gerarDadosPaiXml(detEvento);
    }
}
