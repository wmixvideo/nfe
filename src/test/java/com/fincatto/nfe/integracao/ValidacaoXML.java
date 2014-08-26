package com.fincatto.nfe.integracao;

import java.io.File;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.simpleframework.xml.core.Persister;

import com.fincatto.nfe.FabricaDeObjetosFake;
import com.fincatto.nfe.classes.nota.NFNota;
import com.fincatto.nfe.transformers.NFRegistryMatcher;
import com.fincatto.nfe.validadores.xsd.XMLValidador;
import com.fincatto.util.TesteUtil;

public class ValidacaoXML {

    private static final String DIRETORIO_NOTAS_DE_TESTE = "/tmp/notas";

    @Test
    public void deveValidarXMLContraXSD() throws Throwable {
        XMLValidador.valida(FabricaDeObjetosFake.getNFNota1().toString(), this.getClass().getResource("nfe_v2.00.xsd").getFile());
    }

    @Test
    @Ignore
    public void validaArquivos() throws Throwable {
        final Persister persister = new Persister(new NFRegistryMatcher());
        for (final File notaXML : TesteUtil.getArquivosParaTestes(new File(ValidacaoXML.DIRETORIO_NOTAS_DE_TESTE))) {
            final NFNota nota = persister.read(NFNota.class, notaXML);
            XMLValidador.valida(nota.toString(), this.getClass().getResource("nfe_v2.00.xsd").getFile());
            Assert.assertEquals(TesteUtil.filepathToString(notaXML.getAbsolutePath()), nota.toString());
        }
    }
}