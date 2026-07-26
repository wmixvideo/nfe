package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTTipoEmissao;
import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte400.classes.CTIndicadorTomador;
import com.fincatto.documentofiscal.cte400.classes.CTModal;
import com.fincatto.documentofiscal.cte400.classes.CTProcessoEmissao;
import com.fincatto.documentofiscal.cte400.classes.CTRetirada;
import com.fincatto.documentofiscal.cte400.classes.CTTipoImpressao;
import com.fincatto.documentofiscal.cte400.classes.CTTipoServico;
import com.fincatto.documentofiscal.cte400.classes.CTTomadorServico;
import com.fincatto.documentofiscal.cte400.classes.CTUnidadeMedida;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoCTeNormalInfoModal;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoCTeNormalInfoCarga;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoCTeNormalInfoCargaInformacoesQuantidadeCarga;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoInformacoesRelativasImpostos;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXParseException;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;

public class CTeNotaSimpTest {

    private static final String CHAVE_44 = "12345678901234567890123456789012345678901234";

    /**
     * Monta um CT-e Simplificado rodoviario, serializa com o Persister da fincatto e valida
     * contra cteSimp_v4.00.xsd. Como o teste nao dispoe de certificado, toda a estrutura de
     * negocio (ide, emit, toma, infCarga, det, infModal, imp, total) deve validar e o unico
     * pendente e o elemento Signature (aplicado no envio por DFAssinaturaDigital sobre "infCte",
     * caminho identico ao do CT-e normal/OS e fora das classes de dominio sob teste).
     */
    @Test
    public void deveSerializarEstruturaValidaAteAssinatura() throws Exception {
        final CTeNotaSimp cteSimp = novoCTeSimpRodoviario();
        final String xml = cteSimp.toString();
        try {
            DFXMLValidador.validaNotaCteSimp400(xml);
            Assert.fail("Esperava falha de validacao apenas pela ausencia da assinatura (Signature)");
        } catch (final SAXParseException e) {
            Assert.assertTrue("Erro de schema inesperado (fora da assinatura): " + e.getMessage(),
                    e.getMessage().contains("Signature"));
        }
    }

    private CTeNotaSimp novoCTeSimpRodoviario() {
        final CTeNotaSimp nota = new CTeNotaSimp();
        nota.setInfCte(infCte());
        return nota;
    }

    private CTeNotaSimpInfo infCte() {
        final CTeNotaSimpInfo info = new CTeNotaSimpInfo();
        info.setVersao("4.00");
        info.setId(CHAVE_44);
        info.setIde(ide());
        info.setEmit(FabricaDeObjetosFake.getInfoEmitente());
        info.setToma(toma());
        info.setInfCarga(infCarga());
        info.setDet(Collections.singletonList(det()));
        info.setInfModal(infModal());
        info.setImp(imp());
        info.setTotal(total());
        return info;
    }

    private CTeNotaInfoCTeNormalInfoModal infModal() {
        final CTeNotaInfoCTeNormalInfoModal infModal = new CTeNotaInfoCTeNormalInfoModal();
        infModal.setVersao("4.00");
        infModal.setRodoviario(FabricaDeObjetosFake.getInfoModalRodoviario());
        return infModal;
    }

    private CTeNotaInfoCTeNormalInfoCarga infCarga() {
        final CTeNotaInfoCTeNormalInfoCarga infCarga = new CTeNotaInfoCTeNormalInfoCarga();
        infCarga.setDescricaoOutrasCaracteristicas("Carga pesada");
        infCarga.setDescricaoProdutoPredominante("Ferro");
        infCarga.setValorAverbacao(new BigDecimal("100000"));
        infCarga.setValorTotalCarga(new BigDecimal("100000"));
        final CTeNotaInfoCTeNormalInfoCargaInformacoesQuantidadeCarga q = new CTeNotaInfoCTeNormalInfoCargaInformacoesQuantidadeCarga();
        q.setQuantidade(BigDecimal.ONE);
        q.setUnidadeMedida(CTUnidadeMedida.M3);
        q.setTipoMedia("00");
        infCarga.setInformacoesQuantidadeCarga(Collections.singletonList(q));
        return infCarga;
    }

    private CTeNotaSimpInfoIdentificacao ide() {
        final CTeNotaSimpInfoIdentificacao ide = new CTeNotaSimpInfoIdentificacao();
        ide.setCUF(DFUnidadeFederativa.SC);
        ide.setCCT("67890123");
        ide.setCFOP("5353");
        ide.setNatOp("Prestacao de servico de transporte");
        ide.setMod(DFModelo.CTE);
        ide.setSerie(1);
        ide.setNCT(123);
        ide.setDhEmi(ZonedDateTime.of(2025, 1, 22, 10, 10, 10, 0, DFConfig.TIMEZONE_SP.toZoneId()));
        ide.setTpImp(CTTipoImpressao.RETRATO);
        ide.setTpEmis(CTTipoEmissao.EMISSAO_NORMAL);
        ide.setCDV(4);
        ide.setTpAmb(DFAmbiente.HOMOLOGACAO);
        ide.setTpCTe("5");
        ide.setProcEmi(CTProcessoEmissao.EMISSOR_CONTRIBUINTE);
        ide.setVerProc("1.00");
        ide.setCMunEnv("4205407");
        ide.setXMunEnv("Floriano");
        ide.setUFEnv("SC");
        ide.setModal(CTModal.RODOVIARIO);
        ide.setTpServ(CTTipoServico.NORMAL);
        ide.setUFIni("SC");
        ide.setUFFim("SC");
        ide.setRetira(CTRetirada.NAO);
        return ide;
    }

    private CTeNotaSimpInfoTomador toma() {
        final CTeNotaSimpInfoTomador toma = new CTeNotaSimpInfoTomador();
        toma.setToma(CTTomadorServico.RECEBEDOR);
        toma.setIndIEToma(CTIndicadorTomador.NAO_CONTRIBUINTE);
        toma.setCNPJ("00000000000011");
        toma.setXNome("CTE EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
        toma.setEnderToma(FabricaDeObjetosFake.getEndereco());
        return toma;
    }

    private CTeNotaSimpInfoDet det() {
        final CTeNotaSimpInfoDet det = new CTeNotaSimpInfoDet();
        det.setNItem("1");
        det.setCMunIni("4205407");
        det.setXMunIni("Floriano");
        det.setCMunFim("4205407");
        det.setXMunFim("Floriano");
        det.setVPrest(new BigDecimal("100.00"));
        det.setVRec(new BigDecimal("100.00"));
        final CTeNotaSimpInfoDetInfNFe nfe = new CTeNotaSimpInfoDetInfNFe();
        nfe.setChNFe(CHAVE_44);
        det.setInfNFe(Collections.singletonList(nfe));
        return det;
    }

    private CTeNotaInfoInformacoesRelativasImpostos imp() {
        final CTeNotaInfoInformacoesRelativasImpostos imp = new CTeNotaInfoInformacoesRelativasImpostos();
        imp.setIcms(FabricaDeObjetosFake.getImpostosICMS());
        return imp;
    }

    private CTeNotaSimpInfoTotal total() {
        final CTeNotaSimpInfoTotal total = new CTeNotaSimpInfoTotal();
        total.setVTPrest(new BigDecimal("100.00"));
        total.setVTRec(new BigDecimal("100.00"));
        return total;
    }
}
