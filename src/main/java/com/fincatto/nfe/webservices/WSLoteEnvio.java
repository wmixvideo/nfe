package com.fincatto.nfe.webservices;

import java.util.Iterator;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;

import com.fincatto.nfe.NFEConfig;
import com.fincatto.nfe.assinatura.AssinaturaDigital;
import com.fincatto.nfe.classes.NFAutorizador31;
import com.fincatto.nfe.classes.NFUnidadeFederativa;
import com.fincatto.nfe.classes.lote.envio.NFLoteEnvio;
import com.fincatto.nfe.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.nfe.transformers.NFRegistryMatcher;
import com.fincatto.nfe.webservices.gerado.NfeAutorizacaoStub;
import com.fincatto.nfe.webservices.gerado.NfeAutorizacaoStub.NfeAutorizacaoLoteResult;
import com.fincatto.nfe.webservices.gerado.NfeAutorizacaoStub.NfeCabecMsg;
import com.fincatto.nfe.webservices.gerado.NfeAutorizacaoStub.NfeCabecMsgE;
import com.fincatto.nfe.webservices.gerado.NfeAutorizacaoStub.NfeDadosMsg;

class WSLoteEnvio {

    private static final String NFE_ELEMENTO = "NFe";
    private final Logger log = Logger.getLogger(WSLoteEnvio.class);
    private final NFEConfig config;

    public WSLoteEnvio(final NFEConfig config) {
        this.config = config;
    }

    public NFLoteEnvioRetorno enviaLote(final NFLoteEnvio lote, final NFUnidadeFederativa uf) throws Exception {
        final String xml = new AssinaturaDigital(this.config).assinarDocumento(lote.toString());
        final OMElement omElement = this.nfeToOMElement(xml);

        final NfeDadosMsg dados = new NfeDadosMsg();
        dados.setExtraElement(omElement);

        final NfeCabecMsgE cabecalhoSOAP = this.getCabecalhoSOAP();

        this.log.info(omElement);
        final NfeAutorizacaoLoteResult autorizacaoLoteResult = new NfeAutorizacaoStub(NFAutorizador31.valueOfCodigoUF(uf).getNfeAutorizacao(this.config.getAmbiente())).nfeAutorizacaoLote(dados, cabecalhoSOAP);
        final Persister persister = new Persister(new NFRegistryMatcher());
        System.out.println(autorizacaoLoteResult.getExtraElement());
        final NFLoteEnvioRetorno loteEnvioRetorno = persister.read(NFLoteEnvioRetorno.class, autorizacaoLoteResult.getExtraElement().toString());
        this.log.info(loteEnvioRetorno.toString());
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