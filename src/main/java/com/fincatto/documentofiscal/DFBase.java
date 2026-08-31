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

    /**
     * Instancia unica e thread-safe do persister padrao: construir um {@link DFPersister} monta o
     * registro completo de transformers (~centenas de binds), o que e caro demais para refazer a
     * cada chamada de {@code toString()} - que roda em log e no caminho de assinatura/envio.
     * Holder idiom para inicializacao lazy sem sincronizacao explicita.
     */
    private static final class PersisterHolder {
        private static final Persister INSTANCE = new DFPersister();
    }

    /**
     * Metodo que serializa o objeto para String.
     * Por padrao, usara o {@link DFPersister}.
     *
     * @return String serializada do objeto.
     */
    @Override
    public String toString() {
        try (StringWriter writer = new StringWriter()) {
            DFBase.PersisterHolder.INSTANCE.write(this, writer);
            return writer.toString();
        } catch (final Exception e) {
            throw new IllegalStateException("Falha ao serializar " + this.getClass().getName() + " para XML", e);
        }
    }
}