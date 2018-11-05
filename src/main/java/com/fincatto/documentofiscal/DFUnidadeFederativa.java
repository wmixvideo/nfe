package com.fincatto.documentofiscal;

/**
 * URls qrCode: http://nfce.encat.org/desenvolvedor/qrcode/
 * URLs consulta chave acesso: http://nfce.encat.org/consumidor/consulte-sua-nota/
 **/
public enum DFUnidadeFederativa {

    AC("AC", "Acre", "12", "http://hml.sefaznet.ac.gov.br/nfce/qrcode", "http://hml.sefaznet.ac.gov.br/nfce/qrcode"
            , "http://hml.sefaznet.ac.gov.br/nfce/consulta", "www.sefaznet.ac.gov.br/nfce/consulta"),
    AL("AL", "Alagoas", "27", null, null
            , "http://nfce.sefaz.al.gov.br/consultaNFCe.htm", "http://nfce.sefaz.al.gov.br/consultaNFCe.htm"),
    AP("AP", "Amap\u00E1", "16", "https://www.sefaz.ap.gov.br/nfcehml/nfce.php", "https://www.sefaz.ap.gov.br/nfce/nfce.php"
            , "https://www.sefaz.ap.gov.br/sate1/seg/SEGf_AcessarFuncao.jsp?cdFuncao=FIS_1261", "https://www.sefaz.ap.gov.br/sate/seg/SEGf_AcessarFuncao.jsp?cdFuncao=FIS_1261"),
    AM("AM", "Amazonas", "13", "http://homnfce.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp", "http://sistemas.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp"
            , "homnfce.sefaz.am.gov.br/nfceweb/formConsulta.do", "sistemas.sefaz.am.gov.br/nfceweb/formConsulta.do"),
    BA("BA", "Bahia", "29", "http://hnfe.sefaz.ba.gov.br/servicos/nfce/modulos/geral/NFCEC_consulta_chave_acesso.aspx", "http://nfe.sefaz.ba.gov.br/servicos/nfce/modulos/geral/NFCEC_consulta_chave_acesso.aspx"
            , "http://hnfe.sefaz.ba.gov.br/servicos/nfce/default.aspx", "nfe.sefaz.ba.gov.br/servicos/nfce/default.aspx"),
    CE("CE", "Cear\u00E1", "23", null, null
            , "http://nfce.sefaz.ce.gov.br/pages/consultaNota.jsf", "http://nfceh.sefaz.ce.gov.br/pages/consultaNota.jsf"),
    DF("DF", "Distrito Federal", "53", "http://dec.fazenda.df.gov.br/ConsultarNFCe.aspx", "http://dec.fazenda.df.gov.br/ConsultarNFCe.aspx"
            , "http://dec.fazenda.df.gov.br/NFCE/", "http://dec.fazenda.df.gov.br/NFCE/"),
    GO("GO", "Goi\u00E1s", "52", "http://homolog.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe", "http://nfe.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe"
            , "http://homolog.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe", "http://nfe.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe"),
    ES("ES", "Esp\u00EDrito Santo", "32", "http://homologacao.sefaz.es.gov.br/ConsultaNFCe/qrcode.aspx", "http://app.sefaz.es.gov.br/ConsultaNFCe/qrcode.aspx"
            , "http://homologacao.sefaz.es.gov.br/ConsultaNFCe", "http://app.sefaz.es.gov.br/ConsultaNFCe"),
    MA("MA", "Maranh\u00E3o", "21", "http://www.hom.nfce.sefaz.ma.gov.br/portal/consultarNFCe.jsp", "http://www.nfce.sefaz.ma.gov.br/portal/consultaNFe.do?method=preFilterCupom&"
            , "http://www.hom.nfce.sefaz.ma.gov.br/portal/consultarNFCe.jsp", "http://www.nfce.sefaz.ma.gov.br/portal/consultaNFe.do?method=preFilterCupom&"),
    MT("MT", "Mato Grosso", "51", "http://homologacao.sefaz.mt.gov.br/nfce/consultanfce", "http://www.sefaz.mt.gov.br/nfce/consultanfce"
            , "http://homologacao.sefaz.mt.gov.br/nfce/consultanfce", "http://www.sefaz.mt.gov.br/nfce/consultanfce"),
    MS("MS", "Mato Grosso do Sul", "50", "http://www.dfe.ms.gov.br/nfce/qrcode", "http://www.dfe.ms.gov.br/nfce/qrcode"
            , "http://www.dfe.ms.gov.br/nfce", "http://www.dfe.ms.gov.br/nfce"),
    MG("MG", "Minas Gerais", "31"),
    PA("PA", "Par\u00E1", "15", "https://appnfc.sefa.pa.gov.br/portal-homologacao/view/consultas/nfce/nfceForm.seam", "https://appnfc.sefa.pa.gov.br/portal/view/consultas/nfce/nfceForm.seam"
            , "https://appnfc.sefa.pa.gov.br/portal/view/consultas/nfce/consultanfce.seam", "https://appnfc.sefa.pa.gov.br/portal/view/consultas/nfce/consultanfce.seam"),
    PB("PB", "Paraiba", "25", "http://www.receita.pb.gov.br/nfcehom", "http://www.receita.pb.gov.br/nfce"
            , "http://www.receita.pb.gov.br/nfcehom", "www.receita.pb.gov.br/nfce"),
    PR("PR", "Paran\u00E1", "41", "http://www.fazenda.pr.gov.br/nfce/qrcode", "http://www.fazenda.pr.gov.br/nfce/qrcode"
            , "http://www.fazenda.pr.gov.br", "http://www.fazenda.pr.gov.br"),
    PE("PE", "Pernambuco", "26", "http://nfcehomolog.sefaz.pe.gov.br/nfce-web/consultarNFCe", "http://nfce.sefaz.pe.gov.br/nfce-web/consultarNFCe"
            , "http://nfcehomolog.sefaz.pe.gov.br/nfce/consulta", "http://nfce.sefaz.pe.gov.br/nfce/consulta"),
    PI("PI", "Piau\u00ED", "22", "http://webas.sefaz.pi.gov.br/nfceweb-homologacao/consultarNFCe.jsf", "http://webas.sefaz.pi.gov.br/nfceweb/consultarNFCe.jsf"
            , "http://webas.sefaz.pi.gov.br/nfceweb-homologacao/consultarNFCe.jsf", "http://webas.sefaz.pi.gov.br/nfceweb/consultarNFCe.jsf"),
    RJ("RJ", "Rio de Janeiro", "33", "http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode", "http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode"
            , "www.nfce.fazenda.rj.gov.br/consulta", "www.nfce.fazenda.rj.gov.br/consulta"),
    RN("RN", "Rio Grande do Norte", "24", "http://hom.nfce.set.rn.gov.br/consultarNFCe.aspx", "http://nfce.set.rn.gov.br/consultarNFCe.aspx"
            , "http://nfce.set.rn.gov.br/consultarNFCe.aspx", "http://nfce.set.rn.gov.br/consultarNFCe.aspx"),
    RS("RS", "Rio Grande do Sul", "43", "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx", "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx"
            , "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx", "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx"),
    RO("RO", "Rond\u00F4nia", "11", "http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp", "http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp"
            , "http://www.nfce.sefin.ro.gov.br", "http://www.nfce.sefin.ro.gov.br"),
    RR("RR", "Roraima", "14", "http://200.174.88.103:8080/nfce/servlet/qrcode", "https://www.sefaz.rr.gov.br/nfce/servlet/qrcode"
            , "http://200.174.88.103:8080/nfce/servlet/wp_consulta_nfce", "https://www.sefaz.rr.gov.br/nfce/servlet/wp_consulta_nfce"),
    SP("SP", "S\u00E3o Paulo", "35", "https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx", "https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx"
            , "https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica", "https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica"),
    SC("SC", "Santa Catarina", "42"),
    SE("SE", "Sergipe", "28", "http://www.hom.nfe.se.gov.br/portal/consultarNFCe.jsp", "http://www.nfce.se.gov.br/portal/consultarNFCe.jsp"
            , "http://www.hom.nfe.se.gov.br/portal/portalNoticias.jsp", "http://www.nfce.se.gov.br/portal/portalNoticias.jsp"),
    TO("TO", "Tocantins", "17", null, null
            , "http://homologacao.sefaz.to.gov.br/nfce/consulta.jsf", "http://www.sefaz.to.gov.br/nfce/consulta.jsf"),
    NACIONAL("NC", "Nacional", "90"),
    RFB("RFB", "RFB", "91"),
    EX("EX", "Exterior", "99");

    private final String codigo;
    private final String descricao;
    private final String codigoIbge;
    private final String qrCodeHomologacao;
    private final String qrCodeProducao;
    private final String consultaChaveAcessoHomologacao;
    private final String consultaChaveAcessoProducao;

    DFUnidadeFederativa(final String codigo, final String descricao, final String codigoIbge, String qrCodeHomologacao, String qrCodeProducao, String consultaChaveAcessoHomologacao, String consultaChaveAcessoProducao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.codigoIbge = codigoIbge;
        this.qrCodeHomologacao = qrCodeHomologacao;
        this.qrCodeProducao = qrCodeProducao;
        this.consultaChaveAcessoHomologacao = consultaChaveAcessoHomologacao;
        this.consultaChaveAcessoProducao = consultaChaveAcessoProducao;
    }

    DFUnidadeFederativa(final String codigo, final String descricao, final String codigoIbge) {
        this(codigo, descricao, codigoIbge, null, null, null, null);
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

    public String getConsultaChaveAcessoHomologacao() {
        return consultaChaveAcessoHomologacao;
    }

    public String getConsultaChaveAcessoProducao() {
        return consultaChaveAcessoProducao;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }

    /**
     * Identifica a UF pela sigla ou pelo codigo IBGE.
     *
     * @param codigo Sigla ou codigo IBGE da UF.
     * @return Objeto da UF.
     */
    public static DFUnidadeFederativa valueOfCodigo(final String codigo) {
        for (final DFUnidadeFederativa uf : DFUnidadeFederativa.values()) {
            if (uf.getCodigo().equalsIgnoreCase(codigo)) {
                return uf;
            } else if (uf.getCodigoIbge().equalsIgnoreCase(codigo)) {
                return uf;
            }
        }
        throw new IllegalArgumentException(String.format("N\u00e3o existe o c\u00f3digo %s no mapeamento.", codigo));
    }
}
