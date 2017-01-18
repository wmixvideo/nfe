package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.nfe.DistDFeInt;
import br.inf.portalfiscal.nfe.RetDistDFeInt;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.webservices.gerado.NFeDistribuicaoDFeStub;
import java.io.StringReader;
import java.math.BigDecimal;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import javax.xml.bind.JAXB;

class WSDistribuicaoDocumentoFiscal {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");

    private static final Logger LOGGER = LoggerFactory.getLogger(WSDistribuicaoDocumentoFiscal.class);
    private final NFeConfig config;

    WSDistribuicaoDocumentoFiscal(final NFeConfig config) {
        this.config = config;
    }

    RetDistDFeInt consultaDocumentoFiscal(final String cnpj, final String chave, final String nsu, final NFUnidadeFederativa unidadeFederativa) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(gerarDadosConsulta(cnpj, chave, nsu, unidadeFederativa).marshaller());
        WSDistribuicaoDocumentoFiscal.LOGGER.debug(omElementConsulta.toString());
        final OMElement omElementResult = this.efetuaConsultaDocumentoFiscal(omElementConsulta, unidadeFederativa);
        WSDistribuicaoDocumentoFiscal.LOGGER.debug(omElementResult.toString());
        return JAXB.unmarshal(new StringReader(omElementResult.toString()), RetDistDFeInt.class);
    }

    private DistDFeInt gerarDadosConsulta(final String cnpj, final String chave, final String nsu, final NFUnidadeFederativa unidadeFederativa) {
        final DistDFeInt distDFeInt = new DistDFeInt();
        /**
         * Segundo a NT2014.002_v1.02_WsNFeDistribuicaoDFe a partir de 09/01/2017 este campo será opcional
         */
        distDFeInt.setCUFAutor(unidadeFederativa.getCodigoIbge());
        distDFeInt.setTpAmb(this.config.getAmbiente().getCodigo());
        distDFeInt.setVersao(VERSAO_LEIAUTE.toPlainString());
        distDFeInt.setCNPJ(cnpj);
        if (!nsu.isEmpty()) {
            DistDFeInt.ConsNSU consNSU = new DistDFeInt.ConsNSU();
            consNSU.setNSU(nsu);
            distDFeInt.setConsNSU(consNSU);
        }
        if (!chave.isEmpty()) {
            DistDFeInt.ConsChNFe consChave = new DistDFeInt.ConsChNFe();
            consChave.setChNFe(chave);
            distDFeInt.setConsChNFe(consChave);
        }
        return distDFeInt;
    }

    private OMElement efetuaConsultaDocumentoFiscal(final OMElement omElement, final NFUnidadeFederativa unidadeFederativa) throws RemoteException {
        NFeDistribuicaoDFeStub.NfeDadosMsg_type0 dadosMsg_type0 = new NFeDistribuicaoDFeStub.NfeDadosMsg_type0();
        dadosMsg_type0.setExtraElement(omElement);

        final NFeDistribuicaoDFeStub.NfeDistDFeInteresse dFeInteresse = new NFeDistribuicaoDFeStub.NfeDistDFeInteresse();
        dFeInteresse.setNfeDadosMsg(dadosMsg_type0);

        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = autorizador.getNFeDistribuicaoDFe(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para DistribuicaoDocumentoFiscal NF-e, autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }
        final NFeDistribuicaoDFeStub.NfeDistDFeInteresseResponse result = new NFeDistribuicaoDFeStub(endpoint).nfeDistDFeInteresse(dFeInteresse);
        return result.getNfeDistDFeInteresseResult().getExtraElement();
    }

}
