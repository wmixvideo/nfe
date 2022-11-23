package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * Created by Edivaldo Merlo Stens on 29/06/20.
 * <h1>Informações da carga lotação. Informar somente quando MDF-e for de carga lotação</h1>
 */
@Root(name = "infLotacao")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoProdutoPredominanteInfLotacao extends DFBase {
    private static final long serialVersionUID = -5711457880712720488L;

    /**
     * Informações da localização do carregamento do MDF-e de carga lotação
     */
    @Element(name = "infLocalCarrega", required = true)
    protected MDFInfoProdutoPredominanteInfLotacaoLocalCarrega infLocalCarrega;
    
    /**
     * Informações da localização do descarregamento do MDF-e de carga lotação
     */
    @Element(name = "infLocalDescarrega", required = true)
    protected MDFInfoProdutoPredominanteInfLotacaoLocalDescarrega infLocalDescarrega;

    public MDFInfoProdutoPredominanteInfLotacaoLocalCarrega getInfLocalCarrega() {
        return infLocalCarrega;
    }

    public void setInfLocalCarrega(MDFInfoProdutoPredominanteInfLotacaoLocalCarrega infLocalCarrega) {
        this.infLocalCarrega = infLocalCarrega;
    }

    public MDFInfoProdutoPredominanteInfLotacaoLocalDescarrega getInfLocalDescarrega() {
        return infLocalDescarrega;
    }

    public void setInfLocalDescarrega(MDFInfoProdutoPredominanteInfLotacaoLocalDescarrega infLocalDescarrega) {
        this.infLocalDescarrega = infLocalDescarrega;
    }
    
}
