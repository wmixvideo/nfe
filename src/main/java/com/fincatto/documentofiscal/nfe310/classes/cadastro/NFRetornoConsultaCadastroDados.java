package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NFRetornoConsultaCadastroDados extends DFBase {
    private static final long serialVersionUID = -7130690235919558202L;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Element(name = "verAplic", required = true)
    private String versaoAplicacao;

    @Element(name = "cStat", required = true)
    private String statusResposta;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    @Element(name = "UF", required = false)
    private DFUnidadeFederativa uf;

    @Element(name = "IE", required = false)
    private String inscricaoEstadual;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "dhCons", required = false)
    private String dataHoraProcessamento;

    @Element(name = "cUF", required = true)
    private DFUnidadeFederativa ufAutorizadora;

    @ElementList(inline = true, entry = "infCad", required = false)
    private List<NFRetornoConsultaCadastroSituacaoCadastral> situacaoCadastral;

    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public String getStatusResposta() {
        return this.statusResposta;
    }

    public void setStatusResposta(final String statusResposta) {
        this.statusResposta = statusResposta;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public void setInscricaoEstadual(final String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getDataHoraProcessamento() {
        try {
            return LocalDateTime.parse(this.dataHoraProcessamento, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        } catch (final Exception e) {
            return LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
                    .parse(this.dataHoraProcessamento))
                    .atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
    }

    public void setDataHoraProcessamento(final LocalDateTime dataHoraProcessamento) {
        this.dataHoraProcessamento = NFRetornoConsultaCadastroDados.DATE_FORMATTER.format(dataHoraProcessamento);
    }

    public DFUnidadeFederativa getUfAutorizadora() {
        return this.ufAutorizadora;
    }

    public void setUfAutorizadora(final DFUnidadeFederativa ufAutorizadora) {
        this.ufAutorizadora = ufAutorizadora;
    }

    public List<NFRetornoConsultaCadastroSituacaoCadastral> getSituacaoCadastral() {
        return this.situacaoCadastral;
    }

    public void setSituacaoCadastral(final List<NFRetornoConsultaCadastroSituacaoCadastral> situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }
}