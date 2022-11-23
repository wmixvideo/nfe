package com.fincatto.documentofiscal.utils;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

public class DFAssinaturaDigitalTest {

    @Test
    @Ignore
    public void isValida() throws Exception {
        try (InputStream inputStream = Files.newInputStream(new File("/tmp/42221012672380000190550010001580701847885151.xml").toPath())) {
            Assert.assertTrue(DFAssinaturaDigital.isValida(inputStream));
        }
    }
}