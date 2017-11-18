package com.fincatto.documentofiscal.mdfe3.classes.consultastatusservico;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Eldevan Nery Junior on 10/11/17.
 *
 * Pedido de Consulta do Status do Serviço MDF-e
 *
 */
@Root(name = "consStatServMDFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFeConsStatServ extends DFBase {

    @Element(name = "tpAmb", required = false)
    private DFAmbiente ambiente;

    @Element(name = "xServ", required = false)
    private String servico;

    @Attribute(name = "versao", required = false)
    private String versao;

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getServico() {
        return this.servico;
    }

    public void setServico(final String servico) {
        this.servico = servico;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }
}
