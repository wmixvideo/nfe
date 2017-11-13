package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.ListValidador;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 *
 * <h1>Informações de Vale Pedágio.</h1>
 * <p>Outras informações sobre Vale-Pedágio obrigatório que não tenham campos específicos
 * devem ser informadas no campo de observações gerais de uso livre pelo contribuinte,
 * visando atender as determinações legais vigentes.</p>
 *
 */
@Root(name = "valePed")
public class MDFInfoModalRodoviarioPedagio extends DFBase {

    /**
     * Lista de dispositivos do Vale Pedágio.
     */
    @ElementList(entry = "disp", inline = true)
    private List<MDFInfoModalRodoviarioPedagioDisp> dispositivos;

    public List<MDFInfoModalRodoviarioPedagioDisp> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<MDFInfoModalRodoviarioPedagioDisp> dispositivos) {
        this.dispositivos = ListValidador.validaListaObrigatoria(dispositivos, "Dispositivos do Vale Pedagio");
    }
}
