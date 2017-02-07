package com.fincatto.cte300.classes.statusservico.consulta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.cte300.CTeConfig;
import com.fincatto.cte300.classes.CTBase;
import com.fincatto.dfe.classes.DFAmbiente;

@Root(name = "consStatServCte")
@Namespace(reference = CTeConfig.CTE_NAMESPACE)
public class CTStatusServicoConsulta extends CTBase {

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "xServ")
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