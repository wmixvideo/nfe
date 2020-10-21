package com.fincatto.documentofiscal;

import com.fincatto.documentofiscal.utils.DFPersister;
import com.fincatto.documentofiscal.utils.DFSocketFactory;

import org.simpleframework.xml.core.Persister;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.TimeZone;

/**
 * @author Caio Configuracao basica do sistema de documentos fiscais.
 */
public abstract class DFConfig {
    
    public static final TimeZone TIMEZONE_SP = TimeZone.getTimeZone("America/Sao_Paulo");
    private Persister persister;
    
    /**
     * Indica o ambiente de trabalho, se em producao ou homologacao.
     *
     * @return Ambiente de trabalho.
     */
    public DFAmbiente getAmbiente() {
        return DFAmbiente.HOMOLOGACAO;
    }
    
    /**
     * Indica o modelo do documento fiscal
     *
     * @return Modelo documento fiscal.
     */
    public DFModelo getModelo() {
        return DFModelo.NFE;
    }
    
    /**
     * Unidade da federacao do emissor das notas.
     *
     * @return Unidade da federacao do emissor.
     */
    public abstract DFUnidadeFederativa getCUF();
    
    /**
     * KeyStore contendo o certificado pessoal do emissor. <br>
     * Esse certificado e fornecido por uma autoridade certificadora. <br>
     * Em caso de duvidas, consulte seu contador.
     *
     * @return KeyStore do certificado pessoal.
     * @throws KeyStoreException Caso nao consiga carregar o KeyStore.
     */
    public abstract KeyStore getCertificadoKeyStore() throws KeyStoreException;
    
    /**
     * Retorna o nome do alias do certificado dentro do {@link KeyStore} retornado por {@link #getCertificadoKeyStore()}. Caso seja retornado {@code null}, sera utilizado o primeiro alias do {@link KeyStore}.
     *
     * @return o nome do alias do certificado ou {@code null}
     */
    public String getCertificadoAlias() {
        return null;
    }
    
    /**
     * Senha do certificado pessoal do emissor, contido dentro do KeyStore do certificado.
     *
     * @return Senha do certificado.
     * @see #getCertificadoKeyStore()
     */
    public abstract String getCertificadoSenha();
    
    /**
     * KeyStore contendo a cadeia de certificados da SEFAZ de destino. <br>
     * Para gerar a cadeia, use o utilitario fornecido com a biblioteca:<br>
     * FileUtils.writeByteArrayToFile(new File("/tmp/producao.cacerts"), NFGeraCadeiaCertificados.geraCadeiaCertificados(NFAmbiente.PRODUCAO, "senha"));
     *
     * @return KeyStore da cadeia de certificados.
     * @throws KeyStoreException Caso nao consiga carregar o KeyStore.
     */
    public abstract KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException;
    
    /**
     * Senha da cadeia de certificados, contida dentro do KeyStore da cadeia.
     *
     * @return Senha da cadeia de certificados.
     * @see #getCadeiaCertificadosKeyStore()
     */
    public abstract String getCadeiaCertificadosSenha();
    
    /**
     * Protocolo de SSL, usado pela SEFAZ para receber as notas.
     * Habilita mais de um parametro pra ssl.
     *
     * @return Protocolo SSL da SEFAZ de origem.
     */
    public String[] getSSLProtocolos() {
        return new String[]{"TLSv1.2"};
    }

    /**
     * Timeout a ser utilizado em cada requisição feita ao SEFAZ de origem.
     * Deve ser maior que zero, se não, será utilizado {@link DFSocketFactory#TIMEOUT_PADRAO_EM_MILLIS}
     *
     * @return timeout da requisição em millisegundos
     */
    public int getTimeoutRequisicaoEmMillis() {
        return DFSocketFactory.TIMEOUT_PADRAO_EM_MILLIS;
    }
    
    /**
     * Retorna o timezone a ser usado no sistema.
     * Por padrao, vai usar o timezone default da maquina.
     *
     * @return TimeZone a ser utilizado.
     */
    public TimeZone getTimeZone() {
        return TimeZone.getDefault();
    }
    
    /**
     * Retorna o persister a ser usado para serializacao dos objetos.
     * Por padrao vai usar o {@link DFPersister} com o {@link TimeZone} definido em {@link #getTimeZone()}.
     *
     * @return Persister a ser utilizado.
     */
    public Persister getPersister() {
        if (this.persister == null) {
            this.persister = new DFPersister();
        }
        return this.persister;
    }
    
    /**
     * Codigo de Seguranca do Responsavel Tecnico - CSRT(NT 2018.005)
     *
     * @return Codigo de seguranca do responsavel tecnico.
     * @see <a href="http://www.nfe.fazenda.gov.br/portal/informe.aspx?ehCTG=false&Informe=hDS5co/qWOc=">Informativo(acessado em 10/04/19 as 11:30)</a>
     * @see <a href="http://www.nfe.fazenda.gov.br/portal/exibirArquivo.aspx?conteudo=j/im9zMlcIE=">Baixar PDF(acessado em 10/04/19 as 11:30)</a>
     */
    public String getCSRT() {
        return "";
    }
}
