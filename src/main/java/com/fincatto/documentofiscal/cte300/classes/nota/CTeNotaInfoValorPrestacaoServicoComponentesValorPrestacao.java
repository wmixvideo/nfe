package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * @author Caio
 * @info Componentes do Valor da Prestação
 */

@Root(name = "Comp")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoValorPrestacaoServicoComponentesValorPrestacao extends DFBase {
    private static final long serialVersionUID = -8330894109802841158L;
    
    @Element(name = "xNome")
    private String nomeComponente;
    
    @Element(name = "vComp")
    private String valorComponente;

    public CTeNotaInfoValorPrestacaoServicoComponentesValorPrestacao() {
        this.nomeComponente = null;
        this.valorComponente = null;
    }

    public String getNomeComponente() {
        return this.nomeComponente;
    }

    /**
     * Nome do componente<br>
     * Exemplos: FRETE PESO, FRETE VALOR, SEC/CAT, ADEME, AGENDAMENTO, etc
     */
    public void setNomeComponente(final String nomeComponente) {
        DFStringValidador.tamanho15(nomeComponente, "Nome do componente");
        this.nomeComponente = nomeComponente;
    }

    public String getValorComponente() {
        return this.valorComponente;
    }

    /**
     * Valor do componente
     */
    public void setValorComponente(final BigDecimal valorComponente) {
        this.valorComponente = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorComponente, "Valor do componente");
    }
}
