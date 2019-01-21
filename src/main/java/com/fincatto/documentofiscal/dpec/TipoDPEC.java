package com.fincatto.documentofiscal.dpec;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Eldevan Nery Junior on 15/01/19.
 *
 * Tipo Declaração Prévia de Emissão em Contingência - DPEC
 *
 */
@Root(name = "TDPEC")
public class TipoDPEC extends DFBase {

    public static String VERSAO_DPEC = "1.01";

    @Attribute(name = "versao")
    private String versao = VERSAO_DPEC;

    @Element(name = "infDPEC")
    protected InformacoesDPEC informacoesDeclaracaoPreviaEC;

    @Element(name = "Signature")
    private NFSignature assinatura;

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public InformacoesDPEC getInformacoesDeclaracaoPreviaEC() {
        return informacoesDeclaracaoPreviaEC;
    }

    public void setInformacoesDeclaracaoPreviaEC(InformacoesDPEC informacoesDeclaracaoPreviaEC) {
        this.informacoesDeclaracaoPreviaEC = informacoesDeclaracaoPreviaEC;
    }

    public NFSignature getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(NFSignature assinatura) {
        this.assinatura = assinatura;
    }
}
