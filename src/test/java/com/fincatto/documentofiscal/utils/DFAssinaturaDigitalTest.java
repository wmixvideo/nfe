package com.fincatto.documentofiscal.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

public class DFAssinaturaDigitalTest {

    @Test
    @Disabled
    public void isValida() throws Exception {
        try (InputStream inputStream = Files.newInputStream(new File("/tmp/42221012672380000190550010001580701847885151.xml").toPath())) {
            Assertions.assertTrue(DFAssinaturaDigital.isValida(inputStream));
        }
    }
}