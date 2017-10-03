package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

@Root(name = "veic")
public class CTInfoModalRodoviarioVeiculo extends DFBase {
    private static final long serialVersionUID = 4907049342684105628L;

    @Element(name = "cInt", required = false)
    private String codigoInterno;

    @Element(name = "RENAVAM")
    private String renavam;

    @Element(name = "placa")
    private String placa;

    @Element(name = "tara")
    private String tara;

    @Element(name = "capKG")
    private String capacidadeKG;

    @Element(name = "capM3")
    private String capacidadeM3;

    @Element(name = "tpProp")
    private String tipoPropriedade;

    @Element(name = "tpVeic")
    private String tipoVeiculo;

    @Element(name = "tpRod")
    private String tipoRodado;

    @Element(name = "tpCar")
    private String tipoCarroceria;

    @Element(name = "UF")
    private DFUnidadeFederativa unidadeFederativa;

    @Element(name = "prop", required = false)
    private CTInfoModalRodoviarioVeiculoProp proprietario;

    public String getCodigoInterno() {
        return this.codigoInterno;
    }

    public void setCodigoInterno(final String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getRenavam() {
        return this.renavam;
    }

    public void setRenavam(final String renavam) {
        this.renavam = renavam;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(final String placa) {
        this.placa = placa;
    }

    public String getTara() {
        return this.tara;
    }

    public void setTara(final String tara) {
        this.tara = tara;
    }

    public String getCapacidadeKG() {
        return this.capacidadeKG;
    }

    public void setCapacidadeKG(final String capacidadeKG) {
        this.capacidadeKG = capacidadeKG;
    }

    public String getCapacidadeM3() {
        return this.capacidadeM3;
    }

    public void setCapacidadeM3(final String capacidadeM3) {
        this.capacidadeM3 = capacidadeM3;
    }

    public String getTipoPropriedade() {
        return this.tipoPropriedade;
    }

    public void setTipoPropriedade(final String tipoPropriedade) {
        this.tipoPropriedade = tipoPropriedade;
    }

    public String getTipoVeiculo() {
        return this.tipoVeiculo;
    }

    public void setTipoVeiculo(final String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getTipoRodado() {
        return this.tipoRodado;
    }

    public void setTipoRodado(final String tipoRodado) {
        this.tipoRodado = tipoRodado;
    }

    public String getTipoCarroceria() {
        return this.tipoCarroceria;
    }

    public void setTipoCarroceria(final String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public DFUnidadeFederativa getUnidadeFederativa() {
        return this.unidadeFederativa;
    }

    public void setUnidadeFederativa(final DFUnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public CTInfoModalRodoviarioVeiculoProp getProprietario() {
        return this.proprietario;
    }

    public void setProprietario(final CTInfoModalRodoviarioVeiculoProp proprietario) {
        this.proprietario = proprietario;
    }

}
