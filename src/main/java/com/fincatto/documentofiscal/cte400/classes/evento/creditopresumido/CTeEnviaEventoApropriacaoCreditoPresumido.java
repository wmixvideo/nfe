package com.fincatto.documentofiscal.cte400.classes.evento.creditopresumido;

import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeTipoEvento;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Evento de Apropriação de Crédito Presumido (tpEvento 211110), NT 2026.004.<br>
 * Gerado pelo tomador do serviço de CT-e (modelo 57) emitido por TAC (tpEmis=3 ou procEmi=4) ou por MEI (CRT=4).
 */
@Root(name = "evApropriaCredPres")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeEnviaEventoApropriacaoCreditoPresumido extends CTeTipoEvento {
    private static final long serialVersionUID = -2149853614111525861L;

    /**
     * Declaração de pagamento ao TAC/MEI (xDecPag), texto sem acentuação aceito pelo XSD.
     */
    public static final String DECLARACAO_PAGAMENTO = "Declaro, para fins de apropriacao do credito presumido solicitado, relativo a operacao registrada no documento fiscal eletronico a que se refere este evento: I – ja ter efetuado o pagamento integral do valor da prestacao do servico ao transportador, nos termos do art. 126, paragrafo 5o, II, da Lei Complementar no 214, de 16 de janeiro de 2025; II – estar ciente de que a prestacao de declaracao falsa sujeita-me as penalidades administrativas e sancoes penais previstas na legislacao, sem prejuizo do estorno do credito indevidamente apropriado com os acrescimos legais.";

    @Element(name = "vBCCredPres")
    private String valorBaseCalculoCreditoPresumido;

    @Element(name = "cCredPres")
    private String codigoCreditoPresumido;

    @Element(name = "gIBSCredPres", required = false)
    private CTeInformacaoCreditoPresumido creditoPresumidoIBS;

    @Element(name = "gCBSCredPres", required = false)
    private CTeInformacaoCreditoPresumido creditoPresumidoCBS;

    @Element(name = "xDecPag")
    private String declaracaoPagamento;

    public String getValorBaseCalculoCreditoPresumido() {
        return this.valorBaseCalculoCreditoPresumido;
    }

    /**
     * Valor total da base de cálculo da operação do crédito presumido
     */
    public void setValorBaseCalculoCreditoPresumido(final BigDecimal valorBaseCalculoCreditoPresumido) {
        this.valorBaseCalculoCreditoPresumido = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBaseCalculoCreditoPresumido, "Valor da Base de Calculo do Credito Presumido");
    }

    public String getCodigoCreditoPresumido() {
        return this.codigoCreditoPresumido;
    }

    /**
     * Código de classificação do crédito presumido, conforme a tabela cCredPres (2 dígitos)
     */
    public void setCodigoCreditoPresumido(final String codigoCreditoPresumido) {
        DFStringValidador.exatamente2N(codigoCreditoPresumido, "Codigo de Classificacao do Credito Presumido");
        this.codigoCreditoPresumido = codigoCreditoPresumido;
    }

    public CTeInformacaoCreditoPresumido getCreditoPresumidoIBS() {
        return this.creditoPresumidoIBS;
    }

    /**
     * Crédito presumido do IBS. Informar ou não conforme o indicador do cCredPres.
     */
    public void setCreditoPresumidoIBS(final CTeInformacaoCreditoPresumido creditoPresumidoIBS) {
        this.creditoPresumidoIBS = creditoPresumidoIBS;
    }

    public CTeInformacaoCreditoPresumido getCreditoPresumidoCBS() {
        return this.creditoPresumidoCBS;
    }

    /**
     * Crédito presumido da CBS. Informar ou não conforme o indicador do cCredPres.
     */
    public void setCreditoPresumidoCBS(final CTeInformacaoCreditoPresumido creditoPresumidoCBS) {
        this.creditoPresumidoCBS = creditoPresumidoCBS;
    }

    public String getDeclaracaoPagamento() {
        return this.declaracaoPagamento;
    }

    /**
     * Declaração de pagamento ao TAC/MEI. O XSD aceita apenas os dois literais da NT 2026.004
     * (com ou sem acentuação); use {@link #DECLARACAO_PAGAMENTO}.
     */
    public void setDeclaracaoPagamento(final String declaracaoPagamento) {
        this.declaracaoPagamento = declaracaoPagamento;
    }
}
