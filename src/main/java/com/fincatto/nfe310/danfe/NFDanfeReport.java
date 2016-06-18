package com.fincatto.nfe310.danfe;

import com.fincatto.nfe310.classes.nota.NFNotaProcessada;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

public abstract class NFDanfeReport {

    public static byte[] imprimirDanfe(NFNotaProcessada nota) throws IOException, ParserConfigurationException, SAXException, JRException {
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("danfe/danfeR3.jasper")) {
            final JRPropertiesUtil jrPropertiesUtil = JRPropertiesUtil.getInstance(DefaultJasperReportsContext.getInstance());
            jrPropertiesUtil.setProperty("net.sf.jasperreports.xpath.executer.factory", "net.sf.jasperreports.engine.util.xml.JaxenXPathExecuterFactory");
            return JasperExportManager.exportReportToPdf(JasperFillManager.fillReport(in, null, new JRXmlDataSource(convertStringXMl2DOM(nota.toString()), "/nfeProc/NFe/infNFe/det")));
        }
    }

    private static Document convertStringXMl2DOM(String nota) throws ParserConfigurationException, IOException, SAXException {
        try (StringReader stringReader = new StringReader(nota)) {
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(stringReader);
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        }
    }
}
