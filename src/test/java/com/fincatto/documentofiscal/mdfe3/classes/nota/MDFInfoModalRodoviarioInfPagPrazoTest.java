package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MDFInfoModalRodoviarioInfPagPrazoTest  {

    private MDFInfoModalRodoviarioInfPagPrazo prazo;

    @BeforeEach
    public void setUp() {
        this.prazo = new MDFInfoModalRodoviarioInfPagPrazo();
    }

    // ---------------- nParcela ----------------

    @Test
    public void deveAceitarNParcelaComTamanhoMinimo() {
        prazo.setNParcela("1");
        Assertions.assertEquals("001", prazo.getNParcela());
    }

    @Test
    public void deveAceitarNParcelaComTamanhoMaximo60() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 60; i++) sb.append('X');
        String nParcela60 = sb.toString();

        prazo.setNParcela(nParcela60);

        Assertions.assertEquals(60, prazo.getNParcela().length());
        Assertions.assertEquals(nParcela60, prazo.getNParcela());
    }

    // ---------------- dVenc ----------------

    @Test
    public void deveAceitarDVencLocalDateValido() {
        MDFInfoModalRodoviarioInfPagPrazo prazo = new MDFInfoModalRodoviarioInfPagPrazo();

        LocalDate dataValida = LocalDate.of(2025, 10, 7);
        prazo.setDVenc(dataValida);

        Assertions.assertEquals(dataValida, prazo.getDVenc());
    }

    @Test
    public void devePermitirAlterarDVenc() {
        MDFInfoModalRodoviarioInfPagPrazo prazo = new MDFInfoModalRodoviarioInfPagPrazo();

        LocalDate primeira = LocalDate.of(2025, 1, 9);
        LocalDate segunda  = LocalDate.of(2025, 12, 31);

        prazo.setDVenc(primeira);
        Assertions.assertEquals(primeira, prazo.getDVenc());

        prazo.setDVenc(segunda);
        Assertions.assertEquals(segunda, prazo.getDVenc());
    }

    @Test
    public void deveAceitarDVencNulo() {
        MDFInfoModalRodoviarioInfPagPrazo prazo = new MDFInfoModalRodoviarioInfPagPrazo();

        prazo.setDVenc(null);
        Assertions.assertNull(prazo.getDVenc());

        prazo.setDVenc(LocalDate.of(2025, 10, 7));
        Assertions.assertNotNull(prazo.getDVenc());
        prazo.setDVenc(null);
        Assertions.assertNull(prazo.getDVenc());
    }

    // ---------------- vParcela ----------------

    @Test
    public void deveAceitarVParcelaValidoNoLimite() {
        BigDecimal limite = new BigDecimal("9999999999.99");
        prazo.setVParcela(limite);
        Assertions.assertEquals(0, prazo.getVParcela().compareTo(limite));
    }

    @Test
    public void deveAceitarVParcelaValidoIntermediario() {
        BigDecimal valor = new BigDecimal("1234567890.23");
        prazo.setVParcela(valor);
        Assertions.assertEquals(0, prazo.getVParcela().compareTo(valor));
    }

    @Test
    public void deveRejeitarVParcelaComMaisDe2CasasDecimais() {
        Assertions.assertThrows(NumberFormatException.class, () -> prazo.setVParcela(new BigDecimal("10.999")));
    }

    @Test
    public void deveRejeitarVParcelaComMaisDe13Digitos() {
        Assertions.assertThrows(NumberFormatException.class, () -> prazo.setVParcela(new BigDecimal("100000000000.00")));
    }
}