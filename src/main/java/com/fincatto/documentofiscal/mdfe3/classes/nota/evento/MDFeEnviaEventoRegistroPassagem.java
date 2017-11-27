package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import com.fincatto.documentofiscal.DFBase;
import org.joda.time.LocalDateTime;
import org.simpleframework.xml.Element;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
public class MDFeEnviaEventoRegistroPassagem extends DFBase{

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

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getUfTransito() {
        return ufTransito;
    }

    public void setUfTransito(String ufTransito) {
        this.ufTransito = ufTransito;
    }

    public String getCodigoUnidadeFiscal() {
        return codigoUnidadeFiscal;
    }

    public void setCodigoUnidadeFiscal(String codigoUnidadeFiscal) {
        this.codigoUnidadeFiscal = codigoUnidadeFiscal;
    }

    public String getDescricaoUnidadeFiscal() {
        return descricaoUnidadeFiscal;
    }

    public void setDescricaoUnidadeFiscal(String descricaoUnidadeFiscal) {
        this.descricaoUnidadeFiscal = descricaoUnidadeFiscal;
    }

    public LocalDateTime getDataHoraPassagem() {
        return dataHoraPassagem;
    }

    public void setDataHoraPassagem(LocalDateTime dataHoraPassagem) {
        this.dataHoraPassagem = dataHoraPassagem;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getTpTransm() {
        return tpTransm;
    }

    public void setTpTransm(String tpTransm) {
        this.tpTransm = tpTransm;
    }

    public String getTipoSentido() {
        return tipoSentido;
    }

    public void setTipoSentido(String tipoSentido) {
        this.tipoSentido = tipoSentido;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
