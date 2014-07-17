package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMS40 extends NFBase {
    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private String codigoSituacaoTributaria;

    @Element(name = "vICMS", required = false)
    private BigDecimal valorICMS;

    @Element(name = "motDesICMS", required = false)
    private NFNotaMotivoDesoneracaoICMS motivoDesoneracaoICMS;

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public String getCodigoSituacaoTributaria() {
        return this.codigoSituacaoTributaria;
    }

    public void setCodigoSituacaoTributaria(final String codigoSituacaoTributaria) {
        this.codigoSituacaoTributaria = codigoSituacaoTributaria;
    }

    public BigDecimal getValorICMS() {
        return this.valorICMS;
    }

    public void setValorICMS(final BigDecimal valorICMS) {
        this.valorICMS = valorICMS;
    }

    public NFNotaMotivoDesoneracaoICMS getMotivoDesoneracaoICMS() {
        return this.motivoDesoneracaoICMS;
    }

    public void setMotivoDesoneracaoICMS(final NFNotaMotivoDesoneracaoICMS motivoDesoneracaoICMS) {
        this.motivoDesoneracaoICMS = motivoDesoneracaoICMS;
    }
}