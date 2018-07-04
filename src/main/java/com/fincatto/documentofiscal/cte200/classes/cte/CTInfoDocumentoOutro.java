package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte200.classes.CTTipoDocumentoOutro;

@Root(name = "infOutros")
public class CTInfoDocumentoOutro extends DFBase {
    private static final long serialVersionUID = -2628837709003447868L;

    @Element(name = "tpDoc")
    protected CTTipoDocumentoOutro tpDoc;

    @Element(name = "descOutros", required = false)
    protected String descricao;

    @Element(name = "nDoc", required = false)
    protected String numero;

    @Element(name = "dEmi", required = false)
    protected LocalDate dataEmissao;

    @Element(name = "vDocFisc", required = false)
    protected String valorDocumento;

    @Element(name = "dPrev", required = false)
    protected String dataPrevisaoEntrega;

    @ElementList(name = "infUnidTransp", inline = true, required = false)
    private List<CTInfoDocumentoNFUnidTransp> unidadesTransporte;

    @ElementList(name = "infUnidCarga", inline = true, required = false)
    private List<CTInfoDocumentoNFUnidadeCarga> unidadesCarga;

    public CTTipoDocumentoOutro getTpDoc() {
        return this.tpDoc;
    }

    public void setTpDoc(final CTTipoDocumentoOutro tpDoc) {
        this.tpDoc = tpDoc;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getValorDocumento() {
        return this.valorDocumento;
    }

    public void setValorDocumento(final String valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public String getDataPrevisaoEntrega() {
        return this.dataPrevisaoEntrega;
    }

    public void setDataPrevisaoEntrega(final String dataPrevisaoEntrega) {
        this.dataPrevisaoEntrega = dataPrevisaoEntrega;
    }

    public List<CTInfoDocumentoNFUnidTransp> getUnidadesTransporte() {
        return this.unidadesTransporte;
    }

    public void setUnidadesTransporte(final List<CTInfoDocumentoNFUnidTransp> unidadesTransporte) {
        this.unidadesTransporte = unidadesTransporte;
    }

    public List<CTInfoDocumentoNFUnidadeCarga> getUnidadesCarga() {
        return this.unidadesCarga;
    }

    public void setUnidadesCarga(final List<CTInfoDocumentoNFUnidadeCarga> unidadesCarga) {
        this.unidadesCarga = unidadesCarga;
    }

}
