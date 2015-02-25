Nota Fiscal Eletronica 2.00 e 3.10
===
[![Build Status](https://api.travis-ci.org/fincatto/nfe.png)](http://travis-ci.org/#!/fincatto/nfe)

Comunicador de nota fiscal (versão 3.1) da [fazenda](http://www.nfe.fazenda.gov.br/portal/principal.aspx)


## Como usar

### Exemplo 1, envio do lote para o sefaz

Popule os dados do lote a ser enviado para o Sefaz

```java
NFLoteEnvio lote = new NFLoteEnvio();
// setando os dados do lote
```

Implemente a interface NFeConfig e adicione suas configuracoes
```java
MeuConfig config = new MeuConfig();
```

Faça o envio do lote atraves do facade
```java
final NFLoteEnvioRetorno retorno = new WSFacade(config).enviaLote(lote);
```

### Exemplo 2, Corrige nota

Implemente a interface NFeConfig e adicione suas configuracoes
```java
MeuConfig config = new MeuConfig();
```

Faça a correcao da nota atraves do facade
```java
final NFEnviaEventoRetorno retorno = new WSFacade(config).corrigeNota(chaveDeAcessoDaNota, textoCorrecao);
```

### Exemplo 3, Cancela nota 

Implemente a interface NFeConfig e adicione suas configuracoes
```java
MeuConfig config = new MeuConfig();
```

Faça o cancelamento da nota atraves do facade
```java
final NFEnviaEventoRetorno retorno = new WSFacade(config).cancelaNota(chaveDeAcessoDaNota, protocoloDaNota, motivoCancelaamento);
```
