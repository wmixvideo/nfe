package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemProdutoArmamentoTipo;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

public class NFNotaInfoItemProdutoArmamento extends DFBase {
    private static final long serialVersionUID = -4438932795183476289L;
    
    @Element(name = "tpArma")
    private NFNotaInfoItemProdutoArmamentoTipo tipo;
    
    @Element(name = "nSerie")
    private String numeroSerieArma;
    
    @Element(name = "nCano")
    private String numeroSerieCano;
    
    @Element(name = "descr")
    private String descricao;

    public void setTipo(final NFNotaInfoItemProdutoArmamentoTipo tipo) {
        this.tipo = tipo;
    }

    public void setNumeroSerieArma(final String numeroSerieArma) {
        DFStringValidador.tamanho15(numeroSerieArma, "Numero Serie Arma Armamento");
        this.numeroSerieArma = numeroSerieArma;
    }

    public void setNumeroSerieCano(final String numeroSerieCano) {
        DFStringValidador.tamanho15(numeroSerieCano, "Numero Serie Cano Armamento");
        this.numeroSerieCano = numeroSerieCano;
    }

    public void setDescricao(final String descricao) {
        DFStringValidador.tamanho256(descricao, "Descricao Armamento");
        this.descricao = descricao;
    }

    public NFNotaInfoItemProdutoArmamentoTipo getTipo() {
        return this.tipo;
    }

    public String getNumeroSerieArma() {
        return this.numeroSerieArma;
    }

    public String getNumeroSerieCano() {
        return this.numeroSerieCano;
    }

    public String getDescricao() {
        return this.descricao;
    }
}