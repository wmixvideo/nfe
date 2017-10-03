package com.fincatto.documentofiscal.nfe310.classes.evento.inutilizacao;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

@Root(name = "retInutNFe")
public class NFRetornoEventoInutilizacao extends DFBase {
    private static final long serialVersionUID = 4619432132223667789L;

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
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao, "Versao");
    }
}