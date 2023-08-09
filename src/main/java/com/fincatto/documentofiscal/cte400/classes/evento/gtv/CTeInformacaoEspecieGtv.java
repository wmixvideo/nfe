package com.fincatto.documentofiscal.cte400.classes.evento.gtv;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte400.classes.CTTipoEspecieGtv;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class CTeInformacaoEspecieGtv extends DFBase {
    private static final long serialVersionUID = 229144141854691208L;
    
    @Element(name = "tpEspecie")
    private CTTipoEspecieGtv tipoEspecie;

    @Element(name = "vEspecie", required = false)
    private String valorEspecie;

    public CTTipoEspecieGtv getTipoEspecie() {
        return tipoEspecie;
    }

    public void setTipoEspecie(CTTipoEspecieGtv tipoEspecie) {
        this.tipoEspecie = tipoEspecie;
    }

    public String getValorEspecie() {
        return valorEspecie;
    }

    public void setValorEspecie(BigDecimal valorEspecie) {
        this.valorEspecie = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorEspecie, "Valor Especie");
    }
}
