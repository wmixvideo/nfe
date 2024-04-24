package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

import java.util.ArrayList;
import java.util.List;

public class NFNotaInfoItemTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirInformacoesAdicionaisComTamanhoInvalido() {
        try {
            new NFNotaInfoItem().setInformacoesAdicionais("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItem().setInformacoesAdicionais("R3s36BVI9k15xOe3hnlEpZRpPHEom9inv4hE1oo8hzHYG8X6D9sQjt6oLYiH6yToSFM95zueMhE4s270GB7iLUKcQTRHWLcHb1TU2fSYx2NAz5ZflI3hoTnN8zmqJtGzneaNpDRA5gJW7wxMg9IXIuUCxg25MlIQ46AbDQNc3HLl82g3awWKigBMli0bUEWIMf8C2GG2sB2Y9w1GnsfiDvw7RUuU5vATfWWvYFRCehm2UpDhBlrBjjXcWKYzXsT3x2PNtCC82JqY1nkKrgt2AHCPUjM0tCQk5EHFcssb8I0Rkc4s8aNcARXtFrBzmWqXDQPmCpLIGaAo7LlypOKKaqUNqkRkf8c930p8HaRDvQJealZsVnpwJn3Ev7yEaBZ9INe5PXFwkTQEfpNE3B8IokFMh0aUbu8mfzjKLBazSKW2qA4faIo2Wp5FmOmTzCMiPqznOq3Bl0zM4wmuo0rOXbswjaCUzPB0KpM8Yaze9TArOEDrV6Li1");
        }
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirNumeroItemComTamanhoInvalido() {
        new NFNotaInfoItem().setNumeroItem(991);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirImpostoNulo() {
        final NFNotaInfoItem item = new NFNotaInfoItem();
        item.setInformacoesAdicionais("R3s36BVI9k15xOe3hnlEpZRpPHEom9inv4hE1oo8hzHYG8X6D9sQjt6oLYiH6yToSFM95zueMhE4s270GB7iLUKcQTRHWLcHb1TU2fSYx2NAz5ZflI3hoTnN8zmqJtGzneaNpDRA5gJW7wxMg9IXIuUCxg25MlIQ46AbDQNc3HLl82g3awWKigBMli0bUEWIMf8C2GG2sB2Y9w1GnsfiDvw7RUuU5vATfWWvYFRCehm2UpDhBlrBjjXcWKYzXsT3x2PNtCC82JqY1nkKrgt2AHCPUjM0tCQk5EHFcssb8I0Rkc4s8aNcARXtFrBzmWqXDQPmCpLIGaAo7LlypOKKaqUNqkRkf8c930p8HaRDvQJealZsVnpwJn3Ev7yEaBZ9INe5PXFwkTQEfpNE3B8IokFMh0aUbu8mfzjKLBazSKW2qA4faIo2Wp5FmOmTzCMiPqznOq3Bl0zM4wmuo0rOXbswjaCUzPB0KpM8Yaze9TArOEDrV6Li");
        item.setNumeroItem(99);
        item.setProduto(FabricaDeObjetosFake.getNFNotaInfoItemProduto());
        item.toString();
    }

    @Test
    public void devePermitirInformacoesAdicionaisNulo() {
        final NFNotaInfoItem item = new NFNotaInfoItem();
        item.setImposto(FabricaDeObjetosFake.getNFNotaInfoItemImposto());
        item.setNumeroItem(990);
        item.setProduto(FabricaDeObjetosFake.getNFNotaInfoItemProduto());
        item.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroItemNulo() {
        final NFNotaInfoItem item = new NFNotaInfoItem();
        item.setImposto(FabricaDeObjetosFake.getNFNotaInfoItemImposto());
        item.setInformacoesAdicionais("R3s36BVI9k15xOe3hnlEpZRpPHEom9inv4hE1oo8hzHYG8X6D9sQjt6oLYiH6yToSFM95zueMhE4s270GB7iLUKcQTRHWLcHb1TU2fSYx2NAz5ZflI3hoTnN8zmqJtGzneaNpDRA5gJW7wxMg9IXIuUCxg25MlIQ46AbDQNc3HLl82g3awWKigBMli0bUEWIMf8C2GG2sB2Y9w1GnsfiDvw7RUuU5vATfWWvYFRCehm2UpDhBlrBjjXcWKYzXsT3x2PNtCC82JqY1nkKrgt2AHCPUjM0tCQk5EHFcssb8I0Rkc4s8aNcARXtFrBzmWqXDQPmCpLIGaAo7LlypOKKaqUNqkRkf8c930p8HaRDvQJealZsVnpwJn3Ev7yEaBZ9INe5PXFwkTQEfpNE3B8IokFMh0aUbu8mfzjKLBazSKW2qA4faIo2Wp5FmOmTzCMiPqznOq3Bl0zM4wmuo0rOXbswjaCUzPB0KpM8Yaze9TArOEDrV6Li");
        item.setProduto(FabricaDeObjetosFake.getNFNotaInfoItemProduto());
        item.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirProdutoNulo() {
        final NFNotaInfoItem item = new NFNotaInfoItem();
        item.setImposto(FabricaDeObjetosFake.getNFNotaInfoItemImposto());
        item.setInformacoesAdicionais("R3s36BVI9k15xOe3hnlEpZRpPHEom9inv4hE1oo8hzHYG8X6D9sQjt6oLYiH6yToSFM95zueMhE4s270GB7iLUKcQTRHWLcHb1TU2fSYx2NAz5ZflI3hoTnN8zmqJtGzneaNpDRA5gJW7wxMg9IXIuUCxg25MlIQ46AbDQNc3HLl82g3awWKigBMli0bUEWIMf8C2GG2sB2Y9w1GnsfiDvw7RUuU5vATfWWvYFRCehm2UpDhBlrBjjXcWKYzXsT3x2PNtCC82JqY1nkKrgt2AHCPUjM0tCQk5EHFcssb8I0Rkc4s8aNcARXtFrBzmWqXDQPmCpLIGaAo7LlypOKKaqUNqkRkf8c930p8HaRDvQJealZsVnpwJn3Ev7yEaBZ9INe5PXFwkTQEfpNE3B8IokFMh0aUbu8mfzjKLBazSKW2qA4faIo2Wp5FmOmTzCMiPqznOq3Bl0zM4wmuo0rOXbswjaCUzPB0KpM8Yaze9TArOEDrV6Li");
        item.setNumeroItem(990);
        item.toString();
    }

    @Test
    public void devePermitirImpostoDevolvidoNulo() {
        final NFNotaInfoItem item = new NFNotaInfoItem();
        item.setImposto(FabricaDeObjetosFake.getNFNotaInfoItemImposto());
        item.setInformacoesAdicionais("R3s36BVI9k15xOe3hnlEpZRpPHEom9inv4hE1oo8hzHYG8X6D9sQjt6oLYiH6yToSFM95zueMhE4s270GB7iLUKcQTRHWLcHb1TU2fSYx2NAz5ZflI3hoTnN8zmqJtGzneaNpDRA5gJW7wxMg9IXIuUCxg25MlIQ46AbDQNc3HLl82g3awWKigBMli0bUEWIMf8C2GG2sB2Y9w1GnsfiDvw7RUuU5vATfWWvYFRCehm2UpDhBlrBjjXcWKYzXsT3x2PNtCC82JqY1nkKrgt2AHCPUjM0tCQk5EHFcssb8I0Rkc4s8aNcARXtFrBzmWqXDQPmCpLIGaAo7LlypOKKaqUNqkRkf8c930p8HaRDvQJealZsVnpwJn3Ev7yEaBZ9INe5PXFwkTQEfpNE3B8IokFMh0aUbu8mfzjKLBazSKW2qA4faIo2Wp5FmOmTzCMiPqznOq3Bl0zM4wmuo0rOXbswjaCUzPB0KpM8Yaze9TArOEDrV6Li");
        item.setNumeroItem(990);
        item.setProduto(FabricaDeObjetosFake.getNFNotaInfoItemProduto());
        item.toString();
    }

    @Test
    public void deveGerarXMLComObservacaoContribuinte() {
        NFNotaInfoItem nfNotaInfoItem = FabricaDeObjetosFake.getNFNotaInfoItem();
        final NFNotaInfoObservacao observacao = new NFNotaInfoObservacao();
        observacao.setIdentificacaoCampo("campo");
        observacao.setConteudoCampo("conteudo");
        final List<NFNotaInfoObservacao> nfNotaInfoObservacaos = new ArrayList<>();
        nfNotaInfoObservacaos.add(observacao);
        NFNotaInfoItemObservacao itemObservacao = new NFNotaInfoItemObservacao();
        itemObservacao.setObservacoesContribuinte(nfNotaInfoObservacaos);
        nfNotaInfoItem.setItemObservacao(itemObservacao);
        Assert.assertEquals("<NFNotaInfoItem nItem=\"990\"><prod><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>36811963532505</cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>36811963532505</cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></prod><imposto><vTotTrib>999999999999.99</vTotTrib><ICMS><ICMS00><orig>0</orig><CST>00</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><pFCP>99.99</pFCP><vFCP>999999999999.99</vFCP></ICMS00></ICMS><IPI><CNPJProd>12345678901234</CNPJProd><cSelo>iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5</cSelo><qSelo>999999999999</qSelo><cEnq>aT2</cEnq><IPITrib><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></IPITrib></IPI><II><vBC>999999999999.99</vBC><vDespAdu>999999999999.99</vDespAdu><vII>999999999999.99</vII><vIOF>999999999999.99</vIOF></II><PIS><PISAliq><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq></PIS><PISST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISST><COFINS><COFINSAliq><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq></COFINS><COFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS></COFINSST><ICMSUFDest><vBCUFDest>9999999999999.99</vBCUFDest><vBCFCPUFDest>9999999999999.99</vBCFCPUFDest><pFCPUFDest>999.9999</pFCPUFDest><pICMSUFDest>999.9999</pICMSUFDest><pICMSInter>7.00</pICMSInter><pICMSInterPart>999.9999</pICMSInterPart><vFCPUFDest>9999999999999.99</vFCPUFDest><vICMSUFDest>9999999999999.99</vICMSUFDest><vICMSUFRemet>9999999999999.99</vICMSUFRemet></ICMSUFDest></imposto><impostoDevol><pDevol>100.00</pDevol><IPI><vIPIDevol>9999999999999.99</vIPIDevol></IPI></impostoDevol><infAdProd>R3s36BVI9k15xOe3hnlEpZRpPHEom9inv4hE1oo8hzHYG8X6D9sQjt6oLYiH6yToSFM95zueMhE4s270GB7iLUKcQTRHWLcHb1TU2fSYx2NAz5ZflI3hoTnN8zmqJtGzneaNpDRA5gJW7wxMg9IXIuUCxg25MlIQ46AbDQNc3HLl82g3awWKigBMli0bUEWIMf8C2GG2sB2Y9w1GnsfiDvw7RUuU5vATfWWvYFRCehm2UpDhBlrBjjXcWKYzXsT3x2PNtCC82JqY1nkKrgt2AHCPUjM0tCQk5EHFcssb8I0Rkc4s8aNcARXtFrBzmWqXDQPmCpLIGaAo7LlypOKKaqUNqkRkf8c930p8HaRDvQJealZsVnpwJn3Ev7yEaBZ9INe5PXFwkTQEfpNE3B8IokFMh0aUbu8mfzjKLBazSKW2qA4faIo2Wp5FmOmTzCMiPqznOq3Bl0zM4wmuo0rOXbswjaCUzPB0KpM8Yaze9TArOEDrV6Li</infAdProd><obsItem><obsCont xCampo=\"campo\"><xTexto>conteudo</xTexto></obsCont></obsItem></NFNotaInfoItem>", nfNotaInfoItem.toString());
    }

    @Test
    public void deveGerarXMLComObservacaoFisco() {
        NFNotaInfoItem nfNotaInfoItem = FabricaDeObjetosFake.getNFNotaInfoItem();
        final NFNotaInfoObservacao observacao = new NFNotaInfoObservacao();
        observacao.setIdentificacaoCampo("campo");
        observacao.setConteudoCampo("conteudo");
        final List<NFNotaInfoObservacao> nfNotaInfoObservacaos = new ArrayList<>();
        nfNotaInfoObservacaos.add(observacao);
        NFNotaInfoItemObservacao itemObservacao = new NFNotaInfoItemObservacao();
        itemObservacao.setObservacoesFisco(nfNotaInfoObservacaos);
        nfNotaInfoItem.setItemObservacao(itemObservacao);
        Assert.assertEquals("<NFNotaInfoItem nItem=\"990\"><prod><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>36811963532505</cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>36811963532505</cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></prod><imposto><vTotTrib>999999999999.99</vTotTrib><ICMS><ICMS00><orig>0</orig><CST>00</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><pFCP>99.99</pFCP><vFCP>999999999999.99</vFCP></ICMS00></ICMS><IPI><CNPJProd>12345678901234</CNPJProd><cSelo>iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5</cSelo><qSelo>999999999999</qSelo><cEnq>aT2</cEnq><IPITrib><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></IPITrib></IPI><II><vBC>999999999999.99</vBC><vDespAdu>999999999999.99</vDespAdu><vII>999999999999.99</vII><vIOF>999999999999.99</vIOF></II><PIS><PISAliq><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq></PIS><PISST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISST><COFINS><COFINSAliq><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq></COFINS><COFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS></COFINSST><ICMSUFDest><vBCUFDest>9999999999999.99</vBCUFDest><vBCFCPUFDest>9999999999999.99</vBCFCPUFDest><pFCPUFDest>999.9999</pFCPUFDest><pICMSUFDest>999.9999</pICMSUFDest><pICMSInter>7.00</pICMSInter><pICMSInterPart>999.9999</pICMSInterPart><vFCPUFDest>9999999999999.99</vFCPUFDest><vICMSUFDest>9999999999999.99</vICMSUFDest><vICMSUFRemet>9999999999999.99</vICMSUFRemet></ICMSUFDest></imposto><impostoDevol><pDevol>100.00</pDevol><IPI><vIPIDevol>9999999999999.99</vIPIDevol></IPI></impostoDevol><infAdProd>R3s36BVI9k15xOe3hnlEpZRpPHEom9inv4hE1oo8hzHYG8X6D9sQjt6oLYiH6yToSFM95zueMhE4s270GB7iLUKcQTRHWLcHb1TU2fSYx2NAz5ZflI3hoTnN8zmqJtGzneaNpDRA5gJW7wxMg9IXIuUCxg25MlIQ46AbDQNc3HLl82g3awWKigBMli0bUEWIMf8C2GG2sB2Y9w1GnsfiDvw7RUuU5vATfWWvYFRCehm2UpDhBlrBjjXcWKYzXsT3x2PNtCC82JqY1nkKrgt2AHCPUjM0tCQk5EHFcssb8I0Rkc4s8aNcARXtFrBzmWqXDQPmCpLIGaAo7LlypOKKaqUNqkRkf8c930p8HaRDvQJealZsVnpwJn3Ev7yEaBZ9INe5PXFwkTQEfpNE3B8IokFMh0aUbu8mfzjKLBazSKW2qA4faIo2Wp5FmOmTzCMiPqznOq3Bl0zM4wmuo0rOXbswjaCUzPB0KpM8Yaze9TArOEDrV6Li</infAdProd><obsItem><obsFisco xCampo=\"campo\"><xTexto>conteudo</xTexto></obsFisco></obsItem></NFNotaInfoItem>", nfNotaInfoItem.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItem nItem=\"990\"><prod><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>36811963532505</cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>36811963532505</cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></prod><imposto><vTotTrib>999999999999.99</vTotTrib><ICMS><ICMS00><orig>0</orig><CST>00</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><pFCP>99.99</pFCP><vFCP>999999999999.99</vFCP></ICMS00></ICMS><IPI><CNPJProd>12345678901234</CNPJProd><cSelo>iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5</cSelo><qSelo>999999999999</qSelo><cEnq>aT2</cEnq><IPITrib><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></IPITrib></IPI><II><vBC>999999999999.99</vBC><vDespAdu>999999999999.99</vDespAdu><vII>999999999999.99</vII><vIOF>999999999999.99</vIOF></II><PIS><PISAliq><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq></PIS><PISST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISST><COFINS><COFINSAliq><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq></COFINS><COFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS></COFINSST><ICMSUFDest><vBCUFDest>9999999999999.99</vBCUFDest><vBCFCPUFDest>9999999999999.99</vBCFCPUFDest><pFCPUFDest>999.9999</pFCPUFDest><pICMSUFDest>999.9999</pICMSUFDest><pICMSInter>7.00</pICMSInter><pICMSInterPart>999.9999</pICMSInterPart><vFCPUFDest>9999999999999.99</vFCPUFDest><vICMSUFDest>9999999999999.99</vICMSUFDest><vICMSUFRemet>9999999999999.99</vICMSUFRemet></ICMSUFDest></imposto><impostoDevol><pDevol>100.00</pDevol><IPI><vIPIDevol>9999999999999.99</vIPIDevol></IPI></impostoDevol><infAdProd>R3s36BVI9k15xOe3hnlEpZRpPHEom9inv4hE1oo8hzHYG8X6D9sQjt6oLYiH6yToSFM95zueMhE4s270GB7iLUKcQTRHWLcHb1TU2fSYx2NAz5ZflI3hoTnN8zmqJtGzneaNpDRA5gJW7wxMg9IXIuUCxg25MlIQ46AbDQNc3HLl82g3awWKigBMli0bUEWIMf8C2GG2sB2Y9w1GnsfiDvw7RUuU5vATfWWvYFRCehm2UpDhBlrBjjXcWKYzXsT3x2PNtCC82JqY1nkKrgt2AHCPUjM0tCQk5EHFcssb8I0Rkc4s8aNcARXtFrBzmWqXDQPmCpLIGaAo7LlypOKKaqUNqkRkf8c930p8HaRDvQJealZsVnpwJn3Ev7yEaBZ9INe5PXFwkTQEfpNE3B8IokFMh0aUbu8mfzjKLBazSKW2qA4faIo2Wp5FmOmTzCMiPqznOq3Bl0zM4wmuo0rOXbswjaCUzPB0KpM8Yaze9TArOEDrV6Li</infAdProd></NFNotaInfoItem>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItem().toString());
    }
}