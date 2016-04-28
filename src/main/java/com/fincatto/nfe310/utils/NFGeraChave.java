package com.fincatto.nfe310.utils;

import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.classes.nota.NFNotaInfo;

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
		final NFNotaInfo info = this.nota.getInfo();
		final StringBuilder chaveAcesso = new StringBuilder();
		chaveAcesso.append(info.getIdentificacao().getUf().getCodigoIbge());
		chaveAcesso.append(info.getIdentificacao().getDataHoraEmissao().toString("yyMM"));
		chaveAcesso.append(info.getEmitente().getCnpj() == null ? String.format("%014d", Long.parseLong(info.getEmitente().getCpf())) : info.getEmitente().getCnpj());
		chaveAcesso.append(info.getIdentificacao().getModelo().getCodigo());
		chaveAcesso.append(info.getIdentificacao().getSerie());
		chaveAcesso.append(String.format("%09d", Long.parseLong(info.getIdentificacao().getNumeroNota())));
		chaveAcesso.append(info.getIdentificacao().getTipoEmissao().getCodigo());
		chaveAcesso.append(String.format("%08d", Long.parseLong(info.getIdentificacao().getCodigoRandomico())));
		return chaveAcesso.toString();
	}
}