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
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.core.Persister;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe.classes.distribuicao.NFDistribuicaoConsultaChaveAcesso;
import com.fincatto.documentofiscal.nfe.classes.distribuicao.NFDistribuicaoConsultaNSU;
import com.fincatto.documentofiscal.nfe.classes.distribuicao.NFDistribuicaoInt;
import com.fincatto.documentofiscal.nfe.classes.distribuicao.NFDistribuicaoIntRetorno;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;

public class WSDistribuicaoDFe {

    private final NFeConfig config;

    public WSDistribuicaoDFe(final NFeConfig config) {
        this.config = config;
    }

    /**
     * Metodo para consultar os dados das notas fiscais por chave de acesso ou NSU e retorna o objeto de retorno de distribuicao<br>
     */
    public NFDistribuicaoIntRetorno consultar(final String cnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu) throws Exception {
        try {
            final OMElement ome = AXIOMUtil.stringToOM(this.gerarNFDistribuicaoInt(cnpj, uf, chaveAcesso, nsu).toString());

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

    private NFDistribuicaoInt gerarNFDistribuicaoInt(final String cnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu) {
        final NFDistribuicaoInt distDFeInt = new NFDistribuicaoInt();
        distDFeInt.setVersao("1.01");
        distDFeInt.setAmbiente(this.config.getAmbiente());
        distDFeInt.setCnpj(cnpj);
        distDFeInt.setUnidadeFederativaAutor(uf);

        if (StringUtils.isNotBlank(chaveAcesso)) {
            distDFeInt.setConsultaChaveAcesso(new NFDistribuicaoConsultaChaveAcesso().setChaveAcesso(chaveAcesso));
        } else {
            distDFeInt.setConsultaNSU(new NFDistribuicaoConsultaNSU().setNsu(nsu));
        }
        return distDFeInt;
    }

}