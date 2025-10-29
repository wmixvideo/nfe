package com.fincatto.documentofiscal.nfse.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.math.BigDecimal;

public class NFSeObjectMapper extends ObjectMapper {
    public NFSeObjectMapper() {
        super();
        this.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        this.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        this.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        this.registerModule(new JavaTimeModule());
        this.registerModule(new SimpleModule().addDeserializer(BigDecimal.class, new StdScalarDeserializer<>(BigDecimal.class) {
            @Override
            public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                return new BigDecimal(p.getValueAsString().replace(',', '.'));
            }
        }));
    }
}
