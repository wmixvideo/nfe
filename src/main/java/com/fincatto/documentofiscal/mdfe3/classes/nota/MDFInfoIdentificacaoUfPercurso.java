package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.simpleframework.xml.Element;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
 *
 * Informações do Percurso do MDF-e
 *
 */
public class MDFInfoIdentificacaoUfPercurso extends DFBase{

    /**
     * Sigla das Unidades da Federação do percurso do veículo.
     * Não é necessário repetir as UF de Início e Fim.
     */
    @Element(name = "UFPer")
    private String ufPercurso;

    public MDFInfoIdentificacaoUfPercurso() {
    }

    public MDFInfoIdentificacaoUfPercurso(DFUnidadeFederativa ufPercurso) {
        this.ufPercurso = ufPercurso.getCodigo();
    }

    public String getUfPercurso() {
        return ufPercurso;
    }

    public void setUfPercurso(String ufPercurso) {
        this.ufPercurso = ufPercurso;
    }

    public void setUfPercurso(DFUnidadeFederativa ufPercurso) {
        this.ufPercurso = ufPercurso.getCodigo();
    }
}
