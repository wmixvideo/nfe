package com.fincatto.documentofiscal.nfe400.webservices;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFUnidadeFederativa;

/**
 * O Mato Grosso (MT) e a unica UF cujo WSDL de consulta de cadastro tem um nivel extra de
 * aninhamento no corpo SOAP (o antigo stub Axis2 {@code MTCadConsultaCadastro4Stub} envolvia o
 * {@code <nfeDadosMsg>} dentro de um {@code <consultaCadastro>}; todas as outras UFs usam
 * {@code <nfeDadosMsg>} direto no corpo, como o restante do nfe400). Este teste garante que
 * {@link WSConsultaCadastro#construirEnvelope} reproduz as duas formas corretamente.
 *
 * @author Marcos Lombardi de Andrade
 */
public class WSConsultaCadastroTest {

    private static final String XML_CONSULTA = "<consCad xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><infCons><cnpj>12345678000199</cnpj></infCons></consCad>";

    @Test
    public void paraMtDeveEnvolverNfeDadosMsgDentroDeConsultaCadastro() {
        final String envelope = WSConsultaCadastro.construirEnvelope(DFUnidadeFederativa.MT, XML_CONSULTA);

        Assert.assertTrue(envelope.contains("<consultaCadastro xmlns=\"http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4\">"));
        Assert.assertTrue(envelope.contains("<nfeDadosMsg>" + XML_CONSULTA + "</nfeDadosMsg>"));
        Assert.assertTrue(envelope.contains("</consultaCadastro>"));
    }

    @Test
    public void paraOutrasUfsDeveUsarNfeDadosMsgDiretoNoCorpo() {
        final String envelope = WSConsultaCadastro.construirEnvelope(DFUnidadeFederativa.SC, XML_CONSULTA);

        Assert.assertTrue(envelope.contains("<nfeDadosMsg xmlns=\"http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4\">" + XML_CONSULTA + "</nfeDadosMsg>"));
        Assert.assertFalse("nao deveria ter o wrapper extra consultaCadastro fora do MT", envelope.contains("<consultaCadastro"));
    }
}
