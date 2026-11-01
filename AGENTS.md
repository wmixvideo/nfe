# AGENTS.md
Instruções para agentes de IA (Claude Code, Codex, Cursor, Copilot etc.). O `CLAUDE.md` apenas importa este arquivo.

## Projeto
Biblioteca Java para emissão e comunicação com a SEFAZ de documentos fiscais eletrônicos brasileiros: NF-e/NFC-e, CT-e e MDF-e.
Publicada no Maven Central como `com.github.wmixvideo:nfe`. Pacote base: `com.fincatto.documentofiscal`.

**Idioma:** português para mensagens de commit, títulos e descrições de PR, documentação, comentários e novos identificadores (classes, métodos, variáveis).

## Comandos
Projeto Maven de módulo único.

- Build completo com testes: `mvn clean package`
- Uma classe de teste: `mvn test -Dtest=NFNotaInfoItemImpostoICMSPartilhadoTest`
- Um método de teste: `mvn test -Dtest=NFMeioPagamentoTest#deveObterTipoApartirDoSeuCodigo`

O código compila para **Java 11** (`<release>11</release>`), embora o CI use o JDK 21. Não use recursos de versões mais novas (`record`, `switch` com `->`, text blocks, APIs como `List.toList()`): o build falha.

## Estrutura
- `src/main/java/com/fincatto/documentofiscal/<documento><versão>`: um pacote por documento e versão de leiaute (`nfe400`, `nfe310`, `cte400`, `cte300`, `mdfe3` etc.). Cada um contém:
  - `classes/`: modelo do XML (classes e enums);
  - `transformers/`: conversão de enums de/para o XML;
  - `webservices/`: comunicação com a SEFAZ.
- Código novo vai na versão vigente (`nfe400`, `cte400`, `mdfe3`). Só altere versões legadas (`nfe310`, `cte300`, `cte200`) quando for pedido explicitamente.
- `NFAutorizador400`, `CTAutorizador400` e `MDFAutorizador3` concentram as URLs dos webservices por UF.
- `src/main/resources/schemas/<pacote PL>`: XSDs oficiais. O pacote ativo de cada documento é definido nas constantes `PACOTE_*` de `DFXMLValidador`.

## Implementando leiautes e Notas Técnicas
O XSD do pacote ativo é a fonte da verdade. Ao implementar uma Nota Técnica ou Informe Técnico:

1. Se a NT traz novo pacote de schemas, adicione a pasta em `schemas/` e atualize a constante `PACOTE_*` em `DFXMLValidador`.
2. Localize o grupo no `leiauteNFe_v4.00.xsd` (ou equivalente) e mapeie cada tag seguindo as regras abaixo.
3. Cite a NT e a versão no PR.

### Regras de mapeamento XSD → Java
- O nome em `@Element(name = ...)` é exatamente o nome da tag no XSD.
- `minOccurs="0"` vira `required = false`. Grupos `xs:choice` também usam `required = false` em todos os campos.
- **A ordem dos campos na classe segue a ordem do XSD.** O Simple XML serializa os campos na ordem em que são declarados; ordem errada gera XML rejeitado pela SEFAZ.
- Listas usam `@ElementList(entry = "<tag>", inline = true, required = ...)`.
- Classes de modelo estendem `DFBase` (que gera o XML no `toString()`) e, quando novas, declaram `serialVersionUID`.
- Getters retornam o valor como está no campo; setters recebem o tipo de domínio e fazem validação e formatação.

### Valores numéricos
Campos decimais ficam como `String` e são formatados no setter por `DFBigDecimalValidador`, conforme o tipo `TDec_*` do XSD:

| Tipo no XSD | Inteiros / decimais | Validador |
|---|---|---|
| `TDec_1302`, `TDec_1302Opc` | 13 / 2 | `tamanho15Com2CasasDecimais` |
| `TDec_0302a04`, `TDec_0302a04Opc` | 3 / 2 a 4 | `tamanho7ComAte4CasasDecimais` |
| `TDec_1104`, `TDec_1104Opc` | 11 / 4 | `tamanho11Com4CasasDecimais` |
| `TDec_1104v` | 11 / até 4 | `tamanho15comAte4CasasDecimais` |
| `TDec_1110v` | 11 / até 10 | `tamanho21ComAte10CasasDecimais` |
| `TDec_1203` | 12 / 3 | `tamanho15Com3CasasDecimais` |
| `TDec_1204`, `TDec_1204Opc` | 12 / 4 | `tamanho16Com4CasasDecimais` |
| `TDec_1204v` | 12 / até 4 | `tamanho16ComAte4CasasDecimais` |

Para outros tipos, confira o `pattern` em `tiposBasico_v4.00.xsd` e escolha o validador com o mesmo número de inteiros e casas decimais. Textos são validados por `DFStringValidador`. Siga o que classes vizinhas já fazem para o mesmo tipo de campo.

### Enums
- Cada enum tem `codigo` e `descricao`, `getCodigo()`, `getDescricao()`, `valueOfCodigo(String)` (retorna `null` para código inexistente) e `toString()` no formato `"codigo - descricao"`.
- Enum novo precisa de um `Transform` em `transformers/` e do registro em `DFRegistryMatcher`; sem isso, a serialização falha.
- Se o XSD restringe os valores de um campo (`xs:enumeration`), documente isso no PR. A biblioteca nem sempre impede valores inválidos, mas a SEFAZ rejeita.

## Testes
- JUnit 5, com uma classe de teste por classe, no mesmo pacote (`src/test/java/...`).
- Para cada campo novo, teste:
  - os limites do validador (`assertThrows(NumberFormatException.class, ...)` para tamanho e casas decimais);
  - que campos opcionais nulos não aparecem no XML;
  - o XML gerado, comparado com uma string esperada contendo todos os campos na ordem do XSD.
- Use as `FabricaDeObjetosFake` de cada pacote (`nfe400`, `cte400`, `mdfe3` etc.) para montar documentos completos.
- Ao mexer em leiaute, valide o XML gerado contra o XSD com `DFXMLValidador`.
- Testes nunca chamam os webservices da SEFAZ nem usam certificado digital real.

## Fluxo de trabalho
- Branches a partir da `master`; mudanças entram por PR.
- Não altere a versão do `pom.xml` à mão. A liberação é feita pelo workflow **Release** (Actions → Release → Run workflow), que gera a versão, publica no Maven Central e publica o rascunho de release mantido pelo Release Drafter.
- Coloque labels nos PRs (`feature`, `enhancement`, `bug`, `security`, `documentation`, `dependencies`) para que entrem na categoria certa das notas de release.
- Nunca faça commit de certificados, senhas, chaves ou XMLs reais com dados de contribuintes.

## Diretrizes de comportamento
Diretrizes para reduzir erros comuns de agentes. Priorizam cautela em vez de velocidade; em tarefas triviais, use o bom senso.

### 1. Pense antes de codar
**Não presuma. Não esconda dúvidas. Exponha os tradeoffs.**

- Declare suas suposições. Na dúvida, pergunte.
- Se houver mais de uma interpretação, apresente-as; não escolha em silêncio.
- Se existir uma abordagem mais simples, diga. Discorde quando fizer sentido.
- Se algo estiver confuso, pare, diga o que está confuso e pergunte.

### 2. Simplicidade primeiro
**O mínimo de código que resolve o problema. Nada especulativo.**

- Nenhuma funcionalidade além do que foi pedido.
- Nenhuma abstração para código de uso único.
- Nenhuma "flexibilidade" ou configuração que não foi pedida.
- Nenhum tratamento de erro para cenários impossíveis.
- Se escreveu 200 linhas e dava para fazer em 50, reescreva.

Pergunte-se: "Um engenheiro sênior diria que isto está complicado demais?" Se sim, simplifique.

### 3. Mudanças cirúrgicas
**Mexa só no necessário. Limpe só a sua própria bagunça.**

Ao editar código existente:
- Não "melhore" código, comentários ou formatação ao redor.
- Não refatore o que não está quebrado.
- Siga o estilo existente, mesmo que você faria diferente.
- Se notar código morto não relacionado, mencione; não apague.

Quando suas mudanças deixarem sobras:
- Remova imports, variáveis e métodos que as SUAS mudanças deixaram sem uso.
- Não remova código morto pré-existente sem pedido.

O teste: cada linha alterada deve ter relação direta com o pedido.

### 4. Execução orientada a objetivos
**Defina o critério de sucesso. Repita até verificar.**

Transforme tarefas em objetivos verificáveis:
- "Adicionar validação" → "Escrever testes para entradas inválidas e fazê-los passar"
- "Corrigir o bug" → "Escrever um teste que reproduz o bug e fazê-lo passar"
- "Refatorar X" → "Garantir que os testes passam antes e depois"
- "Implementar NT" → "Gerar o XML com os campos novos e validá-lo contra o XSD"

Em tarefas com várias etapas, apresente um plano curto:
```
1. [Etapa] → verificar: [checagem]
2. [Etapa] → verificar: [checagem]
3. [Etapa] → verificar: [checagem]
```

Critérios fortes permitem trabalhar com autonomia. Critérios fracos ("fazer funcionar") exigem esclarecimentos constantes.
