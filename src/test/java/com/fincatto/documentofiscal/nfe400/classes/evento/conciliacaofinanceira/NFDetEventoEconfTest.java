package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFDetEventoEconfTest {

    @Test
    public void tamanhoMaximo20CampoVersaoAplicativo() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFDetEventoEconf().setVersaoAplicativo("a".repeat(21)));
    }

    @Test
    public void tamanhoMinimo1CampoVersaoAplicativo() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFDetEventoEconf().setVersaoAplicativo(""));
    }

    @Test
    public void naoDevePermitirListaDePagamentosVazia() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFDetEventoEconf().setPagamentos(new ArrayList<>()));
    }

    @Test
    public void naoDevePermitirMaisDe100Pagamentos() {
        Assertions.assertThrows(IllegalStateException.class,
                () -> new NFDetEventoEconf().setPagamentos(Collections.nCopies(101, FabricaDeObjetosFake.getNFDetPagEconf())));
    }

    @Test
    public void devePermitirAte100Pagamentos() {
        final NFDetEventoEconf detEvento = new NFDetEventoEconf();
        detEvento.setPagamentos(Collections.nCopies(100, FabricaDeObjetosFake.getNFDetPagEconf()));
        Assertions.assertEquals(100, detEvento.getPagamentos().size());
    }

    @Test
    public void naoDeveGerarXMLSemPagamentos() {
        final NFDetEventoEconf detEvento = new NFDetEventoEconf();
        detEvento.setDescricaoEvento("ECONF");
        detEvento.setVersao(new BigDecimal("1.00"));
        detEvento.setVersaoAplicativo("1.00");
        Assertions.assertThrows(IllegalStateException.class, detEvento::toString);
    }

    @Test
    public void naoDeveGerarXMLSemVersaoAplicativo() {
        final NFDetEventoEconf detEvento = new NFDetEventoEconf();
        detEvento.setDescricaoEvento("ECONF");
        detEvento.setVersao(new BigDecimal("1.00"));
        detEvento.setPagamentos(Collections.singletonList(FabricaDeObjetosFake.getNFDetPagEconf()));
        Assertions.assertThrows(IllegalStateException.class, detEvento::toString);
    }

    @Test
    public void deveGerarXMLComTodosOsCamposNaOrdemDoXSD() {
        final String xmlEsperado =
                "<detEvento versao=\"1.00\">" +
                        "<descEvento>ECONF</descEvento>" +
                        "<verAplic>1.00</verAplic>" +
                        "<detPag><tPag>17</tPag><vPag>5000.00</vPag><dPag>2026-10-28</dPag></detPag>" +
                        "<detPag><tPag>17</tPag><vPag>5000.00</vPag><dPag>2026-10-28</dPag></detPag>" +
                        "</detEvento>";
        final NFDetEventoEconf detEvento = new NFDetEventoEconf();
        detEvento.setDescricaoEvento("ECONF");
        detEvento.setVersao(new BigDecimal("1.00"));
        detEvento.setVersaoAplicativo("1.00");
        detEvento.setPagamentos(Arrays.asList(FabricaDeObjetosFake.getNFDetPagEconf(), FabricaDeObjetosFake.getNFDetPagEconf()));

        Assertions.assertEquals(xmlEsperado, detEvento.toString());
    }
}
