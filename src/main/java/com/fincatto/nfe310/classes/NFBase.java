package com.fincatto.nfe310.classes;

import java.io.StringWriter;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe310.transformers.NFRegistryMatcher;

public abstract class NFBase {

    @Override
    public String toString() {
        final Persister persister = new Persister(new NFRegistryMatcher(), new Format(0));
        try (StringWriter writer = new StringWriter()) {
            persister.write(this, writer);
            return writer.toString();
        } catch (final Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}