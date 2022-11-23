package com.fincatto.documentofiscal.nfe400.classes.evento.averbacaoexportacao;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.nota.assinatura.NFSignature;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;

public class NFEventoAverbacaoExportacao extends DFBase {

	private static final long serialVersionUID = 2970383461949905568L;

	@Attribute(name = "versao")
	private String versao;

	@Element(name = "infEvento")
	private NFInfoEventoAverbacaoExportacao infoEvento;

	@Element(name = "Signature", required = false)
	private NFSignature assinatura;

	public void setVersao(final BigDecimal versao) {
		this.versao = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versao, "Versao");
	}

	public NFInfoEventoAverbacaoExportacao getInfoEvento() {
		return this.infoEvento;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setInfoEvento(final NFInfoEventoAverbacaoExportacao infoEvento) {
		this.infoEvento = infoEvento;
	}

	public void setAssinatura(final NFSignature assinatura) {
		this.assinatura = assinatura;
	}

	public NFSignature getAssinatura() {
		return this.assinatura;
	}

}
