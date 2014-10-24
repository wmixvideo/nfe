package com.fincatto.nfe310.integracao;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.simpleframework.xml.core.Persister;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import com.fincatto.nfe310.validadores.xsd.XMLValidador;
import com.fincatto.util.TesteUtil;

public class ValidacaoXML {
    private static final String DIRETORIO_XML_NOTAS = "/tmp/notas";

    @Test
    public void deveValidarXMLContraXSD() throws Throwable {
        XMLValidador.validaNota(FabricaDeObjetosFake.getNFNota1().toString());
    }

    @Test
    public void validaArquivos() throws Throwable {
        final Persister persister = new Persister(new NFRegistryMatcher());
        for (final File notaXML : TesteUtil.getArquivosParaTestes(new File(ValidacaoXML.DIRETORIO_XML_NOTAS))) {
            final NFNota notaParser = persister.read(NFNota.class, notaXML);
            XMLValidador.validaNota(notaParser.toString());
            Assert.assertEquals(TesteUtil.filepathToString(notaXML.getAbsolutePath()), notaParser.toString());
        }
    }
}