package com.fincatto.documentofiscal.cte400.classes.evento.insucessoentrega;

import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTMotivoInsucesso;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeTipoEvento;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.ZonedDateTime;
import java.util.List;

@Root(name = "evIECTe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeEnviaEventoInsucessoEntrega extends CTeTipoEvento {
    private static final long serialVersionUID = -2597386001460402893L;

    @Element(name = "nProt")
    private String protocoloAutorizacao;

    @Element(name = "dhTentativaEntrega")
    private ZonedDateTime dataHoraTentativaEntrega;

    @Element(name = "nTentativa", required = false)
    private String numeroTentativaEntrega;

    @Element(name = "tpMotivo")
    private CTMotivoInsucesso motivo;

    @Element(name = "xJustMotivo", required = false)
    private String justificativa;

    @Element(name = "latitude", required = false)
    private String latitude;

    @Element(name = "longitude", required = false)
    private String longitude;

    @Element(name = "hashTentativaEntrega")
    private String hashTentativaEntrega;

    @Element(name = "dhHashTentativaEntrega")
    private ZonedDateTime dataHoraTentativaHashEntrega;

    @ElementList(inline = true, required = false)
    private List<CTeInformacaoInsucessoEntrega> entregas;

    public String getProtocoloAutorizacao() {
        return protocoloAutorizacao;
    }

    public void setProtocoloAutorizacao(String protocoloAutorizacao) {
        DFStringValidador.exatamente15N(protocoloAutorizacao, "Protocolo de Autorizacao");
        this.protocoloAutorizacao = protocoloAutorizacao;
    }

    public ZonedDateTime getDataHoraTentativaEntrega() {
        return dataHoraTentativaEntrega;
    }

    public void setDataHoraTentativaEntrega(ZonedDateTime dataHoraTentativaEntrega) {
        this.dataHoraTentativaEntrega = dataHoraTentativaEntrega;
    }

    public String getNumeroTentativaEntrega() {
        return numeroTentativaEntrega;
    }

    public void setNumeroTentativaEntrega(Integer numeroTentativaEntrega) {
        DFIntegerValidador.tamanho3(numeroTentativaEntrega, "Numero da tentativa de entrega");
        this.numeroTentativaEntrega = String.valueOf(numeroTentativaEntrega);
    }

    public CTMotivoInsucesso getMotivo() {
        return motivo;
    }

    public void setMotivo(CTMotivoInsucesso motivo) {
        this.motivo = motivo;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        DFStringValidador.tamanho2ate255(justificativa, "Justificativa");
        this.justificativa = justificativa;
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

    public String getHashTentativaEntrega() {
        return hashTentativaEntrega;
    }

    public void setHashTentativaEntrega(String hashTentativaEntrega) {
        this.hashTentativaEntrega = hashTentativaEntrega;
    }

    public ZonedDateTime getDataHoraTentativaHashEntrega() {
        return dataHoraTentativaHashEntrega;
    }

    public void setDataHoraTentativaHashEntrega(ZonedDateTime dataHoraTentativaHashEntrega) {
        this.dataHoraTentativaHashEntrega = dataHoraTentativaHashEntrega;
    }

    public List<CTeInformacaoInsucessoEntrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<CTeInformacaoInsucessoEntrega> entregas) {
        this.entregas = entregas;
    }
}