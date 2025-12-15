package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFInfoEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.infoefetivopagamento.NFDetEventoInfoEfetPagIntegral;
import com.fincatto.documentofiscal.nfe400.classes.evento.infoefetivopagamento.NFEnviaEventoInfoEfetPagIntegral;
import com.fincatto.documentofiscal.nfe400.classes.evento.infoefetivopagamento.NFEventoInfoEfetivoPagIntegral;
import com.fincatto.documentofiscal.nfe400.classes.evento.infoefetivopagamento.NFInfoEventoInfoEfetPagIntegral;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

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
     * Orquestra o processo de geração, assinatura e transmissão do evento para a SEFAZ.
     *
     * @return {@link NFEnviaEventoRetorno} contendo a resposta do web service.
     * @throws Exception
     */
    public NFEnviaEventoRetorno gerarEnviarEvento() throws Exception {
        final String atualizacaoDataPrevisaoEntregaXMl = this.gerarDadosXml().toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config)
                .assinarDocumento(atualizacaoDataPrevisaoEntregaXMl);
        final OMElement omElementResult = super.transmiteEvento(xmlAssinado, this.getChaveAcesso());

        return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
    }

    /**
     * Gera os dados XML específicos para o evento de informação de efetivo pagamento integral e chama a criação dos dados comuns
     * @return {@link NFEnviaEvento} com os dados do evento preenchidos
     */
    protected NFEnviaEventoInfoEfetPagIntegral gerarDadosXml() {
        final NFDetEventoInfoEfetPagIntegral detEvento = new NFDetEventoInfoEfetPagIntegral();
        detEvento.setDescricaoEvento(WSInfoEfetPagIntegral.DESCRICAO_EVENTO);
        detEvento.setVersao(WSInfoEfetPagIntegral.VERSAO_LAYOUT);
        detEvento.setUfAutorEvento(ufAutorEvento);
        detEvento.setTipoAutor(NFEventoTipoAutor.EMPRESA_EMITENTE);
        detEvento.setVersaoAplicativo(WSInfoEfetPagIntegral.VERSAO_LAYOUT.toString());
        detEvento.setIndicadorQuitacao(1);

        return gerarDadosPaiXml(detEvento);
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
    private NFEnviaEventoInfoEfetPagIntegral gerarDadosPaiXml(NFDetEventoInfoEfetPagIntegral detEvento) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(this.chaveAcesso);
        final NFInfoEventoInfoEfetPagIntegral infoEvento = new NFInfoEventoInfoEfetPagIntegral();
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

        final NFEventoInfoEfetivoPagIntegral evento = new NFEventoInfoEfetivoPagIntegral();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(this.getVersaoLayout());

        final NFEnviaEventoInfoEfetPagIntegral enviaEvento = new NFEnviaEventoInfoEfetPagIntegral();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(this.getVersaoLayout());
        return enviaEvento;
    }
}
