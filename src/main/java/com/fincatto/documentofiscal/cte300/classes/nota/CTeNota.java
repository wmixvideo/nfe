package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.nota.assinatura.CTeSignature;

/**
 * @author Caio
 * @info Tipo Conhecimento de Transporte Eletrônico (Modelo 57)
 * */

@Root(name = "CTe")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNota extends DFBase {
	
	@Element(name = "infCte", required = true)
	private CTeNotaInfo info;
	
	@Element(name = "Signature", required = false)
	private CTeSignature signature;

	
	public CTeNota(){
		this.info = null;
		this.signature = null;
	}
	
	public CTeNotaInfo getCteNotaInfo() {
		return info;
	}

	public void setCteNotaInfo(CTeNotaInfo info) {
		this.info = info;
	}

	public CTeSignature getSignature() {
		return signature;
	}

	public void setSignature(CTeSignature signature) {
		this.signature = signature;
	}
}
