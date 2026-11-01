package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;

public class NFNotaInfoAgropecuarioTest {

    private static NFNotaInfoAgropecuarioGuiaTransito guia(String uf, String serie, Integer numero) {
        NFNotaInfoAgropecuarioGuiaTransito guia = new NFNotaInfoAgropecuarioGuiaTransito();
        guia.setTipoGuia(com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoAgropecuarioTipoGuia.GTA);
        guia.setUfGuia(com.fincatto.documentofiscal.DFUnidadeFederativa.valueOf(uf));
        guia.setSerieGuia(serie);
        guia.setNumeroGuia(numero);
        return guia;
    }

    private static List<NFNotaInfoAgropecuarioDefensivo> defensivosPadrao() {
        NFNotaInfoAgropecuarioDefensivo defensivo1 = new NFNotaInfoAgropecuarioDefensivo();
        defensivo1.setNumeroReceituario("123456789012345678901234567890");
        defensivo1.setCPFRespTec("12345678909");

        NFNotaInfoAgropecuarioDefensivo defensivo2 = new NFNotaInfoAgropecuarioDefensivo();
        defensivo2.setNumeroReceituario("ABCDEFGHIJABCDEFGHIJABCDEFGHIJ");
        defensivo2.setCPFRespTec("98765432100");

        return Arrays.asList(defensivo1, defensivo2);
    }

    @Test
    public void deveSetarEObterDefensivosEGuiaTransito() {

        NFNotaInfoAgropecuario agro = new NFNotaInfoAgropecuario();
        List<NFNotaInfoAgropecuarioDefensivo> defensivos = defensivosPadrao();
        agro.setDefensivos(defensivos);

        NFNotaInfoAgropecuarioGuiaTransito g = guia("SP", "SERIE123", 123456789);
        agro.setGuiaTransito(g);

        Assertions.assertEquals(defensivos, agro.getDefensivos());
        Assertions.assertEquals("123456789012345678901234567890", agro.getDefensivos().get(0).getNumeroReceituario());
        Assertions.assertEquals("12345678909", agro.getDefensivos().get(0).getCPFRespTec());
        Assertions.assertEquals("ABCDEFGHIJABCDEFGHIJABCDEFGHIJ", agro.getDefensivos().get(1).getNumeroReceituario());
        Assertions.assertEquals("98765432100", agro.getDefensivos().get(1).getCPFRespTec());

        Assertions.assertEquals(g, agro.getGuiaTransito());
        Assertions.assertEquals(com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoAgropecuarioTipoGuia.GTA, agro.getGuiaTransito().getTipoGuia());
        Assertions.assertEquals("SP", agro.getGuiaTransito().getUfGuia());
        Assertions.assertEquals("SERIE123", agro.getGuiaTransito().getSerieGuia());
        Assertions.assertEquals(Integer.valueOf(123456789), agro.getGuiaTransito().getNumeroGuia());

    }

    @Test
    public void devePermitirSetarEObterSomenteGuiaTransito() {
        NFNotaInfoAgropecuario agro = new NFNotaInfoAgropecuario();
        NFNotaInfoAgropecuarioGuiaTransito g = guia("MG", "SERIE999", 987654321);
        agro.setGuiaTransito(g);

        Assertions.assertNull(agro.getDefensivos());
        Assertions.assertNotNull(agro.getGuiaTransito());
        Assertions.assertEquals(com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoAgropecuarioTipoGuia.GTA, agro.getGuiaTransito().getTipoGuia());
        Assertions.assertEquals("MG", agro.getGuiaTransito().getUfGuia());
        Assertions.assertEquals("SERIE999", agro.getGuiaTransito().getSerieGuia());
        Assertions.assertEquals(Integer.valueOf(987654321), agro.getGuiaTransito().getNumeroGuia());
    }

    @Test
    public void devePermitirSetarEObterSomenteDefensivos() {
        NFNotaInfoAgropecuario agro = new NFNotaInfoAgropecuario();
        List<NFNotaInfoAgropecuarioDefensivo> defensivos = defensivosPadrao();
        agro.setDefensivos(defensivos);

        Assertions.assertNull(agro.getGuiaTransito());
        Assertions.assertNotNull(agro.getDefensivos());
        Assertions.assertEquals(2, agro.getDefensivos().size());
        Assertions.assertEquals("123456789012345678901234567890", agro.getDefensivos().get(0).getNumeroReceituario());
        Assertions.assertEquals("12345678909", agro.getDefensivos().get(0).getCPFRespTec());
        Assertions.assertEquals("ABCDEFGHIJABCDEFGHIJABCDEFGHIJ", agro.getDefensivos().get(1).getNumeroReceituario());
        Assertions.assertEquals("98765432100", agro.getDefensivos().get(1).getCPFRespTec());
    }

    @Test
    public void naoAceitaCPFInvalido() {
        NFNotaInfoAgropecuarioDefensivo d = new NFNotaInfoAgropecuarioDefensivo();

        try {
            d.setNumeroReceituario("ABCDEFGHIJABCDEFGHIJABCDEFGHIJ");
            d.setCPFRespTec("39053344706A");
            fail("Deveria lançar exceção para CPF inválido");
        } catch (RuntimeException expected) {
            // ok
        }
    }

    @Test
    public void naoAceitaReceituarioComMaisDe30Caracteres() {
        NFNotaInfoAgropecuarioDefensivo d = new NFNotaInfoAgropecuarioDefensivo();
        try {
            d.setNumeroReceituario("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            fail("Deveria lançar exceção para receituário > 30");
        } catch (RuntimeException expected) { /* ok */ }
    }

    @Test
    public void naoAceitaSerieGuiaComMaisDe9Caracteres() {
        NFNotaInfoAgropecuarioGuiaTransito g = new NFNotaInfoAgropecuarioGuiaTransito();
        try {
            g.setSerieGuia("ABCDEFGHIJ");
            fail("Deveria lançar exceção para série > 9");
        } catch (RuntimeException expected) { /* ok */ }
    }

    @Test
    public void naoAceitaNumeroGuiaComMaisDe9Digitos() {
        NFNotaInfoAgropecuarioGuiaTransito g = new NFNotaInfoAgropecuarioGuiaTransito();
        try {
            g.setNumeroGuia(1234567890);
            fail("Deveria lançar exceção para número > 9");
        } catch (RuntimeException expected) { /* ok */ }
    }

}
