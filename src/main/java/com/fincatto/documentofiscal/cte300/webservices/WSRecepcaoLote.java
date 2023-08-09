package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLote;
import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLoteRetorno;
import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLoteRetornoDados;
import com.fincatto.documentofiscal.cte300.webservices.recepcao.CteRecepcaoStub;
import com.fincatto.documentofiscal.cte300.webservices.recepcao.CteRecepcaoStub.CteCabecMsg;
import com.fincatto.documentofiscal.cte300.webservices.recepcao.CteRecepcaoStub.CteCabecMsgE;
import com.fincatto.documentofiscal.cte300.webservices.recepcao.CteRecepcaoStub.CteDadosMsg;
import com.fincatto.documentofiscal.cte300.webservices.recepcao.CteRecepcaoStub.CteRecepcaoLoteResult;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;
import java.util.Iterator;

class WSRecepcaoLote implements DFLog {
    
    private static final String CTE_ELEMENTO = "CTe";
    private final CTeConfig config;
    
    WSRecepcaoLote(final CTeConfig config) {
        this.config = config;
    }
    
    public CTeEnvioLoteRetornoDados envioRecepcao(CTeEnvioLote cteRecepcaoLote) throws Exception {
        //assina o lote
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cteRecepcaoLote.toString(), "infCte");
        final CTeEnvioLote loteAssinado = this.config.getPersister().read(CTeEnvioLote.class, documentoAssinado);
        
        //comunica o lote
        final CTeEnvioLoteRetorno retorno = comunicaLote(documentoAssinado);
        return new CTeEnvioLoteRetornoDados(retorno, loteAssinado);
    }
    
    private CTeEnvioLoteRetorno comunicaLote(final String loteAssinadoXml) throws Exception {
        //valida o lote assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        DFXMLValidador.validaLoteCTe300(loteAssinadoXml);
        
        //envia o lote para a sefaz
        final OMElement omElement = this.cteToOMElement(loteAssinadoXml);
        
        final CteDadosMsg dados = new CteDadosMsg();
        dados.setExtraElement(omElement);
        
        final CteCabecMsgE cabecalhoSOAP = this.getCabecalhoSOAP();
        this.getLogger().debug(omElement.toString());
        
        final CTAutorizador31 autorizador = CTAutorizador31.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        final String endpoint = autorizador.getCteRecepcao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        final CteRecepcaoLoteResult autorizacaoLoteResult = new CteRecepcaoStub(endpoint, config).cteRecepcaoLote(dados, cabecalhoSOAP);
        final CTeEnvioLoteRetorno retorno = this.config.getPersister().read(CTeEnvioLoteRetorno.class, autorizacaoLoteResult.getExtraElement().toString());
        this.getLogger().debug(retorno.toString());
        return retorno;
    }
    
    private CteCabecMsgE getCabecalhoSOAP() {
        final CteCabecMsg cabecalho = new CteCabecMsg();
        cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
        cabecalho.setVersaoDados("3.00");
        final CteCabecMsgE cabecalhoSOAP = new CteCabecMsgE();
        cabecalhoSOAP.setCteCabecMsg(cabecalho);
        return cabecalhoSOAP;
    }
    
    private OMElement cteToOMElement(final String documento) throws XMLStreamException {
        final XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_COALESCING, false);
        XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(documento));
        StAXOMBuilder builder = new StAXOMBuilder(reader);
        final OMElement ome = builder.getDocumentElement();
        final Iterator<?> children = ome.getChildrenWithLocalName(WSRecepcaoLote.CTE_ELEMENTO);
        while (children.hasNext()) {
            final OMElement omElement = (OMElement) children.next();
            if ((omElement != null) && (WSRecepcaoLote.CTE_ELEMENTO.equals(omElement.getLocalName()))) {
                omElement.addAttribute("xmlns", CTeConfig.NAMESPACE, null);
            }
        }
        return ome;
    }
}
