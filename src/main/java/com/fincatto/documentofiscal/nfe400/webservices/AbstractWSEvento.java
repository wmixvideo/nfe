package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;

abstract class AbstractWSEvento implements DFLog {
    protected final NFeConfig config;
    protected String chaveAcesso;
    protected int numeroSequencialEvento;
    protected DFUnidadeFederativa ufAutorEvento;

    protected abstract BigDecimal getVersaoLayout();
    protected abstract String getCodigoEvento();
    protected abstract String getDescricaoEvento();

    AbstractWSEvento(NFeConfig config) {
        this.config = config;
    }

    protected abstract String getChaveAcesso();
    /**
     * Realiza a transmissão do evento para o web service da SEFAZ.
     *
     * @param xmlAssinado XML do evento assinado digitalmente.
     * @param chaveAcesso Chave de acesso da NF-e relacionada ao evento.
     * @return OMElement contendo a resposta do web service.
     * @throws Exception Caso ocorra algum erro durante a transmissão.
     */
    protected OMElement transmiteEvento(final String xmlAssinado, final String chaveAcesso) throws Exception {
        final NFeRecepcaoEvento4Stub.NfeDadosMsg dados = new NFeRecepcaoEvento4Stub.NfeDadosMsg();

        final OMElement omElementXML = AXIOMUtil.stringToOM(xmlAssinado);
        this.getLogger().debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);

        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador400 autorizador = NFAutorizador400.SVRS;
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ?
                autorizador.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException(
                    "Nao foi possivel encontrar URL para RecepcaoEvento "
                            + parser.getModelo().name() + ", autorizador "
                            + autorizador.name()
            );
        }

        final NFeRecepcaoEvento4Stub.NfeResultMsg nfeRecepcaoEvento = new NFeRecepcaoEvento4Stub(urlWebService, config)
                .nfeRecepcaoEvento(dados);
        final OMElement omElementResult = nfeRecepcaoEvento.getExtraElement();
        this.getLogger().debug(omElementResult.toString());

        return omElementResult;
    }
}
;