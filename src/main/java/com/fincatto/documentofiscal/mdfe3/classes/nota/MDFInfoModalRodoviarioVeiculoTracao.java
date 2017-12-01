package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoRodado;
import com.fincatto.documentofiscal.validadores.ListValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import java.util.List;

@Order(elements = { "cInt", "placa", "RENAVAM", "tara", "capKG", "capM3", "prop", "condutor", "tpRod", "tpCar", "UF"})
public class MDFInfoModalRodoviarioVeiculoTracao extends MDFInfoModalRodoviarioVeiculo {

    @ElementList(entry = "condutor", inline = true)
    private List<MDFInfoModalRodoviarioVeiculoCondutor> condutor;

    @Element(name = "tpRod")
    private MDFTipoRodado tipoRodado;

    @Element(name = "capKG" , required = false)
    private String capacidadeKG;

    public void setCodigoInterno(String codigoInterno) {
        super.codigoInterno = StringValidador.validador(codigoInterno,
                "Codigo interno Veiculo Veiculo tracao", 10, false, false);
    }

    public void setPlaca(String placa) {
        StringValidador.placaDeVeiculo(placa, "Placa do Veiculo tracao");
        this.placa = placa;
    }

    public void setRenavam(String renavam) {
        this.renavam = StringValidador.validaIntervalo(renavam, 9, 11 ,"Renavam do Veiculo tracao");
    }

    public void setTara(String tara) {
        this.tara = StringValidador.capacidadeNDigitos(tara, "Tara em Veiculo tracao",5);
    }

    public String getCapacidadeKG() {
        return capacidadeKG;
    }

    public void setCapacidadeKG(String capacidadeKG) {
        this.capacidadeKG = StringValidador.capacidadeNDigitos(capacidadeKG, "Capacidade em KG Veiculo tracao",5);
    }

    public String getCapacidadeM3() {
        return capacidadeM3;
    }

    public void setCapacidadeM3(String capacidadeM3) {
        this.capacidadeM3 = StringValidador.capacidadeNDigitos(capacidadeM3, "Capacidade em M3 Veiculo tracao",2);
    }

    public List<MDFInfoModalRodoviarioVeiculoCondutor> getCondutor() {
        return condutor;
    }

    public void setCondutor(List<MDFInfoModalRodoviarioVeiculoCondutor> condutor) {
        this.condutor =  ListValidador.validaListaObrigatoria( condutor, 10, "Condutor Veiculo tracao");
    }

    public MDFTipoRodado getTipoRodado() {
        return tipoRodado;
    }

    public void setTipoRodado(MDFTipoRodado tipoRodado) {
        this.tipoRodado = tipoRodado;
    }
}
