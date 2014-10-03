package com.fincatto.nfe.classes.cartacorrecao;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;
import com.fincatto.nfe.validadores.StringValidador;

public class NFInfoCartaCorrecao extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "descEvento", required = true)
    private String descricaoEvento;

    @Element(name = "xCorrecao", required = true)
    private String correcao;

    @Element(name = "xCondUso", required = true)
    private String condicaoDeUso;

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao);
    }

    public void setCondicaoDeUso(final String condicaoDeUso) {
        this.condicaoDeUso = condicaoDeUso;
    }

    public void setCorrecao(final String correcao) {
        StringValidador.tamanho15a1000(correcao);
        this.correcao = correcao;
    }

    public void setDescricaoEvento(final String descricaoEvento) {
        StringValidador.tamanho5a60(descricaoEvento);
        this.descricaoEvento = descricaoEvento;
    }
}