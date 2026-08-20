package com.fincatto.documentofiscal.nfe400.webservices.gerado;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;

/**
 * Remanescente do stub Axis2 gerado a partir do WSDL {@code NFeRecepcaoEvento4} (migracao
 * Axis2 -&gt; HttpClient5). O stub original ({@code extends org.apache.axis2.client.Stub}, com
 * toda a maquinaria de {@code AxisOperation}/fault mapping/chamada de rede via Axis2) foi
 * removido - a comunicacao com a SEFAZ agora e feita por {@link com.fincatto.documentofiscal.utils.DFHttpClient}.
 * <p>
 * Esta classe sobrevive apenas para nao quebrar a assinatura publica de
 * {@link com.fincatto.documentofiscal.nfe400.webservices.WSEpec#comunicaLoteRaw}, que expunha
 * {@link NfeResultMsg} como tipo de retorno.
 */
public final class NFeRecepcaoEvento4Stub {

    private NFeRecepcaoEvento4Stub() {
    }

    /**
     * Portador do XML de negocio (evento) devolvido pela SEFAZ, exposto como
     * {@link OMElement} por compatibilidade com o tipo original gerado pelo Axis2.
     */
    public static class NfeResultMsg {
        public static final QName MY_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "nfeResultMsg", "ns1");

        private OMElement localExtraElement;

        public OMElement getExtraElement() {
            return this.localExtraElement;
        }

        public void setExtraElement(final OMElement param) {
            this.localExtraElement = param;
        }
    }
}
