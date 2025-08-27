package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.LocalDate;

@Root(name = "infDocRef")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoDocumentos extends DFBase {
    private static final long serialVersionUID = 7527096776018371935L;

    @Element(name = "nDoc", required = false)
    private String numeroDocumento;

    @Element(name = "serie", required = false)
    private String serie;

    @Element(name = "subserie", required = false)
    private String subserie;

    @Element(name = "dEmi", required = false)
    private LocalDate dataEmissao;

    @Element(name = "vDoc", required = false)
    private String valorDocumento;

    @Element(name = "chBPe", required = false)
    private String chaveBilhetePassagem;

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(final String numeroDocumento) {
        DFStringValidador.tamanho20(numeroDocumento, "Numero Documento");
        this.numeroDocumento = numeroDocumento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(final String serie) {
        DFStringValidador.tamanho3(serie, "Serie");
        this.serie = serie;
    }

    public String getSubserie() {
        return subserie;
    }

    public void setSubserie(final String subserie) {
        DFStringValidador.tamanho3(subserie, "Subserie");
        this.subserie = subserie;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(final BigDecimal valorDocumento) {
        this.valorDocumento = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorDocumento, "Valor Documento");
    }

    public String getChaveBilhetePassagem() {
        return chaveBilhetePassagem;
    }

    public void setChaveBilhetePassagem(final String chaveBilhetePassagem) {
        this.chaveBilhetePassagem = chaveBilhetePassagem;
    }
}
