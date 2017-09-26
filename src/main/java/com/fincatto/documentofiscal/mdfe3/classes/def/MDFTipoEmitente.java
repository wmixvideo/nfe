package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author Eldevan Nery Junior on 30/05/17.
 */
public enum MDFTipoEmitente {

    PRESTADOR_SERVICO_TRANSPORTE("1", "Prestador de servi\u00e7o de transporte"),
    /**
     * <p>OBS: Deve ser preenchido com 2 para
     emitentes de NF-e e pelas
     transportadoras quando estiverem
     fazendo transporte de carga própria<p/>
     */
    TRANSPORTADOR_CARGA_PROPRIA("2", "Transportador de Carga Própria");

    private final String codigo;
    private final String descricao;

    MDFTipoEmitente(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoEmitente valueOfCodigo(final String codigo) {
        for (MDFTipoEmitente tipoEmitente : MDFTipoEmitente.values()) {
            if (tipoEmitente.getCodigo().equalsIgnoreCase(codigo)) {
                return tipoEmitente;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
