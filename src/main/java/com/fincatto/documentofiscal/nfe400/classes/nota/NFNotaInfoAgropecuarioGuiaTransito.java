package com.fincatto.documentofiscal.nfe400.classes.nota;


import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoAgropecuarioTipoGuia;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Guia de Trânsito
 *
 * @author Fagner Couto
 */
@Root(name = "agropecuario")
public class NFNotaInfoAgropecuarioGuiaTransito extends DFBase {

    @Element(name = "tpGuia")
    private NFNotaInfoAgropecuarioTipoGuia tipoGuia;

    @Element(name = "UFGuia")
    private String ufGuia;

    @Element(name = "serieGuia")
    private String serieGuia;

    @Element(name = "nGuia")
    private Integer numeroGuia;

    public NFNotaInfoAgropecuarioTipoGuia getTipoGuia() {
        return tipoGuia;
    }

    public void setTipoGuia(NFNotaInfoAgropecuarioTipoGuia tipoGuia) {
        this.tipoGuia = tipoGuia;
    }

      public String getSerieGuia() {
        return serieGuia;
    }

    public void setSerieGuia(String serieGuia) {
        DFStringValidador.tamanho9(serieGuia, "Série da Guia");
        this.serieGuia = serieGuia;
    }

    public Integer getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(Integer numeroGuia) {
        DFIntegerValidador.tamanho9(numeroGuia, "Número da Guia");
        this.numeroGuia = numeroGuia;
    }

    public String getUfGuia() {
        return this.ufGuia;
    }

    public void setUfGuia(DFUnidadeFederativa ufGuia) {
        this.ufGuia = ufGuia.getCodigo();
    }
}
