package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
 *
 * Informações dos Municípios de descarregamento.
 *
 */

public  class MDFInfoInformacoesMunicipioDescarga {

    /**
     * Município de Descarregamento.
     */
    @Element(name = "cMunDescarga")
    private String municipioDescarga;
    /**
     * Nome do Município de Descarregamento
     */
    @Element(name="xMunDescarga")
    private String xMunDescarga;

    /**
     * Conhecimentos de Tranporte
     */
    @ElementList(entry = "infCTe", inline = true, required = false)
    private List<MDFInfoInformacoesCTe> infCTe;

    /**
     * Notas Fiscais Eletronica.
     */
    @ElementList(entry = "infNFe", inline = true, required = false)
    private List<MDFInfoInformacoesNFe> infNFe;

    /**
     * Manifesto Eletrônico de Documentos Fiscais. Somente para modal Aquaviário.
     */
    @ElementList(entry = "infMDFeTransp", inline = true, required = false)
    private List<MDFInfoInformacoesMDFe> infMDFeTransp;

    public String getMunicipioDescarga() {
        return municipioDescarga;
    }

    public void setMunicipioDescarga(String municipioDescarga) {
        this.municipioDescarga = DFStringValidador.validaIntervalo(municipioDescarga, 7,7,"codigo municipio descarga", true);
    }

    public String getxMunDescarga() {
        return xMunDescarga;
    }

    public void setxMunDescarga(String xMunDescarga) {
        this.xMunDescarga = DFStringValidador.validaIntervalo(xMunDescarga, 2,60, "Nome do Município de Descarregamento");
    }

    public List<MDFInfoInformacoesCTe> getInfCTe() {
        return infCTe;
    }

    public void setInfCTe(List<MDFInfoInformacoesCTe> infCTe) {
        this.infCTe = DFListValidador.validaListaNaoObrigatoria(infCTe, 10000, "Conhecimentos de Tranporte em MDF-e");
    }

    public List<MDFInfoInformacoesNFe> getInfNFe() {
        return infNFe;
    }

    public void setInfNFe(List<MDFInfoInformacoesNFe> infNFe) {
        this.infNFe = DFListValidador.validaListaNaoObrigatoria(infNFe, 10000, "Notas fiscais em MDF-e");
    }

    public List<MDFInfoInformacoesMDFe> getInfMDFeTransp() {
        return infMDFeTransp;
    }

    public void setInfMDFeTransp(List<MDFInfoInformacoesMDFe> infMDFeTransp) {
        this.infMDFeTransp = DFListValidador.validaListaNaoObrigatoria(infMDFeTransp, 10000, "Manifesto Eletrônico de Documentos Fiscais em MDF-e");
    }
}