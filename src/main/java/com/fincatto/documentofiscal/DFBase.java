package com.fincatto.documentofiscal;

import com.fincatto.documentofiscal.utils.DFPersister;
import org.simpleframework.xml.core.Persister;

import java.io.Serializable;
import java.io.StringWriter;

/**
 * Classe utilizada como base para objetos serializaveis.<br>
 * Automatiza a transformacao para xml no metodo toString.
 */
public abstract class DFBase implements Serializable {
    private static final long serialVersionUID = 6887612399839814676L;
    private static final Persister PERSISTER = new DFPersister();

    /**
     * Metodo que serializa o objeto para String.
     * Por padrao, usara o {@link DFPersister}.
     *
     * @return String serializada do objeto.
     */
    @Override
    public String toString() {
        try (StringWriter writer = new StringWriter()) {
            PERSISTER.write(this, writer);
            return writer.toString();
        } catch (final Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}