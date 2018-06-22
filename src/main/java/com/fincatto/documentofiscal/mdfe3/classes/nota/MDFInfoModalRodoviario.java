package com.fincatto.documentofiscal.mdfe3.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.ListValidador;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 * <h1>Informações do modelo rodoviário do MDFe.</h1>
 */
@Root(name = "rodo")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoModalRodoviario extends DFBase {
    private static final long serialVersionUID = -1288630934217810661L;

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
     * <h1>Código de Agendamento no porto.</h1>
     */
    @Element(name = "codAgPorto", required = false)
    private String codAgPorto;

    /**
     * <h1>Lacres</h1>
     */
    @ElementList(entry = "lacRodo", inline = true, required = false)
    private List<MDFInfoLacre1A20> lacres;

    public MDFInfoModalRodoviarioANTT getMdfInfoModalRodoviarioANTT() {
        return this.mdfInfoModalRodoviarioANTT;
    }

    public void setMdfInfoModalRodoviarioANTT(final MDFInfoModalRodoviarioANTT mdfInfoModalRodoviarioANTT) {
        this.mdfInfoModalRodoviarioANTT = mdfInfoModalRodoviarioANTT;
    }

    public MDFInfoModalRodoviarioVeiculoTracao getVeiculoTracao() {
        return this.veiculoTracao;
    }

    public void setVeiculoTracao(final MDFInfoModalRodoviarioVeiculoTracao veiculoTracao) {
        this.veiculoTracao = veiculoTracao;
    }

    public List<MDFInfoModalRodoviarioVeiculoReboque> getVeiculoReboques() {
        return this.veiculoReboques;
    }

    public void setVeiculoReboques(final List<MDFInfoModalRodoviarioVeiculoReboque> veiculoReboques) {
        this.veiculoReboques = ListValidador.validaListaNaoObrigatoria(veiculoReboques, 3, "Lista de reboques");
    }

    public String getCodAgPorto() {
        return this.codAgPorto;
    }

    public void setCodAgPorto(final String codAgPorto) {
        this.codAgPorto = codAgPorto;
    }

    public List<MDFInfoLacre1A20> getLacres() {
        return this.lacres;
    }

    public void setLacres(final List<MDFInfoLacre1A20> lacres) {
        this.lacres = lacres;
    }
}
