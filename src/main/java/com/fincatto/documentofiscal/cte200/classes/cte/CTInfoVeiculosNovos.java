package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "veicNovos")
public class CTInfoVeiculosNovos extends DFBase {
    private static final long serialVersionUID = 3722531180038594161L;

    @Element(name = "chassi")
    private String chassi;

    @Element(name = "cCor")
    private String codigoCor;

    @Element(name = "xCor")
    private String descricaoCor;

    @Element(name = "cMod")
    private String codigoMarcaModelo;

    @Element(name = "vUnit")
    private String valorUnitario;

    @Element(name = "vFrete")
    private String valorFreteUnitario;

    public String getChassi() {
        return this.chassi;
    }

    public void setChassi(final String chassi) {
        this.chassi = chassi;
    }

    public String getCodigoCor() {
        return this.codigoCor;
    }

    public void setCodigoCor(final String codigoCor) {
        this.codigoCor = codigoCor;
    }

    public String getDescricaoCor() {
        return this.descricaoCor;
    }

    public void setDescricaoCor(final String descricaoCor) {
        this.descricaoCor = descricaoCor;
    }

    public String getCodigoMarcaModelo() {
        return this.codigoMarcaModelo;
    }

    public void setCodigoMarcaModelo(final String codigoMarcaModelo) {
        this.codigoMarcaModelo = codigoMarcaModelo;
    }

    public String getValorUnitario() {
        return this.valorUnitario;
    }

    public void setValorUnitario(final String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getValorFreteUnitario() {
        return this.valorFreteUnitario;
    }

    public void setValorFreteUnitario(final String valorFreteUnitario) {
        this.valorFreteUnitario = valorFreteUnitario;
    }

}
