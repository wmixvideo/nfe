package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte200.classes.CTUnidadeMedida;

@Root(name = "infQ")
public class CTInfoCargaQuantidade extends DFBase {
    private static final long serialVersionUID = -1838442006421644885L;

    @Element(name = "cUnid")
    private CTUnidadeMedida unidadeMedida;

    @Element(name = "tpMed")
    private String tipoMedida;

    @Element(name = "qCarga")
    private String quantidade;

    public CTUnidadeMedida getUnidadeMedida() {
        return this.unidadeMedida;
    }

    public void setUnidadeMedida(final CTUnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getTipoMedida() {
        return this.tipoMedida;
    }

    public void setTipoMedida(final String tipoMedida) {
        this.tipoMedida = tipoMedida;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(final String quantidade) {
        this.quantidade = quantidade;
    }

}
