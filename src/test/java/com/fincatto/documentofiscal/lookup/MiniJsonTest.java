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
    @SuppressWarnings("unchecked")
    public void deveInterpretarArrayDeObjetosComObjetoAninhado() {
        final String json = "{\"inscricoesEstaduais\":["
                + "{\"inscricao_estadual\":\"103947736\",\"ativo\":true,\"estado\":{\"id\":9,\"nome\":\"Goias\",\"sigla\":\"GO\",\"ibge_id\":52}},"
                + "{\"inscricao_estadual\":\"290123456\",\"ativo\":false,\"estado\":{\"id\":25,\"nome\":\"Sao Paulo\",\"sigla\":\"SP\",\"ibge_id\":35}}"
                + "]}";
        final Map<String, Object> mapa = (Map<String, Object>) MiniJson.parse(json);
        final List<Object> inscricoes = (List<Object>) mapa.get("inscricoesEstaduais");
        Assertions.assertEquals(2, inscricoes.size());

        final Map<String, Object> primeira = (Map<String, Object>) inscricoes.get(0);
        Assertions.assertEquals("103947736", primeira.get("inscricao_estadual"));
        Assertions.assertEquals(Boolean.TRUE, primeira.get("ativo"));
        final Map<String, Object> estadoPrimeira = (Map<String, Object>) primeira.get("estado");
        Assertions.assertEquals("GO", estadoPrimeira.get("sigla"));
        Assertions.assertEquals(52L, estadoPrimeira.get("ibge_id"));

        final Map<String, Object> segunda = (Map<String, Object>) inscricoes.get(1);
        Assertions.assertEquals(Boolean.FALSE, segunda.get("ativo"));
        Assertions.assertEquals("SP", ((Map<String, Object>) segunda.get("estado")).get("sigla"));
    }

    @Test
    public void deveRecusarJsonInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MiniJson.parse("{\"status\":"));
    }

    @Test
    public void deveRecusarAninhamentoProfundoSemEstourarPilha() {
        final StringBuilder profundo = new StringBuilder();
        for (int i = 0; i < 5000; i++) {
            profundo.append('[');
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> MiniJson.parse(profundo.toString()));
    }
}
