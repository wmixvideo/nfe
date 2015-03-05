package com.fincatto.nfe200.classes.evento.inutilizacao;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.validadores.BigDecimalParser;

@Root(name = "retInutNFe")
public class NFRetornoEventoInutilizacao extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infInut", required = true)
    private NFRetornoEventoInutilizacaoDados dados;

    public NFRetornoEventoInutilizacaoDados getDados() {
        return this.dados;
    }

    public void setDados(final NFRetornoEventoInutilizacaoDados dados) {
        this.dados = dados;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao);
    }
}