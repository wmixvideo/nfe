package com.fincatto.nfe310.integracao;

import java.io.File;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.parsers.NotaParser;
import com.fincatto.nfe310.validadores.xsd.XMLValidador;
import com.fincatto.util.TesteUtil;

public class ValidacaoXML {
    private static final String DIRETORIO_XML_NOTAS = "/tmp/notas";

    @Test
    public void deveValidarXMLContraXSD() throws Throwable {
        XMLValidador.validaNota(FabricaDeObjetosFake.getNFNota1().toString());
    }

    @Test
    @Ignore
    public void validaArquivos() throws Throwable {
        for (final File notaXML : TesteUtil.getArquivosParaTestes(new File(ValidacaoXML.DIRETORIO_XML_NOTAS))) {
            Assert.assertEquals(TesteUtil.filepathToString(notaXML.getAbsolutePath()), new NotaParser().notaParaObjeto(notaXML).toString());
        }
    }
}