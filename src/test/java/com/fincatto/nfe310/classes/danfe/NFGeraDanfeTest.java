package com.fincatto.nfe310.classes.danfe;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.NFProtocolo;
import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.classes.nota.NFNotaInfo;
import com.fincatto.nfe310.classes.nota.NFNotaProcessada;
import com.fincatto.nfe310.classes.nota.assinatura.NFSignature;

public class NFGeraDanfeTest {

	@Test
	public void deveGerarDanfeAPartirDoXML() throws Exception {
		final NFNota nota = new NFNota();
		final NFNotaProcessada notaProcessada = new NFNotaProcessada();
		final NFSignature assinatura = new NFSignature();
		assinatura.setSignatureValue("NFe89172658591754401086218048846976493475937081");
		final NFNotaInfo notaInfo = FabricaDeObjetosFake.getNFNotaInfo();
		final int identificadorLocal = 123456;
		final NFProtocolo nfProtocolo = new NFProtocolo();
		nota.setAssinatura(assinatura);
		nota.setInfo(notaInfo);
		nota.setIdentificadorLocal(identificadorLocal);
		notaProcessada.setNota(nota);
		notaProcessada.setVersao(new BigDecimal(10));
		nfProtocolo.setProtocoloInfo(FabricaDeObjetosFake.getNFProtocoloInfo());
		nfProtocolo.setVersao("3.10");
		notaProcessada.setProtocolo(nfProtocolo);

		Assert.assertFalse(NFDanfeReport.imprimirDanfe(notaProcessada).length == 0);
	}
}
