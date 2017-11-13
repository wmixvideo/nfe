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
    private DFUnidadeFederativa ufPercurso;

    public DFUnidadeFederativa getUfPercurso() {
        return ufPercurso;
    }

    public void setUfPercurso(DFUnidadeFederativa ufPercurso) {
        this.ufPercurso = ufPercurso;
    }
}
