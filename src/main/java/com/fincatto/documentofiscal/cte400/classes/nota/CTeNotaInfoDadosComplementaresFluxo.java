package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Previsão do fluxo da carga<br>
 *       Preenchimento obrigatório para o modal aéreo.
 */

@Root(name = "fluxo")
public class CTeNotaInfoDadosComplementaresFluxo extends DFBase {
    private static final long serialVersionUID = 4949460530848044079L;

    @Element(name = "xOrig", required = false)
    private String origem;

    @ElementList(name = "pass", inline = true, required = false)
    private List<CTeNotaInfoDadosComplementaresFluxoPass> pass;

    @Element(name = "xDest", required = false)
    private String destino;

    @Element(name = "xRota", required = false)
    private String rota;

    public String getOrigem() {
        return this.origem;
    }

    /**
     * Sigla ou código interno da Filial/Porto/Estação/ Aeroporto de Origem<br>
     * Observações para o modal aéreo:<br>
     * - Preenchimento obrigatório para o modal aéreo.<br>
     * - O código de três letras IATA do aeroporto de partida deverá ser incluído como primeira anotação. Quando não for possível, utilizar a sigla OACI.
     */
    public void setOrigem(final String origem) {
        DFStringValidador.tamanho60(origem, "Sigla ou código interno da Filial/Porto/Estação/ Aeroporto de Origem");
        this.origem = origem;
    }

    public List<CTeNotaInfoDadosComplementaresFluxoPass> getPass() {
        return this.pass;
    }

    /**
     * Sigla ou código interno da Filial/Porto/Estação/Aeroporto de Passagem<br>
     * Observação para o modal aéreo:<br>
     * - O código de três letras IATA, referente ao aeroporto de transferência, deverá ser incluído, quando for o caso. Quando não for possível, utilizar a sigla OACI. Qualquer solicitação de itinerário deverá ser incluída.
     */
    public void setPass(final List<CTeNotaInfoDadosComplementaresFluxoPass> pass) {
        this.pass = pass;
    }

    public String getDestino() {
        return this.destino;
    }

    /**
     * Sigla ou código interno da Filial/Porto/Estação/Aeroporto de Destino<br>
     * Observações para o modal aéreo:<br>
     * - Preenchimento obrigatório para o modal aéreo.<br>
     * - Deverá ser incluído o código de três letras IATA do aeroporto de destino. Quando não for possível, utilizar a sigla OACI.
     */
    public void setDestino(final String destino) {
        DFStringValidador.tamanho60(destino, "Sigla ou código interno da Filial/Porto/Estação/Aeroporto de Destino");
        this.destino = destino;
    }

    public String getRota() {
        return this.rota;
    }

    /**
     * Código da Rota de Entrega
     */
    public void setRota(final String rota) {
        DFStringValidador.tamanho10(rota, "Código da Rota de Entrega");
        this.rota = rota;
    }
}
