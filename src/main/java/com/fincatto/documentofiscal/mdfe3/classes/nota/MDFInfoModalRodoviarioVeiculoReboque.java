package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

public class MDFInfoModalRodoviarioVeiculoReboque extends MDFInfoModalRodoviarioVeiculo {

    @Element(name = "capKG")
    private String capacidadeKG;

    public void setCodigoInterno(String codigoInterno) {
        super.codigoInterno = StringValidador.validador(codigoInterno,
                "Codigo interno Veiculo Reboque", 10, false, false);
    }

    public void setPlaca(String placa) {
        StringValidador.placaDeVeiculo(placa, "Placa do reboque");
        this.placa = placa;
    }

    public void setRenavam(String renavam) {
        this.renavam = StringValidador.validaIntervalo(renavam, 9, 11 ,"Renavam do reboque");
    }

    public void setTara(String tara) {
        this.tara = StringValidador.capacidadeNDigitos(tara, "Tara em reboque",5);
    }

    public String getCapacidadeKG() {
        return capacidadeKG;
    }

    public void setCapacidadeKG(String capacidadeKG) {
        this.capacidadeKG = StringValidador.capacidadeNDigitos(capacidadeKG, "Capacidade em KG reboque",5);
    }

    public String getCapacidadeM3() {
        return capacidadeM3;
    }

    public void setCapacidadeM3(String capacidadeM3) {
        this.capacidadeM3 = StringValidador.capacidadeNDigitos(capacidadeM3, "Capacidade em M3 reboque",2);
    }

}
