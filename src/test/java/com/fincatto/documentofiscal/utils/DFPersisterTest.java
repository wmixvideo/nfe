package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento.NFEnviaEventoCancelamento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cartacorrecao.NFEnviaEventoCartaCorrecao;
import com.fincatto.documentofiscal.nfe400.classes.evento.inutilizacao.NFEnviaEventoInutilizacao;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.simpleframework.xml.core.ElementException;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;

public class DFPersisterTest {
    
    private Persister persister;
    
    @BeforeEach
    public void prepara() {
        this.persister = new DFPersister();
    }
    
    @Test
    public void deveLancarExcecaoCasoRecebaUmaStringInvalida() throws Exception {
        Assertions.assertThrows(Exception.class, () -> this.persister.read(NFNota.class, ""));
    }
    
    @Test
    public void deveLancarExcecaoCasoRecebaUmArquivoInvalido() throws Exception {
        Assertions.assertThrows(FileNotFoundException.class, () -> this.persister.read(NFNota.class, new File("")));
    }
    
    @Test
    public void deveInstanciarObjetosDFPersisterCorretamenteUsandoConstrutores()  {
    	
    	 // Persister instanciado com construtor default new DFPersister() - usa strict=true
    	DFPersister dfPersisterDefault = (DFPersister) this.persister;
    	DFPersister dfPersisterModoEstrito = new DFPersister(true);
    	DFPersister dfPersisterModeEstritoDesativado = new DFPersister(false);
    	
    	Assertions.assertTrue(dfPersisterDefault.isStrict());
    	Assertions.assertTrue(dfPersisterModoEstrito.isStrict());
    	Assertions.assertFalse(dfPersisterModeEstritoDesativado.isStrict());
    }
    
    @Test
    public void deveParsearXMLDaNota400ModoEstritoComTagAdicionasDeFuturasNormasTecnicas() throws Exception {
    	
    	String xmlNota = com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake.getNFNota().toString();
    	
    	xmlNota = mesclaSimulaPropriedadeNovaAdicionadaNormaTecnicaNova(xmlNota);
    	
    	final NFNota object = new DFPersister(false).read(NFNota.class, xmlNota);
    	
    	Assertions.assertNotNull(object);
    }
    
    @Test
    public void deveLancarExcecaoXMLDaNota400SemModoEstritoComTagAdicionasDeFuturasNormasTecnicas() throws Exception {
        final String xmlNota = com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake.getNFNota().toString();

        // Persister instanciado com construtor default - strict=true
        Assertions.assertThrows(ElementException.class, () -> this.persister.read(NFNota.class, mesclaSimulaPropriedadeNovaAdicionadaNormaTecnicaNova(xmlNota)));
        
    }
    
    @Test
    public void deveParsearCorretamenteUmXMLDaNota310() throws Exception {
        final String xmlNota = FabricaDeObjetosFake.getNFNota().toString();
        final com.fincatto.documentofiscal.nfe310.classes.nota.NFNota object = this.persister.read(com.fincatto.documentofiscal.nfe310.classes.nota.NFNota.class, xmlNota);
        Assertions.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteArquivoDaNota310() throws Exception {
        final File file = new File(new URI(DFPersisterTest.class.getResource("nota.xml").getFile()).getPath());
        final com.fincatto.documentofiscal.nfe310.classes.nota.NFNota object = this.persister.read(com.fincatto.documentofiscal.nfe310.classes.nota.NFNota.class, file);
        Assertions.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteUmXMLDaNotaProcessada310() throws Exception {
        final String xmlNota = FabricaDeObjetosFake.getNFNotaProcessada().toString();
        final com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaProcessada object = this.persister.read(com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaProcessada.class, xmlNota);
        Assertions.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteArquivoDaNotaProcessada310() throws Exception {
        final File file = new File(new URI(DFPersisterTest.class.getResource("notaprocessada.xml").getFile()).getPath());
        final com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaProcessada object = this.persister.read(com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaProcessada.class, file);
        Assertions.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoCartaCorrecao() throws Exception {
        final String xmlNFEnviaEventoCartaCorrecao = FabricaDeObjetosFake.getNFEnviaEventoCartaCorrecao().toString();
        final NFEnviaEventoCartaCorrecao object = this.persister.read(NFEnviaEventoCartaCorrecao.class, xmlNFEnviaEventoCartaCorrecao);
        Assertions.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoCartaCorrecao() throws Exception {
        final File file = new File(new URI(DFPersisterTest.class.getResource("enviaEventoCartaCorrecao.xml").getFile()).getPath());
        final NFEnviaEventoCartaCorrecao object = this.persister.read(NFEnviaEventoCartaCorrecao.class, file);
        Assertions.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoCancelamento() throws Exception {
        final String xmlNFEnviaEventoCancelamento = FabricaDeObjetosFake.getNFEnviaEventoCancelamento().toString();
        final NFEnviaEventoCancelamento object = this.persister.read(NFEnviaEventoCancelamento.class, xmlNFEnviaEventoCancelamento);
        Assertions.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoCancelamento() throws Exception {
        final File file = new File(new URI(DFPersisterTest.class.getResource("enviaEventoCancelamento.xml").getFile()).getPath());
        final NFEnviaEventoCancelamento object = this.persister.read(NFEnviaEventoCancelamento.class, file);
        Assertions.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoInutilizacao() throws Exception {
        final String xmlNFEnviaEventoInutilizacao = FabricaDeObjetosFake.getNFEnviaEventoInutilizacao().toString();
        final NFEnviaEventoInutilizacao object = this.persister.read(NFEnviaEventoInutilizacao.class, xmlNFEnviaEventoInutilizacao);
        Assertions.assertNotNull(object);
    }
    
    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoInutilizacao() throws Exception {
        final File file = new File(new URI(DFPersisterTest.class.getResource("enviaEventoInutilizacao.xml").getFile()).getPath());
        final NFEnviaEventoInutilizacao object = this.persister.read(NFEnviaEventoInutilizacao.class, file);
        Assertions.assertNotNull(object);
    }

	/**
	 * Metodo auxiliar para simular e mesclar na String a cricao de uma nova
	 * propriedade/tag no XML, evitando criacao de objetos para representar novas tags
	 * 
	 * @param xmlNFNota
	 * @return xmlNFNota + propriedadeAdicionalNT + xmlNFNota
	 */
    private String mesclaSimulaPropriedadeNovaAdicionadaNormaTecnicaNova(String xmlNFNota ) {
    	
    	// Exemplo Grupo ZD. Informações do Responsável Técnico - adicionado na NT 2018.005 - Versão 1.20 – Março de 2019
        // <infRespTec><CNPJ>53113791000122</CNPJ><xContato>Rodrigo de Almeida Sartorio</xContato><email>resp_tecnico_dfe_protheus@totvs.com.br</email><fone>28591383</fone></infRespTec>
    	
    	final String fragmentoXMLSimulaNovaPropriedadeNormaTecnica = "<infProgramador><CPF>12345678901</CPF><email>programador@wmixvideo.com</email></infProgramador>";
    	
    	if(StringUtils.isNotBlank(xmlNFNota))
    		xmlNFNota = xmlNFNota.replaceAll("</infNFe>", fragmentoXMLSimulaNovaPropriedadeNormaTecnica+"</infNFe>");
    	
    	return xmlNFNota;
    
    }
}
