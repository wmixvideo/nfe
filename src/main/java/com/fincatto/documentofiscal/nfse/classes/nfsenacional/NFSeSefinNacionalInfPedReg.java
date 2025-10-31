
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.time.ZonedDateTime;

@Root(name = "infPedReg")
public class NFSeSefinNacionalInfPedReg {

    @Element(name = "tpAmb")
    protected NFSeSefinNacionalTipoAmbiente tpAmb;
    @Element(name = "verAplic")
    protected String verAplic;
    @Element(name = "dhEvento")
    protected ZonedDateTime dhEvento;
    @Element(name = "CNPJAutor", required = false)
    protected String cnpjAutor;
    @Element(name = "CPFAutor", required = false)
    protected String cpfAutor;
    @Element(name = "chNFSe")
    protected String chaveAcessoNFSE;
    @Element(name = "nPedRegEvento")
    protected String numeroPedidoRegistroEvento;
    @Attribute(name = "Id")
    protected String id;

    @ElementUnion({
            @Element(name="e101101", type=NFSeSefinNacionalInfPedRegTE101101.class),
            @Element(name="e105102", type=NFSeSefinNacionalInfPedRegTE105102.class),
            @Element(name="e101103", type=NFSeSefinNacionalInfPedRegTE101103.class),
            @Element(name="e105104", type=NFSeSefinNacionalInfPedRegTE105104.class),
            @Element(name="e105105", type=NFSeSefinNacionalInfPedRegTE105105.class),
            @Element(name="e202201", type=NFSeSefinNacionalInfPedRegTE202201.class),
            @Element(name="e203202", type=NFSeSefinNacionalInfPedRegTE203202.class),
            @Element(name="e204203", type=NFSeSefinNacionalInfPedRegTE204203.class),
            @Element(name="e205204", type=NFSeSefinNacionalInfPedRegTE205204.class),
            @Element(name="e202205", type=NFSeSefinNacionalInfPedRegTE202205.class),
            @Element(name="e203206", type=NFSeSefinNacionalInfPedRegTE203206.class),
            @Element(name="e204207", type=NFSeSefinNacionalInfPedRegTE204207.class),
            @Element(name="e205208", type=NFSeSefinNacionalInfPedRegTE205208.class),
            @Element(name="e305101", type=NFSeSefinNacionalInfPedRegTE305101.class),
            @Element(name="e305102", type=NFSeSefinNacionalInfPedRegTE305102.class),
            @Element(name="e305103", type=NFSeSefinNacionalInfPedRegTE305103.class),
    })
    protected NFSeSefinNacionalInfPedRegEventoTE evento;

    public NFSeSefinNacionalTipoAmbiente getTpAmb() {
        return tpAmb;
    }

    public NFSeSefinNacionalInfPedReg setTpAmb(NFSeSefinNacionalTipoAmbiente value) {
        this.tpAmb = value;
        return this;
    }

    public String getVerAplic() {
        return verAplic;
    }

    public NFSeSefinNacionalInfPedReg setVerAplic(String value) {
        this.verAplic = value;
        return this;
    }

    public ZonedDateTime getDhEvento() {
        return dhEvento;
    }

    public NFSeSefinNacionalInfPedReg setDhEvento(ZonedDateTime value) {
        this.dhEvento = value;
        return this;
    }

    public String getCNPJAutor() {
        return cnpjAutor;
    }

    public NFSeSefinNacionalInfPedReg setCNPJAutor(String value) {
        this.cnpjAutor = value;
        return this;
    }

    public String getCPFAutor() {
        return cpfAutor;
    }

    public NFSeSefinNacionalInfPedReg setCPFAutor(String value) {
        this.cpfAutor = value;
        return this;
    }

    public String getChaveAcessoNFSE() {
        return chaveAcessoNFSE;
    }

    public NFSeSefinNacionalInfPedReg setChaveAcessoNFSE(String value) {
        this.chaveAcessoNFSE = value;
        return this;
    }

    public String getNPedRegEvento() {
        return numeroPedidoRegistroEvento;
    }

    public NFSeSefinNacionalInfPedReg setNPedRegEvento(String value) {
        this.numeroPedidoRegistroEvento = value;
        return this;
    }

    public NFSeSefinNacionalInfPedRegEventoTE getEvento() {
        return evento;
    }

    public NFSeSefinNacionalInfPedReg setEvento(NFSeSefinNacionalInfPedRegEventoTE evento) {
        this.evento = evento;
        return this;
    }

    public String getId() {
        return this.id;
    }

    /**
     * O identificador do pedido de registro do evento é formado conforme a concatenação dos seguintes campos:
     * "PRE" + Chave de Acesso NFS-e + Tipo do evento + Número do Pedido de Registro do Evento (nPedRegEvento)
     *
     * @param value numero pedido evento
     * @return
     */
    public NFSeSefinNacionalInfPedReg setId(String value) {
        this.id = value;
        return this;
    }

}
