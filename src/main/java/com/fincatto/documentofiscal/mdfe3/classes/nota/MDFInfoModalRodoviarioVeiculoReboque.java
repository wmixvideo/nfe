package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.validadores.StringValidador;

public class MDFInfoModalRodoviarioVeiculoReboque extends MDFInfoModalRodoviarioVeiculo {
    private static final long serialVersionUID = -2787982058485353668L;
    @Element(name = "capKG")
    private String capacidadeKG;

    @Override
    public void setCodigoInterno(final String codigoInterno) {
        super.codigoInterno = StringValidador.validador(codigoInterno, "Codigo interno Veiculo Reboque", 10, false, false);
    }

    @Override
    public void setPlaca(final String placa) {
        StringValidador.placaDeVeiculo(placa, "Placa do reboque");
        this.placa = placa;
    }

    @Override
    public void setRenavam(final String renavam) {
        this.renavam = StringValidador.validaIntervalo(renavam, 9, 11, "Renavam do reboque");
    }

    @Override
    public void setTara(final String tara) {
        this.tara = StringValidador.capacidadeNDigitos(tara, "Tara em reboque", 5);
    }

    public String getCapacidadeKG() {
        return this.capacidadeKG;
    }

    public void setCapacidadeKG(final String capacidadeKG) {
        this.capacidadeKG = StringValidador.capacidadeNDigitos(capacidadeKG, "Capacidade em KG reboque", 5);
    }

    @Override
    public String getCapacidadeM3() {
        return this.capacidadeM3;
    }

    @Override
    public void setCapacidadeM3(final String capacidadeM3) {
        this.capacidadeM3 = StringValidador.capacidadeNDigitos(capacidadeM3, "Capacidade em M3 reboque", 2);
    }

}
