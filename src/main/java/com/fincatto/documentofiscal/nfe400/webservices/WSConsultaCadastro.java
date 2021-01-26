package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.cadastro.NFConsultaCadastro;
import com.fincatto.documentofiscal.nfe400.classes.cadastro.NFInfoConsultaCadastro;
import com.fincatto.documentofiscal.nfe400.classes.cadastro.NFRetornoConsultaCadastro;
import com.fincatto.documentofiscal.nfe400.webservices.consultacadastro.CadConsultaCadastro4Stub;
import com.fincatto.documentofiscal.nfe400.webservices.consultacadastro.CadConsultaCadastro4Stub.NfeDadosMsg;
import com.fincatto.documentofiscal.nfe400.webservices.consultacadastro.MTCadConsultaCadastro4Stub;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

class WSConsultaCadastro implements DFLog {
    
    private static final String NOME_SERVICO = "CONS-CAD";
    private static final String VERSAO_SERVICO = "2.00";
    private final NFeConfig config;
    
    WSConsultaCadastro(final NFeConfig config) {
        this.config = config;
    }
    
    NFRetornoConsultaCadastro consultaCadastro(final String cnpj, final DFUnidadeFederativa uf) throws Exception {
        final NFConsultaCadastro dadosConsulta = this.getDadosConsulta(cnpj, uf);
        final String xmlConsulta = dadosConsulta.toString();
        this.getLogger().debug(xmlConsulta);
        
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(xmlConsulta);
        final OMElement resultado = this.efetuaConsulta(uf, omElementConsulta);
        this.getLogger().debug(resultado.toString());

        return this.config.getPersister().read(NFRetornoConsultaCadastro.class, resultado.toString());
    }
    
    private OMElement efetuaConsulta(final DFUnidadeFederativa uf, final OMElement omElementConsulta) throws Exception {
        final NFAutorizador400 autorizador = NFAutorizador400.valueOfCodigoUF(uf);
        final String urlConsulta = autorizador.getConsultaCadastro(this.config.getAmbiente());
        if (urlConsulta == null) {
            throw new IllegalStateException(String.format("UF %s nao possui autorizador para este servico", uf.getDescricao()));
        }
        if (DFUnidadeFederativa.MT.equals(uf)){
            MTCadConsultaCadastro4Stub.ConsultaCadastro consultaCadastro = new MTCadConsultaCadastro4Stub.ConsultaCadastro();
            MTCadConsultaCadastro4Stub.NfeDadosMsg_type0 dadosMsg = new MTCadConsultaCadastro4Stub.NfeDadosMsg_type0();
            dadosMsg.setExtraElement(omElementConsulta);
            consultaCadastro.setNfeDadosMsg(dadosMsg);
            return new MTCadConsultaCadastro4Stub(urlConsulta).consultaCadastro(consultaCadastro).getConsultaCadastroResult().getExtraElement();
        } else {
            final NfeDadosMsg nfeDadosMsg_type0 = new NfeDadosMsg();
            nfeDadosMsg_type0.setExtraElement(omElementConsulta);
            return new CadConsultaCadastro4Stub(urlConsulta, config).consultaCadastro(nfeDadosMsg_type0).getExtraElement();
        }
    }
    
    private NFConsultaCadastro getDadosConsulta(final String cnpj, final DFUnidadeFederativa uf) {
        final NFConsultaCadastro consulta = new NFConsultaCadastro();
        consulta.setVersao(WSConsultaCadastro.VERSAO_SERVICO);
        consulta.setConsultaCadastro(new NFInfoConsultaCadastro());
        consulta.getConsultaCadastro().setCnpj(cnpj);
        consulta.getConsultaCadastro().setServico(WSConsultaCadastro.NOME_SERVICO);
        consulta.getConsultaCadastro().setUf(uf.getCodigo());
        return consulta;
    }
}
