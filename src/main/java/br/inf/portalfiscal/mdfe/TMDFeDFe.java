//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.01.19 às 11:37:18 PM BRT 
//


package br.inf.portalfiscal.mdfe;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo Documento Fiscal Eletrônico MDF-e
 * 
 * <p>Classe Java de TMDFeDFe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TMDFeDFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="procMDFe"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="2" minOccurs="2"&gt;
 *                   &lt;any/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerMDFeConsultaDFe" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="procEventoMDFe" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="2" minOccurs="2"&gt;
 *                   &lt;any/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerMDFeConsultaDFe" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TMDFeDFe", propOrder = {
    "procMDFe",
    "procEventoMDFe"
})
public class TMDFeDFe {

    @XmlElement(required = true)
    protected TMDFeDFe.ProcMDFe procMDFe;
    protected List<TMDFeDFe.ProcEventoMDFe> procEventoMDFe;

    /**
     * Obtém o valor da propriedade procMDFe.
     * 
     * @return
     *     possible object is
     *     {@link TMDFeDFe.ProcMDFe }
     *     
     */
    public TMDFeDFe.ProcMDFe getProcMDFe() {
        return procMDFe;
    }

    /**
     * Define o valor da propriedade procMDFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TMDFeDFe.ProcMDFe }
     *     
     */
    public void setProcMDFe(TMDFeDFe.ProcMDFe value) {
        this.procMDFe = value;
    }

    /**
     * Gets the value of the procEventoMDFe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the procEventoMDFe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcEventoMDFe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TMDFeDFe.ProcEventoMDFe }
     * 
     * 
     */
    public List<TMDFeDFe.ProcEventoMDFe> getProcEventoMDFe() {
        if (procEventoMDFe == null) {
            procEventoMDFe = new ArrayList<TMDFeDFe.ProcEventoMDFe>();
        }
        return this.procEventoMDFe;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence maxOccurs="2" minOccurs="2"&gt;
     *         &lt;any/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerMDFeConsultaDFe" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class ProcEventoMDFe {

        @XmlAnyElement(lax = true)
        protected List<Object> any;
        @XmlAttribute(name = "versao", required = true)
        protected String versao;

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

        /**
         * Obtém o valor da propriedade versao.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVersao() {
            return versao;
        }

        /**
         * Define o valor da propriedade versao.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVersao(String value) {
            this.versao = value;
        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence maxOccurs="2" minOccurs="2"&gt;
     *         &lt;any/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerMDFeConsultaDFe" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class ProcMDFe {

        @XmlAnyElement(lax = true)
        protected List<Object> any;
        @XmlAttribute(name = "versao", required = true)
        protected String versao;

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

        /**
         * Obtém o valor da propriedade versao.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVersao() {
            return versao;
        }

        /**
         * Define o valor da propriedade versao.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVersao(String value) {
            this.versao = value;
        }

    }

}
