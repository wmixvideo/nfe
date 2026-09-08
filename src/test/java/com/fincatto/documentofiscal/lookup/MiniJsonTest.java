package com.fincatto.documentofiscal.lookup;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MiniJsonTest {

    @Test
    @SuppressWarnings("unchecked")
    public void deveInterpretarObjetoSimples() {
        final Object resultado = MiniJson.parse("{\"status\":1,\"nome\":\"Test Token\"}");
        Assertions.assertTrue(resultado instanceof Map);
        final Map<String, Object> mapa = (Map<String, Object>) resultado;
        Assertions.assertEquals(1L, mapa.get("status"));
        Assertions.assertEquals("Test Token", mapa.get("nome"));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void deveInterpretarObjetoAninhado() {
        final String json = "{\"ibge\":{\"cidade\":{\"nome\":\"Montes Claros\",\"ibge_id\":3143302}}}";
        final Map<String, Object> mapa = (Map<String, Object>) MiniJson.parse(json);
        final Map<String, Object> ibge = (Map<String, Object>) mapa.get("ibge");
        final Map<String, Object> cidade = (Map<String, Object>) ibge.get("cidade");
        Assertions.assertEquals("Montes Claros", cidade.get("nome"));
        Assertions.assertEquals(3143302L, cidade.get("ibge_id"));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void deveDecodificarEscapeUnicode() {
        final Map<String, Object> mapa = (Map<String, Object>) MiniJson.parse("{\"erro\":\"CNPJ inv\\u00e1lido!\"}");
        Assertions.assertEquals("CNPJ inválido!", mapa.get("erro"));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void deveInterpretarListaValoresEValoresNulos() {
        final String json = "{\"telefones\":[{\"ddd\":\"11\"}],\"razao\":null,\"delay\":0.3}";
        final Map<String, Object> mapa = (Map<String, Object>) MiniJson.parse(json);
        Assertions.assertTrue(mapa.get("telefones") instanceof List);
        Assertions.assertEquals(1, ((List<Object>) mapa.get("telefones")).size());
        Assertions.assertNull(mapa.get("razao"));
        Assertions.assertEquals(0.3d, (Double) mapa.get("delay"), 0.0001d);
    }

    @Test
    public void deveRecusarJsonInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MiniJson.parse("{\"status\":"));
    }
}
