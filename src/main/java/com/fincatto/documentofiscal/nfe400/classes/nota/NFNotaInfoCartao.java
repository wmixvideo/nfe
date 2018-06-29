package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

public class NFNotaInfoCartao extends DFBase {
    private static final long serialVersionUID = 8908558834476720280L;

    @Element(name = "tpIntegra", required = true)
    private NFTipoIntegracaoPagamento tipoIntegracao;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "tBand", required = false)
    private NFOperadoraCartao operadoraCartao;

    @Element(name = "cAut", required = false)
    private String numeroAutorizacaoOperacaoCartao;

    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setNumeroAutorizacaoOperacaoCartao(final String numeroAutorizacaoOperacaoCartao) {
        StringValidador.tamanho20(numeroAutorizacaoOperacaoCartao, "Numero Autorizacao Operacao Cartao");
        this.numeroAutorizacaoOperacaoCartao = numeroAutorizacaoOperacaoCartao;
    }

    public void setOperadoraCartao(final NFOperadoraCartao operadoraCartao) {
        this.operadoraCartao = operadoraCartao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getNumeroAutorizacaoOperacaoCartao() {
        return this.numeroAutorizacaoOperacaoCartao;
    }

    public NFOperadoraCartao getOperadoraCartao() {
        return this.operadoraCartao;
    }

    public NFTipoIntegracaoPagamento getTipoIntegracao() {
        return this.tipoIntegracao;
    }

    public void setTipoIntegracao(final NFTipoIntegracaoPagamento tipoIntegracao) {
        this.tipoIntegracao = tipoIntegracao;
    }

}