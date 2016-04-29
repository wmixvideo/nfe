package com.fincatto.nfe310.utils;

import org.apache.commons.lang3.StringUtils;

import com.fincatto.nfe310.classes.nota.NFNota;

public class NFGeraChave {

	private final NFNota nota;

	public NFGeraChave(final NFNota nota) {
		this.nota = nota;
	}

	public String getChaveAcesso() {
		return String.format("%s%s", this.geraChaveAcessoSemDV(), this.getDV());
	}

	public Integer getDV() {
		final char[] valores = this.geraChaveAcessoSemDV().toCharArray();
		final int[] valoresInt = { 2, 3, 4, 5, 6, 7, 8, 9 };
		int indice = 0;
		int soma = 0;
		int valorTemp = 0;
		int multTemp = 0;
		for (int i = valores.length; i > 0; i--) {
			if (indice >= valoresInt.length) {
				indice = 0;
			}
			valorTemp = Integer.valueOf(String.valueOf(valores[i - 1]));
			multTemp = valoresInt[indice++];
			soma += valorTemp * multTemp;
		}
		final int dv = 11 - (soma % 11);
		return ((dv == 11) || (dv == 10)) ? 0 : dv;
	}

	private String geraChaveAcessoSemDV() {
		final StringBuilder chaveAcesso = new StringBuilder();
		chaveAcesso.append(StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getUf().getCodigoIbge(), 2, "0"));
		chaveAcesso.append(StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getDataHoraEmissao().toString("yyMM"), 4, "0"));
		chaveAcesso.append(StringUtils.leftPad(this.nota.getInfo().getEmitente().getCnpj() == null ? this.nota.getInfo().getEmitente().getCpf() : this.nota.getInfo().getEmitente().getCnpj(), 14, "0"));
		chaveAcesso.append(StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getModelo().getCodigo(), 2, "0"));
		chaveAcesso.append(StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getSerie(), 3, "0"));
		chaveAcesso.append(StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getNumeroNota(), 9, "0"));
		chaveAcesso.append(StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getTipoEmissao().getCodigo(), 1, "0"));
		chaveAcesso.append(StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getCodigoRandomico(), 8, "0"));
		return chaveAcesso.toString();
	}
}