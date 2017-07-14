package com.fincatto.nfe310.classes.evento.epec;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.classes.nota.assinatura.NFSignature;
import com.fincatto.nfe310.validadores.BigDecimalParser;

@Root(name = "evento")
public class NFEventoEpec extends NFBase {

	@Attribute(name = "versao", required = true)
	private String versao;

	@Element(name = "infEvento", required = true)
	private NFInfoEventoEpec infoEvento;

	@Element(name = "Signature", required = false)
	private NFSignature assinatura;

	@Transient
	private NFNota nota;

	public void setVersao(final BigDecimal versao) {
		this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao, "Versao");
	}

	public NFInfoEventoEpec getInfoEvento() {
		return this.infoEvento;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public void setInfoEvento(final NFInfoEventoEpec infoEvento) {
		this.infoEvento = infoEvento;
	}

	public void setAssinatura(final NFSignature assinatura) {
		this.assinatura = assinatura;
	}

	public NFSignature getAssinatura() {
		return this.assinatura;
	}

	public NFNota getNota() {
		return nota;
	}

	public void setNota(NFNota nota) {
		this.nota = nota;
	}

}