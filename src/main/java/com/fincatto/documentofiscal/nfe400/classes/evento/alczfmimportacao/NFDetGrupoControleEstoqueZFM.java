package com.fincatto.documentofiscal.nfe400.classes.evento.alczfmimportacao;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gControleEstoque")
public class NFDetGrupoControleEstoqueZFM extends DFBase {

    @Element(name = "qtde")
    private String quantidadeZFM;

    @Element(name = "unidade")
    private String unidadeZFM;

    public String getQuantidadeZFM() {
        return quantidadeZFM;
    }

    public void setQuantidadeZFM(BigDecimal quantidadeZFM) {
        this.quantidadeZFM = DFBigDecimalValidador.tamanho11Com4CasasDecimais(quantidadeZFM, "Quantidade");
    }

    public String getUnidadeZFM() {
        return unidadeZFM;
    }

    public void setUnidadeZFM(String unidadeZFM) {
        DFStringValidador.tamanho6(unidadeZFM, "Unidade de medida");
        this.unidadeZFM = unidadeZFM;
    }
}
