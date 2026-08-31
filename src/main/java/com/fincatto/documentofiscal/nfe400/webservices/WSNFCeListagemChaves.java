package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.nota.listagemchaves.NFCeListagemChaves;
import com.fincatto.documentofiscal.nfe400.classes.nota.listagemchaves.NFCeListagemChavesRetorno;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFCeListagemChavesStub;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFCeListagemChavesStub.NfeDadosMsg;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFCeListagemChavesStub.NfceListagemChavesResult;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class WSNFCeListagemChaves implements DFLog {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private final NFeConfig config;

    WSNFCeListagemChaves(final NFeConfig config) {
        this.config = config;
    }

    NFCeListagemChavesRetorno consultaListagemChaves(final LocalDateTime dataHoraInicial, final LocalDateTime dataHoraFinal) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosListagemChaves(dataHoraInicial, dataHoraFinal).toString());
        this.getLogger().debug(omElementConsulta.toString());

        final OMElement omElementRetorno = this.efetuaConsulta(omElementConsulta);
        this.getLogger().debug(omElementRetorno.toString());

        return this.config.getPersister().read(NFCeListagemChavesRetorno.class, omElementRetorno.toString());
    }

    private OMElement efetuaConsulta(final OMElement omElementConsulta) throws Exception {
        final NfeDadosMsg dados = new NfeDadosMsg();
        dados.setExtraElement(omElementConsulta);

        final String endpoint = NFAutorizador400.SP.getNfceListagemChaves(this.config.getAmbiente());
        final NfceListagemChavesResult resultado = new NFCeListagemChavesStub(endpoint, this.config).nfceListagemChaves(dados);
        return resultado.getExtraElement();
    }

    private NFCeListagemChaves gerarDadosListagemChaves(final LocalDateTime dataHoraInicial, final LocalDateTime dataHoraFinal) {
        final NFCeListagemChaves listagemChaves = new NFCeListagemChaves();
        listagemChaves.setVersao(WSNFCeListagemChaves.VERSAO_LEIAUTE);
        listagemChaves.setAmbiente(this.config.getAmbiente());
        listagemChaves.setDataHoraInicial(dataHoraInicial);
        listagemChaves.setDataHoraFinal(dataHoraFinal);
        return listagemChaves;
    }
}
