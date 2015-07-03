package com.fincatto.nfe310.parsers;

import java.io.File;

import org.simpleframework.xml.core.Persister;

import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.classes.nota.NFNotaProcessada;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;

public class NotaParser {
    private final Persister persister;

    public NotaParser() {
        this.persister = new Persister(new NFRegistryMatcher());
    }

    public NFNota notaParaObjeto(final File xml) {
        try {
            return this.persister.read(NFNota.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFNota notaParaObjeto(final String xml) {
        try {
            return this.persister.read(NFNota.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFNotaProcessada notaProcessadaParaObjeto(final String xml) {
        try {
            return this.persister.read(NFNotaProcessada.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFNotaProcessada notaProcessadaParaObjeto(final File xml) {
        try {
            return this.persister.read(NFNotaProcessada.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }
}