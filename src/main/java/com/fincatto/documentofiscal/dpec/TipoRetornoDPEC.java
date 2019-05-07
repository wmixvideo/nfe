package com.fincatto.documentofiscal.dpec;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;



/**
 *
 * Created by Eldevan Nery Junior on 15/01/19.
 *
 * Tipo Retorno da Declaração Prévia de Emissão em Contignência - DPEC
 *
 */
@Root(name = "TRetDPEC")
public class TipoRetornoDPEC  extends DFBase {

    @Attribute(name = "versao")
    private String versao = TipoDPEC.VERSAO_DPEC;

    @Element(name = "Signature")
    private NFSignature assinatura;

    @Element(name = "infDPECReg")
    private InformacoesDPECReg infDPECReg;

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public NFSignature getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(NFSignature assinatura) {
        this.assinatura = assinatura;
    }

    public InformacoesDPECReg getInfDPECReg() {
        return infDPECReg;
    }

    public void setInfDPECReg(InformacoesDPECReg infDPECReg) {
        this.infDPECReg = infDPECReg;
    }
}
