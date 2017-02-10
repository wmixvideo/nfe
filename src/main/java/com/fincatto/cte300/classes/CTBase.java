package com.fincatto.cte300.classes;

import java.io.StringWriter;

import org.simpleframework.xml.core.Persister;

import com.fincatto.cte300.persister.CTPersister;

public abstract class CTBase {

    @Override
    public String toString() {
        final Persister persister = new CTPersister();
        try (StringWriter writer = new StringWriter()) {
            persister.write(this, writer);
            return writer.toString();
        } catch (final Exception e) {
        	throw new IllegalStateException(e.getMessage(), e);
        }
    }
}