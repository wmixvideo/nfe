package com.fincatto.nfe310.danfe;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.data.JRXmlDataSource;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.fincatto.nfe310.classes.nota.NFNotaProcessada;

public class NFDanfeReport {

	public static byte[] imprimirDanfe(NFNotaProcessada xmlNota) throws JRException,
			ParserConfigurationException, SAXException, IOException {

		ClassLoader classloader = Thread.currentThread()
				.getContextClassLoader();
		byte[] reportByte;
		try (InputStream in = classloader.getResourceAsStream("danfe/danfeR3.jasper")) {
			JasperReportsContext jasperReportsContext = DefaultJasperReportsContext.getInstance();
			JRPropertiesUtil jrPropertiesUtil = JRPropertiesUtil.getInstance(jasperReportsContext);
			jrPropertiesUtil.setProperty("net.sf.jasperreports.xpath.executer.factory",
					"net.sf.jasperreports.engine.util.xml.JaxenXPathExecuterFactory");
			JasperPrint print = JasperFillManager.fillReport(in, null,
					new JRXmlDataSource(convertStringXMl2DOM(xmlNota.toString()),"/nfeProc/NFe/infNFe/det"));
			reportByte = JasperExportManager.exportReportToPdf(print);
		}
		return reportByte;
	}

	private static Document convertStringXMl2DOM(String nota) throws ParserConfigurationException, SAXException, IOException {
		Document doc = null;
		DocumentBuilder db = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(nota));
		doc = db.parse(is);
		return doc;
	}
}
