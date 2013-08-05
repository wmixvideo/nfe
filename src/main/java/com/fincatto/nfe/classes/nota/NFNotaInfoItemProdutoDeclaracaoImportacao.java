package com.fincatto.nfe.classes.nota;

import java.util.List;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemProdutoDeclaracaoImportacao extends NFBase {
	
	@Element(name = "nDI", required = true)
	private String numeroRegistro;
	
	@Element(name = "dDI", required = true)
	private LocalDate dataRegistro;
	
	@Element(name = "xLocDesemb", required = true)
	private String localDesembaraco;
	
	@Element(name = "UFDesemb", required = true)
	private NFUnidadeFederativa ufDesembaraco;
	
	@Element(name = "dDesemb", required = true)
	private LocalDate dataDesembaraco;
	
	@Element(name = "cExportador", required = true)
	private String codigoExportador;
	
	@ElementList(entry = "adi", inline = true, required = true)
	private List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> adicoes;
	
	public NFNotaInfoItemProdutoDeclaracaoImportacao() {
		this.numeroRegistro = null;
		this.dataRegistro = null;
		this.localDesembaraco = null;
		this.ufDesembaraco = null;
		this.dataDesembaraco = null;
		this.codigoExportador = null;
		this.adicoes = null;
	}
	
	public String getNumeroRegistro() {
		return this.numeroRegistro;
	}
	
	public void setNumeroRegistro(final String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	
	public LocalDate getDataRegistro() {
		return this.dataRegistro;
	}
	
	public void setDataRegistro(final LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	public String getLocalDesembaraco() {
		return this.localDesembaraco;
	}
	
	public void setLocalDesembaraco(final String localDesembaraco) {
		this.localDesembaraco = localDesembaraco;
	}
	
	public NFUnidadeFederativa getUfDesembaraco() {
		return this.ufDesembaraco;
	}
	
	public void setUfDesembaraco(final NFUnidadeFederativa ufDesembaraco) {
		this.ufDesembaraco = ufDesembaraco;
	}
	
	public LocalDate getDataDesembaraco() {
		return this.dataDesembaraco;
	}
	
	public void setDataDesembaraco(final LocalDate dataDesembaraco) {
		this.dataDesembaraco = dataDesembaraco;
	}
	
	public String getCodigoExportador() {
		return this.codigoExportador;
	}
	
	public void setCodigoExportador(final String codigoExportador) {
		this.codigoExportador = codigoExportador;
	}
	
	public List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> getAdicoes() {
		return this.adicoes;
	}
	
	public void setAdicoes(final List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> adicoes) {
		this.adicoes = adicoes;
	}
}