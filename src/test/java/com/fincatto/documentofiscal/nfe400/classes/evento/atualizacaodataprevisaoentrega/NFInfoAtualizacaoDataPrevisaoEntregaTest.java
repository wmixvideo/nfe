package com.fincatto.documentofiscal.nfe400.classes.evento.atualizacaodataprevisaoentrega;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NFInfoAtualizacaoDataPrevisaoEntregaTest {

    @Test
    public void deveObterTipoAutorComoFoiSetado() {
        final NFInfoAtualizacaoDataPrevisaoEntrega infoAtualizacaoDataPrevisaoEntrega = new NFInfoAtualizacaoDataPrevisaoEntrega();
        final NFEventoTipoAutor tpAutor = NFEventoTipoAutor.EMPRESA_EMITENTE;
        infoAtualizacaoDataPrevisaoEntrega.setTipoAutor(tpAutor);
        Assert.assertEquals(tpAutor, infoAtualizacaoDataPrevisaoEntrega.getTipoAutor());
    }

    @Test
    public void deveObterCodigoOrgaoAutorComoFoiSetado() {
        final NFInfoAtualizacaoDataPrevisaoEntrega infoAtualizacaoDataPrevisaoEntrega = new NFInfoAtualizacaoDataPrevisaoEntrega();
        final DFUnidadeFederativa ufAutorEvento = DFUnidadeFederativa.PR;
        infoAtualizacaoDataPrevisaoEntrega.setUfAutorEvento(ufAutorEvento);
        Assert.assertEquals(ufAutorEvento, infoAtualizacaoDataPrevisaoEntrega.getUfAutorEvento());
    }

    @Test
    public void deveObterDataPrevisaoEntregaComoFoiSetado() {
        final NFInfoAtualizacaoDataPrevisaoEntrega infoAtualizacaoDataPrevisaoEntrega = new NFInfoAtualizacaoDataPrevisaoEntrega();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
        LocalDate data = LocalDate.parse("2025-11-12", formatter);

        infoAtualizacaoDataPrevisaoEntrega.setDataPrevisaoEntrega(data);
        Assert.assertEquals(data, infoAtualizacaoDataPrevisaoEntrega.getDataPrevisaoEntrega());
    }
}
