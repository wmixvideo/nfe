
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações do DPS relativas ao Serviço Prestado
 */

@Root(name = "serv")
public class NFSeSefinNacionalServ {

    @Element(name = "locPrest")
    protected NFSeSefinNacionalLocPrest localPrestacao;
    @Element(name = "cServ")
    protected NFSeSefinNacionalCServ codigoServico;
    @Element(name = "comExt", required = false)
    protected NFSeSefinNacionalComercioExterior comercioExterior;
    @Element(name = "lsadppu", required = false)
    protected NFSeSefinNacionalLocacaoSublocacao localSubLocacao;
    @Element(name = "obra", required = false)
    protected NFSeSefinNacionalInfoObra obra;
    @Element(name = "atvEvento", required = false)
    protected NFSeSefinNacionalAtvEvento evento;
    @Element(name = "explRod", required = false)
    protected NFSeSefinNacionalExploracaoRodoviaria exploracaoRodoviaria;
    @Element(name = "infoCompl", required = false)
    protected NFSeSefinNacionalInfoCompl informacoesComplementares;

    public NFSeSefinNacionalLocPrest getLocalPrestacao() {
        return localPrestacao;
    }

    public NFSeSefinNacionalServ setLocalPrestacao(NFSeSefinNacionalLocPrest value) {
        this.localPrestacao = value;
        return this;
    }

    public NFSeSefinNacionalCServ getCServ() {
        return codigoServico;
    }

    public NFSeSefinNacionalServ setCServ(NFSeSefinNacionalCServ value) {
        this.codigoServico = value;
        return this;
    }

    public NFSeSefinNacionalComercioExterior getComercioExterior() {
        return comercioExterior;
    }

    public void setComercioExterior(NFSeSefinNacionalComercioExterior value) {
        this.comercioExterior = value;
    }

    public NFSeSefinNacionalLocacaoSublocacao getLocalSubLocacao() {
        return localSubLocacao;
    }

    public void setLocalSubLocacao(NFSeSefinNacionalLocacaoSublocacao value) {
        this.localSubLocacao = value;
    }

    public NFSeSefinNacionalInfoObra getObra() {
        return obra;
    }

    public void setObra(NFSeSefinNacionalInfoObra value) {
        this.obra = value;
    }

    public NFSeSefinNacionalAtvEvento getEvento() {
        return evento;
    }

    public void setEvento(NFSeSefinNacionalAtvEvento value) {
        this.evento = value;
    }

    public NFSeSefinNacionalExploracaoRodoviaria getExploracaoRodoviaria() {
        return exploracaoRodoviaria;
    }

    public void setExploracaoRodoviaria(NFSeSefinNacionalExploracaoRodoviaria value) {
        this.exploracaoRodoviaria = value;
    }

    public NFSeSefinNacionalInfoCompl getInformacoesComplementares() {
        return informacoesComplementares;
    }

    public void setInformacoesComplementares(NFSeSefinNacionalInfoCompl value) {
        this.informacoesComplementares = value;
    }

}
