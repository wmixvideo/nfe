package com.fincatto.documentofiscal.cte300.classes.consultastatusservico;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;

@Root(name = "consStatServCte")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeConsStatServ extends DFBase{

	@Element(name = "tpAmb", required = false)
    private DFAmbiente ambiente;
    
    @Element(name = "xServ", required = false)
    private String servico;
    
    @Attribute(name = "versao", required = false)
    private String versao;

    public CTeConsStatServ(){
    	this.ambiente = null;
    	this.servico = null;
    	this.versao = null;
    }
    
	public DFAmbiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(DFAmbiente ambiente) {
		this.ambiente = ambiente;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
}
