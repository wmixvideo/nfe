package com.fincatto.documentofiscal.cte400.classes.evento.desacordo;

import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeTipoEvento;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "evPrestDesacordo")
@Namespace(reference = CTeConfig.NAMESPACE)
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