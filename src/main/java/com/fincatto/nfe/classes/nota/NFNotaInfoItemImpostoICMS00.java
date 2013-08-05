package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMS00 extends NFBase {
	
	@Element(name = "orig", required = true)
	private NFOrigem origem;
	
	@Element(name = "CST", required = true)
	private String codigoSituacaoTributaria;
	
	@Element(name = "modBC", required = true)
	private NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidadeBaseCalculo;
	
	@Element(name = "vBC", required = true)
	private BigDecimal valorBaseCalculo;
	
	@Element(name = "pICMS", required = true)
	private BigDecimal aliquota;
	
	@Element(name = "vICMS", required = true)
	private BigDecimal valorTributo;
	
}
