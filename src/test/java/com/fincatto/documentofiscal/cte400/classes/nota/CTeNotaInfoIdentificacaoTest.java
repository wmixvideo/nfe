package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CTeNotaInfoIdentificacaoTest {

    @Test
    public void deveGerarXMLCorretamente() {
        final CTeNotaInfoIdentificacao identificacao = FabricaDeObjetosFake.getInfoIdentificador();
        final String retorno = "<ide xmlns=\"http://www.portalfiscal.inf.br/cte\"><cUF>42</cUF><cCT>67890123</cCT><CFOP>5353</CFOP><natOp>Prestacao de servico de transporte</natOp><mod>57</mod><serie>1</serie><nCT>123</nCT><dhEmi>2018-01-22T10:10:10-02:00</dhEmi><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>4</cDV><tpAmb>2</tpAmb><tpCTe>0</tpCTe><procEmi>0</procEmi><verProc>1.00</verProc><indGlobalizado>1</indGlobalizado><cMunEnv>4205407</cMunEnv><xMunEnv>Floriano</xMunEnv><UFEnv>SC</UFEnv><modal>01</modal><tpServ>0</tpServ><cMunIni>4205407</cMunIni><xMunIni>Floriano</xMunIni><UFIni>SC</UFIni><cMunFim>4205407</cMunFim><xMunFim>Floriano</xMunFim><UFFim>SC</UFFim><retira>1</retira><xDetRetira>Nao retira</xDetRetira><indIEToma>9</indIEToma><toma3><toma>2</toma></toma3></ide>";
        Assertions.assertEquals(retorno, identificacao.toString());
    }

    @Test
    public void deveGerarXMLComGrupoCompraGovernamental() {
        final CTeNotaInfoIdentificacao identificacao = FabricaDeObjetosFake.getInfoIdentificador();
        identificacao.setGrupoCompraGovernamental(FabricaDeObjetosFake.getGrupoCompraGovernamental());
        final String retorno = "<ide xmlns=\"http://www.portalfiscal.inf.br/cte\"><cUF>42</cUF><cCT>67890123</cCT><CFOP>5353</CFOP><natOp>Prestacao de servico de transporte</natOp><mod>57</mod><serie>1</serie><nCT>123</nCT><dhEmi>2018-01-22T10:10:10-02:00</dhEmi><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>4</cDV><tpAmb>2</tpAmb><tpCTe>0</tpCTe><procEmi>0</procEmi><verProc>1.00</verProc><indGlobalizado>1</indGlobalizado><cMunEnv>4205407</cMunEnv><xMunEnv>Floriano</xMunEnv><UFEnv>SC</UFEnv><modal>01</modal><tpServ>0</tpServ><cMunIni>4205407</cMunIni><xMunIni>Floriano</xMunIni><UFIni>SC</UFIni><cMunFim>4205407</cMunFim><xMunFim>Floriano</xMunFim><UFFim>SC</UFFim><retira>1</retira><xDetRetira>Nao retira</xDetRetira><indIEToma>9</indIEToma><toma3><toma>2</toma></toma3><gCompraGov><tpEnteGov>1</tpEnteGov><pRedutor>10.00</pRedutor><tpOperGov>2</tpOperGov><refDFeAnt>12345678901234567890123456789012345678901234</refDFeAnt></gCompraGov></ide>";
        Assertions.assertEquals(retorno, identificacao.toString());
    }

    @Test
    public void deveGerarGrupoCompraGovernamentalNaOrdemDoXSD() {
        final CTeNotaInfoIdentificacao identificacao = FabricaDeObjetosFake.getInfoIdentificador();
        identificacao.setDataContingencia(LocalDateTime.of(2018, 1, 22, 10, 10, 10));
        identificacao.setJustificativa("Justificativa de contingencia");
        identificacao.setGrupoCompraGovernamental(FabricaDeObjetosFake.getGrupoCompraGovernamental());
        identificacao.setTpPagAnt("1");
        final String xml = identificacao.toString();
        Assertions.assertTrue(xml.contains("</xJust>"));
        Assertions.assertTrue(xml.indexOf("</xJust>") < xml.indexOf("<gCompraGov>"));
        Assertions.assertTrue(xml.indexOf("</gCompraGov>") < xml.indexOf("<tpPagAnt>"));
    }

    @Test
    public void deveRetornarGrupoCompraGovernamentalInformado() {
        final CTeNotaInfoIdentificacao identificacao = new CTeNotaInfoIdentificacao();
        final CTeNotaInfoIdeGrupoCompraGovernamental grupo = FabricaDeObjetosFake.getGrupoCompraGovernamental();
        identificacao.setGrupoCompraGovernamental(grupo);
        Assertions.assertSame(grupo, identificacao.getGrupoCompraGovernamental());
    }
}
