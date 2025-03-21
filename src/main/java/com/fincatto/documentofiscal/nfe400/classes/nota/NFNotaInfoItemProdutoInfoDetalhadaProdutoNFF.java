package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;

public class NFNotaInfoItemProdutoInfoDetalhadaProdutoNFF extends DFBase {

	private static final long serialVersionUID = -2223280511267153435L;

	@Element(name = "cProdFisco")
	private String codigoFiscalProduto;

	@Element(name = "cOperNFF")
	private String codigoOperacao;

	public String getCodigoFiscalProduto() {
		return codigoFiscalProduto;
	}

	public void setCodigoFiscalProduto(String codigoFiscalProduto) {
		DFStringValidador.exatamente14(codigoFiscalProduto, "C\u00f3digo fiscal do produto");
		this.codigoFiscalProduto = codigoFiscalProduto;
	}

	public String getCodigoOperacao() {
		return codigoOperacao;
	}

	public void setCodigoOperacao(String codigoOperacao) {
		DFStringValidador.validaTamanhoMaximo(codigoOperacao, 5,
				"C\u00f3digo da operação selecionada na NFF e relacionada ao item");
		this.codigoOperacao = codigoOperacao;
	}

}
