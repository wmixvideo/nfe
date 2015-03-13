Nota Fiscal Eletrônica 3.10
===
[![Build Status](https://api.travis-ci.org/fincatto/nfe.png)](http://travis-ci.org/#!/fincatto/nfe)

Comunicador de nota fiscal (versão 3.1) da [fazenda](http://www.nfe.fazenda.gov.br/portal/principal.aspx)

## Atenção
O pacote de classes nfe200 trata em relação a versão 2.00 da NFe, ele deve ser utilizado apenas para tradução de notas antigas,
A previsão do governo em remover a NFe 2.00 é 31/03/2015, Faça a integração com o teu sistema com as classes contidas no pacote nfe310
(NFe 3.10)
Projeto colaborativo, sinta-se a vontade em usar e/ou colaborar com o projeto.

## Serviços disponíveis
| Serviço           | Status              |
| ----------------- | :-----------------: |
| envio lote        | Estável             |
| consulta lote     | Estável             |
| consulta status   | Estável             |
| consulta nota     | Estável             |
| corrige nota      | Estável             |
| cancela nota      | Estável             |
| inutiliza nota    | Estável             |
| consulta cadastro | Precisa de + testes |

## Como usar

Basicamente você precisará de uma implementação de **NFeConfig**, com informações de tipo de emissão, certificados digitais, etc...
e uma instância da **WsFacade**, essa classe tem a responsabilidade de fazer a ponte entre o seu sistema e a comunicação com os webservices da Sefaz.

### Alguns exemplos

Considere para os exemplos abaixo que **config** seja uma instância da implementação da interface **NFeConfig**

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

Popule os dados do lote a ser enviado para o Sefaz

```java
NFLoteEnvio lote = new NFLoteEnvio();
// setando os dados do lote
```

Faça o envio do lote atraves do facade
```java
final NFLoteEnvioRetorno retorno = new WSFacade(config).enviaLote(lote);
```

#### Corrige nota

Faça a correcao da nota atraves do facade
```java
final NFEnviaEventoRetorno retorno = new WSFacade(config).corrigeNota(chaveDeAcessoDaNota, textoCorrecao);
```

#### Cancela nota

Faça o cancelamento da nota atraves do facade
```java
final NFEnviaEventoRetorno retorno = new WSFacade(config).cancelaNota(chaveDeAcessoDaNota, protocoloDaNota, motivoCancelaamento);
```

### Funcionalidades

* Possui validação de campos a nível de código
* Valida o XML de envio de lote através dos xsd's disponiblizados pela Sefaz
* Gera o XML dos objetos de maneira simples, invocando o metodo toString() dá conta do recado.


### TO-DO LIST

 * Envio de nota de forma síncrona (nota a nota, permitido a partir da NF-e 3.10)
 * Envio de notas em contingência

## Licença
Apache 2.0