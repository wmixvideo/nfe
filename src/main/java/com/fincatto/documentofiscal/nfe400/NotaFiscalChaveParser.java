package com.fincatto.documentofiscal.nfe400;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.utils.DFUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

public class NotaFiscalChaveParser {

    private final String chave;

    public NotaFiscalChaveParser(final String chave) {
        this.chave = StringUtils.stripToEmpty(chave).replaceAll("\\D", "");
        if (this.chave.length() != 44) {
            throw new IllegalArgumentException(String.format("A chave deve ter exatos 44 caracteres numericos: %s", chave));
        }
    }

    public String getChave() {
        return this.chave;
    }

    public DFUnidadeFederativa getNFUnidadeFederativa() {
        return DFUnidadeFederativa.valueOfCodigo(this.chave.substring(0, 2));
    }

    public LocalDate getDataEmissao() {
        return LocalDate.of(this.getDataEmissaoAno(), this.getDataEmissaoMes(), 1);
    }

    private int getDataEmissaoMes() {
        return Integer.parseInt(this.chave.substring(4, 6));
    }

    private int getDataEmissaoAno() {
        return 2000 + Integer.parseInt(this.chave.substring(2, 4));
    }

    public DFModelo getModelo() {
        return DFModelo.valueOfCodigo(this.chave.substring(20, 22));
    }

    public String getSerie() {
        return this.chave.substring(22, 25);
    }

    public String getNumero() {
        return this.chave.substring(25, 34);
    }

    public NFTipoEmissao getFormaEmissao() {
        return NFTipoEmissao.valueOfCodigo(this.chave.substring(34, 35));
    }

    public String getCodigoNumerico() {
        return this.chave.substring(35, 43);
    }

    public String getDV() {
        return this.chave.substring(43, 44);
    }

    public boolean isEmitidaContingenciaSCAN() {
        return this.getSerie().matches("9[0-9]{2}");
    }

    public boolean isEmitidaContingenciaSCVAN() {
        return this.chave.matches("\\d{34}6\\d{9}");
    }

    public boolean isEmitidaContingenciaSCVRS() {
        return this.chave.matches("\\d{34}7\\d{9}");
    }

    public String getFormatado() {
        return this.chave.replaceFirst("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})", "$1 $2 $3 $4 $5 $6 $7 $8 $9 $10 $11");
    }

    /**
     * Indica se o emitente da chave eh pessoa fisica.
     * @return Se chave foi emitida por pessoa fisica.
     */
    public boolean isEmitentePessoaFisica() {
        return DFUtils.isCpfValido(this.chave.substring(9, 20));
    }

    /**
     * Indica se o emitente da chave eh pessoa juridica.
     * @return Se chave foi emitida por pessoa juridica.
     */
    public boolean isEmitentePessoaJuridica() {
        return DFUtils.isCnpjValido(this.chave.substring(6, 20));
    }

    /**
     * Returna o CNPJ do emitente da chave.<br>
     * Se nao for um CNPJ valido, retorna nulo.
     *
     * @return CNPJ do emitente ou nulo.
     */
    public String getCnpjEmitente() {
        return isEmitentePessoaJuridica() ? this.chave.substring(6, 20) : null;
    }

    /**
     * Returna o CPF do emitente da chave.<br>
     * Se nao for um CPF valido, retorna nulo.
     *
     * @return CPF do emitente ou nulo.
     */
    public String getCpfEmitente() {
        return isEmitentePessoaFisica() ? this.chave.substring(9, 20) : null;
    }
}
