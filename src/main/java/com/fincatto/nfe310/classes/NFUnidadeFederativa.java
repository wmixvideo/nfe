package com.fincatto.nfe310.classes;

/**
 * URls qrCode: http://nfce.encat.org/desenvolvedor/qrcode/
 **/
public enum NFUnidadeFederativa {

    AC("AC", "Acre", "12", "http://hml.sefaznet.ac.gov.br/nfce/qrcode", "http://hml.sefaznet.ac.gov.br/nfce/qrcode"),
    AL("AL", "Alagoas", "27"),
    AP("AP", "Amap\u00E1", "16", "https://www.sefaz.ap.gov.br/nfcehml/nfce.php", "https://www.sefaz.ap.gov.br/nfce/nfce.php"),
    AM("AM", "Amazonas", "13", "homnfce.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp", "sistemas.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp"),
    BA("BA", "Bahia", "29", "http://hnfe.sefaz.ba.gov.br/servicos/nfce/modulos/geral/NFCEC_consulta_chave_acesso.aspx", "http://nfe.sefaz.ba.gov.br/servicos/nfce/modulos/geral/NFCEC_consulta_chave_acesso.aspx"),
    CE("CE", "Cear\u00E1", "23"),
    DF("DF", "Distrito Federal", "53", "http://dec.fazenda.df.gov.br/ConsultarNFCe.aspx", "http://dec.fazenda.df.gov.br/ConsultarNFCe.aspx"),
    GO("GO", "Goi\u00E1s", "52"),
    ES("ES", "Esp\u00EDrito Santo", "32"),
    MA("MA", "Maranh\u00E3o", "21"),
    MT("MT", "Mato Grosso", "51", "http://www.sefaz.mt.gov.br/nfce/consultanfce", "http://www.sefaz.mt.gov.br/nfce/consultanfce"),
    MS("MS", "Mato Grosso do Sul", "50"),
    MG("MG", "Minas Gerais", "31"),
    PA("PA", "Par\u00E1", "15", "https://appnfc.sefa.pa.gov.br/portal-homologacao/view/consultas/nfce/nfceForm.seam", "https://appnfc.sefa.pa.gov.br/portal/view/consultas/nfce/nfceForm.seam"),
    PB("PB", "Paraiba", "25", "www.receita.pb.gov.br/nfcehom", "www.receita.pb.gov.br/nfce"),
    PR("PR", "Paran\u00E1", "41", "http://www.dfeportal.fazenda.pr.gov.br/dfe-portal/rest/servico/consultaNFCe", "http://www.dfeportal.fazenda.pr.gov.br/dfe-portal/rest/servico/consultaNFCe"),
    PE("PE", "Pernambuco", "26", "http://nfcehomolog.sefaz.pe.gov.br/nfce-web/consultarNFCe", "http://nfce.sefaz.pe.gov.br/nfce-web/consultarNFCe"),
    PI("PI", "Piau\u00ED", "22", "http://webas.sefaz.pi.gov.br/nfceweb-homologacao/consultarNFCe.jsf", "http://webas.sefaz.pi.gov.br/nfceweb/consultarNFCe.jsf"),
    RJ("RJ", "Rio de Janeiro", "33", "http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode", "http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode?"),
    RN("RN", "Rio Grande do Norte", "24", "http://hom.nfce.set.rn.gov.br/consultarNFCe.aspx", "http://nfce.set.rn.gov.br/consultarNFCe.aspx"),
    RS("RS", "Rio Grande do Sul", "43", "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx", "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx"),
    RO("RO", "Rond\u00F4nia", "11", "http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp", "http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp"),
    RR("RR", "Roraima", "14", "http://200.174.88.103:8080/nfce/servlet/qrcode", "https://www.sefaz.rr.gov.br/nfce/servlet/qrcode"),
    SP("SP", "S\u00E3o Paulo", "35", "https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx", "https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx"),
    SC("SC", "Santa Catarina", "42"),
    SE("SE", "Sergipe", "28", "http://www.hom.nfe.se.gov.br/portal/consultarNFCe.jsp", "http://www.nfce.se.gov.br/portal/consultarNFCe.jsp"),
    TO("TO", "Tocantins", "17"),
    NACIONAL("NC", "Nacional", "90"),
    RFB("RFB", "RFB", "91"),
    EX("EX", "Exterior", "99");

    private final String codigo;
    private final String descricao;
    private final String codigoIbge;
    private final String qrCodeHomologacao;
    private final String qrCodeProducao;

    private NFUnidadeFederativa(final String codigo, final String descricao, final String codigoIbge, String qrCodeHomologacao, String qrCodeProducao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.codigoIbge = codigoIbge;
        this.qrCodeHomologacao = qrCodeHomologacao;
        this.qrCodeProducao = qrCodeProducao;
    }

    private NFUnidadeFederativa(final String codigo, final String descricao, final String codigoIbge) {
    	this(codigo, descricao, codigoIbge, null, null);
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getCodigoIbge() {
        return this.codigoIbge;
    }

    public String getQrCodeHomologacao() {
		return qrCodeHomologacao;
	}

	public String getQrCodeProducao() {
		return qrCodeProducao;
	}

	@Override
    public String toString() {
        return this.getDescricao();
    }

    /**
     * Identifica a UF pela sigla ou pelo codigo IBGE.
     * @param codigo Sigla ou codigo IBGE da UF.
     * @return Objeto da UF.
     */
    public static NFUnidadeFederativa valueOfCodigo(final String codigo) {
        for (final NFUnidadeFederativa uf : NFUnidadeFederativa.values()) {
            if (uf.getCodigo().equalsIgnoreCase(codigo)) {
                return uf;
            } else if (uf.getCodigoIbge().equalsIgnoreCase(codigo)) {
                return uf;
            }
        }
        throw new IllegalArgumentException(String.format("N\u00e3o existe o c\u00f3digo %s no mapeamento.", codigo));
    }
}