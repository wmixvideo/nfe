package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MDFInfoModalRodoviarioANTTTest {

    private MDFInfoModalRodoviarioANTT antt;

    @BeforeEach
    public void setUp() {
        this.antt = new MDFInfoModalRodoviarioANTT();
    }

    @Test
    public void deveAceitarRntrcCom8Caracteres() {
        antt.setRntrc("12345678");
        Assertions.assertEquals("12345678", antt.getRntrc());
    }

    @Test
    public void deveRejeitarRntrcVazio() {
        Assertions.assertThrows(IllegalStateException.class, () -> antt.setRntrc(""));
    }

    @Test
    public void deveRejeitarRntrcComMenosDe8Chars() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            antt.setRntrc("1234567"); // 7
        });
    }

    @Test
    public void deveRejeitarRntrcComMaisDe8Chars() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            antt.setRntrc("123456789"); // 9
        });
    }

    // ---------------- infCIOT ----------------
    @Test
    public void deveAceitarInfCiotNulo() {
        antt.setInfCIOT(null);
        Assertions.assertNull(antt.getInfCIOT());
    }

    @Test
    public void deveAceitarInfCiotVazio() {
        List<MDFInfoModalRodoviarioInfCIOT> emptyList = Collections.emptyList();
        antt.setInfCIOT(emptyList);

        Assertions.assertSame(emptyList, antt.getInfCIOT());
    }

    @Test
    public void deveManterElementosInfCiot() {

        MDFInfoModalRodoviarioInfCIOT item = new MDFInfoModalRodoviarioInfCIOT();

        List<MDFInfoModalRodoviarioInfCIOT> lista = new ArrayList<>();
        lista.add(item);

        antt.setInfCIOT(lista);

        Assertions.assertEquals(1, antt.getInfCIOT().size());
        Assertions.assertSame(item, antt.getInfCIOT().get(0));
    }

    // ---------------- valePed ----------------

    @Test
    public void deveAceitarValePedNuloEVazio() {

        antt.setValePedagio(null);
        Assertions.assertNull(antt.getValePedagio());

    }

    // ---------------- infPag ----------------
    @Test
    public void deveAceitarInfPagNuloEVazio() {
        antt.setInfPag(null);
        Assertions.assertNull(antt.getInfPag());

        List<MDFInfoModalRodoviarioInfPag> infPags = new ArrayList<>();
        antt.setInfPag(infPags);

        Assertions.assertSame(infPags, antt.getInfPag());
        Assertions.assertTrue(antt.getInfPag().isEmpty());
    }

    @Test
    public void deveManterItensInfPag() {
        MDFInfoModalRodoviarioInfPag pag = new MDFInfoModalRodoviarioInfPag();
        List<MDFInfoModalRodoviarioInfPag> infPags = new ArrayList<>();
        infPags.add(pag);

        antt.setInfPag(infPags);

        Assertions.assertEquals(1, antt.getInfPag().size());
        Assertions.assertSame(pag, antt.getInfPag().get(0));
    }

}