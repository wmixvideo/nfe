package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte400.classes.CTTipoRegimeIBSCBS;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeNotaInfoEmitenteTest {

    @Test
    public void naoDeveGerarTipoRegimeIBSCBSQuandoNulo() {
        final String xml = FabricaDeObjetosFake.getInfoEmitente().toString();
        Assertions.assertFalse(xml.contains("tpRegimeIBSCBS"));
        Assertions.assertTrue(xml.contains("<CRT>3</CRT></emit>"));
    }

    @Test
    public void deveGerarTipoRegimeIBSCBSAposCRT() {
        final CTeNotaInfoEmitente emitente = FabricaDeObjetosFake.getInfoEmitente();
        emitente.setTipoRegimeIBSCBS(CTTipoRegimeIBSCBS.NORMAL_PENDENTE_SIMPLES_NACIONAL_SEM_REGIME_REGULAR);
        Assertions.assertTrue(emitente.toString().contains("<CRT>3</CRT><tpRegimeIBSCBS>2</tpRegimeIBSCBS></emit>"));
    }

    @Test
    public void deveGerarTipoRegimeIBSCBSEntreCRTEISUFEmit() {
        final CTeNotaInfoEmitente emitente = FabricaDeObjetosFake.getInfoEmitente();
        emitente.setTipoRegimeIBSCBS(CTTipoRegimeIBSCBS.NORMAL_PENDENTE_SIMPLES_NACIONAL_COM_REGIME_REGULAR);
        emitente.setISUFEmit("12345678");
        Assertions.assertTrue(emitente.toString().contains("<CRT>3</CRT><ISUFEmit>12345678</ISUFEmit><tpRegimeIBSCBS>4</tpRegimeIBSCBS></emit>"));
    }

    @Test
    public void deveLerTipoRegimeIBSCBSDoXML() throws Exception {
        final CTeNotaInfoEmitente emitente = FabricaDeObjetosFake.getInfoEmitente();
        emitente.setTipoRegimeIBSCBS(CTTipoRegimeIBSCBS.SIMPLES_NACIONAL_COM_REGIME_REGULAR);

        final CTeNotaInfoEmitente lido = new DFPersister().read(CTeNotaInfoEmitente.class, emitente.toString());
        Assertions.assertEquals(CTTipoRegimeIBSCBS.SIMPLES_NACIONAL_COM_REGIME_REGULAR, lido.getTipoRegimeIBSCBS());
        Assertions.assertEquals(emitente.toString(), lido.toString());
    }

    @Test
    public void deveLerEmitenteSemTipoRegimeIBSCBSDoXML() throws Exception {
        final CTeNotaInfoEmitente emitente = FabricaDeObjetosFake.getInfoEmitente();

        final CTeNotaInfoEmitente lido = new DFPersister().read(CTeNotaInfoEmitente.class, emitente.toString());
        Assertions.assertNull(lido.getTipoRegimeIBSCBS());
        Assertions.assertEquals(emitente.toString(), lido.toString());
    }
}
