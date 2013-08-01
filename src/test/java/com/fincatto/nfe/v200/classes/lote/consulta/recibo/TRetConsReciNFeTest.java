package com.fincatto.nfe.v200.classes.lote.consulta.recibo;

import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe.transformers.NFRegistryMatcher;

public class TRetConsReciNFeTest {
	
	@Test
	public void testNaoPodeHaverDiferencaEntreLeituraEGravacaoParaLoteComReciboNaoLocalizado() throws Exception {
		Persister persister = new Persister(new NFRegistryMatcher(), new Format(0));
		TRetConsReciNFe reciboLoteLido = persister.read(TRetConsReciNFe.class, TRetConsReciNFeTest.class.getResourceAsStream("lote_consulta_recibo_nao_localizado.xml"));
		try (StringWriter reciboLoteGerado = new StringWriter()) {
			persister.write(reciboLoteLido, reciboLoteGerado);
			// System.out.println(reciboLoteLido.toString());
			// System.out.println(reciboLoteGerado.toString());
			Assert.assertEquals(reciboLoteLido.toString(), reciboLoteGerado.toString());
		}
	}
	
	@Test
	public void testNaoPodeHaverDiferencaEntreLeituraEGravacaoParaLoteComReciboOk() throws Exception {
		Persister persister = new Persister(new NFRegistryMatcher(), new Format(0));
		TRetConsReciNFe reciboLoteLido = persister.read(TRetConsReciNFe.class, TRetConsReciNFeTest.class.getResourceAsStream("lote_consulta_recibo_ok.xml"));
		try (StringWriter reciboLoteGerado = new StringWriter()) {
			persister.write(reciboLoteLido, reciboLoteGerado);
			// System.out.println(reciboLoteLido.toString());
			// System.out.println(reciboLoteGerado.toString());
			Assert.assertEquals(reciboLoteLido.toString(), reciboLoteGerado.toString());
		}
	}
}
