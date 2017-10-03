package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "retConsCad")
public class NFRetornoConsultaCadastro extends DFBase {
    private static final long serialVersionUID = 3536099917870161262L;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "infCons")
    private NFRetornoConsultaCadastroDados dados;

    public NFRetornoConsultaCadastroDados getDados() {
        return this.dados;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setDados(final NFRetornoConsultaCadastroDados dados) {
        this.dados = dados;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }
}