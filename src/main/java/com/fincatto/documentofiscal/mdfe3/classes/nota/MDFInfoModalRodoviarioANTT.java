package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 * <h1>Grupo de informações para Agência Reguladora</h1>
 */
@Root(name = "infANTT")
public class MDFInfoModalRodoviarioANTT extends DFBase {

    /**
     * <h1>Registro Nacional de Transportadores Rodoviários de Carga</h1>
     * <p>  Registro obrigatório do emitente do MDF-e junto à ANTT
     * para exercer a atividade de transportador rodoviário de cargas
     * por conta de terceiros e mediante remuneração.</p>
     */
    @Element(name = "RNTRC", required = false)
    private String rntrc;
    /**
     * <h1>Dados do CIOT.</h1>
     */
    @ElementList(entry="infCIOT", inline = true, required = false)
    private List<MDFInfoModalRodoviarioInfCIOT> infCIOT;
    /**
     * Informações de Vale Pedágio
     */
    @Element(name="valePed", required = false)
    private MDFInfoModalRodoviarioPedagio valePedagio;

    @ElementList(entry ="infContratante", inline = true, required = false)
    protected List<MDFInfoModalRodoviarioInfContratante> infContratante;

    public String getRntrc() {
        return rntrc;
    }

    public void setRntrc(String rntrc) {
        StringValidador.validador(rntrc, "Registro Nacional de Transportadores Rodoviários de Carga(RNTRC) ", 8, true,true);
        this.rntrc = rntrc;
    }

    public List<MDFInfoModalRodoviarioInfCIOT> getInfCIOT() {
        return infCIOT;
    }

    public void setInfCIOT(List<MDFInfoModalRodoviarioInfCIOT> infCIOT) {
        this.infCIOT = infCIOT;
    }

    public MDFInfoModalRodoviarioPedagio getValePedagio() {
        return valePedagio;
    }

    public void setValePedagio(MDFInfoModalRodoviarioPedagio valePedagio) {
        this.valePedagio = valePedagio;
    }

    public List<MDFInfoModalRodoviarioInfContratante> getInfContratante() {
        return infContratante;
    }

    public void setInfContratante(List<MDFInfoModalRodoviarioInfContratante> infContratante) {
        this.infContratante = infContratante;
    }
}
