package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import java.time.LocalDateTime;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
public class MDFeEnviaEventoRegistroPassagemAutomaticaInfPass extends DFBase {
    private static final long serialVersionUID = -3989416092815377178L;

    @Element(name = "cUFTransito")
    private DFUnidadeFederativa ufTransito;

    @Element(name = "cIdEquip")
    private String idEquipamento;

    @Element(name = "xIdEquip")
    private String nomeEquipamento;

    @Element(name = "tpEquip")
    private String tipoEquipamento;

    @Element(name = "placa")
    private String placa;

    @Element(name = "tpSentido")
    private String tipoSentido;

    @Element(name = "dhPass")
    private LocalDateTime dataHoraPassagem;

    @Element(name = "latitude")
    private String latitude;

    @Element(name = "longitude")
    private String longitude;

    @Element(name = "NSU")
    private String nsu;

    public DFUnidadeFederativa getUfTransito() {
        return this.ufTransito;
    }

    public void setUfTransito(final DFUnidadeFederativa ufTransito) {
        this.ufTransito = ufTransito;
    }

    public String getIdEquipamento() {
        return this.idEquipamento;
    }

    public void setIdEquipamento(final String idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNomeEquipamento() {
        return this.nomeEquipamento;
    }

    public void setNomeEquipamento(final String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public String getTipoEquipamento() {
        return this.tipoEquipamento;
    }

    public void setTipoEquipamento(final String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(final String placa) {
        this.placa = placa;
    }

    public String getTipoSentido() {
        return this.tipoSentido;
    }

    public void setTipoSentido(final String tipoSentido) {
        this.tipoSentido = tipoSentido;
    }

    public LocalDateTime getDataHoraPassagem() {
        return this.dataHoraPassagem;
    }

    public void setDataHoraPassagem(final LocalDateTime dataHoraPassagem) {
        this.dataHoraPassagem = dataHoraPassagem;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(final String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(final String longitude) {
        this.longitude = longitude;
    }

    public String getNsu() {
        return this.nsu;
    }

    public void setNsu(final String nsu) {
        this.nsu = nsu;
    }
}
