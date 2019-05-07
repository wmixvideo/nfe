package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoUnidadeCarga;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
 */
public class MDFInfoInformacoesDFeTipoUnidadeCarga {

    @Element(name = "tpUnidCarga")
    private MDFTipoUnidadeCarga tipoUnidadeCarga;
    /**
     * Identificação da Unidade de Carga
     * Informar a identificação da unidade de carga, por exemplo: número do container.
     */
    @Element(name = "idUnidCarga")
    private String idUnidCarga;
    /**
     * Lacres das Unidades de Carga.
     */
    @ElementList(entry = "lacUnidCarga", inline = true)
    private List<MDFInfoLacre1A20> lacUnidCarga;
    /**
     * Quantidade rateada (Peso,Volume)
     */
    @Element(name = "qtdRat")
    private String qtdRateada;

    public MDFTipoUnidadeCarga getTipoUnidadeCarga() {
        return tipoUnidadeCarga;
    }

    public void setTipoUnidadeCarga(MDFTipoUnidadeCarga tipoUnidadeCarga) {
        this.tipoUnidadeCarga = tipoUnidadeCarga;
    }

    public String getIdUnidCarga() {
        return idUnidCarga;
    }

    public void setIdUnidCarga(String idUnidCarga) {
        this.idUnidCarga = idUnidCarga;
    }

    public List<MDFInfoLacre1A20> getLacUnidCarga() {
        return lacUnidCarga;
    }

    public void setLacUnidCarga(List<MDFInfoLacre1A20> lacUnidCarga) {
        this.lacUnidCarga = lacUnidCarga;
    }

    public String getQtdRateada() {
        return qtdRateada;
    }

    public void setQtdRateada(String qtdRateada) {
        this.qtdRateada = qtdRateada;
    }

}
