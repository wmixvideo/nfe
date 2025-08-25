package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * Created by Edivaldo Merlo Stens on 29/06/20.
 * <h1>Informações da localização do carregamento do MDF-e de carga lotação</h1>
 */
@Root(name = "infLocalCarrega")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoProdutoPredominanteInfLotacaoLocalCarrega extends DFBase {
    private static final long serialVersionUID = -5711457880712720488L;

    @Element(name = "CEP", required = false)
    private String CEP;
    
    @Element(name = "latitude", required = false)
    private Float latitude;
    
    @Element(name = "longitude", required = false)
    private Float longitude;

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

}
