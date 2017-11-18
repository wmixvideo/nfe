package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
 *
 * Informações dos Municípios de Carregamento.
 *
 */
public class MDFInfoIdentificacaoMunicipioCarregamento extends DFBase{

    /**
     * Código do Município de Carregamento
     */
    @Element(name = "cMunCarrega")
    private String codigoMunicipioCarregamento;

    /**
     * Nome do Município de Carregamento
     */
    @Element(name = "xMunCarrega")
    private String nomeMunicipioCarregamento;

    public String getCodigoMunicipioCarregamento() {
        return codigoMunicipioCarregamento;
    }

    public void setCodigoMunicipioCarregamento(String codigoMunicipioCarregamento) {
        this.codigoMunicipioCarregamento = StringValidador.validador(codigoMunicipioCarregamento, "Codigo municipio carregamento", 7, true, true);
    }

    public String getNomeMunicipioCarregamento() {
        return nomeMunicipioCarregamento;
    }

    public void setNomeMunicipioCarregamento(String nomeMunicipioCarregamento) {
        StringValidador.tamanho2ate60(nomeMunicipioCarregamento, "Nome municipio carregamento");
        this.nomeMunicipioCarregamento = nomeMunicipioCarregamento;
    }
}
