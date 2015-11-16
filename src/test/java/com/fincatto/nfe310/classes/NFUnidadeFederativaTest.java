package com.fincatto.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFUnidadeFederativaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("AC", NFUnidadeFederativa.AC.getCodigo());
        Assert.assertEquals("12", NFUnidadeFederativa.AC.getCodigoIbge());

        Assert.assertEquals("AL", NFUnidadeFederativa.AL.getCodigo());
        Assert.assertEquals("27", NFUnidadeFederativa.AL.getCodigoIbge());

        Assert.assertEquals("AM", NFUnidadeFederativa.AM.getCodigo());
        Assert.assertEquals("13", NFUnidadeFederativa.AM.getCodigoIbge());

        Assert.assertEquals("AP", NFUnidadeFederativa.AP.getCodigo());
        Assert.assertEquals("16", NFUnidadeFederativa.AP.getCodigoIbge());

        Assert.assertEquals("BA", NFUnidadeFederativa.BA.getCodigo());
        Assert.assertEquals("29", NFUnidadeFederativa.BA.getCodigoIbge());

        Assert.assertEquals("CE", NFUnidadeFederativa.CE.getCodigo());
        Assert.assertEquals("23", NFUnidadeFederativa.CE.getCodigoIbge());

        Assert.assertEquals("DF", NFUnidadeFederativa.DF.getCodigo());
        Assert.assertEquals("53", NFUnidadeFederativa.DF.getCodigoIbge());

        Assert.assertEquals("ES", NFUnidadeFederativa.ES.getCodigo());
        Assert.assertEquals("32", NFUnidadeFederativa.ES.getCodigoIbge());

        Assert.assertEquals("GO", NFUnidadeFederativa.GO.getCodigo());
        Assert.assertEquals("52", NFUnidadeFederativa.GO.getCodigoIbge());

        Assert.assertEquals("MA", NFUnidadeFederativa.MA.getCodigo());
        Assert.assertEquals("21", NFUnidadeFederativa.MA.getCodigoIbge());

        Assert.assertEquals("MG", NFUnidadeFederativa.MG.getCodigo());
        Assert.assertEquals("31", NFUnidadeFederativa.MG.getCodigoIbge());

        Assert.assertEquals("MS", NFUnidadeFederativa.MS.getCodigo());
        Assert.assertEquals("50", NFUnidadeFederativa.MS.getCodigoIbge());

        Assert.assertEquals("MT", NFUnidadeFederativa.MT.getCodigo());
        Assert.assertEquals("51", NFUnidadeFederativa.MT.getCodigoIbge());

        Assert.assertEquals("PA", NFUnidadeFederativa.PA.getCodigo());
        Assert.assertEquals("15", NFUnidadeFederativa.PA.getCodigoIbge());

        Assert.assertEquals("PB", NFUnidadeFederativa.PB.getCodigo());
        Assert.assertEquals("25", NFUnidadeFederativa.PB.getCodigoIbge());

        Assert.assertEquals("PE", NFUnidadeFederativa.PE.getCodigo());
        Assert.assertEquals("26", NFUnidadeFederativa.PE.getCodigoIbge());

        Assert.assertEquals("PI", NFUnidadeFederativa.PI.getCodigo());
        Assert.assertEquals("22", NFUnidadeFederativa.PI.getCodigoIbge());

        Assert.assertEquals("PR", NFUnidadeFederativa.PR.getCodigo());
        Assert.assertEquals("41", NFUnidadeFederativa.PR.getCodigoIbge());

        Assert.assertEquals("RJ", NFUnidadeFederativa.RJ.getCodigo());
        Assert.assertEquals("33", NFUnidadeFederativa.RJ.getCodigoIbge());

        Assert.assertEquals("RN", NFUnidadeFederativa.RN.getCodigo());
        Assert.assertEquals("24", NFUnidadeFederativa.RN.getCodigoIbge());

        Assert.assertEquals("RO", NFUnidadeFederativa.RO.getCodigo());
        Assert.assertEquals("11", NFUnidadeFederativa.RO.getCodigoIbge());

        Assert.assertEquals("RR", NFUnidadeFederativa.RR.getCodigo());
        Assert.assertEquals("14", NFUnidadeFederativa.RR.getCodigoIbge());

        Assert.assertEquals("RS", NFUnidadeFederativa.RS.getCodigo());
        Assert.assertEquals("43", NFUnidadeFederativa.RS.getCodigoIbge());

        Assert.assertEquals("SC", NFUnidadeFederativa.SC.getCodigo());
        Assert.assertEquals("42", NFUnidadeFederativa.SC.getCodigoIbge());

        Assert.assertEquals("SE", NFUnidadeFederativa.SE.getCodigo());
        Assert.assertEquals("28", NFUnidadeFederativa.SE.getCodigoIbge());

        Assert.assertEquals("SP", NFUnidadeFederativa.SP.getCodigo());
        Assert.assertEquals("35", NFUnidadeFederativa.SP.getCodigoIbge());

        Assert.assertEquals("TO", NFUnidadeFederativa.TO.getCodigo());
        Assert.assertEquals("17", NFUnidadeFederativa.TO.getCodigoIbge());

        Assert.assertEquals("NC", NFUnidadeFederativa.NACIONAL.getCodigo());
        Assert.assertEquals("90", NFUnidadeFederativa.NACIONAL.getCodigoIbge());

        Assert.assertEquals("RFB", NFUnidadeFederativa.RFB.getCodigo());
        Assert.assertEquals("91", NFUnidadeFederativa.RFB.getCodigoIbge());

        Assert.assertEquals("EX", NFUnidadeFederativa.EX.getCodigo());
        Assert.assertEquals("99", NFUnidadeFederativa.EX.getCodigoIbge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoTenteBuscarUmCodigoErrado() {
        NFUnidadeFederativa.valueOfCodigo("1");
    }

    @Test
    public void deveSerADescricaoAoInvocaarToString() {
        Assert.assertEquals("Santa Catarina", NFUnidadeFederativa.SC.toString());
    }

    @Test
    public void deveObterAtravesDaSiglaAUF() {
        Assert.assertEquals(NFUnidadeFederativa.AC, NFUnidadeFederativa.valueOfCodigo("AC"));
        Assert.assertEquals(NFUnidadeFederativa.AL, NFUnidadeFederativa.valueOfCodigo("AL"));
        Assert.assertEquals(NFUnidadeFederativa.AM, NFUnidadeFederativa.valueOfCodigo("AM"));
        Assert.assertEquals(NFUnidadeFederativa.AP, NFUnidadeFederativa.valueOfCodigo("AP"));
        Assert.assertEquals(NFUnidadeFederativa.BA, NFUnidadeFederativa.valueOfCodigo("BA"));
        Assert.assertEquals(NFUnidadeFederativa.CE, NFUnidadeFederativa.valueOfCodigo("CE"));
        Assert.assertEquals(NFUnidadeFederativa.DF, NFUnidadeFederativa.valueOfCodigo("DF"));
        Assert.assertEquals(NFUnidadeFederativa.ES, NFUnidadeFederativa.valueOfCodigo("ES"));
        Assert.assertEquals(NFUnidadeFederativa.EX, NFUnidadeFederativa.valueOfCodigo("EX"));
        Assert.assertEquals(NFUnidadeFederativa.GO, NFUnidadeFederativa.valueOfCodigo("GO"));
        Assert.assertEquals(NFUnidadeFederativa.MA, NFUnidadeFederativa.valueOfCodigo("MA"));
        Assert.assertEquals(NFUnidadeFederativa.MG, NFUnidadeFederativa.valueOfCodigo("MG"));
        Assert.assertEquals(NFUnidadeFederativa.MS, NFUnidadeFederativa.valueOfCodigo("MS"));
        Assert.assertEquals(NFUnidadeFederativa.MT, NFUnidadeFederativa.valueOfCodigo("MT"));
        Assert.assertEquals(NFUnidadeFederativa.NACIONAL, NFUnidadeFederativa.valueOfCodigo("NC"));
        Assert.assertEquals(NFUnidadeFederativa.PA, NFUnidadeFederativa.valueOfCodigo("PA"));
        Assert.assertEquals(NFUnidadeFederativa.PB, NFUnidadeFederativa.valueOfCodigo("PB"));
        Assert.assertEquals(NFUnidadeFederativa.PE, NFUnidadeFederativa.valueOfCodigo("PE"));
        Assert.assertEquals(NFUnidadeFederativa.PI, NFUnidadeFederativa.valueOfCodigo("PI"));
        Assert.assertEquals(NFUnidadeFederativa.PR, NFUnidadeFederativa.valueOfCodigo("PR"));
        Assert.assertEquals(NFUnidadeFederativa.RFB, NFUnidadeFederativa.valueOfCodigo("RFB"));
        Assert.assertEquals(NFUnidadeFederativa.RJ, NFUnidadeFederativa.valueOfCodigo("RJ"));
        Assert.assertEquals(NFUnidadeFederativa.RN, NFUnidadeFederativa.valueOfCodigo("RN"));
        Assert.assertEquals(NFUnidadeFederativa.RO, NFUnidadeFederativa.valueOfCodigo("RO"));
        Assert.assertEquals(NFUnidadeFederativa.RR, NFUnidadeFederativa.valueOfCodigo("RR"));
        Assert.assertEquals(NFUnidadeFederativa.RS, NFUnidadeFederativa.valueOfCodigo("RS"));
        Assert.assertEquals(NFUnidadeFederativa.SC, NFUnidadeFederativa.valueOfCodigo("SC"));
        Assert.assertEquals(NFUnidadeFederativa.SE, NFUnidadeFederativa.valueOfCodigo("SE"));
        Assert.assertEquals(NFUnidadeFederativa.SP, NFUnidadeFederativa.valueOfCodigo("SP"));
        Assert.assertEquals(NFUnidadeFederativa.TO, NFUnidadeFederativa.valueOfCodigo("TO"));
    }
}