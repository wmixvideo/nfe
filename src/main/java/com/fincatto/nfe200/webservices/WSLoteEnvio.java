package com.fincatto.nfe200.webservices;

import java.util.Iterator;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;

import com.fincatto.nfe200.NFEConfig;
import com.fincatto.nfe200.assinatura.AssinaturaDigital;
import com.fincatto.nfe200.classes.NFAutorizador;
import com.fincatto.nfe200.classes.lote.envio.NFLoteEnvio;
import com.fincatto.nfe200.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.nfe200.transformers.NFRegistryMatcher;
import com.fincatto.nfe200.webservices.gerado.NfeRecepcao2Stub;
import com.fincatto.nfe200.webservices.gerado.NfeRecepcao2Stub.NfeCabecMsg;
import com.fincatto.nfe200.webservices.gerado.NfeRecepcao2Stub.NfeCabecMsgE;
import com.fincatto.nfe200.webservices.gerado.NfeRecepcao2Stub.NfeDadosMsg;
import com.fincatto.nfe200.webservices.gerado.NfeRecepcao2Stub.NfeRecepcaoLote2Result;

class WSLoteEnvio {

    private static final String NFE_ELEMENTO = "NFe";
    private static final Logger LOG = Logger.getLogger(WSLoteEnvio.class);
    private final NFEConfig config;

    public WSLoteEnvio(final NFEConfig config) {
        this.config = config;
    }

    public NFLoteEnvioRetorno enviaLote(final NFLoteEnvio lote) throws Exception {
        final String xml = new AssinaturaDigital(this.config).assinarDocumento(lote.toString());
        final OMElement omElement = this.nfeToOMElement(xml);

        final NfeDadosMsg dados = new NfeDadosMsg();
        dados.setExtraElement(omElement);

        final NfeCabecMsgE cabecalhoSOAP = this.getCabecalhoSOAP();

        WSLoteEnvio.LOG.info(omElement);
        final NfeRecepcaoLote2Result nfeRecepcaoLote2 = new NfeRecepcao2Stub(NFAutorizador.valueOfCodigoUF(this.config.getCUF()).getNfeRecepcao(this.config.getAmbiente())).nfeRecepcaoLote2(dados, cabecalhoSOAP);
        final Persister persister = new Persister(new NFRegistryMatcher());
        final NFLoteEnvioRetorno loteEnvioRetorno = persister.read(NFLoteEnvioRetorno.class, nfeRecepcaoLote2.getExtraElement().toString());
        WSLoteEnvio.LOG.info(loteEnvioRetorno.toString());
        return loteEnvioRetorno;
    }

    private NfeCabecMsgE getCabecalhoSOAP() {
        final NfeCabecMsg cabecalho = new NfeCabecMsg();
        cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
        cabecalho.setVersaoDados(NFEConfig.VERSAO_NFE);
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
                omElement.addAttribute("xmlns", NFEConfig.NFE_NAMESPACE, null);
            }
        }
        return ome;
    }
}