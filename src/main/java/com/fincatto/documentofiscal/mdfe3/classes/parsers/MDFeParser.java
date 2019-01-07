package com.fincatto.documentofiscal.mdfe3.classes.parsers;

import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLote;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFProcessado;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFe;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.MDFeEvento;
import com.fincatto.documentofiscal.persister.DFPersister;
import java.io.File;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author Edivaldo Merlo Stens on 06/10/2018
 */
public class MDFeParser {

    private final Persister persister;

    public MDFeParser() {
        this.persister = new DFPersister();
    }

    /**
     * Transforma arquivo XML (tag: MDFe) para objeto (MDFe)
     *
     * @param xml
     * @return
     */
    public MDFe mdfeParaObjeto(final File xml) {
        try {
            return this.persister.read(MDFe.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    /**
     * Transforma string XML (tag: MDFe) para objeto (MDFe)
     *
     * @param xml
     * @return
     */
    public MDFe mdfeParaObjeto(final String xml) {
        try {
            return this.persister.read(MDFe.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    /**
     * Transforma string XML (tag: enviMDFe) para objeto (MDFEnvioLote)
     *
     * @param xml
     * @return
     */
    public MDFEnvioLote mdfeRecepcaoParaObjeto(final String xml) {
        try {
            return this.persister.read(MDFEnvioLote.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml do Lote MDFe: %s", e.getMessage()));
        }
    }

    /**
     * Transforma string XML (tag: mdfeProc) para objeto (MDFProcessado)
     *
     * @param xml
     * @return
     */
    public MDFProcessado mdfeProcessadoParaObjeto(final String xml) {
        try {
            return this.persister.read(MDFProcessado.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    /**
     * Transforma arquivo XML (tag: mdfeProc) para objeto (MDFProcessado)
     *
     * @param xml
     * @return
     */
    public MDFProcessado mdfeProcessadoParaObjeto(final File xml) {
        try {
            return this.persister.read(MDFProcessado.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    /**
     * Transforma string XML (tag: eventoMDFe) para objeto (MDFeEvento)
     *
     * @param xml
     * @return
     */
    public MDFeEvento mdfeEventoParaObjeto(final String xml) {
        try {
            return this.persister.read(MDFeEvento.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    /**
     * Transforma arquivo XML (tag: eventoMDFe) para objeto (MDFeEvento)
     *
     * @param xml
     * @return
     */
    public MDFeEvento mdfeEventoParaObjeto(final File xml) {
        try {
            return this.persister.read(MDFeEvento.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }
}
