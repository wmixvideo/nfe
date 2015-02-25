package com.fincatto.nfe310.classes.cadastro;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.nfe310.classes.NFBase;

@Root(name = "retConsCad")
public class NFRetornoConsultaCadastro extends NFBase {

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