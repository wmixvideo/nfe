package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NFNotaInfoItemProdutoDetalhamento extends DFBase {
    private static final long serialVersionUID = 4756407184060968887L;
    
    @Element(name = "cProdFisco")
    private String codigoFiscalProduto;
    
    @Element(name = "cOperNFF")
    private String codigoOperacaoNFF;

    public String getCodigoFiscalProduto() {
        return codigoFiscalProduto;
    }

    public void setCodigoFiscalProduto(String codigoFiscalProduto) {
        this.codigoFiscalProduto = codigoFiscalProduto;
    }

    public String getCodigoOperacaoNFF() {
        return codigoOperacaoNFF;
    }

    public void setCodigoOperacaoNFF(String codigoOperacaoNFF) {
        this.codigoOperacaoNFF = codigoOperacaoNFF;
    }
}