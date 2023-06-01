package com.fincatto.documentofiscal.cte300.classes.evento.gtv;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

public class CTeInformacaoGtv extends DFBase {
    @Element(name = "nDoc")
    private String documento;

    @Element(name = "id")
    private String id;

    @Element(name = "serie", required = false)
    private String serie;

    @Element(name = "subserie", required = false)
    private String subserie;

    @Element(name = "dEmi")
    private ZonedDateTime dataEmissao;

    @Element(name = "nDV")
    private Integer digitoVerificador;

    @Element(name = "qCarga")
    private String quantidade;

    @Element(name = "infEspecie")
    private List<CTeInformacaoEspecieGtv> especies;

    @Element(name = "rem")
    private CTeRemetenteGtv remetente;

    @Element(name = "dest")
    private CTeDestinatarioGtv destinatario;

    @Element(name = "placa", required = false)
    private String placa;

    @Element(name = "UF", required = false)
    private String uf;

    @Element(name = "RNTRC", required = false)
    private String rntrc;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        DFStringValidador.tamanho20(documento, "Documento");
        this.documento = documento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        DFStringValidador.tamanho20(id, "Id");
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        DFStringValidador.tamanho3(serie, "Serie");
        this.serie = serie;
    }

    public String getSubserie() {
        return subserie;
    }

    public void setSubserie(String subserie) {
        DFStringValidador.tamanho3(subserie, "Subserie");
        this.subserie = subserie;
    }

    public ZonedDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(ZonedDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Integer getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(Integer digitoVerificador) {
        DFIntegerValidador.exatamente1(digitoVerificador, "Digito Verificador");
        this.digitoVerificador = digitoVerificador;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = DFBigDecimalValidador.validaTamanho(quantidade, "Quantidade Carga CT-e", 11, 4, true);
    }

    public List<CTeInformacaoEspecieGtv> getEspecies() {
        return especies;
    }

    public void setEspecies(List<CTeInformacaoEspecieGtv> especies) {
        this.especies = especies;
    }

    public CTeRemetenteGtv getRemetente() {
        return remetente;
    }

    public void setRemetente(CTeRemetenteGtv remetente) {
        this.remetente = remetente;
    }

    public CTeDestinatarioGtv getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(CTeDestinatarioGtv destinatario) {
        this.destinatario = destinatario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        DFStringValidador.placaDeVeiculo(placa, "Placa");
        this.placa = placa;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        DFStringValidador.exatamente2(uf, "UF");
        this.uf = uf;
    }

    public String getRntrc() {
        return rntrc;
    }

    public void setRntrc(String rntrc) {
        if (!rntrc.equals("ISENTO")) {
            DFStringValidador.exatamente8(rntrc, "RNTRC");
        }
        this.rntrc = rntrc;
    }
}
