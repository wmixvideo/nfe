package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.LocalDate;

@Root(name = "fat")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoCobrancaDuplicata extends DFBase {
    private static final long serialVersionUID = 5321172274976502832L;

    @Element(name = "nDup", required = false)
    private String numeroDuplicata;

    @Element(name = "dVenc", required = false)
    private LocalDate dataVencimento;

    @Element(name = "vDup", required = false)
    private String valorDuplicata;

    public String getNumeroDuplicata() {
        return numeroDuplicata;
    }

    public void setNumeroDuplicata(final String numeroDuplicata) {
        DFStringValidador.tamanho60(numeroDuplicata, "Numero da Duplicata");
        this.numeroDuplicata = numeroDuplicata;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(final LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getValorDuplicata() {
        return valorDuplicata;
    }

    public void setValorDuplicata(final BigDecimal valorDuplicata) {
        this.valorDuplicata = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorDuplicata, "Valor Duplicata");
    }
}
