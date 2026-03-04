package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.naofornecido.NFDetEventoNaoFornecimentoPagamentoAntecipado;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito.NFDetEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.naofornecido.NFDetGrupoItemNaoFornecido;
import com.fincatto.documentofiscal.nfe400.classes.evento.naofornecido.NFEnviaEventoNaoFornecimentoPagamentoAntecipado;
import com.fincatto.documentofiscal.nfe400.classes.evento.naofornecido.NFEventoNaoFornecimentoPagamentoAntecipado;
import com.fincatto.documentofiscal.nfe400.classes.evento.naofornecido.NFInfoEventoNaoFornecimentoPagamentoAntecipado;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
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
     * @return {@link NFEnviaEventoNaoFornecimentoPagamentoAntecipado} com os dados do evento preenchidos
     */
    private NFEnviaEventoNaoFornecimentoPagamentoAntecipado gerarDadosXml() {
        final NFDetEventoNaoFornecimentoPagamentoAntecipado detEvento = new NFDetEventoNaoFornecimentoPagamentoAntecipado();
        detEvento.setDescricaoEvento(WSNaoFornecimentoPagamentoAntecipado.DESCRICAO_EVENTO);
        detEvento.setVersao(WSNaoFornecimentoPagamentoAntecipado.VERSAO_LAYOUT);
        detEvento.setTipoAutor(NFEventoTipoAutor.EMPRESA_EMITENTE);
        detEvento.setUfAutorEvento(super.ufAutorEvento);
        detEvento.setVersaoAplicativo(WSNaoFornecimentoPagamentoAntecipado.VERSAO_LAYOUT.toString());
        detEvento.setGruposItemNaoInformado(this.gruposItensNaoInformados);

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
     * {@link NFEnviaEventoNaoFornecimentoPagamentoAntecipado}
     * {@link NFEventoNaoFornecimentoPagamentoAntecipado}
     * {@link NFInfoEventoNaoFornecimentoPagamentoAntecipado}
     *
     * @param detEvento Detalhes específicos do evento.
     * @return Objeto {@link NFEnviaEventoNaoFornecimentoPagamentoAntecipado} com os dados padrão preenchidos.
     */
    private NFEnviaEventoNaoFornecimentoPagamentoAntecipado gerarDadosPaiXml(NFDetEventoNaoFornecimentoPagamentoAntecipado detEvento) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(this.chaveAcesso);
        final NFInfoEventoNaoFornecimentoPagamentoAntecipado infoEvento = new NFInfoEventoNaoFornecimentoPagamentoAntecipado();
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

        final NFEventoNaoFornecimentoPagamentoAntecipado evento = new NFEventoNaoFornecimentoPagamentoAntecipado();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(this.getVersaoLayout());

        final NFEnviaEventoNaoFornecimentoPagamentoAntecipado enviaEvento = new NFEnviaEventoNaoFornecimentoPagamentoAntecipado();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(this.getVersaoLayout());
        return enviaEvento;
    }
}
