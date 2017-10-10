package com.fincatto.documentofiscal.cte300.classes.evento.cancelamento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "evento")
public class CTeEventoCancelamento extends DFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infEvento", required = true)
    private CTeInfoEventoCancelamento infoEvento;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;




}