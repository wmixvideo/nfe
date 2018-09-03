package com.fincatto.documentofiscal.nfe.webservices.distribuicao;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe.classes.distribuicao.*;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;
import com.fincatto.documentofiscal.validadores.xsd.XMLValidador;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.core.Persister;

import javax.xml.bind.DatatypeConverter;
import javax.xml.stream.XMLStreamException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

public class WSDistribuicaoNFe {

    private final NFeConfig config;

    public WSDistribuicaoNFe(final NFeConfig config) {
        this.config = config;
    }

    /**
     * Metodo para consultar os dados das notas fiscais por chave de acesso ou NSU e retorna o objeto de retorno de distribuicao<br>
     */
    public NFDistribuicaoIntRetorno consultar(final String cnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu) throws Exception {
        return consultar(cnpj, uf, chaveAcesso, nsu, null);
    }

    /**
     * Metodo para consultar os dados das notas fiscais por chave de acesso ou NSU e retorna o objeto de retorno de distribuicao<br>
     */
    public NFDistribuicaoIntRetorno consultar(final String cnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu, final String ultNsu) throws Exception {
        try {
            String xmlEnvio = this.gerarNFDistribuicaoInt(cnpj, uf, chaveAcesso, nsu, ultNsu).toString();

            // valida o lote assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
            XMLValidador.validaConsultaDfe(xmlEnvio);

            final OMElement ome = AXIOMUtil.stringToOM(xmlEnvio);

            final NFeDistribuicaoDFeSoapStub.NFeDadosMsg_type0 dadosMsgType0 = new NFeDistribuicaoDFeSoapStub.NFeDadosMsg_type0();
            dadosMsgType0.setExtraElement(ome);

            final NFeDistribuicaoDFeSoapStub.NFeDistDFeInteresse distDFeInteresse = new NFeDistribuicaoDFeSoapStub.NFeDistDFeInteresse();
            distDFeInteresse.setNFeDadosMsg(dadosMsgType0);

            final NFeDistribuicaoDFeSoapStub stub = new NFeDistribuicaoDFeSoapStub(NFAutorizador31.AN.getNFeDistribuicaoDFe(this.config.getAmbiente()));
            final NFeDistribuicaoDFeSoapStub.NFeDistDFeInteresseResponse result = stub.nfeDistDFeInteresse(distDFeInteresse);
            final String resultadoConsulta = result.getNFeDistDFeInteresseResult().getExtraElement().toString();

            return new Persister(new DFRegistryMatcher()).read(NFDistribuicaoIntRetorno.class, resultadoConsulta);
        } catch (RemoteException | XMLStreamException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static String decodeGZipToXml(final String conteudoEncode) throws Exception {
        if (conteudoEncode == null || conteudoEncode.length() == 0) {
            return "";
        }
        //final byte[] conteudo = Base64.getDecoder().decode(conteudoEncode);//java 8
        final byte[] conteudo = DatatypeConverter.parseBase64Binary(conteudoEncode);//java 7
        try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(conteudo))) {
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(gis, "UTF-8"))) {
                StringBuilder outStr = new StringBuilder();
                String line;
                while ((line = bf.readLine()) != null) {
                    outStr.append(line);
                }
                return outStr.toString();
            }
        }
    }

    private NFDistribuicaoInt gerarNFDistribuicaoInt(final String cnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu, final String ultNsu) {
        final NFDistribuicaoInt distDFeInt = new NFDistribuicaoInt();
        distDFeInt.setVersao("1.01");
        distDFeInt.setAmbiente(this.config.getAmbiente());
        distDFeInt.setCnpj(cnpj);
        distDFeInt.setUnidadeFederativaAutor(uf);

        if (StringUtils.isNotBlank(chaveAcesso)) {
            distDFeInt.setConsultaChaveAcesso(new NFDistribuicaoConsultaChaveAcesso().setChaveAcesso(chaveAcesso));
        } else if (StringUtils.isNotBlank(ultNsu)) {
            distDFeInt.setDistribuicaoNSU(new NFDistribuicaoNSU().setUltimoNSU(ultNsu));
        } else {
            distDFeInt.setConsultaNSU(new NFDistribuicaoConsultaNSU().setNsu(nsu));
        }
        return distDFeInt;
    }
}