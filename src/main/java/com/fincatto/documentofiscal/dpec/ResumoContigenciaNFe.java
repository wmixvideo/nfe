package com.fincatto.documentofiscal.dpec;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Created by Eldevan Nery Junior on 15/01/19.
 *
 * Resumo das NF-e emitidas  no Sistema de Contingência Eletrônica (até 50 NF-e com tpEmiss = "4").
 *
 */
@Root(name = "resNFe")
public class ResumoContigenciaNFe extends DFBase {

    private static final String INFO = "Resumo das NF-e emitidas";

    /**
     * Chave de Acesso da NF-e emitida em contingência eletrônica
     */
    @Element(name = "chNFe")
    private String chaveDeAcesso;

    /**
     *   Identificação do Destinatário:CNPJ do destinatário
     */
    @Element(name = "CNPJ")
    private String cnpj;

    /**
     *  Identificação do Destinatário:CPF do destinatário
     */
    @Element(name = "CPF")
    private String cpf;
    /**
     * Sigla da UF de destinto da mercadoria
     */
    @Element(name = "UF", required = true)
    private DFUnidadeFederativa uf;
    /**
     * Valor Total da NF-e
     */
    @Element(name = "vNF", required = true)
    private String valorTotalNFe;
    /**
     * Valor Total do ICMS da operação própria
     */
    @Element(name = "vICMS", required = true)
    private String valorICMS;
    /**
     * Valor Total do ICMS retido por Subsituição Tributária
     */
    @Element(name = "vST", required = true)
    private String valorTotalICMSST;

    public String getChaveDeAcesso() {
        return chaveDeAcesso;
    }

    public void setChaveDeAcesso(String chaveDeAcesso) {
        StringValidador.exatamente44N(chaveDeAcesso, "Chave de Acesso NFe em " + INFO);
        this.chaveDeAcesso = chaveDeAcesso;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(final String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao deve setar CNPJ se CPF esteja setado em " + ResumoContigenciaNFe.INFO);
        }
        this.cnpj = StringValidador.cnpj(cnpj, ResumoContigenciaNFe.INFO);
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("Nao deve setar CPF se CNPJ esteja setado em " + ResumoContigenciaNFe.INFO);
        }
        this.cpf = StringValidador.cpf(cpf, ResumoContigenciaNFe.INFO);
    }

    public DFUnidadeFederativa getUf() {
        return uf;
    }

    public void setUf(DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public String getValorTotalNFe() {
        return valorTotalNFe;
    }

    public void setValorTotalNFe(final BigDecimal valorTotalNFe) {
        this.valorTotalNFe = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalNFe, "Valor Total NFe");
    }

    public String getValorICMS() {
        return valorICMS;
    }

    /**
     * Valor do ICMS
     */
    public void setValorICMS(final BigDecimal valorICMS) {
        this.valorICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMS, "Valor do ICMS");
    }

    public String getValorTotalICMSST() {
        return valorTotalICMSST;
    }

    public void setValorTotalICMSST(final BigDecimal valorTotalICMSST) {
        this.valorTotalICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalICMSST, "Valor Total ICMS ST");
    }

}
