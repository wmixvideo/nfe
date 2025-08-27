package com.fincatto.documentofiscal.mdfe3.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFListValidador;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 * <h1>Informações de Vale Pedágio.</h1>
 * <p>
 * Outras informações sobre Vale-Pedágio obrigatório que não tenham campos
 * específicos devem ser informadas no campo de observações gerais de uso livre
 * pelo contribuinte, visando atender as determinações legais vigentes.
 * </p>
 */
@Root(name = "valePed")
public class MDFInfoModalRodoviarioPedagio extends DFBase {
	private static final long serialVersionUID = 3657414548123273405L;
	/**
	 * Lista de dispositivos do Vale Pedágio.
	 */
	@ElementList(entry = "disp", inline = true)
	private List<MDFInfoModalRodoviarioPedagioDisp> dispositivos;

	/**
	 * <h1>Categoria do Combinação Veicular</h1>
	 */
	@Element(name = "categCombVeic", required = false)
	private String categoriaCombinacaoVeicular;

	public List<MDFInfoModalRodoviarioPedagioDisp> getDispositivos() {
		return this.dispositivos;
	}

	public void setDispositivos(final List<MDFInfoModalRodoviarioPedagioDisp> dispositivos) {
		this.dispositivos = DFListValidador.validaListaObrigatoria(dispositivos, "Dispositivos do Vale Pedagio");
	}

	public String getCategoriaCombinacaoVeicular() {
		return categoriaCombinacaoVeicular;
	}

	public void setCategoriaCombinacaoVeicular(String categoriaCombinacaoVeicular) {
		this.categoriaCombinacaoVeicular = categoriaCombinacaoVeicular;
	}

}
