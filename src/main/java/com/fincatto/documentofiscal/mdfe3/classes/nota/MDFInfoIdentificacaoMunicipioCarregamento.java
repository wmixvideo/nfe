package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * Created by Eldevan Nery Junior on 06/11/17. Informações dos Municípios de Carregamento.
 */
public class MDFInfoIdentificacaoMunicipioCarregamento extends DFBase {
    private static final long serialVersionUID = 7674411655418687165L;

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
        return this.codigoMunicipioCarregamento;
    }

    public void setCodigoMunicipioCarregamento(final String codigoMunicipioCarregamento) {
        this.codigoMunicipioCarregamento = StringValidador.validador(codigoMunicipioCarregamento, "Codigo municipio carregamento", 7, true, true);
    }

    public String getNomeMunicipioCarregamento() {
        return this.nomeMunicipioCarregamento;
    }

    public void setNomeMunicipioCarregamento(final String nomeMunicipioCarregamento) {
        StringValidador.tamanho2ate60(nomeMunicipioCarregamento, "Nome municipio carregamento");
        this.nomeMunicipioCarregamento = nomeMunicipioCarregamento;
    }
}
