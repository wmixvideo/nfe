package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalComercioExteriorMecanismoApoioTomador {

    DESCONHECIDO("00", "Desconhecido (tipo não informado na nota de origem)"),
    NENHUM("01", "Nenhum"),
    ADM_PUBLICA("02", "Adm. Pública e Repr. Internacional"),
    ALUGUEIS("03", "Alugueis e Arrend. Mercantil de maquinas, equip., embarc. e aeronaves"),
    ARRENDAMENTO("04", "Arrendamento Mercantil de aeronave para empresa de transporte aéreo público"),
    COMISSAO("05", "Comissão a agentes externos na exportação"),
    DESPESAS("06", "Despesas de armazenagem, mov. e transporte de carga no exterior"),
    EVENTOS_FIFA_SUBSIDIARIA("07", "Eventos FIFA (subsidiária)"),
    EVENTOS_FIFA("08", "Eventos FIFA"),
    FRETES("09", "Fretes, arrendamentos de embarcações ou aeronaves e outros"),
    MATERIAL("10", "Material Aeronáutico"),
    PROMOCAO_BENS_EXTERIOR("11", "Promoção de Bens no Exterior"),
    PROMOCAO_DESTINOS_TURISTICOS_BRASILEIROS("12", "Promoção de Dest. Turísticos Brasileiros"),
    PROMOCAO_BRASIL_NO_EXTERIOR("13", "Promoção do Brasil no Exterior"),
    PROMOCAO_SERVICOS_NO_EXTERIOR("14", "Promoção Serviços no Exterior"),
    RECINE("15", "RECINE"),
    RECOPA("16", "RECOPA"),
    REGISTRO_MANUTENCAO_MARCAS_PATENTES_CULTIVARES("17", "Registro e Manutenção de marcas, patentes e cultivares"),
    REICOMP("18", "REICOMP"),
    REIDI("19", "REIDI"),
    REPENEC("20", "REPENEC"),
    REPES("21", "REPES"),
    RETAERO("22", "RETAERO"),
    RETID("23", "RETID"),
    ROYALTIES("24", "Royalties, Assistência Técnica, Científica e Assemelhados"),
    SERVICOS_AVALIACAO_ACORDOS_OMC("25", "Serviços de avaliação da conformidade vinculados aos Acordos da OMC"),
    ZPE("26", "ZPE");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalComercioExteriorMecanismoApoioTomador(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalComercioExteriorMecanismoApoioTomador valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalComercioExteriorMecanismoApoioTomador tipo : NFSeSefinNacionalComercioExteriorMecanismoApoioTomador.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}