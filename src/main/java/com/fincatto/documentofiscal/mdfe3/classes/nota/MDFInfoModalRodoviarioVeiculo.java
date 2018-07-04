package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoCarroceria;

public abstract class MDFInfoModalRodoviarioVeiculo extends DFBase {
    private static final long serialVersionUID = 3584628986749380582L;

    @Element(name = "cInt", required = false)
    protected String codigoInterno;

    @Element(name = "placa")
    protected String placa;

    @Element(name = "RENAVAM", required = false)
    protected String renavam;

    @Element(name = "tara")
    protected String tara;

    @Element(name = "capM3", required = false)
    protected String capacidadeM3;

    @Element(name = "prop", required = false)
    protected MDFInfoModalRodoviarioVeiculoProp proprietario;
    /**
     * Tipo de carroceria
     */
    @Element(name = "tpCar")
    protected MDFTipoCarroceria tipoCarroceria;

    @Element(name = "UF")
    protected String unidadeFederativa;

    public String getCodigoInterno() {
        return this.codigoInterno;
    }

    protected abstract void setCodigoInterno(String codigoInterno);

    public String getPlaca() {
        return this.placa;
    }

    protected abstract void setPlaca(String placa);

    public String getRenavam() {
        return this.renavam;
    }

    protected abstract void setRenavam(String renavam);

    public String getTara() {
        return this.tara;
    }

    protected abstract void setTara(String tara);

    public String getCapacidadeM3() {
        return this.capacidadeM3;
    }

    protected abstract void setCapacidadeM3(String capacidadeM3);

    public MDFInfoModalRodoviarioVeiculoProp getProprietario() {
        return this.proprietario;
    }

    public void setProprietario(final MDFInfoModalRodoviarioVeiculoProp proprietario) {
        this.proprietario = proprietario;
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
