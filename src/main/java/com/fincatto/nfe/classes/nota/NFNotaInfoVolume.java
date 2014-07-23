package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoVolume extends NFBase {
    @Element(name = "qVol", required = false)
    private BigInteger quantidadeVolumesTransportados;

    @Element(name = "nVol", required = false)
    private String numeracaoVolumesTransportados;

    @Element(name = "esp", required = false)
    private String especieVolumesTransportados;

    @Element(name = "marca", required = false)
    private String marca;

    @Element(name = "pesoL", required = false)
    private String pesoLiquido;

    @Element(name = "pesoB", required = false)
    private String pesoBruto;

    @ElementList(entry = "lacres", inline = true, required = false)
    private List<NFNotaInfoLacre> lacres;

    public BigInteger getQuantidadeVolumesTransportados() {
        return this.quantidadeVolumesTransportados;
    }

    public void setQuantidadeVolumesTransportados(final BigInteger quantidadeVolumesTransportados) {
        this.quantidadeVolumesTransportados = quantidadeVolumesTransportados;
    }

    public String getNumeracaoVolumesTransportados() {
        return this.numeracaoVolumesTransportados;
    }

    public void setNumeracaoVolumesTransportados(final String numeracaoVolumesTransportados) {
        StringValidador.tamanho60(numeracaoVolumesTransportados);
        this.numeracaoVolumesTransportados = numeracaoVolumesTransportados;
    }

    public String getEspecieVolumesTransportados() {
        return this.especieVolumesTransportados;
    }

    public void setEspecieVolumesTransportados(final String especieVolumesTransportados) {
        StringValidador.tamanho60(especieVolumesTransportados);
        this.especieVolumesTransportados = especieVolumesTransportados;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(final String marca) {
        StringValidador.tamanho60(marca);
        this.marca = marca;
    }

    public BigDecimal getPesoLiquido() {
        return new BigDecimal(this.pesoLiquido);
    }

    public void setPesoLiquido(final BigDecimal pesoLiquido) {
        this.pesoLiquido = BigDecimalParser.tamanho15Com3CasasDecimais(pesoLiquido);
    }

    public BigDecimal getPesoBruto() {
        return new BigDecimal(this.pesoBruto);
    }

    public void setPesoBruto(final BigDecimal pesoBruto) {
        this.pesoBruto = BigDecimalParser.tamanho15Com3CasasDecimais(pesoBruto);
    }

    public List<NFNotaInfoLacre> getLacres() {
        return Collections.unmodifiableList(this.lacres);
    }

    public void setLacres(final List<NFNotaInfoLacre> lacres) {
        this.lacres = lacres;
    }
}