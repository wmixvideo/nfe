package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao extends DFBase {
    private static final long serialVersionUID = -7286071184901675008L;
    
    @Element(name = "nAdicao", required = false)
    private Integer numero;
    
    @Element(name = "nSeqAdic")
    private Integer sequencial;
    
    @Element(name = "cFabricante")
    private String codigoFabricante;

    @Element(name = "vDescDI", required = false)
    private String desconto;

    @Element(name = "nDraw", required = false)
    private String numeroAtoConcessorioDrawback;

    public void setNumero(final Integer numero) {
        if (numero != null) {
            DFIntegerValidador.tamanho3(numero, "Numero Declaracao Importacao Adicao");
        }
        this.numero = numero;
    }

    public void setSequencial(final Integer sequencial) {
        DFIntegerValidador.tamanho5(sequencial, "Sequencial Declaracao Importacao Adicao");
        this.sequencial = sequencial;
    }

    public void setCodigoFabricante(final String codigoFabricante) {
        DFStringValidador.tamanho60(codigoFabricante, "Codigo Fabricante Declaracao Importacao Adicao");
        this.codigoFabricante = codigoFabricante;
    }

    public void setDesconto(final BigDecimal desconto) {
        this.desconto = DFBigDecimalValidador.tamanho15Com2CasasDecimais(desconto, "Desconto Declaracao Importacao Adicao");
    }

    public void setNumeroAtoConcessorioDrawback(final String numeroAtoConcessorioDrawback) {
        DFStringValidador.tamanho20(numeroAtoConcessorioDrawback, "Numero Ato Concessorio Declaracao Importacao Adicao");
        this.numeroAtoConcessorioDrawback = numeroAtoConcessorioDrawback;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public Integer getSequencial() {
        return this.sequencial;
    }

    public String getCodigoFabricante() {
        return this.codigoFabricante;
    }

    public String getDesconto() {
        return this.desconto;
    }

    public String getNumeroAtoConcessorioDrawback() {
        return this.numeroAtoConcessorioDrawback;
    }
}