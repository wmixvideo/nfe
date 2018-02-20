package com.fincatto.documentofiscal.nfe.webservices.distribuicao;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.httpclient.protocol.Protocol;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.documentofiscal.nfe.NFSocketFactory;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe.classes.distribuicao.NFDistribuicaoInt;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;

public class WSDistribuicaoDFe {

    /**
     * Metodo para consultar os conhecimentos de transporte e retorna uma String<br>
     * É importante salvar esta String para não perder nenhuma informacao<br>
     * A receita não disponibiliza o conhecimento várias vezes para consultar, retorna rejeicao: Consumo indevido
     */
    public static String consultar(final NFDistribuicaoInt distDFeInt, final NFeConfig config) throws Exception {
        Protocol.registerProtocol("https", new Protocol("https", new NFSocketFactory(config), 443));
        try {
            final OMElement ome = AXIOMUtil.stringToOM(distDFeInt.toString());

            final NFeDistribuicaoDFeSoapStub.NFeDadosMsg_type0 dadosMsgType0 = new NFeDistribuicaoDFeSoapStub.NFeDadosMsg_type0();
            dadosMsgType0.setExtraElement(ome);

            final NFeDistribuicaoDFeSoapStub.NFeDistDFeInteresse distDFeInteresse = new NFeDistribuicaoDFeSoapStub.NFeDistDFeInteresse();
            distDFeInteresse.setNFeDadosMsg(dadosMsgType0);

            final NFeDistribuicaoDFeSoapStub stub = new NFeDistribuicaoDFeSoapStub(NFAutorizador31.AN.getNFeDistribuicaoDFe(config.getAmbiente()));
            final NFeDistribuicaoDFeSoapStub.NFeDistDFeInteresseResponse result = stub.nfeDistDFeInteresse(distDFeInteresse);

            return result.getNFeDistDFeInteresseResult().getExtraElement().toString();
        } catch (RemoteException | XMLStreamException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static String decodeGZipToXml(final String conteudoEncode) throws Exception {
        if (conteudoEncode == null || conteudoEncode.length() == 0) {
            return "";
        }
        final byte[] conteudo = Base64.getDecoder().decode(conteudoEncode);
        try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(conteudo))) {
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(gis, "UTF-8"))) {
                String outStr = "";
                String line;
                while ((line = bf.readLine()) != null) {
                    outStr += line;
                }
                return outStr;
            }
        }
    }

    public static <T> T xmlToObject(final String xml, final Class<T> classe) throws Exception {
        return new Persister(new DFRegistryMatcher(), new Format(0)).read(classe, xml);
    }

}