package com.fincatto.documentofiscal.nfe400.classes.evento.averbacaoexportacao;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoRetorno;

@Root(name = "procEventoNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFProtocoloEventoAverbacaoExportacao extends DFBase {

	private static final long serialVersionUID = -1013510869624617504L;

	@Attribute(name = "versao")
	private String versao;

	@Element(name = "evento")
	private NFEventoAverbacaoExportacao evento;

	@Element(name = "retEvento")
	private NFEventoRetorno eventoRetorno;

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public NFEventoAverbacaoExportacao getEvento() {
		return evento;
	}

	public void setEvento(NFEventoAverbacaoExportacao evento) {
		this.evento = evento;
	}

	public NFEventoRetorno getEventoRetorno() {
		return eventoRetorno;
	}

	public void setEventoRetorno(NFEventoRetorno eventoRetorno) {
		this.eventoRetorno = eventoRetorno;
	}

}
