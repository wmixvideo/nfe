package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoProprietario;
import org.simpleframework.xml.Element;

public class MDFInfoModalRodoviarioVeiculoProp extends DFBase {

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "RNTRC")
    private String registroNacionalTransportes;

    @Element(name = "xNome")
    private String razaoSocial;

    @Element(name = "IE")
    private String inscricaoEstadual;

    @Element(name = "UF")
    private DFUnidadeFederativa unidadeFederativa;

    @Element(name = "tpProp", required = false)
    private MDFTipoProprietario tipoProprietario;


}
