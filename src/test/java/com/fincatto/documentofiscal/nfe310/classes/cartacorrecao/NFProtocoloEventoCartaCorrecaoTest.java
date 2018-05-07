package com.fincatto.documentofiscal.nfe310.classes.cartacorrecao;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFEventoRetorno;
import com.fincatto.documentofiscal.nfe310.classes.evento.NFInfoEventoRetorno;
import com.fincatto.documentofiscal.nfe310.classes.evento.cartacorrecao.NFProtocoloEventoCartaCorrecao;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NFProtocoloEventoCartaCorrecaoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFProtocoloEventoCartaCorrecao procEvento = new NFProtocoloEventoCartaCorrecao();
        procEvento.setVersao("1.00");
        Assert.assertEquals("1.00", procEvento.getVersao());
    }
    
    @Test
    public void deveObterEventoComoFoiSetado() {
        final NFProtocoloEventoCartaCorrecao procEvento = new NFProtocoloEventoCartaCorrecao();
        procEvento.setEvento(FabricaDeObjetosFake.getNFEventoCartaCorrecao());
        Assert.assertEquals(FabricaDeObjetosFake.getNFEventoCartaCorrecao().getVersao(), procEvento.getEvento().getVersao());
    }
    
    @Test
    public void deveObterEventoRetornoComoFoiSetado() {
        final NFProtocoloEventoCartaCorrecao procEvento = new NFProtocoloEventoCartaCorrecao();
        final NFEventoRetorno eventoRet = new NFEventoRetorno();
        eventoRet.setVersao("1.00");
        procEvento.setEventoRetorno(eventoRet);
        Assert.assertEquals(eventoRet.getVersao(), procEvento.getEventoRetorno().getVersao());
    }
    
    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFProtocoloEventoCartaCorrecao procEvento = new NFProtocoloEventoCartaCorrecao();
        procEvento.setVersao("1.00");
        
        final NFEventoRetorno eventoRetorno = new NFEventoRetorno();
        eventoRetorno.setVersao("1.0");
        
        final NFInfoEventoRetorno infoEventoRetorno = new NFInfoEventoRetorno();
        infoEventoRetorno.setAmbiente(DFAmbiente.PRODUCAO);
        infoEventoRetorno.setChave("hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6");
        infoEventoRetorno.setCodigoStatus(1);
        infoEventoRetorno.setCpnj("99999999999999");
        infoEventoRetorno.setDataHoraRegistro(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .parse("2016-11-30 02:30:00")));
        infoEventoRetorno.setDescricaoEvento("sdskjdkjdsdcklkjdsakndcsakjdckdljsdckjasldnclakjdsalkdcskdjacdsadcsacd");
        infoEventoRetorno.setId("123456789123456789123456789123456789123456789");
        infoEventoRetorno.setMotivo("asdsdsjdslkdjsaldjsldk");
        infoEventoRetorno.setNumeroProtocolo("999999999999999");
        infoEventoRetorno.setOrgao(DFUnidadeFederativa.GO);
        infoEventoRetorno.setTipoEvento("110111");
        infoEventoRetorno.setVersaoAplicativo("SVRS201601161016");

        eventoRetorno.setInfoEventoRetorno(infoEventoRetorno);
        
        procEvento.setEventoRetorno(eventoRetorno);
        procEvento.setEvento(FabricaDeObjetosFake.getNFEventoCartaCorrecao());
        
        final String xmlEsperado = "<procEventoNFe versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><evento versao=\"1.00\"><infEvento Id=\"ID1101108156800473487493042898372494088308929852383799\"><cOrgao>42</cOrgao><tpAmb>2</tpAmb><CNPJ>02224343323426</CNPJ><chNFe>81568004734874930428983724940883089298523837</chNFe><dhEvento>2014-01-01T10:10:10-02:00</dhEvento><tpEvento>110110</tpEvento><nSeqEvento>99</nSeqEvento><verEvento>1.00</verEvento><detEvento versao=\"1.00\"><descEvento>Carta de Correcao</descEvento><xCorrecao>GtsYuGiKh9h9w3v9CYm7SUUSPo2a5P1TXDzA3CX5p7SFwgFUZVKT4RLLKJKLX6M8gYyr0QG3fPA4ahffeVcB7avzf6C2SWISJ3l251NvnpIM3VATTyBfm5MJxZljegXvc79jhUtotiwt2iUn2x4W2XFRwQHuKnZvkXGuOr4BoX94gGCFuxXus59okD0scjbnPar6ToOpzW86xNn7mGwmAbUJJJTgrikR1GSi03TeiLT9grSizvPqMHgbXFSKOYyBvjWyK3wlhqLrzAvnynunibUnZFEEZNjglyWSItEocQwvUHM5VvOmKu0oIrUB64m6FBXqku3m8zHTAxMoevq8fpabWZGnqtEbBl9hJRRNBDhmbkNg48OXTHNjqO6vpeoEl7EGhR2rrCHuQMgLXKsvFTBVcCblfbKwJ7tCzhQWfgN8KOH0OHpqCnMVk4WBSjNcn5gt0SiXq8bFEDOsvKt62LnPsKCsE9A59P6SBJFG8A1E4T7XuyItBUSZoY0e0pBAVBwJuOUFobCR138KGPFAGa5hDDQv0Pnu9nyDEuOUYD7me3kAGTq9U4Ln7cyg5FbENwY6EcKp6mY5FjaXez0tW0hKRKaXfuk7ojExtv8f3plvSL9HY5ZO10wS64GMhRlEbrzUAW3Pucq2m2e2xm39sbFhatXbfxhT3coSEhPRfMRCxkw30yzfhAclOtF2gH7EoUIZ517mMPqS1NGp4F4unpCf58DaTg5c8phyAlWD96Io9jueeN2QIs6aGVEcRzYsQGpnwXgTYxX2LeLvxeu4aET4Jvh4OFq0jQ3Xby6c5pMkNLktjtR83u7wsQWwiSOivVBp4HAW2wGevLbY7kNougJmMIPLAjtATFKExjuBJylvV2DQYBnVfbg5ApmW0n0V8LiKb2L5TxBK5ISO8PhtMvrJcSJIjFVOSMe1yEAsLfUbfpUCX42yOs0rXImjyn0AsfmqzMf9YVLByE3s6aVGItY2TgQI2zkjBSgDi1vR</xCorrecao><xCondUso>A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.</xCondUso></detEvento></infEvento></evento><retEvento versao=\"1.0\"><infEvento Id=\"123456789123456789123456789123456789123456789\"><tpAmb>1</tpAmb><verAplic>SVRS201601161016</verAplic><cOrgao>52</cOrgao><cStat>1</cStat><xMotivo>asdsdsjdslkdjsaldjsldk</xMotivo><chNFe>hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6</chNFe><tpEvento>110111</tpEvento><xEvento>sdskjdkjdsdcklkjdsakndcsakjdckdljsdckjasldnclakjdsalkdcskdjacdsadcsacd</xEvento><CNPJDest>99999999999999</CNPJDest><dhRegEvento>2016-11-30T02:30:00-02:00</dhRegEvento><nProt>999999999999999</nProt></infEvento></retEvento></procEventoNFe>";
        Assert.assertEquals(xmlEsperado, procEvento.toString());
    }
}