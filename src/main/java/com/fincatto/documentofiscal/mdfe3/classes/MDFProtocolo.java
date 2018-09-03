package com.fincatto.documentofiscal.mdfe3.classes;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;

/**
 * @Author Eldevan Nery Junior on 26/05/17.
 */
@Root(name = "protMDFe")
public class MDFProtocolo extends DFBase {
    private static final long serialVersionUID = 7056704602846442462L;

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