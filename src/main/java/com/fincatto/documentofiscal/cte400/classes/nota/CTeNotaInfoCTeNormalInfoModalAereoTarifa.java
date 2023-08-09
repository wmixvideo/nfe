package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTClasseTarifa;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Informações de tarifa
 */

@Root(name = "tarifa")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalAereoTarifa extends DFBase {
    private static final long serialVersionUID = 6204216175263115810L;

    @Element(name = "CL")
    private CTClasseTarifa classe;

    @Element(name = "cTar", required = false)
    private String codigo;
    
    @Element(name = "vTar")
    private String valor;

    public CTClasseTarifa getClasse() {
        return this.classe;
    }

    /**
     * Classe<br>
     * M - Tarifa Mínima;<br>
     * G - Tarifa Geral;<br>
     * E - Tarifa Específica
     */
    public void setClasse(final CTClasseTarifa classe) {
        this.classe = classe;
    }

    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Código da Tarifa<br>
     * Deverão ser incluídos os códigos de três dígitos, correspondentes à tarifa.
     */
    public void setCodigo(final String codigo) {
        DFStringValidador.tamanho4(codigo, "Código da Tarifa");
        this.codigo = codigo;
    }

    public String getValor() {
        return this.valor;
    }

    /**
     * Valor da Tarifa<br>
     * Valor da tarifa por kg quando for o caso.
     */
    public void setValor(final BigDecimal valor) {
        this.valor = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valor, "Valor da Tarifa");
    }
}
