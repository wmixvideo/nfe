package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * @author Caio
 * @info Informações de identificação dos documentos de Transporte Anterior
 */

@Root(name = "idDocAnt")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacao extends DFBase {
    private static final long serialVersionUID = -3320719905693854938L;

    @ElementList(name = "idDocAntPap", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoPapel> identificacaoPapel;

    @ElementList(name = "idDocAntEle", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoEletronico> identificacaoEletronico;

    public CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacao() {
        this.identificacaoPapel = null;
        this.identificacaoEletronico = null;
    }

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
