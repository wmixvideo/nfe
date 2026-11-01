package com.fincatto.documentofiscal.transformers;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DFUnidadeFederativaTransformerTest {

	@Test
	public void deveTestarLeitura() throws Exception {
		Assertions.assertEquals(DFUnidadeFederativa.AC, new DFUnidadeFederativaTransformer().read("12"));
		Assertions.assertEquals(DFUnidadeFederativa.AL, new DFUnidadeFederativaTransformer().read("27"));
		Assertions.assertEquals(DFUnidadeFederativa.AP, new DFUnidadeFederativaTransformer().read("16"));
		Assertions.assertEquals(DFUnidadeFederativa.AM, new DFUnidadeFederativaTransformer().read("13"));
		Assertions.assertEquals(DFUnidadeFederativa.BA, new DFUnidadeFederativaTransformer().read("29"));
		Assertions.assertEquals(DFUnidadeFederativa.CE, new DFUnidadeFederativaTransformer().read("23"));
		Assertions.assertEquals(DFUnidadeFederativa.DF, new DFUnidadeFederativaTransformer().read("53"));
		Assertions.assertEquals(DFUnidadeFederativa.GO, new DFUnidadeFederativaTransformer().read("52"));
		Assertions.assertEquals(DFUnidadeFederativa.ES, new DFUnidadeFederativaTransformer().read("32"));
		Assertions.assertEquals(DFUnidadeFederativa.MA, new DFUnidadeFederativaTransformer().read("21"));
		Assertions.assertEquals(DFUnidadeFederativa.MT, new DFUnidadeFederativaTransformer().read("51"));
		Assertions.assertEquals(DFUnidadeFederativa.MS, new DFUnidadeFederativaTransformer().read("50"));
		Assertions.assertEquals(DFUnidadeFederativa.MG, new DFUnidadeFederativaTransformer().read("31"));
		Assertions.assertEquals(DFUnidadeFederativa.PA, new DFUnidadeFederativaTransformer().read("15"));
		Assertions.assertEquals(DFUnidadeFederativa.PB, new DFUnidadeFederativaTransformer().read("25"));
		Assertions.assertEquals(DFUnidadeFederativa.PR, new DFUnidadeFederativaTransformer().read("41"));
		Assertions.assertEquals(DFUnidadeFederativa.PE, new DFUnidadeFederativaTransformer().read("26"));
		Assertions.assertEquals(DFUnidadeFederativa.PI, new DFUnidadeFederativaTransformer().read("22"));
		Assertions.assertEquals(DFUnidadeFederativa.RJ, new DFUnidadeFederativaTransformer().read("33"));
		Assertions.assertEquals(DFUnidadeFederativa.RN, new DFUnidadeFederativaTransformer().read("24"));
		Assertions.assertEquals(DFUnidadeFederativa.RS, new DFUnidadeFederativaTransformer().read("43"));
		Assertions.assertEquals(DFUnidadeFederativa.RO, new DFUnidadeFederativaTransformer().read("11"));
		Assertions.assertEquals(DFUnidadeFederativa.RR, new DFUnidadeFederativaTransformer().read("14"));
		Assertions.assertEquals(DFUnidadeFederativa.SP, new DFUnidadeFederativaTransformer().read("35"));
		Assertions.assertEquals(DFUnidadeFederativa.SC, new DFUnidadeFederativaTransformer().read("42"));
		Assertions.assertEquals(DFUnidadeFederativa.SE, new DFUnidadeFederativaTransformer().read("28"));
		Assertions.assertEquals(DFUnidadeFederativa.TO, new DFUnidadeFederativaTransformer().read("17"));
		Assertions.assertEquals(DFUnidadeFederativa.NACIONAL, new DFUnidadeFederativaTransformer().read("90"));
		Assertions.assertEquals(DFUnidadeFederativa.RFB, new DFUnidadeFederativaTransformer().read("91"));
		Assertions.assertEquals(DFUnidadeFederativa.EX, new DFUnidadeFederativaTransformer().read("99"));
	}

	@Test
	public void deveTestarEscrita() throws Exception {
		Assertions.assertEquals("12", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AC));
		Assertions.assertEquals("27", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AL));
		Assertions.assertEquals("16", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AP));
		Assertions.assertEquals("13", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AM));
		Assertions.assertEquals("29", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.BA));
		Assertions.assertEquals("23", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.CE));
		Assertions.assertEquals("53", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.DF));
		Assertions.assertEquals("52", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.GO));
		Assertions.assertEquals("32", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.ES));
		Assertions.assertEquals("21", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MA));
		Assertions.assertEquals("51", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MT));
		Assertions.assertEquals("50", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MS));
		Assertions.assertEquals("31", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MG));
		Assertions.assertEquals("15", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PA));
		Assertions.assertEquals("25", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PB));
		Assertions.assertEquals("41", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PR));
		Assertions.assertEquals("26", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PE));
		Assertions.assertEquals("22", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PI));
		Assertions.assertEquals("33", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RJ));
		Assertions.assertEquals("24", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RN));
		Assertions.assertEquals("43", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RS));
		Assertions.assertEquals("11", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RO));
		Assertions.assertEquals("14", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RR));
		Assertions.assertEquals("35", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.SP));
		Assertions.assertEquals("42", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.SC));
		Assertions.assertEquals("28", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.SE));
		Assertions.assertEquals("17", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.TO));
		Assertions.assertEquals("90", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.NACIONAL));
		Assertions.assertEquals("91", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RFB));
		Assertions.assertEquals("99", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.EX));
	}

}
