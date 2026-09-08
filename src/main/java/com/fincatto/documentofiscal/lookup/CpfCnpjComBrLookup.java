package com.fincatto.documentofiscal.lookup;

import java.io.IOException;
import java.util.Map;

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
 * de testes que devolve dados fictícios.</p>
 *
 * <p><strong>Inscrição Estadual:</strong> a API não fornece IE nem IM, portanto esta consulta
 * nunca as preenche. Veja a {@link NFDestinatarioResolver} para o detalhamento de quando isso
 * é suficiente (NFC-e e venda a consumidor final, {@code indIEDest=9}) e quando o chamador
 * precisa completar a IE por outra fonte (destinatário contribuinte de ICMS).</p>
 */
public class CpfCnpjComBrLookup implements PessoaLookup {

    private static final String BASE_URL = "https://api.cpfcnpj.com.br";
    private static final int PACOTE_CPF_PADRAO = 3;
    private static final int PACOTE_CNPJ_PADRAO = 5;

    private final String token;
    private final int pacoteCpf;
    private final int pacoteCnpj;
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
     * Cria a consulta com um transporte HTTP próprio. Útil para reaproveitar o httpclient5
     * do projeto ou para testes com respostas simuladas.
     *
     * @param token      token de acesso.
     * @param pacoteCpf  identificador do pacote a usar em consultas de CPF.
     * @param pacoteCnpj identificador do pacote a usar em consultas de CNPJ.
     * @param transporte transporte HTTP a utilizar.
     */
    public CpfCnpjComBrLookup(final String token, final int pacoteCpf, final int pacoteCnpj, final HttpTransport transporte) {
        if (!Documentos.preenchido(token)) {
            throw new IllegalArgumentException("Token de acesso obrigatório");
        }
        if (transporte == null) {
            throw new IllegalArgumentException("Transporte HTTP obrigatório");
        }
        this.token = token.trim();
        this.pacoteCpf = pacoteCpf;
        this.pacoteCnpj = pacoteCnpj;
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
        if (valor instanceof Long || valor instanceof Double) {
            return valor instanceof Long ? Long.toString((Long) valor) : String.valueOf(valor);
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
}
