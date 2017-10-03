package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Componentes do Valor da Prestação
 */

@Root(name = "Comp")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoValorPrestacaoServicoComponentesValorPrestacao extends DFBase {
    private static final long serialVersionUID = -8330894109802841158L;

    @Element(name = "xNome", required = true)
    private String nomeComponente;

    @Element(name = "vComp", required = true)
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
        StringValidador.tamanho15(nomeComponente, "Nome do componente");
        this.nomeComponente = nomeComponente;
    }

    public String getValorComponente() {
        return this.valorComponente;
    }

    /**
     * Valor do componente
     */
    public void setValorComponente(final BigDecimal valorComponente) {
        this.valorComponente = BigDecimalParser.tamanho15Com2CasasDecimais(valorComponente, "Valor do componente");
    }
}
