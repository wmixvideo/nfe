package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "infNFe")
public class CTInfoDocumentoNFE extends DFBase {
    private static final long serialVersionUID = 3996548074758272722L;

    @Element(name = "chave")
    private String chave;

    @Element(name = "PIN", required = false)
    private String pin;

    @Element(name = "dPrev", required = false)
    private LocalDate dataPrevisaoEntrega;

    @ElementList(name = "infUnidTransp", inline = true, required = false)
    private List<CTInfoDocumentoNFUnidTransp> unidadesTransporte;

    @ElementList(name = "infUnidCarga", inline = true, required = false)
    private List<CTInfoDocumentoNFUnidadeCarga> unidadesCarga;

    public String getChave() {
        return this.chave;
    }

    public void setChave(final String chave) {
        this.chave = chave;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(final String pin) {
        this.pin = pin;
    }

    public LocalDate getDataPrevisaoEntrega() {
        return this.dataPrevisaoEntrega;
    }

    public void setDataPrevisaoEntrega(final LocalDate dataPrevisaoEntrega) {
        this.dataPrevisaoEntrega = dataPrevisaoEntrega;
    }

    public List<CTInfoDocumentoNFUnidTransp> getUnidadesTransporte() {
        return this.unidadesTransporte;
    }

    public void setUnidadesTransporte(final List<CTInfoDocumentoNFUnidTransp> unidadesTransporte) {
        this.unidadesTransporte = unidadesTransporte;
    }

    public List<CTInfoDocumentoNFUnidadeCarga> getUnidadesCarga() {
        return this.unidadesCarga;
    }

    public void setUnidadesCarga(final List<CTInfoDocumentoNFUnidadeCarga> unidadesCarga) {
        this.unidadesCarga = unidadesCarga;
    }

}
