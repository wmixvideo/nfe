package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFNotaInfoSituacaoTributariaCOFINS;
import com.fincatto.nfe.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoCOFINSAliquota extends NFBase {

    @Element(name = "CST", required = true)
    private String codigoSituacaoTributaria;

    @Element(name = "vBC", required = true)
    private String valorBaseCalulo;

    @Element(name = "pCOFINS", required = true)
    private String percentualAliquota;

    @Element(name = "vCOFINS", required = true)
    private String valor;

    public NFNotaInfoItemImpostoCOFINSAliquota() {
        this.codigoSituacaoTributaria = null;
        this.valorBaseCalulo = null;
        this.percentualAliquota = null;
        this.valor = null;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria) {
        if (!NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_TRIBUTAVEL_CUMULATIVO_NAO_CUMULATIVO.equals(situacaoTributaria) && !NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_TRIBUTAVEL_ALIQUOTA_DIFERENCIADA.equals(situacaoTributaria)) {
            throw new IllegalStateException("Situacao tributaria invalido");
        }

        this.codigoSituacaoTributaria = situacaoTributaria.getCodigo();
    }

    public void setValorBaseCalulo(final BigDecimal valorBaseCalulo) {
        this.valorBaseCalulo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalulo);
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquota);
    }

    public void setValor(final BigDecimal valor) {
        this.valor = BigDecimalParser.tamanho15Com2CasasDecimais(valor);
    }
}