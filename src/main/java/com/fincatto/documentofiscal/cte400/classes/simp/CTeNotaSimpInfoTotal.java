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

    @Element(name = "vTPrestLiq", required = false)
    private String vTPrestLiq;

    @Element(name = "vTRec")
    private String vTRec;

    @Element(name = "IBSCBSTot", required = false)
    private CTeNotaSimpInfoTotalIBSCBS ibsCbsTot;

    @Element(name = "vTotDFe", required = false)
    private String vTotDFe;

    public String getVTPrest() {
        return this.vTPrest;
    }

    /**
     * Valor Total da Prestação do Serviço
     */
    public void setVTPrest(final BigDecimal vTPrest) {
        this.vTPrest = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vTPrest, "Valor Total da Prestacao do Servico");
    }

    public String getVTPrestLiq() {
        return this.vTPrestLiq;
    }

    /**
     * Valor Total Líquido da Prestação do Serviço, sem tributos (NT 2026.004)
     */
    public void setVTPrestLiq(final BigDecimal vTPrestLiq) {
        this.vTPrestLiq = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vTPrestLiq, "Valor Total Liquido da Prestacao do Servico");
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

    public CTeNotaSimpInfoTotalIBSCBS getIbsCbsTot() {
        return this.ibsCbsTot;
    }

    /**
     * Totais do IBS e da CBS (NT 2026.004)
     */
    public void setIbsCbsTot(final CTeNotaSimpInfoTotalIBSCBS ibsCbsTot) {
        this.ibsCbsTot = ibsCbsTot;
    }

    public String getVTotDFe() {
        return this.vTotDFe;
    }

    /**
     * Valor total do documento fiscal
     */
    public void setVTotDFe(final BigDecimal vTotDFe) {
        this.vTotDFe = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTotDFe, "Valor total do documento fiscal");
    }
}
