package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;

import java.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

public class NFNotaInfoAvulsa extends DFBase {
    private static final long serialVersionUID = 724335920156427201L;

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
    private String uf;

    @Element(name = "nDAR", required = false)
    private String numeroDocumentoArrecadacaoReceita;

    @Element(name = "dEmi", required = false)
    private LocalDate dataEmissaoDocumentoArrecadacao;

    @Element(name = "vDAR", required = false)
    private String valorTotalConstanteDocumentoArrecadacaoReceita;

    @Element(name = "repEmi", required = true)
    private String reparticaoFiscalEmitente;

    @Element(name = "dPag", required = false)
    private LocalDate dataPagamentoDocumentoArrecadacao;

    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setOrgaoEmitente(final String orgaoEmitente) {
        StringValidador.tamanho60(orgaoEmitente, "Orgao Emitente");
        this.orgaoEmitente = orgaoEmitente;
    }

    public void setMatriculaAgente(final String matriculaAgente) {
        StringValidador.tamanho60(matriculaAgente, "Matricula Agente");
        this.matriculaAgente = matriculaAgente;
    }

    public void setNomeAgente(final String nomeAgente) {
        StringValidador.tamanho60(nomeAgente, "Nome Agente");
        this.nomeAgente = nomeAgente;
    }

    public void setFone(final String fone) {
        StringValidador.telefone(fone);
        this.fone = fone;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf.getCodigo();
    }

    public void setNumeroDocumentoArrecadacaoReceita(final String numeroDocumentoArrecadacaoReceita) {
        StringValidador.tamanho60(numeroDocumentoArrecadacaoReceita, "Numero Documento Arrecadacao Receita");
        this.numeroDocumentoArrecadacaoReceita = numeroDocumentoArrecadacaoReceita;
    }

    public void setDataEmissaoDocumentoArrecadacao(final LocalDate dataEmissaoDocumentoArrecadacao) {
        this.dataEmissaoDocumentoArrecadacao = dataEmissaoDocumentoArrecadacao;
    }

    public void setValorTotalConstanteDocumentoArrecadacaoReceita(final BigDecimal valorTotalConstanteDocumentoArrecadacaoReceita) {
        this.valorTotalConstanteDocumentoArrecadacaoReceita = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalConstanteDocumentoArrecadacaoReceita, "Valor Total Constante Documento Arrecadacao Receita");
    }

    public void setReparticaoFiscalEmitente(final String reparticaoFiscalEmitente) {
        StringValidador.tamanho60(reparticaoFiscalEmitente, "Reparticao Fiscal Emitente");
        this.reparticaoFiscalEmitente = reparticaoFiscalEmitente;
    }

    public void setDataPagamentoDocumentoArrecadacao(final LocalDate dataPagamentoDocumentoArrecadacao) {
        this.dataPagamentoDocumentoArrecadacao = dataPagamentoDocumentoArrecadacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getOrgaoEmitente() {
        return this.orgaoEmitente;
    }

    public String getMatriculaAgente() {
        return this.matriculaAgente;
    }

    public String getNomeAgente() {
        return this.nomeAgente;
    }

    public String getFone() {
        return this.fone;
    }

    public String getUf() {
        return this.uf;
    }

    public String getNumeroDocumentoArrecadacaoReceita() {
        return this.numeroDocumentoArrecadacaoReceita;
    }

    public LocalDate getDataEmissaoDocumentoArrecadacao() {
        return this.dataEmissaoDocumentoArrecadacao;
    }

    public String getValorTotalConstanteDocumentoArrecadacaoReceita() {
        return this.valorTotalConstanteDocumentoArrecadacaoReceita;
    }

    public String getReparticaoFiscalEmitente() {
        return this.reparticaoFiscalEmitente;
    }

    public LocalDate getDataPagamentoDocumentoArrecadacao() {
        return this.dataPagamentoDocumentoArrecadacao;
    }
}