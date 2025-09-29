#!/bin/bash
#
# Script para aplicar automaticamente as modificações locais na biblioteca Fincatto NFe.
#

set -e
echo "================================================="
echo "Iniciando a aplicação de patches locais..."
echo "================================================="

# --- 1. Aplicar patch com todas as modificações ---
echo "[1/1] Aplicando patch com as modificações..."

git apply <<'EOF'
diff --git a/pom.xml b/pom.xml
index 30897a6f..5101e097 100644
--- a/pom.xml
+++ b/pom.xml
@@ -32,7 +32,7 @@
     </developers>
 
     <properties>
-        <java.version>11</java.version>
+        <java.version>1.8</java.version>
         <slf4j.version>2.0.13</slf4j.version>
         <junit.version>4.13.2</junit.version>
         <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
@@ -47,7 +47,7 @@
         <dependency>
             <groupId>org.apache.santuario</groupId>
             <artifactId>xmlsec</artifactId>
-            <version>4.0.2</version>
+            <version>3.0.6</version>
         </dependency>
 
         <!-- Simple Xml Framework -->
diff --git a/src/main/java/com/fincatto/documentofiscal/nfe400/classes/NFAutorizador400.java b/src/main/java/com/fincatto/documentofiscal/nfe400/classes/NFAutorizador400.java
index 5907098b..2196f7ca 100644
--- a/src/main/java/com/fincatto/documentofiscal/nfe400/classes/NFAutorizador400.java
+++ b/src/main/java/com/fincatto/documentofiscal/nfe400/classes/NFAutorizador400.java
@@ -799,7 +799,95 @@ public enum NFAutorizador400 {
             return new DFUnidadeFederativa[]{DFUnidadeFederativa.MT};
         }
     },
-    PE {
+
+    PA {
+        @Override
+        public String getNfeAutorizacao(final DFAmbiente ambiente) {
+            return SVRS.getNfeAutorizacao(ambiente);
+        }
+
+        @Override
+        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
+            return SVRS.getNfeRetAutorizacao(ambiente);
+        }
+
+        @Override
+        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
+            return SVRS.getNfeConsultaProtocolo(ambiente);
+        }
+
+        @Override
+        public String getNfeStatusServico(final DFAmbiente ambiente) {
+            return SVRS.getNfeStatusServico(ambiente);
+        }
+
+        @Override
+        public String getRecepcaoEvento(final DFAmbiente ambiente) {
+            return SVRS.getRecepcaoEvento(ambiente);
+        }
+
+        @Override
+        public String getConsultaCadastro(final DFAmbiente ambiente) {
+            return SVRS.getConsultaCadastro(ambiente);
+        }
+
+        @Override
+        public String getNfeInutilizacao(final DFAmbiente ambiente) {
+            return SVRS.getNfeInutilizacao(ambiente);
+        }
+
+        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
+
+    @Override
+        public String getNfceAutorizacao(final DFAmbiente ambiente) {
+            return SVRS.getNfceAutorizacao(ambiente);
+        }
+
+        @Override
+        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
+            return SVRS.getNfceRetAutorizacao(ambiente);
+        }
+
+        @Override
+        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
+            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
+        }
+
+        @Override
+        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
+            return SVRS.getNfceConsultaProtocolo(ambiente);
+        }
+
+        @Override
+        public String getNfceStatusServico(final DFAmbiente ambiente) {
+            return SVRS.getNfceStatusServico(ambiente);
+        }
+
+        @Override
+        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
+            return SVRS.getNfceRecepcaoEvento(ambiente);
+        }
+
+        @Override
+        public String getNfceInutilizacao(final DFAmbiente ambiente) {
+            return SVRS.getNfceInutilizacao(ambiente);
+        }
+
+        @Override
+        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
+            return AN.getRecepcaoEventoAN(ambiente);
+        }
+
+        @Override
+        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
+            throw new UnsupportedOperationException("Nao suportado ainda");
+        }
+
+        @Override
+        public DFUnidadeFederativa[] getUFs() {
+            return new DFUnidadeFederativa[]{DFUnidadeFederativa.PA};
+        }
+    },    PE {
         @Override
         public String getNfeAutorizacao(final DFAmbiente ambiente) {
             return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeAutorizacao4" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeAutorizacao4";
diff --git a/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSCancelamento.java b/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSCancelamento.java
index 5ed7ac69..a5805241 100644
--- a/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSCancelamento.java
+++ b/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSCancelamento.java
@@ -11,6 +11,7 @@ import org.apache.axiom.om.util.AXIOMUtil;
 
 import com.fincatto.documentofiscal.DFLog;
 import com.fincatto.documentofiscal.DFModelo;
+import com.fincatto.documentofiscal.assinatura.AssinaturaDigital;
 import com.fincatto.documentofiscal.nfe.NFeConfig;
 import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
 import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
@@ -40,57 +41,113 @@ class WSCancelamento implements DFLog {
         this.config = config;
     }
 
-    NFEnviaEventoRetorno cancelaNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
-        final OMElement omElementResult = this.efetuaCancelamento(eventoAssinadoXml, chaveAcesso);
+//    NFEnviaEventoRetorno cancelaNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
+    NFEnviaEventoRetorno cancelaNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml, final boolean proxy, final String host, final String porta) throws Exception {
+        final OMElement omElementResult = this.efetuaCancelamento(eventoAssinadoXml, chaveAcesso, proxy, host, porta);
+        System.out.println("=====================================================================================");
+        System.out.println("*** PASSO 5 - WSFacade.java (FINCATTO)  > WSCancelamento (FINCATTO) - 2. CANCELAMENTO DA NOTA ASSINADA ***");
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Chave de Acesso:  " + chaveAcesso);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Evento Assinado XML: " + eventoAssinadoXml);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Proxy: " + proxy);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Host: " + host);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Porta: " + porta);
         return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
     }
 
-    NFCancelamentoRetornoDados cancelaNota(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
-        final String cancelamentoNotaXML = this.gerarDadosCancelamento(chaveAcesso, numeroProtocolo, motivo).toString();
-        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cancelamentoNotaXML);
-        final OMElement omElementResult = this.efetuaCancelamento(xmlAssinado, chaveAcesso);
-        NFEnviaEventoRetorno retorno = this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
-
-        NFEnviaEventoCancelamento eventoAssinado = new DFPersister().read(NFEnviaEventoCancelamento.class, xmlAssinado);
-
-		final List<NFEventoRetorno> eventoRetorno = retorno.getEventoRetorno() == null ? Arrays.asList() : retorno.getEventoRetorno();
-
-        NFProtocoloEventoCancelamento protocolo = new NFProtocoloEventoCancelamento();
-        protocolo.setVersao("1.00");
-        protocolo.setEvento(eventoAssinado.getEvento().stream().findFirst().orElse(null));
-		protocolo.setEventoRetorno(eventoRetorno.stream().findFirst().orElse(null));
-
-        return new NFCancelamentoRetornoDados(retorno, protocolo);
+    // ============================================================================================================================================================================
+    NFEnviaEventoRetorno cancelaNota(final String chaveAcesso, final String numeroProtocolo, final String motivo, final boolean proxy, final String host, final String porta) throws Exception {
+        //final String cancelamentoNotaXML = this.gerarDadosCancelamento(chaveAcesso, numeroProtocolo, motivo).toString();
+        final String cancelamentoNotaXML = this.gerarDadosCancelamento(chaveAcesso, numeroProtocolo, motivo, proxy, host, porta).toString();
+        System.out.println("=====================================================================================");
+        System.out.println("*** PASSO 5 - WSFacade.java  > WSCancelamento (FINCATTO) - 2. CANCELAMENTO DA NOTA ***");
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Chave de Acesso:  " + chaveAcesso);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Protocolo: " + numeroProtocolo);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Motivo: " + motivo);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Proxy: " + proxy);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Host: " + host);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - cancelamentoNotaXML = this.gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Porta: " + porta);
+        System.out.println("=====================================================================================");
+        final String xmlAssinado = new AssinaturaDigital(this.config).assinarDocumento(cancelamentoNotaXML);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - xmlAssinado = this.config - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - XML Assinado:  " + xmlAssinado);
+//        final OMElement omElementResult = this.efetuaCancelamento(xmlAssinado, chaveAcesso);
+        final OMElement omElementResult = this.efetuaCancelamento(xmlAssinado, chaveAcesso, proxy, host, porta);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.config - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Efetua Cancelamento:  " + omElementResult);
+        System.out.println("=====================================================================================");
+        System.out.println("*** PASSO 5 - WSFacade.java  > WSCancelamento (FINCATTO) - 2. CANCELAMENTO DA NOTA ***");
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - XML Assinado:  " + xmlAssinado);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Chave de Acesso: " + chaveAcesso);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Proxy: " + proxy);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Host: " + host);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Porta: " + porta);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - Chama a classe NFEnviaEventoRetorno.class, omElementResult.toString(): ");
+        System.out.println("=====================================================================================");
+        return new com.fincatto.documentofiscal.persister.DFPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
     }
     
-    private OMElement efetuaCancelamento(final String xmlAssinado, final String chaveAcesso) throws Exception {
+//    private OMElement efetuaCancelamento(final String xmlAssinado, final String chaveAcesso) throws Exception {
+    private OMElement efetuaCancelamento(final String xmlAssinado, final String chaveAcesso, final boolean proxy, final String host, final String porta) throws Exception {
         final NFeRecepcaoEvento4Stub.NfeDadosMsg dados = new NFeRecepcaoEvento4Stub.NfeDadosMsg();
         final OMElement omElementXML = AXIOMUtil.stringToOM(xmlAssinado);
         this.getLogger().debug(omElementXML.toString());
         dados.setExtraElement(omElementXML);
         
+        System.out.println("=====================================================================================");
+        System.out.println("*** PASSO 5 - WSFacade.java  > WSCancelamento (FINCATTO) - 2. CANCELAMENTO DA NOTA ASSINADA ***");
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - XML Assinado:  " + xmlAssinado);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Dados:  " + dados);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Chave de Acesso: " + chaveAcesso);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Proxy: " + proxy);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Host: " + host);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Porta: " + porta);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - omElementResult = this.efetuaCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - OMElement: " + omElementXML);
+        
         final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - parser = new NotaFiscalChaveParser - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Nota Fiscal Chave Parser: " + parser);
         final NFAutorizador400 autorizador = NFAutorizador400.valueOfChaveAcesso(chaveAcesso);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - autorizador = NFAutorizador400 - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - Autorizador: " + autorizador);        
         final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ? autorizador.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizador.getRecepcaoEvento(this.config.getAmbiente());
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - urlWebService = DFModelo - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno efetuaCancelamento - urlWebService: " + urlWebService);        
         if (urlWebService == null) {
             throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + parser.getModelo().name() + ", autorizador " + autorizador.name());
         }
         
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java NotaFiscalChaveParser parser - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Nota Fiscal Chave Parser:  " + parser);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java NFAutorizador400 autorizador - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Autorizador:  " + autorizador);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java String urlWebService - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - URL WebService:  " + urlWebService);
+        
         final NfeResultMsg nfeRecepcaoEvento = new NFeRecepcaoEvento4Stub(urlWebService, config).nfeRecepcaoEvento(dados);
         final OMElement omElementResult = nfeRecepcaoEvento.getExtraElement();
         this.getLogger().debug(omElementResult.toString());
+
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java NfeResultMsg nfeRecepcaoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Recepção Evento:  " + nfeRecepcaoEvento);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java OMElement omElementResult - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - OmElementResult:  " + omElementResult);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java OMElement - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - WSCancelamento.LOGGER.debug(omElementResult.toString()");
+
+        System.out.println("=====================================================================================");
         return omElementResult;
     }
     
-    private NFEnviaEventoCancelamento gerarDadosCancelamento(final String chaveAcesso, final String numeroProtocolo, final String motivo) {
-        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
+    // ============================================================================================================================================================================
+//    private NFEnviaEventoCancelamento gerarDadosCancelamento(final String chaveAcesso, final String numeroProtocolo, final String motivo) {
+    private NFEnviaEventoCancelamento gerarDadosCancelamento(final String chaveAcesso, final String numeroProtocolo, final String motivo, final boolean proxy, final String host, final String porta) {
+        System.out.println("=====================================================================================");
+        System.out.println("*** PASSO 5 - WSFacade.java  > WSCancelamento (FINCATTO) - 2. CANCELAMENTO DA NOTA ***");
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFEnviaEventoCancelamento gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e ");
         
+        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
+        System.out.println("*** 2.WsFacade.java   > WSCancelamento.java - NFEnviaEventoCancelamento gerarDadosCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Chave Parser:  " + chaveParser);
+
         final NFInfoCancelamento cancelamento = new NFInfoCancelamento();
         cancelamento.setDescricaoEvento(WSCancelamento.DESCRICAO_EVENTO);
         cancelamento.setVersao(WSCancelamento.VERSAO_LEIAUTE);
         cancelamento.setJustificativa(motivo);
         cancelamento.setProtocoloAutorizacao(numeroProtocolo);
         
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento cancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Cancelamento:  " + cancelamento);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setDescricaoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Descrição Evento:  " + WSCancelamento.DESCRICAO_EVENTO);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento SetVersao - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Chave Parser:  " + WSCancelamento.VERSAO_LEIAUTE);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento SetProtocoloAutorizacao - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Protocolo de Autorização:  " + numeroProtocolo);
+
         final NFInfoEventoCancelamento infoEvento = new NFInfoEventoCancelamento();
         infoEvento.setAmbiente(this.config.getAmbiente());
         infoEvento.setChave(chaveAcesso);
@@ -107,21 +164,44 @@ class WSCancelamento implements DFLog {
         infoEvento.setVersaoEvento(WSCancelamento.VERSAO_LEIAUTE);
         infoEvento.setCancelamento(cancelamento);
         
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento infoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Info Evento:  " + infoEvento);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setAmbiente - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Ambiente:  " + this.config.getAmbiente());
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setChave - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Chave de Acesso:  " + chaveAcesso);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setDataHoraEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Data e Hora Evento:  " + ZonedDateTime.now(this.config.getTimeZone().toZoneId()));
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setId - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - ID. Evento:  " + String.format("ID%s%s0%s", WSCancelamento.EVENTO_CANCELAMENTO, chaveAcesso, "1"));
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setNumeroSequencialEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Numero Sequencial Evento:  " + 1);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setOrgao - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Órgão:  " + chaveParser.getNFUnidadeFederativa());
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setCodigoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Código Evento:  " + WSCancelamento.EVENTO_CANCELAMENTO);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setVersaoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Versão Evento:  " + WSCancelamento.VERSAO_LEIAUTE);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setCancelamento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Cancelamento:  " + cancelamento);
+        
         final NFEventoCancelamento evento = new NFEventoCancelamento();
         evento.setInfoEvento(infoEvento);
         evento.setVersao(WSCancelamento.VERSAO_LEIAUTE);
         
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFEventoCancelamento infoEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Info Evento:  " + infoEvento);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFEventoCancelamento setVersao - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Versão:  " + WSCancelamento.VERSAO_LEIAUTE);
+
         final NFEnviaEventoCancelamento enviaEvento = new NFEnviaEventoCancelamento();
         enviaEvento.setEvento(Collections.singletonList(evento));
         enviaEvento.setIdLote(Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
         enviaEvento.setVersao(WSCancelamento.VERSAO_LEIAUTE);
+
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFEnviaEventoCancelamento enviaEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Info Evento:  " + infoEvento);
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Versão:  " + Collections.singletonList(evento));
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setIdLote - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - ID. Lote:  " + Long.toString(ZonedDateTime.now(this.config.getTimeZone().toZoneId()).toInstant().toEpochMilli()));
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - NFInfoCancelamento setVersao - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - ID. Lote:  " + WSCancelamento.VERSAO_LEIAUTE);
+
+        System.out.println("*** 3.WsFacade.java   > WSCancelamento.java - enviaEvento - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - Envia Evento:  " + enviaEvento);
+
         return enviaEvento;
     }
     
-    NFEnviaEventoRetorno cancelaNotaPorSubstituicao(final String chaveAcesso, final String numeroProtocolo, final String motivo, final String versaoAplicativoAutorizador, final String chaveSubstituta) throws Exception {
+//    NFEnviaEventoRetorno cancelaNotaPorSubstituicao(final String chaveAcesso, final String numeroProtocolo, final String motivo, final String versaoAplicativoAutorizador, final String chaveSubstituta) throws Exception {
+    NFEnviaEventoRetorno cancelaNotaPorSubstituicao(final String chaveAcesso, final String numeroProtocolo, final String motivo, final boolean proxy, final String host, final String porta, final String versaoAplicativoAutorizador, final String chaveSubstituta) throws Exception {
         final String cancelamentoNotaXML = this.gerarDadosCancelamentoPorSubstituicao(chaveAcesso, numeroProtocolo, motivo, versaoAplicativoAutorizador, chaveSubstituta).toString();
         final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cancelamentoNotaXML);
-        final OMElement omElementResult = this.efetuaCancelamento(xmlAssinado, chaveAcesso);
+        final OMElement omElementResult = this.efetuaCancelamento(xmlAssinado, chaveAcesso, proxy, host, porta);
         return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
     }
     
diff --git a/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSCartaCorrecao.java b/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSCartaCorrecao.java
index 8dfe558f..dc172a1c 100644
--- a/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSCartaCorrecao.java
+++ b/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSCartaCorrecao.java
@@ -35,9 +35,23 @@ class WSCartaCorrecao implements DFLog {
         this.config = config;
     }
     
-    NFEnviaEventoRetorno corrigeNota(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
-        final String xmlAssinado = getXmlAssinado(chaveAcesso, textoCorrecao, numeroSequencialEvento);
+        NFEnviaEventoRetorno corrigeNota(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento, final boolean proxy, final String host, final String porta) throws Exception {
+        final String xmlAssinado = getXmlAssinado(chaveAcesso, textoCorrecao, numeroSequencialEvento, proxy, host, porta);
+        System.out.println("=====================================================================================");
+        System.out.println("*** PASSO 5 - WSFacade.java  > WSCartaCorrecao (FINCATTO) - 2. CORRECAO DA NOTA ***");
+        System.out.println("*** 2.WsFacade.java   > xmlAssinado = getXmlAssinado = fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno corrigeNota - Chave de Acesso:  " + chaveAcesso);
+        System.out.println("*** 2.WsFacade.java   > xmlAssinado = getXmlAssinado = fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno corrigeNota - Texto Correção: " + textoCorrecao);
+        System.out.println("*** 2.WsFacade.java   > xmlAssinado = getXmlAssinado = fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno corrigeNota - Numero Sequencial de Evento: " + numeroSequencialEvento);
+        System.out.println("*** 2.WsFacade.java   > xmlAssinado = getXmlAssinado = fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno corrigeNota - Proxy: " + proxy);
+        System.out.println("*** 2.WsFacade.java   > xmlAssinado = getXmlAssinado = fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno corrigeNota - Host: " + host);
+        System.out.println("*** 2.WsFacade.java   > xmlAssinado = getXmlAssinado = fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno corrigeNota - Porta: " + porta);
+        System.out.println("=====================================================================================");
         final OMElement omElementResult = this.efetuaCorrecao(xmlAssinado, chaveAcesso);
+        System.out.println("=====================================================================================");
+        System.out.println("*** PASSO 5 - WSFacade.java  > WSCartaCorrecao (FINCATTO) - 2. CORRECAO DA NOTA ***");
+        System.out.println("*** 2.WsFacade.java   > omElementResult = this.efetuaCorrecao = fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno corrigeNota - XML Assinado:  " + xmlAssinado);
+        System.out.println("*** 2.WsFacade.java   > omElementResult = this.efetuaCorrecao = fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno corrigeNota - Chave de Acesso: " + chaveAcesso);
+        System.out.println("=====================================================================================");
         return this.config.getPersister().read(NFEnviaEventoRetorno.class, omElementResult.toString());
     }
     
@@ -87,12 +101,12 @@ class WSCartaCorrecao implements DFLog {
     /**
      * Retorna XML assinado para uso externo.
      */
-    public String getXmlAssinado(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
-        final String cartaCorrecaoXML = this.gerarDadosCartaCorrecao(chaveAcesso, textoCorrecao, numeroSequencialEvento).toString();
+    public String getXmlAssinado(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento, final boolean proxy, final String host, final String porta) throws Exception {
+        final String cartaCorrecaoXML = this.gerarDadosCartaCorrecao(chaveAcesso, textoCorrecao, numeroSequencialEvento, proxy, host, porta).toString();
         return new DFAssinaturaDigital(this.config).assinarDocumento(cartaCorrecaoXML);
     }
     
-    public NFEnviaEventoCartaCorrecao gerarDadosCartaCorrecao(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento) {
+    public NFEnviaEventoCartaCorrecao gerarDadosCartaCorrecao(final String chaveAcesso, final String textoCorrecao, final int numeroSequencialEvento, final boolean proxy, final String host, final String porta) {
         final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
         
         final NFTipoEvento cartaCorrecao = new NFTipoEvento();
diff --git a/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSFacade.java b/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSFacade.java
index 3f92a3be..75663ef7 100755
--- a/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSFacade.java
+++ b/src/main/java/com/fincatto/documentofiscal/nfe400/webservices/WSFacade.java
@@ -172,8 +172,18 @@ public class WSFacade {
      * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
      * o sefaz
      */
-    public NFEnviaEventoRetorno corrigeNota(final String chaveDeAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
-        return this.wsCartaCorrecao.corrigeNota(chaveDeAcesso, textoCorrecao, numeroSequencialEvento);
+    public NFEnviaEventoRetorno corrigeNota(final String chaveDeAcesso, final String textoCorrecao, final int numeroSequencialEvento,
+            final boolean proxy, final String host, final String porta) throws Exception {
+        System.out.println("=====================================================================================");
+        System.out.println("*** PASSO 5 - WSFacade.java (FINCATTO) - 1. CORRECAO DA NOTA ***");
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Chave de Acesso:  " + chaveDeAcesso);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Protocolo: " + textoCorrecao);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Motivo: " + numeroSequencialEvento);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Proxy: " + proxy);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Host: " + host);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Porta: " + porta);
+        System.out.println("=====================================================================================");
+        return this.wsCartaCorrecao.corrigeNota(chaveDeAcesso, textoCorrecao, numeroSequencialEvento, proxy, host, porta);
     }
 
     /**
@@ -206,14 +216,15 @@ public class WSFacade {
         return this.wsCartaCorrecao.corrigeNotaAssinadaProtocolo(eventoAssinadoXml);
     }
 
-    public NFProtocoloEventoCartaCorrecao corrigeNotaAssinadaProtocolo(final String chaveDeAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
-        return this.wsCartaCorrecao.corrigeNotaAssinadaProtocolo(getXmlAssinado(chaveDeAcesso, textoCorrecao, numeroSequencialEvento));
+    public NFProtocoloEventoCartaCorrecao corrigeNotaAssinadaProtocolo(final String chaveDeAcesso, final String textoCorrecao, final int numeroSequencialEvento, final boolean proxy, final String host, final String porta) throws Exception {
+        return this.wsCartaCorrecao.corrigeNotaAssinadaProtocolo(getXmlAssinado(chaveDeAcesso, textoCorrecao, numeroSequencialEvento, proxy, host, porta));
     }
 
-    public String getXmlAssinado(final String chaveDeAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
-        return this.wsCartaCorrecao.getXmlAssinado(chaveDeAcesso, textoCorrecao, numeroSequencialEvento);
+    public String getXmlAssinado(final String chaveDeAcesso, final String textoCorrecao, final int numeroSequencialEvento, final boolean proxy, final String host, final String porta) throws Exception {
+        return this.wsCartaCorrecao.getXmlAssinado(chaveDeAcesso, textoCorrecao, numeroSequencialEvento, proxy, host, porta);
     }
 
+
     /**
      * Faz o cancelamento da nota.
      *
@@ -224,8 +235,18 @@ public class WSFacade {
      * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
      * o sefaz
      */
-    public NFCancelamentoRetornoDados cancelaNota(final String chave, final String numeroProtocolo, final String motivo) throws Exception {
-        return this.wsCancelamento.cancelaNota(chave, numeroProtocolo, motivo);
+//    public NFEnviaEventoRetorno cancelaNota(final String chave, final String numeroProtocolo, final String motivo) throws Exception {
+    public NFEnviaEventoRetorno cancelaNota(final String chave, final String numeroProtocolo, final String motivo, final boolean proxy, final String host, final String porta) throws Exception {
+        System.out.println("=====================================================================================");
+        System.out.println("*** PASSO 5 - WSFacade.java (FINCATTO) - 1. CANCELAMENTO DA NOTA ***");
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Chave de Acesso:  " + chave);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Protocolo: " + numeroProtocolo);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Motivo: " + motivo);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Proxy: " + proxy);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Host: " + host);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNota - Porta: " + porta);
+        System.out.println("=====================================================================================");
+        return this.wsCancelamento.cancelaNota(chave, numeroProtocolo, motivo, proxy, host, porta);
     }
 
     /**
@@ -238,8 +259,16 @@ public class WSFacade {
      * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
      * o sefaz
      */
-    public NFEnviaEventoRetorno cancelaNotaAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
-        return this.wsCancelamento.cancelaNotaAssinada(chave, eventoAssinadoXml);
+//    public NFEnviaEventoRetorno cancelaNotaAssinada(final String chave, final String eventoAssinadoXml) throws Exception {
+    public NFEnviaEventoRetorno cancelaNotaAssinada(final String chave, final String eventoAssinadoXml, final boolean proxy, final String host, final String porta) throws Exception {
+        System.out.println("=====================================================================================");
+        System.out.println("*** PASSO 5 - WSFacade.java (FINCATTO) - 2. CANCELAMENTO DA NOTA ***");
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Chave de Acesso:  " + chave);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Protocolo: " + eventoAssinadoXml);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Proxy: " + proxy);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Host: " + host);
+        System.out.println("*** 1.WsFacade.java - fincatto/documentofiscal/nfe400/webservices/WSFacade.java - NF-e - NFEnviaEventoRetorno cancelaNotaAssinada - Porta: " + porta);
+        return this.wsCancelamento.cancelaNotaAssinada(chave, eventoAssinadoXml, proxy, host, porta);
     }
     
     /**
@@ -253,8 +282,9 @@ public class WSFacade {
      * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
      * o sefaz
      */
-    public NFEnviaEventoRetorno cancelaNotaPorSubstituicao(final String chave, final String numeroProtocolo, final String motivo, final String versaoAplicativoAutorizador, final String chaveSubstituta) throws Exception {
-        return this.wsCancelamento.cancelaNotaPorSubstituicao(chave, numeroProtocolo, motivo, versaoAplicativoAutorizador, chaveSubstituta);
+//    public NFEnviaEventoRetorno cancelaNotaPorSubstituicao(final String chave, final String numeroProtocolo, final String motivo, final String versaoAplicativoAutorizador, final String chaveSubstituta) throws Exception {
+    public NFEnviaEventoRetorno cancelaNotaPorSubstituicao(final String chaveAcesso, final String numeroProtocolo, final String motivo, final boolean proxy, final String host, final String porta, final String versaoAplicativoAutorizador, final String chaveSubstituta) throws Exception {
+        return this.wsCancelamento.cancelaNotaPorSubstituicao(chaveAcesso, numeroProtocolo, motivo, proxy, host, porta, versaoAplicativoAutorizador, chaveSubstituta);
     }
 
     /**
EOF

echo "Patch aplicado com sucesso."

# --- 2. Tornar o script executável ---
echo "[2/2] Tornando o script executável..."
chmod +x aplicar_patches_git_nfe.sh

echo "================================================="
echo "Script 'aplicar_patches_git_nfe.sh' atualizado com sucesso!"
echo "================================================="
echo ""
echo "Para usar, siga estes passos:"
echo "1. Se necessário, reverta as alterações locais: git reset --hard"
echo "2. Atualize seu código: git fetch upstream && git checkout main && git reset --hard upstream/main"
echo "3. Execute este script:   ./aplicar_patches_git_nfe.sh"
echo "4. Compile o projeto:     mvn clean install"

# Limpa o arquivo de patch, se existir
rm -f all_changes.patch