package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "fat")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoCobrancaFatura extends DFBase {
    private static final long serialVersionUID = 4430617027634028923L;

    @Element(name = "nFat", required = false)
    private String numeroFatura;

    @Element(name = "vOrig", required = false)
    private String valorOriginal;

    @Element(name = "vDesc", required = false)
    private String valorDesconto;

    @Element(name = "vLiq", required = false)
    private String valorLiquido;

    public String getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(final String numeroFatura) {
        DFStringValidador.tamanho60(numeroFatura, "Numero da Fatura");
        this.numeroFatura = numeroFatura;
    }

    public String getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(final BigDecimal valorOriginal) {
        this.valorOriginal = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorOriginal, "Valor Original");
    }

    public String getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(final BigDecimal valorDesconto) {
        this.valorDesconto = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorDesconto, "Valor Desconto");
    }

    public String getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(final BigDecimal valorLiquido) {
        this.valorLiquido = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorLiquido, "Valor Liquido");
    }
}
