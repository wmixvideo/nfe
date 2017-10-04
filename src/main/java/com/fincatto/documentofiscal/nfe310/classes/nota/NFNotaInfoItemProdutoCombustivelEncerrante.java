package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * @Author Eldevan Nery Junior on 04/10/17.
 *
 * Informações do grupo de "encerrante"
 */
public class NFNotaInfoItemProdutoCombustivelEncerrante extends DFBase {

    /**
     * Numero de identificação do Bico utilizado no abastecimento.
     */
    @Element(name = "nBico", required = true)
    private String numeroBico;

    /**
     * Numero de identificação da bomba ao qual o bico está interligado.
     */
    @Element(name = "nBomba", required = false)
    private String numeroBomba;

    /**
     * Numero de identificação do tanque ao qual o bico está interligado.
     */
    @Element(name = "nTanque", required = true)
    private String numeroTanque;

    /**
     * Valor do Encerrante no ínicio do abastecimento
     */
    @Element(name = "vEncIni", required = true)
    private String valorEncerramentoInicial;

    /**
     * Valor do Encerrante no final do abastecimento
     */
    @Element(name = "vEncFin", required = true)
    private String valorEncerramentoFinal;

    public NFNotaInfoItemProdutoCombustivelEncerrante() {
    }

    public String getNumeroBico() {
        return numeroBico;
    }

    public String getNumeroBomba() {
        return numeroBomba;
    }

    public String getNumeroTanque() {
        return numeroTanque;
    }

    public String getValorEncerramentoInicial() {
        return valorEncerramentoInicial;
    }

    public String getValorEncerramentoFinal() {
        return valorEncerramentoFinal;
    }

    public void setNumeroBomba(String numeroBomba) {
        StringValidador.tamanho3N(numeroBomba, "Numero de identificação da bomba ");
        this.numeroBomba = numeroBomba;
    }

    public void setNumeroBico(String numeroBico) {
        StringValidador.tamanho3N(numeroBico, "Numero de identificação do Bico ");
        this.numeroBico = numeroBico;
    }

    public void setNumeroTanque(String numeroTanque) {
        StringValidador.tamanho3N(numeroTanque, "Numero de identificação do Tanque ");
        this.numeroTanque = numeroTanque;
    }

    public void setValorEncerramentoInicial(final BigDecimal  valorEncerramentoInicial) {
        this.valorEncerramentoInicial = BigDecimalParser.tamanho11Com3CasasDecimais(valorEncerramentoInicial,
                "Valor do Encerrante no inicio do abastecimento");
    }

    public void setValorEncerramentoFinal(final BigDecimal  valorEncerramentoFinal) {
        this.valorEncerramentoFinal =  BigDecimalParser.tamanho11Com3CasasDecimais(valorEncerramentoFinal,
                "Valor do Encerrante no final do abastecimento");
    }

}