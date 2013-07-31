package com.fincatto.nfe.v200.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.simpleframework.xml.transform.Transform;

public class DateFormatTransformer implements Transform<Date> {

	private DateFormat dateFormat;

	public DateFormatTransformer() {
		this(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()));
	}
	
	public DateFormatTransformer(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	@Override
	public Date read(String value) throws Exception {
		return dateFormat.parse(value);
	}

	@Override
	public String write(Date value) throws Exception {
		return dateFormat.format(value);
	}
}