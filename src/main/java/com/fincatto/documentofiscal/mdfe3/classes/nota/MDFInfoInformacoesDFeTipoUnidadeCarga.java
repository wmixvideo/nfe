package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoUnidadeCarga;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 *  Created by Eldevan Nery Junior on 06/11/17.
 */
public class MDFInfoInformacoesDFeTipoUnidadeCarga {

    @Element(name = "tpUnidCarga")
    private MDFTipoUnidadeCarga tipoUnidadeCarga;
    /**
     * Identificação da Unidade de Carga
     * Informar a identificação da unidade de carga, por exemplo: número do container.
     */
    @Element(name = "idUnidCarga")
    private String idUnidCarga;
    /**
     * Lacres das Unidades de Carga.
     */
    @ElementList(entry = "lacUnidCarga", inline = true)
    private List<MDFInfoLacre1A20> lacUnidCarga;
    /**
     * Quantidade rateada (Peso,Volume)
     */
    @Element(name = "qtdRat")
    private String qtdRateada;
}