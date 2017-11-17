package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.joda.time.LocalDateTime;
import org.simpleframework.xml.Element;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
public class MDFeEnviaEventoRegistroPassagemAutomaticaInfPass extends DFBase{

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
        return ufTransito;
    }

    public void setUfTransito(DFUnidadeFederativa ufTransito) {
        this.ufTransito = ufTransito;
    }

    public String getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(String idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoSentido() {
        return tipoSentido;
    }

    public void setTipoSentido(String tipoSentido) {
        this.tipoSentido = tipoSentido;
    }

    public LocalDateTime getDataHoraPassagem() {
        return dataHoraPassagem;
    }

    public void setDataHoraPassagem(LocalDateTime dataHoraPassagem) {
        this.dataHoraPassagem = dataHoraPassagem;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }
}
