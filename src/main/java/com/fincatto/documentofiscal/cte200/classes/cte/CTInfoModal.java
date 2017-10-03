package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoModal extends DFBase {
    private static final long serialVersionUID = -6014137294072801459L;

    @Attribute(name = "versaoModal")
    private String versaoModal;

    @Element(name = "rodo", required = false)
    private CTInfoModalRodoviario rodoviario;

    @Element(name = "aereo", required = false)
    private CTInfoModalAereo aereo;

    public String getVersaoModal() {
        return this.versaoModal;
    }

    public void setVersaoModal(final String versaoModal) {
        this.versaoModal = versaoModal;
    }

    public CTInfoModalRodoviario getRodoviario() {
        return this.rodoviario;
    }

    public void setRodoviario(final CTInfoModalRodoviario rodoviario) {
        this.rodoviario = rodoviario;
    }

    public CTInfoModalAereo getAereo() {
        return this.aereo;
    }

    public void setAereo(final CTInfoModalAereo aereo) {
        this.aereo = aereo;
    }
}
