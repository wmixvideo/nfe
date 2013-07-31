package com.fincatto.nfe.v200.classes.lote.envio.recibo;

import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe.transformers.NFRegistryMatcher;

public class TRetEnviNFeTest {
	
	@Test
	public void testNaoPodeHaverDiferencaEntreLeituraEGravacao() throws Exception {
		Persister persister = new Persister(new NFRegistryMatcher(), new Format(0));
		TRetEnviNFe reciboLoteLido = persister.read(TRetEnviNFe.class, TRetEnviNFeTest.class.getResourceAsStream("lote_envio_recibo.xml"));
		try (StringWriter reciboLoteGerado = new StringWriter()) {
			persister.write(reciboLoteLido, reciboLoteGerado);
			System.out.println(reciboLoteLido.toString());
			System.out.println(reciboLoteGerado.toString());
			Assert.assertEquals(reciboLoteLido.toString(), reciboLoteGerado.toString());
		}
	}
}