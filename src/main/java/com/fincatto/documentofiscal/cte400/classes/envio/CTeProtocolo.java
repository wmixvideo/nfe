package com.fincatto.documentofiscal.cte400.classes.envio;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.nota.assinatura.CTeSignature;
import org.simpleframework.xml.*;

import java.util.List;

@Root(name = "protCTe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeProtocolo extends DFBase {
    private static final long serialVersionUID = 4634629801463718104L;

    @Element(name = "infProt", required = false)
    private CTeProtocoloInfo info;

    @ElementList(inline = true, required = false)
    private List<CTeInformacaoFisco> informacoesFisco;

    @Element(name = "Signature", required = false)
    private CTeSignature signature;

    // o XSD define que esse atributo é obrigatório, mas ele não está sendo retornado pela SEFAZ-SP
    @Attribute(name = "versao", required = false)
    private String versao;

    public CTeProtocoloInfo getInfo() {
        return this.info;
    }

    /**
     * Dados do protocolo de status
     */
    public void setInfo(final CTeProtocoloInfo info) {
        this.info = info;
    }

    public CTeSignature getSignature() {
        return this.signature;
    }

    /**
     *
     * */
    public void setSignature(final CTeSignature signature) {
        this.signature = signature;
    }

    public String getVersao() {
        return this.versao;
    }

    /**
     *
     * */
    public void setVersao(final String versao) {
        this.versao = versao;
    }
}
