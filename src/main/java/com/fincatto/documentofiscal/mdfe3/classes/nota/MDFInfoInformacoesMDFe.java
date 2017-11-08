package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by Eldevan Nery Junior on 08/11/17.
 *
 * Manifesto Eletrônico de Documentos Fiscais. Somente para modal Aquaviário (vide regras MOC).
 */
public class MDFInfoInformacoesMDFe {

    /**
     * Nota Fiscal Eletronica - Chave de Acesso
     */
    @Element(name = "chMDFe" )
    private String chaveMDFe;
    /**
     * Indicador de Reentrega
     */
    @Element(name = "indReentrega", required = false)
    private String indicadorReentrega;

    /**
     * Informações das Unidades de Transporte.
     */
    @ElementList(entry = "infUnidTransp", inline = true, required = false)
    private List<MDFInfoInformacoesDFeTipoUnidadeTransporte> informacoesUnidadeTransporte;

    /**
     * Preenchido quando for  transporte de produtos classificados pela ONU como perigosos.
     */
    @ElementList(entry = "peri", inline = true, required = false)
    private List<MDFInfoPerigosos> perigosos;

    public String getChaveMDFe() {
        return chaveMDFe;
    }

    public void setChaveMDFe(String chaveMDFe) {
        StringValidador.exatamente44N(chaveMDFe, "Chave NF-e informações");
        this.chaveMDFe = chaveMDFe;
    }

    public String getIndicadorReentrega() {
        return indicadorReentrega;
    }

    public void setIndicadorReentrega(String indicadorReentrega) {
        StringValidador.equals( "1", indicadorReentrega);
        this.indicadorReentrega = indicadorReentrega;
    }

    public List<MDFInfoInformacoesDFeTipoUnidadeTransporte> getInformacoesUnidadeTransporte() {
        return informacoesUnidadeTransporte;
    }

    public void setInformacoesUnidadeTransporte(List<MDFInfoInformacoesDFeTipoUnidadeTransporte> informacoesUnidadeTransporte) {
        this.informacoesUnidadeTransporte = informacoesUnidadeTransporte;
    }

    public List<MDFInfoPerigosos> getPerigosos() {
        return perigosos;
    }

    public void setPerigosos(List<MDFInfoPerigosos> perigosos) {
        this.perigosos = perigosos;
    }
}