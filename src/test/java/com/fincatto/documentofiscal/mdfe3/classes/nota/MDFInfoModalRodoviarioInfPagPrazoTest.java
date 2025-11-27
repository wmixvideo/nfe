package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class MDFInfoModalRodoviarioInfPagPrazoTest  {

    private MDFInfoModalRodoviarioInfPagPrazo prazo;

    @Before
    public void setUp() {
        this.prazo = new MDFInfoModalRodoviarioInfPagPrazo();
    }

    // ---------------- nParcela ----------------

    @Test
    public void deveAceitarNParcelaComTamanhoMinimo() {
        prazo.setNParcela("1");
        assertEquals("001", prazo.getNParcela());
    }

    @Test
    public void deveAceitarNParcelaComTamanhoMaximo60() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 60; i++) sb.append('X');
        String nParcela60 = sb.toString();

        prazo.setNParcela(nParcela60);

        assertEquals(60, prazo.getNParcela().length());
        assertEquals(nParcela60, prazo.getNParcela());
    }

    // ---------------- dVenc ----------------

    @Test
    public void deveAceitarDVencLocalDateValido() {
        MDFInfoModalRodoviarioInfPagPrazo prazo = new MDFInfoModalRodoviarioInfPagPrazo();

        LocalDate dataValida = LocalDate.of(2025, 10, 7);
        prazo.setDVenc(dataValida);

        assertEquals(dataValida, prazo.getDVenc());
    }

    @Test
    public void devePermitirAlterarDVenc() {
        MDFInfoModalRodoviarioInfPagPrazo prazo = new MDFInfoModalRodoviarioInfPagPrazo();

        LocalDate primeira = LocalDate.of(2025, 1, 9);
        LocalDate segunda  = LocalDate.of(2025, 12, 31);

        prazo.setDVenc(primeira);
        assertEquals(primeira, prazo.getDVenc());

        prazo.setDVenc(segunda);
        assertEquals(segunda, prazo.getDVenc());
    }

    @Test
    public void deveAceitarDVencNulo() {
        MDFInfoModalRodoviarioInfPagPrazo prazo = new MDFInfoModalRodoviarioInfPagPrazo();

        prazo.setDVenc(null);
        Assert.assertNull(prazo.getDVenc());

        prazo.setDVenc(LocalDate.of(2025, 10, 7));
        Assert.assertNotNull(prazo.getDVenc());
        prazo.setDVenc(null);
        Assert.assertNull(prazo.getDVenc());
    }

    // ---------------- vParcela ----------------

    @Test
    public void deveAceitarVParcelaValidoNoLimite() {
        BigDecimal limite = new BigDecimal("9999999999.99");
        prazo.setVParcela(limite);
        assertEquals(0, prazo.getVParcela().compareTo(limite));
    }

    @Test
    public void deveAceitarVParcelaValidoIntermediario() {
        BigDecimal valor = new BigDecimal("1234567890.23");
        prazo.setVParcela(valor);
        assertEquals(0, prazo.getVParcela().compareTo(valor));
    }

    @Test(expected = NumberFormatException.class)
    public void deveRejeitarVParcelaComMaisDe2CasasDecimais() {
        prazo.setVParcela(new BigDecimal("10.999"));
    }

    @Test(expected = NumberFormatException.class)
    public void deveRejeitarVParcelaComMaisDe13Digitos() {
        prazo.setVParcela(new BigDecimal("100000000000.00"));
    }
}