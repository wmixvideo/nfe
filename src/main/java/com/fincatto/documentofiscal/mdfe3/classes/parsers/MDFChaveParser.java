package com.fincatto.documentofiscal.mdfe3.classes.parsers;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmissao;
import org.apache.commons.lang3.StringUtils;
import java.time.LocalDate;

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

    public String getCnpjEmitente() {
        return this.chave.substring(6, 20);
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
}
