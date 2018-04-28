package com.fincatto.documentofiscal.nfe400.classes.nota.consulta;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

@Root(name = "consSitNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaConsulta extends DFBase {
    private static final long serialVersionUID = 6261821910786634620L;

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "xServ", required = true)
    private String servico;

    @Element(name = "chNFe", required = true)
    private String chave;

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho4Com2CasasDecimais(versao, "Versao Nota Consulta");
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public void setServico(final String servico) {
        this.servico = servico;
    }

    public void setChave(final String chave) {
        StringValidador.exatamente44N(chave, "Chave de Acesso Nota Consulta");
        this.chave = chave;
    }

    public String getVersao() {
        return this.versao;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public String getServico() {
        return this.servico;
    }

    public String getChave() {
        return this.chave;
    }
}