package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "infNFeSupl")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaInfoSuplementar extends DFBase {
    private static final long serialVersionUID = -7212144193264841151L;
    
    @Element(data = true, name = "qrCode")
    private String qrCode;
    
    @Element(name = "urlChave")
    private String urlConsultaChaveAcesso;

    public void setQrCode(final String qrCode) {
        DFStringValidador.tamanho100a600(qrCode, "QR Code");
        this.qrCode = qrCode;
    }

    public String getQrCode() {
        return this.qrCode;
    }

    public String getUrlConsultaChaveAcesso() {
        return this.urlConsultaChaveAcesso;
    }

    /**
     * Informar a URL da &quot;Consulta por chave de acesso da NFC-e&quot;.
     *  A mesma URL que deve estar informada no DANFE NFC-e para consulta por chave de acesso.
     * @param urlConsultaChaveAcesso
     */
    public void setUrlConsultaChaveAcesso(final String urlConsultaChaveAcesso) {
        DFStringValidador.validaIntervalo(urlConsultaChaveAcesso, 21,85, "Url Consulta Chave Acesso ");
        this.urlConsultaChaveAcesso = urlConsultaChaveAcesso;
    }
}