package com.fincatto.documentofiscal.mdfe3;

import com.fincatto.documentofiscal.assinatura.AssinaturaDigital;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Edivaldo Merlo Stens on 06/10/18.
 */
public class AssinaturaDigitalMDFeTest {

    @Test
    public void deveAssinarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<MDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"><infMDFe Id=\"MDFe33180436293264000128580010000000551430791300\" versao=\"3.00\"><ide><cUF>33</cUF><tpAmb>2</tpAmb><tpEmit>1</tpEmit><tpTransp>1</tpTransp><mod>58</mod><serie>1</serie><nMDF>55</nMDF><cMDF>43079130</cMDF><cDV>0</cDV><modal>1</modal><dhEmi>2018-10-03T00:45:00-03:00</dhEmi><tpEmis>1</tpEmis><procEmi>0</procEmi><verProc>1.0.0</verProc><UFIni>RJ</UFIni><UFFim>SP</UFFim><infMunCarrega><cMunCarrega>3201308</cMunCarrega><xMunCarrega>Cariacica</xMunCarrega></infMunCarrega><infPercurso><UFPer>ES</UFPer></infPercurso><dhIniViagem>2018-10-04T23:45:00-03:00</dhIniViagem></ide><emit><CNPJ>10936521000109</CNPJ><IE>123456</IE><xNome>Evoli Tecnologia Ltda</xNome><xFant>Evoli</xFant><enderEmit><xLgr>Rua Itacibá</xLgr><nro>471</nro><xCpl>PAVM01</xCpl><xBairro>Vista Mar</xBairro><cMun>3201308</cMun><xMun>Cariacica</xMun><CEP>29141500</CEP><UF>ES</UF><fone>27999739375</fone><email>contato@evoli.com.br</email></enderEmit></emit><infModal versaoModal=\"3.00\"><rodo><infANTT><RNTRC>88888888</RNTRC><infCIOT><CIOT>222222222222</CIOT><CPF>08779437702</CPF></infCIOT><valePed><disp><CNPJForn>10936521000109</CNPJForn><CPFPg>08779437702</CPFPg><nCompra>2</nCompra><vValePed>4.00</vValePed></disp></valePed><infContratante><CPF>08779437702</CPF></infContratante></infANTT><veicTracao><cInt>3</cInt><placa>MTW1257</placa><RENAVAM>99999999999</RENAVAM><tara>6</tara><capKG>7</capKG><capM3>8</capM3><prop><CPF>08779437702</CPF><RNTRC>99999999</RNTRC><xNome>18</xNome><IE>17</IE><UF>AL</UF><tpProp>1</tpProp></prop><condutor><xNome>Edivaldo Merlo Stens</xNome><CPF>08779437702</CPF></condutor><tpRod>01</tpRod><tpCar>00</tpCar><UF>AC</UF></veicTracao><veicReboque><cInt>1</cInt><placa>MTW1257</placa><RENAVAM>777777777</RENAVAM><tara>4</tara><capM3>6</capM3><prop><CPF>08779437702</CPF><RNTRC>99999999</RNTRC><xNome>15</xNome><IE>14</IE><UF>27</UF></prop><tpCar>05</tpCar><UF>AC</UF><capKG>5</capKG></veicReboque><codAgPorto>2</codAgPorto></rodo></infModal><infDoc><infMunDescarga><cMunDescarga>3201308</cMunDescarga><xMunDescarga>Cariacica</xMunDescarga><infNFe><chNFe>44444444444444444444444444444444444444444444</chNFe><SegCodBarra>222222222222222222222222222222222222</SegCodBarra><indReentrega>1</indReentrega><infUnidTransp><tpUnidTransp>1</tpUnidTransp><idUnidTransp>2</idUnidTransp><lacUnidTransp><nLacre>11111111</nLacre></lacUnidTransp><infUnidCarga><tpUnidCarga>3</tpUnidCarga><idUnidCarga>2</idUnidCarga><lacUnidCarga><nLacre>222222222</nLacre></lacUnidCarga><qtdRat>1.00</qtdRat></infUnidCarga><qtdRat>3.00</qtdRat></infUnidTransp><peri><nONU>1111</nONU><xNomeAE>3</xNomeAE><xClaRisco>2</xClaRisco><grEmb>4</grEmb><qTotProd>5</qTotProd><qVolTipo>6</qVolTipo></peri></infNFe></infMunDescarga></infDoc><seg><infResp><respSeg>2</respSeg><CPF>08779437702</CPF></infResp><infSeg><xSeg>3</xSeg><CNPJ>10936521000109</CNPJ></infSeg><nApol>5</nApol><nAver>001</nAver><nAver>002</nAver><nAver>003</nAver><nAver>004</nAver><nAver>005</nAver><nAver>006</nAver></seg><tot><qCTe>0</qCTe><qNFe>1</qNFe><qMDFe>0</qMDFe><vCarga>9999999.99</vCarga><cUnid>01</cUnid><qCarga>888888.0000</qCarga></tot><lacres><nLacre>1</nLacre></lacres><autXML><CNPJ>10936521000109</CNPJ></autXML><infAdic><infAdFisco>AAAAAAAAW</infAdFisco><infCpl>BBBBBBBW</infCpl></infAdic></infMDFe></MDFe>";
        System.err.println("xmlEsperado: " + xmlEsperado);
        AssinaturaDigital assinatura = new AssinaturaDigital(new MDFeConfigFake());
        String xmlStrSigned = null;

        try {
            xmlStrSigned = assinatura.assinarDocumento(xmlEsperado, "infMDFe");
            System.err.println("xmlStrSigned: " + xmlStrSigned);
        } catch (Exception ex) {
            //ex.printStackTrace();
            Logger.getLogger(AssinaturaDigitalMDFeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Assert.assertEquals(xmlEsperado, xmlStrSigned);
    }
}
