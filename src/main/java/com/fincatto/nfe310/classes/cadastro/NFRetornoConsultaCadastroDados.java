package com.fincatto.nfe310.classes.cadastro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

public class NFRetornoConsultaCadastroDados extends NFBase {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    @Element(name = "verAplic", required = true)
    private String versaoAplicacao;

    @Element(name = "cStat", required = true)
    private String statusResposta;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    @Element(name = "UF", required = false)
    private NFUnidadeFederativa uf;

    @Element(name = "IE", required = false)
    private String inscricaoEstadual;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "dhCons", required = false)
    private String dataHoraProcessamento;

    @Element(name = "cUF", required = true)
    private NFUnidadeFederativa ufAutorizadora;

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

    public NFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final NFUnidadeFederativa uf) {
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
            return LocalDateTime.fromDateFields(NFRetornoConsultaCadastroDados.DATE_FORMATTER.parse(this.dataHoraProcessamento));
        } catch (final ParseException e) {
            throw new IllegalStateException("Houve um problema em parsear a data");
        }
    }

    public void setDataHoraProcessamento(final LocalDateTime dataHoraProcessamento) {
        this.dataHoraProcessamento = NFRetornoConsultaCadastroDados.DATE_FORMATTER.format(dataHoraProcessamento.toDate());
    }

    public NFUnidadeFederativa getUfAutorizadora() {
        return this.ufAutorizadora;
    }

    public void setUfAutorizadora(final NFUnidadeFederativa ufAutorizadora) {
        this.ufAutorizadora = ufAutorizadora;
    }

    public List<NFRetornoConsultaCadastroSituacaoCadastral> getSituacaoCadastral() {
        return this.situacaoCadastral;
    }

    public void setSituacaoCadastral(final List<NFRetornoConsultaCadastroSituacaoCadastral> situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }
}