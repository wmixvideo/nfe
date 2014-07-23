package com.fincatto.nfe.transformers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.simpleframework.xml.transform.Transform;

class BigDecimalTransformer implements Transform<BigDecimal> {

    @Override
    public BigDecimal read(final String valor) throws Exception {
        return new BigDecimal(valor);
    }

    @Override
    public String write(final BigDecimal valor) throws Exception {
        return new DecimalFormat("#0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(valor);
    }
}