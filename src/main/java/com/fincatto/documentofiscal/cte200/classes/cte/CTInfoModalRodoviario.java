package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoModalRodoviario extends DFBase {
    private static final long serialVersionUID = 3232064596106386289L;

    @Element(name = "RNTRC")
    private String registroNacionalTrasportadoras;

    @Element(name = "dPrev")
    private LocalDate dataPrevisaoEntrega;

    @Element(name = "lota")
    private String indicadorLotacao;

    @Element(name = "CIOT", required = false)
    private String codigoOperacaoTransporte;

    @ElementList(name = "occ", inline = true, required = false)
    private List<CTInfoModalRodoviarioColeta> ordensColeta;

    @ElementList(name = "valePed", inline = true, required = false)
    private List<CTInfoModalRodoviarioPedagio> valesPedagio;

    @ElementList(name = "veic", inline = true, required = false)
    private List<CTInfoModalRodoviarioVeiculo> veiculos;

    @ElementList(name = "lacRodo", inline = true, required = false)
    private List<CTInfoModalRodoviarioLacre> lacres;

    @ElementList(name = "moto", inline = true, required = false)
    private List<CTInfoModalRodoviarioMotorista> motoristas;

    public String getRegistroNacionalTrasportadoras() {
        return this.registroNacionalTrasportadoras;
    }

    public void setRegistroNacionalTrasportadoras(final String registroNacionalTrasportadoras) {
        this.registroNacionalTrasportadoras = registroNacionalTrasportadoras;
    }

    public LocalDate getDataPrevisaoEntrega() {
        return this.dataPrevisaoEntrega;
    }

    public void setDataPrevisaoEntrega(final LocalDate dataPrevisaoEntrega) {
        this.dataPrevisaoEntrega = dataPrevisaoEntrega;
    }

    public String getIndicadorLotacao() {
        return this.indicadorLotacao;
    }

    public void setIndicadorLotacao(final String indicadorLotacao) {
        this.indicadorLotacao = indicadorLotacao;
    }

    public String getCodigoOperacaoTransporte() {
        return this.codigoOperacaoTransporte;
    }

    public void setCodigoOperacaoTransporte(final String codigoOperacaoTransporte) {
        this.codigoOperacaoTransporte = codigoOperacaoTransporte;
    }

    public List<CTInfoModalRodoviarioColeta> getOrdensColeta() {
        return this.ordensColeta;
    }

    public void setOrdensColeta(final List<CTInfoModalRodoviarioColeta> ordensColeta) {
        this.ordensColeta = ordensColeta;
    }

    public List<CTInfoModalRodoviarioPedagio> getValesPedagio() {
        return this.valesPedagio;
    }

    public void setValesPedagio(final List<CTInfoModalRodoviarioPedagio> valesPedagio) {
        this.valesPedagio = valesPedagio;
    }

    public List<CTInfoModalRodoviarioVeiculo> getVeiculos() {
        return this.veiculos;
    }

    public void setVeiculos(final List<CTInfoModalRodoviarioVeiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<CTInfoModalRodoviarioLacre> getLacres() {
        return this.lacres;
    }

    public void setLacres(final List<CTInfoModalRodoviarioLacre> lacres) {
        this.lacres = lacres;
    }

    public List<CTInfoModalRodoviarioMotorista> getMotoristas() {
        return this.motoristas;
    }

    public void setMotoristas(final List<CTInfoModalRodoviarioMotorista> motoristas) {
        this.motoristas = motoristas;
    }

}
