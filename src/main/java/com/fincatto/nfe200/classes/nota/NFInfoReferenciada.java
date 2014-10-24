package com.fincatto.nfe200.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.validadores.StringValidador;

public class NFInfoReferenciada extends NFBase {
    @Element(name = "refNFe", required = false)
    private String chaveAcesso;

    @Element(name = "refNF", required = false)
    private NFInfoModelo1Por1AReferenciada modelo1por1Referenciada;

    @Element(name = "refNFP", required = false)
    private NFInfoProdutorRuralReferenciada infoNFProdutorRuralReferenciada;

    @Element(name = "refCTe", required = false)
    private String chaveAcessoCTReferenciada;

    @Element(name = "refECF", required = false)
    private NFInfoCupomFiscalReferenciado cupomFiscalReferenciado;

    public void setChaveAcesso(final String chaveAcesso) {
        if (this.modelo1por1Referenciada != null || this.infoNFProdutorRuralReferenciada != null || this.chaveAcessoCTReferenciada != null || this.cupomFiscalReferenciado != null) {
            throw new IllegalStateException("Nao pode setar chave de acesso caso modelo 1 por 1 referenciada esteja setado");
        }
        StringValidador.exatamente44N(chaveAcesso);
        this.chaveAcesso = chaveAcesso;
    }

    public void setModelo1por1Referenciada(final NFInfoModelo1Por1AReferenciada modelo1por1Referenciada) {
        if (this.chaveAcesso != null || this.infoNFProdutorRuralReferenciada != null || this.chaveAcessoCTReferenciada != null || this.cupomFiscalReferenciado != null) {
            throw new IllegalStateException("Nao pode setar modelo 1 por 1 referenciada caso chave de acesso esteja setado");
        }
        this.modelo1por1Referenciada = modelo1por1Referenciada;
    }

    public void setChaveAcessoCTReferenciada(final String chaveAcessoCTReferenciada) {
        if (this.modelo1por1Referenciada != null || this.chaveAcesso != null || this.infoNFProdutorRuralReferenciada != null || this.cupomFiscalReferenciado != null) {
            throw new IllegalStateException("Nao pode setar modelo 1 por 1 referenciada caso chave de acesso esteja setado");
        }
        StringValidador.exatamente44N(chaveAcessoCTReferenciada);
        this.chaveAcessoCTReferenciada = chaveAcessoCTReferenciada;
    }

    public void setInfoNFProdutorRuralReferenciada(final NFInfoProdutorRuralReferenciada infoNFProdutorRuralReferenciada) {
        if (this.modelo1por1Referenciada != null || this.chaveAcesso != null || this.cupomFiscalReferenciado != null || this.chaveAcessoCTReferenciada != null) {
            throw new IllegalStateException("Nao pode setar modelo 1 por 1 referenciada caso chave de acesso esteja setado");
        }
        this.infoNFProdutorRuralReferenciada = infoNFProdutorRuralReferenciada;
    }

    public void setCupomFiscalReferenciado(final NFInfoCupomFiscalReferenciado cupomFiscalReferenciado) {
        if (this.modelo1por1Referenciada != null || this.chaveAcesso != null || this.chaveAcessoCTReferenciada != null || this.infoNFProdutorRuralReferenciada != null) {
            throw new IllegalStateException("Nao pode setar modelo 1 por 1 referenciada caso chave de acesso esteja setado");
        }
        this.cupomFiscalReferenciado = cupomFiscalReferenciado;
    }
}