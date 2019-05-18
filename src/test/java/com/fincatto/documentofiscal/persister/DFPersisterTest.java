package com.fincatto.documentofiscal.persister;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento.NFEnviaEventoCancelamento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cartacorrecao.NFEnviaEventoCartaCorrecao;
import com.fincatto.documentofiscal.nfe400.classes.evento.inutilizacao.NFEnviaEventoInutilizacao;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;

public class DFPersisterTest {
    
    private Persister persister;
    
    @Before
    public void prepara() {
        this.persister = new DFPersister(DFConfig.TIMEZONE_SP);
    }
    
    @Test(expected = Exception.class)
    public void deveLancarExcecaoCasoRecebaUmaStringInvalida() throws Exception {
        this.persister.read(NFNota.class, "");
    }
    
    @Test(expected = FileNotFoundException.class)
    public void deveLancarExcecaoCasoRecebaUmArquivoInvalido() throws Exception {
        this.persister.read(NFNota.class, new File(""));
    }
    
    @Test
    public void deveParsearCorretamenteUmXMLDaNota310() throws Exception {
        final String xmlNota = FabricaDeObjetosFake.getNFNota().toString();
        final com.fincatto.documentofiscal.nfe310.classes.nota.NFNota object = this.persister.read(com.fincatto.documentofiscal.nfe310.classes.nota.NFNota.class, xmlNota);
        Assert.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteArquivoDaNota310() throws Exception {
        final File file = new File(new URI(DFPersisterTest.class.getResource("nota.xml").getFile()).getPath());
        final com.fincatto.documentofiscal.nfe310.classes.nota.NFNota object = this.persister.read(com.fincatto.documentofiscal.nfe310.classes.nota.NFNota.class, file);
        Assert.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteUmXMLDaNotaProcessada310() throws Exception {
        final String xmlNota = FabricaDeObjetosFake.getNFNotaProcessada().toString();
        final com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaProcessada object = this.persister.read(com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaProcessada.class, xmlNota);
        Assert.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteArquivoDaNotaProcessada310() throws Exception {
        final File file = new File(new URI(DFPersisterTest.class.getResource("notaprocessada.xml").getFile()).getPath());
        final com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaProcessada object = this.persister.read(com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaProcessada.class, file);
        Assert.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoCartaCorrecao() throws Exception {
        final String xmlNFEnviaEventoCartaCorrecao = FabricaDeObjetosFake.getNFEnviaEventoCartaCorrecao().toString();
        final NFEnviaEventoCartaCorrecao object = this.persister.read(NFEnviaEventoCartaCorrecao.class, xmlNFEnviaEventoCartaCorrecao);
        Assert.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoCartaCorrecao() throws Exception {
        final File file = new File(new URI(DFPersisterTest.class.getResource("enviaEventoCartaCorrecao.xml").getFile()).getPath());
        final NFEnviaEventoCartaCorrecao object = this.persister.read(NFEnviaEventoCartaCorrecao.class, file);
        Assert.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoCancelamento() throws Exception {
        final String xmlNFEnviaEventoCancelamento = FabricaDeObjetosFake.getNFEnviaEventoCancelamento().toString();
        final NFEnviaEventoCancelamento object = this.persister.read(NFEnviaEventoCancelamento.class, xmlNFEnviaEventoCancelamento);
        Assert.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoCancelamento() throws Exception {
        final File file = new File(new URI(DFPersisterTest.class.getResource("enviaEventoCancelamento.xml").getFile()).getPath());
        final NFEnviaEventoCancelamento object = this.persister.read(NFEnviaEventoCancelamento.class, file);
        Assert.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoInutilizacao() throws Exception {
        final String xmlNFEnviaEventoInutilizacao = FabricaDeObjetosFake.getNFEnviaEventoInutilizacao().toString();
        final NFEnviaEventoInutilizacao object = this.persister.read(NFEnviaEventoInutilizacao.class, xmlNFEnviaEventoInutilizacao);
        Assert.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoInutilizacao() throws Exception {
        final File file = new File(new URI(DFPersisterTest.class.getResource("enviaEventoInutilizacao.xml").getFile()).getPath());
        final NFEnviaEventoInutilizacao object = this.persister.read(NFEnviaEventoInutilizacao.class, file);
        Assert.assertNotNull(object);
    }
}
