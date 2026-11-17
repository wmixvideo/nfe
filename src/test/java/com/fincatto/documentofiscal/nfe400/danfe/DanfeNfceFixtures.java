package com.fincatto.documentofiscal.nfe400.danfe;

import java.util.ArrayList;
import java.util.List;

/**
 * XML de NFC-e (modelo 65) fiticio e deterministico para os testes do cupom; cada teste ajusta so o que precisa.
 *
 * @author Marcos Lombardi de Andrade
 */
public final class DanfeNfceFixtures {

    static final String CHAVE = "41261011222333000181650010000000361608043464";
    static final String CHAVE_FORMATADA = "4126 1011 2223 3300 0181 6500 1000 0000 3616 0804 3464";
    static final String QR_CODE = "https://www.fazenda.pr.gov.br/nfce/qrcode?p=" + CHAVE + "|2|1|1|ABCDEF0123456789ABCDEF0123456789ABCDEF01";
    static final String URL_CONSULTA = "https://www.fazenda.pr.gov.br/nfce/consulta";

    private DanfeNfceFixtures() {
    }

    public static Builder nfce() {
        return new Builder();
    }

    /** NFC-e com 3 itens (14 unidades), desconto de 1,10, pagamento em PIX, sem consumidor identificado. */
    public static String xml() {
        return nfce().build();
    }

    /**
     * Monta o XML da NFC-e com valores padrao; cada metodo ajusta um aspecto da nota.
     *
     * @author Marcos Lombardi de Andrade
     */
    public static final class Builder {
        private String modelo = "65";
        private String ambiente = "1";
        private String tipoEmissao = "1";
        private boolean comProtocolo = true;
        private boolean comQrCode = true;
        private String destinatario = "";
        private String desconto = "1.10";
        private String outrasDespesas = "";
        private String troco = "";
        private String infCpl = "Tributos aprox.: R$ 11,85 federal, R$ 17,01 estadual. Fonte: IBPT.";
        private String infAdFisco = "";
        private final List<String[]> itens = new ArrayList<>();
        private final List<String[]> pagamentos = new ArrayList<>();
        private boolean itensPadrao = true;
        private boolean pagamentoPadrao = true;

        public Builder modelo(final String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Builder ambiente(final String ambiente) {
            this.ambiente = ambiente;
            return this;
        }

        public Builder tipoEmissao(final String tipoEmissao) {
            this.tipoEmissao = tipoEmissao;
            return this;
        }

        public Builder semProtocolo() {
            this.comProtocolo = false;
            return this;
        }

        public Builder semQrCode() {
            this.comQrCode = false;
            return this;
        }

        /** Trecho XML do grupo {@code dest}, por exemplo {@code <dest><CPF>12345678909</CPF></dest>}. */
        public Builder destinatario(final String destXml) {
            this.destinatario = destXml;
            return this;
        }

        /** Valor do desconto no XML ({@code "0.00"} ou vazio para nao informar). */
        public Builder desconto(final String desconto) {
            this.desconto = desconto;
            return this;
        }

        public Builder outrasDespesas(final String outrasDespesas) {
            this.outrasDespesas = outrasDespesas;
            return this;
        }

        public Builder troco(final String troco) {
            this.troco = troco;
            return this;
        }

        public Builder infCpl(final String infCpl) {
            this.infCpl = infCpl;
            return this;
        }

        public Builder infAdFisco(final String infAdFisco) {
            this.infAdFisco = infAdFisco;
            return this;
        }

        /** Substitui os itens padrao; cada item e {codigo, descricao, quantidade, unidade, valorUnitario, valorTotal}. */
        public Builder item(final String codigo, final String descricao, final String quantidade, final String unidade, final String valorUnitario, final String valorTotal) {
            if (this.itensPadrao) {
                this.itens.clear();
                this.itensPadrao = false;
            }
            this.itens.add(new String[]{codigo, descricao, quantidade, unidade, valorUnitario, valorTotal});
            return this;
        }

        /** Substitui o pagamento padrao; meio no formato do XML (tPag) e valor. */
        public Builder pagamento(final String meio, final String valor) {
            if (this.pagamentoPadrao) {
                this.pagamentos.clear();
                this.pagamentoPadrao = false;
            }
            this.pagamentos.add(new String[]{meio, valor});
            return this;
        }

        /** N itens iguais, de 1 un a 2,00 (codigo "ITEM0001", "ITEM0002"...). */
        public Builder itens(final int quantidade) {
            this.itens.clear();
            this.itensPadrao = false;
            for (int i = 1; i <= quantidade; i++) {
                this.itens.add(new String[]{String.format("ITEM%04d", i), "Produto de teste " + i, "1.0000", "UN", "2.0000", "2.00"});
            }
            return this;
        }

        public String build() {
            final List<String[]> lista = this.itens.isEmpty() && this.itensPadrao ? padrao() : this.itens;
            final List<String[]> pagos = this.pagamentos.isEmpty() && this.pagamentoPadrao ? java.util.Collections.singletonList(new String[]{"17", "79.90"}) : this.pagamentos;
            final StringBuilder dets = new StringBuilder();
            double total = 0;
            for (int i = 0; i < lista.size(); i++) {
                final String[] item = lista.get(i);
                total += Double.parseDouble(item[5]);
                dets.append("<det nItem=\"").append(i + 1).append("\"><prod><cProd>").append(item[0]).append("</cProd><cEAN>SEM GTIN</cEAN><xProd>")
                        .append(item[1]).append("</xProd><NCM>22021000</NCM><CFOP>5102</CFOP><uCom>").append(item[3]).append("</uCom><qCom>")
                        .append(item[2]).append("</qCom><vUnCom>").append(item[4]).append("</vUnCom><vProd>").append(item[5])
                        .append("</vProd><cEANTrib>SEM GTIN</cEANTrib><uTrib>").append(item[3]).append("</uTrib><qTrib>").append(item[2])
                        .append("</qTrib><vUnTrib>").append(item[4]).append("</vUnTrib><indTot>1</indTot></prod>")
                        .append("<imposto><ICMS><ICMSSN102><orig>0</orig><CSOSN>102</CSOSN></ICMSSN102></ICMS>")
                        .append("<PIS><PISNT><CST>07</CST></PISNT></PIS><COFINS><COFINSNT><CST>07</CST></COFINSNT></COFINS></imposto></det>");
            }
            final double desc = this.desconto.isEmpty() ? 0 : Double.parseDouble(this.desconto);
            final double outros = this.outrasDespesas.isEmpty() ? 0 : Double.parseDouble(this.outrasDespesas);
            final String valorNota = String.format(java.util.Locale.US, "%.2f", total - desc + outros);
            final StringBuilder pag = new StringBuilder();
            if (!pagos.isEmpty()) {
                pag.append("<pag>");
                for (final String[] p : pagos) {
                    pag.append("<detPag><indPag>0</indPag><tPag>").append(p[0]).append("</tPag><vPag>").append(p[1]).append("</vPag></detPag>");
                }
                if (!this.troco.isEmpty()) {
                    pag.append("<vTroco>").append(this.troco).append("</vTroco>");
                }
                pag.append("</pag>");
            }
            final String adicionais = (this.infAdFisco.isEmpty() ? "" : "<infAdFisco>" + this.infAdFisco + "</infAdFisco>")
                    + (this.infCpl.isEmpty() ? "" : "<infCpl>" + this.infCpl + "</infCpl>");
            final String suplementar = this.comQrCode ? "<infNFeSupl><qrCode><![CDATA[" + QR_CODE + "]]></qrCode><urlChave>" + URL_CONSULTA + "</urlChave></infNFeSupl>" : "";
            final String protocolo = this.comProtocolo
                    ? "<protNFe versao=\"4.00\"><infProt><tpAmb>" + this.ambiente + "</tpAmb><verAplic>PR-v4_0</verAplic><chNFe>" + CHAVE
                    + "</chNFe><dhRecbto>2026-08-14T17:47:08-03:00</dhRecbto><nProt>131261940757601</nProt><digVal>abc</digVal><cStat>100</cStat>"
                    + "<xMotivo>Autorizado o uso da NF-e</xMotivo></infProt></protNFe>"
                    : "";
            final String nfe = "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"><infNFe Id=\"NFe" + CHAVE + "\" versao=\"4.00\">"
                    + "<ide><cUF>41</cUF><cNF>60804346</cNF><natOp>Venda</natOp><mod>" + this.modelo + "</mod><serie>2</serie><nNF>36</nNF>"
                    + "<dhEmi>2026-08-14T17:47:06-03:00</dhEmi><tpNF>1</tpNF><idDest>1</idDest><cMunFG>4106902</cMunFG><tpImp>4</tpImp>"
                    + "<tpEmis>" + this.tipoEmissao + "</tpEmis><cDV>4</cDV><tpAmb>" + this.ambiente + "</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal>"
                    + "<indPres>1</indPres><procEmi>0</procEmi><verProc>1.0</verProc></ide>"
                    + "<emit><CNPJ>11222333000181</CNPJ><xNome>EMPRESA EXEMPLO COMERCIO LTDA</xNome><enderEmit><xLgr>RUA DAS PALMEIRAS</xLgr><nro>1500</nro>"
                    + "<xBairro>CENTRO</xBairro><cMun>4106902</cMun><xMun>CURITIBA</xMun><UF>PR</UF><CEP>80010000</CEP><cPais>1058</cPais><xPais>BRASIL</xPais></enderEmit>"
                    + "<IE>1234567890</IE><CRT>1</CRT></emit>"
                    + this.destinatario + dets
                    + "<total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vICMSDeson>0.00</vICMSDeson><vFCP>0.00</vFCP><vBCST>0.00</vBCST><vST>0.00</vST>"
                    + "<vFCPST>0.00</vFCPST><vFCPSTRet>0.00</vFCPSTRet><vProd>" + String.format(java.util.Locale.US, "%.2f", total) + "</vProd><vFrete>0.00</vFrete>"
                    + "<vSeg>0.00</vSeg><vDesc>" + (this.desconto.isEmpty() ? "0.00" : this.desconto) + "</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vIPIDevol>0.00</vIPIDevol>"
                    + "<vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>" + (this.outrasDespesas.isEmpty() ? "0.00" : this.outrasDespesas) + "</vOutro><vNF>" + valorNota
                    + "</vNF></ICMSTot></total><transp><modFrete>9</modFrete></transp>" + pag
                    + (adicionais.isEmpty() ? "" : "<infAdic>" + adicionais + "</infAdic>")
                    + "</infNFe>" + suplementar + "</NFe>";
            return this.comProtocolo ? "<nfeProc versao=\"4.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">" + nfe.replace(" xmlns=\"http://www.portalfiscal.inf.br/nfe\"", "") + protocolo + "</nfeProc>" : nfe;
        }

        private static List<String[]> padrao() {
            final List<String[]> lista = new ArrayList<>();
            lista.add(new String[]{"7894900681017", "SPRITE ORIGINAL LT350ML", "1.0000", "UN", "6.0000", "6.00"});
            lista.add(new String[]{"17898368380151", "PICOLE CHOCOLATE SUICO", "3.0000", "UN", "4.0000", "12.00"});
            lista.add(new String[]{"21", "MACARRAO NA CHAPA", "10.0000", "UN", "6.3000", "63.00"});
            return lista;
        }
    }
}
