Nota Fiscal Eletrônica
===
Comunicador de nota fiscal da [fazenda](http://www.nfe.fazenda.gov.br/portal/principal.aspx).<br/>
[![Build Status](https://api.travis-ci.org/fincatto/nfe.png)](http://travis-ci.org/#!/fincatto/nfe)

## Atenção
O pacote de classes nfe200 refere-se à versão 2.00 da NFe.<br/>
Ele deve ser utilizado apenas para tradução de notas antigas pois é prevista sua desativação em 31/03/2015, portanto,
faça a integração com o teu sistema com as classes contidas no pacote nfe310.<br/>
<br/>
Este é um projeto colaborativo, sinta-se a vontade em usar e colaborar com o mesmo.<br/>
Antes de submeter um patch, verifique a estrutura seguida pelo projeto e procure incluir no mesmo testes unitários que 
garantam que a funcionalidade funciona como o esperado.

## Como usar
Basicamente você precisará de uma implementação de **NFeConfig**, com informações de tipo de emissão, certificados 
digitais, e uma instância da **WsFacade**, essa classe tem a responsabilidade de fazer a ponte entre o seu sistema e a 
comunicação com os webservices da Sefaz.

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

Faça o envio do lote atraves do facade:
```java
final NFLoteEnvioRetorno retorno = new WSFacade(config).enviaLote(lote);
```

#### Corrige nota
Faça a correcao da nota atraves do facade:
```java
final NFEnviaEventoRetorno retorno = new WSFacade(config).corrigeNota(chaveDeAcessoDaNota, textoCorrecao);
```

#### Cancela nota
Faça o cancelamento da nota atraves do facade:
```java
final NFEnviaEventoRetorno retorno = new WSFacade(config).cancelaNota(chaveDeAcessoDaNota, protocoloDaNota, motivoCancelaamento);
```

### Funcionalidades
* Possui validação de campos a nível de código;
* Valida o XML de envio de lote através dos xsd's disponiblizados pela Sefaz;
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

## TO-DO LIST
* Envio de nota de forma síncrona (nota a nota, permitido a partir da NF-e 3.10);
* Envio de notas em contingência.

## Criação do Java KeyStore (JKS)
Para usar os serviços da nota fiscal são necessarios dois certificados, o certificado do cliente que será utilizado para assinar as notas e comunicar com o fisco e o certificado da SEFAZ que desejamos acesso.

Os certificados são um ponto critico já que estes tem validade de apenas um ano (certificado cliente). Além disso as SEFAZ vem trocando suas cadeias de certificado a cada atualização. Dessa forma se surgirem erros de SSL vale a pena verificar se existem novas atualizações de certificados.

Para criação do JKS sera utilizada a ferramenta keytool do java ($JRE_HOME/bin/keytool).

Obter os certificados da certificadora raiz disponibilizados por cada SEFAZ.
* https://homologacao.nfe.sefaz.rs.gov.br/
* https://nfe.sefaz.rs.gov.br/
* https://serasa.certificadodigital.com.br/ajuda/instalacao/cadeia-de-certificados/

Converter o arquivo .cer para jks utilizando keytool:
* keytool -importcert -trustcacerts -alias icp_br -file CertificadoACRaiz.cer -keystore keystore.jks

## Licença
Apache 2.0

## Dúvidas?
O projeto da NFe brasileira é relativamente complexo e propenso a dúvidas. <br/>
Para ajudar a saná-las, foi disponibilizado um fórum para ajudar na implementação e tirar dúvidas:
* [Fórum NFe](http://tecnoandroid.com.br/nfe/) 

##Agradecimentos
- [Edson Moretti](https://github.com/edsonmoretti): Criação e manutenção do forum
