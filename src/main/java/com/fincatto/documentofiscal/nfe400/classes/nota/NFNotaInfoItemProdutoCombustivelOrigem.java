package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoCombustivelOrigem extends DFBase {
    private static final long serialVersionUID = 434158175698173797L;

    @Element(name = "indImport")
    private NFIndicadorImportacao indicadorImportacao;

    @Element(name = "cUFOrig")
    private String uf;

    @Element(name = "pOrig")
    private String percentualOriginario;

    public void setIndicadorImportacao(NFIndicadorImportacao indicadorImportacao) {
        this.indicadorImportacao = indicadorImportacao;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf.getCodigoIbge();
    }

    public void setPercentualOriginario(BigDecimal percentualOriginario) {
        this.percentualOriginario = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualOriginario, "Percentual originário para a UF");
    }

    public NFIndicadorImportacao getIndicadorImportacao() {
        return this.indicadorImportacao;
    }

    public String getUf() {
        return this.uf;
    }

    public String getPercentualOriginario() {
        return this.percentualOriginario;
    }
}
