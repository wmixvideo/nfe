package com.fincatto.documentofiscal.nfe400.classes.evento.consumopessoal;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

public class NFDetGrupoDfeReferenciado extends DFBase {

    @Element
    private String chaveAcesso;

    @Element
    private Integer nItem;

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        DFStringValidador.exatamente44N(chaveAcesso, "Chave de Acesso");
        this.chaveAcesso = chaveAcesso;
    }

    public Integer getNItem() {
        return nItem;
    }

    public void setNItem(Integer nItem) {
        this.nItem = nItem;
    }

}
