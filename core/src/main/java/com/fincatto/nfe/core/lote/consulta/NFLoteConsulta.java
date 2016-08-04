package com.fincatto.nfe.core.lote.consulta;

import com.fincatto.nfe.core.NFAmbiente;
import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.validadores.BigDecimalParser;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

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
        this.versao = BigDecimalParser.tamanho4Com2CasasDecimais(versao, "Versao");
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