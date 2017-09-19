package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigInteger;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.validadores.BigIntegerValidador;

public class NFNotaInfoItemDetalheExportacao extends DFBase {

    @Element(name = "nDraw", required = false)
    private BigInteger atoConcessorioDrawback;

    @Element(name = "exportInd", required = false)
    private NFNotaInfoItemExportacaoIndireta exportacaoIndireta;

    public void setNumeroAtoConcessorioDrawback(final BigInteger numeroAtoConcessorioDrawback) {
        BigIntegerValidador.tamanho11(numeroAtoConcessorioDrawback, "Numero Ato Concessorio");
        this.atoConcessorioDrawback = numeroAtoConcessorioDrawback;
    }

    public void setExportacaoIndireta(final NFNotaInfoItemExportacaoIndireta exportacaoIndireta) {
        this.exportacaoIndireta = exportacaoIndireta;
    }

    public BigInteger getAtoConcessorioDrawback() {
        return this.atoConcessorioDrawback;
    }

    public NFNotaInfoItemExportacaoIndireta getExportacaoIndireta() {
        return this.exportacaoIndireta;
    }
}