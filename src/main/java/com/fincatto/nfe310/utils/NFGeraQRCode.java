package com.fincatto.nfe310.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import org.joda.time.DateTime;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFProtocolo;
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
	public static void geraURL(NFeConfig config, NFNota nf, NFProtocolo prot){
		NFUnidadeFederativa uf = nf.getInfo().getIdentificacao().getUf();
		String url = config.getAmbiente().equals(NFAmbiente.PRODUCAO)?uf.getQrCodeProd():uf.getQrCodeHom();

		if(url==null || url.isEmpty()){
			throw new IllegalArgumentException("URL para consulta do QRCode não informada para uf "+uf+"!");
		}
		
		if(config.getCSC()==null || config.getCSC().isEmpty()){
			throw new IllegalArgumentException("CSC não informado nas configurações!");
		}
		
		if(config.getIdCSC()==null || config.getIdCSC() == 0){
			throw new IllegalArgumentException("IdCSC não informado nas configurações!");
		}
		
		StringBuilder b = new StringBuilder();
		
		//Chave de Acesso da NFC-e
		b.append("chNFe=").append(prot.getProtocoloInfo().getChave()).append("&");
		
		//Versão do QRCode
		b.append("nVersao=100").append("&");
		
		//AMBIENTE: 1-PRODUÇÃO 2-HOMOLOGAÇÃO
		b.append("tpAmb=").append(config.getAmbiente().getCodigo()).append("&");
		
		//Documento de Identificação do Consumidor (CNPJ/CPF/ID Estrangeiro)
		String cpfj = nf.getInfo().getDestinatario().getCpfj();
		if(cpfj!=null && !cpfj.isEmpty()){
			b.append("cDest=").append(cpfj).append("&");
		}
		
		//Data e Hora de Emissão da NFC-e
		DateTime dt = nf.getInfo().getIdentificacao().getDataHoraEmissao();
		String dtF = dt.toString("yyyy-MM-dd")+"T"+dt.toString("HH:mm:ssZZ");
		b.append("dhEmi=").append(toHex(dtF)).append("&");
		
		//Valor Total da NFC-e
		b.append("vNF=").append(nf.getInfo().getTotal().getIcmsTotal().getValorTotalNFe()).append("&");
		
		//NFC-e Valor Total ICMS na NFC-e
		b.append("vICMS=").append(nf.getInfo().getTotal().getIcmsTotal().getValorTotalICMS()).append("&");
		
		//Digest Value da NFC-e
		String dig = prot.getProtocoloInfo().getValidador();
		b.append("digVal=").append(toHex(dig)).append("&");
		
		//Identificador do CSC – Código de Segurança do Contribuinte no Banco de Dados da SEFAZ
		b.append("cIdToken=").append(String.format("%06d", config.getIdCSC()));
		
		//Código Hash dos Parâmetros
		String campos = b.toString();
		String hash = createHash(campos, config.getCSC());
		
		String qrCode = url+campos+"&cHashQRCode="+hash;
		
		nf.getInfoSuplementar().setQrCode(qrCode);
	}
	
	public static String createHash(String campos, String csc) {
		String str = campos+csc;
		return sha1(str);
	}
	
	public static String toHex(String arg) {
	    return String.format("%040x", new BigInteger(1, arg.getBytes()));
	}
	
	public static String sha1(String input){
		try {
			MessageDigest mDigest = MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(input.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}