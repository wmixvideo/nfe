package com.fincatto.documentofiscal.cte300.classes.evento.inutilizacao;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.nota.assinatura.CTeSignature;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;

@Root(name = "inutCTe")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTEnviaEventoInutilizacao extends DFBase {
    private static final long serialVersionUID = -2140741787724000417L;

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infInut", required = true)
    private CTEventoInutilizacaoDados dados;

    @Element(name = "Signature", required = false)
    private CTeSignature assinatura;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public CTEventoInutilizacaoDados getDados() {
        return this.dados;
    }

    public void setDados(final CTEventoInutilizacaoDados dados) {
        this.dados = dados;
    }

    public CTeSignature getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(final CTeSignature assinatura) {
        this.assinatura = assinatura;
    }
}