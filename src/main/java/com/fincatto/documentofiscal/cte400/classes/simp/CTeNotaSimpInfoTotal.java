package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Valores Totais do CT-e Simplificado (grupo total)
 */
@Root(name = "total")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimpInfoTotal extends DFBase {
    private static final long serialVersionUID = 1L;

    @Element(name = "vTPrest")
    private String vTPrest;

    @Element(name = "vTRec")
    private String vTRec;

    public String getVTPrest() {
        return this.vTPrest;
    }

    /**
     * Valor Total da Prestação do Serviço
     */
    public void setVTPrest(final BigDecimal vTPrest) {
        this.vTPrest = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vTPrest, "Valor Total da Prestacao do Servico");
    }

    public String getVTRec() {
        return this.vTRec;
    }

    /**
     * Valor total a Receber
     */
    public void setVTRec(final BigDecimal vTRec) {
        this.vTRec = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vTRec, "Valor Total a Receber");
    }
}
