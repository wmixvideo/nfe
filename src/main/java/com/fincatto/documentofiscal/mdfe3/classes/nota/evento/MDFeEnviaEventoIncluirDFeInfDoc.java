package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Edivaldo Merlo Stens on 19/02/20.
 */
@Root(name = "infDoc")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFeEnviaEventoIncluirDFeInfDoc extends DFBase {

    /**
     * Município de Descarregamento.
     */
    @Element(name = "cMunDescarga")
    private String codigoMunicipioDescarga;
    /**
     * Nome do Município de Descarregamento
     */
    @Element(name = "xMunDescarga")
    private String nomeMunicipioDescarga;

    @Element(name = "chNFe")
    private String chNFe;

    public String getMunicipioDescarga() {
        return codigoMunicipioDescarga;
    }

    public void setCodigoMunicipioDescarga(String codigoMunicipioDescarga) {
        this.codigoMunicipioDescarga = StringValidador.validaIntervalo(codigoMunicipioDescarga, 7, 7, "codigo municipio descarga", true);
    }

    public String getNomeMunicipioDescarga() {
        return nomeMunicipioDescarga;
    }

    public void setNomeMunicipioDescarga(String nomeMunicipioDescarga) {
        this.nomeMunicipioDescarga = StringValidador.validaIntervalo(nomeMunicipioDescarga, 2, 60, "Nome do Município de Descarregamento");
    }

    public String getChNFe() {
        return chNFe;
    }

    public void setChNFe(String chNFe) {
        StringValidador.exatamente44N(chNFe, "Chave NF-e informações");
        this.chNFe = chNFe;
    }

}
