package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;

import java.util.List;

public  class MDFInfoInformacoesDocumentos {

    /**
     * Informações dos Municípios de descarregamento
     */
    @Element(name = "infMunDescarga")
    protected List<MDFInfoInformacoesMunicipioDescarga> informacoesMunicipioDescargas;
}