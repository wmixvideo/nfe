package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte200.classes.CTTipoUnidadeCarga;

@Root(name = "infUnidCarga")
public class CTInfoDocumentoNFUnidadeCarga extends DFBase {
    private static final long serialVersionUID = 2569096233760080388L;

    @Element(name = "tpUnidCarga")
    private CTTipoUnidadeCarga tipoUnidadeCarga;

    @Element(name = "idUnidCarga")
    private String identificadorUnidadeCarga;

    @ElementList(name = "lacUnidCarga", inline = true, required = false)
    private List<CTInfoDocumentoNFUnidadeCargaLacre> lacres;

    @Element(name = "qtdRat", required = false)
    private String quantidadeRateada;

    public CTTipoUnidadeCarga getTipoUnidadeCarga() {
        return this.tipoUnidadeCarga;
    }

    public void setTipoUnidadeCarga(final CTTipoUnidadeCarga tipoUnidadeCarga) {
        this.tipoUnidadeCarga = tipoUnidadeCarga;
    }

    public String getIdentificadorUnidadeCarga() {
        return this.identificadorUnidadeCarga;
    }

    public void setIdentificadorUnidadeCarga(final String identificadorUnidadeCarga) {
        this.identificadorUnidadeCarga = identificadorUnidadeCarga;
    }

    public List<CTInfoDocumentoNFUnidadeCargaLacre> getLacres() {
        return this.lacres;
    }

    public void setLacres(final List<CTInfoDocumentoNFUnidadeCargaLacre> lacres) {
        this.lacres = lacres;
    }

    public String getQuantidadeRateada() {
        return this.quantidadeRateada;
    }

    public void setQuantidadeRateada(final String quantidadeRateada) {
        this.quantidadeRateada = quantidadeRateada;
    }

}
