package com.fincatto.nfe310.classes.lote.consulta;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;

@Root(name = "consReciNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFLoteConsulta extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "tpAmb", required = true)
    private NFAmbiente ambiente;

    @Element(name = "nRec", required = true)
    private String recibo;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho4Com2CasasDecimais(versao);
    }

    public NFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final NFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getRecibo() {
        return this.recibo;
    }

    public void setRecibo(final String recibo) {
        this.recibo = recibo;
    }
}