package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoPermissaoAntecipacao;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;

/**
 * Created by Edivaldo Merlo Stens on 29/06/20.
 * <h1>Informações do pagamento a prazo. Obs: Informar somente se indPag for à
 * Prazo</h1>
 */
@Root(name = "infPrazo")
public class MDFInfoModalRodoviarioInfPagPrazo extends DFBase {

    private static final long serialVersionUID = 3657414548123273405L;

    /**
     *
     */
    @Element(name = "nParcela", required = false)
    private String nParcela;

    /**
     *
     */
    @Element(name = "dVenc", required = false)
    private LocalDate dVenc;

    /**
     *
     */
    @Element(name = "vParcela", required = true)
    private BigDecimal vParcela;

    /**
     * Tipo de Permissão em relação a
     * antecipação das parcelas
     */
    @Element(name = "tpAntecip", required = false)
    private MDFTipoPermissaoAntecipacao tipoPermissaoAntecipacao;

    public String getNParcela() {
        return nParcela;
    }

    public void setNParcela(String nParcela) {
        this.nParcela = nParcela != null ? StringUtils.leftPad(nParcela, 3, "0") : null;
    }

    public LocalDate getDVenc() {
        return dVenc;
    }

    public void setDVenc(LocalDate dVenc) {
        this.dVenc = dVenc;
    }

    public BigDecimal getVParcela() {
        return vParcela;
    }

    public void setVParcela(BigDecimal vParcela) {
        DFBigDecimalValidador.tamanho13Com2CasasDecimais(vParcela, "Valor da Parcela");
        this.vParcela = vParcela;
    }

    public MDFTipoPermissaoAntecipacao getTipoPermissaoAntecipacao() {
        return tipoPermissaoAntecipacao;
    }

    public void setTipoPermissaoAntecipacao(MDFTipoPermissaoAntecipacao tipoPermissaoAntecipacao) {
        this.tipoPermissaoAntecipacao = tipoPermissaoAntecipacao;
    }
}
