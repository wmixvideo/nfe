package com.fincatto.nfe310.utils;

import com.fincatto.nfe310.classes.nota.NFNotaInfo;

public class NFGeraChave {

	public static void geraChave(NFNotaInfo infoNota) {
		
		StringBuilder chaveAcesso = new StringBuilder();
		chaveAcesso.append(infoNota.getIdentificacao().getUf().getCodigoIbge());
		chaveAcesso.append(infoNota.getIdentificacao().getDataHoraEmissao().toString("yyMM"));
		chaveAcesso.append(infoNota.getEmitente().getCnpj());
		chaveAcesso.append(infoNota.getIdentificacao().getModelo());
		chaveAcesso.append(infoNota.getIdentificacao().getSerie());
		chaveAcesso.append(String.format("%09d", Long.parseLong(infoNota.getIdentificacao().getNumeroNota())));
		// Aplicar somente na versão 2.0
		chaveAcesso.append(infoNota.getIdentificacao().getTipoEmissao().getCodigo());
		chaveAcesso.append(String.format("%08d", Long.parseLong(infoNota.getIdentificacao().getCodigoRandomico())));
		Integer dv = calculoDigitoVerificador(chaveAcesso.toString());
		chaveAcesso.append(dv);

		infoNota.getIdentificacao().setDigitoVerificador(dv);
		infoNota.setIdentificador(chaveAcesso.toString());
	}
	
	private static Integer calculoDigitoVerificador(String chave) {

		char[] valores = chave.toCharArray();
		int[] valoresInt = { 2, 3, 4, 5, 6, 7, 8, 9 };
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

		int dv = 11 - (soma % 11);

		return (dv == 11 || dv == 10) ? 0 : dv;
	}
	
}
