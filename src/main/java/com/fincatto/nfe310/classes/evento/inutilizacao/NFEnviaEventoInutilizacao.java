package com.fincatto.nfe310.classes.evento.inutilizacao;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;

@Root(name = "inutNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFEnviaEventoInutilizacao extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infInut", required = true)
    private NFEventoCancelamentoDados dados;

    @Element(name = "Signature", required = false)
    private String assinatura;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao);
    }

    public NFEventoCancelamentoDados getDados() {
        return this.dados;
    }

    public void setDados(final NFEventoCancelamentoDados dados) {
        this.dados = dados;
    }

    public String getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(final String assinatura) {
        this.assinatura = assinatura;
    }
}