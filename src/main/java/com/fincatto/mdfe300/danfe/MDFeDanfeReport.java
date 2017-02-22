package com.fincatto.mdfe300.danfe;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRXmlDataSource;

public class MDFeDanfeReport {

    private final File xml;

    public MDFeDanfeReport(File xml) {
        this.xml = xml;
    }

    public byte[] gerarDanfeMDFe(byte[] logoEmpresa) throws Exception {
        return toPDF(createJasperPrintMDFe(logoEmpresa));
    }

    private static byte[] toPDF(JasperPrint print) throws JRException {
    	return JasperExportManager.exportReportToPdf(print);
    }

    public JasperPrint createJasperPrintMDFe(byte[] logoEmpresa) throws IOException, JRException {
    	try (InputStream in = MDFeDanfeReport.class.getClassLoader().getResourceAsStream("danfe/DANFE_MDFE_RODO_RETRATO.jasper");) {
            final JRPropertiesUtil jrPropertiesUtil = JRPropertiesUtil.getInstance(DefaultJasperReportsContext.getInstance());
            jrPropertiesUtil.setProperty("net.sf.jasperreports.xpath.executer.factory", "net.sf.jasperreports.engine.util.xml.JaxenXPathExecuterFactory");
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("LOGO_EMPRESA", (logoEmpresa == null ? null : new ByteArrayInputStream(logoEmpresa)));
            return JasperFillManager.fillReport(in, parameters, new JRXmlDataSource(this.xml, "/mdfeProc"));
        }
    }

}
