package com.fincatto.documentofiscal.nfe310.classes.evento.inutilizacao;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "inutNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFEnviaEventoInutilizacao extends DFBase {
    private static final long serialVersionUID = -2140741787724000417L;
    
    @Attribute(name = "versao")
    private String versao;
    
    @Element(name = "infInut")
    private NFEventoInutilizacaoDados dados;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public NFEventoInutilizacaoDados getDados() {
        return this.dados;
    }

    public void setDados(final NFEventoInutilizacaoDados dados) {
        this.dados = dados;
    }

    public NFSignature getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(final NFSignature assinatura) {
        this.assinatura = assinatura;
    }
}