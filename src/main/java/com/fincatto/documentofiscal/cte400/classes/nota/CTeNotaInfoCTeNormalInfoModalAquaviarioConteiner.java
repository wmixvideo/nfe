package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Grupo de informações de detalhamento dos conteiners (Somente para Redespacho Intermediario e serviço vinculado)
 */

@Root(name = "detCont")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalAquaviarioConteiner extends DFBase {
    private static final long serialVersionUID = -7329224461307912634L;

    @Element(name = "nCont")
    private String identificacao;

    @ElementList(name = "lacre", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerLacre> lacre;

    @Element(name = "infDoc", required = false)
    private CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentos infoDocumentos;

    public String getIdentificacao() {
        return this.identificacao;
    }

    /**
     * Identificação do Container
     */
    public void setIdentificacao(final String identificacao) {
        DFStringValidador.tamanho20(identificacao, "Identificação do Containe");
        this.identificacao = identificacao;
    }

    public List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerLacre> getLacre() {
        return this.lacre;
    }

    /**
     * Grupo de informações dos lacres dos cointainers da qtde da carga
     */
    public void setLacre(final List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerLacre> lacre) {
        DFListValidador.tamanho3(lacre, "Grupo de informações dos lacres dos cointainers da qtde da carga");
        this.lacre = lacre;
    }

    public CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentos getInfoDocumentos() {
        return this.infoDocumentos;
    }

    /**
     * Informações dos documentos dos conteiners
     */
    public void setInfoDocumentos(final CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentos infoDocumentos) {
        this.infoDocumentos = infoDocumentos;
    }
}
