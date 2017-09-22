package com.fincatto.documentofiscal;

import java.io.StringWriter;

import org.simpleframework.xml.core.Persister;

import com.fincatto.documentofiscal.nfe310.persister.NFPersister;

/**
 * Classe utilizada como base para objetos serializaveis.<br>
 * Automatiza a transformacao para xml no metodo toString.
 */
public abstract class DFBase {

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
}