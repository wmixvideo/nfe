package com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFTipoEvento;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

public class NFInfoCancelamento extends NFTipoEvento {
    private static final long serialVersionUID = 7427073073940993756L;
    
    @Element(name = "cOrgaoAutor", required = false)
    private DFUnidadeFederativa ufAutorizador;//campo destinado ao cancelamento por substituicao
    
    @Element(name = "tpAutor", required = false)
    private String tipoAutorizador;//campo destinado ao cancelamento por substituicao
    
    @Element(name = "verAplic", required = false)
    private String versaoAplicativo;//campo destinado ao cancelamento por substituicao
    
    @Element(name = "nProt")
    private String protocoloAutorizacao;
    
    @Element(name = "xJust")
    private String justificativa;
    
    @Element(name = "chNFeRef", required = false)
    private String chaveAcessoSubstituta;//campo destinado ao cancelamento por substituicao

    public DFUnidadeFederativa getUfAutorizador() {
		return ufAutorizador;
	}

	public void setUfAutorizador(DFUnidadeFederativa ufAutorizador) {
		this.ufAutorizador = ufAutorizador;
	}

	public String getTipoAutorizador() {
		return tipoAutorizador;
	}

	public void setTipoAutorizador(String tipoAutorizador) {
		this.tipoAutorizador = tipoAutorizador;
	}

	public String getVersaoAplicativo() {
		return versaoAplicativo;
	}

	public void setVersaoAplicativo(String versaoAplicativo) {
		this.versaoAplicativo = versaoAplicativo;
	}

	public void setJustificativa(final String justificativa) {
        StringValidador.tamanho15a256(justificativa, "Justificativa");
        this.justificativa = justificativa;
    }

    public void setProtocoloAutorizacao(final String protocoloAutorizacao) {
        StringValidador.exatamente15N(protocoloAutorizacao, "Protocolo de Autorizacao");
        this.protocoloAutorizacao = protocoloAutorizacao;
    }

    public String getJustificativa() {
        return this.justificativa;
    }

    public String getProtocoloAutorizacao() {
        return this.protocoloAutorizacao;
    }

    public String getChaveAcessoSubstituta() {
		return chaveAcessoSubstituta;
	}

	public void setChaveAcessoSubstituta(String chaveAcessoSubstituta) {
		this.chaveAcessoSubstituta = chaveAcessoSubstituta;
	}

	@Override
    public void setCondicaoUso(final String condicaoUso) {
        throw new UnsupportedOperationException("Evento de cancelamento nao possui condicao de uso");
    }

    @Override
    public void setTextoCorrecao(final String textoCorrecao) {
        throw new UnsupportedOperationException("Evento de cancelamento nao possui texto de correcao");
    }
}