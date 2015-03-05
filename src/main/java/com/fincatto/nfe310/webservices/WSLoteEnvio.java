package com.fincatto.nfe310.webservices;

import java.util.Iterator;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvio;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import com.fincatto.nfe310.webservices.gerado.NfeAutorizacaoStub;
import com.fincatto.nfe310.webservices.gerado.NfeAutorizacaoStub.NfeAutorizacaoLoteResult;
import com.fincatto.nfe310.webservices.gerado.NfeAutorizacaoStub.NfeCabecMsg;
import com.fincatto.nfe310.webservices.gerado.NfeAutorizacaoStub.NfeCabecMsgE;
import com.fincatto.nfe310.webservices.gerado.NfeAutorizacaoStub.NfeDadosMsg;

class WSLoteEnvio {

    private static final String NFE_ELEMENTO = "NFe";
    private static final Logger LOG = Logger.getLogger(WSLoteEnvio.class);
    private final NFeConfig config;

    public WSLoteEnvio(final NFeConfig config) {
        this.config = config;
    }

    public NFLoteEnvioRetorno enviaLote(final NFLoteEnvio lote) throws Exception {
        final String xml = new AssinaturaDigital(this.config).assinarDocumento(lote.toString());
        final OMElement omElement = this.nfeToOMElement(xml);

        final NfeDadosMsg dados = new NfeDadosMsg();
        dados.setExtraElement(omElement);

        final NfeCabecMsgE cabecalhoSOAP = this.getCabecalhoSOAP();

        WSLoteEnvio.LOG.info(omElement);
        final NfeAutorizacaoLoteResult autorizacaoLoteResult = new NfeAutorizacaoStub(NFAutorizador31.valueOfCodigoUF(this.config.getCUF()).getNfeAutorizacao(this.config.getAmbiente())).nfeAutorizacaoLote(dados, cabecalhoSOAP);
        final Persister persister = new Persister(new NFRegistryMatcher());
        final NFLoteEnvioRetorno loteEnvioRetorno = persister.read(NFLoteEnvioRetorno.class, autorizacaoLoteResult.getExtraElement().toString());
        WSLoteEnvio.LOG.info(loteEnvioRetorno.toString());
        return loteEnvioRetorno;
    }

    private NfeCabecMsgE getCabecalhoSOAP() {
        final NfeCabecMsg cabecalho = new NfeCabecMsg();
        cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
        cabecalho.setVersaoDados(NFeConfig.VERSAO_NFE);
        final NfeCabecMsgE cabecalhoSOAP = new NfeCabecMsgE();
        cabecalhoSOAP.setNfeCabecMsg(cabecalho);
        return cabecalhoSOAP;
    }

    private OMElement nfeToOMElement(final String documento) throws XMLStreamException {
        final OMElement ome = AXIOMUtil.stringToOM(documento);
        final Iterator<?> children = ome.getChildrenWithLocalName(WSLoteEnvio.NFE_ELEMENTO);
        while (children.hasNext()) {
            final OMElement omElement = (OMElement) children.next();
            if ((omElement != null) && (WSLoteEnvio.NFE_ELEMENTO.equals(omElement.getLocalName()))) {
                omElement.addAttribute("xmlns", NFeConfig.NFE_NAMESPACE, null);
            }
        }
        return ome;
    }
}