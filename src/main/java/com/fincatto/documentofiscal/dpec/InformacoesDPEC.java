package com.fincatto.documentofiscal.dpec;


import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.ListValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Eldevan Nery Junior on 15/01/19.
 *
 * Informações da Declaração Prévia de Emissão em Contingência.
 */
@Root(name = "InfDPEC")
public class InformacoesDPEC  extends DFBase {

    @Attribute(name = "Id")
    private String id;

    @Element
    private IdentificacaoDeclarante ideDec;
    /**
     * Resumo das NF-e emitidas  no Sistema de Contingência Eletrônica (até 50 NF-e com tpEmiss = "4")
     */
    @Element
    private List<ResumoContigenciaNFe> resNFe;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IdentificacaoDeclarante getIdeDec() {
        return ideDec;
    }

    public void setIdeDec(IdentificacaoDeclarante ideDec) {
        this.ideDec = ideDec;
    }

    public List<ResumoContigenciaNFe> getResNFe() {
        return resNFe;
    }

    public void setResNFe(List<ResumoContigenciaNFe> resNFe) {
        this.resNFe = ListValidador.validaListaObrigatoria(resNFe, 50, "Lista com o Resumo das NF-e emitidas");
    }
}