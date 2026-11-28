package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTTipoEmissao;
import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte400.classes.CTFinalidade;
import com.fincatto.documentofiscal.cte400.classes.CTIndicadorTomador;
import com.fincatto.documentofiscal.cte400.classes.CTModal;
import com.fincatto.documentofiscal.cte400.classes.CTProcessoEmissao;
import com.fincatto.documentofiscal.cte400.classes.CTTipoImpressao;
import com.fincatto.documentofiscal.cte400.classes.CTTipoRegimeTributario;
import com.fincatto.documentofiscal.cte400.classes.CTTipoServicoOS;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXParseException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class CTeOSTest {

    /**
     * Monta um CT-e OS com os grupos da NT 2026.004 (gCompraGov, vTPrestLiq e gICMSPrevistoPagtoAntecip)
     * e valida contra cteOS_v4.00.xsd. Sem certificado, o unico erro esperado e a ausencia da Signature.
     */
    @Test
    public void deveValidarGruposDaNT2026004ContraXSD() throws Exception {
        final CTeOS cteOS = new CTeOS();
        cteOS.setVersao("4.00");
        cteOS.setInfo(info());
        try {
            DFXMLValidador.validaNotaCTeOS400(cteOS.toString());
            Assertions.fail("Esperava falha de validacao apenas pela ausencia da assinatura (Signature)");
        } catch (final SAXParseException e) {
            Assertions.assertTrue(e.getMessage().contains("Signature"), e.getMessage());
        }
    }

    @Test
    public void deveGerarGrupoCompraGovernamentalAposJustificativa() {
        final CTeOSInfoIdentificacao identificacao = identificacao();
        identificacao.setDataContingencia(LocalDateTime.of(2025, 1, 22, 10, 10, 10));
        identificacao.setJustificativa("Justificativa de contingencia");
        final String xml = identificacao.toString();
        Assertions.assertTrue(xml.endsWith("<xJust>Justificativa de contingencia</xJust><gCompraGov><tpEnteGov>1</tpEnteGov><pRedutor>10.00</pRedutor><tpOperGov>2</tpOperGov><refDFeAnt>12345678901234567890123456789012345678901234</refDFeAnt></gCompraGov></ide>"), xml);
    }

    @Test
    public void deveGerarValorLiquidoEntreTotalEReceber() {
        Assertions.assertEquals("<vPrest xmlns=\"http://www.portalfiscal.inf.br/cte\"><vTPrest>100.00</vTPrest><vTPrestLiq>90.00</vTPrestLiq><vRec>100.00</vRec></vPrest>", valorPrestacao().toString());
    }

    @Test
    public void naoDeveGerarValorLiquidoQuandoNulo() {
        final CTeOSInfoValorPrestacaoServico valor = valorPrestacao();
        valor.setValorTotalLiquidoPrestacaoServico(null);
        Assertions.assertEquals("<vPrest xmlns=\"http://www.portalfiscal.inf.br/cte\"><vTPrest>100.00</vTPrest><vRec>100.00</vRec></vPrest>", valor.toString());
    }

    @Test
    public void valorLiquidoNaoDeveExtrapolarTamanho() {
        final CTeOSInfoValorPrestacaoServico valor = new CTeOSInfoValorPrestacaoServico();
        Assertions.assertThrows(NumberFormatException.class, () -> valor.setValorTotalLiquidoPrestacaoServico(new BigDecimal("12345678901234")));
        Assertions.assertThrows(NumberFormatException.class, () -> valor.setValorTotalLiquidoPrestacaoServico(new BigDecimal("1.123")));
    }

    @Test
    public void deveGerarGrupoIcmsPrevisto() {
        Assertions.assertEquals("<ICMS xmlns=\"http://www.portalfiscal.inf.br/cte\"><gICMSPrevistoPagtoAntecip><vICMSPrevisto>17.00</vICMSPrevisto></gICMSPrevistoPagtoAntecip></ICMS>", icms().toString());
    }

    @Test
    public void naoDeveGerarGrupoIcmsPrevistoQuandoNulo() {
        Assertions.assertFalse(new CTeOSInfoInformacoesRelativasImpostosICMS().toString().contains("gICMSPrevistoPagtoAntecip"));
    }

    private CTeOSInfo info() {
        final CTeOSInfo info = new CTeOSInfo();
        info.setVersao("4.00");
        info.setIdentificador("42250112345678000190670010000001231678901234");
        info.setIdentificacao(identificacao());
        info.setEmitente(emitente());
        info.setTomador(tomador());
        info.setValorPrestacaoServico(valorPrestacao());
        final CTeOSInfoInformacoesRelativasImpostos impostos = new CTeOSInfoInformacoesRelativasImpostos();
        impostos.setIcms(icms());
        info.setInformacoesRelativasImpostos(impostos);
        info.setCteNormal(cteNormal());
        return info;
    }

    private CTeOSInfoIdentificacao identificacao() {
        final CTeOSInfoIdentificacao ide = new CTeOSInfoIdentificacao();
        ide.setCodigoUF(DFUnidadeFederativa.SC);
        ide.setCodigoNumerico("67890123");
        ide.setCfop("5357");
        ide.setNaturezaOperacao("Prestacao de servico de transporte");
        ide.setModelo(DFModelo.CTeOS);
        ide.setSerie(1);
        ide.setNumero(123);
        ide.setDataEmissao(ZonedDateTime.of(2025, 1, 22, 10, 10, 10, 0, DFConfig.TIMEZONE_SP.toZoneId()));
        ide.setTipoImpressao(CTTipoImpressao.RETRATO);
        ide.setTipoEmissao(CTTipoEmissao.EMISSAO_NORMAL);
        ide.setDigitoVerificador(4);
        ide.setAmbiente(DFAmbiente.HOMOLOGACAO);
        ide.setFinalidade(CTFinalidade.NORMAL);
        ide.setProcessoEmissao(CTProcessoEmissao.EMISSOR_CONTRIBUINTE);
        ide.setVersaoProcessoEmissao("1.00");
        ide.setCodigoMunicipioEnvio("4205407");
        ide.setDescricaoMunicipioEnvio("Floriano");
        ide.setSiglaUFEnvio("SC");
        ide.setModalidadeFrete(CTModal.RODOVIARIO);
        ide.setTipoServico(CTTipoServicoOS.TRANSPORTE_DE_PESSOAS);
        ide.setIndIEToma(CTIndicadorTomador.NAO_CONTRIBUINTE);
        ide.setCodigoMunicipioInicio("4205407");
        ide.setDescricaoMunicipioInicio("Floriano");
        ide.setSiglaUfInicio("SC");
        ide.setCodigoMunicipioFim("4205407");
        ide.setDescricaoMunicipioFim("Floriano");
        ide.setSiglaUfFim("SC");
        ide.setGrupoCompraGovernamental(FabricaDeObjetosFake.getGrupoCompraGovernamental());
        return ide;
    }

    private CTeOSInfoEmitente emitente() {
        final CTeOSEnderecoEmitente endereco = new CTeOSEnderecoEmitente();
        endereco.setLogradouro("RUA ANITA GARIBALDI");
        endereco.setNumero("1");
        endereco.setBairro("CENTRO");
        endereco.setCodigoMunicipio("4205407");
        endereco.setDescricaoMunicipio("Floriano");
        endereco.setCep("88010500");
        endereco.setSiglaUF("SC");
        final CTeOSInfoEmitente emitente = new CTeOSInfoEmitente();
        emitente.setCnpj("12345678000190");
        emitente.setInscricaoEstadual("123456789");
        emitente.setRazaoSocial("CTE EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
        emitente.setEnderEmit(endereco);
        emitente.setTipoRegimeTributario(CTTipoRegimeTributario.REGIME_NORMAL);
        return emitente;
    }

    private CTeOSInfoIdentificacaoTomador tomador() {
        final CTeOSEndereco endereco = new CTeOSEndereco();
        endereco.setLogradouro("RUA ANITA GARIBALDI");
        endereco.setNumero("1");
        endereco.setBairro("CENTRO");
        endereco.setCodigoMunicipio("4205407");
        endereco.setDescricaoMunicipio("Floriano");
        endereco.setSiglaUF("SC");
        final CTeOSInfoIdentificacaoTomador tomador = new CTeOSInfoIdentificacaoTomador();
        tomador.setCnpj("00000000000011");
        tomador.setRazaoSocial("CTE EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
        tomador.setEnderTomadorServico(endereco);
        return tomador;
    }

    private CTeOSInfoValorPrestacaoServico valorPrestacao() {
        final CTeOSInfoValorPrestacaoServico valor = new CTeOSInfoValorPrestacaoServico();
        valor.setValorTotalPrestacaoServico(new BigDecimal("100"));
        valor.setValorTotalLiquidoPrestacaoServico(new BigDecimal("90"));
        valor.setValorReceber(new BigDecimal("100"));
        return valor;
    }

    private CTeOSInfoInformacoesRelativasImpostosICMS icms() {
        final CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip previsto = new CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip();
        previsto.setValorICMSPrevisto(new BigDecimal("17"));
        final CTeOSInfoInformacoesRelativasImpostosICMS icms = new CTeOSInfoInformacoesRelativasImpostosICMS();
        icms.setGrupoIcmsPrevistoPagamentoAntecipado(previsto);
        return icms;
    }

    private CTeOSInfoCTeNormal cteNormal() {
        final CTeOSInfoCTeNormalInfoServico servico = new CTeOSInfoCTeNormalInfoServico();
        servico.setDescricaoServico("Transporte de pessoas");
        final CTeOSInfoCTeNormalInfoModal modal = new CTeOSInfoCTeNormalInfoModal();
        modal.setVersao("4.00");
        modal.setRodoviario(new CTeOSInfoCTeNormalInfoModalRodoviario());
        final CTeOSInfoCTeNormal normal = new CTeOSInfoCTeNormal();
        normal.setInfoCarga(servico);
        normal.setInfoModal(modal);
        return normal;
    }
}
