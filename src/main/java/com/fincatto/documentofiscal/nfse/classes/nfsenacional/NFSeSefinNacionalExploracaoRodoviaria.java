
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;


@Root(name = "ExploracaoRodoviaria")
public class NFSeSefinNacionalExploracaoRodoviaria {

    @Element(required = true)
    protected String categVeic;
    @Element(required = true)
    protected String nEixos;
    @Element(required = true)
    protected String rodagem;
    @Element(required = true)
    protected String sentido;
    @Element(required = true)
    protected String placa;
    @Element(required = true)
    protected String codAcessoPed;
    @Element(required = true)
    protected String codContrato;

    public String getCategVeic() {
        return categVeic;
    }

    public void setCategVeic(String value) {
        this.categVeic = value;
    }

    public String getNEixos() {
        return nEixos;
    }

    public void setNEixos(String value) {
        this.nEixos = value;
    }

    public String getRodagem() {
        return rodagem;
    }

    public void setRodagem(String value) {
        this.rodagem = value;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String value) {
        this.sentido = value;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String value) {
        this.placa = value;
    }

    public String getCodAcessoPed() {
        return codAcessoPed;
    }

    public void setCodAcessoPed(String value) {
        this.codAcessoPed = value;
    }

    public String getCodContrato() {
        return codContrato;
    }

    public void setCodContrato(String value) {
        this.codContrato = value;
    }

}
