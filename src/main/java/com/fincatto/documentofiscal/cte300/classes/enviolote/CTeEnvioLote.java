package com.fincatto.documentofiscal.cte300.classes.enviolote;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.nota.CTeNota;
import com.fincatto.documentofiscal.validadores.ListValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Tipo Pedido de Concessão de Autorização da CT-e
 * */

@Root(name = "enviCTe")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeEnvioLote extends DFBase {

	@Attribute(name = "versao", required = true)
    private String versao;
	
	@Element(name = "idLote", required = true)
    private String idLote;
    
	@ElementList(name = "CTe", inline = true, required = true)
    private List<CTeNota> nota;

	public CTeEnvioLote() {
		this.versao = null;
		this.idLote = null;
		this.nota = null;
	}
	
	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
	
	public String getIdLote() {
		return idLote;
	}

	public void setIdLote(String idLote) {
		StringValidador.tamanho15N(idLote, "ID do Lote");
		this.idLote = idLote;
	}

	public List<CTeNota> getNota() {
		return nota;
	}

	public void setNota(List<CTeNota> nota) {
		ListValidador.tamanho50(nota, "Notas");
		this.nota = nota;
	}
}
