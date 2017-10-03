package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTipoFerrovia;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

/**
 * @author Caio
 * @info Detalhamento de informações para o tráfego mútuo
 */

@Root(name = "trafMut")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalFerroviarioTrafegoMutuo extends DFBase {
    private static final long serialVersionUID = -1418176957547086575L;

    @Element(name = "respFat", required = true)
    private CTTipoFerrovia responsavel;

    @Element(name = "ferrEmi", required = true)
    private CTTipoFerrovia emitente;

    @Element(name = "vFrete", required = true)
    private String valorFrete;

    @Element(name = "chCTeFerroOrigem", required = false)
    private String chaveCTeFerroviaOrigem;

    @ElementList(name = "ferroEnv", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoModalFerroviarioTrafegoMutuoFerroviasEnvolvidas> ferroviasEnvolvidas;

    public CTeNotaInfoCTeNormalInfoModalFerroviarioTrafegoMutuo() {
        this.responsavel = null;
        this.emitente = null;
        this.valorFrete = null;
        this.chaveCTeFerroviaOrigem = null;
        this.ferroviasEnvolvidas = null;
    }

    public CTTipoFerrovia getResponsavel() {
        return this.responsavel;
    }

    /**
     * Responsável pelo Faturamento<br>
     * Preencher com:<br>
     * 1-Ferrovia de origem;<br>
     * 2-Ferrovia de destino
     */
    public void setResponsavel(final CTTipoFerrovia responsavel) {
        this.responsavel = responsavel;
    }

    public CTTipoFerrovia getEmitente() {
        return this.emitente;
    }

    /**
     * Responsável pelo Faturamento<br>
     * Preencher com:<br>
     * 1-Ferrovia de origem;<br>
     * 2-Ferrovia de destino
     */
    public void setEmitente(final CTTipoFerrovia emitente) {
        this.emitente = emitente;
    }

    public String getValorFrete() {
        return this.valorFrete;
    }

    /**
     * Valor do Frete do Tráfego Mútuo
     */
    public void setValorFrete(final BigDecimal valorFrete) {
        this.valorFrete = BigDecimalParser.tamanho15Com2CasasDecimais(valorFrete, "Valor do Frete do Tráfego Mútuo");
    }

    public String getChaveCTeFerroviaOrigem() {
        return this.chaveCTeFerroviaOrigem;
    }

    /**
     * Chave de acesso do CT-e emitido pelo ferrovia de origem
     */
    public void setChaveCTeFerroviaOrigem(final String chaveCTeFerroviaOrigem) {
        this.chaveCTeFerroviaOrigem = chaveCTeFerroviaOrigem;
    }

    public List<CTeNotaInfoCTeNormalInfoModalFerroviarioTrafegoMutuoFerroviasEnvolvidas> getFerroviasEnvolvidas() {
        return this.ferroviasEnvolvidas;
    }

    /**
     * Informações das Ferrovias Envolvidas
     */
    public void setFerroviasEnvolvidas(final List<CTeNotaInfoCTeNormalInfoModalFerroviarioTrafegoMutuoFerroviasEnvolvidas> ferroviasEnvolvidas) {
        this.ferroviasEnvolvidas = ferroviasEnvolvidas;
    }
}
