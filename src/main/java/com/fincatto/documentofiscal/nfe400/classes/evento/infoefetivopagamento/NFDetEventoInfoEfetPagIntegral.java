package com.fincatto.documentofiscal.nfe400.classes.evento.infoefetivopagamento;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFDetEvento;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "detEvento")
public class NFDetEventoInfoEfetPagIntegral extends NFDetEvento {

    @Element(name = "indQuitacao")
    private int indicadorQuitacao;

    public int getIndicadorQuitacao() {
        return indicadorQuitacao;
    }

    public void setIndicadorQuitacao(int indicadorQuitacao) {
        DFIntegerValidador.valor1(indicadorQuitacao,"Indicador de Quitacao");
        this.indicadorQuitacao = indicadorQuitacao;
    }
}
