package com.fincatto.nfe.v200.classes.lote.recibo;

import java.io.StringWriter;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.transform.RegistryMatcher;

import com.fincatto.nfe.v200.classes.DateFormatTransformer;
import com.fincatto.nfe.v200.classes.lote.recibo.TRetEnviNFe;

public class TRetEnviNFeTest {
	
	@Test
	public void testNaoPodeHaverDiferencaEntreLeituraEGravacao() throws Exception {
		RegistryMatcher registryMatcher = new RegistryMatcher();
		registryMatcher.bind(Date.class, new DateFormatTransformer());
		Persister persister = new Persister(registryMatcher, new Format(0));
		TRetEnviNFe reciboLoteLido = persister.read(TRetEnviNFe.class, TRetEnviNFeTest.class.getResourceAsStream("lote_recibo.xml"));
		try (StringWriter reciboLoteGerado = new StringWriter()) {
			persister.write(reciboLoteLido, reciboLoteGerado);
			// System.out.println(reciboLoteLido.toString());
			// System.out.println(reciboLoteGerado.toString());
			Assert.assertEquals(reciboLoteLido.toString(), reciboLoteGerado.toString());
		}
	}
}