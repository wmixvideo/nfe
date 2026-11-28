package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import java.util.List;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFTipoEvento;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "detEvento")
public class NFDetEventoEconf extends NFTipoEvento {
    private static final long serialVersionUID = 7305419628841935027L;

    @Element(name = "verAplic")
    private String versaoAplicativo;

    @ElementList(entry = "detPag", inline = true)
    private List<NFDetPagEconf> pagamentos;

    public String getVersaoAplicativo() {
        return this.versaoAplicativo;
    }

    public void setVersaoAplicativo(final String versaoAplicativo) {
        DFStringValidador.tamanho20(versaoAplicativo, "Versao Aplicativo");
        this.versaoAplicativo = versaoAplicativo;
    }

    public List<NFDetPagEconf> getPagamentos() {
        return this.pagamentos;
    }

    public void setPagamentos(final List<NFDetPagEconf> pagamentos) {
        this.pagamentos = DFListValidador.validaListaObrigatoria(pagamentos, 100, "Pagamentos do ECONF");
    }
}
