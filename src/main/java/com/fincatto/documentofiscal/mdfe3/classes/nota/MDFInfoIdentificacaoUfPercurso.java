package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

/**
 * Created by Eldevan Nery Junior on 06/11/17. Informações do Percurso do MDF-e
 */
public class MDFInfoIdentificacaoUfPercurso extends DFBase {
    private static final long serialVersionUID = 212116102866608942L;
    /**
     * Sigla das Unidades da Federação do percurso do veículo. Não é necessário repetir as UF de Início e Fim.
     */
    @Element(name = "UFPer")
    private String ufPercurso;

    public MDFInfoIdentificacaoUfPercurso() {
    }

    public MDFInfoIdentificacaoUfPercurso(final DFUnidadeFederativa ufPercurso) {
        this.ufPercurso = ufPercurso.getCodigo();
    }

    public String getUfPercurso() {
        return this.ufPercurso;
    }

    public void setUfPercurso(final String ufPercurso) {
        this.ufPercurso = ufPercurso;
    }

    public void setUfPercurso(final DFUnidadeFederativa ufPercurso) {
        this.ufPercurso = ufPercurso.getCodigo();
    }
}
