package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoCarroceria;
import org.simpleframework.xml.Element;

public abstract class MDFInfoModalRodoviarioVeiculo extends DFBase {

    @Element(name = "cInt", required = false)
    protected String codigoInterno;

    @Element(name = "placa")
    protected String placa;

    @Element(name = "RENAVAM", required = false)
    protected String renavam;

    @Element(name = "tara")
    protected String tara;

    @Element(name = "capM3" ,required = false)
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
        return codigoInterno;
    }

    protected abstract void setCodigoInterno(String codigoInterno);

    public String getPlaca() {
        return placa;
    }

    protected abstract void setPlaca(String placa);

    public String getRenavam() {
        return renavam;
    }

    protected abstract void setRenavam(String renavam);

    public String getTara() {
        return tara;
    }

    protected abstract void setTara(String tara);

    public String getCapacidadeM3() {
        return capacidadeM3;
    }

    protected abstract void setCapacidadeM3(String capacidadeM3);

    public MDFInfoModalRodoviarioVeiculoProp getProprietario() {
        return proprietario;
    }

    public void setProprietario(MDFInfoModalRodoviarioVeiculoProp proprietario) {
        this.proprietario = proprietario;
    }

    public MDFTipoCarroceria getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(MDFTipoCarroceria tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public void setUnidadeFederativa(DFUnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa.getCodigo();
    }
}
