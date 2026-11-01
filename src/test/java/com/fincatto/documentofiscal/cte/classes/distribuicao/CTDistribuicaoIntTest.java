package com.fincatto.documentofiscal.cte.classes.distribuicao;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTDistribuicaoIntTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final CTDistribuicaoInt retorno = new CTDistribuicaoInt();
        retorno.setAmbiente(DFAmbiente.HOMOLOGACAO);
        retorno.setCnpj("00000000000000");
        retorno.setUnidadeFederativaAutor(DFUnidadeFederativa.SC);
        retorno.setVersao("1.0");
        retorno.setDistribuicao(new CTDistribuicaoNSU().setUltimoNSU("0"));

        final String xmlEsperado = "<distDFeInt versao=\"1.0\" xmlns=\"http://www.portalfiscal.inf.br/cte\"><tpAmb>2</tpAmb><cUFAutor>42</cUFAutor><CNPJ>00000000000000</CNPJ><distNSU><ultNSU>0</ultNSU></distNSU></distDFeInt>";
        Assertions.assertEquals(xmlEsperado, retorno.toString());
    }
}
