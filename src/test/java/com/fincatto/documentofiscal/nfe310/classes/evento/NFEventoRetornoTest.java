package com.fincatto.documentofiscal.nfe310.classes.evento;

import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFEventoRetornoTest {

    @Test
    public void deveObterInfoEventoRetornoComoFoiSetado() {
        final NFEventoRetorno retorno = new NFEventoRetorno();
        final NFInfoEventoRetorno infoEventoRetorno = new NFInfoEventoRetorno();
        retorno.setInfoEventoRetorno(infoEventoRetorno);
        Assertions.assertEquals(infoEventoRetorno, retorno.getInfoEventoRetorno());
    }

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFEventoRetorno retorno = new NFEventoRetorno();
        final String versao = "3.10";
        retorno.setVersao(versao);
        Assertions.assertEquals(versao, retorno.getVersao());
    }

    @Test
    public void deveObterAssinaturaComoFoiSetado() {
        final NFEventoRetorno retorno = new NFEventoRetorno();
        final NFSignature assinatura = new NFSignature();
        retorno.setAssinatura(assinatura);
        Assertions.assertEquals(assinatura, retorno.getAssinatura());
    }
}