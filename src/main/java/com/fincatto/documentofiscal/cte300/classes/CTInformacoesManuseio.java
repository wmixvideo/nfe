package com.fincatto.documentofiscal.cte300.classes;

public enum CTInformacoesManuseio {

	Certificado_do_Expedidor_para_Embarque_de_Animal_Vivo("01", "Certificado do Expedidor para Embarque de Animal Vivo"),
	Artigo_Perigoso_Conforme_Declaracao_do_Expedidor_Anexa("02", "Artigo Perigoso Conforme Declaração do Expedidor Anexa"),
	Somente_em_Aeronave_Cargueira("03", "Somente em Aeronave Cargueira"),
	Artigo_Perigoso_Declaracao_do_Expedidor_nao_requerida("04", "Artigo Perigoso - Declaração do Expedidor não requerida"),
	Artigo_Perigoso_em_Quantidade_Isenta("05", "Artigo Perigoso em Quantidade Isenta"),
	Gelo_Seco_para_Refrigeracao("06", "Gelo Seco para Refrigeração (Especificar no Campo Observações a Quantidade)"),
	Nao_Restrito("07", "Não Restrito (Especificar a Disposição Especial no Campo Observações)"),
	Artigo_Perigoso_em_Carga_Consolidada("08", "Artigo Perigoso em Carga Consolidada (Especificar a Quantidade no Campo Observações)"),
	Autorizacao_da_Autoridade_Governamental_Anexa("09", "Autorização da Autoridade Governamental Anexa (Especificar no Campo Observações)"),
	Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI965("10", "Baterias de Íons de Lítio em Conformidade com a Seção II da PI965 - CAO"),
	Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI966("11", "Baterias de Íons de Lítio em Conformidade com a Seção II da PI966"),
	Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI967("12", "Baterias de Íons de Lítio em Conformidade com a Seção II da PI967"),
	Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI968("13", "Baterias de Íons de Lítio em Conformidade com a Seção II da PI968 - CAO"),
	Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI969("14", "Baterias de Íons de Lítio em Conformidade com a Seção II da PI969"),
	Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI970("15", "Baterias de Íons de Lítio em Conformidade com a Seção II da PI970"),
	Outro("99", "Outro (Especificar no Campo Observações)");

    private final String codigo;
    private final String descricao;

    CTInformacoesManuseio(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTInformacoesManuseio valueOfCodigo(final String codigo) {
        for (final CTInformacoesManuseio tipo : CTInformacoesManuseio.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}