package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.ListValidador;
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
    private MDFInfoModalRodoviarioANTT mdfInfoModalRodoviarioANTT;

    /**
     * <h1>Dados do Veículo com a Tração.</h1>
     */
    @Element(name = "veicTracao")
    private MDFInfoModalRodoviarioVeiculoTracao veiculoTracao;

    /**
     * <h1>Dados dos reboques.</h1>
     */
    @ElementList(entry = "veicReboque", inline = true, required = false)
    private List<MDFInfoModalRodoviarioVeiculoReboque> veiculoReboques;


    /**
     * <h1> Código de Agendamento no porto.</h1>
     */
    @Element(name = "codAgPorto" , required = false)
    private String codAgPorto;

    /**
     * <h1>Lacres</h1>
     */
    @ElementList(entry = "lacRodo", inline = true, required = false)
    private List<MDFInfoLacre1A20> lacres;

    public MDFInfoModalRodoviarioANTT getMdfInfoModalRodoviarioANTT() {
        return mdfInfoModalRodoviarioANTT;
    }

    public void setMdfInfoModalRodoviarioANTT(MDFInfoModalRodoviarioANTT mdfInfoModalRodoviarioANTT) {
        this.mdfInfoModalRodoviarioANTT = mdfInfoModalRodoviarioANTT;
    }

    public MDFInfoModalRodoviarioVeiculoTracao getVeiculoTracao() {
        return veiculoTracao;
    }

    public void setVeiculoTracao(MDFInfoModalRodoviarioVeiculoTracao veiculoTracao) {
        this.veiculoTracao = veiculoTracao;
    }

    public List<MDFInfoModalRodoviarioVeiculoReboque> getVeiculoReboques() {
        return veiculoReboques;
    }

    public void setVeiculoReboques(List<MDFInfoModalRodoviarioVeiculoReboque> veiculoReboques) {
        this.veiculoReboques = ListValidador.validaListaNaoObrigatoria(veiculoReboques, 3, "Lista de reboques");
    }

    public String getCodAgPorto() {
        return codAgPorto;
    }

    public void setCodAgPorto(String codAgPorto) {
        this.codAgPorto = codAgPorto;
    }

    public List<MDFInfoLacre1A20> getLacres() {
        return lacres;
    }

    public void setLacres(List<MDFInfoLacre1A20> lacres) {
        this.lacres = lacres;
    }
}
