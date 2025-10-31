package com.fincatto.documentofiscal.nfse;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.*;
import com.fincatto.documentofiscal.nfse.utils.NFSeEventoUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class NFSeEventoUtilsTest {

    @Ignore
    @Test
    public void testeFormatoPedidoRegistroEventoId(){
        final var evento = new NFSeSefinNacionalPedRegEvt();
        Assert.assertThrows(AssertionError.class, () -> NFSeEventoUtils.gerarId(evento));

        evento.setInfPedReg(new NFSeSefinNacionalInfPedReg().setChaveAcessoNFSE("12345123451234512134512345123451234512345123451234"));
        Assert.assertThrows(AssertionError.class, () -> NFSeEventoUtils.gerarId(evento));

        evento.getInfPedReg().setNPedRegEvento("1");
        Assert.assertThrows(AssertionError.class, () -> NFSeEventoUtils.gerarId(evento));

        evento.getInfPedReg().setEvento(new NFSeSefinNacionalInfPedRegTE101101());
        Assert.assertEquals("PRE12345123451234512134512345123451234512345123451234101101001", NFSeEventoUtils.gerarId(evento));
    }
}
