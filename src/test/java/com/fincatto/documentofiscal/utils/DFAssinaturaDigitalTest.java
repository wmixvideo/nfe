package com.fincatto.documentofiscal.utils;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class DFAssinaturaDigitalTest {

    @Test
    @Ignore
    public void isValida() throws Exception {
        try (InputStream inputStream = new FileInputStream(new File("/tmp/nota_a_validar.xml"))) {
            Assert.assertTrue(DFAssinaturaDigital.isValida(inputStream));
        }
    }
}