package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.apropriacaobens.NFDetEventoSolicApropriCreditoBensAtdAdquirinte;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.apropriacaocredito.NFDetEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.apropriacaobens.NFDetGrupoCredito;

import java.math.BigDecimal;
import java.util.List;

/**
 * Classe responsável por informar a solicitação de apropriação de crédito presumido para bens e serviços que dependem
 * de atividade do adquirente
 * Classe utiliza de herança de {@link AbstractWSEvento} para reaproveitar código comum a todos os eventos.
 * A classe {@link NFDetEventoSolicitacaoApropriacaoCreditoPresumido} é utilizada para representar os dados específicos do evento (detEvento).
 *
 * @author Marcos Della Justina Schulz
 */
class WSSolicitacaoApropriacaoCreditoBensAtdAdquirinte extends AbstractWSEvento implements DFLog {
    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Solicita\u00E7\u00E3o de Apropria\u00E7\u00E3o de Cr\u00E9dito para bens e servi\u00E7os que dependem de atividade do adquirente";
    private static final String CODIGO_EVENTO = "211150";

    private List<NFDetGrupoCredito> gruposCredito;

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
     * Construtor da classe {@link WSSolicitacaoApropriacaoCreditoBensAtdAdquirinte}.
     *
     * @param config Configuração da NF-e utilizada para a comunicação com o web service.
     */
    WSSolicitacaoApropriacaoCreditoBensAtdAdquirinte(NFeConfig config) {
        super(config);
    }

    /**
     * Adiciona os dados necessários para a geração do XML do evento de solicitação de apropriação de crédito presumido.
     *
     * @param chaveAcesso            Chave de acesso da NF-e relacionada ao evento.
     * @param ufEmitenteEvento
     * @param gruposCredito Lista de grupos do crédito.
     * @param numeroSequencialEvento Número sequencial do evento.
     * @return A própria instância de {@link WSSolicitacaoApropriacaoCreditoBensAtdAdquirinte} para permitir encadeamento de chamadas.
     */
    WSSolicitacaoApropriacaoCreditoBensAtdAdquirinte adicionarDadosEvento(
            final String chaveAcesso, DFUnidadeFederativa ufEmitenteEvento, final List<NFDetGrupoCredito> gruposCredito, final int numeroSequencialEvento
    ) {
        super.chaveAcesso = chaveAcesso;
        this.gruposCredito = gruposCredito;
        super.numeroSequencialEvento = numeroSequencialEvento;
        super.ufAutorEvento = ufEmitenteEvento;
        return this;
    }

    /**
     * Gera os dados XML específicos do evento de solicitação de apropriação de crédito presumido para bens e serviços que dependem
     * @return {@link NFEnviaEvento} com os dados do evento preenchidos
     */
    @Override
    protected NFEnviaEvento gerarDadosXml() {
        final NFDetEventoSolicApropriCreditoBensAtdAdquirinte detEvento = new NFDetEventoSolicApropriCreditoBensAtdAdquirinte();
        detEvento.setDescricaoEvento(WSSolicitacaoApropriacaoCreditoBensAtdAdquirinte.DESCRICAO_EVENTO);
        detEvento.setVersao(WSSolicitacaoApropriacaoCreditoBensAtdAdquirinte.VERSAO_LAYOUT);
        detEvento.setTipoAutor(NFEventoTipoAutor.EMPRESA_DESTINADA);
        detEvento.setVersaoAplicativo(WSSolicitacaoApropriacaoCreditoBensAtdAdquirinte.VERSAO_LAYOUT.toString());
        detEvento.setUfAutorEvento(super.ufAutorEvento);
        detEvento.setGruposCredito(this.gruposCredito);

        return super.gerarDadosPaiXml(detEvento);
    }
}
