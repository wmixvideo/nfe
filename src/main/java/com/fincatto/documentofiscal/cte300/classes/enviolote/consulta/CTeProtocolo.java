package com.fincatto.documentofiscal.cte300.classes.enviolote.consulta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.nota.assinatura.CTeSignature;

/**
 * @author Caio
 * @info Conjunto de CT-es processados, só existe nos casos em que o lote consultado se encontra processado
 * */

@Root(name = "protCTe")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeProtocolo extends DFBase {

	@Element(name = "infProt", required = true)
    private CTeProtocoloInfo info;
	
	@Element(name = "Signature", required = false)
    private CTeSignature signature;
	
	@Attribute(name = "versao", required = true)
    private String versao;

	public CTeProtocolo() {
		this.info = null;
		this.signature = null;
		this.versao = null;
	}

	public CTeProtocoloInfo getInfo() {
		return info;
	}

	/**
	 * Dados do protocolo de status
	 * */
	public void setInfo(CTeProtocoloInfo info) {
		this.info = info;
	}

	public CTeSignature getSignature() {
		return signature;
	}

	/**
	 * 
	 * */
	public void setSignature(CTeSignature signature) {
		this.signature = signature;
	}

	public String getVersao() {
		return versao;
	}

	/**
	 * 
	 * */
	public void setVersao(String versao) {
		this.versao = versao;
	}
}
