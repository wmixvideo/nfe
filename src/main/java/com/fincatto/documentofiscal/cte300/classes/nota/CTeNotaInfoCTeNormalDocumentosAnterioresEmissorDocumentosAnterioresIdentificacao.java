package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * @author Caio
 * @info Informações de identificação dos documentos de Transporte Anterior
 */

@Root(name = "idDocAnt")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacao extends DFBase {
    private static final long serialVersionUID = -3320719905693854938L;

    @Element(name = "idDocAntPap", required = false)
    private List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoPapel> identificacaoPapel;

    @Element(name = "idDocAntEle", required = false)
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
