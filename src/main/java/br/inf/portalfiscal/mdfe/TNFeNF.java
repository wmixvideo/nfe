//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.01.19 às 11:37:18 PM BRT 
//


package br.inf.portalfiscal.mdfe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo  de Dados das Notas Fiscais Papel e Eletrônica
 * 
 * <p>Classe Java de TNFeNF complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TNFeNF"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="infNFe"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
 *                   &lt;element name="PIN" type="{http://www.portalfiscal.inf.br/mdfe}TPIN" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infNF"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="emi"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="dest"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="serie"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="3"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="nNF"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="20"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/mdfe}TData"/&gt;
 *                   &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
 *                   &lt;element name="PIN" type="{http://www.portalfiscal.inf.br/mdfe}TPIN" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TNFeNF", propOrder = {
    "infNFe",
    "infNF"
})
public class TNFeNF {

    protected TNFeNF.InfNFe infNFe;
    protected TNFeNF.InfNF infNF;

    /**
     * Obtém o valor da propriedade infNFe.
     * 
     * @return
     *     possible object is
     *     {@link TNFeNF.InfNFe }
     *     
     */
    public TNFeNF.InfNFe getInfNFe() {
        return infNFe;
    }

    /**
     * Define o valor da propriedade infNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TNFeNF.InfNFe }
     *     
     */
    public void setInfNFe(TNFeNF.InfNFe value) {
        this.infNFe = value;
    }

    /**
     * Obtém o valor da propriedade infNF.
     * 
     * @return
     *     possible object is
     *     {@link TNFeNF.InfNF }
     *     
     */
    public TNFeNF.InfNF getInfNF() {
        return infNF;
    }

    /**
     * Define o valor da propriedade infNF.
     * 
     * @param value
     *     allowed object is
     *     {@link TNFeNF.InfNF }
     *     
     */
    public void setInfNF(TNFeNF.InfNF value) {
        this.infNF = value;
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
     *       &lt;sequence&gt;
     *         &lt;element name="emi"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="dest"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="serie"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="3"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="nNF"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="20"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/mdfe}TData"/&gt;
     *         &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
     *         &lt;element name="PIN" type="{http://www.portalfiscal.inf.br/mdfe}TPIN" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "emi",
        "dest",
        "serie",
        "nnf",
        "dEmi",
        "vnf",
        "pin"
    })
    public static class InfNF {

        @XmlElement(required = true)
        protected TNFeNF.InfNF.Emi emi;
        @XmlElement(required = true)
        protected TNFeNF.InfNF.Dest dest;
        @XmlElement(required = true)
        protected String serie;
        @XmlElement(name = "nNF", required = true)
        protected String nnf;
        @XmlElement(required = true)
        protected String dEmi;
        @XmlElement(name = "vNF", required = true)
        protected String vnf;
        @XmlElement(name = "PIN")
        protected String pin;

        /**
         * Obtém o valor da propriedade emi.
         * 
         * @return
         *     possible object is
         *     {@link TNFeNF.InfNF.Emi }
         *     
         */
        public TNFeNF.InfNF.Emi getEmi() {
            return emi;
        }

        /**
         * Define o valor da propriedade emi.
         * 
         * @param value
         *     allowed object is
         *     {@link TNFeNF.InfNF.Emi }
         *     
         */
        public void setEmi(TNFeNF.InfNF.Emi value) {
            this.emi = value;
        }

        /**
         * Obtém o valor da propriedade dest.
         * 
         * @return
         *     possible object is
         *     {@link TNFeNF.InfNF.Dest }
         *     
         */
        public TNFeNF.InfNF.Dest getDest() {
            return dest;
        }

        /**
         * Define o valor da propriedade dest.
         * 
         * @param value
         *     allowed object is
         *     {@link TNFeNF.InfNF.Dest }
         *     
         */
        public void setDest(TNFeNF.InfNF.Dest value) {
            this.dest = value;
        }

        /**
         * Obtém o valor da propriedade serie.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSerie() {
            return serie;
        }

        /**
         * Define o valor da propriedade serie.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSerie(String value) {
            this.serie = value;
        }

        /**
         * Obtém o valor da propriedade nnf.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNNF() {
            return nnf;
        }

        /**
         * Define o valor da propriedade nnf.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNNF(String value) {
            this.nnf = value;
        }

        /**
         * Obtém o valor da propriedade dEmi.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDEmi() {
            return dEmi;
        }

        /**
         * Define o valor da propriedade dEmi.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDEmi(String value) {
            this.dEmi = value;
        }

        /**
         * Obtém o valor da propriedade vnf.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVNF() {
            return vnf;
        }

        /**
         * Define o valor da propriedade vnf.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVNF(String value) {
            this.vnf = value;
        }

        /**
         * Obtém o valor da propriedade pin.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPIN() {
            return pin;
        }

        /**
         * Define o valor da propriedade pin.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPIN(String value) {
            this.pin = value;
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
         *       &lt;sequence&gt;
         *         &lt;choice&gt;
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "cnpj",
            "cpf",
            "xNome",
            "uf"
        })
        public static class Dest {

            @XmlElement(name = "CNPJ")
            protected String cnpj;
            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(required = true)
            protected String xNome;
            @XmlElement(name = "UF", required = true)
            @XmlSchemaType(name = "string")
            protected TUf uf;

            /**
             * Obtém o valor da propriedade cnpj.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCNPJ() {
                return cnpj;
            }

            /**
             * Define o valor da propriedade cnpj.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCNPJ(String value) {
                this.cnpj = value;
            }

            /**
             * Obtém o valor da propriedade cpf.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCPF() {
                return cpf;
            }

            /**
             * Define o valor da propriedade cpf.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCPF(String value) {
                this.cpf = value;
            }

            /**
             * Obtém o valor da propriedade xNome.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXNome() {
                return xNome;
            }

            /**
             * Define o valor da propriedade xNome.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXNome(String value) {
                this.xNome = value;
            }

            /**
             * Obtém o valor da propriedade uf.
             * 
             * @return
             *     possible object is
             *     {@link TUf }
             *     
             */
            public TUf getUF() {
                return uf;
            }

            /**
             * Define o valor da propriedade uf.
             * 
             * @param value
             *     allowed object is
             *     {@link TUf }
             *     
             */
            public void setUF(TUf value) {
                this.uf = value;
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
         *       &lt;sequence&gt;
         *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "cnpj",
            "xNome",
            "uf"
        })
        public static class Emi {

            @XmlElement(name = "CNPJ", required = true)
            protected String cnpj;
            @XmlElement(required = true)
            protected String xNome;
            @XmlElement(name = "UF", required = true)
            @XmlSchemaType(name = "string")
            protected TUf uf;

            /**
             * Obtém o valor da propriedade cnpj.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCNPJ() {
                return cnpj;
            }

            /**
             * Define o valor da propriedade cnpj.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCNPJ(String value) {
                this.cnpj = value;
            }

            /**
             * Obtém o valor da propriedade xNome.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXNome() {
                return xNome;
            }

            /**
             * Define o valor da propriedade xNome.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXNome(String value) {
                this.xNome = value;
            }

            /**
             * Obtém o valor da propriedade uf.
             * 
             * @return
             *     possible object is
             *     {@link TUf }
             *     
             */
            public TUf getUF() {
                return uf;
            }

            /**
             * Define o valor da propriedade uf.
             * 
             * @param value
             *     allowed object is
             *     {@link TUf }
             *     
             */
            public void setUF(TUf value) {
                this.uf = value;
            }

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
     *       &lt;sequence&gt;
     *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
     *         &lt;element name="PIN" type="{http://www.portalfiscal.inf.br/mdfe}TPIN" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "chNFe",
        "pin"
    })
    public static class InfNFe {

        @XmlElement(required = true)
        protected String chNFe;
        @XmlElement(name = "PIN")
        protected String pin;

        /**
         * Obtém o valor da propriedade chNFe.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getChNFe() {
            return chNFe;
        }

        /**
         * Define o valor da propriedade chNFe.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setChNFe(String value) {
            this.chNFe = value;
        }

        /**
         * Obtém o valor da propriedade pin.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPIN() {
            return pin;
        }

        /**
         * Define o valor da propriedade pin.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPIN(String value) {
            this.pin = value;
        }

    }

}
