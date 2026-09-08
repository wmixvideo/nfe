package com.fincatto.documentofiscal.lookup;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CpfCnpjComBrLookupTest {

    private static final String JSON_CPF_PACOTE_3 = "{\"status\":1,\"cpf\":\"000.000.000-00\",\"nome\":\"Test Token\",\"nascimento\":\"31/12/1900\",\"endereco\":\"Rua A\",\"numero\":\"100 B\",\"complemento\":\"Apto 03\",\"bairro\":\"Centro\",\"cep\":\"99999123\",\"cidade\":\"Sao Paulo\",\"uf\":\"SP\",\"ibge\":\"1234567\",\"genero\":\"M\",\"pacoteUsado\":3,\"saldo\":123}";

    private static final String JSON_CNPJ_PACOTE_5 = "{\"status\":1,\"cnpj\":\"11.222.333/0001-81\",\"tipo\":\"Matriz\",\"razao\":\"TOKEN TEST LTDA\",\"fantasia\":\"TOKEN TEST\",\"matrizEndereco\":{\"cep\":\"39400123\",\"tipo\":\"Rua\",\"logradouro\":\"Avenida Central\",\"numero\":\"1000\",\"complemento\":\"Sala 1\",\"bairro\":\"Centro\",\"cidade\":\"Montes Claros\",\"uf\":\"MG\"},\"ibge\":{\"pais\":{\"id\":\"1058\"},\"estado\":{\"id\":11,\"ibge_id\":31},\"cidade\":{\"id\":2745,\"nome\":\"Montes Claros\",\"ibge_id\":3143302}},\"pacoteUsado\":5,\"saldo\":123}";

    private static final String JSON_ERRO = "{\"status\":0,\"razao\":null,\"erro\":\"CNPJ inv\\u00e1lido!\",\"pacoteUsado\":5,\"erroCodigo\":200}";

    @Test
    public void deveConsultarCpfEnormalizarDocumentoEEndereco() throws PessoaLookupException {
        final TransporteFake transporte = new TransporteFake(JSON_CPF_PACOTE_3);
        final CpfCnpjComBrLookup lookup = new CpfCnpjComBrLookup("tok123", 3, 5, transporte);

        final PessoaFiscal pessoa = lookup.consultarCpf("000.000.000-00");

        Assertions.assertEquals(PessoaFiscal.TipoPessoa.FISICA, pessoa.getTipo());
        Assertions.assertEquals("00000000000", pessoa.getDocumento());
        Assertions.assertEquals("Test Token", pessoa.getNome());
        Assertions.assertNotNull(pessoa.getEndereco());
        Assertions.assertEquals("Rua A", pessoa.getEndereco().getLogradouro());
        Assertions.assertEquals("100 B", pessoa.getEndereco().getNumero());
        Assertions.assertEquals("Centro", pessoa.getEndereco().getBairro());
        Assertions.assertEquals("99999123", pessoa.getEndereco().getCep());
        Assertions.assertEquals("Sao Paulo", pessoa.getEndereco().getCidade());
        Assertions.assertEquals("SP", pessoa.getEndereco().getUf());
        Assertions.assertEquals("1234567", pessoa.getEndereco().getCodigoMunicipio());
    }

    @Test
    public void deveMontarUrlComTokenPacoteEDocumentoSemMascara() throws PessoaLookupException {
        final TransporteFake transporte = new TransporteFake(JSON_CPF_PACOTE_3);
        final CpfCnpjComBrLookup lookup = new CpfCnpjComBrLookup("tok123", 3, 5, transporte);

        lookup.consultarCpf("000.000.000-00");

        Assertions.assertEquals("https://api.cpfcnpj.com.br/tok123/3/00000000000", transporte.getUltimaUrl());
    }

    @Test
    public void deveConsultarCnpjEExtrairCodigoMunicipioDoIbge() throws PessoaLookupException {
        final TransporteFake transporte = new TransporteFake(JSON_CNPJ_PACOTE_5);
        final CpfCnpjComBrLookup lookup = new CpfCnpjComBrLookup("tok123", 3, 5, transporte);

        final PessoaFiscal pessoa = lookup.consultarCnpj("11.222.333/0001-81");

        Assertions.assertEquals(PessoaFiscal.TipoPessoa.JURIDICA, pessoa.getTipo());
        Assertions.assertEquals("11222333000181", pessoa.getDocumento());
        Assertions.assertEquals("TOKEN TEST LTDA", pessoa.getNome());
        Assertions.assertNotNull(pessoa.getEndereco());
        Assertions.assertEquals("Avenida Central", pessoa.getEndereco().getLogradouro());
        Assertions.assertEquals("39400123", pessoa.getEndereco().getCep());
        Assertions.assertEquals("Montes Claros", pessoa.getEndereco().getCidade());
        Assertions.assertEquals("MG", pessoa.getEndereco().getUf());
        Assertions.assertEquals("3143302", pessoa.getEndereco().getCodigoMunicipio());
    }

    @Test
    public void deveLancarExcecaoQuandoStatusForZero() {
        final TransporteFake transporte = new TransporteFake(JSON_ERRO);
        final CpfCnpjComBrLookup lookup = new CpfCnpjComBrLookup("tok123", 3, 5, transporte);

        final PessoaLookupException excecao = Assertions.assertThrows(PessoaLookupException.class,
                () -> lookup.consultarCnpj("11222333000181"));
        Assertions.assertTrue(excecao.getMessage().contains("CNPJ inválido!"));
    }

    @Test
    public void deveLancarExcecaoQuandoTransporteFalha() {
        final TransporteFake transporte = new TransporteFake(new IOException("timeout"));
        final CpfCnpjComBrLookup lookup = new CpfCnpjComBrLookup("tok123", 3, 5, transporte);

        Assertions.assertThrows(PessoaLookupException.class, () -> lookup.consultarCpf("00000000000"));
    }

    @Test
    public void deveRecusarCpfComTamanhoInvalido() {
        final CpfCnpjComBrLookup lookup = new CpfCnpjComBrLookup("tok123", 3, 5, new TransporteFake(JSON_CPF_PACOTE_3));
        Assertions.assertThrows(PessoaLookupException.class, () -> lookup.consultarCpf("123"));
    }

    @Test
    public void deveExigirToken() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CpfCnpjComBrLookup("  "));
    }

    @Test
    public void deveRejeitarTokenComCaractereInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CpfCnpjComBrLookup("tok 123", 3, 5, new TransporteFake(JSON_CPF_PACOTE_3)));
    }

    @Test
    public void deveFormatarNumeroInteiroSemPontoDecimal() throws PessoaLookupException {
        final String jsonNumeroFloat = "{\"status\":1,\"nome\":\"Test Token\",\"endereco\":\"Rua A\",\"numero\":85.0,\"cep\":\"99999123\",\"cidade\":\"Sao Paulo\",\"uf\":\"SP\",\"ibge\":\"1234567\"}";
        final CpfCnpjComBrLookup lookup = new CpfCnpjComBrLookup("tok123", 3, 5, new TransporteFake(jsonNumeroFloat));

        final PessoaFiscal pessoa = lookup.consultarCpf("00000000000");

        Assertions.assertEquals("85", pessoa.getEndereco().getNumero());
    }
}
