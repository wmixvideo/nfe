package com.fincatto.nfe310.utils;

import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.nota.NFNota;

public class NFGeraQRCode {

	/* EXEMPLO
	 * https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx?
	 * chNFe=43160493062776000117650010000012891000012891&
	 * nVersao=100&
	 * tpAmb=1&
	 * cDest=00400437031&
	 * dhEmi=323031362d30342d31355431363a32313a35312d30333a3030&
	 * vNF=88.00&
	 * vICMS=0.00&
	 * digVal=787971704e2f7771446134687070486e6b6b6c34705a39536a36633d&
	 * cIdToken=000001&
	 * cHashQRCode=852E4B5BC4EB9BF65484AEEBB06BE4A65F0E8E13
	 */
	public static void geraURL(NFNota nf){
		NFUnidadeFederativa uf = nf.getInfo().getIdentificacao().getUf();
		NFAutorizador31 auto = NFAutorizador31.valueOfCodigoUF(uf);
		
		StringBuilder b = new StringBuilder();
		//URL CONSULTA
		//b.append(auto.getNFCeConsultaQRCode());
		
		//Chave de Acesso da NFC-e
		b.append("chNFe=").append(nf.getInfo().getIdentificador()).append("&");
		
		//Versão do QRCode
		b.append("nVersao=100").append("&");
		
		//AMBIENTE: 1-PRODUÇÃO 2-HOMOLOGAÇÃO
		b.append("tpAmb=1").append("&");
		
		//Documento de Identificação do Consumidor (CNPJ/CPF/ID Estrangeiro)
		b.append("cDest=00400437031").append("&");
		
		//Data e Hora de Emissão da NFC-e
		b.append("dhEmi=323031362d30342d31355431363a32313a35312d30333a3030").append("&");
		
		//Valor Total da NFC-e
		b.append("vNF=88.00").append("&");
		
		//NFC-e Valor Total ICMS na NFC-e
		b.append("vICMS=0.00").append("&");
		
		//Digest Value da NFC-e
		b.append("digVal=787971704e2f7771446134687070486e6b6b6c34705a39536a36633d").append("&");
		
		//Identificador do CSC – Código de Segurança do Contribuinte no Banco de Dados da SEFAZ
		b.append("cIdToken=000001").append("&");
		
		//Código Hash dos Parâmetros
		b.append("cHashQRCode=852E4B5BC4EB9BF65484AEEBB06BE4A65F0E8E13");
		
		nf.getInfoSuplementar().setQrCode(b.toString());
	}
	
}