package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFUnidadeFederativa;
import com.fincatto.nfe.validadores.BigDecimalParser;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoItemProdutoDeclaracaoImportacao extends NFBase {

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
        StringValidador.tamanho12(numeroRegistro);
        this.numeroRegistro = numeroRegistro;
    }

    public void setDataRegistro(final LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public void setLocalDesembaraco(final String localDesembaraco) {
        StringValidador.tamanho60(localDesembaraco);
        this.localDesembaraco = localDesembaraco;
    }

    public void setUfDesembaraco(final NFUnidadeFederativa ufDesembaraco) {
        this.ufDesembaraco = ufDesembaraco.getCodigo();
    }

    public void setDataDesembaraco(final LocalDate dataDesembaraco) {
        this.dataDesembaraco = dataDesembaraco;
    }

    public void setCodigoExportador(final String codigoExportador) {
        StringValidador.tamanho60(codigoExportador);
        this.codigoExportador = codigoExportador;
    }

    public void setAdicoes(final List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> adicoes) {
        this.adicoes = adicoes;
    }

    public void setTransporteInternacional(final NFViaTransporteInternacional transporteInternacional) {
        this.transporteInternacional = transporteInternacional;
    }

    public void setValorAFRMM(final BigDecimal valorAFRMM) {
        this.valorAFRMM = BigDecimalParser.tamanho15Com2CasasDecimais(valorAFRMM);
    }

    public void setFormaImportacaoIntermediacao(final NFFormaImportacaoIntermediacao formaImportacaoIntermediacao) {
        this.formaImportacaoIntermediacao = formaImportacaoIntermediacao;
    }

    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setUfTerceiro(final NFUnidadeFederativa ufTerceiro) {
        this.ufTerceiro = ufTerceiro.getCodigo();
    }
}