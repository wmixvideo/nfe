package com.fincatto.documentofiscal.cte300.classes.evento.inutilizacao;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;

@Root(name = "retInutCTe")
public class CTeRetornoEventoInutilizacao extends DFBase {
    private static final long serialVersionUID = 4619432132223667789L;

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infInut", required = true)
    private CTeRetornoEventoInutilizacaoDados dados;

    public CTeRetornoEventoInutilizacaoDados getDados() {
        return this.dados;
    }

    public void setDados(final CTeRetornoEventoInutilizacaoDados dados) {
        this.dados = dados;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versao, "Versao");
    }
}