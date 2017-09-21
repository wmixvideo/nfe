package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFUnidadeFederativa;

public class NFUnidadeFederativaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("AC", DFUnidadeFederativa.AC.getCodigo());
        Assert.assertEquals("12", DFUnidadeFederativa.AC.getCodigoIbge());

        Assert.assertEquals("AL", DFUnidadeFederativa.AL.getCodigo());
        Assert.assertEquals("27", DFUnidadeFederativa.AL.getCodigoIbge());

        Assert.assertEquals("AM", DFUnidadeFederativa.AM.getCodigo());
        Assert.assertEquals("13", DFUnidadeFederativa.AM.getCodigoIbge());

        Assert.assertEquals("AP", DFUnidadeFederativa.AP.getCodigo());
        Assert.assertEquals("16", DFUnidadeFederativa.AP.getCodigoIbge());

        Assert.assertEquals("BA", DFUnidadeFederativa.BA.getCodigo());
        Assert.assertEquals("29", DFUnidadeFederativa.BA.getCodigoIbge());

        Assert.assertEquals("CE", DFUnidadeFederativa.CE.getCodigo());
        Assert.assertEquals("23", DFUnidadeFederativa.CE.getCodigoIbge());

        Assert.assertEquals("DF", DFUnidadeFederativa.DF.getCodigo());
        Assert.assertEquals("53", DFUnidadeFederativa.DF.getCodigoIbge());

        Assert.assertEquals("ES", DFUnidadeFederativa.ES.getCodigo());
        Assert.assertEquals("32", DFUnidadeFederativa.ES.getCodigoIbge());

        Assert.assertEquals("GO", DFUnidadeFederativa.GO.getCodigo());
        Assert.assertEquals("52", DFUnidadeFederativa.GO.getCodigoIbge());

        Assert.assertEquals("MA", DFUnidadeFederativa.MA.getCodigo());
        Assert.assertEquals("21", DFUnidadeFederativa.MA.getCodigoIbge());

        Assert.assertEquals("MG", DFUnidadeFederativa.MG.getCodigo());
        Assert.assertEquals("31", DFUnidadeFederativa.MG.getCodigoIbge());

        Assert.assertEquals("MS", DFUnidadeFederativa.MS.getCodigo());
        Assert.assertEquals("50", DFUnidadeFederativa.MS.getCodigoIbge());

        Assert.assertEquals("MT", DFUnidadeFederativa.MT.getCodigo());
        Assert.assertEquals("51", DFUnidadeFederativa.MT.getCodigoIbge());

        Assert.assertEquals("PA", DFUnidadeFederativa.PA.getCodigo());
        Assert.assertEquals("15", DFUnidadeFederativa.PA.getCodigoIbge());

        Assert.assertEquals("PB", DFUnidadeFederativa.PB.getCodigo());
        Assert.assertEquals("25", DFUnidadeFederativa.PB.getCodigoIbge());

        Assert.assertEquals("PE", DFUnidadeFederativa.PE.getCodigo());
        Assert.assertEquals("26", DFUnidadeFederativa.PE.getCodigoIbge());

        Assert.assertEquals("PI", DFUnidadeFederativa.PI.getCodigo());
        Assert.assertEquals("22", DFUnidadeFederativa.PI.getCodigoIbge());

        Assert.assertEquals("PR", DFUnidadeFederativa.PR.getCodigo());
        Assert.assertEquals("41", DFUnidadeFederativa.PR.getCodigoIbge());

        Assert.assertEquals("RJ", DFUnidadeFederativa.RJ.getCodigo());
        Assert.assertEquals("33", DFUnidadeFederativa.RJ.getCodigoIbge());

        Assert.assertEquals("RN", DFUnidadeFederativa.RN.getCodigo());
        Assert.assertEquals("24", DFUnidadeFederativa.RN.getCodigoIbge());

        Assert.assertEquals("RO", DFUnidadeFederativa.RO.getCodigo());
        Assert.assertEquals("11", DFUnidadeFederativa.RO.getCodigoIbge());

        Assert.assertEquals("RR", DFUnidadeFederativa.RR.getCodigo());
        Assert.assertEquals("14", DFUnidadeFederativa.RR.getCodigoIbge());

        Assert.assertEquals("RS", DFUnidadeFederativa.RS.getCodigo());
        Assert.assertEquals("43", DFUnidadeFederativa.RS.getCodigoIbge());

        Assert.assertEquals("SC", DFUnidadeFederativa.SC.getCodigo());
        Assert.assertEquals("42", DFUnidadeFederativa.SC.getCodigoIbge());

        Assert.assertEquals("SE", DFUnidadeFederativa.SE.getCodigo());
        Assert.assertEquals("28", DFUnidadeFederativa.SE.getCodigoIbge());

        Assert.assertEquals("SP", DFUnidadeFederativa.SP.getCodigo());
        Assert.assertEquals("35", DFUnidadeFederativa.SP.getCodigoIbge());

        Assert.assertEquals("TO", DFUnidadeFederativa.TO.getCodigo());
        Assert.assertEquals("17", DFUnidadeFederativa.TO.getCodigoIbge());

        Assert.assertEquals("NC", DFUnidadeFederativa.NACIONAL.getCodigo());
        Assert.assertEquals("90", DFUnidadeFederativa.NACIONAL.getCodigoIbge());

        Assert.assertEquals("RFB", DFUnidadeFederativa.RFB.getCodigo());
        Assert.assertEquals("91", DFUnidadeFederativa.RFB.getCodigoIbge());

        Assert.assertEquals("EX", DFUnidadeFederativa.EX.getCodigo());
        Assert.assertEquals("99", DFUnidadeFederativa.EX.getCodigoIbge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoTenteBuscarUmCodigoErrado() {
        DFUnidadeFederativa.valueOfCodigo("1");
    }

    @Test
    public void deveSerADescricaoAoInvocaarToString() {
        Assert.assertEquals("Santa Catarina", DFUnidadeFederativa.SC.toString());
    }

    @Test
    public void deveObterAtravesDaSiglaAUF() {
        Assert.assertEquals(DFUnidadeFederativa.AC, DFUnidadeFederativa.valueOfCodigo("AC"));
        Assert.assertEquals(DFUnidadeFederativa.AL, DFUnidadeFederativa.valueOfCodigo("AL"));
        Assert.assertEquals(DFUnidadeFederativa.AM, DFUnidadeFederativa.valueOfCodigo("AM"));
        Assert.assertEquals(DFUnidadeFederativa.AP, DFUnidadeFederativa.valueOfCodigo("AP"));
        Assert.assertEquals(DFUnidadeFederativa.BA, DFUnidadeFederativa.valueOfCodigo("BA"));
        Assert.assertEquals(DFUnidadeFederativa.CE, DFUnidadeFederativa.valueOfCodigo("CE"));
        Assert.assertEquals(DFUnidadeFederativa.DF, DFUnidadeFederativa.valueOfCodigo("DF"));
        Assert.assertEquals(DFUnidadeFederativa.ES, DFUnidadeFederativa.valueOfCodigo("ES"));
        Assert.assertEquals(DFUnidadeFederativa.EX, DFUnidadeFederativa.valueOfCodigo("EX"));
        Assert.assertEquals(DFUnidadeFederativa.GO, DFUnidadeFederativa.valueOfCodigo("GO"));
        Assert.assertEquals(DFUnidadeFederativa.MA, DFUnidadeFederativa.valueOfCodigo("MA"));
        Assert.assertEquals(DFUnidadeFederativa.MG, DFUnidadeFederativa.valueOfCodigo("MG"));
        Assert.assertEquals(DFUnidadeFederativa.MS, DFUnidadeFederativa.valueOfCodigo("MS"));
        Assert.assertEquals(DFUnidadeFederativa.MT, DFUnidadeFederativa.valueOfCodigo("MT"));
        Assert.assertEquals(DFUnidadeFederativa.NACIONAL, DFUnidadeFederativa.valueOfCodigo("NC"));
        Assert.assertEquals(DFUnidadeFederativa.PA, DFUnidadeFederativa.valueOfCodigo("PA"));
        Assert.assertEquals(DFUnidadeFederativa.PB, DFUnidadeFederativa.valueOfCodigo("PB"));
        Assert.assertEquals(DFUnidadeFederativa.PE, DFUnidadeFederativa.valueOfCodigo("PE"));
        Assert.assertEquals(DFUnidadeFederativa.PI, DFUnidadeFederativa.valueOfCodigo("PI"));
        Assert.assertEquals(DFUnidadeFederativa.PR, DFUnidadeFederativa.valueOfCodigo("PR"));
        Assert.assertEquals(DFUnidadeFederativa.RFB, DFUnidadeFederativa.valueOfCodigo("RFB"));
        Assert.assertEquals(DFUnidadeFederativa.RJ, DFUnidadeFederativa.valueOfCodigo("RJ"));
        Assert.assertEquals(DFUnidadeFederativa.RN, DFUnidadeFederativa.valueOfCodigo("RN"));
        Assert.assertEquals(DFUnidadeFederativa.RO, DFUnidadeFederativa.valueOfCodigo("RO"));
        Assert.assertEquals(DFUnidadeFederativa.RR, DFUnidadeFederativa.valueOfCodigo("RR"));
        Assert.assertEquals(DFUnidadeFederativa.RS, DFUnidadeFederativa.valueOfCodigo("RS"));
        Assert.assertEquals(DFUnidadeFederativa.SC, DFUnidadeFederativa.valueOfCodigo("SC"));
        Assert.assertEquals(DFUnidadeFederativa.SE, DFUnidadeFederativa.valueOfCodigo("SE"));
        Assert.assertEquals(DFUnidadeFederativa.SP, DFUnidadeFederativa.valueOfCodigo("SP"));
        Assert.assertEquals(DFUnidadeFederativa.TO, DFUnidadeFederativa.valueOfCodigo("TO"));
    }
}