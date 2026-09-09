package com.fincatto.documentofiscal.lookup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Implementação de referência de {@link PessoaLookup} sobre a API pública cpfcnpj.com.br.
 *
 * <p>A consulta segue o formato {@code GET https://api.cpfcnpj.com.br/{token}/{pacote}/{documento}},
 * onde {@code documento} vai apenas com os caracteres válidos. Por padrão usa o pacote 3
 * para CPF (nome mais endereço) e o pacote 5 para CNPJ (razão social, endereço da matriz e
 * código IBGE do município). Os pacotes podem ser trocados no construtor, por exemplo para
 * o pacote 6 de CNPJ, que traz os mesmos campos do 5 acrescidos de dados do Simples Nacional.</p>
 *
 * <p>Esta classe é aditiva e opcional: nada no restante do SDK depende dela. O token é obtido
 * no painel da conta, em API, aba Tokens. Para experimentar sem custo existe um token público
 * de testes que devolve dados fictícios. A documentação da API, com a lista de pacotes e a
 * geração do token, está em <a href="https://www.cpfcnpj.com.br/dev/">cpfcnpj.com.br/dev</a>.</p>
 *
 * <p><strong>Inscrição Estadual:</strong> os pacotes de endereço (3, 5 e 6) não trazem IE.
 * Para o B2B entre contribuintes existe {@link #consultarInscricoesEstaduais(String)}, que
 * usa o pacote CNPJ H (identificador 16) e devolve a lista de Inscrições Estaduais da empresa
 * (uma por unidade federativa, com a marca de ativa ou não). A montagem do destinatário com a
 * IE está na {@link NFDestinatarioResolver}: quando não há IE ativa, o destinatário segue como
 * {@code indIEDest=9} (NFC-e e venda a consumidor final); havendo IE ativa para a UF do endereço,
 * ele vira contribuinte de ICMS ({@code indIEDest=1}). A IM continua fora do escopo desta fonte.</p>
 */
public class CpfCnpjComBrLookup implements PessoaLookup, InscricaoEstadualLookup {

    private static final String BASE_URL = "https://api.cpfcnpj.com.br";
    private static final int PACOTE_CPF_PADRAO = 3;
    private static final int PACOTE_CNPJ_PADRAO = 5;
    private static final int PACOTE_IE_PADRAO = 16;
    private static final Pattern TOKEN_SEGURO = Pattern.compile("[A-Za-z0-9._~-]+");

    private final String token;
    private final int pacoteCpf;
    private final int pacoteCnpj;
    private final int pacoteIe;
    private final HttpTransport transporte;

    /**
     * Cria a consulta com os pacotes padrão (3 para CPF, 5 para CNPJ) e o transporte HTTP
     * da JDK.
     *
     * @param token token de acesso obtido no painel da conta.
     */
    public CpfCnpjComBrLookup(final String token) {
        this(token, PACOTE_CPF_PADRAO, PACOTE_CNPJ_PADRAO);
    }

    /**
     * Cria a consulta escolhendo os pacotes e usando o transporte HTTP da JDK.
     *
     * @param token      token de acesso.
     * @param pacoteCpf  identificador do pacote a usar em consultas de CPF.
     * @param pacoteCnpj identificador do pacote a usar em consultas de CNPJ.
     */
    public CpfCnpjComBrLookup(final String token, final int pacoteCpf, final int pacoteCnpj) {
        this(token, pacoteCpf, pacoteCnpj, new JdkHttpTransport());
    }

    /**
     * Cria a consulta com um transporte HTTP próprio, usando o pacote 16 para Inscrição
     * Estadual. Útil para reaproveitar o httpclient5 do projeto ou para testes com respostas
     * simuladas.
     *
     * @param token      token de acesso.
     * @param pacoteCpf  identificador do pacote a usar em consultas de CPF.
     * @param pacoteCnpj identificador do pacote a usar em consultas de CNPJ.
     * @param transporte transporte HTTP a utilizar.
     */
    public CpfCnpjComBrLookup(final String token, final int pacoteCpf, final int pacoteCnpj, final HttpTransport transporte) {
        this(token, pacoteCpf, pacoteCnpj, PACOTE_IE_PADRAO, transporte);
    }

    /**
     * Cria a consulta escolhendo todos os pacotes, inclusive o de Inscrição Estadual, e um
     * transporte HTTP próprio.
     *
     * @param token      token de acesso.
     * @param pacoteCpf  identificador do pacote a usar em consultas de CPF.
     * @param pacoteCnpj identificador do pacote a usar em consultas de CNPJ.
     * @param pacoteIe   identificador do pacote a usar em consultas de Inscrição Estadual (padrão 16).
     * @param transporte transporte HTTP a utilizar.
     */
    public CpfCnpjComBrLookup(final String token, final int pacoteCpf, final int pacoteCnpj, final int pacoteIe, final HttpTransport transporte) {
        if (!Documentos.preenchido(token)) {
            throw new IllegalArgumentException("Token de acesso obrigatório");
        }
        if (transporte == null) {
            throw new IllegalArgumentException("Transporte HTTP obrigatório");
        }
        final String tokenLimpo = token.trim();
        if (!TOKEN_SEGURO.matcher(tokenLimpo).matches()) {
            throw new IllegalArgumentException("Token de acesso contém caracteres inválidos para a URL");
        }
        this.token = tokenLimpo;
        this.pacoteCpf = pacoteCpf;
        this.pacoteCnpj = pacoteCnpj;
        this.pacoteIe = pacoteIe;
        this.transporte = transporte;
    }

    @Override
    public PessoaFiscal consultarCpf(final String cpf) throws PessoaLookupException {
        final String documento = Documentos.apenasDigitos(cpf);
        if (documento.length() != 11) {
            throw new PessoaLookupException("CPF deve conter 11 dígitos: " + cpf);
        }
        final Map<String, Object> resposta = requisitar(this.pacoteCpf, documento);
        final EnderecoFiscal endereco = enderecoDeCpf(resposta);
        return new PessoaFiscal(PessoaFiscal.TipoPessoa.FISICA, documento, texto(resposta, "nome"), null, endereco);
    }

    @Override
    public PessoaFiscal consultarCnpj(final String cnpj) throws PessoaLookupException {
        final String documento = Documentos.normalizaCnpj(cnpj);
        if (documento.length() != 14) {
            throw new PessoaLookupException("CNPJ deve conter 14 caracteres: " + cnpj);
        }
        final Map<String, Object> resposta = requisitar(this.pacoteCnpj, documento);
        final EnderecoFiscal endereco = enderecoDeCnpj(resposta);
        return new PessoaFiscal(PessoaFiscal.TipoPessoa.JURIDICA, documento, texto(resposta, "razao"), texto(resposta, "email"), endereco);
    }

    /**
     * Consulta as Inscrições Estaduais de uma pessoa jurídica pelo pacote CNPJ H
     * (identificador 16). O corpo esperado traz o array {@code inscricoesEstaduais}, com um
     * objeto por unidade federativa: {@code inscricao_estadual}, {@code ativo} e um objeto
     * {@code estado} aninhado com a {@code sigla} da UF.
     *
     * @param cnpj CNPJ a consultar, com ou sem máscara. Aceita CNPJ alfanumérico.
     * @return lista de inscrições estaduais; vazia quando a empresa não tem IE cadastrada.
     * @throws PessoaLookupException quando a consulta falha ou o documento é recusado pela fonte.
     */
    @Override
    public List<InscricaoEstadual> consultarInscricoesEstaduais(final String cnpj) throws PessoaLookupException {
        final String documento = Documentos.normalizaCnpj(cnpj);
        if (documento.length() != 14) {
            throw new PessoaLookupException("CNPJ deve conter 14 caracteres: " + cnpj);
        }
        final Map<String, Object> resposta = requisitar(this.pacoteIe, documento);
        return inscricoesDe(resposta);
    }

    private static List<InscricaoEstadual> inscricoesDe(final Map<String, Object> resposta) {
        final List<Object> itens = lista(resposta, "inscricoesEstaduais");
        final List<InscricaoEstadual> inscricoes = new ArrayList<>();
        if (itens == null) {
            return inscricoes;
        }
        for (final Object item : itens) {
            if (!(item instanceof Map)) {
                continue;
            }
            @SuppressWarnings("unchecked") final Map<String, Object> mapa = (Map<String, Object>) item;
            final String numero = Documentos.apenasDigitos(texto(mapa, "inscricao_estadual"));
            if (numero.isEmpty()) {
                continue;
            }
            final Map<String, Object> estado = objeto(mapa, "estado");
            final String sigla = estado == null ? null : texto(estado, "sigla");
            inscricoes.add(new InscricaoEstadual(numero, sigla, booleano(mapa, "ativo")));
        }
        return inscricoes;
    }

    private Map<String, Object> requisitar(final int pacote, final String documento) throws PessoaLookupException {
        final String url = BASE_URL + "/" + this.token + "/" + pacote + "/" + documento;
        final String corpo;
        try {
            corpo = this.transporte.get(url);
        } catch (final IOException e) {
            throw new PessoaLookupException("Falha na comunicação com a API cpfcnpj.com.br", e);
        }
        final Object cru;
        try {
            cru = MiniJson.parse(corpo);
        } catch (final RuntimeException e) {
            throw new PessoaLookupException("Resposta da API cpfcnpj.com.br não é um JSON válido", e);
        }
        if (!(cru instanceof Map)) {
            throw new PessoaLookupException("Resposta da API cpfcnpj.com.br em formato inesperado");
        }
        @SuppressWarnings("unchecked") final Map<String, Object> resposta = (Map<String, Object>) cru;
        final long status = inteiro(resposta, "status");
        if (status != 1L) {
            final String erro = texto(resposta, "erro");
            final long codigo = inteiro(resposta, "erroCodigo");
            throw new PessoaLookupException("Consulta recusada pela API cpfcnpj.com.br"
                    + (erro != null ? ": " + erro : "")
                    + (codigo != 0 ? " (código " + codigo + ")" : ""));
        }
        return resposta;
    }

    private EnderecoFiscal enderecoDeCpf(final Map<String, Object> resposta) {
        final String logradouro = texto(resposta, "endereco");
        if (!Documentos.preenchido(logradouro)) {
            return null;
        }
        return new EnderecoFiscal(
                logradouro,
                texto(resposta, "numero"),
                texto(resposta, "complemento"),
                texto(resposta, "bairro"),
                Documentos.apenasDigitos(texto(resposta, "cep")),
                texto(resposta, "cidade"),
                texto(resposta, "uf"),
                Documentos.apenasDigitos(texto(resposta, "ibge")));
    }

    private EnderecoFiscal enderecoDeCnpj(final Map<String, Object> resposta) {
        final Map<String, Object> matriz = objeto(resposta, "matrizEndereco");
        if (matriz == null) {
            return null;
        }
        final Map<String, Object> ibge = objeto(resposta, "ibge");
        final Map<String, Object> cidadeIbge = ibge == null ? null : objeto(ibge, "cidade");
        final String codigoMunicipio = cidadeIbge == null ? null : Documentos.apenasDigitos(texto(cidadeIbge, "ibge_id"));
        String cidade = texto(matriz, "cidade");
        if (!Documentos.preenchido(cidade) && cidadeIbge != null) {
            cidade = texto(cidadeIbge, "nome");
        }
        return new EnderecoFiscal(
                texto(matriz, "logradouro"),
                texto(matriz, "numero"),
                texto(matriz, "complemento"),
                texto(matriz, "bairro"),
                Documentos.apenasDigitos(texto(matriz, "cep")),
                cidade,
                texto(matriz, "uf"),
                codigoMunicipio);
    }

    private static String texto(final Map<String, Object> mapa, final String chave) {
        final Object valor = mapa.get(chave);
        if (valor == null) {
            return null;
        }
        if (valor instanceof Long) {
            return Long.toString((Long) valor);
        }
        if (valor instanceof Double) {
            final double numero = (Double) valor;
            if (!Double.isNaN(numero) && !Double.isInfinite(numero) && numero == Math.rint(numero)) {
                return Long.toString((long) numero);
            }
            return String.valueOf(numero);
        }
        return valor.toString();
    }

    private static long inteiro(final Map<String, Object> mapa, final String chave) {
        final Object valor = mapa.get(chave);
        if (valor instanceof Long) {
            return (Long) valor;
        }
        if (valor instanceof Double) {
            return ((Double) valor).longValue();
        }
        if (valor instanceof String) {
            final String digitos = Documentos.apenasDigitos((String) valor);
            if (!digitos.isEmpty()) {
                return Long.parseLong(digitos);
            }
        }
        return 0L;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> objeto(final Map<String, Object> mapa, final String chave) {
        final Object valor = mapa.get(chave);
        return valor instanceof Map ? (Map<String, Object>) valor : null;
    }

    @SuppressWarnings("unchecked")
    private static List<Object> lista(final Map<String, Object> mapa, final String chave) {
        final Object valor = mapa.get(chave);
        return valor instanceof List ? (List<Object>) valor : null;
    }

    private static boolean booleano(final Map<String, Object> mapa, final String chave) {
        final Object valor = mapa.get(chave);
        if (valor instanceof Boolean) {
            return (Boolean) valor;
        }
        if (valor instanceof String) {
            return Boolean.parseBoolean(((String) valor).trim());
        }
        return false;
    }
}
