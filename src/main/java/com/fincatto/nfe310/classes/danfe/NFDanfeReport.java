package com.fincatto.nfe310.classes.danfe;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.util.JRProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.fincatto.nfe310.classes.nota.NFNota;

public class NFDanfeReport {
	private static ClassLoader classloader;
	private static InputStream in = null;
	private static Document doc;
	private static final Logger logger = LoggerFactory.getLogger(NFDanfeReport.class);

	public static boolean imprimirDanfe(NFNota xmlNota, String pathDestino) {

		boolean retorno = false;
		try {
			classloader = Thread.currentThread().getContextClassLoader();
			in = classloader.getResourceAsStream("danfe/danfeR3.jrxml");
			JasperReport report = JasperCompileManager.compileReport(in);
			logger.info("Compilando Relatório...");
			JRProperties
					.setProperty("net.sf.jasperreports.xpath.executer.factory",
							"net.sf.jasperreports.engine.util.xml.JaxenXPathExecuterFactory");
			JasperPrint print = JasperFillManager.fillReport(report, null,
					new JRXmlDataSource(
							convertStringXMl2DOM(xmlNota.toString()),
							"/NFe/infNFe/det"));
			logger.info("Montando estrutura...");
			JasperExportManager.exportReportToPdfFile(print, pathDestino);
			logger.info("Gravando PDF...");
			logger.info("Danfe impresso em: " + pathDestino);
			retorno = true;
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return retorno;

	}

	private static Document convertStringXMl2DOM(String nota) {
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(nota));
			doc = db.parse(is);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;

	}

}
