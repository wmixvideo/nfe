package com.fincatto.documentofiscal.cte300.classes.evento.desacordo;

import com.fincatto.documentofiscal.cte300.classes.evento.CTeTipoEvento;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

public class CTeEnviaEventoPrestacaoEmDesacordo extends CTeTipoEvento {
    private static final long serialVersionUID = -7261255586164368554L;

    @Element(name = "indDesacordoOper")
    private int indicadorPrestacaoEmDesacordo;

    @Element(name = "xObs")
    private String observacao;

    public int getIndicadorPrestacaoEmDesacordo() {
        return indicadorPrestacaoEmDesacordo;
    }

    public void setIndicadorPrestacaoEmDesacordo(int indicadorPrestacaoEmDesacordo) {
        this.indicadorPrestacaoEmDesacordo = indicadorPrestacaoEmDesacordo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        DFStringValidador.tamanho15a256(observacao, "Observacao");
        this.observacao = observacao;
    }
}