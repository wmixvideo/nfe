package com.fincatto.cte300.classes.statusservico.consulta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.cte300.FabricaDeObjetosFakeCTe;
import com.fincatto.cte300.classes.statusservico.consulta.CTStatusServicoConsultaRetorno;
import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFUnidadeFederativa;

public class CTStatusServicoConsultaRetornoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final CTStatusServicoConsultaRetorno consultaRetorno = new CTStatusServicoConsultaRetorno();
        final String versao = "2.00";
        consultaRetorno.setVersao(versao);
        Assert.assertEquals(versao, consultaRetorno.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final CTStatusServicoConsultaRetorno consultaRetorno = new CTStatusServicoConsultaRetorno();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        consultaRetorno.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, consultaRetorno.getAmbiente());
    }

    @Test
    public void deveObterVersaoAplicacaoComoFoiSetado() {
        final CTStatusServicoConsultaRetorno consultaRetorno = new CTStatusServicoConsultaRetorno();
        final String versaoAplicacao = "1.01";
        consultaRetorno.setVersaoAplicacao(versaoAplicacao);
        Assert.assertEquals(versaoAplicacao, consultaRetorno.getVersaoAplicacao());
    }

    @Test
    public void deveObterStatusComoFoiSetado() {
        final CTStatusServicoConsultaRetorno consultaRetorno = new CTStatusServicoConsultaRetorno();
        final String status = "107";
        consultaRetorno.setStatus(status);
        Assert.assertEquals(status, consultaRetorno.getStatus());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final CTStatusServicoConsultaRetorno consultaRetorno = new CTStatusServicoConsultaRetorno();
        final String motivo = "Servico em operacao";
        consultaRetorno.setMotivo(motivo);
        Assert.assertEquals(motivo, consultaRetorno.getMotivo());
    }

    @Test
    public void deveObterUFComoFoiSetado() {
        final CTStatusServicoConsultaRetorno consultaRetorno = new CTStatusServicoConsultaRetorno();
        final DFUnidadeFederativa unidadeFederativa = DFUnidadeFederativa.AC;
        consultaRetorno.setUf(unidadeFederativa);
        Assert.assertEquals(unidadeFederativa, consultaRetorno.getUf());
    }

    @Test
    public void deveObterDataRecebimentoComoFoiSetado() throws ParseException {
        final CTStatusServicoConsultaRetorno consultaRetorno = new CTStatusServicoConsultaRetorno();
        final Date dataRecebimento = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse("2017-01-05T19:19:09");
        consultaRetorno.setDataRecebimento(dataRecebimento);
        Assert.assertEquals(dataRecebimento, consultaRetorno.getDataRecebimento());
    }

    @Test
    public void deveObterDataRetornoComoFoiSetado() throws ParseException {
        final CTStatusServicoConsultaRetorno consultaRetorno = new CTStatusServicoConsultaRetorno();
        final Date dataRetorno = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse("2017-01-05T19:19:09");
        consultaRetorno.setDataRetorno(dataRetorno);
        Assert.assertEquals(dataRetorno, consultaRetorno.getDataRetorno());
    }

    @Test
    public void deveObterObservacaoComoFoiSetado() {
        final CTStatusServicoConsultaRetorno consultaRetorno = new CTStatusServicoConsultaRetorno();
        final String observacao = "Sem informacao";
        consultaRetorno.setObservacao(observacao);
        Assert.assertEquals(observacao, consultaRetorno.getObservacao());
    }

    @Test
    public void deveObterTempoMedioComoFoiSetado() {
        final CTStatusServicoConsultaRetorno consultaRetorno = new CTStatusServicoConsultaRetorno();
        final String tempoMedio = "10";
        consultaRetorno.setTempoMedio(tempoMedio);
        Assert.assertEquals(tempoMedio, consultaRetorno.getTempoMedio());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() throws ParseException {
        final String xmlEsperado = "<retConsStatServCte versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/cte\"><tpAmb>1</tpAmb><verAplic>1.01</verAplic><cStat>107</cStat><xMotivo>Servico em Operacao</xMotivo><cUF>52</cUF><dhRecbto>2017-01-05T19:19:09</dhRecbto><dhRetorno>2017-01-05T19:19:09</dhRetorno><xObs>Teste</xObs><tMed>10</tMed></retConsStatServCte>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFakeCTe.getCTStatusServicoConsultaRetorno().toString());
    }
}