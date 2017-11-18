
package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoUnidadeTransporte;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;


/**
 * Created by Eldevan Nery Junior on 06/11/17.
 *
 * Informações das Unidades de Transporte (Carreta/Reboque/Vagão)
 * Deve ser preenchido com as informações das unidades de transporte utilizadas.
 */
public class MDFInfoInformacoesDFeTipoUnidadeTransporte {

    /**
     * Tipo da Unidade de Transporte
     */
    @Element(name = "tpUnidTransp")
    private MDFTipoUnidadeTransporte tipoUnidadeTransporte;
    /**
     * 	Identificação da Unidade de Transporte
     * Informar a identificação conforme o tipo de unidade de transporte.
     * Por exemplo: para rodoviário tração ou reboque deverá preencher com a placa do veículo.
     */
    @Element(name = "idUnidTransp")
    private String idUnidTransp;
    /**
     * Lacres das Unidades de Transporte
     */
    @ElementList(entry = "lacUnidTransp", inline = true, required = false)
    private List<MDFInfoLacre1A20> lacUnidTransp;

    /**
     * Informações das Unidades de Carga (Containeres/ULD/Outros).
     */
    @ElementList(entry = "infUnidCarga", inline = true, required = false)
    private List<MDFInfoInformacoesDFeTipoUnidadeCarga> infUnidCarga;

    @Element(name = "qtdRat")
    private String qtdRateada;

}
