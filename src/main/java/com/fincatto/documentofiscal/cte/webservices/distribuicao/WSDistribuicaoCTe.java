package com.fincatto.documentofiscal.cte.webservices.distribuicao;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte.classes.distribuicao.CTDistribuicaoConsultaNSU;
import com.fincatto.documentofiscal.cte.classes.distribuicao.CTDistribuicaoInt;
import com.fincatto.documentofiscal.cte.classes.distribuicao.CTDistribuicaoIntRetorno;
import com.fincatto.documentofiscal.cte.classes.distribuicao.CTDistribuicaoNSU;
import com.fincatto.documentofiscal.cte200.classes.CTAutorizador;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

/**
 * Cliente do webservice de Distribuicao de DF-e do CT-e (consulta de documentos por NSU/interesse).
 * Servico compartilhado por CT-e 3.00 e 4.00 (usado tanto pelo {@code WSFacade} do {@code cte300}
 * quanto do {@code cte400}), por isso vive no pacote legado {@code com.fincatto.documentofiscal.cte}
 * em vez de dentro de um dos dois modulos versionados.
 */
public class WSDistribuicaoCTe {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe";
    private static final String SOAP_ACTION = WSDistribuicaoCTe.NAMESPACE_WSDL + "/cteDistDFeInteresse";
    private static final int NIVEIS_DE_WRAPPER_NA_RESPOSTA = 2;

    private final CTeConfig config;
    private final DFHttpClient httpClient;

    public WSDistribuicaoCTe(final CTeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }


    /**
     * Faz consulta de distribuicao dos CTe e devolve o XML de resposta bruto (sem
     * desserializar), tal como recebido/desempacotado do envelope SOAP retornado pela SEFAZ.
     * Pode ser feita utilizando o CTe (numero sequencial unico) da receita.
     *
     * @param cpfOuCnpj CPF ou CNPJ da pessoa fisica ou juridica a consultar
     * @param uf        Unidade federativa da pessoa juridica a consultar
     * @param nsu       Número Sequencial Único. Geralmente esta consulta será
     *                  utilizada quando identificado pelo interessado um NSU faltante. O Web
     *                  Service retornará o documento ou informará que o NSU não existe no
     *                  Ambiente Nacional. Assim, esta consulta fechará a lacuna do NSU
     *                  identificado como faltante.
     * @param ultNsu    Último NSU recebido pelo ator. Caso seja informado com
     *                  zero, ou com um NSU muito antigo, a consulta retornará unicamente as
     *                  informações resumidas e documentos fiscais eletrônicos que tenham sido
     *                  recepcionados pelo Ambiente Nacional nos últimos 3 meses.
     * @return String do XML de retorno da consulta, sem conversão para {@link CTDistribuicaoIntRetorno}
     * @throws Exception caso nao consiga gerar/validar o xml de envio ou haja
     *                    problema de conexao com o sefaz
     */
    public String consultarRaw(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String nsu, final String ultNsu) throws Exception {
        final String xmlEnvio = this.gerarCTeDistribuicaoInt(cpfOuCnpj, uf, nsu, ultNsu).toString();
        DFXMLValidador.validaDistribuicaoCTe(xmlEnvio);
        return this.efetuaConsulta(xmlEnvio);
    }

    /**
     * Faz consulta de distribuicao dos CTe e desserializa o retorno em {@link CTDistribuicaoIntRetorno}.
     * Pode ser feita utilizando o CTe (numero sequencial unico) da receita.
     *
     * @param cpfOuCnpj CPF ou CNPJ da pessoa fisica ou juridica a consultar
     * @param uf        Unidade federativa da pessoa juridica a consultar
     * @param nsu       Número Sequencial Único. Geralmente esta consulta será
     *                  utilizada quando identificado pelo interessado um NSU faltante. O Web
     *                  Service retornará o documento ou informará que o NSU não existe no
     *                  Ambiente Nacional. Assim, esta consulta fechará a lacuna do NSU
     *                  identificado como faltante.
     * @param ultNsu    Último NSU recebido pelo ator. Caso seja informado com
     *                  zero, ou com um NSU muito antigo, a consulta retornará unicamente as
     *                  informações resumidas e documentos fiscais eletrônicos que tenham sido
     *                  recepcionados pelo Ambiente Nacional nos últimos 3 meses.
     * @return {@link CTDistribuicaoIntRetorno} com o resultado da consulta de distribuicao
     * @throws Exception caso nao consiga gerar o xml ou problema de conexao com
     *                   o sefaz
     */
    public CTDistribuicaoIntRetorno consultar(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String nsu, final String ultNsu) throws Exception {
        return this.config.getPersister().read(CTDistribuicaoIntRetorno.class, this.consultarRaw(cpfOuCnpj, uf, nsu, ultNsu));
    }

    /**
     * Envia a consulta de distribuicao para a SEFAZ via {@link DFHttpClient} e devolve o XML de
     * negocio ja desempacotado do envelope SOAP 1.2 de resposta - mesmo padrao aninhado de
     * {@code WSDistribuicaoNFe#efetuaConsulta}: o wrapper e {@code cteDistDFeInteresse} (nao
     * {@code cteDadosMsg} direto), com {@code cteDadosMsg} dentro dele.
     */
    private String efetuaConsulta(final String xmlEnvio) throws IOException, DFSoapFaultException {
        final String endpoint = CTAutorizador.AN.getDistribuicaoDFe(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para DistribuicaoDFe, autorizador " + CTAutorizador.AN.name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSDistribuicaoCTe.NAMESPACE_WSDL, "cteDistDFeInteresse", "<cteDadosMsg>" + xmlEnvio + "</cteDadosMsg>");
        final String resposta = this.httpClient.postSoap(endpoint, WSDistribuicaoCTe.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta, WSDistribuicaoCTe.NIVEIS_DE_WRAPPER_NA_RESPOSTA);
    }

    private CTDistribuicaoInt gerarCTeDistribuicaoInt(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String nsu, final String ultNsu) {
        final CTDistribuicaoInt distDFeInt = new CTDistribuicaoInt();
        distDFeInt.setVersao("1.00");
        distDFeInt.setAmbiente(this.config.getAmbiente());
        distDFeInt.setUnidadeFederativaAutor(uf);

        if (cpfOuCnpj.length() == 11) {
            distDFeInt.setCpf(cpfOuCnpj);
        } else {
            distDFeInt.setCnpj(cpfOuCnpj);
        }

        if (StringUtils.isNotBlank(ultNsu)) {
            distDFeInt.setDistribuicao(new CTDistribuicaoNSU().setUltimoNSU(ultNsu));
        } else {
            distDFeInt.setConsulta(new CTDistribuicaoConsultaNSU().setNsu(nsu));
        }
        return distDFeInt;
    }

    public static String decodeGZipToXml(final String conteudoEncode) throws Exception {
        if (conteudoEncode == null || conteudoEncode.length() == 0) {
            return "";
        }
        final byte[] conteudo = Base64.getDecoder().decode(conteudoEncode);
        // le os bytes crus (sem readLine), preservando quebras de linha dentro de campos texto do XML
        try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(conteudo))) {
            return new String(gis.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
