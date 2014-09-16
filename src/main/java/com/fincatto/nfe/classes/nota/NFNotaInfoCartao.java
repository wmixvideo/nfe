package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoCartao extends NFBase {

    @Element(name = "CNPJ", required = true)
    private String cnpj;

    @Element(name = "tBand", required = true)
    private NFOperadoraCartao operadoraCartao;

    @Element(name = "cAut", required = true)
    private String numeroAutorizacaoOperacaoCartao;

    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setNumeroAutorizacaoOperacaoCartao(final String numeroAutorizacaoOperacaoCartao) {
        StringValidador.tamanho20(numeroAutorizacaoOperacaoCartao);
        this.numeroAutorizacaoOperacaoCartao = numeroAutorizacaoOperacaoCartao;
    }

    public void setOperadoraCartao(final NFOperadoraCartao operadoraCartao) {
        this.operadoraCartao = operadoraCartao;
    }
}