package com.fincatto.documentofiscal.cte400.classes.evento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.nota.assinatura.CTeSignature;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "eventoCTe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeEvento extends DFBase {
    private static final long serialVersionUID = 1427772563112875017L;

    @Attribute(name = "versao")
    private String versao;
    
    @Element(name = "infEvento")
    private CTeInfoEvento infoEvento;

    @Element(name = "Signature", required = false)
    private CTeSignature assinatura;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public CTeInfoEvento getInfoEvento() {
        return this.infoEvento;
    }

    public void setInfoEvento(final CTeInfoEvento infoEvento) {
        this.infoEvento = infoEvento;
    }

    public CTeSignature getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(final CTeSignature assinatura) {
        this.assinatura = assinatura;
    }
}