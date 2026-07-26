package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoCategoriaCombinacaoVeicular;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Correcao: categCombVeic deve ser irmao de disp (filho direto de valePed, uma unica ocorrencia),
 * conforme mdfeModalRodoviario_v3.00.xsd, e nao um elemento repetido dentro de cada disp.
 */
public class MDFInfoModalRodoviarioPedagioTest {

    @Test
    public void categCombVeicDeveSerSerializadoComoIrmaoDeDispEAposTodosOsDisp() {
        final MDFInfoModalRodoviarioPedagio pedagio = buildPedagioComDoisDispositivos();

        final String xml = pedagio.toString();

        final int fimUltimoDisp = xml.lastIndexOf("</disp>") + "</disp>".length();
        final int posicaoCategCombVeic = xml.indexOf("<categCombVeic>");

        Assert.assertTrue("categCombVeic deve estar presente no XML", posicaoCategCombVeic >= 0);
        Assert.assertTrue("categCombVeic deve vir depois de fechar todos os <disp>", posicaoCategCombVeic >= fimUltimoDisp);

        final String[] blocosDisp = xml.split("<disp>");
        for (int i = 1; i < blocosDisp.length; i++) {
            final String conteudoDisp = blocosDisp[i].substring(0, blocosDisp[i].indexOf("</disp>"));
            Assert.assertFalse("categCombVeic nao deve aparecer dentro de <disp>", conteudoDisp.contains("categCombVeic"));
        }
    }

    @Test
    public void naoDeveGerarCategCombVeicQuandoNaoSetado() {
        final MDFInfoModalRodoviarioPedagio pedagio = new MDFInfoModalRodoviarioPedagio();
        pedagio.setDispositivos(buildDispositivos());

        final String xml = pedagio.toString();

        Assert.assertFalse("categCombVeic nao deve aparecer quando nulo", xml.contains("categCombVeic"));
    }

    @Test
    public void deveRealizarRoundTripDeSerializacao() throws Exception {
        final DFPersister persister = new DFPersister();
        final MDFInfoModalRodoviarioPedagio original = buildPedagioComDoisDispositivos();

        final String xml = original.toString();
        final MDFInfoModalRodoviarioPedagio lido = persister.read(MDFInfoModalRodoviarioPedagio.class, xml);

        Assert.assertNotNull(lido);
        Assert.assertEquals(original.getCategoriaCombinacaoVeicular(), lido.getCategoriaCombinacaoVeicular());
        Assert.assertEquals(original.getDispositivos().size(), lido.getDispositivos().size());
        Assert.assertEquals(original.getDispositivos().get(0).getCnpjFornecedora(), lido.getDispositivos().get(0).getCnpjFornecedora());
    }

    private MDFInfoModalRodoviarioPedagio buildPedagioComDoisDispositivos() {
        final MDFInfoModalRodoviarioPedagio pedagio = new MDFInfoModalRodoviarioPedagio();
        pedagio.setDispositivos(buildDispositivos());
        pedagio.setCategoriaCombinacaoVeicular(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_5_EIXOS);
        return pedagio;
    }

    private List<MDFInfoModalRodoviarioPedagioDisp> buildDispositivos() {
        final List<MDFInfoModalRodoviarioPedagioDisp> dispositivos = new ArrayList<>();
        dispositivos.add(buildDisp("27865757000102"));
        dispositivos.add(buildDisp("40151127000126"));
        return dispositivos;
    }

    private MDFInfoModalRodoviarioPedagioDisp buildDisp(final String cnpjFornecedora) {
        final MDFInfoModalRodoviarioPedagioDisp disp = new MDFInfoModalRodoviarioPedagioDisp();
        disp.setCnpjFornecedora(cnpjFornecedora);
        disp.setValor(new BigDecimal("104.24"));
        return disp;
    }
}
