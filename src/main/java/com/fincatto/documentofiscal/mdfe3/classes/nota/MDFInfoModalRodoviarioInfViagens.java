package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;

/**
 * Created by Edivaldo Merlo Stens on 29/06/20.
 *
 * <h1>Informações do total de viagens acobertadas pelo Evento “pagamento do frete”</h1>
 *
 */
public class MDFInfoModalRodoviarioInfViagens {

    /**
     * Quantidade total de viagens realizadas com o pagamento do Frete 
     */
    @Element(required = true)
    private String qtdViagens;
    
    
    /**
     * Número de referência da viagem do MDF-e referenciado
     */
    @Element(required = true)
    private String nroViagem;

    public String getQtdViagens() {
        return qtdViagens;
    }

    public void setQtdViagens(String qtdViagens) {
        this.qtdViagens = qtdViagens != null ? StringUtils.leftPad(qtdViagens, 5, "0") : null;
    }

    public String getNroViagem() {
        return nroViagem;
    }

    public void setNroViagem(String nroViagem) {
        this.nroViagem = nroViagem != null ? StringUtils.leftPad(nroViagem, 5, "0") : null;
    }

    
}