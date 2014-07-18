package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoVolume extends NFBase {
    @Element(name = "qVol", required = false)
    private int quantidadeVolumesTransportados;

    @Element(name = "nVol", required = false)
    private String numeracaoVolumesTransportados;

    @Element(name = "esp", required = false)
    private String especieVolumesTransportados;

    @Element(name = "marca", required = false)
    private String marca;

    @Element(name = "pesoL", required = false)
    private BigDecimal pesoLiquido;

    @Element(name = "pesoB", required = false)
    private BigDecimal pesoBruto;

    @ElementList(entry = "lacres", inline = true, required = false)
    private List<NFNotaInfoLacre> lacres;

    public int getQuantidadeVolumesTransportados() {
        return this.quantidadeVolumesTransportados;
    }

    public void setQuantidadeVolumesTransportados(final int quantidadeVolumesTransportados) {
        this.quantidadeVolumesTransportados = quantidadeVolumesTransportados;
    }

    public String getNumeracaoVolumesTransportados() {
        return this.numeracaoVolumesTransportados;
    }

    public void setNumeracaoVolumesTransportados(final String numeracaoVolumesTransportados) {
        this.numeracaoVolumesTransportados = numeracaoVolumesTransportados;
    }

    public String getEspecieVolumesTransportados() {
        return this.especieVolumesTransportados;
    }

    public void setEspecieVolumesTransportados(final String especieVolumesTransportados) {
        this.especieVolumesTransportados = especieVolumesTransportados;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(final String marca) {
        this.marca = marca;
    }

    public BigDecimal getPesoLiquido() {
        return this.pesoLiquido;
    }

    public void setPesoLiquido(final BigDecimal pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public BigDecimal getPesoBruto() {
        return this.pesoBruto;
    }

    public void setPesoBruto(final BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public List<NFNotaInfoLacre> getLacres() {
        return this.lacres;
    }

    public void setLacres(final List<NFNotaInfoLacre> lacres) {
        this.lacres = lacres;
    }
}