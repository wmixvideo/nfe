package com.fincatto.nfe200.validadores.xsd;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

class ErroHandler implements ErrorHandler {
    final private List<String> warnings;
    final private List<String> errors;
    final private List<String> fatals;

    public ErroHandler() {
        this.warnings = new ArrayList<>();
        this.errors = new ArrayList<>();
        this.fatals = new ArrayList<String>();
    }

    @Override
    public void warning(final SAXParseException exception) throws SAXException {
        this.warnings.add(exception.getMessage());
    }

    @Override
    public void error(final SAXParseException exception) throws SAXException {
        this.errors.add(exception.getMessage());
    }

    @Override
    public void fatalError(final SAXParseException exception) throws SAXException {
        this.fatals.add(exception.getMessage());
    }

    public String getMensagemComErros() {
        final StringBuilder inconsistencias = new StringBuilder("\nHouve problemas na validacao do XML\n\n");

        if (!this.fatals.isEmpty()) {
            inconsistencias.append(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<\n");
            inconsistencias.append(MessageFormat.format(">>>> Contem {0} erros fatais, segue a lista:\n", this.fatals.size()));
            inconsistencias.append(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<\n");
            for (final String fatal : this.fatals) {
                this.errors.add(MessageFormat.format("{0}\n", fatal));
            }
        }

        if (!this.errors.isEmpty()) {
            inconsistencias.append(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<\n");
            inconsistencias.append(MessageFormat.format(">>>> Contem {0} erros, segue a lista:\n", this.errors.size()));
            inconsistencias.append(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<\n");
            for (final String error : this.errors) {
                inconsistencias.append(MessageFormat.format("{0}\n", error));
            }
        }

        if (!this.warnings.isEmpty()) {
            inconsistencias.append(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<\n");
            inconsistencias.append(MessageFormat.format(">>>> Contem {0} warnings, segue a lista:\n", this.warnings.size()));
            inconsistencias.append(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<\n");
            for (final String warning : this.warnings) {
                inconsistencias.append(MessageFormat.format("{0}\n", warning));
            }
        }
        return inconsistencias.toString();
    }
}