package com.fincatto.documentofiscal.cte300.classes.evento.comprovanteentrega;

import com.fincatto.documentofiscal.cte300.classes.evento.CTeTipoEvento;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.ZonedDateTime;
import java.util.List;

@Root(name = "evCECTe")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeEnviaEventoComprovanteEntrega extends CTeTipoEvento {
    private static final long serialVersionUID = -5488904753372508623L;

    @Element(name = "nProt")
    private String protocoloAutorizacao;

    @Element(name = "dhEntrega")
    private ZonedDateTime dataHoraEntrega;

    @Element(name = "nDoc")
    private String documentoRecebedor;

    @Element(name = "xNome")
    private String nomeRecebedor;

    @Element(name = "latitude", required = false)
    private String latitude;

    @Element(name = "longitude", required = false)
    private String longitude;

    @Element(name = "hashEntrega")
    private String hashEntrega;

    @Element(name = "dhHashEntrega")
    private ZonedDateTime dataHoraHashEntrega;

    @ElementList(inline = true, required = false)
    private List<CTeInformacaoComprovanteEntrega> entregas;

    public String getProtocoloAutorizacao() {
        return protocoloAutorizacao;
    }

    public void setProtocoloAutorizacao(String protocoloAutorizacao) {
        DFStringValidador.exatamente15N(protocoloAutorizacao, "Protocolo de Autorizacao");
        this.protocoloAutorizacao = protocoloAutorizacao;
    }

    public ZonedDateTime getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(ZonedDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public String getDocumentoRecebedor() {
        return documentoRecebedor;
    }

    public void setDocumentoRecebedor(String documentoRecebedor) {
        DFStringValidador.tamanho20(documentoRecebedor, "Documento Recebedor");
        this.documentoRecebedor = documentoRecebedor;
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public void setNomeRecebedor(String nomeRecebedor) {
        DFStringValidador.tamanho2ate60(nomeRecebedor, "Nome Recebedor");
        this.nomeRecebedor = nomeRecebedor;
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

    public String getHashEntrega() {
        return hashEntrega;
    }

    public void setHashEntrega(String hashEntrega) {
        this.hashEntrega = hashEntrega;
    }

    public ZonedDateTime getDataHoraHashEntrega() {
        return dataHoraHashEntrega;
    }

    public void setDataHoraHashEntrega(ZonedDateTime dataHoraHashEntrega) {
        this.dataHoraHashEntrega = dataHoraHashEntrega;
    }

    public List<CTeInformacaoComprovanteEntrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<CTeInformacaoComprovanteEntrega> entregas) {
        this.entregas = entregas;
    }
}