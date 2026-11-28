package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXParseException;

import java.math.BigDecimal;

public class CTeNotaXSDTest {

    /**
     * Monta um CT-e com os grupos da NT 2026.004 (gCompraGov, vTPrestLiq e gICMSPrevistoPagtoAntecip)
     * e valida contra cte_v4.00.xsd. Sem certificado, o unico erro esperado e a ausencia da Signature.
     */
    @Test
    public void deveValidarGruposNovosContraXSD() throws Exception {
        final CTeNotaInfo info = FabricaDeObjetosFake.getCTeNotaInfo();
        info.setVersao("4.00");
        // compl da fabrica esta incompleto para o XSD 4.00 e nao tem relacao com a NT
        info.setDadosComplementares(null);
        info.getCteNormal().getInfoModal().setVersao("4.00");
        // fatura da fabrica tem vDesc=0.00, rejeitado pelo TDec_1302Opc
        info.getCteNormal().setCobranca(null);
        info.getIdentificacao().setGrupoCompraGovernamental(FabricaDeObjetosFake.getGrupoCompraGovernamental());
        info.getValorPrestacaoServico().setValorTotalLiquidoPrestacaoServico(new BigDecimal("90"));

        final CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip previsto = new CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip();
        previsto.setValorICMSPrevisto(new BigDecimal("17"));
        final CTeNotaInfoInformacoesRelativasImpostosICMS icms = new CTeNotaInfoInformacoesRelativasImpostosICMS();
        icms.setGrupoIcmsPrevistoPagamentoAntecipado(previsto);
        info.getInformacoesRelativasImpostos().setIcms(icms);
        // ICMSUFFim gera pICMSInterPart, que o XSD 4.00 nao aceita (fora do escopo da NT)
        info.getInformacoesRelativasImpostos().setIcmsPartilha(null);

        final CTeNota nota = new CTeNota();
        nota.setCteNotaInfo(info);
        try {
            DFXMLValidador.validaNotaCte400(nota.toString());
            Assertions.fail("Esperava falha de validacao apenas pela ausencia da assinatura (Signature)");
        } catch (final SAXParseException e) {
            Assertions.assertTrue(e.getMessage().contains("Signature"), e.getMessage());
        }
    }
}
