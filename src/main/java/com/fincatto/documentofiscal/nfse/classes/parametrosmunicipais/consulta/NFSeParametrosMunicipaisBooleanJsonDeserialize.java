package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * Deserializador customizado para converter valores "1" em true e qualquer outro valor em false.
 */
class NFSeParametrosMunicipaisBooleanJsonDeserialize extends JsonDeserializer<Boolean> {

    private static final List<String> VERDADEIROS = List.of("1", "true", "sim", "s");
    private static final List<String> FALSOS = List.of("0", "false", "nao", "não", "n");

    @Override
    public Boolean deserialize(final JsonParser p, final DeserializationContext dc) throws IOException {
        final var valorSanitizado = StringUtils.trimToEmpty(p.getText());
        for (String verdadeiro : VERDADEIROS) {
            if (verdadeiro.equalsIgnoreCase(valorSanitizado)) {
                return true;
            }
        }
        for (String falso : FALSOS) {
            if (falso.equalsIgnoreCase(valorSanitizado)) {
                return false;
            }
        }
        throw new IOException(String.format("Valor booleano desconhecido: '%s'", valorSanitizado));
    }
}
