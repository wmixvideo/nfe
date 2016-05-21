package com.fincatto.nfe310.classes.danfe;

import java.util.ArrayList;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.fincatto.nfe310.classes.nota.NFNota;

public class NFDanfeReport {
	private static ArrayList<NFNota> notaList;

	public static void imprimirDanfe(NFNota notaProcessadaSefaz,
			String pathDestino) {
		notaList.add(notaProcessadaSefaz);

		try {
			JasperReport report = JasperCompileManager
					.compileReport("danfe/DANFE.jrxml");
			JasperPrint print = JasperFillManager.fillReport(report, null,
					new JRBeanCollectionDataSource(notaList));
			JasperExportManager.exportReportToPdfFile(print, pathDestino);
			System.out.println("Danfe impresso em: " + pathDestino);

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
