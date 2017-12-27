package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * Created by Eldevan Nery Junior on 07/12/17.
 * 
 * Responsável pelo seguro
 * 
 */
public enum MDFTipoResponsavelSeguro {

    /**
     * Preencher com:
     * 1- Emitente do MDF-e;
     *
     * 2 - Responsável pela contratação do serviço de transporte (contratante)	
     * Dados obrigatórios apenas no modal Rodoviário, depois da lei 11.442/07.
     * Para os demais modais esta informação é opcional.
     */
    EMITENTE_MDFE("1", "Emitente do MDF-e"),
    CONTRATANTE_MDFE("2", "Responsável pela contratação");

    private final String codigo;
    private final String descricao;

    MDFTipoResponsavelSeguro(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoResponsavelSeguro valueOfCodigo(final String codigo) {
        for (MDFTipoResponsavelSeguro tipoUnidadeCarga : MDFTipoResponsavelSeguro.values()) {
            if (tipoUnidadeCarga.getCodigo().equalsIgnoreCase(codigo)) {
                return tipoUnidadeCarga;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
