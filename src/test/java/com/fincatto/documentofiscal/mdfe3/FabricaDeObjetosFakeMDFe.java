package com.fincatto.documentofiscal.mdfe3;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoResponsavelSeguro;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoSeguro;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoSeguroInfo;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoSeguroResponsavel;
import java.util.ArrayList;

import java.util.List;

public class FabricaDeObjetosFakeMDFe {

    public static MDFInfoSeguro getMDFInfoSeguro() {
        final MDFInfoSeguro infSeguro = new MDFInfoSeguro();
        infSeguro.setResponsavelSeguro(FabricaDeObjetosFakeMDFe.getMDFInfoSeguroResponsavel());
        infSeguro.setInfo(FabricaDeObjetosFakeMDFe.getMDFInfoSeguroInfo());
        infSeguro.setApolice("12457898653245789865");
        infSeguro.setAverbacao(FabricaDeObjetosFakeMDFe.getMDFInfoSeguroAverbacao());
        return infSeguro;
    }

    public static MDFInfoSeguroResponsavel getMDFInfoSeguroResponsavel() {
        final MDFInfoSeguroResponsavel infSeguroResp = new MDFInfoSeguroResponsavel();
        infSeguroResp.setCnpj("12345678901234");
        infSeguroResp.setResponsavelSeguro(MDFTipoResponsavelSeguro.CONTRATANTE_MDFE);
        return infSeguroResp;
    }

    public static MDFInfoSeguroInfo getMDFInfoSeguroInfo() {
        final MDFInfoSeguroInfo infSeguroInfo = new MDFInfoSeguroInfo();
        infSeguroInfo.setCnpj("12345678901234");
        infSeguroInfo.setSeguradora("891726585917544010862180488469");
        return infSeguroInfo;
    }

    public static List<String> getMDFInfoSeguroAverbacao() {
        final List<String> infSeguroAverbacaoList = new ArrayList<>();
        String infSeguroAverbacao0 = new String("1245789865322154879865325487986532154876");
        infSeguroAverbacaoList.add(infSeguroAverbacao0);
        //
        String infSeguroAverbacao1 = new String("1245789865322154879865325487986532154877");
        infSeguroAverbacaoList.add(infSeguroAverbacao1);
        return infSeguroAverbacaoList;
    }

}
