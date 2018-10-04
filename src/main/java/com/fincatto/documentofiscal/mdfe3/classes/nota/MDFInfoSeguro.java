package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import org.simpleframework.xml.ElementList;

/**
 * Created by Eldevan Nery Junior on 07/12/17. Informações de Seguro da Carga.
 */
@Root(name = "seg")
@XmlAccessorType(XmlAccessType.FIELD)
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoSeguro extends DFBase {

    private static final long serialVersionUID = 665561268515018765L;

    @Element(name = "infResp")
    private MDFInfoSeguroResponsavel responsavelSeguro;

    @Element(name = "infSeg", required = false)
    private MDFInfoSeguroInfo info;

    @Element(name = "nApol", required = false)
    private String apolice;

    @ElementList(name = "nAver", inline = true, entry = "nAver")
    private List<String> averbacao;

    public MDFInfoSeguroInfo getInfo() {
        return this.info;
    }

    /**
     * Informações do responsável pelo seguro da carga
     */
    public MDFInfoSeguroResponsavel getResponsavelSeguro() {
        return responsavelSeguro;
    }

    public void setResponsavelSeguro(MDFInfoSeguroResponsavel responsavelSeguro) {
        this.responsavelSeguro = responsavelSeguro;
    }

    /**
     * Informações da seguradora
     */
    public void setInfo(final MDFInfoSeguroInfo info) {
        this.info = info;
    }

    public String getApolice() {
        return this.apolice;
    }

    /**
     * Número da Apólice<br>
     * Obrigatório pela lei 11.442/07 (RCTRC)
     */
    public void setApolice(final String apolice) {
        StringValidador.tamanho20(apolice, "Número da Apólice");
        this.apolice = apolice;
    }

    public List<String> getAverbacao() {
        return this.averbacao;
    }

    /**
     * 127 | nAver | 2 | Número da Averbação | E | C | 0 - n | 1 - 40 | ER35 | Informar as averbações do seguro
     */
    public void setAverbacao(final List<String> averbacao) {
        this.averbacao = averbacao;
    }
}
