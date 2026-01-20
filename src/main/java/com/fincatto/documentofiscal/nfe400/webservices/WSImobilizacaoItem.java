package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito.NFDetEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.imobilizacao.NFDetEventoImobilizacaoItem;
import com.fincatto.documentofiscal.nfe400.classes.evento.imobilizacao.NFDetGrupoImobilizacao;
import com.fincatto.documentofiscal.nfe400.classes.evento.imobilizacao.NFEnviaEventoImobilizacaoItem;
import com.fincatto.documentofiscal.nfe400.classes.evento.imobilizacao.NFEventoImobilizacaoItem;
import com.fincatto.documentofiscal.nfe400.classes.evento.imobilizacao.NFInfoEventoImobilizacaoItem;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;


/**
 * Classe responsável por informar a imobilização de itens
 * Classe utiliza de herança de {@link AbstractWSEvento} para reaproveitar código comum a todos os eventos.
 * A classe {@link NFDetEventoSolicitacaoApropriacaoCreditoPresumido} é utilizada para representar os dados específicos do evento (detEvento).
 *
 * @author Marcos Della Justina Schulz
 */
class WSImobilizacaoItem extends AbstractWSEvento implements DFLog {
    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Imobiliza\u00E7\u00E3o de Item";
    private static final String CODIGO_EVENTO = "211130";

    private List<NFDetGrupoImobilizacao> gruposImobilizacao;
    private String cpfAutorEvento;
    private String cnpjAutorEvento;

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
    WSImobilizacaoItem(NFeConfig config) {
        super(config);
    }

    /**
     * Adiciona os dados necessários para a geração do XML do evento de imobilização de item.
     *
     * @param chaveAcesso            Chave de acesso da NF-e relacionada ao evento.
     * @param gruposImobilizacao Lista de grupos do crédito presumido.
     * @param numeroSequencialEvento Número sequencial do evento.
     * @param cnpjCpfAutorEvento CNPJ ou CPF do autor do evento sem formatação.
     * @return A própria instância de {@link WSImobilizacaoItem} para permitir encadeamento de chamadas.
     */
    WSImobilizacaoItem adicionarDadosEvento(
            final String chaveAcesso, DFUnidadeFederativa ufEmitenteEvento, final List<NFDetGrupoImobilizacao> gruposImobilizacao,
            final int numeroSequencialEvento, final String cnpjCpfAutorEvento
    ) {
        super.chaveAcesso = chaveAcesso;
        this.gruposImobilizacao = gruposImobilizacao;
        super.numeroSequencialEvento = numeroSequencialEvento;
        super.ufAutorEvento = ufEmitenteEvento;
        this.cpfAutorEvento = cnpjCpfAutorEvento.length() == 11 ? cnpjCpfAutorEvento : null;
        this.cnpjAutorEvento = cnpjCpfAutorEvento.length() > 11 ? cnpjCpfAutorEvento : null;
        return this;
    }

    /**
     * Gera os dados XML específicos do evento de solicitação de apropriação de crédito presumido.
     * @return {@link NFEnviaEventoImobilizacaoItem} com os dados do evento preenchidos
     */
    private NFEnviaEventoImobilizacaoItem gerarDadosXml() {
        final NFDetEventoImobilizacaoItem detEvento = new NFDetEventoImobilizacaoItem();
        detEvento.setDescricaoEvento(WSImobilizacaoItem.DESCRICAO_EVENTO);
        detEvento.setVersao(WSImobilizacaoItem.VERSAO_LAYOUT);
        detEvento.setTipoAutor(NFEventoTipoAutor.EMPRESA_DESTINADA);
        detEvento.setVersaoAplicativo(WSImobilizacaoItem.VERSAO_LAYOUT.toString());
        detEvento.setUfAutorEvento(super.ufAutorEvento);
        detEvento.setGruposImobilizacao(this.gruposImobilizacao);

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
     * {@link NFEnviaEventoImobilizacaoItem}
     * {@link NFEventoImobilizacaoItem}
     * {@link NFInfoEventoImobilizacaoItem}
     *
     * @param detEvento Detalhes específicos do evento.
     * @return Objeto NFEnviaEvento com os dados padrão preenchidos.
     */
    private NFEnviaEventoImobilizacaoItem gerarDadosPaiXml(NFDetEventoImobilizacaoItem detEvento) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(this.chaveAcesso);
        final NFInfoEventoImobilizacaoItem infoEvento = new NFInfoEventoImobilizacaoItem();
        infoEvento.setAmbiente(this.config.getAmbiente());
        infoEvento.setChave(this.chaveAcesso);
        infoEvento.setCpf(this.cpfAutorEvento);
        infoEvento.setCnpj(this.cnpjAutorEvento);
        infoEvento.setDataHoraEvento(ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
        infoEvento.setId(ChaveAcessoUtils.geraIDevento(this.chaveAcesso, this.getCodigoEvento(), numeroSequencialEvento));
        infoEvento.setNumeroSequencialEvento(numeroSequencialEvento);
        infoEvento.setOrgao(chaveParser.getNFUnidadeFederativa());
        infoEvento.setCodigoEvento(this.getCodigoEvento());
        infoEvento.setVersaoEvento(this.getVersaoLayout());
        infoEvento.setDetalhesEvento(detEvento);

        final NFEventoImobilizacaoItem evento = new NFEventoImobilizacaoItem();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(this.getVersaoLayout());

        final NFEnviaEventoImobilizacaoItem enviaEvento = new NFEnviaEventoImobilizacaoItem();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(this.getVersaoLayout());
        return enviaEvento;
    }
}
