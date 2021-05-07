package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoInfPag;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import java.math.BigDecimal;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/**
 * Created by Edivaldo Merlo Stens on 29/06/20.
 *
 * <h1>Grupo de informações pagamento do transporte</h1>
 *
 */
public class MDFInfoModalRodoviarioInfPag {

    /**
     * <p>Nome do responsável pelo pgto.</p>
     */
    @Element(name = "xNome", required = false)
    private String xNome;
    
    /**
     * <p>Número do CPF do responsável pelo pgto.</p>
     */
    @Element(name = "CPF", required = false)
    private String cpf;

    /**
     * <p>Número do CNPJ do responsável pelo pgto.</p>
     */
    @Element(name = "CNPJ", required = false)
    private String cnpj;
    
    /**
     * <p>Identificador do responsável pelo pgto em caso de ser estrangeiro.</p>
     */
    @Element(name = "idEstrangeiro", required = false)
    private String idEstrangeiro;
    
    /**
     * Componentes do Pagamento do Frete 
     */
    @ElementList(entry = "Comp", inline = true, required = true)
    private List<MDFInfoModalRodoviarioInfPagComp> comp;
    
    /**
     * Valor total do contrato
     */
    @Element(name = "vContrato", required = true)
    private BigDecimal vContrato;
    
    /**
     * Indicador da Forma de Pagamento: 0-Pagamento à Vista; 1-Pagamento à
     * Prazo;
     */
    @Element(name = "indPag", required = true)
    private MDFTipoInfPag indPag;
    
    /**
     * Informações do pagamento a prazo. Obs: Informar somente se indPag for à Prazo
     */
    @ElementList(entry = "infPrazo", inline = true, required = false)
    private List<MDFInfoModalRodoviarioInfPagPrazo> infPrazo;
    
    /**
     * Informações bancárias.
     */
    @Element(name = "infBanc", required = true)
    private MDFInfoModalRodoviarioInfPagBanco infBanc;

    public String getXNome() {
        return xNome;
    }

    public void setXNome(String xNome) {
        this.xNome = xNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (this.cnpj != null || this.idEstrangeiro != null) {
            throw new IllegalStateException("Nao deve setar CPF se CNPJ/IdEstrangeiro esteja setado");
        }
        DFStringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (this.cpf != null || this.idEstrangeiro != null) {
            throw new IllegalStateException("Nao deve setar CNPJ se CPF/IdEstrangeiro esteja setado");
        }
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getIdEstrangeiro() {
        return idEstrangeiro;
    }

    public void setIdEstrangeiro(String idEstrangeiro) {
        if (this.cpf != null || this.cnpj != null) {
            throw new IllegalStateException("Nao deve setar IdEstrangeiro se CPF/CNPJ esteja setado");
        }
        this.idEstrangeiro = idEstrangeiro;
    }

    public List<MDFInfoModalRodoviarioInfPagComp> getComp() {
        return comp;
    }

    public void setComp(List<MDFInfoModalRodoviarioInfPagComp> comp) {
        this.comp = comp;
    }

    public BigDecimal getVContrato() {
        return vContrato;
    }

    public void setVContrato(BigDecimal vContrato) {
        this.vContrato = vContrato;
    }

    public MDFTipoInfPag getIndPag() {
        return indPag;
    }

    public void setIndPag(MDFTipoInfPag indPag) {
        this.indPag = indPag;
    }

    public List<MDFInfoModalRodoviarioInfPagPrazo> getInfPrazo() {
        return infPrazo;
    }

    public void setInfPrazo(List<MDFInfoModalRodoviarioInfPagPrazo> infPrazo) {
        this.infPrazo = infPrazo;
    }

    public MDFInfoModalRodoviarioInfPagBanco getInfBanc() {
        return infBanc;
    }

    public void setInfBanc(MDFInfoModalRodoviarioInfPagBanco infBanc) {
        this.infBanc = infBanc;
    }
    
}