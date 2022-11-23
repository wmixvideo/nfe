package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class NFNotaInfoItemProdutoDeclaracaoImportacao extends DFBase {
    private static final long serialVersionUID = 4173954108879768633L;
    
    @Element(name = "nDI")
    private String numeroRegistro;
    
    @Element(name = "dDI")
    private LocalDate dataRegistro;
    
    @Element(name = "xLocDesemb")
    private String localDesembaraco;
    
    @Element(name = "UFDesemb")
    private String ufDesembaraco;
    
    @Element(name = "dDesemb")
    private LocalDate dataDesembaraco;
    
    @Element(name = "tpViaTransp")
    private NFViaTransporteInternacional transporteInternacional;

    @Element(name = "vAFRMM", required = false)
    private String valorAFRMM;
    
    @Element(name = "tpIntermedio")
    private NFFormaImportacaoIntermediacao formaImportacaoIntermediacao;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "UFTerceiro", required = false)
    private String ufTerceiro;
    
    @Element(name = "cExportador")
    private String codigoExportador;
    
    @ElementList(entry = "adi", inline = true)
    private List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> adicoes;

    public void setNumeroRegistro(final String numeroRegistro) {
        DFStringValidador.tamanho12(numeroRegistro, "Numero Registro Declaracao Importacao");
        this.numeroRegistro = numeroRegistro;
    }

    public void setDataRegistro(final LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public void setLocalDesembaraco(final String localDesembaraco) {
        DFStringValidador.tamanho60(localDesembaraco, "Desembaraco Declaracao Importacao");
        this.localDesembaraco = localDesembaraco;
    }

    public void setUfDesembaraco(final DFUnidadeFederativa ufDesembaraco) {
        this.ufDesembaraco = ufDesembaraco.getCodigo();
    }

    public void setDataDesembaraco(final LocalDate dataDesembaraco) {
        this.dataDesembaraco = dataDesembaraco;
    }

    public void setCodigoExportador(final String codigoExportador) {
        DFStringValidador.tamanho60(codigoExportador, "Codigo Exportador Declaracao Importacao");
        this.codigoExportador = codigoExportador;
    }

    public void setAdicoes(final List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> adicoes) {
        this.adicoes = adicoes;
    }

    public void setTransporteInternacional(final NFViaTransporteInternacional transporteInternacional) {
        this.transporteInternacional = transporteInternacional;
    }

    public void setValorAFRMM(final BigDecimal valorAFRMM) {
        this.valorAFRMM = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorAFRMM, "Valor AFRMM Declaracao Importacao");
    }

    public void setFormaImportacaoIntermediacao(final NFFormaImportacaoIntermediacao formaImportacaoIntermediacao) {
        this.formaImportacaoIntermediacao = formaImportacaoIntermediacao;
    }

    public void setCnpj(final String cnpj) {
        DFStringValidador.cnpj(cnpj);
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