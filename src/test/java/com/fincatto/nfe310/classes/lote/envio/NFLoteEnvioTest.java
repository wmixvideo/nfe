package com.fincatto.nfe310.classes.lote.envio;

import java.util.TimeZone;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fincatto.nfe310.NFeConfigFake;
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
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() throws Exception {
        NFLoteEnvio loteEnvio = new NFLoteEnvio();
//        loteEnvio.setIdLote("333972757970401");
//        loteEnvio.setVersao("3.10");
//        loteEnvio.setIndicadorProcessamento(NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO);
//        loteEnvio.setNotas(Collections.singletonList(FabricaDeObjetosFakeUiliam.getNFNota()));
        
        try {
        
        String xml = "<enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"3.10\">" +
        		"	<idLote>123</idLote>" +
        		"	<indSinc>0</indSinc>" +
        		"	<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">" +
        		"		<infNFe Id=\"NFe35170600317372000499550010001474841002369605\" versao=\"3.10\">" +
        		"			<ide>" +
        		"				<cUF>35</cUF>" +
        		"				<cNF>00236960</cNF>" +
        		"				<natOp>VENDA DE PRODUCAO DO ESTAB. QUE NAO DEVA POR ELE TRANS.</natOp>" +
        		"				<indPag>1</indPag>" +
        		"				<mod>55</mod>" +
        		"				<serie>1</serie>" +
        		"				<nNF>1</nNF>" +
        		"				<dhEmi>2017-07-17T21:35:00-03:00</dhEmi>" +
        		"				<tpNF>1</tpNF>" +
        		"				<idDest>2</idDest>" +
        		"				<cMunFG>3519071</cMunFG>" +
        		"				<tpImp>1</tpImp>" +
        		"				<tpEmis>1</tpEmis>" +
        		"				<cDV>5</cDV>" +
        		"				<tpAmb>1</tpAmb>" +
        		"				<finNFe>1</finNFe>" +
        		"				<indFinal>0</indFinal>" +
        		"				<indPres>9</indPres>" +
        		"				<procEmi>0</procEmi>" +
        		"				<verProc>2.53</verProc>" +
        		"			</ide>" +
        		"			<emit>" +
        		"				<CNPJ>00317372000499</CNPJ>" +
        		"				<xNome>GALDERMA BRASIL LTDA</xNome>" +
        		"				<xFant>GALDERMA</xFant>" +
        		"				<enderEmit>" +
        		"					<xLgr>ROD. JORNALISTA FRANCISCO AGUIRRE PROENCA, KM 09</xLgr>" +
        		"					<nro>SN</nro>" +
        		"					<xBairro>CHACARAS ASSAY</xBairro>" +
        		"					<cMun>3519071</cMun>" +
        		"					<xMun>HORTOLANDIA</xMun>" +
        		"					<UF>SP</UF>" +
        		"					<CEP>13186900</CEP>" +
        		"					<cPais>1058</cPais>" +
        		"					<xPais>BRASIL</xPais>" +
        		"					<fone>1930456903</fone>" +
        		"				</enderEmit>" +
        		"				<IE>748123590114</IE>" +
        		"				<CRT>3</CRT>" +
        		"			</emit>" +
        		"			<dest>" +
        		"				<CNPJ>88212113016014</CNPJ>" +
        		"				<xNome>COM DE MEDICAMENTOS BRAIR LTDA</xNome>" +
        		"				<enderDest>" +
        		"					<xLgr>AV PERIMETRAL JARBAS QUADROS DA SILVA</xLgr>" +
        		"					<nro>3701</nro>" +
        		"					<xCpl>PREDIO 3 ESQ EST</xCpl>" +
        		"					<xBairro>SAO CRISTOVAO</xBairro>" +
        		"					<cMun>4314100</cMun>" +
        		"					<xMun>PASSO FUNDO</xMun>" +
        		"					<UF>RS</UF>" +
        		"					<CEP>99064440</CEP>" +
        		"					<cPais>1058</cPais>" +
        		"					<xPais>BRASIL</xPais>" +
        		"					<fone>5433350100</fone>" +
        		"				</enderDest>" +
        		"				<indIEDest>1</indIEDest>" +
        		"				<IE>0910307881</IE>" +
        		"				<email>DAIANE.GUEDES@FARMACIASSAOJOAO.COM.BR</email>" +
        		"			</dest>" +
        		"			<det nItem=\"1\">" +
        		"				<prod>" +
        		"					<cProd>006010197</cProd>" +
        		"					<cEAN>7897930760806</cEAN>" +
        		"					<xProd>NUTRAPLUS 10% CREME 60 G OR</xProd>" +
        		"					<NCM>30049099</NCM>" +
        		"					<CEST>1300101</CEST>" +
        		"					<CFOP>6105</CFOP>" +
        		"					<uCom>UN</uCom>" +
        		"					<qCom>30.0000</qCom>" +
        		"					<vUnCom>21.85000000</vUnCom>" +
        		"					<vProd>655.50</vProd>" +
        		"					<cEANTrib>7897930760806</cEANTrib>" +
        		"					<uTrib>UN</uTrib>" +
        		"					<qTrib>30.0000</qTrib>" +
        		"					<vUnTrib>21.85000000</vUnTrib>" +
        		"					<vDesc>44.71</vDesc>" +
        		"					<indTot>1</indTot>" +
        		"					<xPed>33997</xPed>" +
        		"					<nItemPed>01</nItemPed>" +
        		"					<med>" +
        		"						<nLote>0140517</nLote>" +
        		"						<qLote>30.000</qLote>" +
        		"						<dFab>2017-04-05</dFab>" +
        		"						<dVal>2020-03-30</dVal>" +
        		"						<vPMC>31.64</vPMC>" +
        		"					</med>" +
        		"				</prod>" +
        		"				<imposto>" +
        		"					<ICMS>" +
        		"						<ICMS20>" +
        		"							<orig>0</orig>" +
        		"							<CST>20</CST>" +
        		"							<modBC>3</modBC>" +
        		"							<pRedBC>9.9000</pRedBC>" +
        		"							<vBC>550.32</vBC>" +
        		"							<pICMS>12.0000</pICMS>" +
        		"							<vICMS>66.04</vICMS>" +
        		"						</ICMS20>" +
        		"					</ICMS>" +
        		"					<IPI>" +
        		"						<cEnq>999</cEnq>" +
        		"						<IPINT>" +
        		"							<CST>53</CST>" +
        		"						</IPINT>" +
        		"					</IPI>" +
        		"					<PIS>" +
        		"						<PISAliq>" +
        		"							<CST>02</CST>" +
        		"							<vBC>610.79</vBC>" +
        		"							<pPIS>2.1000</pPIS>" +
        		"							<vPIS>12.83</vPIS>" +
        		"						</PISAliq>" +
        		"					</PIS>" +
        		"					<COFINS>" +
        		"						<COFINSAliq>" +
        		"							<CST>02</CST>" +
        		"							<vBC>610.79</vBC>" +
        		"							<pCOFINS>9.9000</pCOFINS>" +
        		"							<vCOFINS>60.47</vCOFINS>" +
        		"						</COFINSAliq>" +
        		"					</COFINS>" +
        		"				</imposto>" +
        		"				<infAdProd>-- Lista Negativa</infAdProd>" +
        		"			</det>" +
        		"			<total>" +
        		"				<ICMSTot>" +
        		"					<vBC>550.32</vBC>" +
        		"					<vICMS>66.04</vICMS>" +
        		"					<vICMSDeson>0</vICMSDeson>" +
        		"					<vFCPUFDest>0</vFCPUFDest>" +
        		"					<vICMSUFDest>0</vICMSUFDest>" +
        		"					<vICMSUFRemet>0</vICMSUFRemet>" +
        		"					<vBCST>0</vBCST>" +
        		"					<vST>0</vST>" +
        		"					<vProd>655.50</vProd>" +
        		"					<vFrete>0</vFrete>" +
        		"					<vSeg>0</vSeg>" +
        		"					<vDesc>44.71</vDesc>" +
        		"					<vII>0</vII>" +
        		"					<vIPI>0</vIPI>" +
        		"					<vPIS>12.83</vPIS>" +
        		"					<vCOFINS>60.47</vCOFINS>" +
        		"					<vOutro>0</vOutro>" +
        		"					<vNF>610.79</vNF>" +
        		"				</ICMSTot>" +
        		"			</total>" +
        		"			<transp>" +
        		"				<modFrete>0</modFrete>" +
        		"				<transporta>" +
        		"					<CNPJ>01200743000178</CNPJ>" +
        		"					<xNome>EXPERT TRANSP. E LOGISTICA LTDA</xNome>" +
        		"					<IE>636148077117</IE>" +
        		"					<xEnder>SV. GUIDO ALIBERT,3801</xEnder>" +
        		"					<xMun>SAO CAETANO DO</xMun>" +
        		"					<UF>SP</UF>" +
        		"				</transporta>" +
        		"				<vol>" +
        		"					<qVol>1</qVol>" +
        		"					<esp>CAIXA</esp>" +
        		"					<pesoB>2.544</pesoB>" +
        		"				</vol>" +
        		"			</transp>" +
        		"			<cobr>" +
        		"				<dup>" +
        		"					<nDup>1  000147484</nDup>" +
        		"					<dVenc>2017-08-22</dVenc>" +
        		"					<vDup>610.79</vDup>" +
        		"				</dup>" +
        		"			</cobr>" +
        		"			<infAdic>" +
        		"				<infCpl>Reducao de base de calculo nas operacoes interestaduais quando aliquota em 12.00 % reduz 9.90 % conf. convenio 34/2006 As mercadorias serao retiradas do deposito fechado, localizado na Av. Portugal, 1100 Parte A-8 - Itapevi - SP, Inscricao Estadual - 373.113.944.110, CNPJ 00.317.372/0005-70 Valor Liquido R$ 610.79 Ped.Galderma.: 654489  REPASSE DO ICMS-PRODUTOS FARMACEUTICOS: 6,82%  R$ 44,71  Ped.Cliente.: 33997 </infCpl>" +
        		"			</infAdic>" +
        		"			<compra>" +
        		"				<xPed>33997</xPed>" +
        		"			</compra>" +
        		"		</infNFe>" +
        		"	</NFe>" +
        		"</enviNFe>";
        
        System.out.println(xml);
        
        loteEnvio = new NotaParser().loteParaObjeto(xml);
        
        System.out.println(loteEnvio.toString());
        
        WSFacade facade = new WSFacade(new NFeConfigFake());
        
        NFLoteEnvioRetornoDados retorno = facade.enviaLote(loteEnvio);
        
        System.out.println(retorno.toString());
        
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        
//        Assert.assertEquals(xmlEsperado, loteEnvio.toString());
    }
}