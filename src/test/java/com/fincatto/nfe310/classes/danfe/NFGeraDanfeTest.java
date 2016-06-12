package com.fincatto.nfe310.classes.danfe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.classes.nota.NFNotaInfo;
import com.fincatto.nfe310.classes.nota.assinatura.NFSignature;

public class NFGeraDanfeTest {

	@Test
	public void deveGerarDanfeAPartirDoXML() throws IOException {
		final NFNota nota = new NFNota();
		final NFSignature assinatura = new NFSignature();
		assinatura.setSignatureValue("NFe89172658591754401086218048846976493475937081");
		final NFNotaInfo notaInfo = FabricaDeObjetosFake.getNFNotaInfo();
		final int identificadorLocal = 123456;
		nota.setAssinatura(assinatura);
		nota.setInfo(notaInfo);
		nota.setIdentificadorLocal(identificadorLocal);
		nota.toString();
		FileOutputStream fos = new FileOutputStream("/tmp/danfe.pdf");
		fos.write(NFDanfeReport.imprimirDanfe(nota));
		fos.close();
		Assert.assertTrue(new File("/tmp/danfe.pdf").exists());
	}

}
