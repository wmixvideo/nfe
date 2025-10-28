
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Grupo de informações complementares disponível para todos os serviços prestados
 */

@Root(name = "infoCompl")
public class NFSeSefinNacionalInfoCompl {

    @Element(name = "idDocTec")
    protected String idDocResponsabilidadeTecnica;
    @Element(name = "docRef")
    protected String referenciaDocumento;
    @Element(name = "xInfComp")
    protected String informacoesComplementares;

    /**
     * @return Identificador de Documento de Responsabilidade Técnica: ART, RRT, DRT, Outros.
     */
    public String getIdDocResponsabilidadeTecnica() {
        return idDocResponsabilidadeTecnica;
    }

    /**
     * @param idDocResponsabilidadeTecnica Identificador de Documento de Responsabilidade Técnica: ART, RRT, DRT, Outros.
     */
    public void setIdDocResponsabilidadeTecnica(String idDocResponsabilidadeTecnica) {
        this.idDocResponsabilidadeTecnica = idDocResponsabilidadeTecnica;
    }

    /**
     * Chave da nota, número identificador da nota, número do contrato ou outro identificador de documento emitido pelo prestador de serviços,
     * que subsidia a emissão dessa nota pelo tomador do serviço ou intermediário
     * (preenchimento obrigatório caso a nota esteja sendo emitida pelo Tomador ou intermediário do serviço)
     * @return Referência do documento
     */
    public String getReferenciaDocumento() {
        return referenciaDocumento;
    }

    /**
     * Chave da nota, número identificador da nota, número do contrato ou outro identificador de documento emitido pelo prestador de serviços,
     * que subsidia a emissão dessa nota pelo tomador do serviço ou intermediário
     * (preenchimento obrigatório caso a nota esteja sendo emitida pelo Tomador ou intermediário do serviço)
     * @param referenciaDocumento Referência do documento
     */
    public void setReferenciaDocumento(String referenciaDocumento) {
        this.referenciaDocumento = referenciaDocumento;
    }

    /**
     * @return Informações complementares
     */
    public String getInformacoesComplementares() {
        return informacoesComplementares;
    }

    /**
     * @param informacoesComplementares Informações complementares
     */
    public void setInformacoesComplementares(String informacoesComplementares) {
        this.informacoesComplementares = informacoesComplementares;
    }

}
