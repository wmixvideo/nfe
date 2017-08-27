package com.fincatto.mdfe3.classes;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.nota.assinatura.NFSignature;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @Author Eldevan Nery Junior on 26/05/17.
 */
@Root(name = "protMDFe")
public class MDFProtocolo extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infProt", required = true)
    private MDFProtocoloInfo protocoloInfo;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public void setProtocoloInfo(final MDFProtocoloInfo protocoloInfo) {
        this.protocoloInfo = protocoloInfo;
    }

    public MDFProtocoloInfo getProtocoloInfo() {
        return this.protocoloInfo;
    }

    public String getVersao() {
        return this.versao;
    }
}