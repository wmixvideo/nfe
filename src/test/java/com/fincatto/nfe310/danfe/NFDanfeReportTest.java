package com.fincatto.nfe310.danfe;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.NFProtocolo;
import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.classes.nota.NFNotaProcessada;
import com.fincatto.nfe310.classes.nota.assinatura.NFSignature;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFDanfeReportTest {

    @Test
    public void deveGerarDanfeAPartirDoXML() throws Exception {
        final NFProtocolo nfProtocolo = new NFProtocolo();
        nfProtocolo.setProtocoloInfo(FabricaDeObjetosFake.getNFProtocoloInfo());
        nfProtocolo.setVersao("3.10");

        final NFSignature signature = new NFSignature();
        signature.setSignatureValue("NFe89172658591754401086218048846976493475937081");

        final NFNota nota = new NFNota();
        nota.setInfo(FabricaDeObjetosFake.getNFNotaInfo());
        nota.setIdentificadorLocal(123456);
        nota.setAssinatura(signature);

        final NFNotaProcessada notaProcessada = new NFNotaProcessada();
        notaProcessada.setVersao(BigDecimal.TEN);
        notaProcessada.setProtocolo(nfProtocolo);
        notaProcessada.setNota(nota);

        final byte[] danfe = NFDanfeReport.imprimirDanfe(notaProcessada);
        //FileUtils.writeByteArrayToFile(new File("/tmp/danfe.pdf"), danfe);
        Assert.assertTrue(danfe.length > 0);
    }
}
