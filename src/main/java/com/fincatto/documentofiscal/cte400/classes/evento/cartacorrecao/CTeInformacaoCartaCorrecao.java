package com.fincatto.documentofiscal.cte400.classes.evento.cartacorrecao;

import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "infCorrecao")
public class CTeInformacaoCartaCorrecao {
    @Element(name = "grupoAlterado")
    private String grupoAlterado;

    @Element(name = "campoAlterado")
    private String campoAlterado;

    @Element(name = "valorAlterado")
    private String valorAlterado;

    @Element(name = "nroItemAlterado", required = false)
    private Integer numeroItemAlterado;

    public String getGrupoAlterado() {
        return grupoAlterado;
    }

    public void setGrupoAlterado(String grupoAlterado) {
        DFStringValidador.tamanho20(grupoAlterado, "Grupo Alterado");
        this.grupoAlterado = grupoAlterado;
    }

    public String getCampoAlterado() {
        return campoAlterado;
    }

    public void setCampoAlterado(String campoAlterado) {
        DFStringValidador.tamanho20(grupoAlterado, "Campo Alterado");
        this.campoAlterado = campoAlterado;
    }

    public String getValorAlterado() {
        return valorAlterado;
    }

    public void setValorAlterado(String valorAlterado) {
        DFStringValidador.tamanho500(grupoAlterado, "Valor Alterado");
        this.valorAlterado = valorAlterado;
    }

    public Integer getNumeroItemAlterado() {
        return numeroItemAlterado;
    }

    public void setNumeroItemAlterado(Integer numeroItemAlterado) {
        this.numeroItemAlterado = numeroItemAlterado;
    }
}
