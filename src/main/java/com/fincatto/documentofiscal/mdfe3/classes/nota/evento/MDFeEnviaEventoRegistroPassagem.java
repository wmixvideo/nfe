package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;

import java.time.LocalDateTime;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
public class MDFeEnviaEventoRegistroPassagem extends DFBase {
    private static final long serialVersionUID = 2562978821969093169L;

    @Element(name = "descEvento")
    private String descricaoEvento;

    @Element(name = "cUFTransito")
    private String ufTransito;

    @Element(name = "cUnidFiscal")
    private String codigoUnidadeFiscal;

    @Element(name = "xUnidFiscal")
    private String descricaoUnidadeFiscal;

    @Element(name = "dhPass")
    private LocalDateTime dataHoraPassagem;

    @Element(name = "CPFFunc")
    private String cpfFuncionario;

    @Element(name = "xFunc")
    private String nomeFuncionario;

    @Element(name = "tpTransm")
    private String tpTransm;

    @Element(name = "tpSentido")
    private String tipoSentido;

    @Element(name = "placa")
    private String placa;

    @Element(name = "xObs", required = false)
    private String observacao;

    public String getDescricaoEvento() {
        return this.descricaoEvento;
    }

    public void setDescricaoEvento(final String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getUfTransito() {
        return this.ufTransito;
    }

    public void setUfTransito(final String ufTransito) {
        this.ufTransito = ufTransito;
    }

    public String getCodigoUnidadeFiscal() {
        return this.codigoUnidadeFiscal;
    }

    public void setCodigoUnidadeFiscal(final String codigoUnidadeFiscal) {
        this.codigoUnidadeFiscal = codigoUnidadeFiscal;
    }

    public String getDescricaoUnidadeFiscal() {
        return this.descricaoUnidadeFiscal;
    }

    public void setDescricaoUnidadeFiscal(final String descricaoUnidadeFiscal) {
        this.descricaoUnidadeFiscal = descricaoUnidadeFiscal;
    }

    public LocalDateTime getDataHoraPassagem() {
        return this.dataHoraPassagem;
    }

    public void setDataHoraPassagem(final LocalDateTime dataHoraPassagem) {
        this.dataHoraPassagem = dataHoraPassagem;
    }

    public String getCpfFuncionario() {
        return this.cpfFuncionario;
    }

    public void setCpfFuncionario(final String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getNomeFuncionario() {
        return this.nomeFuncionario;
    }

    public void setNomeFuncionario(final String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getTpTransm() {
        return this.tpTransm;
    }

    public void setTpTransm(final String tpTransm) {
        this.tpTransm = tpTransm;
    }

    public String getTipoSentido() {
        return this.tipoSentido;
    }

    public void setTipoSentido(final String tipoSentido) {
        this.tipoSentido = tipoSentido;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(final String placa) {
        this.placa = placa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
