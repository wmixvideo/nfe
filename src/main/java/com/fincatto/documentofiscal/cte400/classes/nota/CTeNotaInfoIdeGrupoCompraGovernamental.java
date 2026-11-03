package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte400.classes.CTTipoEntidadeGovernamental;
import com.fincatto.documentofiscal.cte400.classes.CTTipoOperacaoGovernamental;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.List;

@Root(name = "gCompraGov")
public class CTeNotaInfoIdeGrupoCompraGovernamental extends DFBase {

    @Element(required = true, name = "tpEnteGov")
    private CTTipoEntidadeGovernamental tipoEntidadeGovernamental;

    @Element(required = true, name = "pRedutor")
    private String percentualRedutor;

    @Element(required = true, name = "tpOperGov")
    private CTTipoOperacaoGovernamental tipoOperacaoGovernamental;

    @ElementList(required = false, inline = true, entry = "refDFeAnt")
    private List<String> documentosAnteriores;

    public CTTipoEntidadeGovernamental getTipoEntidadeGovernamental() {
        return tipoEntidadeGovernamental;
    }

    public void setTipoEntidadeGovernamental(CTTipoEntidadeGovernamental tipoEntidadeGovernamental) {
        this.tipoEntidadeGovernamental = tipoEntidadeGovernamental;
    }

    public String getPercentualRedutor() {
        return percentualRedutor;
    }

    public void setPercentualRedutor(BigDecimal percentualRedutor) {
        this.percentualRedutor = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualRedutor, "Percentual Redutor");;
    }

    public CTTipoOperacaoGovernamental getTipoOperacaoGovernamental() {
        return tipoOperacaoGovernamental;
    }

    public void setTipoOperacaoGovernamental(CTTipoOperacaoGovernamental tipoOperacaoGovernamental) {
        this.tipoOperacaoGovernamental = tipoOperacaoGovernamental;
    }

    public List<String> getDocumentosAnteriores() {
        return documentosAnteriores;
    }

    public void setDocumentosAnteriores(List<String> documentosAnteriores) {
        this.documentosAnteriores = documentosAnteriores;
    }
}
