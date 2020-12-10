package com.fincatto.documentofiscal.mdfe3.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoRodado;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;

@Order(elements = { "cInt", "placa", "RENAVAM", "tara", "capKG", "capM3", "prop", "condutor", "tpRod", "tpCar", "UF" })
public class MDFInfoModalRodoviarioVeiculoTracao extends MDFInfoModalRodoviarioVeiculo {
    private static final long serialVersionUID = 6276417540652702190L;

    @ElementList(entry = "condutor", inline = true)
    private List<MDFInfoModalRodoviarioVeiculoCondutor> condutor;

    @Element(name = "tpRod")
    private MDFTipoRodado tipoRodado;

    @Element(name = "capKG", required = false)
    private String capacidadeKG;

    @Override
    public void setCodigoInterno(final String codigoInterno) {
        super.codigoInterno = DFStringValidador.validador(codigoInterno, "Codigo interno Veiculo Veiculo tracao", 10, false, false);
    }

    @Override
    public void setPlaca(final String placa) {
        DFStringValidador.placaDeVeiculo(placa, "Placa do Veiculo tracao");
        this.placa = placa;
    }

    @Override
    public void setRenavam(final String renavam) {
        this.renavam = DFStringValidador.validaIntervalo(renavam, 9, 11, "Renavam do Veiculo tracao");
    }

    @Override
    public void setTara(final String tara) {
        this.tara = DFStringValidador.capacidadeNDigitos(tara, "Tara em Veiculo tracao", 5);
    }

    public String getCapacidadeKG() {
        return this.capacidadeKG;
    }

    public void setCapacidadeKG(final String capacidadeKG) {
        this.capacidadeKG = DFStringValidador.capacidadeNDigitos(capacidadeKG, "Capacidade em KG Veiculo tracao", 5);
    }

    @Override
    public String getCapacidadeM3() {
        return this.capacidadeM3;
    }

    @Override
    public void setCapacidadeM3(final String capacidadeM3) {
        this.capacidadeM3 = DFStringValidador.capacidadeNDigitos(capacidadeM3, "Capacidade em M3 Veiculo tracao", 2);
    }

    public List<MDFInfoModalRodoviarioVeiculoCondutor> getCondutor() {
        return this.condutor;
    }

    public void setCondutor(final List<MDFInfoModalRodoviarioVeiculoCondutor> condutor) {
        this.condutor = DFListValidador.validaListaObrigatoria(condutor, 10, "Condutor Veiculo tracao");
    }

    public MDFTipoRodado getTipoRodado() {
        return this.tipoRodado;
    }

    public void setTipoRodado(final MDFTipoRodado tipoRodado) {
        this.tipoRodado = tipoRodado;
    }
}
