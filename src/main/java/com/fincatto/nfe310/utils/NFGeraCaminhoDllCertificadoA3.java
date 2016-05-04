package com.fincatto.nfe310.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFTipoCertificadoA3;

public class NFGeraCaminhoDllCertificadoA3 {

	private static String pasta;
	private final static String smartCart = "SmartCard.cfg";
	private final static String token = "Token.cfg";
	private static NFeConfig config;
	
	public NFGeraCaminhoDllCertificadoA3(NFeConfig config){
		this.config = config;
		
		geraCaminhoDll();
	}

	public static String getCaminhoArquivo() {
		return pasta + System.getProperty("file.separator") + (NFTipoCertificadoA3.SMARTCARD.equals(config.getTipoCertificadoA3()) ? 
				NFGeraCaminhoDllCertificadoA3.smartCart : NFGeraCaminhoDllCertificadoA3.token);
	}

	private static void geraCaminhoDll(){
		pasta = System.getProperty("user.home") + System.getProperty("file.separator") + ".configCaminhoDll";
		
		//cria o diretorio
		File caminhoArquivo = new File(pasta);
		
		if (!caminhoArquivo.exists()) {
			caminhoArquivo.mkdirs();
			
			File file;
			
			try {
				file = new File(caminhoArquivo + System.getProperty("file.separator") + (NFTipoCertificadoA3.SMARTCARD.equals(config.getTipoCertificadoA3()) ? 
						NFGeraCaminhoDllCertificadoA3.smartCart : NFGeraCaminhoDllCertificadoA3.token ));
				
				if(file.exists()){
					file.delete();
				}
				
				file.createNewFile();
				
				FileWriter arq;
				PrintWriter gravarArq;
				
				arq = new FileWriter(file);
				gravarArq = new PrintWriter(arq);
				
				if((NFTipoCertificadoA3.SMARTCARD.equals(config.getTipoCertificadoA3()))){
					gravarArq.println("name = SmartCard");
					gravarArq.println("library = c:/windows/system32/aetpkss1.dll");
					gravarArq.println("showInfo = true");
				}else{
					gravarArq.println("name = eToken");
					gravarArq.println("library = c:/windows/system32/eTpkcs11.dll");
					gravarArq.println("showInfo = true");
				}
				
				arq.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
