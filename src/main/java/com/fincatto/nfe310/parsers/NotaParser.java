package com.fincatto.nfe310.parsers;

import java.io.File;

import org.simpleframework.xml.core.Persister;

import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import com.fincatto.nfe310.validadores.xsd.XMLValidador;

public class NotaParser {
    private final Persister persister;

    public NotaParser() {
        this.persister = new Persister(new NFRegistryMatcher());
    }

    public NFNota paraObjeto(final File xml) {
        try {
            final NFNota nota = this.persister.read(NFNota.class, xml);
            XMLValidador.validaNota(nota.toString());
            return nota;
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }

    }

    public NFNota paraObjeto(final String xml) {
        try {
            final NFNota nota = this.persister.read(NFNota.class, xml);
            XMLValidador.validaNota(nota.toString());
            return nota;
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }
}