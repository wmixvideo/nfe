package com.fincatto.documentofiscal.lookup;

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
 * <p><strong>Inscrição Estadual (IE):</strong> este resolver nunca preenche a IE, porque a
 * fonte de dados não a fornece. O indicador de IE do destinatário assume, por padrão,
 * {@link NFIndicadorIEDestinatario#NAO_CONTRIBUINTE} ({@code indIEDest=9}). Esse é o cenário
 * de encaixe forte: NFC-e (modelo 65) e NF-e a consumidor final pessoa física, em que a IE
 * não se informa. Para destinatário contribuinte de ICMS ({@code indIEDest=1}), use a
 * sobrecarga que recebe o indicador e complete a IE por outra fonte (entrada manual ou a
 * consulta de cadastro na SEFAZ, que exige certificado).</p>
 */
public class NFDestinatarioResolver {

    private static final int TAMANHO_MAXIMO_TEXTO = 60;
    private static final int TAMANHO_MINIMO_BAIRRO = 2;
    private static final int TAMANHO_CEP = 8;
    private static final int TAMANHO_CODIGO_MUNICIPIO = 7;

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
