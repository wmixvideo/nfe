package com.fincatto.nfe310.webservices;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.w3c.dom.Element;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.evento.downloadnf.NFDownloadNFe;
import com.fincatto.nfe310.classes.evento.downloadnf.NFDownloadNFeRetorno;
import com.fincatto.nfe310.converters.ElementStringConverter;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;

import br.inf.portalfiscal.nfe.wsdl.nfedownloadnf.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.nfedownloadnf.NfeDadosMsg;
import br.inf.portalfiscal.nfe.wsdl.nfedownloadnf.NfeDownloadNF;
import br.inf.portalfiscal.nfe.wsdl.nfedownloadnf.NfeDownloadNFResult;
import br.inf.portalfiscal.nfe.wsdl.nfedownloadnf.NfeDownloadNFSoap;

class WSNotaDownload {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String NOME_SERVICO = "DOWNLOAD NFE";
    private final NFeConfig config;

    WSNotaDownload(final NFeConfig config) {
        this.config = config;
    }

    NFDownloadNFeRetorno downloadNota(final String cnpj, final String chave) throws Exception {
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFDownloadNFeRetorno.class, efetuaDownloadNF(gerarDadosDownloadNF(cnpj, chave).toString()));
    }

    private NFDownloadNFe gerarDadosDownloadNF(final String cnpj, final String chave) throws Exception {
        final NFDownloadNFe nfDownloadNFe = new NFDownloadNFe();
        nfDownloadNFe.setVersao(WSNotaDownload.VERSAO_LEIAUTE.toPlainString());
        nfDownloadNFe.setAmbiente(this.config.getAmbiente());
        nfDownloadNFe.setServico(WSNotaDownload.NOME_SERVICO);
        nfDownloadNFe.setCnpj(cnpj);
        nfDownloadNFe.setChave(chave);
        return nfDownloadNFe;
    }

    private String efetuaDownloadNF(final String xml) throws RemoteException, MalformedURLException {
        final NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();
        nfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        nfeCabecMsg.setVersaoDados(WSNotaDownload.VERSAO_LEIAUTE.toPlainString());

        final NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.getContent().add(ElementStringConverter.read(xml));

        NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getNfeDownloadNF(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para DownloadNF, autorizador " + autorizador.name());
        }

        NfeDownloadNFSoap port = new NfeDownloadNF(new URL(endpoint)).getNfeDownloadNFSoap12();
        NfeDownloadNFResult result = port.nfeDownloadNF(nfeDadosMsg, nfeCabecMsg);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

}
