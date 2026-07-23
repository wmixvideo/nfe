package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Componentes do Valor da Prestação (CT-e Simplificado - grupo det)
 */
@Root(name = "Comp")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimpInfoDetComp extends DFBase {
    private static final long serialVersionUID = 1L;

    @Element(name = "xNome")
    private String xNome;

    @Element(name = "vComp")
    private String vComp;

    public String getXNome() {
        return this.xNome;
    }

    /**
     * Nome do componente<br>
     * Exemplos: FRETE PESO, FRETE VALOR, SEC/CAT, ADEME, AGENDAMENTO, etc
     */
    public void setXNome(final String xNome) {
        DFStringValidador.tamanho15(xNome, "Nome do componente");
        this.xNome = xNome;
    }

    public String getVComp() {
        return this.vComp;
    }

    /**
     * Valor do componente
     */
    public void setVComp(final BigDecimal vComp) {
        this.vComp = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vComp, "Valor do componente");
    }
}
