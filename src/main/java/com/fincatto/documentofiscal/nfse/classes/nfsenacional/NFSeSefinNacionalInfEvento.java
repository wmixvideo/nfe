
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.time.ZonedDateTime;

/**
 * <p>Java class for TCInfEvento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfEvento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="verAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSVerAplic" minOccurs="0"/&gt;
 *         &lt;element name="ambGer" type="{http://www.sped.fazenda.gov.br/nfse}TSAmbGeradorEvt"/&gt;
 *         &lt;element name="nSeqEvento" type="{http://www.sped.fazenda.gov.br/nfse}TSNum3Dig"/&gt;
 *         &lt;element name="dhProc" type="{http://www.sped.fazenda.gov.br/nfse}TSDateTimeUTC"/&gt;
 *         &lt;element name="nDFe" type="{http://www.sped.fazenda.gov.br/nfse}TSNumDFe"/&gt;
 *         &lt;element name="pedRegEvento" type="{http://www.sped.fazenda.gov.br/nfse}TCPedRegEvt"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.sped.fazenda.gov.br/nfse}TSIdEvento" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "infEvento")
public class NFSeSefinNacionalInfEvento {

    @Element(name = "verAplic", required = false)
    protected String versaoApp;
    @Element(name = "ambGer")
    protected NFSeSefinNacionalInfEventoAmbienteGeracao ambienteGeracao;
    @Element(name = "nSeqEvento")
    protected String numeroSequencialEvento;
    @Element(name = "dhProc")
    protected ZonedDateTime dataHoraProcessamento;
    @Element(name = "nDFe")
    protected String numeroDFe;
    @Element(name = "pedRegEvento")
    protected NFSeSefinNacionalPedRegEvt pedidoRegistroEvento;
    @Attribute(name = "Id")
    protected String id;

    public String getVersaoApp() {
        return versaoApp;
    }

    public void setVersaoApp(String value) {
        this.versaoApp = value;
    }

    public NFSeSefinNacionalInfEventoAmbienteGeracao getAmbienteGeracao() {
        return ambienteGeracao;
    }

    public void setAmbienteGeracao(NFSeSefinNacionalInfEventoAmbienteGeracao value) {
        this.ambienteGeracao = value;
    }

    public String getNumeroSequencialEvento() {
        return numeroSequencialEvento;
    }

    public void setNumeroSequencialEvento(String numeroSequencialEvento) {
        this.numeroSequencialEvento = numeroSequencialEvento;
    }

    public ZonedDateTime getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public void setDataHoraProcessamento(ZonedDateTime value) {
        this.dataHoraProcessamento = value;
    }

    public String getNumeroDFe() {
        return numeroDFe;
    }

    public void setNumeroDFe(String numeroDFe) {
        this.numeroDFe = numeroDFe;
    }

    public NFSeSefinNacionalPedRegEvt getPedidoRegistroEvento() {
        return pedidoRegistroEvento;
    }

    public void setPedidoRegistroEvento(NFSeSefinNacionalPedRegEvt pedidoRegistroEvento) {
        this.pedidoRegistroEvento = pedidoRegistroEvento;
    }

    public String getId() {
        return id;
    }

    /**
     * Identificador do evento: "EVT" + Chave de acesso(50) Tipo do evento (6) + Pedido de Registro do Evento(3) (nPedRegEvento)
     * @param value
     */
    public void setId(String value) {
        this.id = value;
    }

}
