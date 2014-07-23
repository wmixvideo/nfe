package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoReboque extends NFBase {
    @Element(name = "placa", required = true)
    private String placaVeiculo;

    @Element(name = "UF", required = true)
    private NFUnidadeFederativa uf;

    @Element(name = "RNTC", required = false)
    private String registroNacionalTransportadorCarga;

    @Element(name = "vagao", required = false)
    private String vagao;

    @Element(name = "balsa", required = false)
    private String balsa;

    public String getPlacaVeiculo() {
        return this.placaVeiculo;
    }

    public void setPlacaVeiculo(final String placaVeiculo) {
        StringValidador.placaDeVeiculo(placaVeiculo);
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
        if (this.vagao != null || this.balsa != null) {
            throw new IllegalStateException("Apenas pode ser setado um");
        }
        StringValidador.tamanho20(registroNacionalTransportadorCarga);
        this.registroNacionalTransportadorCarga = registroNacionalTransportadorCarga;
    }

    public String getVagao() {
        return this.vagao;
    }

    public void setVagao(final String vagao) {
        if (this.balsa != null || this.registroNacionalTransportadorCarga != null) {
            throw new IllegalStateException("Apenas pode ser setado um");
        }
        StringValidador.tamanho20(vagao);
        this.vagao = vagao;
    }

    public String getBalsa() {
        return this.balsa;
    }

    public void setBalsa(final String balsa) {
        if (this.vagao != null || this.registroNacionalTransportadorCarga != null) {
            throw new IllegalStateException("Apenas pode ser setado um");
        }
        StringValidador.tamanho20(balsa);
        this.balsa = balsa;
    }
}