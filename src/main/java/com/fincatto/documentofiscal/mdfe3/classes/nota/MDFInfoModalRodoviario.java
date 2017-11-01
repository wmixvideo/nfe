package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 *
 * <h1>Informações do modelo rodoviário do MDFe.</h1>
 *
 */
@Root(name = "rodo")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoModalRodoviario extends DFBase {

    /**
     * <h1>Grupo de informações para Agência Reguladora(ANTT).</h1>
     */
    @Element(name = "infANTT", required = false)
    MDFInfoModalRodoviarioANTT mdfInfoModalRodoviarioANTT;



    /**
     * <h1>Dados dos reboques.</h1>
     */
    @ElementList(entry = "veicReboque", inline = true, required = false)
    List<MDFInfoModalRodoviarioVeiculoReboque> veiculoReboques;



}
