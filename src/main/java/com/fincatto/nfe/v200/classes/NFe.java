package com.fincatto.nfe.v200.classes;

import java.io.StringWriter;
import java.util.Date;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.transform.RegistryMatcher;

public abstract class NFe {
	@Override
	public String toString() {
		final RegistryMatcher registryMatcher = new RegistryMatcher();
		registryMatcher.bind(Date.class, new DateFormatTransformer());
		
		final Persister persister = new Persister(registryMatcher, new Format(0));
		try (StringWriter writer = new StringWriter()) {
			persister.write(this, writer);
			return writer.toString();
		} catch (final Exception ex) {
			return ex.getMessage();
		}
	}
}
