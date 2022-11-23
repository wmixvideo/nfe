package com.fincatto.documentofiscal.nfe310.classes.lote.consulta;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "consReciNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFLoteConsulta extends DFBase {
    private static final long serialVersionUID = 205828108320121890L;
    
    @Attribute(name = "versao")
    private String versao;
    
    @Element(name = "tpAmb")
    private DFAmbiente ambiente;
    
    @Element(name = "nRec")
    private String recibo;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho4Com2CasasDecimais(versao, "Versao");
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getRecibo() {
        return this.recibo;
    }

    public void setRecibo(final String recibo) {
        this.recibo = recibo;
    }
}