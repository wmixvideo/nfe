package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoModal extends DFBase {

    @Attribute(name = "versaoModal")
    private String versaoModal;

    @Element(name = "rodo")
    private CTInfoModalRodoviario rodoviario;

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

}
