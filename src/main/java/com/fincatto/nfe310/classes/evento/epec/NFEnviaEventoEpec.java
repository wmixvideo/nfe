package com.fincatto.nfe310.classes.evento.epec;

import java.math.BigDecimal;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;
import com.fincatto.nfe310.validadores.ListValidador;
import com.fincatto.nfe310.validadores.StringValidador;

@Root(name = "envEvento")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFEnviaEventoEpec extends NFBase {

	@Attribute(name = "versao", required = true)
	private String versao;

	@Element(name = "idLote", required = true)
	private String idLote;

	@ElementList(entry = "evento", inline = true, required = true)
	private List<NFEventoEpec> evento;

	public void setVersao(final BigDecimal versao) {
		this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao, "Versao");
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getIdLote() {
		return this.idLote;
	}

	public void setIdLote(final String idLote) {
		StringValidador.tamanho15N(idLote, "ID do Lote");
		this.idLote = idLote;
	}

	public List<NFEventoEpec> getEvento() {
		return this.evento;
	}

	public void setEvento(final List<NFEventoEpec> evento) {
		ListValidador.tamanho20(evento, "Evento de Conting\u00eancia EPEC");
		this.evento = evento;
	}
}