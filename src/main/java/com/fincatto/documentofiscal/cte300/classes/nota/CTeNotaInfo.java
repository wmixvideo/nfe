package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.ListValidador;

/**
 * @author Caio
 * @info Informações do CT-e
 * */

@Root(name = "infCte")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfo extends DFBase {
	
    @Element(name = "ide", required = true)
    private CTeNotaInfoIdentificacao identificacao;
    
    @Element(name = "compl", required = false)
    private CTeNotaInfoDadosComplementares dadosComplementares;
    
    @Element(name = "emit", required = true)
    private CTeNotaInfoEmitente emitente;
    
    @Element(name = "rem", required = false)
    private CTeNotaInfoRemetente remetente;
    
    @Element(name = "exped", required = false)
    private CTeNotaInfoExpedidorCarga expedidorCarga;
    
    @Element(name = "receb", required = false)
    private CTeNotaInfoRecebedorCarga recebedorCarga;
    
    @Element(name = "dest", required = false)
    private CTeNotaInfoDestinatario destinatario;
    
    @Element(name = "vPrest", required = true)
    private CTeNotaInfoValorPrestacaoServico valorPrestacaoServico;
    
    @Element(name = "imp", required = true)
    private CTeNotaInfoInformacoesRelativasImpostos informacoesRelativasImpostos;
    
    @Element(name = "infCTeNorm", required = false)
    private CTeNotaInfoCTeNormal cteNormal;
    
    @Element(name = "infCteComp", required = false)
    private CTeNotaInfoCTeComplementar cteComplementar;
    
    @Element(name = "infCteAnu", required = false)
    private CTeNotaInfoCTeAnulacao cteAnulacao;
    
    @ElementList(name = "autXML", inline = true, required = false)
    private List<CTeNotaInfoAutorizacaoDownload> autorizacaoDownload;
    
	@Attribute(name = "versao", required = true)
	private String versao;
    
    @Attribute(name = "Id", required = true)
    private String identificador;

	public CTeNotaInfo() {
		this.identificacao = null;
		this.dadosComplementares = null;
		this.emitente = null;
		this.remetente = null;
		this.expedidorCarga = null;
		this.recebedorCarga = null;
		this.destinatario = null;
		this.valorPrestacaoServico = null;
		this.informacoesRelativasImpostos = null;
		this.cteNormal = null;
		this.cteComplementar = null;
		this.cteAnulacao = null;
		this.autorizacaoDownload = null;
		this.versao = null;
		this.identificador = null;
	}

	public CTeNotaInfoIdentificacao getIdentificacao() {
		return identificacao;
	}

	/**
	 * Identificação do CT-e
	 * */
	public void setIdentificacao(CTeNotaInfoIdentificacao identificacao) {
		this.identificacao = identificacao;
	}

	public CTeNotaInfoDadosComplementares getDadosComplementares() {
		return dadosComplementares;
	}

	/**
	 * Dados complementares do CT-e para fins operacionais ou comerciais
	 * */
	public void setDadosComplementares(CTeNotaInfoDadosComplementares dadosComplementares) {
		this.dadosComplementares = dadosComplementares;
	}

	public CTeNotaInfoEmitente getEmitente() {
		return emitente;
	}

	/**
	 * Identificação do Emitente do CT-e
	 * */
	public void setEmitente(CTeNotaInfoEmitente emitente) {
		this.emitente = emitente;
	}

	public CTeNotaInfoRemetente getRemetente() {
		return remetente;
	}

	/**
	 * Informações do Remetente das mercadorias transportadas pelo CT-e<br>
	 * Poderá não ser informado para os CT-e de redespacho intermediário e serviço vinculado a multimodal. Nos demais casos deverá sempre ser informado.
	 * */
	public void setRemetente(CTeNotaInfoRemetente remetente) {
		this.remetente = remetente;
	}

	public CTeNotaInfoExpedidorCarga getExpedidorCarga() {
		return expedidorCarga;
	}

	/**
	 * Informações do Expedidor da Carga
	 * */
	public void setExpedidorCarga(CTeNotaInfoExpedidorCarga expedidorCarga) {
		this.expedidorCarga = expedidorCarga;
	}

	public CTeNotaInfoRecebedorCarga getRecebedorCarga() {
		return recebedorCarga;
	}

	/**
	 * Informações do Recebedor da Carga
	 * */
	public void setRecebedorCarga(CTeNotaInfoRecebedorCarga recebedorCarga) {
		this.recebedorCarga = recebedorCarga;
	}

	public CTeNotaInfoDestinatario getDestinatario() {
		return destinatario;
	}

	/**
	 * Informações do Destinatário do CT-e<br>
	 * Só pode ser omitido em caso de redespacho intermediário
	 * */
	public void setDestinatario(CTeNotaInfoDestinatario destinatario) {
		this.destinatario = destinatario;
	}

	public CTeNotaInfoValorPrestacaoServico getValorPrestacaoServico() {
		return valorPrestacaoServico;
	}

	/**
	 * Valores da Prestação de Serviço
	 * */
	public void setValorPrestacaoServico(CTeNotaInfoValorPrestacaoServico valorPrestacaoServico) {
		this.valorPrestacaoServico = valorPrestacaoServico;
	}

	public CTeNotaInfoInformacoesRelativasImpostos getInformacoesRelativasImpostos() {
		return informacoesRelativasImpostos;
	}

	/**
	 * Informações relativas aos Impostos
	 * */
	public void setInformacoesRelativasImpostos(CTeNotaInfoInformacoesRelativasImpostos informacoesRelativasImpostos) {
		this.informacoesRelativasImpostos = informacoesRelativasImpostos;
	}

	public CTeNotaInfoCTeNormal getCteNormal() {
		return cteNormal;
	}

	/**
	 * Grupo de informações do CT-e Normal e Substituto
	 * */
	public void setCteNormal(CTeNotaInfoCTeNormal cteNormal) {
		this.cteNormal = cteNormal;
	}

	public CTeNotaInfoCTeComplementar getCteComplementar() {
		return cteComplementar;
	}

	/**
	 * Detalhamento do CT-e complementado
	 * */
	public void setCteComplementar(CTeNotaInfoCTeComplementar cteComplementar) {
		this.cteComplementar = cteComplementar;
	}

	public CTeNotaInfoCTeAnulacao getCteAnulacao() {
		return cteAnulacao;
	}

	/**
	 * Detalhamento do CT-e do tipo Anulação
	 * */
	public void setCteAnulacao(CTeNotaInfoCTeAnulacao cteAnulacao) {
		this.cteAnulacao = cteAnulacao;
	}

	public List<CTeNotaInfoAutorizacaoDownload> getAutorizacaoDownload() {
		return autorizacaoDownload;
	}

	/**
	 * Autorizados para download do XML do DF-e<br>
	 * Informar CNPJ ou CPF. Preencher os zeros não significativos.
	 * */
	public void setAutorizacaoDownload(List<CTeNotaInfoAutorizacaoDownload> autorizacaoDownload) {
		ListValidador.tamanho10(autorizacaoDownload, "Autorizados para download do XML do DF-e");
		this.autorizacaoDownload = autorizacaoDownload;
	}

	public String getVersao() {
		return versao;
	}

	/**
	 * Versão do leiaute
	 * */
	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getIdentificador() {
		return identificador;
	}

	/**
	 * Identificador da tag a ser assinada<br>
	 * Informar a chave de acesso do CT-e e precedida do literal "CTe"
	 * */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}
