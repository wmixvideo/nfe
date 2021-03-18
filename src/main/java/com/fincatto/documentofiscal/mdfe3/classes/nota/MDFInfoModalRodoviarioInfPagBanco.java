package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
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
    @Element(name = "codBanco")
    private String codBanco;

    /**
     * Número da agência bancária
     */
    @Element(name = "codAgencia")
    private String codAgencia;

    /**
     * Número do CNPJ da Instituição de Pagamento Eletrônico do Frete
     * Informar os zeros não significativos.
     */
    @Element(name = "CNPJIPEF", required = false)
    private String CNPJIPEF;

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

}
