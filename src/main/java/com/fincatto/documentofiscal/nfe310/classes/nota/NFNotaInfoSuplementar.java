package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

@Root(name = "infNFeSupl")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaInfoSuplementar extends DFBase {
    private static final long serialVersionUID = -7212144193264841151L;

    @Element(data = true, name = "qrCode", required = true)
    private String qrCode;

    public void setQrCode(final String qrCode) {
        StringValidador.tamanho100a600(qrCode, "QR Code");
        this.qrCode = qrCode;
    }

    public String getQrCode() {
        return this.qrCode;
    }
}