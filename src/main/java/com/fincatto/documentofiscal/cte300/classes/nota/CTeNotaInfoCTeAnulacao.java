package com.fincatto.documentofiscal.cte300.classes.nota;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Detalhamento do CT-e do tipo Anulação
 */

@Root(name = "infCteAnu")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeAnulacao extends DFBase {
    private static final long serialVersionUID = -8393627804759742007L;

    @Element(name = "chCte", required = true)
    private String chave;

    @Element(name = "dEmi", required = true)
    private LocalDate dataEmissao;

    public CTeNotaInfoCTeAnulacao() {
        this.chave = null;
        this.dataEmissao = null;
    }

    public String getChave() {
        return this.chave;
    }

    /**
     * Chave de acesso do CT-e original a ser anulado e substituído
     */
    public void setChave(final String chave) {
        StringValidador.exatamente44N(chave, "Chave de acesso do CT-e original a ser anulado e substituído");
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
