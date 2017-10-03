package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTClasseTarifa;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações de tarifa
 * */

@Root(name = "tarifa")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalAereoTarifa extends DFBase {

	@Element(name = "CL", required = true)
    private CTClasseTarifa classe;
	
	@Element(name = "cTar", required = false)
    private String codigo;
	
	@Element(name = "vTar", required = true)
    private String valor;

	public CTeNotaInfoCTeNormalInfoModalAereoTarifa() {
		this.classe = null;
		this.codigo = null;
		this.valor = null;
	}

	public CTClasseTarifa getClasse() {
		return classe;
	}

	/**
	 * Classe<br>
	 * M - Tarifa Mínima;<br>
	 * G - Tarifa Geral;<br>
	 * E - Tarifa Específica
	 * */
	public void setClasse(CTClasseTarifa classe) {
		this.classe = classe;
	}

	public String getCodigo() {
		return codigo;
	}

	/**
	 * Código da Tarifa<br>
	 * Deverão ser incluídos os códigos de três dígitos, correspondentes à tarifa.
	 * */
	public void setCodigo(String codigo) {
		StringValidador.tamanho4(codigo, "Código da Tarifa");
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	/**
	 * Valor da Tarifa<br>
	 * Valor da tarifa por kg quando for o caso.
	 * */
	public void setValor(BigDecimal valor) {
		this.valor = BigDecimalParser.tamanho15Com2CasasDecimais(valor, "Valor da Tarifa");
	}
}
