package com.fincatto.documentofiscal;

import java.util.Arrays;
import java.util.List;

public enum DFModelo {

    AVULSA("01", "Nota avulsa"),
    PRODUTOR("04", "Nota produtor"),
    NFE("55", "NF-e"),
    NFCE("65", "NFC-e"),
    CTE("57", "CT-e"),
    MDFE("58", "MDF-e"),
    CTeOS("67", "CT-e OS");

    public static final List<DFModelo> MODELOS_NOTAS_NAO_ELETRONICAS = Arrays.asList(AVULSA, PRODUTOR);

    private final String codigo;
    private final String descricao;

    DFModelo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static DFModelo valueOfCodigo(final String codigo) {
        for (final DFModelo tipo : DFModelo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
}