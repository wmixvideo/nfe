package com.fincatto.nfe310.classes.nota.consulta;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFProtocolo;
import com.fincatto.nfe310.classes.NFProtocoloInfo;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.evento.NFEvento;
import com.fincatto.nfe310.classes.evento.NFEventoRetorno;
import com.fincatto.nfe310.classes.evento.NFInfoEvento;
import com.fincatto.nfe310.classes.evento.NFInfoEventoRetorno;
import com.fincatto.nfe310.classes.evento.NFTipoEvento;
import com.fincatto.nfe310.classes.evento.cancelamento.NFRetornoCancelamento;
import java.math.BigDecimal;
import org.joda.time.DateTime;

public class NFNotaConsultaRetornoTest {

  @Test
  public void deveObterVersaoComoFoiSetado() {
    final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
    final String versao = "3.10";
    consultaRetorno.setVersao(versao);
    Assert.assertEquals(versao, consultaRetorno.getVersao());
  }

  @Test
  public void deveObterAmbienteComoFoiSetado() {
    final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
    final NFAmbiente ambiente = NFAmbiente.HOMOLOGACAO;
    consultaRetorno.setAmbiente(ambiente);
    Assert.assertEquals(ambiente, consultaRetorno.getAmbiente());
  }

  @Test
  public void deveObterChaveComoFoiSetado() {
    final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
    final String chave = "70460574637515066066966657989989378421243260";
    consultaRetorno.setChave(chave);
    Assert.assertEquals(chave, consultaRetorno.getChave());
  }

  @Test
  public void deveObterDataHoraReciboComoFoiSetado() {
    final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
    final LocalDateTime dataHoraRecibo = LocalDateTime.parse("2010-10-10 10:10:10", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
    consultaRetorno.setDataHoraRecibo(dataHoraRecibo);
    Assert.assertEquals(dataHoraRecibo, consultaRetorno.getDataHoraRecibo());
  }

  @Test
  public void deveObterMotivoComoFoiSetado() {
    final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
    final String motivo = "Motivo simples";
    consultaRetorno.setMotivo(motivo);
    Assert.assertEquals(motivo, consultaRetorno.getMotivo());
  }

  @Test
  public void deveObterProtocoloComoFoiSetado() {
    final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
    final NFProtocolo protocolo = FabricaDeObjetosFake.getNFProtocolo();
    consultaRetorno.setProtocolo(protocolo);
    Assert.assertEquals(protocolo, consultaRetorno.getProtocolo());
  }

  @Test
  public void deveObterStatusComoFoiSetado() {
    final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
    final String status = "190";
    consultaRetorno.setStatus(status);
    Assert.assertEquals(status, consultaRetorno.getStatus());
  }

  @Test
  public void deveObterUfComoFoiSetado() {
    final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
    final NFUnidadeFederativa unidadeFederativa = NFUnidadeFederativa.AL;
    consultaRetorno.setUf(unidadeFederativa);
    Assert.assertEquals(unidadeFederativa, consultaRetorno.getUf());
  }

  @Test
  public void deveObterVersaoAplicativoComoFoiSetado() {
    final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
    final String versaoAplicacao = "v10.0";
    consultaRetorno.setVersaoAplicacao(versaoAplicacao);
    Assert.assertEquals(versaoAplicacao, consultaRetorno.getVersaoAplicacao());
  }

  @Test
  public void deveObterProtocoloCancelamentoComoFoiSetado() {
    final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
    final NFRetornoCancelamento protocoloCancelamento = new NFRetornoCancelamento();
    consultaRetorno.setProtocoloCancelamento(protocoloCancelamento);
    Assert.assertEquals(protocoloCancelamento, consultaRetorno.getProtocoloCancelamento());
  }

  @Test
  public void deveObterProtocoloEventoComoFoiSetado() {
    final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
    final List<NFProtocoloEvento> protocoloEvento = new ArrayList<>();
    consultaRetorno.setProtocoloEvento(protocoloEvento);
    Assert.assertEquals(protocoloEvento, consultaRetorno.getProtocoloEvento());
  }

  /**
   * Futuramente testar cada classe/XML retornada para identificar facilmente onde ocorre erros
   */
  @Test
  public void deveGerarXMLDeAcordoComOPadraoEstabelecidoParaMultiplosEventosRetornados() {
    {/*INICIO - CONSULTA RETORNO*/
      final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
      consultaRetorno.setVersao("3.10");
      consultaRetorno.setAmbiente(NFAmbiente.HOMOLOGACAO);
      consultaRetorno.setVersaoAplicacao("SVRS201601160949");
      consultaRetorno.setStatus("101");
      consultaRetorno.setMotivo("Cancelamento de NF-e homologado");
      consultaRetorno.setUf(NFUnidadeFederativa.ES);
      consultaRetorno.setDataHoraRecibo(new LocalDateTime(2016, 9, 26, 11, 24, 22));
      consultaRetorno.setChave("32160815691577000164550010000010431771198745");

      {/*INICIO - PROTOCOLO*/
        final NFProtocolo protocolo = new NFProtocolo();
        protocolo.setVersao("3.10");

        {/*INICIO - PROTOCOLO INFO*/
          final NFProtocoloInfo protocoloInfo = new NFProtocoloInfo();
          protocoloInfo.setIdentificador("ID332160000086058");
          protocoloInfo.setAmbiente(NFAmbiente.HOMOLOGACAO);
          protocoloInfo.setVersaoAplicacao("SVRS201608011111");
          protocoloInfo.setChave("32160815691577000164550010000010431771198745");
          protocoloInfo.setDataRecebimento("2016-08-24T22:47:32-03:00");
          protocoloInfo.setNumeroProtocolo("332160000086058");
          protocoloInfo.setValidador("039gMJO+FySMAapc6n1A14SZBgg=");
          protocoloInfo.setStatus("100");
          protocoloInfo.setMotivo("Autorizado o uso da NF-e");
          protocolo.setProtocoloInfo(protocoloInfo);
        }/*FIM - PROTOCOLO INFO*/

        consultaRetorno.setProtocolo(protocolo);
      }/*FIM - PROTOCOLO*/

      {/*INICIO - EVENTOS*/
        final List<NFProtocoloEvento> protocoloEvento = new ArrayList<>();

        {/*INICIO - PROTOCOLO EVENTO - CARTA CORRECAO 1*/
          final NFProtocoloEvento protEventoCartaCorrecao = new NFProtocoloEvento();
          protEventoCartaCorrecao.setVersao("3.10");

          {/*INICIO - EVENTO - CARTA CORRECAO 1*/
            final NFEvento eventoCartaCorrecao = new NFEvento();
            eventoCartaCorrecao.setVersao(new BigDecimal("3.10"));
            //eventoCartaCorrecao.setAssinatura(assinatura); // assinatura ignorada para testar

            {/*INICIO - INFO EVENTO - CARTA CORRECAO 1*/
              final NFInfoEvento nfInfEventoCartaCorrecao = new NFInfoEvento();
              nfInfEventoCartaCorrecao.setId("ID1101103216081569157700016455001000001043177119874501");
              nfInfEventoCartaCorrecao.setOrgao(NFUnidadeFederativa.ES);
              nfInfEventoCartaCorrecao.setAmbiente(NFAmbiente.HOMOLOGACAO);
              nfInfEventoCartaCorrecao.setCnpj("15691577000164");
              nfInfEventoCartaCorrecao.setChave("32160815691577000164550010000010431771198745");
              nfInfEventoCartaCorrecao.setDataHoraEvento(new DateTime(2016, 8, 24, 22, 48, 1));
              nfInfEventoCartaCorrecao.setTipoEvento("110110");
              nfInfEventoCartaCorrecao.setNumeroSequencialEvento(1);
              nfInfEventoCartaCorrecao.setVersaoEvento(new BigDecimal("1.00"));

              {/*INICIO - TIPO EVENTO - CARTA CORRECAO 1*/
                final NFTipoEvento detEventoCartaCorrecao = new NFTipoEvento();
                detEventoCartaCorrecao.setVersao(new BigDecimal("1.00"));
                detEventoCartaCorrecao.setDescricaoEvento("Carta de Correcao");
                detEventoCartaCorrecao.setTextoCorrecao("TesteTesteTesteTeste1");
                detEventoCartaCorrecao.setCondicaoUso("A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.");

                nfInfEventoCartaCorrecao.setDadosEvento(detEventoCartaCorrecao);
              }/*FIM - TIPO EVENTO - CARTA CORRECAO 1*/

              eventoCartaCorrecao.setInfoEvento(nfInfEventoCartaCorrecao);
            }/*FIM - INFO EVENTO - CARTA CORRECAO 1*/

            protEventoCartaCorrecao.setEvento(eventoCartaCorrecao);
          }/*FIM - EVENTO - CARTA CORRECAO 1*/

          {
            final NFEventoRetorno nfEventoRetornoCartaCorrecao = new NFEventoRetorno();
            nfEventoRetornoCartaCorrecao.setVersao("1.10");

            {
              final NFInfoEventoRetorno infoEventoRetorno = new NFInfoEventoRetorno();
              infoEventoRetorno.setAmbiente(NFAmbiente.HOMOLOGACAO);
              infoEventoRetorno.setVersaoAplicativo("SVRS201601161016");
              infoEventoRetorno.setOrgao(NFUnidadeFederativa.ES);
              infoEventoRetorno.setCodigoStatus(135);
              infoEventoRetorno.setMotivo("Evento registrado e vinculado a NF-e");
              infoEventoRetorno.setChave("32160815691577000164550010000010431771198745");
              infoEventoRetorno.setTipoEvento("110110");
              infoEventoRetorno.setNumeroSequencialEvento(1);
              infoEventoRetorno.setCpnj("13335111000109");
              infoEventoRetorno.setDataHoraRegistro(new LocalDateTime(2016, 8, 24, 22, 48, 49));
              infoEventoRetorno.setNumeroProtocolo("332160000086059");
              nfEventoRetornoCartaCorrecao.setInfoEventoRetorno(infoEventoRetorno);
            }

            protEventoCartaCorrecao.setEventoRetorno(nfEventoRetornoCartaCorrecao);
          }

          protocoloEvento.add(protEventoCartaCorrecao);
        }/*FIM - PROTOCOLO EVENTO - CARTA CORRECAO 1*/

        {/*INICIO - PROTOCOLO EVENTO - CANCELAMENTO*/
          final NFProtocoloEvento protEventoCancelamento = new NFProtocoloEvento();
          protEventoCancelamento.setVersao("3.10");

          {/*INICIO - EVENTO - CANCELAMENTO*/
            final NFEvento eventoCancelamento = new NFEvento();
            eventoCancelamento.setVersao(new BigDecimal("3.10"));
            //eventoCartaCorrecao.setAssinatura(assinatura); // assinatura ignorada para testar

            {/*INICIO - INFO EVENTO - CANCELAMENTO*/
              final NFInfoEvento nfInfEventoCancelamento = new NFInfoEvento();
              nfInfEventoCancelamento.setId("ID1101113216081569157700016455001000001043177119874501");
              nfInfEventoCancelamento.setOrgao(NFUnidadeFederativa.ES);
              nfInfEventoCancelamento.setAmbiente(NFAmbiente.HOMOLOGACAO);
              nfInfEventoCancelamento.setCnpj("15691577000164");
              nfInfEventoCancelamento.setChave("32160815691577000164550010000010431771198745");
              nfInfEventoCancelamento.setDataHoraEvento(new DateTime(2016, 8, 24, 23, 9, 54));
              nfInfEventoCancelamento.setTipoEvento("110111");
              nfInfEventoCancelamento.setNumeroSequencialEvento(1);
              nfInfEventoCancelamento.setVersaoEvento(new BigDecimal("1.00"));

              {/*INICIO - TIPO EVENTO - CANCELAMENTO*/
                final NFTipoEvento detEventoCancelamento = new NFTipoEvento();
                detEventoCancelamento.setVersao(new BigDecimal("1.00"));
                detEventoCancelamento.setDescricaoEvento("Cancelamento");
                detEventoCancelamento.setProtocoloAutorizacao("332160000086058");
                detEventoCancelamento.setJustificativa("TesteTesteTeste");

                nfInfEventoCancelamento.setDadosEvento(detEventoCancelamento);
              }/*FIM - TIPO EVENTO - CANCELAMENTO*/

              eventoCancelamento.setInfoEvento(nfInfEventoCancelamento);
            }/*FIM - INFO EVENTO - CANCELAMENTO*/

            protEventoCancelamento.setEvento(eventoCancelamento);
          }/*FIM - EVENTO - CANCELAMENTO*/

          {
            final NFEventoRetorno nfEventoRetornoCartaCorrecao = new NFEventoRetorno();
            nfEventoRetornoCartaCorrecao.setVersao("1.10");

            {
              final NFInfoEventoRetorno infoEventoRetorno = new NFInfoEventoRetorno();
              infoEventoRetorno.setAmbiente(NFAmbiente.HOMOLOGACAO);
              infoEventoRetorno.setVersaoAplicativo("SVRS201601161016");
              infoEventoRetorno.setOrgao(NFUnidadeFederativa.ES);
              infoEventoRetorno.setCodigoStatus(135);
              infoEventoRetorno.setMotivo("Evento registrado e vinculado a NF-e");
              infoEventoRetorno.setChave("32160815691577000164550010000010431771198745");
              infoEventoRetorno.setTipoEvento("110111");
              infoEventoRetorno.setNumeroSequencialEvento(1);
              infoEventoRetorno.setCpnj("13335111000109");
              infoEventoRetorno.setDataHoraRegistro(new LocalDateTime(2016, 8, 24, 23, 10, 41));
              infoEventoRetorno.setNumeroProtocolo("332160000086062");

              nfEventoRetornoCartaCorrecao.setInfoEventoRetorno(infoEventoRetorno);
            }

            protEventoCancelamento.setEventoRetorno(nfEventoRetornoCartaCorrecao);
          }

          protocoloEvento.add(protEventoCancelamento);
        }/*FIM - PROTOCOLO EVENTO - CANCELAMENTO*/

        consultaRetorno.setProtocoloEvento(protocoloEvento);
      }/*FIM - EVENTOS*/

      final String xmlEsperado = "<retConsSitNFe versao=\"3.10\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>2</tpAmb><verAplic>SVRS201601160949</verAplic><cStat>101</cStat><xMotivo>Cancelamento de NF-e homologado</xMotivo><cUF>32</cUF><dhRecbto>2016-09-26T11:24:22-03:00</dhRecbto><chNFe>32160815691577000164550010000010431771198745</chNFe><protNFe versao=\"3.10\"><infProt Id=\"ID332160000086058\"><tpAmb>2</tpAmb><verAplic>SVRS201608011111</verAplic><chNFe>32160815691577000164550010000010431771198745</chNFe><dhRecbto>2016-08-24T22:47:32-03:00</dhRecbto><nProt>332160000086058</nProt><digVal>039gMJO+FySMAapc6n1A14SZBgg=</digVal><cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo></infProt></protNFe><procEventoNFe versao=\"3.10\"><evento versao=\"3.10\"><infEvento Id=\"ID1101103216081569157700016455001000001043177119874501\"><cOrgao>32</cOrgao><tpAmb>2</tpAmb><CNPJ>15691577000164</CNPJ><chNFe>32160815691577000164550010000010431771198745</chNFe><dhEvento>2016-08-24T22:48:01-03:00</dhEvento><tpEvento>110110</tpEvento><nSeqEvento>1</nSeqEvento><verEvento>1.00</verEvento><detEvento versao=\"1.00\"><descEvento>Carta de Correcao</descEvento><xCorrecao>TesteTesteTesteTeste1</xCorrecao><xCondUso>A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.</xCondUso></detEvento></infEvento></evento><retEvento versao=\"1.10\"><infEvento><tpAmb>2</tpAmb><verAplic>SVRS201601161016</verAplic><cOrgao>32</cOrgao><cStat>135</cStat><xMotivo>Evento registrado e vinculado a NF-e</xMotivo><chNFe>32160815691577000164550010000010431771198745</chNFe><tpEvento>110110</tpEvento><nSeqEvento>1</nSeqEvento><CNPJDest>13335111000109</CNPJDest><dhRegEvento>2016-08-24T22:48:49-03:00</dhRegEvento><nProt>332160000086059</nProt></infEvento></retEvento></procEventoNFe><procEventoNFe versao=\"3.10\"><evento versao=\"3.10\"><infEvento Id=\"ID1101113216081569157700016455001000001043177119874501\"><cOrgao>32</cOrgao><tpAmb>2</tpAmb><CNPJ>15691577000164</CNPJ><chNFe>32160815691577000164550010000010431771198745</chNFe><dhEvento>2016-08-24T23:09:54-03:00</dhEvento><tpEvento>110111</tpEvento><nSeqEvento>1</nSeqEvento><verEvento>1.00</verEvento><detEvento versao=\"1.00\"><descEvento>Cancelamento</descEvento><nProt>332160000086058</nProt><xJust>TesteTesteTeste</xJust></detEvento></infEvento></evento><retEvento versao=\"1.10\"><infEvento><tpAmb>2</tpAmb><verAplic>SVRS201601161016</verAplic><cOrgao>32</cOrgao><cStat>135</cStat><xMotivo>Evento registrado e vinculado a NF-e</xMotivo><chNFe>32160815691577000164550010000010431771198745</chNFe><tpEvento>110111</tpEvento><nSeqEvento>1</nSeqEvento><CNPJDest>13335111000109</CNPJDest><dhRegEvento>2016-08-24T23:10:41-03:00</dhRegEvento><nProt>332160000086062</nProt></infEvento></retEvento></procEventoNFe></retConsSitNFe>";

      Assert.assertEquals(xmlEsperado, consultaRetorno.toString());

    }/*FIM - CONSULTA RETORNO*/
  }
}
