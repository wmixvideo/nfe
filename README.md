Nota Fiscal Eletronica 2.00 e 3.10
===
[![Build Status](https://api.travis-ci.org/fincatto/nfe.png)](http://travis-ci.org/#!/fincatto/nfe)

Comunicador de nota fiscal (versão 3.1) da [fazenda](http://www.nfe.fazenda.gov.br/portal/principal.aspx)


## Como usar

### Exemplo 1, envio do lote para o sefaz

Popule os dados do lote a ser enviado para o SEFAZ

```java
NFLoteEnvio lote = new NFLoteEnvio();
// setando os dados do lote
```

Implemente a interface NFeConfig e crie suas configuracoes
```java
MeuConfig config = new MeuConfig();
```

Faça o envio do lote atraves do facade
```java
final NFLoteEnvioRetorno retorno = new WSFacade(config).enviaLote(lote);
```

Pronto, o lote foi enviado e os dados de retorno estará setado no objeto da classe NFLoteEnvioRetorno