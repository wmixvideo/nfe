package com.fincatto.documentofiscal.lookup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFIndicadorIEDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoDestinatario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFDestinatarioResolverTest {

    private static final String JSON_CPF_PACOTE_3 = "{\"status\":1,\"cpf\":\"000.000.000-00\",\"nome\":\"Test Token\",\"endereco\":\"Rua A\",\"numero\":\"100 B\",\"complemento\":\"Apto 03\",\"bairro\":\"Centro\",\"cep\":\"99999123\",\"cidade\":\"Sao Paulo\",\"uf\":\"SP\",\"ibge\":\"1234567\",\"pacoteUsado\":3}";

    private static final String JSON_CNPJ_PACOTE_5 = "{\"status\":1,\"cnpj\":\"11.222.333/0001-81\",\"razao\":\"TOKEN TEST LTDA\",\"matrizEndereco\":{\"cep\":\"39400123\",\"logradouro\":\"Avenida Central\",\"numero\":\"1000\",\"complemento\":\"Sala 1\",\"bairro\":\"Centro\",\"cidade\":\"Montes Claros\",\"uf\":\"MG\"},\"ibge\":{\"cidade\":{\"nome\":\"Montes Claros\",\"ibge_id\":3143302}},\"pacoteUsado\":5}";

    private static final String JSON_IE_MG_ATIVA = "{\"status\":1,\"cnpj\":\"11222333000181\",\"inscricoesEstaduais\":[{\"inscricao_estadual\":\"0623079040081\",\"ativo\":true,\"estado\":{\"sigla\":\"MG\"}}],\"pacoteUsado\":16}";

    private static final String JSON_IE_MULTIPLAS_UF = "{\"status\":1,\"cnpj\":\"11222333000181\",\"inscricoesEstaduais\":[{\"inscricao_estadual\":\"103947736\",\"ativo\":true,\"estado\":{\"sigla\":\"GO\"}},{\"inscricao_estadual\":\"0623079040081\",\"ativo\":true,\"estado\":{\"sigla\":\"MG\"}},{\"inscricao_estadual\":\"290123456\",\"ativo\":false,\"estado\":{\"sigla\":\"SP\"}}],\"pacoteUsado\":16}";

    private static final String JSON_IE_MG_INATIVA = "{\"status\":1,\"cnpj\":\"11222333000181\",\"inscricoesEstaduais\":[{\"inscricao_estadual\":\"0623079040081\",\"ativo\":false,\"estado\":{\"sigla\":\"MG\"}}],\"pacoteUsado\":16}";

    private static final String JSON_IE_OUTRA_UF = "{\"status\":1,\"cnpj\":\"11222333000181\",\"inscricoesEstaduais\":[{\"inscricao_estadual\":\"103947736\",\"ativo\":true,\"estado\":{\"sigla\":\"GO\"}}],\"pacoteUsado\":16}";

    private static final String JSON_IE_VAZIA = "{\"status\":1,\"cnpj\":\"11222333000181\",\"inscricoesEstaduais\":[],\"pacoteUsado\":16}";

    private NFDestinatarioResolver resolverCom(final String corpo) {
        return new NFDestinatarioResolver(new CpfCnpjComBrLookup("tok123", 3, 5, new TransporteFake(corpo)));
    }

    private NFDestinatarioResolver resolverComIe(final String corpoIe) {
        final Map<Integer, String> corpos = new HashMap<>();
        corpos.put(5, JSON_CNPJ_PACOTE_5);
        corpos.put(16, corpoIe);
        return new NFDestinatarioResolver(new CpfCnpjComBrLookup("tok123", 3, 5, new TransporteFake(corpos)));
    }

    private static final class LookupSemInscricaoEstadual implements PessoaLookup {
        @Override
        public PessoaFiscal consultarCpf(final String cpf) {
            return new PessoaFiscal(PessoaFiscal.TipoPessoa.FISICA, "00000000000", "Fulano", null, null);
        }

        @Override
        public PessoaFiscal consultarCnpj(final String cnpj) {
            return new PessoaFiscal(PessoaFiscal.TipoPessoa.JURIDICA, "11222333000181", "Empresa", null, null);
        }
    }

    private static final class LookupComIe implements PessoaLookup, InscricaoEstadualLookup {
        private final List<InscricaoEstadual> inscricoes;

        LookupComIe(final InscricaoEstadual... inscricoes) {
            this.inscricoes = Arrays.asList(inscricoes);
        }

        @Override
        public PessoaFiscal consultarCpf(final String cpf) {
            return new PessoaFiscal(PessoaFiscal.TipoPessoa.FISICA, "00000000000", "Fulano", null, null);
        }

        @Override
        public PessoaFiscal consultarCnpj(final String cnpj) {
            final EnderecoFiscal endereco = new EnderecoFiscal("Rua X", "1", null, "Centro", "39400123", "Montes Claros", "MG", "3143302");
            return new PessoaFiscal(PessoaFiscal.TipoPessoa.JURIDICA, "11222333000181", "Empresa", null, endereco);
        }

        @Override
        public List<InscricaoEstadual> consultarInscricoesEstaduais(final String cnpj) {
            return this.inscricoes;
        }
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

    @Test
    public void devePreencherInscricaoEstadualAtivaDaUfComoContribuinte() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverComIe(JSON_IE_MG_ATIVA).porCnpjComInscricaoEstadual("11.222.333/0001-81");

        Assertions.assertEquals("11222333000181", destinatario.getCnpj());
        Assertions.assertEquals(NFIndicadorIEDestinatario.CONTRIBUINTE_ICMS, destinatario.getIndicadorIEDestinatario());
        Assertions.assertEquals("0623079040081", destinatario.getInscricaoEstadual());
        Assertions.assertEquals("MG", destinatario.getEndereco().getUf());
    }

    @Test
    public void deveEscolherAInscricaoDaUfDoEnderecoEntreVariasUf() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverComIe(JSON_IE_MULTIPLAS_UF).porCnpjComInscricaoEstadual("11222333000181");

        Assertions.assertEquals(NFIndicadorIEDestinatario.CONTRIBUINTE_ICMS, destinatario.getIndicadorIEDestinatario());
        Assertions.assertEquals("0623079040081", destinatario.getInscricaoEstadual());
    }

    @Test
    public void deveManterNaoContribuinteQuandoInscricaoDaUfEstaInativa() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverComIe(JSON_IE_MG_INATIVA).porCnpjComInscricaoEstadual("11222333000181");

        Assertions.assertEquals(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE, destinatario.getIndicadorIEDestinatario());
        Assertions.assertNull(destinatario.getInscricaoEstadual());
    }

    @Test
    public void deveManterNaoContribuinteQuandoNaoHaInscricaoParaAUfDoEndereco() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverComIe(JSON_IE_OUTRA_UF).porCnpjComInscricaoEstadual("11222333000181");

        Assertions.assertEquals(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE, destinatario.getIndicadorIEDestinatario());
        Assertions.assertNull(destinatario.getInscricaoEstadual());
    }

    @Test
    public void deveManterNaoContribuinteQuandoEmpresaNaoTemInscricaoEstadual() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverComIe(JSON_IE_VAZIA).porCnpjComInscricaoEstadual("11222333000181");

        Assertions.assertEquals(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE, destinatario.getIndicadorIEDestinatario());
        Assertions.assertNull(destinatario.getInscricaoEstadual());
    }

    @Test
    public void devePreencherInscricaoEstadualPorDocumentoQuandoCnpj() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverComIe(JSON_IE_MG_ATIVA).porDocumentoComInscricaoEstadual("11.222.333/0001-81");

        Assertions.assertEquals(NFIndicadorIEDestinatario.CONTRIBUINTE_ICMS, destinatario.getIndicadorIEDestinatario());
        Assertions.assertEquals("0623079040081", destinatario.getInscricaoEstadual());
    }

    @Test
    public void deveTratarCpfComoNaoContribuintePorDocumentoComInscricaoEstadual() throws PessoaLookupException {
        final NFNotaInfoDestinatario destinatario = resolverCom(JSON_CPF_PACOTE_3).porDocumentoComInscricaoEstadual("000.000.000-00");

        Assertions.assertEquals("00000000000", destinatario.getCpf());
        Assertions.assertEquals(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE, destinatario.getIndicadorIEDestinatario());
        Assertions.assertNull(destinatario.getInscricaoEstadual());
    }

    @Test
    public void deveFalharQuandoFonteNaoForneceInscricaoEstadual() {
        final NFDestinatarioResolver resolver = new NFDestinatarioResolver(new LookupSemInscricaoEstadual());
        Assertions.assertThrows(IllegalStateException.class, () -> resolver.porCnpjComInscricaoEstadual("11222333000181"));
    }

    @Test
    public void deveIgnorarInscricaoAtivaComFormatoForaDoSchemaSemLancar() throws PessoaLookupException {
        final NFDestinatarioResolver resolver = new NFDestinatarioResolver(
                new LookupComIe(new InscricaoEstadual("ISENTO", "MG", true), new InscricaoEstadual(" 12A ", "MG", true)));

        final NFNotaInfoDestinatario destinatario = resolver.porCnpjComInscricaoEstadual("11222333000181");

        Assertions.assertEquals(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE, destinatario.getIndicadorIEDestinatario());
        Assertions.assertNull(destinatario.getInscricaoEstadual());
    }

    @Test
    public void deveNormalizarEspacosDaInscricaoAntesDeGravar() throws PessoaLookupException {
        final NFDestinatarioResolver resolver = new NFDestinatarioResolver(
                new LookupComIe(new InscricaoEstadual(" 0623079040081 ", "MG", true)));

        final NFNotaInfoDestinatario destinatario = resolver.porCnpjComInscricaoEstadual("11222333000181");

        Assertions.assertEquals(NFIndicadorIEDestinatario.CONTRIBUINTE_ICMS, destinatario.getIndicadorIEDestinatario());
        Assertions.assertEquals("0623079040081", destinatario.getInscricaoEstadual());
    }

    @Test
    public void deveEscolherAPrimeiraInscricaoAtivaQuandoHaVariasNaMesmaUf() throws PessoaLookupException {
        final NFDestinatarioResolver resolver = new NFDestinatarioResolver(
                new LookupComIe(new InscricaoEstadual("1112223334", "MG", true), new InscricaoEstadual("9998887776", "MG", true)));

        final NFNotaInfoDestinatario destinatario = resolver.porCnpjComInscricaoEstadual("11222333000181");

        Assertions.assertEquals("1112223334", destinatario.getInscricaoEstadual());
    }
}
