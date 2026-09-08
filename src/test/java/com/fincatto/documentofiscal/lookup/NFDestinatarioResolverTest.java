package com.fincatto.documentofiscal.lookup;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFIndicadorIEDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoDestinatario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFDestinatarioResolverTest {

    private static final String JSON_CPF_PACOTE_3 = "{\"status\":1,\"cpf\":\"000.000.000-00\",\"nome\":\"Test Token\",\"endereco\":\"Rua A\",\"numero\":\"100 B\",\"complemento\":\"Apto 03\",\"bairro\":\"Centro\",\"cep\":\"99999123\",\"cidade\":\"Sao Paulo\",\"uf\":\"SP\",\"ibge\":\"1234567\",\"pacoteUsado\":3}";

    private static final String JSON_CNPJ_PACOTE_5 = "{\"status\":1,\"cnpj\":\"11.222.333/0001-81\",\"razao\":\"TOKEN TEST LTDA\",\"matrizEndereco\":{\"cep\":\"39400123\",\"logradouro\":\"Avenida Central\",\"numero\":\"1000\",\"complemento\":\"Sala 1\",\"bairro\":\"Centro\",\"cidade\":\"Montes Claros\",\"uf\":\"MG\"},\"ibge\":{\"cidade\":{\"nome\":\"Montes Claros\",\"ibge_id\":3143302}},\"pacoteUsado\":5}";

    private NFDestinatarioResolver resolverCom(final String corpo) {
        return new NFDestinatarioResolver(new CpfCnpjComBrLookup("tok123", 3, 5, new TransporteFake(corpo)));
    }

    @Test
    public void devePreencherDestinatarioPorCpfComoNaoContribuinte() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverCom(JSON_CPF_PACOTE_3).porCpf("000.000.000-00");

        Assertions.assertEquals("00000000000", destinatario.getCpf());
        Assertions.assertNull(destinatario.getCnpj());
        Assertions.assertEquals("Test Token", destinatario.getRazaoSocial());
        Assertions.assertEquals(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE, destinatario.getIndicadorIEDestinatario());
        Assertions.assertNull(destinatario.getInscricaoEstadual());
        Assertions.assertNotNull(destinatario.getEndereco());
        Assertions.assertEquals("Rua A", destinatario.getEndereco().getLogradouro());
        Assertions.assertEquals("SP", destinatario.getEndereco().getUf());
        Assertions.assertEquals("99999123", destinatario.getEndereco().getCep());
        Assertions.assertEquals("1234567", destinatario.getEndereco().getCodigoMunicipio());
        Assertions.assertEquals("Sao Paulo", destinatario.getEndereco().getDescricaoMunicipio());
    }

    @Test
    public void devePreencherDestinatarioPorCnpjSemInscricaoEstadual() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverCom(JSON_CNPJ_PACOTE_5).porCnpj("11.222.333/0001-81");

        Assertions.assertEquals("11222333000181", destinatario.getCnpj());
        Assertions.assertNull(destinatario.getCpf());
        Assertions.assertEquals("TOKEN TEST LTDA", destinatario.getRazaoSocial());
        Assertions.assertNull(destinatario.getInscricaoEstadual());
        Assertions.assertEquals("MG", destinatario.getEndereco().getUf());
        Assertions.assertEquals("3143302", destinatario.getEndereco().getCodigoMunicipio());
    }

    @Test
    public void deveAplicarIndicadorInformadoNoCnpj() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverCom(JSON_CNPJ_PACOTE_5)
                .porCnpj("11222333000181", NFIndicadorIEDestinatario.CONTRIBUINTE_ICMS);

        Assertions.assertEquals(NFIndicadorIEDestinatario.CONTRIBUINTE_ICMS, destinatario.getIndicadorIEDestinatario());
        Assertions.assertNull(destinatario.getInscricaoEstadual());
    }

    @Test
    public void deveDetectarCnpjPorDocumento() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverCom(JSON_CNPJ_PACOTE_5).porDocumento("11.222.333/0001-81");
        Assertions.assertEquals("11222333000181", destinatario.getCnpj());
    }

    @Test
    public void deveDetectarCpfPorDocumento() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverCom(JSON_CPF_PACOTE_3).porDocumento("000.000.000-00");
        Assertions.assertEquals("00000000000", destinatario.getCpf());
    }

    @Test
    public void deveRecusarDocumentoComTamanhoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> resolverCom(JSON_CPF_PACOTE_3).porDocumento("123456"));
    }

    @Test
    public void deveGerarXmlCoerente() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverCom(JSON_CPF_PACOTE_3).porCpf("00000000000");
        final String xml = destinatario.toString();
        Assertions.assertTrue(xml.contains("<CPF>00000000000</CPF>"));
        Assertions.assertTrue(xml.contains("<cMun>1234567</cMun>"));
        Assertions.assertFalse(xml.contains("<IE>"));
    }

    @Test
    public void deveExigirLookup() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NFDestinatarioResolver(null));
    }
}
