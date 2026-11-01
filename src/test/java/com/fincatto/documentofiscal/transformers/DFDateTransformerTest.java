package com.fincatto.documentofiscal.transformers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DFDateTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assertions.assertNotNull(new DFDateTransformer().read("2015-02-15T10:10:10"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        final String data = "2015-02-15T10:10:10";
        final Date dataEsperada = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(data);
        Assertions.assertEquals(dataEsperada, new DFDateTransformer().read(data));
    }
}