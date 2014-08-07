package com.fincatto.nfe.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFModalidadeFrete;
import com.fincatto.nfe.validadores.ListValidador;

public class NFNotaInfoTransporte extends NFBase {
    @Element(name = "modFrete", required = true)
    private NFModalidadeFrete modalidadeFrete;

    @Element(name = "transporta", required = false)
    private NFNotaInfoTransportador transportador;

    @Element(name = "retTransp", required = false)
    private NFNotaInfoRetencaoICMSTransporte icmsTransporte;

    @Element(name = "veicTransp", required = false)
    private NFNotaInfoVeiculo veiculo;

    @ElementList(entry = "reboque", inline = true, required = false)
    private List<NFNotaInfoReboque> reboques;

    @ElementList(entry = "vol", inline = true, required = false)
    private List<NFNotaInfoVolume> volumes;

    public void setModalidadeFrete(final NFModalidadeFrete modalidadeFrete) {
        this.modalidadeFrete = modalidadeFrete;
    }

    public void setTransportador(final NFNotaInfoTransportador transportador) {
        this.transportador = transportador;
    }

    public void setIcmsTransporte(final NFNotaInfoRetencaoICMSTransporte icmsTransporte) {
        this.icmsTransporte = icmsTransporte;
    }

    public void setVeiculo(final NFNotaInfoVeiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setReboques(final List<NFNotaInfoReboque> reboques) {
        ListValidador.tamanho5(reboques);
        this.reboques = reboques;
    }

    public void setVolumes(final List<NFNotaInfoVolume> volumes) {
        this.volumes = volumes;
    }
}