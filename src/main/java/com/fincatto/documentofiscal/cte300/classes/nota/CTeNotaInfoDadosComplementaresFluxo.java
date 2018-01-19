package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Previsão do fluxo da carga<br>
 *       Preenchimento obrigatório para o modal aéreo.
 */

@Root(name = "fluxo")
public class CTeNotaInfoDadosComplementaresFluxo extends DFBase {
    private static final long serialVersionUID = 512911768559316038L;

    @Element(name = "xOrig", required = false)
    private String origem;

    @ElementList(name = "pass", inline = true, required = false)
    private List<CTeNotaInfoDadosComplementaresFluxoPass> pass;

    @Element(name = "xDest", required = false)
    private String destino;

    @Element(name = "xRota", required = false)
    private String rota;

    public CTeNotaInfoDadosComplementaresFluxo() {
        this.origem = null;
        this.pass = null;
        this.destino = null;
        this.rota = null;
    }

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
        StringValidador.tamanho60(origem, "Sigla ou código interno da Filial/Porto/Estação/ Aeroporto de Origem");
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
        StringValidador.tamanho60(destino, "Sigla ou código interno da Filial/Porto/Estação/Aeroporto de Destino");
        this.destino = destino;
    }

    public String getRota() {
        return this.rota;
    }

    /**
     * Código da Rota de Entrega
     */
    public void setRota(final String rota) {
        StringValidador.tamanho10(rota, "Código da Rota de Entrega");
        this.rota = rota;
    }
}
