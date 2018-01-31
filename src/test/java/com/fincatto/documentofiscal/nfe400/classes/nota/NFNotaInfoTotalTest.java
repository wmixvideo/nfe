package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFNotaInfoTotalTest {

    @Test
    public void devePermitirRetencoesTributosNulo() {
        final NFNotaInfoTotal total = new NFNotaInfoTotal();
        total.setIcmsTotal(FabricaDeObjetosFake.getNFNotaInfoICMSTotal());
        total.setIssqnTotal(FabricaDeObjetosFake.getNFNotaInfoISSQNTotal());
        total.toString();
    }

    @Test
    public void devePermitirISSQNTotalNulo() {
        final NFNotaInfoTotal total = new NFNotaInfoTotal();
        total.setIcmsTotal(FabricaDeObjetosFake.getNFNotaInfoICMSTotal());
        total.setRetencoesTributos(FabricaDeObjetosFake.getNFNotaInfoRetencoesTributos());
        total.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirICMSTotalNulo() {
        final NFNotaInfoTotal total = new NFNotaInfoTotal();
        total.setIssqnTotal(FabricaDeObjetosFake.getNFNotaInfoISSQNTotal());
        total.setRetencoesTributos(FabricaDeObjetosFake.getNFNotaInfoRetencoesTributos());
        total.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoTotal><ICMSTot><vBC>999999999999.99</vBC><vICMS>999999999999.99</vICMS><vICMSDeson>999999999999.99</vICMSDeson><vFCPUFDest>999999999999.99</vFCPUFDest><vICMSUFDest>999999999999.99</vICMSUFDest><vICMSUFRemet>999999999999.99</vICMSUFRemet><vFCP>999999999999.99</vFCP><vBCST>999999999999.99</vBCST><vST>999999999999.99</vST><vFCPST>999999999999.99</vFCPST><vFCPSTRet>999999999999.99</vFCPSTRet><vProd>999999999999.99</vProd><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vII>999999999999.99</vII><vIPI>999999999999.99</vIPI><vIPIDevol>999999999999.99</vIPIDevol><vPIS>999999999999.99</vPIS><vCOFINS>999999999999.99</vCOFINS><vOutro>999999999999.99</vOutro><vNF>999999999999.99</vNF></ICMSTot><ISSQNtot><vServ>999999999999.99</vServ><vBC>999999999999.99</vBC><vISS>999999999999.99</vISS><vPIS>999999999999.99</vPIS><vCOFINS>999999999999.99</vCOFINS><dCompet>2014-01-01</dCompet><vDeducao>999999999999.99</vDeducao><vOutro>999999999999.99</vOutro><vDescIncond>999999999999.99</vDescIncond><vDescCond>999999999999.99</vDescCond><vISSRet>999999999999.99</vISSRet><cRegTrib>3</cRegTrib></ISSQNtot><retTrib><vRetPIS>999999999999.99</vRetPIS><vRetCOFINS>999999999999.99</vRetCOFINS><vRetCSLL>999999999999.99</vRetCSLL><vBCIRRF>999999999999.99</vBCIRRF><vIRRF>999999999999.99</vIRRF><vBCRetPrev>999999999999.99</vBCRetPrev><vRetPrev>999999999999.99</vRetPrev></retTrib></NFNotaInfoTotal>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoTotal().toString());
    }
}