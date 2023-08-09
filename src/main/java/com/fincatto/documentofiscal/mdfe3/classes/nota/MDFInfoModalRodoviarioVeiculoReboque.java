package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoCarroceria;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.validadores.DFStringValidador;

public class MDFInfoModalRodoviarioVeiculoReboque extends DFBase {
    private static final long serialVersionUID = -2787982058485353668L;
    @Element(name = "cInt", required = false)
    protected String codigoInterno;

    @Element(name = "placa")
    protected String placa;

    @Element(name = "RENAVAM", required = false)
    protected String renavam;

    @Element(name = "tara")
    protected String tara;

    @Element(name = "capKG")
    private String capacidadeKG;

    @Element(name = "capM3", required = false)
    protected String capacidadeM3;

    /**
     * Tipo de carroceria
     */
    @Element(name = "tpCar")
    protected MDFTipoCarroceria tipoCarroceria;

    @Element(name = "UF")
    protected String unidadeFederativa;

    @Element(name = "prop", required = false)
    protected MDFInfoModalRodoviarioVeiculoProp proprietario;

    public void setCodigoInterno(final String codigoInterno) {
        this.codigoInterno = DFStringValidador.validador(codigoInterno, "Codigo interno Veiculo Reboque", 10, false, false);
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(final String placa) {
        DFStringValidador.placaDeVeiculo(placa, "Placa do reboque");
        this.placa = placa;
    }

    public String getRenavam() {
        return this.renavam;
    }

    public void setRenavam(final String renavam) {
        this.renavam = DFStringValidador.validaIntervalo(renavam, 9, 11, "Renavam do reboque");
    }

    public void setTara(final String tara) {
        this.tara = DFStringValidador.capacidadeNDigitos(tara, "Tara em reboque", 5);
    }

    public String getTara() {
        return this.tara;
    }

    public String getCapacidadeKG() {
        return this.capacidadeKG;
    }

    public void setCapacidadeKG(final String capacidadeKG) {
        this.capacidadeKG = DFStringValidador.capacidadeNDigitos(capacidadeKG, "Capacidade em KG reboque", 5);
    }

    public String getCapacidadeM3() {
        return this.capacidadeM3;
    }

    public void setCapacidadeM3(final String capacidadeM3) {
        this.capacidadeM3 = DFStringValidador.capacidadeNDigitos(capacidadeM3, "Capacidade em M3 reboque", 2);
    }

    public void setProprietario(final MDFInfoModalRodoviarioVeiculoProp proprietario) {
        this.proprietario = proprietario;
    }

    public MDFInfoModalRodoviarioVeiculoProp getProprietario() {
        return this.proprietario;
    }

    public MDFTipoCarroceria getTipoCarroceria() {
        return this.tipoCarroceria;
    }

    public void setTipoCarroceria(final MDFTipoCarroceria tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public String getUnidadeFederativa() {
        return this.unidadeFederativa;
    }

    public void setUnidadeFederativa(final String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public void setUnidadeFederativa(final DFUnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa.getCodigo();
    }

}
