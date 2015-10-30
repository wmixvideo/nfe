Nota Fiscal Eletrônica
===
Comunicador de nota fiscal da [fazenda](http://www.nfe.fazenda.gov.br/portal/principal.aspx).<br/>
[![Build Status](https://api.travis-ci.org/wmixvideo/nfe.png)](http://travis-ci.org/#!/wmixvideo/nfe)
[![Coverage Status](https://coveralls.io/repos/wmixvideo/nfe/badge.svg?branch=master&service=github)](https://coveralls.io/github/wmixvideo/nfe?branch=master)

## Atenção
O pacote de classes nfe200 refere-se à versão 2.00 da NFe.<br/>
Ele deve ser utilizado apenas para tradução de notas antigas pois foi desativado em 31/03/2015. Portanto,
faça a integração do seu sistema com as classes contidas no pacote nfe310.<br/>
<br/>
Este é um projeto colaborativo, sinta-se à vontade em usar e colaborar com o mesmo.<br/>
Antes de submeter um patch, verifique a estrutura seguida pelo projeto e procure incluir no mesmo testes unitários que
garantam que a funcionalidade funciona como o esperado.

## Antes de usar
Antes de começar a implementar, é altamente recomendável a leitura da documentação oficial que o governo disponibiliza em http://www.nfe.fazenda.gov.br/portal

Caso não possua conhecimento técnico para criar notas fiscais, um profissional da área (como um contador) pode lhe auxiliar.

## Instalação

```xml
<dependency>
  <groupId>com.github.wmixvideo</groupId>
  <artifactId>nfe</artifactId>
  <version>1.0.23</version>
</dependency>
```

## Como usar
Basicamente você precisará de uma implementação de **NFeConfig** (exemplificado abaixo), com informações de tipo de emissão, certificados
digitais, e uma instância da **WsFacade**, essa classe tem a responsabilidade de fazer a ponte entre o seu sistema e a
comunicação com os webservices da Sefaz.

```java
// Exemplo de configuracao para acesso aos serviços da Sefaz.
public class ConfiguracaoSefaz implements NFeConfig {

    private final boolean ehAmbienteDeTeste;

    public ConfiguracaoSefaz(final boolean ehAmbienteDeTeste) {
        this.ehAmbienteDeTeste = ehAmbienteDeTeste;
    }

    @Override
    public NFAmbiente getAmbiente() {
        return this.ehAmbienteDeTeste ? NFAmbiente.HOMOLOGACAO : NFAmbiente.PRODUCAO;
    }

    @Override
    public File getCertificado() throws IOException {
        return new File("certificado.pfx");
    }

    @Override
    public File getCadeiaCertificados() throws IOException {
        return new File("cadeia_certificado.jks");
    }

    @Override
    public String getCertificadoSenha() {
        return "senhaDoCertificado";
    }

    @Override
    public NFUnidadeFederativa getCUF() {
        return NFUnidadeFederativa.SC;
    }

    @Override
    public NFTipoEmissao getTipoEmissao() {
        return NFTipoEmissao.EMISSAO_NORMAL;
    }
}
```

### Alguns exemplos
Considere para os exemplos abaixo que **config** seja uma instância da implementação da interface **NFeConfig**.

#### Status dos webservices
```java
NFStatusServicoConsultaRetorno retorno = new WSFacade(config).consultaStatus(NFUnidadeFederativa.SC);
System.out.println(retorno.getStatus());
System.out.println(retorno.getMotivo());
```

O Resultado será (caso o webservice responsável por SC esteja OK):
```
107
Servico em operacao
```

#### Envio do lote para o sefaz
Popule os dados do lote a ser enviado para o Sefaz:

```java
NFLoteEnvio lote = new NFLoteEnvio();
// setando os dados do lote
```

Faça o envio do lote através do facade:
```java
final NFLoteEnvioRetorno retorno = new WSFacade(config).enviaLote(lote);
```

#### Corrige nota
Faça a correção da nota através do facade:
```java
final NFEnviaEventoRetorno retorno = new WSFacade(config).corrigeNota(chaveDeAcessoDaNota, textoCorrecao, sequencialEventoDaNota);
```

#### Cancela nota
Faça o cancelamento da nota através do facade:
```java
final NFEnviaEventoRetorno retorno = new WSFacade(config).cancelaNota(chaveDeAcessoDaNota, protocoloDaNota, motivoCancelaamento);
```

### Convertendo objetos Java em XML
Qualquer objeto que seja uma representação XML do documento NFe, pode ser obtido seu XML de forma fácil bastando chamar o método **toString**, por exemplo, para conseguir o XML do lote, invoque o toString

```java
NFLoteEnvio lote = new NFLoteEnvio();
// setando os dados do lote
...

// Obtendo o xml do objeto
String xmlGerado = lote.toString();
```

### Convertendo nota XML em Java
Existe uma classe que pode receber um File/String e converter para um objeto NFNota, faça da seguinte forma:
```java
final NFNota nota = new NotaParser().notaParaObjeto(xmlNota);
```
Ou para uma nota já processada:
```java
final NFNotaProcessada notaProcessada = new NotaParser().notaProcessadaParaObjeto(xmlNota);
```


### Armazenando notas autorizadas
Você precisará armazenar as notas autorizadas por questões legais e também para a geração do DANFE, uma forma de fazer é armazenar o xml das notas ao enviar o lote:
```java
final List<NFNota> notas = lote.getNotas();
// Armazena os xmls das notas
...
```
Ao fazer a consulta do lote, crie um objeto do tipo **NFNotaProcessada** e adicione o protocolo da nota correspondente, além da nota assinada:
```java
// Carregue o xml da nota do local que foi armazenado
final String xmlNotaRecuperada;
// Assine a nota
final String xmlNotaRecuperadaAssinada = new AssinaturaDigital(config).assinarDocumento(xmlNotaRecuperada);
// Converta para objeto java
final NFNota notaRecuperadaAssinada = new NotaParser().notaParaObjeto(xmlNotaRecuperadaAssinada);
// Crie o objeto NFNotaProcessada
final NFNotaProcessada notaProcessada = new NFNotaProcessada();
notaProcessada.setVersao(new BigDecimal(NFeConfig.VERSAO_NFE));
notaProcessada.setProtocolo(protocolo);
notaProcessada.setNota(notaRecuperadaAssinada);
// Obtenha o xml da nota com protocolo
String xmlNotaProcessadaPeloSefaz = notaProcessada.toString();
```

### Funcionalidades
* Possui validação de campos a nível de código;
* Valida o XML de envio de lote através dos xsd's disponibilizados pela Sefaz;
* Gera o XML dos objetos de maneira simples, invocando o metodo toString() dá conta do recado.

## Serviços disponíveis
| Serviço           | Status              |
| ----------------- | :-----------------: |
| Envio lote        | Estável             |
| Consulta lote     | Estável             |
| Consulta status   | Estável             |
| Consulta nota     | Estável             |
| Corrige nota      | Estável             |
| Cancela nota      | Estável             |
| Inutiliza nota    | Estável             |
| Consulta cadastro | Estável             |

## Criação do Java KeyStore (JKS)
Para usar os serviços da nota fiscal são necessários dois certificados, o certificado do cliente que será utilizado para assinar as notas e comunicar com o fisco e o certificado da SEFAZ que desejamos acesso.

Os certificados são um ponto critico já que estes tem validade de apenas um ano (certificado cliente). Além disso as SEFAZ vem trocando suas cadeias de certificado a cada atualização. Dessa forma se surgirem erros de SSL vale a pena verificar se existem novas atualizações de certificados.

Para criação do JKS sera utilizada a ferramenta keytool do java ($JRE_HOME/bin/keytool).

Obter os certificados da certificadora raiz disponibilizados por cada SEFAZ.
* https://homologacao.nfe.sefaz.rs.gov.br/
* https://nfe.sefaz.rs.gov.br/
* https://serasa.certificadodigital.com.br/ajuda/instalacao/cadeia-de-certificados/

Converter o arquivo .cer para jks utilizando keytool:
```sh
keytool -importcert -trustcacerts -alias icp_br -file CertificadoACRaiz.cer -keystore keystore.jks
```

Caso o certificado esteja em formato *p7b*, você pode convertê-lo para *cer* utilizando o openssl para isso:
```sh
openssl pkcs7 -inform DER -outform PEM -in certificadoBaixadoDoSefaz.p7b -print_certs > certificadoGerado.cer
```

## Licença
Apache 2.0

## Dúvidas?
O projeto da NFe brasileira é relativamente complexo e propenso a dúvidas. <br/>
Para ajudar a saná-las, foi disponibilizado um fórum para ajudar na implementação e tirar dúvidas:
* [Fórum NFe](http://www.edsonmoretti.com.br/nfe/)

##Agradecimentos
- [Edson Moretti](https://github.com/edsonmoretti): Criação e manutenção do forum
