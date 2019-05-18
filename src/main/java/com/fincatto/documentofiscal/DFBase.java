package com.fincatto.documentofiscal;

import com.fincatto.documentofiscal.persister.DFPersister;
import org.simpleframework.xml.core.Persister;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.TimeZone;

/**
 * Classe utilizada como base para objetos serializaveis.<br>
 * Automatiza a transformacao para xml no metodo toString.
 */
public abstract class DFBase implements Serializable {
    private static final long serialVersionUID = 6887612399839814676L;
    
    /**
     * Metodo que serializa o objeto para String.
     * Por padrao, usara o {@link DFPersister} com {@link TimeZone} padrao maquina.
     *
     * @return String serializada do objeto.
     * @see #toString(Persister) para definir um persiter diferente do padrao.
     */
    @Override
    public String toString() {
        final Persister persister = new DFPersister(TimeZone.getDefault());
        try (StringWriter writer = new StringWriter()) {
            persister.write(this, writer);
            return writer.toString();
        } catch (final Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
    
    /**
     * Metodo que serializa o objeto para String.
     *
     * @param persister Permister que utilizara para serializar os objetos. Recomendado o uso do {@link DFPersister}.
     * @return String serializada do objeto.
     */
    public String toString(final Persister persister) {
        try (StringWriter writer = new StringWriter()) {
            persister.write(this, writer);
            return writer.toString();
        } catch (final Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}