package com.fincatto.nfe310.webservices;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.evento.epec.NFEnviaEventoEpec;
import com.fincatto.nfe310.classes.evento.epec.NFEnviaEventoEpecRetorno;
import com.fincatto.nfe310.classes.evento.epec.NFEventoEpec;
import com.fincatto.nfe310.classes.evento.epec.NFInfoEpec;
import com.fincatto.nfe310.classes.evento.epec.NFInfoEventoEpec;
import com.fincatto.nfe310.classes.evento.epec.NfDestinatarioEpec;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvio;
import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.parsers.NotaParser;
import com.fincatto.nfe310.utils.NFGeraChave;
import com.fincatto.nfe310.validadores.xsd.XMLValidador;
import com.fincatto.nfe310.webservices.gerado.RecepcaoEventoStub;
import com.fincatto.nfe310.webservices.gerado.RecepcaoEventoStub.NfeDadosMsg;
import com.fincatto.nfe310.webservices.gerado.RecepcaoEventoStub.NfeRecepcaoEventoResult;

public class WSEpec {

	private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
	public static final String TIPO_EVENTO_EPEC = "110140";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSEpec.class);
    private final NFeConfig config;

    public WSEpec(NFeConfig config) {
        this.config = config;
    }
    
    NFEnviaEventoEpecRetorno enviaEpecAssinado(final String epecAssinadoXml) throws Exception {
        return this.comunicaEpec(epecAssinadoXml);
    }
    
    private String converterDataParaTexto(DateTime data, String pattern) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			return dateFormat.format(data);
		} catch (Exception ex) {
			return "";
		}
	}
    
    private NFEnviaEventoEpec criaEnvioEpec(NFLoteEnvio loteEnvio) {

		NFEnviaEventoEpec nfEnviaEventoEpec = new NFEnviaEventoEpec();
		nfEnviaEventoEpec.setIdLote(loteEnvio.getIdLote());
		nfEnviaEventoEpec.setVersao("1.00");
		nfEnviaEventoEpec.setEvento(new ArrayList<NFEventoEpec>());

		int i = 1;
		for (NFNota nfNota : loteEnvio.getNotas()) {
			NFEventoEpec nfEventoEpec = new NFEventoEpec();
			nfEventoEpec.setNota(nfNota);
			nfNota.getInfo().getIdentificacao().setTipoEmissao(NFTipoEmissao.CONTINGENCIA_EPEC);
			nfEventoEpec.setVersao("1.00");

			NFInfoEventoEpec nfInfoEventoEpec = new NFInfoEventoEpec();
			nfInfoEventoEpec.setAmbiente(this.config.getAmbiente());
			nfInfoEventoEpec.setCnpj(nfNota.getInfo().getEmitente().getCnpj());
			nfInfoEventoEpec.setCpf(nfNota.getInfo().getEmitente().getCpf());
			nfInfoEventoEpec.setCodigoEvento(WSEpec.TIPO_EVENTO_EPEC);
			nfInfoEventoEpec.setNumeroSequencialEvento(i++);
			nfInfoEventoEpec.setOrgao(NFUnidadeFederativa.RFB);
			nfInfoEventoEpec.setVersaoEvento("1.00");
			nfInfoEventoEpec.setDataHoraEvento(new DateTime());

			NFInfoEpec nfInfoEpec = new NFInfoEpec();
			nfInfoEpec.setDataHoraEmissao(converterDataParaTexto(
					nfNota.getInfo().getIdentificacao().getDataHoraEmissao(), "yyyy-MM-dd'T'HH:mm:ssXXX"));
			nfInfoEpec.setDescricaoEvento("EPEC");
			nfInfoEpec.setInscricaoEstadualEmitente(nfNota.getInfo().getEmitente().getInscricaoEstadual());
			nfInfoEpec.setOrgaoAutor(NFUnidadeFederativa
					.valueOfCodigo(nfNota.getInfo().getEmitente().getEndereco().getUf()).getCodigoIbge());
			nfInfoEpec.setTipoNota("1"); // Informar 1=Saída.
			nfInfoEpec.setTpAutor("1"); // Informar "1=Empresa Emitente" para
										// este evento.
			nfInfoEpec.setVersao(BigDecimal.valueOf(1.00));
			nfInfoEpec.setVersaoAplicativo("FSJ_1.0");
			nfInfoEventoEpec.setEpec(nfInfoEpec);

			if (nfNota.getInfo().getDestinatario() != null) {
				NfDestinatarioEpec nfDestinatarioEpec = new NfDestinatarioEpec();
				nfDestinatarioEpec.setCnpj(nfNota.getInfo().getDestinatario().getCnpj());
				nfDestinatarioEpec.setCpf(nfNota.getInfo().getDestinatario().getCpfj());
				nfDestinatarioEpec.setIdEstrangeiro(nfNota.getInfo().getDestinatario().getIdEstrangeiro());
				nfDestinatarioEpec
						.setInscricaoEstadualDestinatario(nfNota.getInfo().getDestinatario().getInscricaoEstadual());
				if (nfNota.getInfo().getDestinatario().getEndereco() != null) {
					nfDestinatarioEpec.setUfDestinatario(nfNota.getInfo().getDestinatario().getEndereco().getUf());
				}
				if (nfNota.getInfo().getTotal() != null) {
					nfDestinatarioEpec
							.setValorTotalIcms(nfNota.getInfo().getTotal().getIcmsTotal().getValorTotalICMS());
					nfDestinatarioEpec.setValorTotalIcmsSubstituicaoTributaria(
							nfNota.getInfo().getTotal().getIcmsTotal().getValorTotalICMSST());
					nfDestinatarioEpec.setValorTotalNFe(nfNota.getInfo().getTotal().getIcmsTotal().getValorTotalNFe());
				}
				nfInfoEpec.setDestinatario(nfDestinatarioEpec);
			}

			nfEventoEpec.setInfoEvento(nfInfoEventoEpec);

			nfEnviaEventoEpec.getEvento().add(nfEventoEpec);
		}

		return nfEnviaEventoEpec;

	}

    NFEnviaEventoEpecRetorno enviaEpec(NFLoteEnvio loteEnvio) throws Exception {
    	
    	final NFEnviaEventoEpec epec = criaEnvioEpec(loteEnvio);
    	
        // adiciona a chave e o dv antes de assinar
        int nSeqEvento = 1;
    	for (final NFEventoEpec eventoEpec : epec.getEvento()) {
        	final NFNota nota = eventoEpec.getNota();
            final NFGeraChave geraChave = new NFGeraChave(nota);
            String chave = geraChave.getChaveAcesso();
            eventoEpec.getInfoEvento().setIdentificador("ID" + TIPO_EVENTO_EPEC + chave + (nSeqEvento < 10 ? "0" + nSeqEvento : nSeqEvento));
            eventoEpec.getInfoEvento().setNumeroSequencialEvento(nSeqEvento++);
            eventoEpec.getInfoEvento().setChave(chave);
        }

        // assina o epec
        final String documentoAssinado = new AssinaturaDigital(this.config).assinarDocumento(epec.toString());
        final NFEnviaEventoEpec epecAssinado = new NotaParser().epecParaObjeto(documentoAssinado);

        // comunica o epec
        final NFEnviaEventoEpecRetorno epecEnvioRetorno = this.comunicaEpec(epecAssinado.toString());
        return epecEnvioRetorno;
    }

    private NFEnviaEventoEpecRetorno comunicaEpec(String epecAssinadoXml) throws Exception {
        //valida o epec assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        XMLValidador.validaEpec(epecAssinadoXml);
        
        final RecepcaoEventoStub.NfeCabecMsg cabecalho = new RecepcaoEventoStub.NfeCabecMsg();
        cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
        cabecalho.setVersaoDados(WSEpec.VERSAO_LEIAUTE.toPlainString());
        
        final RecepcaoEventoStub.NfeCabecMsgE cabecalhoE = new RecepcaoEventoStub.NfeCabecMsgE();
        cabecalhoE.setNfeCabecMsg(cabecalho);

        final RecepcaoEventoStub.NfeDadosMsg dados = new NfeDadosMsg();
        final OMElement omElementXML = AXIOMUtil.stringToOM(epecAssinadoXml);
        WSEpec.LOGGER.debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);

        //define o tipo de emissao
        final NFAutorizador31 autorizador = NFAutorizador31.AN;

        final String endpoint = autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao EPEC, autorizador " + autorizador.name());
        }

        final NfeRecepcaoEventoResult nfeRecepcaoEvento = new RecepcaoEventoStub(endpoint).nfeRecepcaoEvento(dados, cabecalhoE);
        final OMElement omElementResult = nfeRecepcaoEvento.getExtraElement();
        String xmlRetorno = omElementResult.toString();
        return new NotaParser().xmlParaEpecRetorno(xmlRetorno);
    }
    
}