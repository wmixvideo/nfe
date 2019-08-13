package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.FabricaDeObjetosFakeMDFe;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Edivaldo Merlo Stens on 04/10/18.
 */
public class MDFInfoIdentificacaoTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<ide xmlns=\"http://www.portalfiscal.inf.br/mdfe\">"
                + "<cUF>32</cUF>"
                + "<tpAmb>2</tpAmb>"
                + "<tpEmit>2</tpEmit>"
                + "<tpTransp>2</tpTransp>"
                + "<mod>58</mod>"
                + "<serie>1</serie>"
                + "<nMDF>123654</nMDF>"
                + "<cMDF>12345689</cMDF>"
                + "<cDV>1</cDV>"
                + "<modal>1</modal>"
                + "<dhEmi>2019-05-28T11:07:55-03:00</dhEmi>"
                + "<tpEmis>1</tpEmis>"
                + "<procEmi>0</procEmi>"
                + "<verProc>3.0</verProc>"
                + "<UFIni>RJ</UFIni>"
                + "<UFFim>ES</UFFim>"
                + "<infMunCarrega>"
                + "<cMunCarrega>3304557</cMunCarrega>"
                + "<xMunCarrega>Rio de Janeiro</xMunCarrega>"
                + "</infMunCarrega>"
                + "<dhIniViagem>2019-05-28T11:07:55-03:00</dhIniViagem>"
                + "</ide>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFakeMDFe.getMDFInfoIdentificacao().toString());
    }
}
