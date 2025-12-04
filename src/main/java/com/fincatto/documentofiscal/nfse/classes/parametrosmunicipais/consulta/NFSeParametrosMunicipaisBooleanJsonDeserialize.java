package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Deserializador customizado para converter valores "1" em true e qualquer outro valor em false.
 */
class NFSeParametrosMunicipaisBooleanJsonDeserialize extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(final JsonParser p, final DeserializationContext dc) throws IOException {
        return "1".equals(p.getText()) || "true".equalsIgnoreCase(p.getText());
    }
}
