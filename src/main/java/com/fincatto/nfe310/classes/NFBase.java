package com.fincatto.nfe310.classes;

import java.io.StringWriter;

import org.simpleframework.xml.core.Persister;

import com.fincatto.nfe310.persister.NFPersister;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;

public abstract class NFBase {

    @Override
    public String toString() {
        final Persister persister = new NFPersister();
        try (StringWriter writer = new StringWriter()) {
            persister.write(this, writer);
            return writer.toString();
        } catch (final Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public String marshaller() throws JAXBException {
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(this, stringWriter);
        return stringWriter.toString();
    }

}
