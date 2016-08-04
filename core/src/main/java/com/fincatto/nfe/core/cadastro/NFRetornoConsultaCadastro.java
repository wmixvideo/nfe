package com.fincatto.nfe.core.cadastro;

import com.fincatto.nfe.core.NFBase;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

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