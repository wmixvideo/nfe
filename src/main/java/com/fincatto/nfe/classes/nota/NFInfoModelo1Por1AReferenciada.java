package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.IntegerValidador;
import com.fincatto.nfe.validadores.StringValidador;

public class NFInfoModelo1Por1AReferenciada extends NFBase {
    @Element(name = "cUF", required = true)
    private NFUnidadeFederativa uf;

    @Element(name = "AAMM", required = true)
    private String anoMesEmissaoNFe;

    @Element(name = "CNPJ", required = true)
    private String cnpj;

    @Element(name = "mod", required = true)
    private String modeloDocumentoFiscal;

    @Element(name = "serie", required = true)
    private Integer serie;

    @Element(name = "nNF", required = false)
    private Integer numeroDocumentoFiscal;

    @Element(name = "refNFP", required = false)
    private NFInfoProdutorRuralReferenciada infoNFProdutorRuralReferenciada;

    @Element(name = "refECF", required = false)
    private NFInfoCupomFiscalReferenciado cupomFiscalReferenciado;

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public void setAnoMesEmissaoNFe(final String anoMesEmissaoNFe) {
        StringValidador.aamm(anoMesEmissaoNFe);
        this.anoMesEmissaoNFe = anoMesEmissaoNFe;
    }

    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setModeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        StringValidador.exatamente2(modeloDocumentoFiscal);
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public void setSerie(final Integer serie) {
        IntegerValidador.tamanho3(serie);
        this.serie = serie;
    }

    public void setNumeroDocumentoFiscal(final Integer numeroDocumentoFiscal) {
        IntegerValidador.tamanho9(numeroDocumentoFiscal);
        this.numeroDocumentoFiscal = numeroDocumentoFiscal;
    }

    public void setInfoNFProdutorRuralReferenciada(final NFInfoProdutorRuralReferenciada infoNFProdutorRuralReferenciada) {
        this.infoNFProdutorRuralReferenciada = infoNFProdutorRuralReferenciada;
    }

    public void setCupomFiscalReferenciado(final NFInfoCupomFiscalReferenciado cupomFiscalReferenciado) {
        this.cupomFiscalReferenciado = cupomFiscalReferenciado;
    }
}