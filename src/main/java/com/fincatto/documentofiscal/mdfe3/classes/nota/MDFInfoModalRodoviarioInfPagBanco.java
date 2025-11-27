package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Edivaldo Merlo Stens on 29/06/20.
 * <h1>Informações bancárias</h1>
 */
@Root(name = "infBanc")
public class MDFInfoModalRodoviarioInfPagBanco extends DFBase {

    private static final long serialVersionUID = 3657414548123273478L;

    /**
     * Número do banco
     */
    @Element(name = "codBanco", required = false)
    private String codBanco;

    /**
     * Número da agência bancária
     */
    @Element(name = "codAgencia", required = false)
    private String codAgencia;

    /**
     * Número do CNPJ da Instituição de Pagamento Eletrônico do Frete
     * Informar os zeros não significativos.
     */
    @Element(name = "CNPJIPEF", required = false)
    private String CNPJIPEF;

    /**
     * Chave PIX
     * Pode ser email, CPF/ CNPJ (somente numeros), Telefone com a seguinte formatação (+5599999999999) ou a chave aleatória gerada pela instituição.
     */
    @Element(name = "PIX", required = false)
    private String PIX;

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(String codAgencia) {
        this.codAgencia = codAgencia;
    }

    public String getCNPJIPEF() {
        return CNPJIPEF;
    }

    public void setCNPJIPEF(String CNPJIPEF) {
        this.CNPJIPEF = CNPJIPEF != null ? StringUtils.leftPad(CNPJIPEF, 14, "0") : null;
    }

    public String getPIX() {
        return PIX;
    }

    public void setPIX(String PIX) {
        DFStringValidador.tamanho2ate60(PIX, "Chave PIX");
        this.PIX = PIX;
    }
}
