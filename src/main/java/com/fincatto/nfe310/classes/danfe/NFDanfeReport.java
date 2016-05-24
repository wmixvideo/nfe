package com.fincatto.nfe310.classes.danfe;

import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.util.JRXmlUtils;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.fincatto.nfe310.classes.nota.NFNota;

public class NFDanfeReport {
	private static ClassLoader classloader;
	private static Document document;
	
	public static boolean imprimirDanfe(NFNota xmlNota,
			String pathDestino) {
		
	    
	    try {
	    	String tst = xmlNota.toString();
	    	System.out.println(tst);
			document = JRXmlUtils.parse(new InputSource( new StringReader(xmlNota.toString()))); 
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean retorno = false;
		try {
			classloader = Thread.currentThread().getContextClassLoader();
			InputStream in = classloader.getResourceAsStream("danfe/danfeR2.jrxml");
			JasperReport report = JasperCompileManager.compileReport(in);
			System.out.println("Passei por aqui");
			JasperPrint print = JasperFillManager.fillReport(report, null,
					new JRXmlDataSource(document,"/NFe/infNFe/det"));
			JasperExportManager.exportReportToPdfFile(print, pathDestino);
			System.out.println("Danfe impresso em: " + pathDestino);
			retorno = true;
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;

	}

}
