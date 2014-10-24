package com.fincatto.nfe310.classes.cartacorrecao;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.evento.cartacorrecao.NFInfoCartaCorrecao;

public class NFInfoCartaCorrecaoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDescricaoEventoComTamanhoInvalido() {
        final NFInfoCartaCorrecao cartaCorrecao = new NFInfoCartaCorrecao();
        try {
            cartaCorrecao.setDescricaoEvento("YOnu");
        } catch (final IllegalStateException e) {
            cartaCorrecao.setDescricaoEvento("BvB4pkKXeortfa9qKOktO7ISeo2pnoHjOwOS05FygYEmg5kGGeG5peQ5PrDJL");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCorrecaoComTamanhoInvalido() {
        final NFInfoCartaCorrecao cartaCorrecao = new NFInfoCartaCorrecao();
        try {
            cartaCorrecao.setCorrecao("YOnuN1AFNX0xpG");
        } catch (final IllegalStateException e) {
            cartaCorrecao.setCorrecao("GtsYuGiKh9h9w3v9CYm7SUUSPo2a5P1TXDzA3CX5p7SFwgFUZVKT4RLLKJKLX6M8gYyr0QG3fPA4ahffeVcB7avzf6C2SWISJ3l251NvnpIM3VATTyBfm5MJxZljegXvc79jhUtotiwt2iUn2x4W2XFRwQHuKnZvkXGuOr4BoX94gGCFuxXus59okD0scjbnPar6ToOpzW86xNn7mGwmAbUJJJTgrikR1GSi03TeiLT9grSizvPqMHgbXFSKOYyBvjWyK3wlhqLrzAvnynunibUnZFEEZNjglyWSItEocQwvUHM5VvOmKu0oIrUB64m6FBXqku3m8zHTAxMoevq8fpabWZGnqtEbBl9hJRRNBDhmbkNg48OXTHNjqO6vpeoEl7EGhR2rrCHuQMgLXKsvFTBVcCblfbKwJ7tCzhQWfgN8KOH0OHpqCnMVk4WBSjNcn5gt0SiXq8bFEDOsvKt62LnPsKCsE9A59P6SBJFG8A1E4T7XuyItBUSZoY0e0pBAVBwJuOUFobCR138KGPFAGa5hDDQv0Pnu9nyDEuOUYD7me3kAGTq9U4Ln7cyg5FbENwY6EcKp6mY5FjaXez0tW0hKRKaXfuk7ojExtv8f3plvSL9HY5ZO10wS64GMhRlEbrzUAW3Pucq2m2e2xm39sbFhatXbfxhT3coSEhPRfMRCxkw30yzfhAclOtF2gH7EoUIZ517mMPqS1NGp4F4unpCf58DaTg5c8phyAlWD96Io9jueeN2QIs6aGVEcRzYsQGpnwXgTYxX2LeLvxeu4aET4Jvh4OFq0jQ3Xby6c5pMkNLktjtR83u7wsQWwiSOivVBp4HAW2wGevLbY7kNougJmMIPLAjtATFKExjuBJylvV2DQYBnVfbg5ApmW0n0V8LiKb2L5TxBK5ISO8PhtMvrJcSJIjFVOSMe1yEAsLfUbfpUCX42yOs0rXImjyn0AsfmqzMf9YVLByE3s6aVGItY2TgQI2zkjBSgDi1vR1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCondicaoUsoNulo() {
        final NFInfoCartaCorrecao cartaCorrecao = new NFInfoCartaCorrecao();
        cartaCorrecao.setCorrecao("GtsYuGiKh9h9w3v9CYm7SUUSPo2a5P1TXDzA3CX5p7SFwgFUZVKT4RLLKJKLX6M8gYyr0QG3fPA4ahffeVcB7avzf6C2SWISJ3l251NvnpIM3VATTyBfm5MJxZljegXvc79jhUtotiwt2iUn2x4W2XFRwQHuKnZvkXGuOr4BoX94gGCFuxXus59okD0scjbnPar6ToOpzW86xNn7mGwmAbUJJJTgrikR1GSi03TeiLT9grSizvPqMHgbXFSKOYyBvjWyK3wlhqLrzAvnynunibUnZFEEZNjglyWSItEocQwvUHM5VvOmKu0oIrUB64m6FBXqku3m8zHTAxMoevq8fpabWZGnqtEbBl9hJRRNBDhmbkNg48OXTHNjqO6vpeoEl7EGhR2rrCHuQMgLXKsvFTBVcCblfbKwJ7tCzhQWfgN8KOH0OHpqCnMVk4WBSjNcn5gt0SiXq8bFEDOsvKt62LnPsKCsE9A59P6SBJFG8A1E4T7XuyItBUSZoY0e0pBAVBwJuOUFobCR138KGPFAGa5hDDQv0Pnu9nyDEuOUYD7me3kAGTq9U4Ln7cyg5FbENwY6EcKp6mY5FjaXez0tW0hKRKaXfuk7ojExtv8f3plvSL9HY5ZO10wS64GMhRlEbrzUAW3Pucq2m2e2xm39sbFhatXbfxhT3coSEhPRfMRCxkw30yzfhAclOtF2gH7EoUIZ517mMPqS1NGp4F4unpCf58DaTg5c8phyAlWD96Io9jueeN2QIs6aGVEcRzYsQGpnwXgTYxX2LeLvxeu4aET4Jvh4OFq0jQ3Xby6c5pMkNLktjtR83u7wsQWwiSOivVBp4HAW2wGevLbY7kNougJmMIPLAjtATFKExjuBJylvV2DQYBnVfbg5ApmW0n0V8LiKb2L5TxBK5ISO8PhtMvrJcSJIjFVOSMe1yEAsLfUbfpUCX42yOs0rXImjyn0AsfmqzMf9YVLByE3s6aVGItY2TgQI2zkjBSgDi1vR");
        cartaCorrecao.setDescricaoEvento("Carta de Correcao");
        cartaCorrecao.setVersao(new BigDecimal("1.00"));
        cartaCorrecao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCorrecaoNulo() {
        final NFInfoCartaCorrecao cartaCorrecao = new NFInfoCartaCorrecao();
        cartaCorrecao.setCondicaoDeUso("A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.");
        cartaCorrecao.setDescricaoEvento("Carta de Correcao");
        cartaCorrecao.setVersao(new BigDecimal("1.00"));
        cartaCorrecao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDescricaoEventoNulo() {
        final NFInfoCartaCorrecao cartaCorrecao = new NFInfoCartaCorrecao();
        cartaCorrecao.setCondicaoDeUso("A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.");
        cartaCorrecao.setCorrecao("GtsYuGiKh9h9w3v9CYm7SUUSPo2a5P1TXDzA3CX5p7SFwgFUZVKT4RLLKJKLX6M8gYyr0QG3fPA4ahffeVcB7avzf6C2SWISJ3l251NvnpIM3VATTyBfm5MJxZljegXvc79jhUtotiwt2iUn2x4W2XFRwQHuKnZvkXGuOr4BoX94gGCFuxXus59okD0scjbnPar6ToOpzW86xNn7mGwmAbUJJJTgrikR1GSi03TeiLT9grSizvPqMHgbXFSKOYyBvjWyK3wlhqLrzAvnynunibUnZFEEZNjglyWSItEocQwvUHM5VvOmKu0oIrUB64m6FBXqku3m8zHTAxMoevq8fpabWZGnqtEbBl9hJRRNBDhmbkNg48OXTHNjqO6vpeoEl7EGhR2rrCHuQMgLXKsvFTBVcCblfbKwJ7tCzhQWfgN8KOH0OHpqCnMVk4WBSjNcn5gt0SiXq8bFEDOsvKt62LnPsKCsE9A59P6SBJFG8A1E4T7XuyItBUSZoY0e0pBAVBwJuOUFobCR138KGPFAGa5hDDQv0Pnu9nyDEuOUYD7me3kAGTq9U4Ln7cyg5FbENwY6EcKp6mY5FjaXez0tW0hKRKaXfuk7ojExtv8f3plvSL9HY5ZO10wS64GMhRlEbrzUAW3Pucq2m2e2xm39sbFhatXbfxhT3coSEhPRfMRCxkw30yzfhAclOtF2gH7EoUIZ517mMPqS1NGp4F4unpCf58DaTg5c8phyAlWD96Io9jueeN2QIs6aGVEcRzYsQGpnwXgTYxX2LeLvxeu4aET4Jvh4OFq0jQ3Xby6c5pMkNLktjtR83u7wsQWwiSOivVBp4HAW2wGevLbY7kNougJmMIPLAjtATFKExjuBJylvV2DQYBnVfbg5ApmW0n0V8LiKb2L5TxBK5ISO8PhtMvrJcSJIjFVOSMe1yEAsLfUbfpUCX42yOs0rXImjyn0AsfmqzMf9YVLByE3s6aVGItY2TgQI2zkjBSgDi1vR");
        cartaCorrecao.setVersao(new BigDecimal("1.00"));
        cartaCorrecao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVersaoNulo() {
        final NFInfoCartaCorrecao cartaCorrecao = new NFInfoCartaCorrecao();
        cartaCorrecao.setCondicaoDeUso("A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.");
        cartaCorrecao.setCorrecao("GtsYuGiKh9h9w3v9CYm7SUUSPo2a5P1TXDzA3CX5p7SFwgFUZVKT4RLLKJKLX6M8gYyr0QG3fPA4ahffeVcB7avzf6C2SWISJ3l251NvnpIM3VATTyBfm5MJxZljegXvc79jhUtotiwt2iUn2x4W2XFRwQHuKnZvkXGuOr4BoX94gGCFuxXus59okD0scjbnPar6ToOpzW86xNn7mGwmAbUJJJTgrikR1GSi03TeiLT9grSizvPqMHgbXFSKOYyBvjWyK3wlhqLrzAvnynunibUnZFEEZNjglyWSItEocQwvUHM5VvOmKu0oIrUB64m6FBXqku3m8zHTAxMoevq8fpabWZGnqtEbBl9hJRRNBDhmbkNg48OXTHNjqO6vpeoEl7EGhR2rrCHuQMgLXKsvFTBVcCblfbKwJ7tCzhQWfgN8KOH0OHpqCnMVk4WBSjNcn5gt0SiXq8bFEDOsvKt62LnPsKCsE9A59P6SBJFG8A1E4T7XuyItBUSZoY0e0pBAVBwJuOUFobCR138KGPFAGa5hDDQv0Pnu9nyDEuOUYD7me3kAGTq9U4Ln7cyg5FbENwY6EcKp6mY5FjaXez0tW0hKRKaXfuk7ojExtv8f3plvSL9HY5ZO10wS64GMhRlEbrzUAW3Pucq2m2e2xm39sbFhatXbfxhT3coSEhPRfMRCxkw30yzfhAclOtF2gH7EoUIZ517mMPqS1NGp4F4unpCf58DaTg5c8phyAlWD96Io9jueeN2QIs6aGVEcRzYsQGpnwXgTYxX2LeLvxeu4aET4Jvh4OFq0jQ3Xby6c5pMkNLktjtR83u7wsQWwiSOivVBp4HAW2wGevLbY7kNougJmMIPLAjtATFKExjuBJylvV2DQYBnVfbg5ApmW0n0V8LiKb2L5TxBK5ISO8PhtMvrJcSJIjFVOSMe1yEAsLfUbfpUCX42yOs0rXImjyn0AsfmqzMf9YVLByE3s6aVGItY2TgQI2zkjBSgDi1vR");
        cartaCorrecao.setDescricaoEvento("Carta de Correcao");
        cartaCorrecao.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoCartaCorrecao versao=\"1.00\"><descEvento>Carta de Correcao</descEvento><xCorrecao>GtsYuGiKh9h9w3v9CYm7SUUSPo2a5P1TXDzA3CX5p7SFwgFUZVKT4RLLKJKLX6M8gYyr0QG3fPA4ahffeVcB7avzf6C2SWISJ3l251NvnpIM3VATTyBfm5MJxZljegXvc79jhUtotiwt2iUn2x4W2XFRwQHuKnZvkXGuOr4BoX94gGCFuxXus59okD0scjbnPar6ToOpzW86xNn7mGwmAbUJJJTgrikR1GSi03TeiLT9grSizvPqMHgbXFSKOYyBvjWyK3wlhqLrzAvnynunibUnZFEEZNjglyWSItEocQwvUHM5VvOmKu0oIrUB64m6FBXqku3m8zHTAxMoevq8fpabWZGnqtEbBl9hJRRNBDhmbkNg48OXTHNjqO6vpeoEl7EGhR2rrCHuQMgLXKsvFTBVcCblfbKwJ7tCzhQWfgN8KOH0OHpqCnMVk4WBSjNcn5gt0SiXq8bFEDOsvKt62LnPsKCsE9A59P6SBJFG8A1E4T7XuyItBUSZoY0e0pBAVBwJuOUFobCR138KGPFAGa5hDDQv0Pnu9nyDEuOUYD7me3kAGTq9U4Ln7cyg5FbENwY6EcKp6mY5FjaXez0tW0hKRKaXfuk7ojExtv8f3plvSL9HY5ZO10wS64GMhRlEbrzUAW3Pucq2m2e2xm39sbFhatXbfxhT3coSEhPRfMRCxkw30yzfhAclOtF2gH7EoUIZ517mMPqS1NGp4F4unpCf58DaTg5c8phyAlWD96Io9jueeN2QIs6aGVEcRzYsQGpnwXgTYxX2LeLvxeu4aET4Jvh4OFq0jQ3Xby6c5pMkNLktjtR83u7wsQWwiSOivVBp4HAW2wGevLbY7kNougJmMIPLAjtATFKExjuBJylvV2DQYBnVfbg5ApmW0n0V8LiKb2L5TxBK5ISO8PhtMvrJcSJIjFVOSMe1yEAsLfUbfpUCX42yOs0rXImjyn0AsfmqzMf9YVLByE3s6aVGItY2TgQI2zkjBSgDi1vR</xCorrecao><xCondUso>A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.</xCondUso></NFInfoCartaCorrecao>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoCartaCorrecao().toString());
    }
}