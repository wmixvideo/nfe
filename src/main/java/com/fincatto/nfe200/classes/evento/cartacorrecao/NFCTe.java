package com.fincatto.nfe200.classes.evento.cartacorrecao;

import org.simpleframework.xml.Element;

import com.fincatto.nfe200.classes.NFBase;

public class NFCTe extends NFBase {

    @Element(name = "chCTe", required = false)
    private String chaveCTe;

    @Element(name = "modal", required = false)
    private String modal;

    @Element(name = "dhEmi", required = false)
    private String dataHoraEmissao;

    @Element(name = "nProt", required = false)
    private String numeroProtocolo;

    @Element(name = "dhRecbto", required = false)
    private String dataHoraRecebimento;

    public String getChaveCTe() {
        return this.chaveCTe;
    }

    public void setChaveCTe(final String chaveCTe) {
        this.chaveCTe = chaveCTe;
    }

    public String getModal() {
        return this.modal;
    }

    public void setModal(final String modal) {
        this.modal = modal;
    }

    public String getDataHoraEmissao() {
        return this.dataHoraEmissao;
    }

    public void setDataHoraEmissao(final String dataHoraEmissao) {
        this.dataHoraEmissao = dataHoraEmissao;
    }

    public String getNumeroProtocolo() {
        return this.numeroProtocolo;
    }

    public void setNumeroProtocolo(final String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getDataHoraRecebimento() {
        return this.dataHoraRecebimento;
    }

    public void setDataHoraRecebimento(final String dataHoraRecebimento) {
        this.dataHoraRecebimento = dataHoraRecebimento;
    }
}