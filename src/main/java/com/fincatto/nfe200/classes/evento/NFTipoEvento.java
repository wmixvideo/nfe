package com.fincatto.nfe200.classes.evento;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.validadores.BigDecimalParser;
import com.fincatto.nfe200.validadores.StringValidador;

public class NFTipoEvento extends NFBase {
    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "descEvento", required = true)
    private String descricaoEvento;

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao);
    }

    public void setDescricaoEvento(final String descricaoEvento) {
        StringValidador.tamanho5a60(descricaoEvento);
        this.descricaoEvento = descricaoEvento;
    }

    public String getDescricaoEvento() {
        return this.descricaoEvento;
    }

    public String getVersao() {
        return this.versao;
    }
}