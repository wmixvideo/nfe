package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.List;

@Root(name = "vPrest")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoValorPrestacaoServico extends DFBase {
    private static final long serialVersionUID = -5913703822180633261L;
    
    @Element(name = "vTPrest")
    private String valorTotalPrestacaoServico;
    
    @Element(name = "vRec")
    private String valorReceber;

    @ElementList(name = "Comp", inline = true, required = false)
    private List<CTeOSInfoValorPrestacaoServicoComponentesValorPrestacao> componentesValorPrestacao;

    public String getValorTotalPrestacaoServico() {
        return this.valorTotalPrestacaoServico;
    }

    /**
     * Valor Total da Prestação do Serviço<br>
     * Pode conter zeros quando o CT-e for de complemento de ICMS
     */
    public void setValorTotalPrestacaoServico(final BigDecimal valorTotalPrestacaoServico) {
        this.valorTotalPrestacaoServico = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalPrestacaoServico, "Valor Total da Prestação do Serviço");
    }

    public String getValorReceber() {
        return this.valorReceber;
    }

    /**
     * Valor a Receber
     */
    public void setValorReceber(final BigDecimal valorReceber) {
        this.valorReceber = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorReceber, "Valor a Receber");
    }

    public List<CTeOSInfoValorPrestacaoServicoComponentesValorPrestacao> getComponentesValorPrestacao() {
        return this.componentesValorPrestacao;
    }

    /**
     * Componentes do Valor da Prestação
     */
    public void setComponentesValorPrestacao(final List<CTeOSInfoValorPrestacaoServicoComponentesValorPrestacao> componentesValorPrestacao) {
        this.componentesValorPrestacao = componentesValorPrestacao;
    }
}
