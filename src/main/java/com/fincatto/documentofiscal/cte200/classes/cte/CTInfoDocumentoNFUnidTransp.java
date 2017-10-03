package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte200.classes.CTTipoUnidadeTransporte;

@Root(name = "infUnidTransp")
public class CTInfoDocumentoNFUnidTransp extends DFBase {
    private static final long serialVersionUID = -6450005169115940136L;

    @Element(name = "tpUnidTransp")
    private CTTipoUnidadeTransporte tipoUnidadeTransporte;

    @Element(name = "idUnidTransp")
    private String identificacaoUnidadeTransporte;

    @ElementList(name = "lacUnidTransp", inline = true, required = false)
    private List<CTInfoDocumentoNFUnidTranspLacre> lacres;

    @ElementList(name = "infUnidCarga", inline = true, required = false)
    private List<CTInfoDocumentoNFUnidadeCarga> unidadesCarga;

    @Element(name = "qtdRat", required = false)
    private String quantidadeRateada;

    public CTTipoUnidadeTransporte getTipoUnidadeTransporte() {
        return this.tipoUnidadeTransporte;
    }

    public void setTipoUnidadeTransporte(final CTTipoUnidadeTransporte tipoUnidadeTransporte) {
        this.tipoUnidadeTransporte = tipoUnidadeTransporte;
    }

    public String getIdentificacaoUnidadeTransporte() {
        return this.identificacaoUnidadeTransporte;
    }

    public void setIdentificacaoUnidadeTransporte(final String identificacaoUnidadeTransporte) {
        this.identificacaoUnidadeTransporte = identificacaoUnidadeTransporte;
    }

    public List<CTInfoDocumentoNFUnidTranspLacre> getLacres() {
        return this.lacres;
    }

    public void setLacres(final List<CTInfoDocumentoNFUnidTranspLacre> lacres) {
        this.lacres = lacres;
    }

    public List<CTInfoDocumentoNFUnidadeCarga> getUnidadesCarga() {
        return this.unidadesCarga;
    }

    public void setUnidadesCarga(final List<CTInfoDocumentoNFUnidadeCarga> unidadesCarga) {
        this.unidadesCarga = unidadesCarga;
    }

    public String getQuantidadeRateada() {
        return this.quantidadeRateada;
    }

    public void setQuantidadeRateada(final String quantidadeRateada) {
        this.quantidadeRateada = quantidadeRateada;
    }

}
