
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "ComExterior")
public class NFSeSefinNacionalComExterior {

    @Element(required = true)
    protected String mdPrestacao;
    @Element(required = true)
    protected String vincPrest;
    @Element(required = true)
    protected String tpMoeda;
    @Element(required = true)
    protected String vServMoeda;
    @Element(required = true)
    protected String mecAFComexP;
    @Element(required = true)
    protected String mecAFComexT;
    @Element(required = true)
    protected String movTempBens;
    @Element(name = "nDI", required = false)
    protected String ndi;
    @Element(name = "nRE", required = false)
    protected String nre;
    @Element(required = true)
    protected String mdic;

    public String getMdPrestacao() {
        return mdPrestacao;
    }

    public void setMdPrestacao(String value) {
        this.mdPrestacao = value;
    }

    public String getVincPrest() {
        return vincPrest;
    }

    public void setVincPrest(String value) {
        this.vincPrest = value;
    }

    public String getTpMoeda() {
        return tpMoeda;
    }

    public void setTpMoeda(String value) {
        this.tpMoeda = value;
    }

    public String getVServMoeda() {
        return vServMoeda;
    }

    public void setVServMoeda(String value) {
        this.vServMoeda = value;
    }

    public String getMecAFComexP() {
        return mecAFComexP;
    }

    public void setMecAFComexP(String value) {
        this.mecAFComexP = value;
    }

    public String getMecAFComexT() {
        return mecAFComexT;
    }

    public void setMecAFComexT(String value) {
        this.mecAFComexT = value;
    }

    public String getMovTempBens() {
        return movTempBens;
    }

    public void setMovTempBens(String value) {
        this.movTempBens = value;
    }

    public String getNDI() {
        return ndi;
    }

    public void setNDI(String value) {
        this.ndi = value;
    }

    public String getNRE() {
        return nre;
    }

    public void setNRE(String value) {
        this.nre = value;
    }

    public String getMdic() {
        return mdic;
    }

    public void setMdic(String value) {
        this.mdic = value;
    }

}
