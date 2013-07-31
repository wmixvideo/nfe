package com.fincatto.nfe.v200.classes.lote.consulta;

import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe.transformers.NFRegistryMatcher;

public class TConsReciNFeTest {
	
	@Test
	public void testNaoPodeHaverDiferencaEntreLeituraEGravacao() throws Exception {
		Persister persister = new Persister(new NFRegistryMatcher(), new Format(0));
		TConsReciNFe consultaLoteLido = persister.read(TConsReciNFe.class, TConsReciNFeTest.class.getResourceAsStream("lote_consulta.xml"));
		try (StringWriter consultaLoteGerado = new StringWriter()) {
			persister.write(consultaLoteLido, consultaLoteGerado);
			// System.out.println(consultaLoteLido.toString());
			// System.out.println(consultaLoteGerado.toString());
			Assert.assertEquals(consultaLoteLido.toString(), consultaLoteGerado.toString());
		}
	}
}