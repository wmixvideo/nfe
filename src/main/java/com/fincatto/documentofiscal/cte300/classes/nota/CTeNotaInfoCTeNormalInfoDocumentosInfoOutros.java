package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;
import java.util.List;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTipoDocumento;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações dos demais documentos
 */

@Root(name = "infOutros")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoDocumentosInfoOutros extends DFBase {
    private static final long serialVersionUID = -2282041203753433659L;

    @Element(name = "tpDoc", required = true)
    private CTTipoDocumento tipoDocumento;

    @Element(name = "descOutros", required = false)
    private String descricao;

    @Element(name = "nDoc", required = false)
    private String numero;

    @Element(name = "dEmi", required = false)
    private LocalDate dataEmissao;

    @Element(name = "vDocFisc", required = false)
    private String valorDocumentoFiscal;

    @Element(name = "dPrev", required = false)
    private LocalDate dataPrevisaoEntrega;

    @ElementList(name = "infUnidCarga", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> infoUnidCarga;

    @ElementList(name = "infUnidTransp", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeTransporte> infoUnidTransporte;

    public CTeNotaInfoCTeNormalInfoDocumentosInfoOutros() {
        this.tipoDocumento = null;
        this.descricao = null;
        this.numero = null;
        this.dataEmissao = null;
        this.valorDocumentoFiscal = null;
        this.dataPrevisaoEntrega = null;
        this.infoUnidCarga = null;
        this.infoUnidTransporte = null;
    }

    public CTTipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    /**
     * Tipo de documento originário<br>
     * Preencher com:<br>
     * 00 - Declaração;<br>
     * 10 - Dutoviário;<br>
     * 59 - CF-e SAT;<br>
     * 65 - NFC-e;<br>
     * 99 - Outros
     */
    public void setTipoDocumento(final CTTipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Descrição do documento
     */
    public void setDescricao(final String descricao) {
        StringValidador.tamanho100(descricao, "Descrição do documento");
        this.descricao = descricao;
    }

    public String getNumero() {
        return this.numero;
    }

    /**
     * Número
     */
    public void setNumero(final String numero) {
        StringValidador.tamanho20(numero, "Número documento");
        this.numero = numero;
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    /**
     * Data de Emissão<br>
     * Formato AAAA-MM-DD
     */
    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getValorDocumentoFiscal() {
        return this.valorDocumentoFiscal;
    }

    /**
     * Valor do documento
     */
    public void setValorDocumentoFiscal(final BigDecimal valorDocumentoFiscal) {
        this.valorDocumentoFiscal = BigDecimalParser.tamanho15Com2CasasDecimais(valorDocumentoFiscal, "Valor do documento");
    }

    public LocalDate getDataPrevisaoEntrega() {
        return this.dataPrevisaoEntrega;
    }

    /**
     * Data prevista de entrega<br>
     * Formato AAAA-MM-DD
     */
    public void setDataPrevisaoEntrega(final LocalDate dataPrevisaoEntrega) {
        this.dataPrevisaoEntrega = dataPrevisaoEntrega;
    }

    public List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> getInfoUnidCarga() {
        return this.infoUnidCarga;
    }

    /**
     * Informações das Unidades de Carga (Containeres/ULD/Outros)<br>
     * Dispositivo de carga utilizada (Unit Load Device - ULD) significa todo tipo de contêiner de carga, vagão, contêiner de avião, palete de aeronave com rede ou palete de aeronave com rede sobre um iglu.
     */
    public void setInfoUnidCarga(final List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> infoUnidCarga) {
        this.infoUnidCarga = infoUnidCarga;
    }

    public List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeTransporte> getInfoUnidTransporte() {
        return this.infoUnidTransporte;
    }

    /**
     * Informações das Unidades de Transporte (Carreta/Reboque/Vagão)<br>
     * Deve ser preenchido com as informações das unidades de transporte utilizadas.
     */
    public void setInfoUnidTransporte(final List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeTransporte> infoUnidTransporte) {
        this.infoUnidTransporte = infoUnidTransporte;
    }
}
