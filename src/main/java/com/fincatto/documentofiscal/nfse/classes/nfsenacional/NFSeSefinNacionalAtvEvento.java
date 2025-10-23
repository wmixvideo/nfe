
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

import javax.xml.datatype.XMLGregorianCalendar;

@Root(name = "AtvEvento")
public class NFSeSefinNacionalAtvEvento {

    @Element(required = true)
    protected String desc;
    @Element(required = true)
    protected XMLGregorianCalendar dtIni;
    @Element(required = true)
    protected XMLGregorianCalendar dtFim;
    protected String id;
    protected NFSeSefinNacionalEnderecoSimples end;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String value) {
        this.desc = value;
    }

    public XMLGregorianCalendar getDtIni() {
        return dtIni;
    }

    public void setDtIni(XMLGregorianCalendar value) {
        this.dtIni = value;
    }

    public XMLGregorianCalendar getDtFim() {
        return dtFim;
    }

    public void setDtFim(XMLGregorianCalendar value) {
        this.dtFim = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public NFSeSefinNacionalEnderecoSimples getEnd() {
        return end;
    }

    public void setEnd(NFSeSefinNacionalEnderecoSimples value) {
        this.end = value;
    }

}
