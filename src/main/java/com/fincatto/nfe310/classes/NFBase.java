package com.fincatto.nfe310.classes;

import java.io.StringWriter;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe310.transformers.NFRegistryMatcher;

public abstract class NFBase {

	private static final NFRegistryMatcher NF_REGISTRY_MATCHER = new NFRegistryMatcher();
	private static final Format FORMAT = new Format(0);

	@Override
	public String toString() {
		final Persister persister = new Persister(NFBase.NF_REGISTRY_MATCHER, NFBase.FORMAT);
		try (StringWriter writer = new StringWriter()) {
			persister.write(this, writer);
			return writer.toString();
		} catch (final Exception e) {
			throw new IllegalStateException(e.getMessage());
		}
	}
}