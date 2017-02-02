package com.fincatto.cte200.classes.statusservico.consulta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.cte200.classes.CTBase;
import com.fincatto.dfe.classes.DFAmbiente;

@Root(name = "consStatServCte")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTStatusServicoConsulta extends CTBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "xServ", required = true)
    private String servico;

    public CTStatusServicoConsulta() {
        this.versao = null;
        this.ambiente = null;
        this.servico = null;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

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
}