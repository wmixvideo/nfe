Nota Fiscal Eletrônica
===
Biblioteca Java para gerar, assinar, validar e transmitir documentos fiscais eletrônicos para os webservices da SEFAZ: **NF-e**, **NFC-e**, **CT-e** e **MDF-e**.

[![Java CI](https://github.com/wmixvideo/nfe/actions/workflows/maven.yml/badge.svg)](https://github.com/wmixvideo/nfe/actions/workflows/maven.yml)
[![Coverage Status](https://coveralls.io/repos/github/wmixvideo/nfe/badge.svg?branch=master)](https://coveralls.io/github/wmixvideo/nfe?branch=master)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.wmixvideo/nfe)](https://central.sonatype.com/artifact/com.github.wmixvideo/nfe)
[![Apache 2.0 License](https://img.shields.io/badge/license-apache%202.0-green.svg)](https://github.com/wmixvideo/nfe/blob/master/LICENSE)

Este é um projeto colaborativo: sinta-se à vontade para usar e contribuir. Temos um [grupo de WhatsApp](https://chat.whatsapp.com/LFmqpkoiIYc6Zy3d4TnZGU) para discussões sobre o desenvolvimento da biblioteca.

## Antes de usar
A biblioteca cuida da parte técnica (montar o XML, assinar, validar contra os schemas e conversar com a SEFAZ), mas **não decide o conteúdo fiscal** do documento: CFOP, CST, alíquotas e afins dependem da operação e da legislação. Na dúvida, consulte um contador.

A documentação oficial é a melhor fonte de informação:
- NF-e e NFC-e: [Portal Nacional da NF-e](https://www.nfe.fazenda.gov.br/portal/principal.aspx)
- CT-e: [Portal Nacional do CT-e](https://www.cte.fazenda.gov.br/portal/)
- MDF-e: [Portal do MDF-e](https://dfe-portal.svrs.rs.gov.br/Mdfe)

Veja também as [dúvidas comuns de quem está começando](docs/mais_info.md).

## Requisitos
- Java 11 ou superior
- Certificado digital A1 (arquivo `.pfx`/`.p12`) ou A3 do emitente, inclusive para o ambiente de homologação

## Instalação
Adicione a dependência ao seu `pom.xml`, trocando `VERSAO` pela [última versão publicada](https://central.sonatype.com/artifact/com.github.wmixvideo/nfe):

```xml
<dependency>
    <groupId>com.github.wmixvideo</groupId>
    <artifactId>nfe</artifactId>
    <version>VERSAO</version>
</dependency>
```

As mudanças de cada versão estão nas [releases do GitHub](https://github.com/wmixvideo/nfe/releases).

Para usar a versão em desenvolvimento, compile a partir do código-fonte:

```bash
git clone https://github.com/wmixvideo/nfe.git
cd nfe
mvn clean install
```

## Como funciona
O uso segue sempre o mesmo caminho:

1. **Configuração:** você estende `NFeConfig` (ou `CTeConfig`, `MDFeConfig`) informando UF, ambiente, certificado e cadeia de certificados.
2. **Documento:** você monta o documento com as classes Java da biblioteca, que espelham o XML oficial (`NFNota`, `CTeNota`, `MDFe`...).
3. **Envio:** o `WSFacade` assina, valida contra o XSD e transmite para a SEFAZ, devolvendo a resposta já convertida em objetos Java.

Cada documento tem o seu `WSFacade`, no pacote da versão vigente:

| Documento | Configuração | Facade |
|---|---|---|
| NF-e / NFC-e | `com.fincatto.documentofiscal.nfe.NFeConfig` | `com.fincatto.documentofiscal.nfe400.webservices.WSFacade` |
| CT-e | `com.fincatto.documentofiscal.cte.CTeConfig` | `com.fincatto.documentofiscal.cte400.webservices.WSFacade` |
| MDF-e | `com.fincatto.documentofiscal.mdfe3.MDFeConfig` | `com.fincatto.documentofiscal.mdfe3.webservices.WSFacade` |

## Configuração
Crie uma classe que estenda `NFeConfig`. Os métodos obrigatórios são os da UF, do certificado e da cadeia de certificados; os demais têm valores padrão que você pode sobrescrever.

> **Atenção:** o ambiente padrão é **homologação**. Para emitir notas com valor fiscal, sobrescreva `getAmbiente()` e retorne `DFAmbiente.PRODUCAO`.

```java
public class MinhaConfig extends NFeConfig {

    private KeyStore keyStoreCertificado;
    private KeyStore keyStoreCadeia;

    @Override
    public DFUnidadeFederativa getCUF() {
        return DFUnidadeFederativa.SC;
    }

    @Override
    public DFAmbiente getAmbiente() {
        return DFAmbiente.HOMOLOGACAO;
    }

    @Override
    public String getCertificadoSenha() {
        return "senha_do_certificado";
    }

    @Override
    public String getCadeiaCertificadosSenha() {
        return "senha_da_cadeia";
    }

    @Override
    public KeyStore getCertificadoKeyStore() throws KeyStoreException {
        if (this.keyStoreCertificado == null) {
            this.keyStoreCertificado = this.carrega("PKCS12", "/caminho/certificado.pfx", this.getCertificadoSenha());
        }
        return this.keyStoreCertificado;
    }

    @Override
    public KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
        if (this.keyStoreCadeia == null) {
            this.keyStoreCadeia = this.carrega("JKS", "/caminho/cadeia.jks", this.getCadeiaCertificadosSenha());
        }
        return this.keyStoreCadeia;
    }

    private KeyStore carrega(final String tipo, final String arquivo, final String senha) throws KeyStoreException {
        final KeyStore keyStore = KeyStore.getInstance(tipo);
        try (InputStream stream = new FileInputStream(arquivo)) {
            keyStore.load(stream, senha.toCharArray());
            return keyStore;
        } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
            throw new KeyStoreException("Não foi possível carregar o KeyStore " + arquivo, e);
        }
    }
}
```

Outros métodos que você pode sobrescrever:

| Método | Para que serve | Padrão |
|---|---|---|
| `getAmbiente()` | Homologação ou produção | `HOMOLOGACAO` |
| `getTipoEmissao()` | Emissão normal ou contingência | `EMISSAO_NORMAL` |
| `getCertificadoAlias()` | Alias do certificado dentro do KeyStore | primeiro alias encontrado |
| `getCodigoSegurancaContribuinte()` e `getCodigoSegurancaContribuinteID()` | CSC e seu ID, obrigatórios para NFC-e | `null` |
| `getTimeZone()` | Fuso horário usado nas datas | fuso horário da JVM |
| `getTimeoutRequisicaoEmMillis()` e `getSoTimeoutEmMillis()` | Tempo limite das chamadas à SEFAZ | ver `DFConfig` |

### Cadeia de certificados da SEFAZ
Além do certificado do emitente, a comunicação usa a cadeia de certificados dos servidores da SEFAZ. A biblioteca baixa essa cadeia e gera o arquivo JKS para você:

```java
byte[] producao = DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.PRODUCAO, "senha_da_cadeia");
Files.write(Paths.get("/caminho/cadeia-producao.jks"), producao);

byte[] homologacao = DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.HOMOLOGACAO, "senha_da_cadeia");
Files.write(Paths.get("/caminho/cadeia-homologacao.jks"), homologacao);
```

As SEFAZ trocam seus certificados de tempos em tempos. Se aparecerem erros de SSL/handshake, gere a cadeia novamente. Lembre-se também de que o certificado A1 do emitente costuma valer apenas um ano.

### Certificado instalado no Windows (A1 ou A3)
Para usar um certificado do repositório do Windows, carregue o KeyStore `Windows-MY` e informe qual certificado usar pelo alias:

```java
@Override
public KeyStore getCertificadoKeyStore() throws KeyStoreException {
    try {
        final KeyStore keyStore = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
        keyStore.load(null, null);
        return keyStore;
    } catch (Exception e) {
        throw new KeyStoreException("Não foi possível acessar os certificados do Windows", e);
    }
}

@Override
public String getCertificadoAlias() {
    return "alias do certificado escolhido";
}
```

Para listar os certificados instalados e deixar o usuário escolher, use `keyStore.aliases()`.

## NF-e e NFC-e
Nos exemplos abaixo, `config` é uma instância da sua implementação de `NFeConfig`.

O `WSFacade` mantém um pool de conexões HTTP com a SEFAZ. Crie uma instância, reaproveite-a enquanto precisar e feche-a no fim (ele implementa `Closeable`, então funciona com *try-with-resources*):

```java
try (WSFacade facade = new WSFacade(config)) {
    // chamadas à SEFAZ
}
```

### Consultar o status do serviço
```java
NFStatusServicoConsultaRetorno retorno = facade.consultaStatus(DFUnidadeFederativa.SC, DFModelo.NFE);
System.out.println(retorno.getStatus() + " - " + retorno.getMotivo());
```

Se o serviço estiver no ar, o resultado será:
```
107 - Servico em operacao
```

### Enviar uma nota
Monte a nota (`NFNota`) e coloque-a em um lote. O `enviaLote` assina, valida contra o XSD e envia; para NFC-e, também gera o QR Code.

```java
NFNota nota = new NFNota();
// preencha os dados da nota: emitente, destinatário, itens, impostos, pagamento...

NFLoteEnvio lote = new NFLoteEnvio();
lote.setIdLote("1");
lote.setVersao("4.00");
lote.setIndicadorProcessamento(NFLoteIndicadorProcessamento.PROCESSAMENTO_SINCRONO);
lote.setNotas(Collections.singletonList(nota));

NFLoteEnvioRetornoDados resultado = facade.enviaLote(lote);
NFLoteEnvioRetorno retorno = resultado.getRetorno();
```

O retorno depende do modo de processamento:

- **Síncrono** (uma nota por lote): a SEFAZ responde na hora com o protocolo da nota.
  ```java
  NFProtocoloInfo protocolo = retorno.getProtocoloInfo();
  System.out.println(protocolo.getStatus() + " - " + protocolo.getMotivo()); // 100 = autorizada
  ```
- **Assíncrono** (`PROCESSAMENTO_ASSINCRONO`, até 50 notas): a SEFAZ devolve um recibo, e o resultado é consultado depois.
  ```java
  String recibo = retorno.getInfoRecebimento().getRecibo();

  NFLoteConsultaRetorno consulta = facade.consultaLote(recibo, DFModelo.NFE);
  for (NFProtocolo protocolo : consulta.getProtocolos()) {
      System.out.println(protocolo.getProtocoloInfo().getChave() + ": " + protocolo.getProtocoloInfo().getMotivo());
  }
  ```

### Guardar a nota autorizada
Por lei, o XML da nota autorizada deve ser guardado, e é ele que gera o DANFE. Esse XML (`nfeProc`) junta a nota **assinada** e o protocolo de autorização, nessa forma:

```java
NFNota notaAssinada = resultado.getLoteAssinado().getNotas().get(0);

NFProtocolo protocolo = new NFProtocolo();
protocolo.setVersao("4.00");
protocolo.setProtocoloInfo(retorno.getProtocoloInfo());

NFNotaProcessada notaProcessada = new NFNotaProcessada();
notaProcessada.setVersao(new BigDecimal("4.00"));
notaProcessada.setNota(notaAssinada);
notaProcessada.setProtocolo(protocolo);

String xmlParaGuardar = notaProcessada.toString();
```

Use a nota que veio em `getLoteAssinado()`: o XML assinado não pode ser alterado depois da assinatura, senão a SEFAZ rejeita com "Assinatura difere do calculado". No modo assíncrono, o protocolo vem de `consultaLote` (`NFProtocolo` já pronto).

### Consultar uma nota pela chave de acesso
```java
NFNotaConsultaRetorno retorno = facade.consultaNota(chaveDeAcesso);
System.out.println(retorno.getStatus() + " - " + retorno.getMotivo());
```

### Cancelar
```java
NFCancelamentoRetornoDados retorno = facade.cancelaNota(chaveDeAcesso, numeroProtocolo, "Motivo do cancelamento com pelo menos 15 caracteres");
NFInfoEventoRetorno info = retorno.getRetorno().getEventoRetorno().get(0).getInfoEventoRetorno();
System.out.println(info.getCodigoStatus() + " - " + info.getMotivo()); // 135 = evento registrado
```

### Carta de correção
O número sequencial começa em 1 e aumenta a cada nova correção da mesma nota.

```java
NFEnviaEventoRetorno retorno = facade.corrigeNota(chaveDeAcesso, "Texto da correção com pelo menos 15 caracteres", 1);
```

### Inutilizar numeração
```java
NFRetornoEventoInutilizacao retorno = facade.inutilizaNota(2026, cnpjEmitente, "1", "100", "110", "Justificativa com pelo menos 15 caracteres", DFModelo.NFE);
System.out.println(retorno.getDados().getStatus() + " - " + retorno.getDados().getMotivo());
```

### Manifestação do destinatário
```java
NFEnviaEventoRetorno retorno = facade.manifestaDestinatarioNota(chaveDeAcesso, NFTipoEventoManifestacaoDestinatario.CIENCIA_DA_EMISSAO, null, cnpjDestinatario);
```

### Baixar notas emitidas contra o seu CNPJ (distribuição DF-e)
Informe uma chave de acesso, um NSU específico ou o último NSU já recebido (os outros parâmetros ficam `null`):

```java
NFDistribuicaoIntRetorno retorno = facade.consultarDistribuicaoDFe(cnpj, DFUnidadeFederativa.SC, null, null, ultimoNsu);
```

### Outros serviços
O `WSFacade` também tem consulta de cadastro (`consultaCadastro`), EPEC (`enviaEpec`) e os eventos da Reforma Tributária (`enviaInformacaoEfetivoPagamentoIntegral`, `enviaSolicitacaoApropriacaoCreditoPresumido`, entre outros).

Os métodos terminados em `Assinado`/`Assinada` recebem um XML que você já assinou, como no caso de certificados A3 assinados fora da biblioteca.

## CT-e
O uso é o mesmo da NF-e, com `CTeConfig` e o facade do pacote `cte400`:

```java
try (WSFacade facade = new WSFacade(configCTe)) {
    CTeConsStatServRet status = facade.consultaStatus(DFUnidadeFederativa.SC);

    CTeEnvioRetornoDados envio = facade.enviaCTe(cte);

    CTDistribuicaoIntRetorno distribuicao = facade.consultarDistribuicaoCTe(cnpj, DFUnidadeFederativa.SC, null, ultimoNsu);
}
```

Também estão disponíveis CT-e OS e CT-e Simplificado (`enviaCTe` com `CTeOS` ou `CTeNotaSimp`), cancelamento, carta de correção, comprovante e insucesso de entrega, prestação em desacordo, EPEC e GTV.

## MDF-e
Com `MDFeConfig` e o facade do pacote `mdfe3`:

```java
try (WSFacade facade = new WSFacade(configMDFe)) {
    MDFEnvioRetornoDados envio = facade.envioRecepcaoSinc(mdfe);

    MDFeRetorno encerramento = facade.encerramento(chaveDeAcesso, numeroProtocolo, codigoMunicipio, dataEncerramento, DFUnidadeFederativa.SC);

    MDFeConsultaNaoEncerradosRetorno naoEncerrados = facade.consultaNaoEncerrados(cnpj);
}
```

Também estão disponíveis cancelamento, inclusão de condutor, inclusão de DF-e, pagamento do transporte e distribuição.

## Trabalhando com o XML
Qualquer objeto da biblioteca que representa um XML gera o seu conteúdo pelo `toString()`:

```java
String xml = nota.toString();
```

Para o caminho inverso, transformar um XML em objeto Java, use o `DFPersister`:

```java
NFNota nota = new DFPersister().read(NFNota.class, xmlNota);
NFNotaProcessada notaProcessada = new DFPersister().read(NFNotaProcessada.class, xmlNotaProcessada);
```

Por padrão a leitura é estrita e falha se o XML tiver tags que a biblioteca não conhece. Para ignorá-las:

```java
NFNota nota = new DFPersister(false).read(NFNota.class, xmlNota);
```

Para validar um XML contra os schemas oficiais sem enviá-lo, use `DFXMLValidador.validaNota400(xml)`. Para assinar um XML manualmente, use `new DFAssinaturaDigital(config).assinarDocumento(xml)`.

## Funcionalidades
- Validação de tamanho e formato dos campos já no momento em que são preenchidos.
- Validação do XML contra os schemas (XSD) oficiais antes do envio.
- Assinatura digital automática com certificado A1, e métodos que aceitam XML já assinado para A3.
- Geração automática do QR Code da NFC-e.
- Geração da cadeia de certificados da SEFAZ.
- Conversão entre objetos Java e XML nos dois sentidos.
- Suporte a fuso horário configurável (`getTimeZone()`).

## Serviços disponíveis

| Serviço | NF-e / NFC-e | CT-e | MDF-e |
|---|:---:|:---:|:---:|
| Envio | ✔ | ✔ | ✔ |
| Consulta de recibo (lote) | ✔ |  | ✔ |
| Consulta de status do serviço | ✔ | ✔ | ✔ |
| Consulta por chave de acesso | ✔ | ✔ | ✔ |
| Cancelamento | ✔ | ✔ | ✔ |
| Carta de correção | ✔ | ✔ |  |
| Inutilização | ✔ |  |  |
| Consulta de cadastro | ✔ |  |  |
| Manifestação do destinatário | ✔ |  |  |
| Distribuição DF-e | ✔ | ✔ | ✔ |
| EPEC | ✔ | ✔ |  |
| Encerramento e inclusão de condutor |  |  | ✔ |

## Contribuindo
Contribuições são bem-vindas. Antes de abrir um pull request:

- Siga a estrutura e o estilo do código existente. Código novo vai no pacote da versão vigente (`nfe400`, `cte400`, `mdfe3`).
- Ao implementar uma Nota Técnica, use o XSD oficial como referência e informe no PR a NT e a versão.
- Inclua testes unitários que mostrem que a funcionalidade funciona como esperado.
- Garanta que o build passa com `mvn clean package`.
- Escreva commits e PRs em português.

Mais detalhes sobre as convenções do projeto estão no [AGENTS.md](AGENTS.md).

## Licença
Distribuído sob a [licença Apache 2.0](LICENSE).
