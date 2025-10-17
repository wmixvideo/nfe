package com.fincatto.documentofiscal.nfse.webservices;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta.*;
import com.fincatto.documentofiscal.utils.DFSocketFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;

public class WSParametrosMunicipais implements DFLog {

    public static final String URL_BASE = "https://adn.nfse.gov.br/parametrizacao";

    private final NFeConfig config;
    private final ObjectMapper objectMapper;
    private final HttpClient client;
    private Duration timeout;

    public WSParametrosMunicipais(final NFeConfig config) {
        this.config = config;
        this.timeout = Duration.ofSeconds(5);
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        this.objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        this.objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        this.objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        this.objectMapper.registerModule(new SimpleModule().addDeserializer(BigDecimal.class, new StdScalarDeserializer<>(BigDecimal.class) {
            @Override
            public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                return new BigDecimal(p.getValueAsString().replace(',', '.'));
            }
        }));

        try {
            this.client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).followRedirects(HttpClient.Redirect.NORMAL).sslContext(DFSocketFactory.getDefaultSSLContext(this.config)).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Consulta o status do convênio de um município na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) para o qual o convênio será consultado.
     * @return Objeto {@link NFSeParametrosMunicipaisConvenioResponse} contendo as informações sobre o status do convenio do município
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisConvenioResponse consultaConvenioMunicipio(final String codigoMunicipio) throws Exception {
        final var url = new URI(String.format("%s/%s/convenio", URL_BASE, codigoMunicipio));
        final var response = sendGetRequest(url);
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisConvenioResponse.class);
    }

    /**
     * Consulta a alíquota de um serviço específico em um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o serviço é prestado.
     * @param codigoServico   Código do serviço para o qual a alíquota será consultada.
     * @param competencia    Data de competência no formato LocalDate (ano, mês, dia).
     * @return Objeto {@link NFSeParametrosMunicipaisAliquotasResponse} contendo as informações sobre a alíquota do serviço no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisAliquotasResponse consultaAliquotaMunicipioServicoCompetencia(final String codigoMunicipio, final String codigoServico, final LocalDate competencia) throws Exception {
        final var competenciaFormatada = formataCompetencia(competencia);
        final var url = new URI(String.format("%s/%s/%s/%s/aliquota", URL_BASE, codigoMunicipio, codigoServico, competenciaFormatada));
        final var response = sendGetRequest(url);
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisAliquotasResponse.class);
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
        final var url = new URI(String.format("%s/%s/%s/historicoaliquotas", URL_BASE, codigoMunicipio, codigoServico));
        final var response = sendGetRequest(url);
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisAliquotasResponse.class);
    }

    /**
     * Consulta os benefícios fiscais de um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o benefício é aplicado.
     * @param numeroBeneficio Número do benefício fiscal a ser consultado.
     * @param competencia    Data de competência no formato LocalDate (ano, mês, dia).
     * @return Objeto {@link NFSeParametrosMunicipaisBeneficioResponse} contendo as informações sobre o benefício fiscal no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisBeneficioResponse consultaBeneficioMunicipioBeneficioCompetencia(final String codigoMunicipio, final String numeroBeneficio, final LocalDate competencia) throws Exception {
        final var competenciaFormatada = formataCompetencia(competencia);
        final var url = new URI(String.format("%s/%s/%s/%s/beneficio", URL_BASE, codigoMunicipio, numeroBeneficio, competenciaFormatada));
        final var response = sendGetRequest(url);
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisBeneficioResponse.class);
    }

    /**
     * Consulta os regimes especiais de um serviço específico em um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o serviço é prestado.
     * @param codigoServico   Código do serviço para o qual os regimes especiais serão consultados.
     * @param competencia    Data de competência no formato LocalDate (ano, mês, dia).
     * @return Objeto {@link NFSeParametrosMunicipaisRegimesEspeciaisResponse} contendo as informações sobre os regimes especiais do serviço no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisRegimesEspeciaisResponse consultaRegimesEspeciaisMunicipioServicoCompetencia(final String codigoMunicipio, final String codigoServico, final LocalDate competencia) throws Exception {
        final var competenciaFormatada = formataCompetencia(competencia);
        final var url = new URI(String.format("%s/%s/%s/%s/regimes_especiais", URL_BASE, codigoMunicipio, codigoServico, competenciaFormatada));
        final var response = sendGetRequest(url);
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisRegimesEspeciaisResponse.class);
    }

    /**
     * Consulta as retenções de um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde as retenções são aplicadas.
     * @param competencia    Data de competência no formato LocalDate (ano, mês, dia).
     * @return Objeto {@link NFSeParametrosMunicipaisRetencoesResponse} contendo as informações sobre as retenções no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisRetencoesResponse consultaRetencoesMunicipioCompetencia(final String codigoMunicipio, final LocalDate competencia) throws Exception {
        final var competenciaFormatada = formataCompetencia(competencia);
        final var url = new URI(String.format("%s/%s/%s/retencoes", URL_BASE, codigoMunicipio, competenciaFormatada));
        final var response = sendGetRequest(url);
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisRetencoesResponse.class);
    }

    /**
     * Método privado que realiza uma requisição GET para a uri especificada.
     * <code>Content-Type application/json; charset=utf-8</code>.
     *
     * @param uri URI para a qual a requisição será feita.
     * @return Objeto {@link HttpResponse} contendo a resposta da requisição.
     * @throws Exception Se ocorrer um erro durante a requisição.
     */
    private HttpResponse<String> sendGetRequest(final URI uri) throws Exception {
        return this.client.send(HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .headers("Content-Type", "application/json; charset=utf-8")
                .timeout(this.getTimeout())
                .build(), HttpResponse.BodyHandlers.ofString());
    }

    private static String formataCompetencia(LocalDate competencia) {
        return String.format("%02d-%02d-%04d", competencia.getMonthValue(), competencia.getDayOfMonth(), competencia.getYear());
    }

    private Duration getTimeout() {
        return timeout;
    }

}
