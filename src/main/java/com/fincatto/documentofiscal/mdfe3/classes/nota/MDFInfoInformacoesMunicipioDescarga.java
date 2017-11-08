package com.fincatto.documentofiscal.mdfe3.classes.nota;

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
    @ElementList(entry = "infCTe", inline = true, required = false)
    private List<MDFInfoInformacoesCTe> infCTe;
    @ElementList(entry = "infNFe", inline = true, required = false)
    private List<InfNFe> infNFe;
    @ElementList(entry = "infMDFeTransp", inline = true, required = false)
    private List<InfMDFeTransp> infMDFeTransp;
}