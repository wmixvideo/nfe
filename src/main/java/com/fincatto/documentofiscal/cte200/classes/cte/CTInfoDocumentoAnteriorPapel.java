package com.fincatto.documentofiscal.cte200.classes.cte;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte200.classes.CTTipoDocumentoTransporteAnterior;

@Root(name = "idDocAntPap")
public class CTInfoDocumentoAnteriorPapel extends DFBase {
    private static final long serialVersionUID = 4454196068240203651L;

    @Element(name = "tpDoc")
    private CTTipoDocumentoTransporteAnterior tipoDocumento;

    @Element(name = "serie")
    private String serie;

    @Element(name = "subser", required = false)
    private String subSerie;

    @Element(name = "nDoc")
    private String numero;

    @Element(name = "dEmi")
    private LocalDate dataEmissao;

    public CTTipoDocumentoTransporteAnterior getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(final CTTipoDocumentoTransporteAnterior tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(final String serie) {
        this.serie = serie;
    }

    public String getSubSerie() {
        return this.subSerie;
    }

    public void setSubSerie(final String subSerie) {
        this.subSerie = subSerie;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

}
