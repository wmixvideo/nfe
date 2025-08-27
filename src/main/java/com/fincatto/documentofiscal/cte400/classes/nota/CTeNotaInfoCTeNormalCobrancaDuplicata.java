package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Dados das duplicatas
 */

@Root(name = "dup")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalCobrancaDuplicata extends DFBase {
    private static final long serialVersionUID = -1545662082458268610L;

    @Element(name = "nDup", required = false)
    private String numero;

    @Element(name = "dVenc", required = false)
    private LocalDate dataVencimento;

    @Element(name = "vDup", required = false)
    private String valor;

    public String getNumero() {
        return this.numero;
    }

    /**
     * Número da duplicata
     */
    public void setNumero(final String numero) {
        DFStringValidador.tamanho60(numero, "Número da duplicata");
        this.numero = numero;
    }

    public LocalDate getDataVencimento() {
        return this.dataVencimento;
    }

    /**
     * Data de vencimento da duplicata (AAAA-MM-DD)
     */
    public void setDataVencimento(final LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getValor() {
        return this.valor;
    }

    /**
     * Valor da duplicata
     */
    public void setValor(final BigDecimal valor) {
        this.valor = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valor, "Valor da duplicata");
    }
}
