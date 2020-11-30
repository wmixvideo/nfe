package com.fincatto.documentofiscal.nfe400.classes.evento.averbacaoexportacao;

import java.util.List;

import com.fincatto.documentofiscal.validadores.DFListValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.documentofiscal.DFBase;

public class NFInfoAverbacaoExportacao extends DFBase {

	private static final long serialVersionUID = 2593936397273523676L;

	@Attribute(name = "versao")
	private String versao;

	@Element(name = "descEvento")
	private String descricaoEvento;

	@Element(name = "tpAutor")
	private Integer codigoAutorEvento;

	@Element(name = "verAplic")
	private String versaoAplicativoAutorEvento;

	@ElementList(entry = "itensAverbados", inline = true)
	private List<NFInfoItemAverbacaoExportacao> itensAverbados;

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getDescricaoEvento() {
		return descricaoEvento;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	public Integer getCodigoAutorEvento() {
		return codigoAutorEvento;
	}

	public void setCodigoAutorEvento(Integer codigoAutorEvento) {
		this.codigoAutorEvento = codigoAutorEvento;
	}

	public String getVersaoAplicativoAutorEvento() {
		return versaoAplicativoAutorEvento;
	}

	public void setVersaoAplicativoAutorEvento(String versaoAplicativoAutorEvento) {
		this.versaoAplicativoAutorEvento = versaoAplicativoAutorEvento;
	}

	public List<NFInfoItemAverbacaoExportacao> getItensAverbados() {
		DFListValidador.tamanho990(itensAverbados, "Itens Averbados");
		return itensAverbados;
	}

	public void setItensAverbados(List<NFInfoItemAverbacaoExportacao> itensAverbados) {
		this.itensAverbados = itensAverbados;
	}

}
