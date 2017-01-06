package com.fincatto.dfe.transformers;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.dfe.classes.DFUnidadeFederativa;

public class DFUnidadeFederativaTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assert.assertEquals(DFUnidadeFederativa.AC, new DFUnidadeFederativaTransformer().read("AC"));
        Assert.assertEquals(DFUnidadeFederativa.AL, new DFUnidadeFederativaTransformer().read("AL"));
        Assert.assertEquals(DFUnidadeFederativa.AM, new DFUnidadeFederativaTransformer().read("AM"));
        Assert.assertEquals(DFUnidadeFederativa.AP, new DFUnidadeFederativaTransformer().read("AP"));
        Assert.assertEquals(DFUnidadeFederativa.BA, new DFUnidadeFederativaTransformer().read("BA"));
        Assert.assertEquals(DFUnidadeFederativa.CE, new DFUnidadeFederativaTransformer().read("CE"));
        Assert.assertEquals(DFUnidadeFederativa.DF, new DFUnidadeFederativaTransformer().read("DF"));
        Assert.assertEquals(DFUnidadeFederativa.ES, new DFUnidadeFederativaTransformer().read("ES"));
        Assert.assertEquals(DFUnidadeFederativa.GO, new DFUnidadeFederativaTransformer().read("GO"));
        Assert.assertEquals(DFUnidadeFederativa.MA, new DFUnidadeFederativaTransformer().read("MA"));
        Assert.assertEquals(DFUnidadeFederativa.MG, new DFUnidadeFederativaTransformer().read("MG"));
        Assert.assertEquals(DFUnidadeFederativa.MS, new DFUnidadeFederativaTransformer().read("MS"));
        Assert.assertEquals(DFUnidadeFederativa.MT, new DFUnidadeFederativaTransformer().read("MT"));
        Assert.assertEquals(DFUnidadeFederativa.PA, new DFUnidadeFederativaTransformer().read("PA"));
        Assert.assertEquals(DFUnidadeFederativa.PB, new DFUnidadeFederativaTransformer().read("PB"));
        Assert.assertEquals(DFUnidadeFederativa.PE, new DFUnidadeFederativaTransformer().read("PE"));
        Assert.assertEquals(DFUnidadeFederativa.PI, new DFUnidadeFederativaTransformer().read("PI"));
        Assert.assertEquals(DFUnidadeFederativa.PR, new DFUnidadeFederativaTransformer().read("PR"));
        Assert.assertEquals(DFUnidadeFederativa.RJ, new DFUnidadeFederativaTransformer().read("RJ"));
        Assert.assertEquals(DFUnidadeFederativa.RN, new DFUnidadeFederativaTransformer().read("RN"));
        Assert.assertEquals(DFUnidadeFederativa.RO, new DFUnidadeFederativaTransformer().read("RO"));
        Assert.assertEquals(DFUnidadeFederativa.RR, new DFUnidadeFederativaTransformer().read("RR"));
        Assert.assertEquals(DFUnidadeFederativa.RS, new DFUnidadeFederativaTransformer().read("RS"));
        Assert.assertEquals(DFUnidadeFederativa.SC, new DFUnidadeFederativaTransformer().read("SC"));
        Assert.assertEquals(DFUnidadeFederativa.SE, new DFUnidadeFederativaTransformer().read("SE"));
        Assert.assertEquals(DFUnidadeFederativa.SP, new DFUnidadeFederativaTransformer().read("SP"));
        Assert.assertEquals(DFUnidadeFederativa.TO, new DFUnidadeFederativaTransformer().read("TO"));
        Assert.assertEquals(DFUnidadeFederativa.NACIONAL, new DFUnidadeFederativaTransformer().read("NC"));
        Assert.assertEquals(DFUnidadeFederativa.RFB, new DFUnidadeFederativaTransformer().read("RFB"));
        Assert.assertEquals(DFUnidadeFederativa.EX, new DFUnidadeFederativaTransformer().read("EX"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        Assert.assertEquals("12", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AC));
        Assert.assertEquals("27", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AL));
        Assert.assertEquals("13", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AM));
        Assert.assertEquals("16", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.AP));
        Assert.assertEquals("29", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.BA));
        Assert.assertEquals("23", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.CE));
        Assert.assertEquals("53", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.DF));
        Assert.assertEquals("32", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.ES));
        Assert.assertEquals("52", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.GO));
        Assert.assertEquals("21", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MA));
        Assert.assertEquals("31", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MG));
        Assert.assertEquals("50", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MS));
        Assert.assertEquals("51", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.MT));
        Assert.assertEquals("15", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PA));
        Assert.assertEquals("25", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PB));
        Assert.assertEquals("26", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PE));
        Assert.assertEquals("22", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PI));
        Assert.assertEquals("41", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.PR));
        Assert.assertEquals("33", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RJ));
        Assert.assertEquals("24", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RN));
        Assert.assertEquals("11", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RO));
        Assert.assertEquals("14", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RR));
        Assert.assertEquals("43", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RS));
        Assert.assertEquals("42", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.SC));
        Assert.assertEquals("28", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.SE));
        Assert.assertEquals("35", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.SP));
        Assert.assertEquals("17", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.TO));
        Assert.assertEquals("90", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.NACIONAL));
        Assert.assertEquals("91", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.RFB));
        Assert.assertEquals("99", new DFUnidadeFederativaTransformer().write(DFUnidadeFederativa.EX));
    }

    @Test(expected = IllegalArgumentException.class)
	public void deveRetornarExcecaoQuandoCodigoForNull() throws Exception {
		new DFUnidadeFederativaTransformer().read(null);
	}
}