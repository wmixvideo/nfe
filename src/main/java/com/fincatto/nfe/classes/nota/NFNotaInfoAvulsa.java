package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;
import com.fincatto.nfe.validadores.StringValidador;

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
        StringValidador.tamanho60(orgaoEmitente);
        this.orgaoEmitente = orgaoEmitente;
    }

    public void setMatriculaAgente(final String matriculaAgente) {
        StringValidador.tamanho60(matriculaAgente);
        this.matriculaAgente = matriculaAgente;
    }

    public void setNomeAgente(final String nomeAgente) {
        StringValidador.tamanho60(nomeAgente);
        this.nomeAgente = nomeAgente;
    }

    public void setFone(final String fone) {
        StringValidador.telefone(fone);
        this.fone = fone;
    }

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public void setNumeroDocumentoArrecadacaoReceita(final String numeroDocumentoArrecadacaoReceita) {
        StringValidador.tamanho60(numeroDocumentoArrecadacaoReceita);
        this.numeroDocumentoArrecadacaoReceita = numeroDocumentoArrecadacaoReceita;
    }

    public void setDataEmissaoDocumentoArrecadacao(final LocalDate dataEmissaoDocumentoArrecadacao) {
        this.dataEmissaoDocumentoArrecadacao = dataEmissaoDocumentoArrecadacao;
    }

    public void setValorTotalConstanteDocumentoArrecadacaoReceita(final BigDecimal valorTotalConstanteDocumentoArrecadacaoReceita) {
        this.valorTotalConstanteDocumentoArrecadacaoReceita = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalConstanteDocumentoArrecadacaoReceita);
    }

    public void setReparticaoFiscalEmitente(final String reparticaoFiscalEmitente) {
        StringValidador.tamanho60(reparticaoFiscalEmitente);
        this.reparticaoFiscalEmitente = reparticaoFiscalEmitente;
    }

    public void setDataPagamentoDocumentoArrecadacao(final LocalDate dataPagamentoDocumentoArrecadacao) {
        this.dataPagamentoDocumentoArrecadacao = dataPagamentoDocumentoArrecadacao;
    }
}