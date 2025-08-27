package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Informações de identificação dos documentos de Transporte Anterior
 */

@Root(name = "idDocAnt")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacao extends DFBase {
    private static final long serialVersionUID = 3331955690692199729L;

    @ElementList(name = "idDocAntPap", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoPapel> identificacaoPapel;

    @ElementList(name = "idDocAntEle", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoEletronico> identificacaoEletronico;

    public List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoPapel> getIdentificacaoPapel() {
        return this.identificacaoPapel;
    }

    /**
     * Documentos de transporte anterior em papel
     */
    public void setIdentificacaoPapel(final List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoPapel> identificacaoPapel) {
        this.identificacaoPapel = identificacaoPapel;
    }

    public List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoEletronico> getIdentificacaoEletronico() {
        return this.identificacaoEletronico;
    }

    /**
     * Documentos de transporte anterior eletrônicos
     */
    public void setIdentificacaoEletronico(final List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoEletronico> identificacaoEletronico) {
        this.identificacaoEletronico = identificacaoEletronico;
    }
}
