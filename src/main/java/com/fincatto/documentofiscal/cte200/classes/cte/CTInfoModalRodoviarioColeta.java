package com.fincatto.documentofiscal.cte200.classes.cte;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "occ")
public class CTInfoModalRodoviarioColeta extends DFBase {
    private static final long serialVersionUID = -681665118121512351L;

    @Element(name = "serie", required = false)
    private String serie;

    @Element(name = "nOcc")
    private String numeroOrdemColeta;

    @Element(name = "dEmi")
    private LocalDate dataEmissao;

    @Element(name = "emiOcc")
    private CTInfoModalRodoviarioColetaEmissor emissor;

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(final String serie) {
        this.serie = serie;
    }

    public String getNumeroOrdemColeta() {
        return this.numeroOrdemColeta;
    }

    public void setNumeroOrdemColeta(final String numeroOrdemColeta) {
        this.numeroOrdemColeta = numeroOrdemColeta;
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public CTInfoModalRodoviarioColetaEmissor getEmissor() {
        return this.emissor;
    }

    public void setEmissor(final CTInfoModalRodoviarioColetaEmissor emissor) {
        this.emissor = emissor;
    }

}
