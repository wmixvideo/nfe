//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.10.07 às 11:09:41 PM BRT 
//


package com.fincatto.documentofiscal.nfse.xmlsignature;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TCInfPedReg complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfPedReg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpAmb" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoAmbiente"/>
 *         &lt;element name="verAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSVerAplic"/>
 *         &lt;element name="dhEvento" type="{http://www.sped.fazenda.gov.br/nfse}TSDateTimeUTC"/>
 *         &lt;choice>
 *           &lt;element name="CNPJAutor" type="{http://www.sped.fazenda.gov.br/nfse}TSCNPJ"/>
 *           &lt;element name="CPFAutor" type="{http://www.sped.fazenda.gov.br/nfse}TSCPF"/>
 *         &lt;/choice>
 *         &lt;element name="chNFSe" type="{http://www.sped.fazenda.gov.br/nfse}TSChaveNFSe"/>
 *         &lt;element name="nPedRegEvento" type="{http://www.sped.fazenda.gov.br/nfse}TSNum3Dig"/>
 *         &lt;choice>
 *           &lt;element name="e101101" type="{http://www.sped.fazenda.gov.br/nfse}TE101101"/>
 *           &lt;element name="e105102" type="{http://www.sped.fazenda.gov.br/nfse}TE105102"/>
 *           &lt;element name="e101103" type="{http://www.sped.fazenda.gov.br/nfse}TE101103"/>
 *           &lt;element name="e105104" type="{http://www.sped.fazenda.gov.br/nfse}TE105104"/>
 *           &lt;element name="e105105" type="{http://www.sped.fazenda.gov.br/nfse}TE105105"/>
 *           &lt;element name="e202201" type="{http://www.sped.fazenda.gov.br/nfse}TE202201"/>
 *           &lt;element name="e203202" type="{http://www.sped.fazenda.gov.br/nfse}TE203202"/>
 *           &lt;element name="e204203" type="{http://www.sped.fazenda.gov.br/nfse}TE204203"/>
 *           &lt;element name="e205204" type="{http://www.sped.fazenda.gov.br/nfse}TE205204"/>
 *           &lt;element name="e202205" type="{http://www.sped.fazenda.gov.br/nfse}TE202205"/>
 *           &lt;element name="e203206" type="{http://www.sped.fazenda.gov.br/nfse}TE203206"/>
 *           &lt;element name="e204207" type="{http://www.sped.fazenda.gov.br/nfse}TE204207"/>
 *           &lt;element name="e205208" type="{http://www.sped.fazenda.gov.br/nfse}TE205208"/>
 *           &lt;element name="e305101" type="{http://www.sped.fazenda.gov.br/nfse}TE305101"/>
 *           &lt;element name="e305102" type="{http://www.sped.fazenda.gov.br/nfse}TE305102"/>
 *           &lt;element name="e305103" type="{http://www.sped.fazenda.gov.br/nfse}TE305103"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.sped.fazenda.gov.br/nfse}TSIdPedRefEvt" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCInfPedReg", propOrder = {
    "tpAmb",
    "verAplic",
    "dhEvento",
    "cnpjAutor",
    "cpfAutor",
    "chNFSe",
    "nPedRegEvento",
    "e101101",
    "e105102",
    "e101103",
    "e105104",
    "e105105",
    "e202201",
    "e203202",
    "e204203",
    "e205204",
    "e202205",
    "e203206",
    "e204207",
    "e205208",
    "e305101",
    "e305102",
    "e305103"
})
public class TCInfPedReg {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String dhEvento;
    @XmlElement(name = "CNPJAutor")
    protected String cnpjAutor;
    @XmlElement(name = "CPFAutor")
    protected String cpfAutor;
    @XmlElement(required = true)
    protected String chNFSe;
    @XmlElement(required = true)
    protected String nPedRegEvento;
    protected TE101101 e101101;
    protected TE105102 e105102;
    protected TE101103 e101103;
    protected TE105104 e105104;
    protected TE105105 e105105;
    protected TE202201 e202201;
    protected TE203202 e203202;
    protected TE204203 e204203;
    protected TE205204 e205204;
    protected TE202205 e202205;
    protected TE203206 e203206;
    protected TE204207 e204207;
    protected TE205208 e205208;
    protected TE305101 e305101;
    protected TE305102 e305102;
    protected TE305103 e305103;
    @XmlAttribute(name = "Id", required = true)
    protected String id;

    /**
     * Obtém o valor da propriedade tpAmb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * Define o valor da propriedade tpAmb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpAmb(String value) {
        this.tpAmb = value;
    }

    /**
     * Obtém o valor da propriedade verAplic.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * Define o valor da propriedade verAplic.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerAplic(String value) {
        this.verAplic = value;
    }

    /**
     * Obtém o valor da propriedade dhEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhEvento() {
        return dhEvento;
    }

    /**
     * Define o valor da propriedade dhEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhEvento(String value) {
        this.dhEvento = value;
    }

    /**
     * Obtém o valor da propriedade cnpjAutor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNPJAutor() {
        return cnpjAutor;
    }

    /**
     * Define o valor da propriedade cnpjAutor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNPJAutor(String value) {
        this.cnpjAutor = value;
    }

    /**
     * Obtém o valor da propriedade cpfAutor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPFAutor() {
        return cpfAutor;
    }

    /**
     * Define o valor da propriedade cpfAutor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPFAutor(String value) {
        this.cpfAutor = value;
    }

    /**
     * Obtém o valor da propriedade chNFSe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChNFSe() {
        return chNFSe;
    }

    /**
     * Define o valor da propriedade chNFSe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChNFSe(String value) {
        this.chNFSe = value;
    }

    /**
     * Obtém o valor da propriedade nPedRegEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNPedRegEvento() {
        return nPedRegEvento;
    }

    /**
     * Define o valor da propriedade nPedRegEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNPedRegEvento(String value) {
        this.nPedRegEvento = value;
    }

    /**
     * Obtém o valor da propriedade e101101.
     * 
     * @return
     *     possible object is
     *     {@link TE101101 }
     *     
     */
    public TE101101 getE101101() {
        return e101101;
    }

    /**
     * Define o valor da propriedade e101101.
     * 
     * @param value
     *     allowed object is
     *     {@link TE101101 }
     *     
     */
    public void setE101101(TE101101 value) {
        this.e101101 = value;
    }

    /**
     * Obtém o valor da propriedade e105102.
     * 
     * @return
     *     possible object is
     *     {@link TE105102 }
     *     
     */
    public TE105102 getE105102() {
        return e105102;
    }

    /**
     * Define o valor da propriedade e105102.
     * 
     * @param value
     *     allowed object is
     *     {@link TE105102 }
     *     
     */
    public void setE105102(TE105102 value) {
        this.e105102 = value;
    }

    /**
     * Obtém o valor da propriedade e101103.
     * 
     * @return
     *     possible object is
     *     {@link TE101103 }
     *     
     */
    public TE101103 getE101103() {
        return e101103;
    }

    /**
     * Define o valor da propriedade e101103.
     * 
     * @param value
     *     allowed object is
     *     {@link TE101103 }
     *     
     */
    public void setE101103(TE101103 value) {
        this.e101103 = value;
    }

    /**
     * Obtém o valor da propriedade e105104.
     * 
     * @return
     *     possible object is
     *     {@link TE105104 }
     *     
     */
    public TE105104 getE105104() {
        return e105104;
    }

    /**
     * Define o valor da propriedade e105104.
     * 
     * @param value
     *     allowed object is
     *     {@link TE105104 }
     *     
     */
    public void setE105104(TE105104 value) {
        this.e105104 = value;
    }

    /**
     * Obtém o valor da propriedade e105105.
     * 
     * @return
     *     possible object is
     *     {@link TE105105 }
     *     
     */
    public TE105105 getE105105() {
        return e105105;
    }

    /**
     * Define o valor da propriedade e105105.
     * 
     * @param value
     *     allowed object is
     *     {@link TE105105 }
     *     
     */
    public void setE105105(TE105105 value) {
        this.e105105 = value;
    }

    /**
     * Obtém o valor da propriedade e202201.
     * 
     * @return
     *     possible object is
     *     {@link TE202201 }
     *     
     */
    public TE202201 getE202201() {
        return e202201;
    }

    /**
     * Define o valor da propriedade e202201.
     * 
     * @param value
     *     allowed object is
     *     {@link TE202201 }
     *     
     */
    public void setE202201(TE202201 value) {
        this.e202201 = value;
    }

    /**
     * Obtém o valor da propriedade e203202.
     * 
     * @return
     *     possible object is
     *     {@link TE203202 }
     *     
     */
    public TE203202 getE203202() {
        return e203202;
    }

    /**
     * Define o valor da propriedade e203202.
     * 
     * @param value
     *     allowed object is
     *     {@link TE203202 }
     *     
     */
    public void setE203202(TE203202 value) {
        this.e203202 = value;
    }

    /**
     * Obtém o valor da propriedade e204203.
     * 
     * @return
     *     possible object is
     *     {@link TE204203 }
     *     
     */
    public TE204203 getE204203() {
        return e204203;
    }

    /**
     * Define o valor da propriedade e204203.
     * 
     * @param value
     *     allowed object is
     *     {@link TE204203 }
     *     
     */
    public void setE204203(TE204203 value) {
        this.e204203 = value;
    }

    /**
     * Obtém o valor da propriedade e205204.
     * 
     * @return
     *     possible object is
     *     {@link TE205204 }
     *     
     */
    public TE205204 getE205204() {
        return e205204;
    }

    /**
     * Define o valor da propriedade e205204.
     * 
     * @param value
     *     allowed object is
     *     {@link TE205204 }
     *     
     */
    public void setE205204(TE205204 value) {
        this.e205204 = value;
    }

    /**
     * Obtém o valor da propriedade e202205.
     * 
     * @return
     *     possible object is
     *     {@link TE202205 }
     *     
     */
    public TE202205 getE202205() {
        return e202205;
    }

    /**
     * Define o valor da propriedade e202205.
     * 
     * @param value
     *     allowed object is
     *     {@link TE202205 }
     *     
     */
    public void setE202205(TE202205 value) {
        this.e202205 = value;
    }

    /**
     * Obtém o valor da propriedade e203206.
     * 
     * @return
     *     possible object is
     *     {@link TE203206 }
     *     
     */
    public TE203206 getE203206() {
        return e203206;
    }

    /**
     * Define o valor da propriedade e203206.
     * 
     * @param value
     *     allowed object is
     *     {@link TE203206 }
     *     
     */
    public void setE203206(TE203206 value) {
        this.e203206 = value;
    }

    /**
     * Obtém o valor da propriedade e204207.
     * 
     * @return
     *     possible object is
     *     {@link TE204207 }
     *     
     */
    public TE204207 getE204207() {
        return e204207;
    }

    /**
     * Define o valor da propriedade e204207.
     * 
     * @param value
     *     allowed object is
     *     {@link TE204207 }
     *     
     */
    public void setE204207(TE204207 value) {
        this.e204207 = value;
    }

    /**
     * Obtém o valor da propriedade e205208.
     * 
     * @return
     *     possible object is
     *     {@link TE205208 }
     *     
     */
    public TE205208 getE205208() {
        return e205208;
    }

    /**
     * Define o valor da propriedade e205208.
     * 
     * @param value
     *     allowed object is
     *     {@link TE205208 }
     *     
     */
    public void setE205208(TE205208 value) {
        this.e205208 = value;
    }

    /**
     * Obtém o valor da propriedade e305101.
     * 
     * @return
     *     possible object is
     *     {@link TE305101 }
     *     
     */
    public TE305101 getE305101() {
        return e305101;
    }

    /**
     * Define o valor da propriedade e305101.
     * 
     * @param value
     *     allowed object is
     *     {@link TE305101 }
     *     
     */
    public void setE305101(TE305101 value) {
        this.e305101 = value;
    }

    /**
     * Obtém o valor da propriedade e305102.
     * 
     * @return
     *     possible object is
     *     {@link TE305102 }
     *     
     */
    public TE305102 getE305102() {
        return e305102;
    }

    /**
     * Define o valor da propriedade e305102.
     * 
     * @param value
     *     allowed object is
     *     {@link TE305102 }
     *     
     */
    public void setE305102(TE305102 value) {
        this.e305102 = value;
    }

    /**
     * Obtém o valor da propriedade e305103.
     * 
     * @return
     *     possible object is
     *     {@link TE305103 }
     *     
     */
    public TE305103 getE305103() {
        return e305103;
    }

    /**
     * Define o valor da propriedade e305103.
     * 
     * @param value
     *     allowed object is
     *     {@link TE305103 }
     *     
     */
    public void setE305103(TE305103 value) {
        this.e305103 = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
