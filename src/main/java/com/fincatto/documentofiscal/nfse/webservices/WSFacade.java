package com.fincatto.documentofiscal.nfse.webservices;

import com.fincatto.documentofiscal.nfse.NFSeConfig;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalGetResponse;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalPostResponseSucesso;
import com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta.*;
import com.fincatto.documentofiscal.utils.DFSocketFactory;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.time.LocalDate;

public class WSFacade {

    private final WSParametrosMunicipais wsParametrosMunicipais;
    private final WSDANFSe wsDANFSe;
    private final WSSefinNFSe wsSefinNFSe;

    public WSFacade(final NFSeConfig config) throws IOException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
        Protocol.registerProtocol("https", new Protocol("https", new DFSocketFactory(config), 443));

        // inicia os servicos disponiveis da nfe
        this.wsParametrosMunicipais = new WSParametrosMunicipais(config);
        this.wsDANFSe = new WSDANFSe(config);
        this.wsSefinNFSe = new WSSefinNFSe(config);
    }

    /**
     * Consulta o status do convênio de um município na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) para o qual o convênio será consultado.
     * @return Objeto {@link NFSeParametrosMunicipaisConvenioResponse} contendo as informações sobre o status do convenio do município
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisConvenioResponse consultaConvenioMunicipio(final String codigoMunicipio) throws Exception {
        return wsParametrosMunicipais.consultaConvenioMunicipio(codigoMunicipio);
    }

    /**
     * Consulta a alíquota de um serviço específico em um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o serviço é prestado.
     * @param codigoServico   Código do serviço para o qual a alíquota será consultada.
     * @param competencia     Data de competência.
     * @return Objeto {@link NFSeParametrosMunicipaisAliquotasResponse} contendo as informações sobre a alíquota do serviço no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisAliquotasResponse consultaAliquotaMunicipioServicoCompetencia(final String codigoMunicipio, final String codigoServico, final LocalDate competencia) throws Exception {
        return wsParametrosMunicipais.consultaAliquotaMunicipioServicoCompetencia(codigoMunicipio, codigoServico, competencia);
    }

    /**
     * Consulta o histórico de alíquotas de um serviço específico em um município na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o serviço é prestado.
     * @param codigoServico   Código do serviço para o qual o histórico de alíquotas será consultado.
     * @return Objeto {@link NFSeParametrosMunicipaisAliquotasResponse} contendo as informações sobre o histórico de alíquotas do serviço no município.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisAliquotasResponse consultaHistoricoAliquotaMunicipioServico(final String codigoMunicipio, final String codigoServico) throws Exception {
        return wsParametrosMunicipais.consultaHistoricoAliquotaMunicipioServico(codigoMunicipio, codigoServico);
    }

    /**
     * Consulta os benefícios fiscais de um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o benefício é aplicado.
     * @param numeroBeneficio Número do benefício fiscal a ser consultado.
     * @param competencia     Data de competência.
     * @return Objeto {@link NFSeParametrosMunicipaisBeneficioResponse} contendo as informações sobre o benefício fiscal no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisBeneficioResponse consultaBeneficioMunicipioBeneficioCompetencia(final String codigoMunicipio, final String numeroBeneficio, final LocalDate competencia) throws Exception {
        return wsParametrosMunicipais.consultaBeneficioMunicipioBeneficioCompetencia(codigoMunicipio, numeroBeneficio, competencia);
    }

    /**
     * Consulta os regimes especiais de um serviço específico em um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o serviço é prestado.
     * @param codigoServico   Código do serviço para o qual os regimes especiais serão consultados.
     * @param competencia     Data de competência.
     * @return Objeto {@link NFSeParametrosMunicipaisRegimesEspeciaisResponse} contendo as informações sobre os regimes especiais do serviço no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisRegimesEspeciaisResponse consultaRegimesEspeciaisMunicipioServicoCompetencia(final String codigoMunicipio, final String codigoServico, final LocalDate competencia) throws Exception {
        return wsParametrosMunicipais.consultaRegimesEspeciaisMunicipioServicoCompetencia(codigoMunicipio, codigoServico, competencia);
    }

    /**
     * Consulta as retenções de um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde as retenções são aplicadas.
     * @param competencia     Data de competência.
     * @return Objeto {@link NFSeParametrosMunicipaisRetencoesResponse} contendo as informações sobre as retenções no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisRetencoesResponse consultaRetencoesMunicipioCompetencia(final String codigoMunicipio, final LocalDate competencia) throws Exception {
        return wsParametrosMunicipais.consultaRetencoesMunicipioCompetencia(codigoMunicipio, competencia);
    }

    /**
     * Faz o download do DANFSe em PDF utilizando a chave de acesso da NFSe.
     *
     * @param nfseChaveAcesso Chave de acesso da NFSe com 50 dígitos.
     * @return Array de bytes representando o arquivo PDF do DANFSe.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public byte[] downloadDANFSePdfByChaveAcesso(final String nfseChaveAcesso) throws Exception {
        return wsDANFSe.downloadDANFSePdfByChaveAcesso(nfseChaveAcesso);
    }

    public NFSeSefinNacionalGetResponse getNFSeByChaveAcesso(final String nfseChaveAcesso) throws Exception {
        return wsSefinNFSe.getNFSeByChaveAcesso(nfseChaveAcesso);
    }

    public NFSeSefinNacionalPostResponseSucesso emitirNFSeByDPS(final String dps) throws Exception {
        return wsSefinNFSe.emitirNFSeByDPS(dps);
    }
}