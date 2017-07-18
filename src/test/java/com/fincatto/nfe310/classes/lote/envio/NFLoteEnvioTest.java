package com.fincatto.nfe310.classes.lote.envio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.fincatto.nfe310.NFeConfigFake;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFModelo;
import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.evento.epec.NFEnviaEventoEpec;
import com.fincatto.nfe310.classes.evento.epec.NFEnviaEventoEpecRetorno;
import com.fincatto.nfe310.classes.evento.epec.NFEventoEpec;
import com.fincatto.nfe310.classes.evento.epec.NFInfoEpec;
import com.fincatto.nfe310.classes.evento.epec.NFInfoEventoEpec;
import com.fincatto.nfe310.classes.evento.epec.NfDestinatarioEpec;
import com.fincatto.nfe310.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.parsers.NotaParser;
import com.fincatto.nfe310.webservices.WSFacade;

public class NFLoteEnvioTest {
	
	@BeforeClass
	public static void setUpBeforeClass() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

//    @Test
//    public void devePermitirNotasComTamanho50() {
//        final List<NFNota> notas = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            notas.add(new NFNota());
//        }
//        new NFLoteEnvio().setNotas(notas);
//    }
//
//    @Test(expected = IllegalStateException.class)
//    public void naoDevePermitirNotasComTamanhoInvalido() {
//        final List<NFNota> notas = new ArrayList<>();
//        for (int i = 0; i < 51; i++) {
//            notas.add(new NFNota());
//        }
//        new NFLoteEnvio().setNotas(notas);
//    }
//
//    @Test(expected = IllegalStateException.class)
//    public void naoDevePermitirIdLoteComTamanhoInvalido() {
//        new NFLoteEnvio().setIdLote("0309665812232211");
//    }
//
//    @Test(expected = IllegalStateException.class)
//    public void naoDevePermitirLetrasNoIdLote() {
//        new NFLoteEnvio().setIdLote("03096658122A221");
//    }
//
//    @Test(expected = IllegalStateException.class)
//    public void naoDevePermitirIndicadorProcessamentoNulo() {
//        final NFLoteEnvio loteEnvio = new NFLoteEnvio();
//        loteEnvio.setVersao("3.10");
//        loteEnvio.setIdLote("333972757970401");
//        loteEnvio.setNotas(Collections.singletonList(FabricaDeObjetosFakeUiliam.getNFNota()));
//        loteEnvio.toString();
//    }
//
//    @Test(expected = IllegalStateException.class)
//    public void naoDevePermitirVersaoNulo() {
//        final NFLoteEnvio loteEnvio = new NFLoteEnvio();
//        loteEnvio.setIdLote("333972757970401");
//        loteEnvio.setNotas(Collections.singletonList(FabricaDeObjetosFakeUiliam.getNFNota()));
//        loteEnvio.setIndicadorProcessamento(NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO);
//        loteEnvio.toString();
//    }
//
//    @Test(expected = IllegalStateException.class)
//    public void naoDevePermitirIdLoteNulo() {
//        final NFLoteEnvio loteEnvio = new NFLoteEnvio();
//        loteEnvio.setVersao("3.10");
//        loteEnvio.setNotas(Collections.singletonList(FabricaDeObjetosFakeUiliam.getNFNota()));
//        loteEnvio.setIndicadorProcessamento(NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO);
//        loteEnvio.toString();
//    }
//
//    @Test(expected = IllegalStateException.class)
//    public void naoDevePermitirNotasNulo() {
//        final NFLoteEnvio loteEnvio = new NFLoteEnvio();
//        loteEnvio.setIdLote("333972757970401");
//        loteEnvio.setVersao("3.10");
//        loteEnvio.setIndicadorProcessamento(NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO);
//        loteEnvio.toString();
//    }
	
	
    @Test
    @Ignore
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() throws Exception {
        NFLoteEnvio loteEnvio = new NFLoteEnvio();
//        loteEnvio.setIdLote("333972757970401");
//        loteEnvio.setVersao("3.10");
//        loteEnvio.setIndicadorProcessamento(NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO);
//        loteEnvio.setNotas(Collections.singletonList(FabricaDeObjetosFakeUiliam.getNFNota()));
        
        try {
        
        String xml = "<enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"3.10\"><idLote>200602220000001</idLote><indSinc>0</indSinc><NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"><infNFe versao=\"3.10\" Id=\"NFe43170388212113016014550010013370501013729382\"><ide><cUF>43</cUF><cNF>01372938</cNF><natOp>Transferencia de mercadoria adquirida ou recebida de terceir</natOp><indPag>2</indPag><mod>55</mod><serie>1</serie><nNF>1</nNF><dhEmi>2017-07-17T22:50:00-03:00</dhEmi><dhSaiEnt>2017-07-17T22:50:00-03:00</dhSaiEnt><tpNF>1</tpNF><idDest>1</idDest><cMunFG>4314100</cMunFG><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>2</cDV><tpAmb>2</tpAmb><finNFe>1</finNFe><indFinal>0</indFinal><indPres>9</indPres><procEmi>0</procEmi><verProc>39989</verProc></ide><emit><CNPJ>88212113016014</CNPJ><xNome>NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome><xFant>FARMACIAS SAO JOAO - PF DEP 2 C. DISTRIB</xFant><enderEmit><xLgr>AV P CORONEL JARBAS QUADROS DA SILVA</xLgr><nro>3701</nro><xCpl>PREDIO 3 TERREO</xCpl><xBairro>SAO CRISTOVAO</xBairro><cMun>4314100</cMun><xMun>PASSO FUNDO</xMun><UF>RS</UF><CEP>99064440</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone>5433350100</fone></enderEmit><IE>0910307881</IE><CRT>3</CRT></emit><dest><CNPJ>88212113009077</CNPJ><xNome>NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome><enderDest><xLgr>AV PARAGUASSU</xLgr><nro>1984</nro><xCpl>SL 03</xCpl><xBairro>CENTRO</xBairro><cMun>4304630</cMun><xMun>CAPAO DA CANOA</xMun><UF>RS</UF><CEP>95555000</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone>5136655600</fone></enderDest><indIEDest>1</indIEDest><IE>2340085548</IE></dest><det nItem=\"1\"><prod><cProd>14463</cProd><cEAN>7896004814193</cEAN><xProd>ALGODAO TOPZ 50G ZIG-ZAG</xProd><NCM>30059090</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>6.0000</qCom><vUnCom>1.6400000000</vUnCom><vProd>9.84</vProd><cEANTrib>7896004814193</cEANTrib><uTrib>UN</uTrib><qTrib>6.0000</qTrib><vUnTrib>1.6400000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>6.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>3.49</vPMC></med></prod><imposto><ICMS><ICMS10><orig>0</orig><CST>10</CST><modBC>0</modBC><vBC>9.84</vBC><pICMS>18.0000</pICMS><vICMS>1.77</vICMS><modBCST>0</modBCST><pMVAST>49.8600</pMVAST><vBCST>14.75</vBCST><pICMSST>18.0000</pICMSST><vICMSST>0.88</vICMSST></ICMS10></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto><infAdProd>PIcmsSt = 18% BcSt = 14,75 VSt = 0,88.</infAdProd></det><det nItem=\"2\"><prod><cProd>994198</cProd><cEAN>7899026464056</cEAN><xProd>COND FRUCTIS 200M NORMAIS FORCA E BRILH</xProd><NCM>33059000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>5.3000000000</vUnCom><vProd>10.60</vProd><cEANTrib>7899026464056</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>5.3000000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>12.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"3\"><prod><cProd>1000003</cProd><cEAN>7896090401208</cEAN><xProd>DES HYDRATTA AERO 165ML INVISIBLE</xProd><NCM>33072010</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>3.0000</qCom><vUnCom>7.1300000000</vUnCom><vProd>21.39</vProd><cEANTrib>7896090401208</cEANTrib><uTrib>UN</uTrib><qTrib>3.0000</qTrib><vUnTrib>7.1300000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>3.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>10.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"4\"><prod><cProd>10088972</cProd><cEAN>7899026496125</cEAN><xProd>COND FRUCTIS 200ML OLEO REPARACAO 3OLEO</xProd><NCM>33059000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>5.3000000000</vUnCom><vProd>10.60</vProd><cEANTrib>7899026496125</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>5.3000000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>12.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"5\"><prod><cProd>10094045</cProd><cEAN>7896018700710</cEAN><xProd>SH INF MONICA 200ML HUGGIES CAMOMILA</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>4.5700000000</vUnCom><vProd>9.14</vProd><cEANTrib>7896018700710</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>4.5700000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>7.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"6\"><prod><cProd>10094046</cProd><cEAN>7896018700765</cEAN><xProd>COND INF MONICA 200ML HUGGIES CAMOMILA</xProd><NCM>33059000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>7.5300000000</vUnCom><vProd>15.06</vProd><cEANTrib>7896018700765</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>7.5300000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>11.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"7\"><prod><cProd>100003313</cProd><cEAN>7899026463677</cEAN><xProd>SH FRUCTIS 200ML 2X1 ANTICASPA</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>7.2200000000</vUnCom><vProd>14.44</vProd><cEANTrib>7899026463677</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>7.2200000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>11.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"8\"><prod><cProd>100003320</cProd><cEAN>7899026464070</cEAN><xProd>SH FRUCTIS 200ML NORMAIS FOR/BRILHO</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>6.1400000000</vUnCom><vProd>12.28</vProd><cEANTrib>7899026464070</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>6.1400000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>8.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"9\"><prod><cProd>100003335</cProd><cEAN>7899026464094</cEAN><xProd>SH FRUCTIS 400ML NORMAIS FOR/BRILHO</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>3.0000</qCom><vUnCom>9.0100000000</vUnCom><vProd>27.03</vProd><cEANTrib>7899026464094</cEANTrib><uTrib>UN</uTrib><qTrib>3.0000</qTrib><vUnTrib>9.0100000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>3.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>12.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"10\"><prod><cProd>100003341</cProd><cEAN>7899026475427</cEAN><xProd>COND FRUCTIS 400ML LISO ABSOLUTO QUIMIC</xProd><NCM>33059000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>9.3900000000</vUnCom><vProd>18.78</vProd><cEANTrib>7899026475427</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>9.3900000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>13.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"11\"><prod><cProd>100003345</cProd><cEAN>7899026464179</cEAN><xProd>COND FRUCTIS 400ML OLEO REPARACAO 3OLEO</xProd><NCM>33059000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>9.3900000000</vUnCom><vProd>18.78</vProd><cEANTrib>7899026464179</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>9.3900000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>13.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"12\"><prod><cProd>100004944</cProd><cEAN>7898587760485</cEAN><xProd>SH FRUCTIS 200ML FRESCOR VITAMINADO</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>3.0000</qCom><vUnCom>6.1400000000</vUnCom><vProd>18.42</vProd><cEANTrib>7898587760485</cEANTrib><uTrib>UN</uTrib><qTrib>3.0000</qTrib><vUnTrib>6.1400000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>3.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>8.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"13\"><prod><cProd>100009018</cProd><cEAN>7899706110365</cEAN><xProd>SH FRUCTIS 200ML APAGA DANOS</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>4.9900000000</vUnCom><vProd>9.98</vProd><cEANTrib>7899706110365</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>4.9900000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>8.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"14\"><prod><cProd>100014622</cProd><cEAN>7899706130974</cEAN><xProd>DES BI-O ROLL-ON 50G MEN ODOR BLOCK 2</xProd><NCM>33072010</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>3.0000</qCom><vUnCom>6.2100000000</vUnCom><vProd>18.63</vProd><cEANTrib>7899706130974</cEANTrib><uTrib>UN</uTrib><qTrib>3.0000</qTrib><vUnTrib>6.2100000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>3.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>9.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"15\"><prod><cProd>100014750</cProd><cEAN>7897664169449</cEAN><xProd>DES HYDRATTA AERO 165ML SEN CARE</xProd><NCM>33072010</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>6.0000</qCom><vUnCom>7.1300000000</vUnCom><vProd>42.78</vProd><cEANTrib>7897664169449</cEANTrib><uTrib>UN</uTrib><qTrib>6.0000</qTrib><vUnTrib>7.1300000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>6.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>10.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><total><ICMSTot><vBC>9.84</vBC><vICMS>1.77</vICMS><vICMSDeson>0.00</vICMSDeson><vFCPUFDest>0.00</vFCPUFDest><vBCST>14.75</vBCST><vST>0.88</vST><vProd>257.75</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>258.63</vNF></ICMSTot></total><transp><modFrete>0</modFrete><transporta><CNPJ>88212113001092</CNPJ><xNome>NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome><IE>0910227250</IE><xEnder>AV BRASIL LESTE, 1190</xEnder><xMun>PASSO FUNDO</xMun><UF>RS</UF></transporta><veicTransp><placa>ITR3067</placa><UF>RS</UF></veicTransp><vol><qVol>1</qVol><esp>CAIXA</esp><marca>DIVERSAS</marca><nVol>0</nVol></vol></transp><infAdic><infCpl>Conferencia(s) n (s): ;3131259;3131261;3131262;3131263;3131264;3131265;3131266</infCpl></infAdic></infNFe></NFe></enviNFe>";
        
        System.out.println(xml);
        
        loteEnvio = new NotaParser().loteParaObjeto(xml);
        
        System.out.println(loteEnvio.toString());
        
        WSFacade facade = new WSFacade(new NFeConfigFake());
        
        NFLoteConsultaRetorno retorno = facade.consultaLote("431002186977891", NFModelo.NFE);
        
//        NFLoteEnvioRetornoDados retorno = facade.enviaLote(loteEnvio);
        
        System.out.println(retorno.toString());
        
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        
//        Assert.assertEquals(xmlEsperado, loteEnvio.toString());
    }
    
    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoEpec() throws Exception {
        NFLoteEnvio loteEnvio = new NFLoteEnvio();
//        loteEnvio.setIdLote("333972757970401");
//        loteEnvio.setVersao("3.10");
//        loteEnvio.setIndicadorProcessamento(NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO);
//        loteEnvio.setNotas(Collections.singletonList(FabricaDeObjetosFakeUiliam.getNFNota()));
        
        try {
        
        String xml = "<enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"3.10\"><idLote>200602220000001</idLote><indSinc>0</indSinc><NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"><infNFe versao=\"3.10\" Id=\"NFe43170388212113016014550010013370501013729382\"><ide><cUF>43</cUF><cNF>01372938</cNF><natOp>Transferencia de mercadoria adquirida ou recebida de terceir</natOp><indPag>2</indPag><mod>55</mod><serie>1</serie><nNF>2</nNF><dhEmi>2017-07-17T22:50:00-03:00</dhEmi><dhSaiEnt>2017-07-17T22:50:00-03:00</dhSaiEnt><tpNF>1</tpNF><idDest>1</idDest><cMunFG>4314100</cMunFG><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>2</cDV><tpAmb>2</tpAmb><finNFe>1</finNFe><indFinal>0</indFinal><indPres>9</indPres><procEmi>0</procEmi><verProc>39989</verProc></ide><emit><CNPJ>88212113016014</CNPJ><xNome>NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome><xFant>FARMACIAS SAO JOAO - PF DEP 2 C. DISTRIB</xFant><enderEmit><xLgr>AV P CORONEL JARBAS QUADROS DA SILVA</xLgr><nro>3701</nro><xCpl>PREDIO 3 TERREO</xCpl><xBairro>SAO CRISTOVAO</xBairro><cMun>4314100</cMun><xMun>PASSO FUNDO</xMun><UF>RS</UF><CEP>99064440</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone>5433350100</fone></enderEmit><IE>0910307881</IE><CRT>3</CRT></emit><dest><CNPJ>88212113009077</CNPJ><xNome>NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome><enderDest><xLgr>AV PARAGUASSU</xLgr><nro>1984</nro><xCpl>SL 03</xCpl><xBairro>CENTRO</xBairro><cMun>4304630</cMun><xMun>CAPAO DA CANOA</xMun><UF>RS</UF><CEP>95555000</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone>5136655600</fone></enderDest><indIEDest>1</indIEDest><IE>2340085548</IE></dest><det nItem=\"1\"><prod><cProd>14463</cProd><cEAN>7896004814193</cEAN><xProd>ALGODAO TOPZ 50G ZIG-ZAG</xProd><NCM>30059090</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>6.0000</qCom><vUnCom>1.6400000000</vUnCom><vProd>9.84</vProd><cEANTrib>7896004814193</cEANTrib><uTrib>UN</uTrib><qTrib>6.0000</qTrib><vUnTrib>1.6400000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>6.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>3.49</vPMC></med></prod><imposto><ICMS><ICMS10><orig>0</orig><CST>10</CST><modBC>0</modBC><vBC>9.84</vBC><pICMS>18.0000</pICMS><vICMS>1.77</vICMS><modBCST>0</modBCST><pMVAST>49.8600</pMVAST><vBCST>14.75</vBCST><pICMSST>18.0000</pICMSST><vICMSST>0.88</vICMSST></ICMS10></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto><infAdProd>PIcmsSt = 18% BcSt = 14,75 VSt = 0,88.</infAdProd></det><det nItem=\"2\"><prod><cProd>994198</cProd><cEAN>7899026464056</cEAN><xProd>COND FRUCTIS 200M NORMAIS FORCA E BRILH</xProd><NCM>33059000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>5.3000000000</vUnCom><vProd>10.60</vProd><cEANTrib>7899026464056</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>5.3000000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>12.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"3\"><prod><cProd>1000003</cProd><cEAN>7896090401208</cEAN><xProd>DES HYDRATTA AERO 165ML INVISIBLE</xProd><NCM>33072010</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>3.0000</qCom><vUnCom>7.1300000000</vUnCom><vProd>21.39</vProd><cEANTrib>7896090401208</cEANTrib><uTrib>UN</uTrib><qTrib>3.0000</qTrib><vUnTrib>7.1300000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>3.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>10.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"4\"><prod><cProd>10088972</cProd><cEAN>7899026496125</cEAN><xProd>COND FRUCTIS 200ML OLEO REPARACAO 3OLEO</xProd><NCM>33059000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>5.3000000000</vUnCom><vProd>10.60</vProd><cEANTrib>7899026496125</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>5.3000000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>12.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"5\"><prod><cProd>10094045</cProd><cEAN>7896018700710</cEAN><xProd>SH INF MONICA 200ML HUGGIES CAMOMILA</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>4.5700000000</vUnCom><vProd>9.14</vProd><cEANTrib>7896018700710</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>4.5700000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>7.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"6\"><prod><cProd>10094046</cProd><cEAN>7896018700765</cEAN><xProd>COND INF MONICA 200ML HUGGIES CAMOMILA</xProd><NCM>33059000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>7.5300000000</vUnCom><vProd>15.06</vProd><cEANTrib>7896018700765</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>7.5300000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>11.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"7\"><prod><cProd>100003313</cProd><cEAN>7899026463677</cEAN><xProd>SH FRUCTIS 200ML 2X1 ANTICASPA</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>7.2200000000</vUnCom><vProd>14.44</vProd><cEANTrib>7899026463677</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>7.2200000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>11.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"8\"><prod><cProd>100003320</cProd><cEAN>7899026464070</cEAN><xProd>SH FRUCTIS 200ML NORMAIS FOR/BRILHO</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>6.1400000000</vUnCom><vProd>12.28</vProd><cEANTrib>7899026464070</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>6.1400000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>8.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"9\"><prod><cProd>100003335</cProd><cEAN>7899026464094</cEAN><xProd>SH FRUCTIS 400ML NORMAIS FOR/BRILHO</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>3.0000</qCom><vUnCom>9.0100000000</vUnCom><vProd>27.03</vProd><cEANTrib>7899026464094</cEANTrib><uTrib>UN</uTrib><qTrib>3.0000</qTrib><vUnTrib>9.0100000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>3.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>12.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"10\"><prod><cProd>100003341</cProd><cEAN>7899026475427</cEAN><xProd>COND FRUCTIS 400ML LISO ABSOLUTO QUIMIC</xProd><NCM>33059000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>9.3900000000</vUnCom><vProd>18.78</vProd><cEANTrib>7899026475427</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>9.3900000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>13.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"11\"><prod><cProd>100003345</cProd><cEAN>7899026464179</cEAN><xProd>COND FRUCTIS 400ML OLEO REPARACAO 3OLEO</xProd><NCM>33059000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>9.3900000000</vUnCom><vProd>18.78</vProd><cEANTrib>7899026464179</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>9.3900000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>13.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"12\"><prod><cProd>100004944</cProd><cEAN>7898587760485</cEAN><xProd>SH FRUCTIS 200ML FRESCOR VITAMINADO</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>3.0000</qCom><vUnCom>6.1400000000</vUnCom><vProd>18.42</vProd><cEANTrib>7898587760485</cEANTrib><uTrib>UN</uTrib><qTrib>3.0000</qTrib><vUnTrib>6.1400000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>3.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>8.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"13\"><prod><cProd>100009018</cProd><cEAN>7899706110365</cEAN><xProd>SH FRUCTIS 200ML APAGA DANOS</xProd><NCM>33051000</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>4.9900000000</vUnCom><vProd>9.98</vProd><cEANTrib>7899706110365</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>4.9900000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>2.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>8.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"14\"><prod><cProd>100014622</cProd><cEAN>7899706130974</cEAN><xProd>DES BI-O ROLL-ON 50G MEN ODOR BLOCK 2</xProd><NCM>33072010</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>3.0000</qCom><vUnCom>6.2100000000</vUnCom><vProd>18.63</vProd><cEANTrib>7899706130974</cEANTrib><uTrib>UN</uTrib><qTrib>3.0000</qTrib><vUnTrib>6.2100000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>3.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>9.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><det nItem=\"15\"><prod><cProd>100014750</cProd><cEAN>7897664169449</cEAN><xProd>DES HYDRATTA AERO 165ML SEN CARE</xProd><NCM>33072010</NCM><CEST>1300402</CEST><CFOP>5409</CFOP><uCom>UN</uCom><qCom>6.0000</qCom><vUnCom>7.1300000000</vUnCom><vProd>42.78</vProd><cEANTrib>7897664169449</cEANTrib><uTrib>UN</uTrib><qTrib>6.0000</qTrib><vUnTrib>7.1300000000</vUnTrib><indTot>1</indTot><med><nLote>1</nLote><qLote>6.000</qLote><dFab>2016-06-03</dFab><dVal>2018-03-30</dVal><vPMC>10.99</vPMC></med></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST></ICMS60></ICMS><PIS><PISAliq><CST>01</CST><vBC>0.00</vBC><pPIS>0.0000</pPIS><vPIS>0.00</vPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>0.00</vBC><pCOFINS>0.0000</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSAliq></COFINS></imposto></det><total><ICMSTot><vBC>9.84</vBC><vICMS>1.77</vICMS><vICMSDeson>0.00</vICMSDeson><vFCPUFDest>0.00</vFCPUFDest><vBCST>14.75</vBCST><vST>0.88</vST><vProd>257.75</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>258.63</vNF></ICMSTot></total><transp><modFrete>0</modFrete><transporta><CNPJ>88212113001092</CNPJ><xNome>NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome><IE>0910227250</IE><xEnder>AV BRASIL LESTE, 1190</xEnder><xMun>PASSO FUNDO</xMun><UF>RS</UF></transporta><veicTransp><placa>ITR3067</placa><UF>RS</UF></veicTransp><vol><qVol>1</qVol><esp>CAIXA</esp><marca>DIVERSAS</marca><nVol>0</nVol></vol></transp><infAdic><infCpl>Conferencia(s) n (s): ;3131259;3131261;3131262;3131263;3131264;3131265;3131266</infCpl></infAdic></infNFe></NFe></enviNFe>";
        
        System.out.println(xml);
        
        loteEnvio = new NotaParser().loteParaObjeto(xml);
        
        System.out.println(loteEnvio.toString());
        
        WSFacade facade = new WSFacade(new NFeConfigFake());
        
//        NFLoteConsultaRetorno retorno = facade.consultaLote("431002186977891", NFModelo.NFE);
        
        NFEnviaEventoEpec epec = new NFEnviaEventoEpec();
        epec.setIdLote("123455687");
        epec.setVersao("1.00");
        epec.setEvento(new ArrayList<NFEventoEpec>());
        int i = 1;
        for (NFNota nfNota : loteEnvio.getNotas()) {
        	NFEventoEpec nfEpec = new NFEventoEpec();
        	nfEpec.setNota(nfNota);
        	nfEpec.setVersao("1.00");
        	NFInfoEventoEpec nfInfoEventoEpec = new NFInfoEventoEpec();
        	nfInfoEventoEpec.setAmbiente(NFAmbiente.HOMOLOGACAO);
        	nfInfoEventoEpec.setCnpj("88212113016014");
        	nfInfoEventoEpec.setCodigoEvento("110140");
        	nfInfoEventoEpec.setDataHoraEvento(DateTime.now());
        	NFInfoEpec infoEpec = new NFInfoEpec();
//        	infoEpec.setCondicaoUso();
        	infoEpec.setDataHoraEmissao("2017-07-17T22:50:00-03:00");
        	infoEpec.setDescricaoEvento("EPEC");
        	NfDestinatarioEpec destinatario = new NfDestinatarioEpec();
        	destinatario.setCnpj("88212113009077");
//        	destinatario.setIdEstrangeiro();
//        	destinatario.setInscricaoEstadualDestinatario();
        	destinatario.setUfDestinatario("RS");
        	destinatario.setValorTotalIcms("1.77");
        	destinatario.setValorTotalIcmsSubstituicaoTributaria("0.88");
        	destinatario.setValorTotalNFe("258.63");
        	infoEpec.setDestinatario(destinatario);
        	infoEpec.setInscricaoEstadualEmitente("0910307881");
        	infoEpec.setOrgaoAutor("43");
//        	infoEpec.setTextoCorrecao();
        	infoEpec.setTipoNota("1");
        	infoEpec.setTpAutor("1");
        	infoEpec.setVersao(BigDecimal.valueOf(1.00));
        	infoEpec.setVersaoAplicativo("1.0");
        	nfInfoEventoEpec.setEpec(infoEpec);
        	nfInfoEventoEpec.setNumeroSequencialEvento(i++);
        	nfInfoEventoEpec.setOrgao(NFUnidadeFederativa.RS);
        	nfInfoEventoEpec.setVersaoEvento("1.00");
        	
        	
        	nfEpec.setInfoEvento(nfInfoEventoEpec);
        	
        	epec.getEvento().add(nfEpec);
        	
        }
        
        NFEnviaEventoEpecRetorno retorno = facade.enviaEpec(epec);
        
        System.out.println(retorno.toString());
        
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        
//        Assert.assertEquals(xmlEsperado, loteEnvio.toString());
    }
}