package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CTeNotaInfoValorPrestacaoServicoTest {

    @Test
    public void naoDeveGerarValorLiquidoQuandoNulo() {
        final String xml = "<vPrest xmlns=\"http://www.portalfiscal.inf.br/cte\"><vTPrest>100.00</vTPrest><vRec>100.00</vRec><Comp><xNome>FRETE</xNome><vComp>100.00</vComp></Comp></vPrest>";
        Assertions.assertEquals(xml, FabricaDeObjetosFake.getValorPrestacaoServico().toString());
    }

    @Test
    public void deveGerarValorLiquidoEntreTotalEReceber() {
        final CTeNotaInfoValorPrestacaoServico valorPrestacao = FabricaDeObjetosFake.getValorPrestacaoServico();
        valorPrestacao.setValorTotalLiquidoPrestacaoServico(new BigDecimal("90"));
        Assertions.assertEquals("90.00", valorPrestacao.getValorTotalLiquidoPrestacaoServico());
        Assertions.assertTrue(valorPrestacao.toString().contains("<vTPrest>100.00</vTPrest><vTPrestLiq>90.00</vTPrestLiq><vRec>100.00</vRec>"));
    }

    @Test
    public void valorLiquidoNaoDeveExtrapolarTamanho() {
        final CTeNotaInfoValorPrestacaoServico valorPrestacao = new CTeNotaInfoValorPrestacaoServico();
        Assertions.assertThrows(NumberFormatException.class, () -> valorPrestacao.setValorTotalLiquidoPrestacaoServico(new BigDecimal("12345678901234")));
        Assertions.assertThrows(NumberFormatException.class, () -> valorPrestacao.setValorTotalLiquidoPrestacaoServico(new BigDecimal("1.123")));
        Assertions.assertThrows(NumberFormatException.class, () -> valorPrestacao.setValorTotalLiquidoPrestacaoServico(new BigDecimal("-1")));
    }
}
