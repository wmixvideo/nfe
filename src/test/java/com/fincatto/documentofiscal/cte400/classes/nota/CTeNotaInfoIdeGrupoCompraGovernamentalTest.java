package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte400.classes.CTTipoEntidadeGovernamental;
import com.fincatto.documentofiscal.cte400.classes.CTTipoOperacaoGovernamental;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

public class CTeNotaInfoIdeGrupoCompraGovernamentalTest {

    private static final String CHAVE = "12345678901234567890123456789012345678901234";
    private static final String CHAVE_2 = "98765432109876543210987654321098765432109876";
    private static final String XML_ESPERADO = "<gCompraGov><tpEnteGov>1</tpEnteGov><pRedutor>10.00</pRedutor><tpOperGov>2</tpOperGov><refDFeAnt>" + CHAVE + "</refDFeAnt></gCompraGov>";

    @Test
    public void deveGerarXMLCorretamente() {
        Assertions.assertEquals(XML_ESPERADO, FabricaDeObjetosFake.getGrupoCompraGovernamental().toString());
    }

    @Test
    public void percentualRedutorDeveFormatarComAte4Casas() {
        final CTeNotaInfoIdeGrupoCompraGovernamental grupo = new CTeNotaInfoIdeGrupoCompraGovernamental();
        grupo.setPercentualRedutor(new BigDecimal("10"));
        Assertions.assertEquals("10.00", grupo.getPercentualRedutor());
        grupo.setPercentualRedutor(new BigDecimal("12.3456"));
        Assertions.assertEquals("12.3456", grupo.getPercentualRedutor());
        grupo.setPercentualRedutor(BigDecimal.ZERO);
        Assertions.assertEquals("0.00", grupo.getPercentualRedutor());
    }

    @Test
    public void percentualRedutorNaoDeveExtrapolarTamanho() {
        final CTeNotaInfoIdeGrupoCompraGovernamental grupo = new CTeNotaInfoIdeGrupoCompraGovernamental();
        Assertions.assertThrows(NumberFormatException.class, () -> grupo.setPercentualRedutor(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> grupo.setPercentualRedutor(new BigDecimal("1.23456")));
        Assertions.assertThrows(NumberFormatException.class, () -> grupo.setPercentualRedutor(new BigDecimal("-1")));
    }

    @Test
    public void naoDeveGerarRefDFeAntQuandoNuloOuVazio() {
        final CTeNotaInfoIdeGrupoCompraGovernamental grupo = FabricaDeObjetosFake.getGrupoCompraGovernamental();
        grupo.setDocumentosAnteriores(null);
        Assertions.assertFalse(grupo.toString().contains("refDFeAnt"));
        grupo.setDocumentosAnteriores(Collections.emptyList());
        Assertions.assertFalse(grupo.toString().contains("refDFeAnt"));
    }

    @Test
    public void deveGerarUmaTagPorDocumentoAnterior() {
        final CTeNotaInfoIdeGrupoCompraGovernamental grupo = FabricaDeObjetosFake.getGrupoCompraGovernamental();
        grupo.setDocumentosAnteriores(Arrays.asList(CHAVE, CHAVE_2));
        Assertions.assertTrue(grupo.toString().endsWith("<refDFeAnt>" + CHAVE + "</refDFeAnt><refDFeAnt>" + CHAVE_2 + "</refDFeAnt></gCompraGov>"));
    }

    @Test
    public void deveLerXMLGerado() throws Exception {
        final CTeNotaInfoIdeGrupoCompraGovernamental grupo = new DFPersister().read(CTeNotaInfoIdeGrupoCompraGovernamental.class, XML_ESPERADO);
        Assertions.assertEquals(CTTipoEntidadeGovernamental.UNIAO, grupo.getTipoEntidadeGovernamental());
        Assertions.assertEquals("10.00", grupo.getPercentualRedutor());
        Assertions.assertEquals(CTTipoOperacaoGovernamental.RECEBIMENTO_PAGAMENTO_REALIZADO, grupo.getTipoOperacaoGovernamental());
        Assertions.assertEquals(Collections.singletonList(CHAVE), grupo.getDocumentosAnteriores());
    }
}
