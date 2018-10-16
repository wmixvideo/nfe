package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import java.time.LocalDate;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioVeiculoCondutor;
import com.fincatto.documentofiscal.validadores.StringValidador;
import java.util.List;
import org.simpleframework.xml.ElementList;

/**
 * Created by Edivaldo Merlo Stens on 13/10/18.
 */
@Root(name = " evIncCondutorMDFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFeEnviaEventoIncluirCondutor extends DFBase {

    private static final long serialVersionUID = -6894944230355205786L;

    @Element(name = "descEvento")
    private String descricaoEvento = "Inclusao Condutor";

    @Element(name = "condutor")
    private MDFInfoModalRodoviarioVeiculoCondutor condutor;

    public void setDescricaoEvento(final String descricaoEvento) {
        final String defaultValue = "Inclusao Condutor";
        StringValidador.equals(defaultValue, descricaoEvento);
        this.descricaoEvento = descricaoEvento;
    }

    public String getDescricaoEvento() {
        return this.descricaoEvento;
    }

    public MDFInfoModalRodoviarioVeiculoCondutor getCondutor() {
        return condutor;
    }

    public void setCondutor(MDFInfoModalRodoviarioVeiculoCondutor condutor) {
        this.condutor = condutor;
    }

}
