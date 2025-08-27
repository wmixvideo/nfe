package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.LocalDate;

@Root(name = "infCteAnu")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeAnulacao extends DFBase {
    private static final long serialVersionUID = 3248640412163502446L;

    @Element(name = "chCte")
    private String chave;
    
    @Element(name = "dEmi")
    private LocalDate dataEmissao;

    public String getChave() {
        return this.chave;
    }

    /**
     * Chave de acesso do CT-e original a ser anulado e substituído
     */
    public void setChave(final String chave) {
        DFStringValidador.exatamente44N(chave, "Chave de acesso do CT-e original a ser anulado e substituído");
        this.chave = chave;
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    /**
     * Data de emissão da declaração do tomador não contribuinte do ICMS
     */
    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
