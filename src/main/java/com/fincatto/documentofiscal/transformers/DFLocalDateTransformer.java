package com.fincatto.documentofiscal.transformers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.simpleframework.xml.transform.Transform;

public class DFLocalDateTransformer implements Transform<LocalDate> {

	private static final DateTimeFormatter DATATIME_FORMATTER_YYYYMMDDXXX = DateTimeFormatter.ofPattern("yyyy-MM-ddXXX");
	private static final DateTimeFormatter DATETIME_FORMATTER_YYYYMMDD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final DateTimeFormatter DATETIME_FORMATTER_DDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter DATETIME_FORMATTER_DDMMYYYHHMMSS = DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm:ss");

	@Override
	public LocalDate read(final String data) {
		try {
			return LocalDate.parse(data, DFLocalDateTransformer.DATETIME_FORMATTER_YYYYMMDD);
		} catch (final Exception e) {
			try {
				return LocalDate.from(DFLocalDateTransformer.DATATIME_FORMATTER_YYYYMMDDXXX.parse(data));
			} catch (final Exception e2) {
				try {
					return LocalDate.from(DFLocalDateTransformer.DATETIME_FORMATTER_DDMMYYYY.parse(data));
				} catch (final Exception e3) {
					return LocalDate.from(DFLocalDateTransformer.DATETIME_FORMATTER_DDMMYYYHHMMSS.parse(data));
				}
			}
		}
	}

	@Override
	public String write(final LocalDate data) {
		return DFLocalDateTransformer.DATETIME_FORMATTER_YYYYMMDD.format(data);
	}
}