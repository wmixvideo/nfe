package com.fincatto.documentofiscal.mdfe3.classes.parsers;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmissao;
import com.fincatto.documentofiscal.utils.DFUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

/**
 * Classe responsavel por fazer o parse da chave do MDFe.
 */
public class MDFChaveParser {

    private final String chave;

    public MDFChaveParser(final String chave) {
        this.chave = StringUtils.stripToEmpty(chave).replaceAll("\\D", "");
        if (this.chave.length() != 44) {
            throw new IllegalArgumentException(String.format("A chave do MDFe deve ter exatos 44 caracteres numericos: %s", chave));
        }
    }

    public String getChave() {
        return chave;
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

    public DFModelo getModelo() {
        return DFModelo.valueOfCodigo(this.chave.substring(20, 22));
    }

    public String getSerie() {
        return this.chave.substring(22, 25);
    }

    public String getNumero() {
        return this.chave.substring(25, 34);
    }

    public MDFTipoEmissao getFormaEmissao() {
        return MDFTipoEmissao.valueOfCodigo(this.chave.substring(34, 35));
    }

    public String getCodigoNumerico() {
        return this.chave.substring(35, 43);
    }

    public String getDV() {
        return this.chave.substring(43, 44);
    }

    public String getFormatado() {
        return this.chave.replaceFirst("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})", "$1 $2 $3 $4 $5 $6 $7 $8 $9 $10 $11");
    }

    /**
     * Indica se o emitente da chave eh pessoa fisica.
     *
     * @return Se chave foi emitida por pessoa fisica.
     */
    public boolean isEmitentePessoaFisica() {
        return DFUtils.isCpfValido(this.chave.substring(9, 20)) && this.isSerieReservadaPessoaFisica();
    }

    /**
     * Indica se o emitente da chave eh pessoa juridica.
     *
     * @return Se chave foi emitida por pessoa juridica.
     */
    public boolean isEmitentePessoaJuridica() {
        return DFUtils.isCnpjValido(this.chave.substring(6, 20)) && !this.isSerieReservadaPessoaFisica();
    }

    /**
     * Indica se a chave é de uma série destinada a pessoa física.<br>
     * De acordo com a documentação: "Será reservada uma faixa do campo Série do MDF-e (920-969), como forma de identificação da Emitente pessoa física (CPF);"<br>
     * <a href="http://sped.rfb.gov.br/estatico/8A/16CC5375F0AC1A0B7666221FC2116325133C01/MOC_MDFe_VisaoGeral_v3.00a.pdf">...</a>
     *
     * @return se a serie é destinada a pessoa física.
     */
    public boolean isSerieReservadaPessoaFisica() {
        if (DFUtils.isNumerico(this.getSerie())) {
            final int serie = Integer.parseInt(this.getSerie());
            return serie >= 920 && serie <= 969;
        }
        return false;
    }
}
