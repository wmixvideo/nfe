package com.fincatto.documentofiscal.nfe310.classes.cartacorrecao;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFInfoEvento;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class NFInfoEventoCartaCorrecaoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJComTamanhoInvalido() {
        try {
            new NFInfoEvento().setCnpj("1234567890123");
        } catch (final IllegalStateException e) {
            new NFInfoEvento().setCpf("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCPFComTamanhoInvalido() {
        try {
            new NFInfoEvento().setCpf("1234567890");
        } catch (final IllegalStateException e) {
            new NFInfoEvento().setCnpj("123456789012");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAmbienteNulo() {
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setDadosEvento(FabricaDeObjetosFake.getNFInfoCartaCorrecao());
        infoEvento.setChave("81568004734874930428983724940883089298523837");
        infoEvento.setCnpj("02224343323426");
        infoEvento.setDataHoraEvento(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-01-01 10:10:10")), ZoneId.systemDefault()));
        infoEvento.setId("ID1101108156800473487493042898372494088308929852383799");
        infoEvento.setNumeroSequencialEvento(99);
        infoEvento.setOrgao(DFUnidadeFederativa.SC);
        infoEvento.setTipoEvento("110110");
        infoEvento.setVersaoEvento(new BigDecimal("1.00"));
        infoEvento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCartaCorrecaoNulo() {
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(DFAmbiente.HOMOLOGACAO);
        infoEvento.setChave("81568004734874930428983724940883089298523837");
        infoEvento.setCnpj("02224343323426");
        infoEvento.setDataHoraEvento(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-01-01 10:10:10")), ZoneId.systemDefault()));
        infoEvento.setId("ID1101108156800473487493042898372494088308929852383799");
        infoEvento.setNumeroSequencialEvento(99);
        infoEvento.setOrgao(DFUnidadeFederativa.SC);
        infoEvento.setTipoEvento("110110");
        infoEvento.setVersaoEvento(new BigDecimal("1.00"));
        infoEvento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChaveNulo() {
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(DFAmbiente.HOMOLOGACAO);
        infoEvento.setDadosEvento(FabricaDeObjetosFake.getNFInfoCartaCorrecao());
        infoEvento.setCnpj("02224343323426");
        infoEvento.setDataHoraEvento(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-01-01 10:10:10")), ZoneId.systemDefault()));
        infoEvento.setId("ID1101108156800473487493042898372494088308929852383799");
        infoEvento.setNumeroSequencialEvento(99);
        infoEvento.setOrgao(DFUnidadeFederativa.SC);
        infoEvento.setTipoEvento("110110");
        infoEvento.setVersaoEvento(new BigDecimal("1.00"));
        infoEvento.toString();
    }

    @Test
    public void devePermitirCnpjNulo() {
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(DFAmbiente.HOMOLOGACAO);
        infoEvento.setDadosEvento(FabricaDeObjetosFake.getNFInfoCartaCorrecao());
        infoEvento.setChave("81568004734874930428983724940883089298523837");
        infoEvento.setDataHoraEvento(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-01-01 10:10:10")), ZoneId.systemDefault()));
        infoEvento.setId("ID1101108156800473487493042898372494088308929852383799");
        infoEvento.setNumeroSequencialEvento(99);
        infoEvento.setOrgao(DFUnidadeFederativa.SC);
        infoEvento.setTipoEvento("110110");
        infoEvento.setVersaoEvento(new BigDecimal("1.00"));
        infoEvento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDataHoraEventoNulo() {
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(DFAmbiente.HOMOLOGACAO);
        infoEvento.setDadosEvento(FabricaDeObjetosFake.getNFInfoCartaCorrecao());
        infoEvento.setChave("81568004734874930428983724940883089298523837");
        infoEvento.setCnpj("02224343323426");
        infoEvento.setId("ID1101108156800473487493042898372494088308929852383799");
        infoEvento.setNumeroSequencialEvento(99);
        infoEvento.setOrgao(DFUnidadeFederativa.SC);
        infoEvento.setTipoEvento("110110");
        infoEvento.setVersaoEvento(new BigDecimal("1.00"));
        infoEvento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdNulo() {
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(DFAmbiente.HOMOLOGACAO);
        infoEvento.setDadosEvento(FabricaDeObjetosFake.getNFInfoCartaCorrecao());
        infoEvento.setChave("81568004734874930428983724940883089298523837");
        infoEvento.setCnpj("02224343323426");
        infoEvento.setDataHoraEvento(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-01-01 10:10:10")), ZoneId.systemDefault()));
        infoEvento.setNumeroSequencialEvento(99);
        infoEvento.setOrgao(DFUnidadeFederativa.SC);
        infoEvento.setTipoEvento("110110");
        infoEvento.setVersaoEvento(new BigDecimal("1.00"));
        infoEvento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroSequencialEventoNulo() {
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(DFAmbiente.HOMOLOGACAO);
        infoEvento.setDadosEvento(FabricaDeObjetosFake.getNFInfoCartaCorrecao());
        infoEvento.setChave("81568004734874930428983724940883089298523837");
        infoEvento.setCnpj("02224343323426");
        infoEvento.setDataHoraEvento(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-01-01 10:10:10")), ZoneId.systemDefault()));
        infoEvento.setId("ID1101108156800473487493042898372494088308929852383799");
        infoEvento.setOrgao(DFUnidadeFederativa.SC);
        infoEvento.setTipoEvento("110110");
        infoEvento.setVersaoEvento(new BigDecimal("1.00"));
        infoEvento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrgaoNulo() {
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(DFAmbiente.HOMOLOGACAO);
        infoEvento.setDadosEvento(FabricaDeObjetosFake.getNFInfoCartaCorrecao());
        infoEvento.setChave("81568004734874930428983724940883089298523837");
        infoEvento.setCnpj("02224343323426");
        infoEvento.setDataHoraEvento(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-01-01 10:10:10")), ZoneId.systemDefault()));
        infoEvento.setId("ID1101108156800473487493042898372494088308929852383799");
        infoEvento.setNumeroSequencialEvento(99);
        infoEvento.setTipoEvento("110110");
        infoEvento.setVersaoEvento(new BigDecimal("1.00"));
        infoEvento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoEventoNulo() {
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(DFAmbiente.HOMOLOGACAO);
        infoEvento.setDadosEvento(FabricaDeObjetosFake.getNFInfoCartaCorrecao());
        infoEvento.setChave("81568004734874930428983724940883089298523837");
        infoEvento.setCnpj("02224343323426");
        infoEvento.setDataHoraEvento(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-01-01 10:10:10")), ZoneId.systemDefault()));
        infoEvento.setId("ID1101108156800473487493042898372494088308929852383799");
        infoEvento.setNumeroSequencialEvento(99);
        infoEvento.setOrgao(DFUnidadeFederativa.SC);
        infoEvento.setVersaoEvento(new BigDecimal("1.00"));
        infoEvento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVersaoEventoNulo() {
        final NFInfoEvento infoEvento = new NFInfoEvento();
        infoEvento.setAmbiente(DFAmbiente.HOMOLOGACAO);
        infoEvento.setDadosEvento(FabricaDeObjetosFake.getNFInfoCartaCorrecao());
        infoEvento.setChave("81568004734874930428983724940883089298523837");
        infoEvento.setCnpj("02224343323426");
        infoEvento.setDataHoraEvento(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-01-01 10:10:10")), ZoneId.systemDefault()));
        infoEvento.setId("ID1101108156800473487493042898372494088308929852383799");
        infoEvento.setNumeroSequencialEvento(99);
        infoEvento.setOrgao(DFUnidadeFederativa.SC);
        infoEvento.setTipoEvento("110110");
        infoEvento.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoEvento Id=\"ID1101108156800473487493042898372494088308929852383799\"><cOrgao>42</cOrgao><tpAmb>2</tpAmb><CNPJ>02224343323426</CNPJ><chNFe>81568004734874930428983724940883089298523837</chNFe><dhEvento>2014-01-01T10:10:10-02:00</dhEvento><tpEvento>110110</tpEvento><nSeqEvento>99</nSeqEvento><verEvento>1.00</verEvento><detEvento versao=\"1.00\"><descEvento>Carta de Correcao</descEvento><xCorrecao>GtsYuGiKh9h9w3v9CYm7SUUSPo2a5P1TXDzA3CX5p7SFwgFUZVKT4RLLKJKLX6M8gYyr0QG3fPA4ahffeVcB7avzf6C2SWISJ3l251NvnpIM3VATTyBfm5MJxZljegXvc79jhUtotiwt2iUn2x4W2XFRwQHuKnZvkXGuOr4BoX94gGCFuxXus59okD0scjbnPar6ToOpzW86xNn7mGwmAbUJJJTgrikR1GSi03TeiLT9grSizvPqMHgbXFSKOYyBvjWyK3wlhqLrzAvnynunibUnZFEEZNjglyWSItEocQwvUHM5VvOmKu0oIrUB64m6FBXqku3m8zHTAxMoevq8fpabWZGnqtEbBl9hJRRNBDhmbkNg48OXTHNjqO6vpeoEl7EGhR2rrCHuQMgLXKsvFTBVcCblfbKwJ7tCzhQWfgN8KOH0OHpqCnMVk4WBSjNcn5gt0SiXq8bFEDOsvKt62LnPsKCsE9A59P6SBJFG8A1E4T7XuyItBUSZoY0e0pBAVBwJuOUFobCR138KGPFAGa5hDDQv0Pnu9nyDEuOUYD7me3kAGTq9U4Ln7cyg5FbENwY6EcKp6mY5FjaXez0tW0hKRKaXfuk7ojExtv8f3plvSL9HY5ZO10wS64GMhRlEbrzUAW3Pucq2m2e2xm39sbFhatXbfxhT3coSEhPRfMRCxkw30yzfhAclOtF2gH7EoUIZ517mMPqS1NGp4F4unpCf58DaTg5c8phyAlWD96Io9jueeN2QIs6aGVEcRzYsQGpnwXgTYxX2LeLvxeu4aET4Jvh4OFq0jQ3Xby6c5pMkNLktjtR83u7wsQWwiSOivVBp4HAW2wGevLbY7kNougJmMIPLAjtATFKExjuBJylvV2DQYBnVfbg5ApmW0n0V8LiKb2L5TxBK5ISO8PhtMvrJcSJIjFVOSMe1yEAsLfUbfpUCX42yOs0rXImjyn0AsfmqzMf9YVLByE3s6aVGItY2TgQI2zkjBSgDi1vR</xCorrecao><xCondUso>A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.</xCondUso></detEvento></NFInfoEvento>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoEventoCartaCorrecao().toString());
    }
}