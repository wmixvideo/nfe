package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoAvulsa extends NFBase {
    @Element(name = "CNPJ", required = true)
    private String cnpj;

    @Element(name = "xOrgao", required = true)
    private String orgaoEmitente;

    @Element(name = "matr", required = true)
    private String matriculaAgente;

    @Element(name = "xAgente", required = true)
    private String nomeAgente;

    @Element(name = "fone", required = false)
    private String fone;

    @Element(name = "UF", required = true)
    private NFUnidadeFederativa uf;

    @Element(name = "nDAR", required = false)
    private String numeroDocumentoArrecadacaoReceita;

    @Element(name = "dEmi", required = false)
    private LocalDate dataEmissaoDocumentoArrecadacao;

    @Element(name = "vDAR", required = false)
    private BigDecimal valorTotalConstanteDocumentoArrecadacaoReceita;

    @Element(name = "repEmi", required = true)
    private String reparticaoFiscalEmitente;

    @Element(name = "dPag", required = false)
    private LocalDate dataPagamentoDocumentoArrecadacao;

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }

    public String getOrgaoEmitente() {
        return this.orgaoEmitente;
    }

    public void setOrgaoEmitente(final String orgaoEmitente) {
        this.orgaoEmitente = orgaoEmitente;
    }

    public String getMatriculaAgente() {
        return this.matriculaAgente;
    }

    public void setMatriculaAgente(final String matriculaAgente) {
        this.matriculaAgente = matriculaAgente;
    }

    public String getNomeAgente() {
        return this.nomeAgente;
    }

    public void setNomeAgente(final String nomeAgente) {
        this.nomeAgente = nomeAgente;
    }

    public String getFone() {
        return this.fone;
    }

    public void setFone(final String fone) {
        this.fone = fone;
    }

    public NFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public String getNumeroDocumentoArrecadacaoReceita() {
        return this.numeroDocumentoArrecadacaoReceita;
    }

    public void setNumeroDocumentoArrecadacaoReceita(final String numeroDocumentoArrecadacaoReceita) {
        this.numeroDocumentoArrecadacaoReceita = numeroDocumentoArrecadacaoReceita;
    }

    public LocalDate getDataEmissaoDocumentoArrecadacao() {
        return this.dataEmissaoDocumentoArrecadacao;
    }

    public void setDataEmissaoDocumentoArrecadacao(final LocalDate dataEmissaoDocumentoArrecadacao) {
        this.dataEmissaoDocumentoArrecadacao = dataEmissaoDocumentoArrecadacao;
    }

    public BigDecimal getValorTotalConstanteDocumentoArrecadacaoReceita() {
        return this.valorTotalConstanteDocumentoArrecadacaoReceita;
    }

    public void setValorTotalConstanteDocumentoArrecadacaoReceita(final BigDecimal valorTotalConstanteDocumentoArrecadacaoReceita) {
        this.valorTotalConstanteDocumentoArrecadacaoReceita = valorTotalConstanteDocumentoArrecadacaoReceita;
    }

    public String getReparticaoFiscalEmitente() {
        return this.reparticaoFiscalEmitente;
    }

    public void setReparticaoFiscalEmitente(final String reparticaoFiscalEmitente) {
        this.reparticaoFiscalEmitente = reparticaoFiscalEmitente;
    }

    public LocalDate getDataPagamentoDocumentoArrecadacao() {
        return this.dataPagamentoDocumentoArrecadacao;
    }

    public void setDataPagamentoDocumentoArrecadacao(final LocalDate dataPagamentoDocumentoArrecadacao) {
        this.dataPagamentoDocumentoArrecadacao = dataPagamentoDocumentoArrecadacao;
    }
}