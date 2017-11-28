package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 */
@Root(name = "infModal")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoModal extends DFBase {

    @Attribute(name = "versaoModal")
    private String versao;

    @Element(name = "rodo", required = false)
    private MDFInfoModalRodoviario rodoviario;

   //TODO terminar as modalidades abaixo
//    @Element(name = "aereo", required = false)
//    private MDFInfoModalModalAereo aereo;

//    @Element(name = "aquav", required = false)
//    private MDFInfoModalModalAquaviario aquaviario;

//    @Element(name = "ferrov", required = false)
//    private MDFInfoModalModalFerroviario ferroviario;


    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public MDFInfoModalRodoviario getRodoviario() {
        return rodoviario;
    }

    public void setRodoviario(MDFInfoModalRodoviario rodoviario) {
        this.rodoviario = rodoviario;
    }
}
