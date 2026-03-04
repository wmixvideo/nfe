package com.fincatto.documentofiscal.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class DFYearMonthTransformer implements Transform<YearMonth> {

    private static final DateTimeFormatter DATATIME_FORMATTER_YYYYMMDDXXX = DateTimeFormatter.ofPattern("yyyy-MM-ddXXX");
    private static final DateTimeFormatter DATATIME_FORMATTER_YYYYMMDDHHMMSSXXXX = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXXXX");
    private static final DateTimeFormatter DATETIME_FORMATTER_YYYYMMDD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATETIME_FORMATTER_YYYYMM = DateTimeFormatter.ofPattern("yyyy-MM");
    private static final DateTimeFormatter DATETIME_FORMATTER_DDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATETIME_FORMATTER_DDMMYYYHHMMSS = DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm:ss");

    @Override
    public YearMonth read(final String data) {
        try {
            return YearMonth.parse(data, DFYearMonthTransformer.DATETIME_FORMATTER_YYYYMMDD);
        } catch (final Exception e) {
            try {
                return YearMonth.from(DFYearMonthTransformer.DATATIME_FORMATTER_YYYYMMDDXXX.parse(data));
            } catch (final Exception e2) {
                try {
                    return YearMonth.from(DFYearMonthTransformer.DATETIME_FORMATTER_DDMMYYYY.parse(data));
                } catch (final Exception e3) {
                    try {
                        return YearMonth.from(DFYearMonthTransformer.DATETIME_FORMATTER_DDMMYYYHHMMSS.parse(data));
                    } catch (final Exception e4) {
                        try {
                            return YearMonth.from(DFYearMonthTransformer.DATATIME_FORMATTER_YYYYMMDDHHMMSSXXXX.parse(data));
                        } catch (final Exception e5) {
                            return YearMonth.parse(data, DFYearMonthTransformer.DATETIME_FORMATTER_YYYYMM);
                        }
                    }
                }
            }
        }
    }

    @Override
    public String write(final YearMonth data) {
        return DFYearMonthTransformer.DATETIME_FORMATTER_YYYYMM.format(data);
    }
}