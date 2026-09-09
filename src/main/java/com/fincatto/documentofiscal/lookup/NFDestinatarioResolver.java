package com.fincatto.documentofiscal.lookup;

import java.util.List;
import java.util.regex.Pattern;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.NFEndereco;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFIndicadorIEDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoDestinatario;

/**
 * Monta um {@link NFNotaInfoDestinatario} do pacote nfe400, já preenchido, a partir de
 * qualquer {@link PessoaLookup}. É a ponte entre os dados cadastrais normalizados e o
 * objeto nativo do SDK, populado pelos setters JavaBean das próprias classes.
 *
 * <p>Recurso aditivo e opcional: nenhuma classe de nota é alterada. O resolver apenas
 * chama os setters existentes e devolve o destinatário com o {@link NFEndereco} embutido,
 * pronto para receber os demais dados da nota.</p>
 *
 * <p><strong>Inscrição Estadual (IE):</strong> por padrão o indicador de IE do destinatário
 * assume {@link NFIndicadorIEDestinatario#NAO_CONTRIBUINTE} ({@code indIEDest=9}), sem IE. Esse
 * é o cenário de encaixe forte: NFC-e (modelo 65) e NF-e a consumidor final pessoa física, em
 * que a IE não se informa. Para o B2B entre contribuintes existe
 * {@link #porCnpjComInscricaoEstadual(String)}: quando a fonte implementa
 * {@link InscricaoEstadualLookup} (o caso da {@link CpfCnpjComBrLookup}, via pacote 16), o
 * resolver seleciona a IE ativa cuja unidade federativa coincide com a UF do endereço do
 * destinatário e, havendo uma, marca o destinatário como contribuinte de ICMS
 * ({@code indIEDest=1}) e preenche a IE. Sem IE ativa para a UF, o destinatário permanece como
 * não contribuinte, sem IE: o resolver nunca presume o regime de isento
 * ({@code indIEDest=2}), que depende de informação que a fonte não fornece.</p>
 */
public class NFDestinatarioResolver {

    private static final int TAMANHO_MAXIMO_TEXTO = 60;
    private static final int TAMANHO_MINIMO_BAIRRO = 2;
    private static final int TAMANHO_CEP = 8;
    private static final int TAMANHO_CODIGO_MUNICIPIO = 7;
    private static final Pattern IE_SCHEMA = Pattern.compile("[0-9]{2,14}");

    private final PessoaLookup lookup;

    public NFDestinatarioResolver(final PessoaLookup lookup) {
        if (lookup == null) {
            throw new IllegalArgumentException("PessoaLookup obrigatório");
        }
        this.lookup = lookup;
    }

    /**
     * Resolve o destinatário por CPF. Como CPF nunca é contribuinte de ICMS, o indicador
     * de IE fica em {@link NFIndicadorIEDestinatario#NAO_CONTRIBUINTE}.
     *
     * @param cpf CPF a consultar.
     * @return destinatário preenchido.
     * @throws PessoaLookupException quando a consulta falha.
     */
    public NFNotaInfoDestinatario porCpf(final String cpf) throws PessoaLookupException {
        return montar(this.lookup.consultarCpf(cpf), NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
    }

    /**
     * Resolve o destinatário por CNPJ, assumindo {@link NFIndicadorIEDestinatario#NAO_CONTRIBUINTE}.
     *
     * @param cnpj CNPJ a consultar.
     * @return destinatário preenchido, sem IE.
     * @throws PessoaLookupException quando a consulta falha.
     */
    public NFNotaInfoDestinatario porCnpj(final String cnpj) throws PessoaLookupException {
        return porCnpj(cnpj, NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
    }

    /**
     * Resolve o destinatário por CNPJ com o indicador de IE informado pelo chamador.
     *
     * @param cnpj      CNPJ a consultar.
     * @param indicador indicador de IE do destinatário.
     * @return destinatário preenchido, sem IE.
     * @throws PessoaLookupException quando a consulta falha.
     */
    public NFNotaInfoDestinatario porCnpj(final String cnpj, final NFIndicadorIEDestinatario indicador) throws PessoaLookupException {
        return montar(this.lookup.consultarCnpj(cnpj), indicador);
    }

    /**
     * Resolve o destinatário detectando automaticamente CPF (11 dígitos) ou CNPJ (14
     * caracteres). Para CNPJ, assume {@link NFIndicadorIEDestinatario#NAO_CONTRIBUINTE}.
     *
     * @param documento CPF ou CNPJ, com ou sem máscara.
     * @return destinatário preenchido.
     * @throws PessoaLookupException quando a consulta falha.
     */
    public NFNotaInfoDestinatario porDocumento(final String documento) throws PessoaLookupException {
        return porDocumento(documento, NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
    }

    /**
     * Resolve o destinatário detectando CPF ou CNPJ, aplicando o indicador de IE ao caso CNPJ.
     *
     * @param documento      CPF ou CNPJ, com ou sem máscara.
     * @param indicadorCnpj  indicador de IE usado quando o documento for CNPJ.
     * @return destinatário preenchido.
     * @throws PessoaLookupException quando a consulta falha.
     */
    public NFNotaInfoDestinatario porDocumento(final String documento, final NFIndicadorIEDestinatario indicadorCnpj) throws PessoaLookupException {
        final String normalizado = Documentos.normalizaCnpj(documento);
        if (normalizado.length() == 11 && Documentos.apenasDigitos(documento).length() == 11) {
            return porCpf(documento);
        }
        if (normalizado.length() == 14) {
            return porCnpj(documento, indicadorCnpj);
        }
        throw new IllegalArgumentException("Documento não é um CPF (11 dígitos) nem um CNPJ (14 caracteres): " + documento);
    }

    /**
     * Resolve o destinatário por CNPJ preenchendo a Inscrição Estadual (IE) quando cabível.
     * A fonte precisa implementar {@link InscricaoEstadualLookup} (o caso da
     * {@link CpfCnpjComBrLookup}); do contrário, use {@link #porCnpj(String)}.
     *
     * <p>O resolver consulta os dados cadastrais e as IEs, e escolhe a IE ativa cuja unidade
     * federativa coincide com a UF do endereço do destinatário. Havendo essa IE ativa, o
     * destinatário vira contribuinte de ICMS ({@code indIEDest=1}) com a IE preenchida. Não
     * havendo, permanece como não contribuinte ({@code indIEDest=9}) sem IE, sem nunca presumir
     * o regime de isento.</p>
     *
     * @param cnpj CNPJ a consultar, com ou sem máscara.
     * @return destinatário preenchido, com IE quando há inscrição ativa para a UF do endereço.
     * @throws PessoaLookupException quando a consulta falha.
     * @throws IllegalStateException quando a fonte não fornece Inscrição Estadual.
     */
    public NFNotaInfoDestinatario porCnpjComInscricaoEstadual(final String cnpj) throws PessoaLookupException {
        if (!(this.lookup instanceof InscricaoEstadualLookup)) {
            throw new IllegalStateException("A fonte de consulta não fornece Inscrição Estadual (pacote 16); use porCnpj(cnpj) ou uma fonte que implemente InscricaoEstadualLookup");
        }
        final PessoaFiscal pessoa = this.lookup.consultarCnpj(cnpj);
        final List<InscricaoEstadual> inscricoes = ((InscricaoEstadualLookup) this.lookup).consultarInscricoesEstaduais(cnpj);
        final String uf = pessoa.getEndereco() == null ? null : pessoa.getEndereco().getUf();
        final InscricaoEstadual ativa = inscricaoAtivaDaUf(inscricoes, uf);
        if (ativa == null) {
            return montar(pessoa, NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
        }
        final NFNotaInfoDestinatario destinatario = montar(pessoa, NFIndicadorIEDestinatario.CONTRIBUINTE_ICMS);
        destinatario.setInscricaoEstadual(ativa.getInscricao().trim());
        return destinatario;
    }

    /**
     * Resolve o destinatário detectando CPF ou CNPJ. Para CPF, segue como não contribuinte;
     * para CNPJ, preenche a IE quando cabível, como em {@link #porCnpjComInscricaoEstadual(String)}.
     *
     * @param documento CPF ou CNPJ, com ou sem máscara.
     * @return destinatário preenchido.
     * @throws PessoaLookupException quando a consulta falha.
     * @throws IllegalStateException quando o documento é CNPJ e a fonte não fornece IE.
     */
    public NFNotaInfoDestinatario porDocumentoComInscricaoEstadual(final String documento) throws PessoaLookupException {
        final String normalizado = Documentos.normalizaCnpj(documento);
        if (normalizado.length() == 11 && Documentos.apenasDigitos(documento).length() == 11) {
            return porCpf(documento);
        }
        if (normalizado.length() == 14) {
            return porCnpjComInscricaoEstadual(documento);
        }
        throw new IllegalArgumentException("Documento não é um CPF (11 dígitos) nem um CNPJ (14 caracteres): " + documento);
    }

    private static InscricaoEstadual inscricaoAtivaDaUf(final List<InscricaoEstadual> inscricoes, final String uf) {
        if (inscricoes == null || inscricoes.isEmpty() || !Documentos.preenchido(uf)) {
            return null;
        }
        final String alvo = uf.trim().toUpperCase();
        for (final InscricaoEstadual inscricao : inscricoes) {
            if (inscricao.isAtivo() && Documentos.preenchido(inscricao.getUf())
                    && alvo.equals(inscricao.getUf().trim().toUpperCase())
                    && ieValida(inscricao.getInscricao())) {
                return inscricao;
            }
        }
        return null;
    }

    private static boolean ieValida(final String inscricao) {
        return inscricao != null && IE_SCHEMA.matcher(inscricao.trim()).matches();
    }

    private NFNotaInfoDestinatario montar(final PessoaFiscal pessoa, final NFIndicadorIEDestinatario indicador) {
        final NFNotaInfoDestinatario destinatario = new NFNotaInfoDestinatario();
        if (pessoa.getTipo() == PessoaFiscal.TipoPessoa.FISICA) {
            destinatario.setCpf(pessoa.getDocumento());
        } else {
            destinatario.setCnpj(pessoa.getDocumento());
        }
        if (Documentos.preenchido(pessoa.getNome())) {
            destinatario.setRazaoSocial(Documentos.limita(pessoa.getNome(), TAMANHO_MAXIMO_TEXTO));
        }
        if (Documentos.preenchido(pessoa.getEmail())) {
            destinatario.setEmail(Documentos.limita(pessoa.getEmail(), TAMANHO_MAXIMO_TEXTO));
        }
        destinatario.setIndicadorIEDestinatario(indicador);
        final NFEndereco endereco = montarEndereco(pessoa.getEndereco());
        if (endereco != null) {
            destinatario.setEndereco(endereco);
        }
        return destinatario;
    }

    private NFEndereco montarEndereco(final EnderecoFiscal origem) {
        if (origem == null || !Documentos.preenchido(origem.getLogradouro())) {
            return null;
        }
        final NFEndereco endereco = new NFEndereco();
        endereco.setLogradouro(Documentos.limita(origem.getLogradouro(), TAMANHO_MAXIMO_TEXTO));
        endereco.setNumero(Documentos.preenchido(origem.getNumero())
                ? Documentos.limita(origem.getNumero(), TAMANHO_MAXIMO_TEXTO)
                : "S/N");
        if (Documentos.preenchido(origem.getComplemento())) {
            endereco.setComplemento(Documentos.limita(origem.getComplemento(), TAMANHO_MAXIMO_TEXTO));
        }
        if (Documentos.preenchido(origem.getBairro()) && origem.getBairro().trim().length() >= TAMANHO_MINIMO_BAIRRO) {
            endereco.setBairro(Documentos.limita(origem.getBairro(), TAMANHO_MAXIMO_TEXTO));
        }
        final String cep = Documentos.apenasDigitos(origem.getCep());
        if (cep.length() == TAMANHO_CEP) {
            endereco.setCep(cep);
        }
        if (Documentos.preenchido(origem.getCidade())) {
            endereco.setDescricaoMunicipio(Documentos.limita(origem.getCidade(), TAMANHO_MAXIMO_TEXTO));
        }
        final DFUnidadeFederativa uf = unidadeFederativa(origem.getUf());
        if (uf != null) {
            endereco.setUf(uf);
        }
        final String codigoMunicipio = Documentos.apenasDigitos(origem.getCodigoMunicipio());
        if (codigoMunicipio.length() == TAMANHO_CODIGO_MUNICIPIO) {
            endereco.setCodigoMunicipio(codigoMunicipio);
        }
        return endereco;
    }

    private static DFUnidadeFederativa unidadeFederativa(final String sigla) {
        if (!Documentos.preenchido(sigla)) {
            return null;
        }
        try {
            return DFUnidadeFederativa.valueOf(sigla.trim().toUpperCase());
        } catch (final IllegalArgumentException e) {
            return null;
        }
    }
}
