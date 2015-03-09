package com.fincatto.nfe310.classes.evento;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;
import com.fincatto.nfe310.validadores.StringValidador;

@Root(strict = false)
public class NFTipoEvento extends NFBase {
    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "descEvento", required = true)
    private String descricaoEvento;

    // Carta correcao
    @Element(name = "xCorrecao", required = false)
    private String textoCorrecao;;

    @Element(name = "xCondUso", required = false)
    private String condicaoUso;

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

    public void setCondicaoUso(final String condicaoUso) {
        this.condicaoUso = condicaoUso;
    }

    public void setTextoCorrecao(final String textoCorrecao) {
        this.textoCorrecao = textoCorrecao;
    }

    public String getCondicaoUso() {
        return this.condicaoUso;
    }

    public String getTextoCorrecao() {
        return this.textoCorrecao;
    }
}