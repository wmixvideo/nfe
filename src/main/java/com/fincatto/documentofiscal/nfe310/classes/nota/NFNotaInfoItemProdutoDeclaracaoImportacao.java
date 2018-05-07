package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;
import java.util.List;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

public class NFNotaInfoItemProdutoDeclaracaoImportacao extends DFBase {
    private static final long serialVersionUID = 4173954108879768633L;

    @Element(name = "nDI", required = true)
    private String numeroRegistro;

    @Element(name = "dDI", required = true)
    private LocalDate dataRegistro;

    @Element(name = "xLocDesemb", required = true)
    private String localDesembaraco;

    @Element(name = "UFDesemb", required = true)
    private String ufDesembaraco;

    @Element(name = "dDesemb", required = true)
    private LocalDate dataDesembaraco;

    @Element(name = "tpViaTransp", required = true)
    private NFViaTransporteInternacional transporteInternacional;

    @Element(name = "vAFRMM", required = false)
    private String valorAFRMM;

    @Element(name = "tpIntermedio", required = true)
    private NFFormaImportacaoIntermediacao formaImportacaoIntermediacao;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "UFTerceiro", required = false)
    private String ufTerceiro;

    @Element(name = "cExportador", required = true)
    private String codigoExportador;

    @ElementList(entry = "adi", inline = true, required = true)
    private List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> adicoes;

    public void setNumeroRegistro(final String numeroRegistro) {
        StringValidador.tamanho12(numeroRegistro, "Numero Registro Declaracao Importacao");
        this.numeroRegistro = numeroRegistro;
    }

    public void setDataRegistro(final LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public void setLocalDesembaraco(final String localDesembaraco) {
        StringValidador.tamanho60(localDesembaraco, "Desembaraco Declaracao Importacao");
        this.localDesembaraco = localDesembaraco;
    }

    public void setUfDesembaraco(final DFUnidadeFederativa ufDesembaraco) {
        this.ufDesembaraco = ufDesembaraco.getCodigo();
    }

    public void setDataDesembaraco(final LocalDate dataDesembaraco) {
        this.dataDesembaraco = dataDesembaraco;
    }

    public void setCodigoExportador(final String codigoExportador) {
        StringValidador.tamanho60(codigoExportador, "Codigo Exportador Declaracao Importacao");
        this.codigoExportador = codigoExportador;
    }

    public void setAdicoes(final List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> adicoes) {
        this.adicoes = adicoes;
    }

    public void setTransporteInternacional(final NFViaTransporteInternacional transporteInternacional) {
        this.transporteInternacional = transporteInternacional;
    }

    public void setValorAFRMM(final BigDecimal valorAFRMM) {
        this.valorAFRMM = BigDecimalParser.tamanho15Com2CasasDecimais(valorAFRMM, "Valor AFRMM Declaracao Importacao");
    }

    public void setFormaImportacaoIntermediacao(final NFFormaImportacaoIntermediacao formaImportacaoIntermediacao) {
        this.formaImportacaoIntermediacao = formaImportacaoIntermediacao;
    }

    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setUfTerceiro(final DFUnidadeFederativa ufTerceiro) {
        this.ufTerceiro = ufTerceiro.getCodigo();
    }

    public String getNumeroRegistro() {
        return this.numeroRegistro;
    }

    public LocalDate getDataRegistro() {
        return this.dataRegistro;
    }

    public String getLocalDesembaraco() {
        return this.localDesembaraco;
    }

    public String getUfDesembaraco() {
        return this.ufDesembaraco;
    }

    public LocalDate getDataDesembaraco() {
        return this.dataDesembaraco;
    }

    public NFViaTransporteInternacional getTransporteInternacional() {
        return this.transporteInternacional;
    }

    public String getValorAFRMM() {
        return this.valorAFRMM;
    }

    public NFFormaImportacaoIntermediacao getFormaImportacaoIntermediacao() {
        return this.formaImportacaoIntermediacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getUfTerceiro() {
        return this.ufTerceiro;
    }

    public String getCodigoExportador() {
        return this.codigoExportador;
    }

    public List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> getAdicoes() {
        return this.adicoes;
    }
}