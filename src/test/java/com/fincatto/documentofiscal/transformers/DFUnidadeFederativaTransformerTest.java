package com.fincatto.documentofiscal.transformers;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFUnidadeFederativa;

public class DFUnidadeFederativaTransformerTest {

	@Test
	public void deveTestarLeitura() throws Exception {
		Assert.assertEquals(DFUnidadeFederativa.AC, new DFUnidadeFederativaTransformer().read("12"));
		Assert.assertEquals(DFUnidadeFederativa.AL, new DFUnidadeFederativaTransformer().read("27"));
		Assert.assertEquals(DFUnidadeFederativa.AP, new DFUnidadeFederativaTransformer().read("16"));
		Assert.assertEquals(DFUnidadeFederativa.AM, new DFUnidadeFederativaTransformer().read("13"));
		Assert.assertEquals(DFUnidadeFederativa.BA, new DFUnidadeFederativaTransformer().read("29"));
		Assert.assertEquals(DFUnidadeFederativa.CE, new DFUnidadeFederativaTransformer().read("23"));
		Assert.assertEquals(DFUnidadeFederativa.DF, new DFUnidadeFederativaTransformer().read("53"));
		Assert.assertEquals(DFUnidadeFederativa.GO, new DFUnidadeFederativaTransformer().read("52"));
		Assert.assertEquals(DFUnidadeFederativa.ES, new DFUnidadeFederativaTransformer().read("32"));
		Assert.assertEquals(DFUnidadeFederativa.MA, new DFUnidadeFederativaTransformer().read("21"));
		Assert.assertEquals(DFUnidadeFederativa.MT, new DFUnidadeFederativaTransformer().read("51"));
		Assert.assertEquals(DFUnidadeFederativa.MS, new DFUnidadeFederativaTransformer().read("50"));
		Assert.assertEquals(DFUnidadeFederativa.MG, new DFUnidadeFederativaTransformer().read("31"));
		Assert.assertEquals(DFUnidadeFederativa.PA, new DFUnidadeFederativaTransformer().read("15"));
		Assert.assertEquals(DFUnidadeFederativa.PB, new DFUnidadeFederativaTransformer().read("25"));
		Assert.assertEquals(DFUnidadeFederativa.PR, new DFUnidadeFederativaTransformer().read("41"));
		Assert.assertEquals(DFUnidadeFederativa.PE, new DFUnidadeFederativaTransformer().read("26"));
		Assert.assertEquals(DFUnidadeFederativa.PI, new DFUnidadeFederativaTransformer().read("22"));
		Assert.assertEquals(DFUnidadeFederativa.RJ, new DFUnidadeFederativaTransformer().read("33"));
		Assert.assertEquals(DFUnidadeFederativa.RN, new DFUnidadeFederativaTransformer().read("24"));
		Assert.assertEquals(DFUnidadeFederativa.RS, new DFUnidadeFederativaTransformer().read("43"));
		Assert.assertEquals(DFUnidadeFederativa.RO, new DFUnidadeFederativaTransformer().read("11"));
		Assert.assertEquals(DFUnidadeFederativa.RR, new DFUnidadeFederativaTransformer().read("14"));
		Assert.assertEquals(DFUnidadeFederativa.SP, new DFUnidadeFederativaTransformer().read("35"));
		Assert.assertEquals(DFUnidadeFederativa.SC, new DFUnidadeFederativaTransformer().read("42"));
		Assert.assertEquals(DFUnidadeFederativa.SE, new DFUnidadeFederativaTransformer().read("28"));
		Assert.assertEquals(DFUnidadeFederativa.TO, new DFUnidadeFederativaTransformer().read("17"));
		Assert.assertEquals(DFUnidadeFederativa.NACIONAL, new DFUnidadeFederativaTransformer().read("90"));
		Assert.assertEquals(DFUnidadeFederativa.RFB, new DFUnidadeFederativaTransformer().read("91"));
		Assert.assertEquals(DFUnidadeFederativa.EX, new DFUnidadeFederativaTransformer().read("99"));
	}

	@Test
	public void deveTestarEscrita() throws Exception {
		Assert.assertEquals("12", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AC));
		Assert.assertEquals("27", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AL));
		Assert.assertEquals("16", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AP));
		Assert.assertEquals("13", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AM));
		Assert.assertEquals("29", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.BA));
		Assert.assertEquals("23", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.CE));
		Assert.assertEquals("53", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.DF));
		Assert.assertEquals("52", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.GO));
		Assert.assertEquals("32", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.ES));
		Assert.assertEquals("21", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MA));
		Assert.assertEquals("51", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MT));
		Assert.assertEquals("50", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MS));
		Assert.assertEquals("31", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MG));
		Assert.assertEquals("15", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PA));
		Assert.assertEquals("25", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PB));
		Assert.assertEquals("41", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PR));
		Assert.assertEquals("26", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PE));
		Assert.assertEquals("22", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PI));
		Assert.assertEquals("33", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RJ));
		Assert.assertEquals("24", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RN));
		Assert.assertEquals("43", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RS));
		Assert.assertEquals("11", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RO));
		Assert.assertEquals("14", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RR));
		Assert.assertEquals("35", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.SP));
		Assert.assertEquals("42", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.SC));
		Assert.assertEquals("28", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.SE));
		Assert.assertEquals("17", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.TO));
		Assert.assertEquals("90", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.NACIONAL));
		Assert.assertEquals("91", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RFB));
		Assert.assertEquals("99", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.EX));
	}

}
