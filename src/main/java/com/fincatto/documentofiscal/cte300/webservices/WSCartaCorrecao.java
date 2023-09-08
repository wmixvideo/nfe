package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte300.classes.evento.cartacorrecao.CTeEnviaEventoCartaCorrecao;
import com.fincatto.documentofiscal.cte300.classes.evento.cartacorrecao.CTeInformacaoCartaCorrecao;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class WSCartaCorrecao extends WSRecepcaoEvento {
    private static final String DESCRICAO_EVENTO = "Carta de Correcao";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_CARTA_DE_CORRECAO = "110110";
    private static final List<DFModelo> modelosPermitidos = Arrays.asList(DFModelo.CTE, DFModelo.CTeOS);

    WSCartaCorrecao(final CTeConfig config) {
        super(config, modelosPermitidos);
    }

    CTeEventoRetorno corrigeNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = super.efetuaEvento(eventoAssinadoXml, chaveAcesso, WSCartaCorrecao.VERSAO_LEIAUTE);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno corrigeNota(final String chaveAcesso, String grupoAlterado, String campoAlterado, String valorAlterado, Integer numeroItemAlterado, int sequencialEvento) throws Exception {
        final CTeInformacaoCartaCorrecao correcao = new CTeInformacaoCartaCorrecao();
        correcao.setGrupoAlterado(grupoAlterado);
        correcao.setCampoAlterado(campoAlterado);
        correcao.setValorAlterado(valorAlterado);
        correcao.setNumeroItemAlterado(numeroItemAlterado);

        return corrigeNota(chaveAcesso, Arrays.asList(correcao), sequencialEvento);
    }

    CTeEventoRetorno corrigeNota(final String chaveAcesso, List<CTeInformacaoCartaCorrecao> correcoes, int sequencialEvento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, correcoes, sequencialEvento);
        return corrigeNotaAssinada(chaveAcesso, xmlAssinado);
    }

    String getXmlAssinado(final String chave, List<CTeInformacaoCartaCorrecao> correcoes, int sequencialEvento) throws Exception {
        final String xml = this.gerarDadosCartaCorrecao(chave, correcoes, sequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private CTeEvento gerarDadosCartaCorrecao(final String chaveAcesso, List<CTeInformacaoCartaCorrecao> correcoes, int sequencialEvento) throws Exception {
        final CTeEnviaEventoCartaCorrecao cartaCorrecao = new CTeEnviaEventoCartaCorrecao();
        cartaCorrecao.setDescricaoEvento(WSCartaCorrecao.DESCRICAO_EVENTO);
        cartaCorrecao.setCorrecoes(correcoes);
        cartaCorrecao.setCondicaoUso("A Carta de Correcao e disciplinada pelo Art. 58-B do CONVENIO/SINIEF 06/89: Fica permitida a utilizacao de carta de correcao, para regularizacao de erro ocorrido na emissao de documentos fiscais relativos a prestacao de servico de transporte, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da prestacao;II - a correcao de dados cadastrais que implique mudanca do emitente, tomador, remetente ou do destinatario;III - a data de emissao ou de saida.");

        DFXMLValidador.validaEventoCartaCorrecaoCTe300(cartaCorrecao.toString());

        return super.gerarEvento(chaveAcesso, WSCartaCorrecao.VERSAO_LEIAUTE, cartaCorrecao, WSCartaCorrecao.EVENTO_CARTA_DE_CORRECAO, null, sequencialEvento);
    }
}
