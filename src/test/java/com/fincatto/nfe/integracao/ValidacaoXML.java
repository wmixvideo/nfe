package com.fincatto.nfe.integracao;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.simpleframework.xml.core.Persister;

import com.fincatto.nfe.FabricaDeObjetosFake;
import com.fincatto.nfe.classes.nota.NFNota;
import com.fincatto.nfe.transformers.NFRegistryMatcher;
import com.fincatto.nfe.validadores.xsd.XMLValidador;
import com.fincatto.util.TesteUtil;

public class ValidacaoXML {

    private static final String DIRETORIO_XML_NOTAS = "/tmp/notas";

    @Test
    public void deveValidarXMLContraXSD() throws Throwable {
        XMLValidador.valida(FabricaDeObjetosFake.getNFNota1().toString(), this.getClass().getResource("nfe_v2.00.xsd").getFile());
    }

    @Test
    public void validaArquivos() throws Throwable {
        final Persister persister = new Persister(new NFRegistryMatcher());
        for (final File notaXML : TesteUtil.getArquivosParaTestes(new File(ValidacaoXML.DIRETORIO_XML_NOTAS))) {
            final NFNota notaParser = persister.read(NFNota.class, notaXML);
            XMLValidador.valida(notaParser.toString(), this.getClass().getResource("nfe_v2.00.xsd").getFile());
            Assert.assertEquals(TesteUtil.filepathToString(notaXML.getAbsolutePath()), notaParser.toString());
        }
    }
}