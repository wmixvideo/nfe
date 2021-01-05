package com.fincatto.documentofiscal.nfe.webservices.distribuicao;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe.classes.distribuicao.*;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang3.StringUtils;

import javax.xml.stream.XMLStreamException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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
    public NFDistribuicaoIntRetorno consultar(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu) throws Exception {
        return consultar(cpfOuCnpj, uf, chaveAcesso, nsu, null);
    }

    /**
     * Metodo para consultar os dados das notas fiscais por chave de acesso ou NSU e retorna o objeto de retorno de distribuicao<br>
     */
    public NFDistribuicaoIntRetorno consultar(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu, final String ultNsu) throws Exception {
        try {
            String xmlEnvio = this.gerarNFDistribuicaoInt(cpfOuCnpj, uf, chaveAcesso, nsu, ultNsu).toString();

            // valida o lote assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
            DFXMLValidador.validaConsultaDfe(xmlEnvio);

            final OMElement ome = AXIOMUtil.stringToOM(xmlEnvio);

            final NFeDistribuicaoDFeSoapStub.NFeDadosMsg_type0 dadosMsgType0 = new NFeDistribuicaoDFeSoapStub.NFeDadosMsg_type0();
            dadosMsgType0.setExtraElement(ome);

            final NFeDistribuicaoDFeSoapStub.NFeDistDFeInteresse distDFeInteresse = new NFeDistribuicaoDFeSoapStub.NFeDistDFeInteresse();
            distDFeInteresse.setNFeDadosMsg(dadosMsgType0);

            final NFeDistribuicaoDFeSoapStub stub = new NFeDistribuicaoDFeSoapStub(NFAutorizador31.AN.getNFeDistribuicaoDFe(this.config.getAmbiente()), config);
            final NFeDistribuicaoDFeSoapStub.NFeDistDFeInteresseResponse result = stub.nfeDistDFeInteresse(distDFeInteresse);
    
            return this.config.getPersister().read(NFDistribuicaoIntRetorno.class, result.getNFeDistDFeInteresseResult().getExtraElement().toString());
        } catch (RemoteException | XMLStreamException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static String decodeGZipToXml(final String conteudoEncode) throws Exception {
        if (conteudoEncode == null || conteudoEncode.length() == 0) {
            return "";
        }
        final byte[] conteudo = Base64.getDecoder().decode(conteudoEncode);//java 8
        //final byte[] conteudo = DatatypeConverter.parseBase64Binary(conteudoEncode);//java 7
        try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(conteudo))) {
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8))) {
                StringBuilder outStr = new StringBuilder();
                String line;
                while ((line = bf.readLine()) != null) {
                    outStr.append(line);
                }
                return outStr.toString();
            }
        }
    }

    private NFDistribuicaoInt gerarNFDistribuicaoInt(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu, final String ultNsu) {
        final NFDistribuicaoInt distDFeInt = new NFDistribuicaoInt();
        distDFeInt.setVersao("1.01");
        distDFeInt.setAmbiente(this.config.getAmbiente());
        distDFeInt.setUnidadeFederativaAutor(uf);

        if (cpfOuCnpj.length() == 11) {
            distDFeInt.setCpf(cpfOuCnpj);
        } else {
            distDFeInt.setCnpj(cpfOuCnpj);
        }

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