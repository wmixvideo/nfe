package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MDFInfoModalRodoviarioANTTTest {

    private MDFInfoModalRodoviarioANTT antt;

    @Before
    public void setUp() {
        this.antt =  new MDFInfoModalRodoviarioANTT();
    }

    @Test
    public void deveAceitarRntrcCom8Caracteres() {
        antt.setRntrc("12345678");
        assertEquals("getRntrc deve refletir o valor setado", "12345678", antt.getRntrc());
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarRntrcVazio() {
        antt.setRntrc("");
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarRntrcComMenosDe8Chars() {
        antt.setRntrc("1234567"); // 7
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarRntrcComMaisDe8Chars() {
        antt.setRntrc("123456789"); // 9
    }

    // ---------------- infCIOT ----------------
    @Test
    public void deveAceitarInfCiotNulo() {
        antt.setInfCIOT(null);
        Assert.assertNull(antt.getInfCIOT());
    }

    @Test
    public void deveAceitarInfCiotVazio() {
        List<MDFInfoModalRodoviarioInfCIOT> emptyList = Collections.emptyList();
        antt.setInfCIOT(emptyList);

        Assert.assertSame(emptyList, antt.getInfCIOT());
    }

    @Test
    public void deveManterElementosInfCiot() {

        MDFInfoModalRodoviarioInfCIOT item = new MDFInfoModalRodoviarioInfCIOT();

        List<MDFInfoModalRodoviarioInfCIOT> lista = new ArrayList<>();
        lista.add(item);

        antt.setInfCIOT(lista);

        Assert.assertEquals(1, antt.getInfCIOT().size());
        Assert.assertSame(item, antt.getInfCIOT().get(0));
    }

    // ---------------- valePed ----------------

    @Test
    public void deveAceitarValePedNuloEVazio() {

        antt.setValePedagio(null);
        Assert.assertNull(antt.getValePedagio());

    }

    // ---------------- infPag ----------------
    @Test
    public void deveAceitarInfPagNuloEVazio() {
        antt.setInfPag(null);
        Assert.assertNull(antt.getInfPag());

        List<MDFInfoModalRodoviarioInfPag> infPags = new ArrayList<>();
        antt.setInfPag(infPags);

        Assert.assertSame(infPags, antt.getInfPag());
        Assert.assertTrue(antt.getInfPag().isEmpty());
    }

    @Test
    public void deveManterItensInfPag() {
        MDFInfoModalRodoviarioInfPag pag = new MDFInfoModalRodoviarioInfPag();
        List<MDFInfoModalRodoviarioInfPag> infPags = new ArrayList<>();
        infPags.add(pag);

        antt.setInfPag(infPags);

        Assert.assertEquals(1, antt.getInfPag().size());
        Assert.assertSame(pag, antt.getInfPag().get(0));
    }

    // ---------------- infContrato ----------------

    @Test
    public void devePermitirInfContratoNuloEManterReferencia() {
        Assert.assertNull(antt.getInfContrato());

        MDFInfoModalRodoviarioInfContrato contrato = new MDFInfoModalRodoviarioInfContrato();
        antt.setInfContrato(contrato);
        Assert.assertSame(contrato, antt.getInfContrato());

        antt.setInfContrato(null);
        Assert.assertNull(antt.getInfContrato());
    }
}