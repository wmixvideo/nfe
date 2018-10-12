package com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoRetorno;

@Root(name = "procEventoNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFProtocoloEventoManifestacaoDestinatario extends DFBase {
	private static final long serialVersionUID = 8058424887014735846L;

	@Attribute(name = "versao", required = true)
	private String versao;

	@Element(name = "evento", required = true)
	private NFEventoManifestacaoDestinatario evento;

	@Element(name = "retEvento", required = true)
	private NFEventoRetorno eventoRetorno;

	public NFEventoManifestacaoDestinatario getEvento() {
		return this.evento;
	}

	public void setEvento(final NFEventoManifestacaoDestinatario evento) {
		this.evento = evento;
	}

	public NFEventoRetorno getEventoRetorno() {
		return this.eventoRetorno;
	}

	public void setEventoRetorno(final NFEventoRetorno infoEventoRetorno) {
		this.eventoRetorno = infoEventoRetorno;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(final String versao) {
		this.versao = versao;
	}
}
