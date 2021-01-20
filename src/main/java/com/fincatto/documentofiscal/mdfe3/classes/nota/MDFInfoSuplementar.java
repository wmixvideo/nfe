package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Eldevan Nery Junior on 07/10/19.
 * <h1>Informações suplementares do MDF-e</h1>
 */
@Root(name = "infMDFeSupl")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoSuplementar extends DFBase {

    @Element(data = true, name = "qrCodMDFe")
    private String qrCodMDFe;
    

    public void setQrCodMDFe(final String qrCode) {
        DFStringValidador.validaIntervalo(qrCode, 50, 1000,"MDF-e QR Code");
        this.qrCodMDFe = qrCode;
    }

    public String getQrCodMDFe() {
        return this.qrCodMDFe;
    }

}