package com.fincatto.documentofiscal.utils;

import org.junit.Assert;
import org.junit.Test;

public class DFUtilsTest {

    @Test
    public void isCNPJValido() {
        Assert.assertFalse(DFUtils.isCnpjValido(null));
        Assert.assertFalse(DFUtils.isCnpjValido(""));
        Assert.assertFalse(DFUtils.isCnpjValido("00000000000000"));
        Assert.assertFalse(DFUtils.isCnpjValido("11111111111111"));
        Assert.assertTrue(DFUtils.isCnpjValido("03918609000132"));
    }

    @Test
    public void isCPFValido() {
        Assert.assertFalse(DFUtils.isCpfValido(null));
        Assert.assertFalse(DFUtils.isCpfValido(""));
        Assert.assertFalse(DFUtils.isCpfValido("00000000000"));
        Assert.assertFalse(DFUtils.isCpfValido("11111111111"));
        Assert.assertFalse(DFUtils.isCpfValido("12345678909"));
        Assert.assertTrue(DFUtils.isCpfValido("38883975022"));
    }
}