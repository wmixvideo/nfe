package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.NFIndicadorFormaPagamento;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFMeioPagamento;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFOperadoraCartao;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

/**
 * Detalhamento de um pagamento do evento de Conciliação Financeira (ECONF).
 * <p>
 * Os grupos abaixo são opcionais, mas a biblioteca não valida a combinação dos campos. O XML só é aceito
 * pelo XSD se forem respeitadas estas regras:
 * <ul>
 * <li>{@code CNPJPag} e {@code UFPag} devem ser informados juntos;</li>
 * <li>{@code CNPJIF}, {@code tBand} e {@code cAut} só podem ser informados junto com {@code CNPJPag} e
 * {@code UFPag};</li>
 * <li>{@code CNPJReceb} e {@code UFReceb} devem ser informados juntos.</li>
 * </ul>
 */
public class NFDetPagEconf extends DFBase {
    private static final long serialVersionUID = 4821573906412187345L;

    @Element(name = "indPag", required = false)
    private NFIndicadorFormaPagamento indicadorFormaPagamento;

    @Element(name = "tPag")
    private NFMeioPagamento meioPagamento;

    @Element(name = "xPag", required = false)
    private String descricaoMeioPagamento;

    @Element(name = "vPag")
    private String valorPagamento;

    @Element(name = "dPag")
    private LocalDate dataPagamento;

    @Element(name = "CNPJPag", required = false)
    private String cnpjTransacionalPagamento;

    @Element(name = "UFPag", required = false)
    private String ufTransacionalPagamento;

    @Element(name = "CNPJIF", required = false)
    private String cnpjInstituicaoFinanceira;

    @Element(name = "tBand", required = false)
    private NFOperadoraCartao operadoraCartao;

    @Element(name = "cAut", required = false)
    private String numeroAutorizacao;

    @Element(name = "CNPJReceb", required = false)
    private String cnpjBeneficiarioPagamento;

    @Element(name = "UFReceb", required = false)
    private String ufBeneficiarioPagamento;

    public NFIndicadorFormaPagamento getIndicadorFormaPagamento() {
        return this.indicadorFormaPagamento;
    }

    public NFDetPagEconf setIndicadorFormaPagamento(final NFIndicadorFormaPagamento indicadorFormaPagamento) {
        this.indicadorFormaPagamento = indicadorFormaPagamento;
        return this;
    }

    public NFMeioPagamento getMeioPagamento() {
        return this.meioPagamento;
    }

    public NFDetPagEconf setMeioPagamento(final NFMeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
        return this;
    }

    public String getDescricaoMeioPagamento() {
        return this.descricaoMeioPagamento;
    }

    public NFDetPagEconf setDescricaoMeioPagamento(final String descricaoMeioPagamento) {
        DFStringValidador.tamanho2ate60(descricaoMeioPagamento, "Descricao Meio Pagamento");
        this.descricaoMeioPagamento = descricaoMeioPagamento;
        return this;
    }

    public String getValorPagamento() {
        return this.valorPagamento;
    }

    public NFDetPagEconf setValorPagamento(final BigDecimal valorPagamento) {
        this.valorPagamento = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorPagamento, "Valor Pagamento");
        return this;
    }

    public LocalDate getDataPagamento() {
        return this.dataPagamento;
    }

    public NFDetPagEconf setDataPagamento(final LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
        return this;
    }

    public String getCnpjTransacionalPagamento() {
        return this.cnpjTransacionalPagamento;
    }

    public NFDetPagEconf setCnpjTransacionalPagamento(final String cnpjTransacionalPagamento) {
        this.cnpjTransacionalPagamento = DFStringValidador.cnpj(cnpjTransacionalPagamento, "CNPJ Transacional Pagamento");
        return this;
    }

    public String getUfTransacionalPagamento() {
        return this.ufTransacionalPagamento;
    }

    public NFDetPagEconf setUfTransacionalPagamento(final DFUnidadeFederativa ufTransacionalPagamento) {
        this.ufTransacionalPagamento = NFDetPagEconf.validaUf(ufTransacionalPagamento, "UF do Pagamento");
        return this;
    }

    public String getCnpjInstituicaoFinanceira() {
        return this.cnpjInstituicaoFinanceira;
    }

    public NFDetPagEconf setCnpjInstituicaoFinanceira(final String cnpjInstituicaoFinanceira) {
        this.cnpjInstituicaoFinanceira = DFStringValidador.cnpj(cnpjInstituicaoFinanceira, "CNPJ Instituicao Financeira");
        return this;
    }

    public NFOperadoraCartao getOperadoraCartao() {
        return this.operadoraCartao;
    }

    public NFDetPagEconf setOperadoraCartao(final NFOperadoraCartao operadoraCartao) {
        this.operadoraCartao = operadoraCartao;
        return this;
    }

    public String getNumeroAutorizacao() {
        return this.numeroAutorizacao;
    }

    public NFDetPagEconf setNumeroAutorizacao(final String numeroAutorizacao) {
        DFStringValidador.tamanho128(numeroAutorizacao, "Numero Autorizacao");
        this.numeroAutorizacao = numeroAutorizacao;
        return this;
    }

    public String getCnpjBeneficiarioPagamento() {
        return this.cnpjBeneficiarioPagamento;
    }

    public NFDetPagEconf setCnpjBeneficiarioPagamento(final String cnpjBeneficiarioPagamento) {
        this.cnpjBeneficiarioPagamento = DFStringValidador.cnpj(cnpjBeneficiarioPagamento, "CNPJ Beneficiario Pagamento");
        return this;
    }

    public String getUfBeneficiarioPagamento() {
        return this.ufBeneficiarioPagamento;
    }

    public NFDetPagEconf setUfBeneficiarioPagamento(final DFUnidadeFederativa ufBeneficiarioPagamento) {
        this.ufBeneficiarioPagamento = NFDetPagEconf.validaUf(ufBeneficiarioPagamento, "UF do Beneficiario");
        return this;
    }

    /**
     * O tipo TUfEmi do XSD aceita apenas as 27 UFs. NC, RFB, BRId e EX (código IBGE a partir de 90) são rejeitados.
     */
    private static String validaUf(final DFUnidadeFederativa uf, final String info) {
        if (uf == null) {
            return null;
        }
        if (Integer.parseInt(uf.getCodigoIbge()) >= 90) {
            throw new IllegalArgumentException(String.format("%s deve ser uma das 27 UFs: %s", info, uf.getCodigo()));
        }
        return uf.getCodigo();
    }
}
