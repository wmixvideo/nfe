package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.alczfmimportacao.NFDetEventoImportacaoALCZFMNaoConvertidaIsencao;
import com.fincatto.documentofiscal.nfe400.classes.evento.alczfmimportacao.NFDetGrupoConsumoZFM;
import com.fincatto.documentofiscal.nfe400.classes.evento.alczfmimportacao.NFEnviaEventoImportacaoALCZFMNaoConvertidaIsencao;
import com.fincatto.documentofiscal.nfe400.classes.evento.alczfmimportacao.NFEventoImportacaoALCZFMNaoConvertidaIsencao;
import com.fincatto.documentofiscal.nfe400.classes.evento.alczfmimportacao.NFInfoEventoImportacaoALCZFMNaoConvertidaIsencao;
import com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito.NFDetEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.utils.ChaveAcessoUtils;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;


/**
 * Classe responsável por informar a importação de ALC/ZFM não convertida em isenção
 * Classe utiliza de herança de {@link AbstractWSEvento} para reaproveitar código comum a todos os eventos.
 * A classe {@link NFDetEventoSolicitacaoApropriacaoCreditoPresumido} é utilizada para representar os dados específicos do evento (detEvento).
 *
 * @author Marcos Della Justina Schulz
 */
class WSImportacaoALCZFMNaoConvertidaIsencao extends AbstractWSEvento implements DFLog {
    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Importa\u00E7\u00E3o em ALC/ZFM n\u00E3o convertida em isen\u00E7\u00E3o";
    private static final String CODIGO_EVENTO = "211130";

    private List<NFDetGrupoConsumoZFM> gruposImobilizacao;

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
    WSImportacaoALCZFMNaoConvertidaIsencao(NFeConfig config) {
        super(config);
    }

    /**
     * Adiciona os dados necessários para a geração do XML do evento de importação de ALC/ZFM não convertida em isenção.
     *
     * @param chaveAcesso            Chave de acesso da NF-e relacionada ao evento.
     * @param gruposConsumo Lista de grupos do crédito presumido.
     * @param numeroSequencialEvento Número sequencial do evento.
     * @return A própria instância de {@link WSImportacaoALCZFMNaoConvertidaIsencao} para permitir encadeamento de chamadas.
     */
    WSImportacaoALCZFMNaoConvertidaIsencao adicionarDadosEvento(
            final String chaveAcesso, DFUnidadeFederativa ufEmitenteEvento, final List<NFDetGrupoConsumoZFM> gruposConsumo,
            final int numeroSequencialEvento
    ) {
        super.chaveAcesso = chaveAcesso;
        this.gruposImobilizacao = gruposConsumo;
        super.numeroSequencialEvento = numeroSequencialEvento;
        super.ufAutorEvento = ufEmitenteEvento;
        return this;
    }

    /**
     * Gera os dados XML específicos do evento de solicitação de apropriação de crédito presumido.
     * @return {@link NFEnviaEventoImportacaoALCZFMNaoConvertidaIsencao} com os dados do evento preenchidos
     */
    private NFEnviaEventoImportacaoALCZFMNaoConvertidaIsencao gerarDadosXml() {
        final NFDetEventoImportacaoALCZFMNaoConvertidaIsencao detEvento = new NFDetEventoImportacaoALCZFMNaoConvertidaIsencao();
        detEvento.setDescricaoEvento(WSImportacaoALCZFMNaoConvertidaIsencao.DESCRICAO_EVENTO);
        detEvento.setVersao(WSImportacaoALCZFMNaoConvertidaIsencao.VERSAO_LAYOUT);
        detEvento.setTipoAutor(NFEventoTipoAutor.EMPRESA_EMITENTE);
        detEvento.setVersaoAplicativo(WSImportacaoALCZFMNaoConvertidaIsencao.VERSAO_LAYOUT.toString());
        detEvento.setUfAutorEvento(super.ufAutorEvento);
        detEvento.setGruposConsumo(this.gruposImobilizacao);

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
     * {@link NFInfoEventoImportacaoALCZFMNaoConvertidaIsencao}
     * {@link NFEventoImportacaoALCZFMNaoConvertidaIsencao}
     * {@link NFEnviaEventoImportacaoALCZFMNaoConvertidaIsencao}
     *
     * @param detEvento Detalhes específicos do evento.
     * @return Objeto {@link NFInfoEventoImportacaoALCZFMNaoConvertidaIsencao} com os dados padrão preenchidos.
     */
    private NFEnviaEventoImportacaoALCZFMNaoConvertidaIsencao gerarDadosPaiXml(NFDetEventoImportacaoALCZFMNaoConvertidaIsencao detEvento) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(this.chaveAcesso);
        final NFInfoEventoImportacaoALCZFMNaoConvertidaIsencao infoEvento = new NFInfoEventoImportacaoALCZFMNaoConvertidaIsencao();
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

        final NFEventoImportacaoALCZFMNaoConvertidaIsencao evento = new NFEventoImportacaoALCZFMNaoConvertidaIsencao();
        evento.setInfoEvento(infoEvento);
        evento.setVersao(this.getVersaoLayout());

        final NFEnviaEventoImportacaoALCZFMNaoConvertidaIsencao enviaEvento = new NFEnviaEventoImportacaoALCZFMNaoConvertidaIsencao();
        enviaEvento.setEvento(Collections.singletonList(evento));
        enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
        enviaEvento.setVersao(this.getVersaoLayout());
        return enviaEvento;
    }
}
