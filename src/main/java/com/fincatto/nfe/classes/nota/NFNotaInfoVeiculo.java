package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoVeiculo extends NFBase {
    @Element(name = "placa", required = true)
    private String placaVeiculo;

    @Element(name = "UF", required = true)
    private NFUnidadeFederativa uf;

    @Element(name = "RNTC", required = false)
    private String registroNacionalTransportadorCarga;

    public String getPlacaVeiculo() {
        return this.placaVeiculo;
    }

    public void setPlacaVeiculo(final String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public NFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public String getRegistroNacionalTransportadorCarga() {
        return this.registroNacionalTransportadorCarga;
    }

    public void setRegistroNacionalTransportadorCarga(final String registroNacionalTransportadorCarga) {
        this.registroNacionalTransportadorCarga = registroNacionalTransportadorCarga;
    }
}