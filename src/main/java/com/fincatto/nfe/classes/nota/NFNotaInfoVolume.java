package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;
import com.fincatto.nfe.validadores.ListValidador;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoVolume extends NFBase {
    @Element(name = "qVol", required = true)
    private BigInteger quantidadeVolumesTransportados;

    @Element(name = "esp", required = false)
    private String especieVolumesTransportados;

    @Element(name = "marca", required = false)
    private String marca;

    @Element(name = "nVol", required = false)
    private String numeracaoVolumesTransportados;

    @Element(name = "pesoL", required = false)
    private String pesoLiquido;

    @Element(name = "pesoB", required = false)
    private String pesoBruto;

    @ElementList(entry = "lacres", inline = true, required = false)
    private List<NFNotaInfoLacre> lacres;

    public void setQuantidadeVolumesTransportados(final BigInteger quantidadeVolumesTransportados) {
        this.quantidadeVolumesTransportados = quantidadeVolumesTransportados;
    }

    public void setNumeracaoVolumesTransportados(final String numeracaoVolumesTransportados) {
        StringValidador.tamanho60(numeracaoVolumesTransportados);
        this.numeracaoVolumesTransportados = numeracaoVolumesTransportados;
    }

    public void setEspecieVolumesTransportados(final String especieVolumesTransportados) {
        StringValidador.tamanho60(especieVolumesTransportados);
        this.especieVolumesTransportados = especieVolumesTransportados;
    }

    public void setMarca(final String marca) {
        StringValidador.tamanho60(marca);
        this.marca = marca;
    }

    public void setPesoLiquido(final BigDecimal pesoLiquido) {
        this.pesoLiquido = BigDecimalParser.tamanho15Com3CasasDecimais(pesoLiquido);
    }

    public void setPesoBruto(final BigDecimal pesoBruto) {
        this.pesoBruto = BigDecimalParser.tamanho15Com3CasasDecimais(pesoBruto);
    }

    public void setLacres(final List<NFNotaInfoLacre> lacres) {
        ListValidador.tamanho5000(lacres);
        this.lacres = lacres;
    }
}