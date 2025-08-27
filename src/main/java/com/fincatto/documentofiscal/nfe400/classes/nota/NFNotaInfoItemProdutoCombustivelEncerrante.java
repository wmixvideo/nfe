package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * @Author Eldevan Nery Junior on 04/10/17. Informações do grupo de "encerrante"
 */
public class NFNotaInfoItemProdutoCombustivelEncerrante extends DFBase {
    private static final long serialVersionUID = 1807879647248567049L;

    /**
     * Numero de identificação do Bico utilizado no abastecimento.
     */
    @Element(name = "nBico")
    private String numeroBico;

    /**
     * Numero de identificação da bomba ao qual o bico está interligado.
     */
    @Element(name = "nBomba", required = false)
    private String numeroBomba;

    /**
     * Numero de identificação do tanque ao qual o bico está interligado.
     */
    @Element(name = "nTanque")
    private String numeroTanque;

    /**
     * Valor do Encerrante no ínicio do abastecimento
     */
    @Element(name = "vEncIni")
    private String valorEncerramentoInicial;

    /**
     * Valor do Encerrante no final do abastecimento
     */
    @Element(name = "vEncFin")
    private String valorEncerramentoFinal;

    public NFNotaInfoItemProdutoCombustivelEncerrante() {
    }

    public String getNumeroBico() {
        return this.numeroBico;
    }

    public String getNumeroBomba() {
        return this.numeroBomba;
    }

    public String getNumeroTanque() {
        return this.numeroTanque;
    }

    public String getValorEncerramentoInicial() {
        return this.valorEncerramentoInicial;
    }

    public String getValorEncerramentoFinal() {
        return this.valorEncerramentoFinal;
    }

    public void setNumeroBomba(final String numeroBomba) {
        DFStringValidador.tamanho3N(numeroBomba, "Numero de identificação da bomba ");
        this.numeroBomba = numeroBomba;
    }

    public void setNumeroBico(final String numeroBico) {
        DFStringValidador.tamanho3N(numeroBico, "Numero de identificação do Bico ");
        this.numeroBico = numeroBico;
    }

    public void setNumeroTanque(final String numeroTanque) {
        DFStringValidador.tamanho3N(numeroTanque, "Numero de identificação do Tanque ");
        this.numeroTanque = numeroTanque;
    }

    public void setValorEncerramentoInicial(final BigDecimal valorEncerramentoInicial) {
        this.valorEncerramentoInicial = DFBigDecimalValidador.tamanho11Com3CasasDecimais(valorEncerramentoInicial, "Valor do Encerrante no inicio do abastecimento");
    }

    public void setValorEncerramentoFinal(final BigDecimal valorEncerramentoFinal) {
        this.valorEncerramentoFinal = DFBigDecimalValidador.tamanho11Com3CasasDecimais(valorEncerramentoFinal, "Valor do Encerrante no final do abastecimento");
    }
}