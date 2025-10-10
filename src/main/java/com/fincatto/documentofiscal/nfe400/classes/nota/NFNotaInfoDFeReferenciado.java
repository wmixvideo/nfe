package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

/**
 * VC01
 *
 * @author Edivaldo Merlo Stens
 */
public class NFNotaInfoDFeReferenciado extends DFBase {

    private static final long serialVersionUID = -2776137091542174568L;

    @Element(required = true)
    private String chaveAcesso; // VC02

    @Element(required = false)
    private Integer nItem; // VC03

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
