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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="infANTT" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="RNTRC" type="{http://www.portalfiscal.inf.br/mdfe}TRNTRC" minOccurs="0"/&gt;
 *                   &lt;element name="infCIOT" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="CIOT"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TCIOT"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
 *                             &lt;/choice&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="valePed" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="disp" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="CNPJForn"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TCnpj"&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;choice minOccurs="0"&gt;
 *                                         &lt;element name="CNPJPg" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
 *                                         &lt;element name="CPFPg" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                                       &lt;/choice&gt;
 *                                       &lt;element name="nCompra"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;pattern value="[0-9]{1,20}"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="vValePed" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="infContratante" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                             &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="veicTracao"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="cInt" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="10"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="placa"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TPlaca"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="RENAVAM" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="9"/&gt;
 *                         &lt;maxLength value="11"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="tara"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;pattern value="0|[1-9]{1}[0-9]{0,5}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="capKG" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;pattern value="0|[1-9]{1}[0-9]{0,5}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="capM3" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;pattern value="0|[1-9]{1}[0-9]{0,2}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="prop" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="RNTRC" type="{http://www.portalfiscal.inf.br/mdfe}TRNTRC"/&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;sequence minOccurs="0"&gt;
 *                               &lt;element name="IE"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TIeDest"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;element name="tpProp"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="0"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="condutor" maxOccurs="10"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="tpRod"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="01"/&gt;
 *                         &lt;enumeration value="02"/&gt;
 *                         &lt;enumeration value="03"/&gt;
 *                         &lt;enumeration value="04"/&gt;
 *                         &lt;enumeration value="05"/&gt;
 *                         &lt;enumeration value="06"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="tpCar"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="00"/&gt;
 *                         &lt;enumeration value="01"/&gt;
 *                         &lt;enumeration value="02"/&gt;
 *                         &lt;enumeration value="03"/&gt;
 *                         &lt;enumeration value="04"/&gt;
 *                         &lt;enumeration value="05"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="veicReboque" maxOccurs="3" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="cInt" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="10"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="placa"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TPlaca"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="RENAVAM" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="9"/&gt;
 *                         &lt;maxLength value="11"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="tara"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;pattern value="0|[1-9]{1}[0-9]{0,5}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="capKG"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;pattern value="0|[1-9]{1}[0-9]{0,5}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="capM3" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;pattern value="0|[1-9]{1}[0-9]{0,2}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="prop" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="RNTRC" type="{http://www.portalfiscal.inf.br/mdfe}TRNTRC"/&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;sequence minOccurs="0"&gt;
 *                               &lt;element name="IE"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TIeDest"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;element name="tpProp"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="0"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="tpCar"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="00"/&gt;
 *                         &lt;enumeration value="01"/&gt;
 *                         &lt;enumeration value="02"/&gt;
 *                         &lt;enumeration value="03"/&gt;
 *                         &lt;enumeration value="04"/&gt;
 *                         &lt;enumeration value="05"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="codAgPorto" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="0"/&gt;
 *               &lt;maxLength value="16"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="lacRodo" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="nLacre"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="20"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
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
@XmlType(name = "", propOrder = {
    "infANTT",
    "veicTracao",
    "veicReboque",
    "codAgPorto",
    "lacRodo"
})
@XmlRootElement(name = "rodo")
public class Rodo {

    protected Rodo.InfANTT infANTT;
    @XmlElement(required = true)
    protected Rodo.VeicTracao veicTracao;
    protected List<Rodo.VeicReboque> veicReboque;
    protected String codAgPorto;
    protected List<Rodo.LacRodo> lacRodo;

    /**
     * Obtém o valor da propriedade infANTT.
     * 
     * @return
     *     possible object is
     *     {@link Rodo.InfANTT }
     *     
     */
    public Rodo.InfANTT getInfANTT() {
        return infANTT;
    }

    /**
     * Define o valor da propriedade infANTT.
     * 
     * @param value
     *     allowed object is
     *     {@link Rodo.InfANTT }
     *     
     */
    public void setInfANTT(Rodo.InfANTT value) {
        this.infANTT = value;
    }

    /**
     * Obtém o valor da propriedade veicTracao.
     * 
     * @return
     *     possible object is
     *     {@link Rodo.VeicTracao }
     *     
     */
    public Rodo.VeicTracao getVeicTracao() {
        return veicTracao;
    }

    /**
     * Define o valor da propriedade veicTracao.
     * 
     * @param value
     *     allowed object is
     *     {@link Rodo.VeicTracao }
     *     
     */
    public void setVeicTracao(Rodo.VeicTracao value) {
        this.veicTracao = value;
    }

    /**
     * Gets the value of the veicReboque property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the veicReboque property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVeicReboque().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rodo.VeicReboque }
     * 
     * 
     */
    public List<Rodo.VeicReboque> getVeicReboque() {
        if (veicReboque == null) {
            veicReboque = new ArrayList<Rodo.VeicReboque>();
        }
        return this.veicReboque;
    }

    /**
     * Obtém o valor da propriedade codAgPorto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAgPorto() {
        return codAgPorto;
    }

    /**
     * Define o valor da propriedade codAgPorto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAgPorto(String value) {
        this.codAgPorto = value;
    }

    /**
     * Gets the value of the lacRodo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lacRodo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLacRodo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rodo.LacRodo }
     * 
     * 
     */
    public List<Rodo.LacRodo> getLacRodo() {
        if (lacRodo == null) {
            lacRodo = new ArrayList<Rodo.LacRodo>();
        }
        return this.lacRodo;
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
     *         &lt;element name="RNTRC" type="{http://www.portalfiscal.inf.br/mdfe}TRNTRC" minOccurs="0"/&gt;
     *         &lt;element name="infCIOT" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="CIOT"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TCIOT"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
     *                   &lt;/choice&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="valePed" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="disp" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="CNPJForn"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TCnpj"&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;choice minOccurs="0"&gt;
     *                               &lt;element name="CNPJPg" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
     *                               &lt;element name="CPFPg" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *                             &lt;/choice&gt;
     *                             &lt;element name="nCompra"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;pattern value="[0-9]{1,20}"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="vValePed" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="infContratante" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *                   &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
     *                 &lt;/choice&gt;
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
    @XmlType(name = "", propOrder = {
        "rntrc",
        "infCIOT",
        "valePed",
        "infContratante"
    })
    public static class InfANTT {

        @XmlElement(name = "RNTRC")
        protected String rntrc;
        protected List<Rodo.InfANTT.InfCIOT> infCIOT;
        protected Rodo.InfANTT.ValePed valePed;
        protected List<Rodo.InfANTT.InfContratante> infContratante;

        /**
         * Obtém o valor da propriedade rntrc.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRNTRC() {
            return rntrc;
        }

        /**
         * Define o valor da propriedade rntrc.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRNTRC(String value) {
            this.rntrc = value;
        }

        /**
         * Gets the value of the infCIOT property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the infCIOT property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInfCIOT().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Rodo.InfANTT.InfCIOT }
         * 
         * 
         */
        public List<Rodo.InfANTT.InfCIOT> getInfCIOT() {
            if (infCIOT == null) {
                infCIOT = new ArrayList<Rodo.InfANTT.InfCIOT>();
            }
            return this.infCIOT;
        }

        /**
         * Obtém o valor da propriedade valePed.
         * 
         * @return
         *     possible object is
         *     {@link Rodo.InfANTT.ValePed }
         *     
         */
        public Rodo.InfANTT.ValePed getValePed() {
            return valePed;
        }

        /**
         * Define o valor da propriedade valePed.
         * 
         * @param value
         *     allowed object is
         *     {@link Rodo.InfANTT.ValePed }
         *     
         */
        public void setValePed(Rodo.InfANTT.ValePed value) {
            this.valePed = value;
        }

        /**
         * Gets the value of the infContratante property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the infContratante property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInfContratante().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Rodo.InfANTT.InfContratante }
         * 
         * 
         */
        public List<Rodo.InfANTT.InfContratante> getInfContratante() {
            if (infContratante == null) {
                infContratante = new ArrayList<Rodo.InfANTT.InfContratante>();
            }
            return this.infContratante;
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
         *         &lt;element name="CIOT"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TCIOT"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;choice&gt;
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
         *         &lt;/choice&gt;
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
            "ciot",
            "cpf",
            "cnpj"
        })
        public static class InfCIOT {

            @XmlElement(name = "CIOT", required = true)
            protected String ciot;
            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(name = "CNPJ")
            protected String cnpj;

            /**
             * Obtém o valor da propriedade ciot.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCIOT() {
                return ciot;
            }

            /**
             * Define o valor da propriedade ciot.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCIOT(String value) {
                this.ciot = value;
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
         *       &lt;choice&gt;
         *         &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
         *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
         *       &lt;/choice&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "cpf",
            "cnpj"
        })
        public static class InfContratante {

            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(name = "CNPJ")
            protected String cnpj;

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
         *         &lt;element name="disp" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="CNPJForn"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TCnpj"&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;choice minOccurs="0"&gt;
         *                     &lt;element name="CNPJPg" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
         *                     &lt;element name="CPFPg" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
         *                   &lt;/choice&gt;
         *                   &lt;element name="nCompra"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;pattern value="[0-9]{1,20}"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="vValePed" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
         *                 &lt;/sequence&gt;
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
        @XmlType(name = "", propOrder = {
            "disp"
        })
        public static class ValePed {

            @XmlElement(required = true)
            protected List<Rodo.InfANTT.ValePed.Disp> disp;

            /**
             * Gets the value of the disp property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the disp property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDisp().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Rodo.InfANTT.ValePed.Disp }
             * 
             * 
             */
            public List<Rodo.InfANTT.ValePed.Disp> getDisp() {
                if (disp == null) {
                    disp = new ArrayList<Rodo.InfANTT.ValePed.Disp>();
                }
                return this.disp;
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
             *         &lt;element name="CNPJForn"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TCnpj"&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;choice minOccurs="0"&gt;
             *           &lt;element name="CNPJPg" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
             *           &lt;element name="CPFPg" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
             *         &lt;/choice&gt;
             *         &lt;element name="nCompra"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;pattern value="[0-9]{1,20}"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="vValePed" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
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
                "cnpjForn",
                "cnpjPg",
                "cpfPg",
                "nCompra",
                "vValePed"
            })
            public static class Disp {

                @XmlElement(name = "CNPJForn", required = true)
                protected String cnpjForn;
                @XmlElement(name = "CNPJPg")
                protected String cnpjPg;
                @XmlElement(name = "CPFPg")
                protected String cpfPg;
                @XmlElement(required = true)
                protected String nCompra;
                @XmlElement(required = true)
                protected String vValePed;

                /**
                 * Obtém o valor da propriedade cnpjForn.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCNPJForn() {
                    return cnpjForn;
                }

                /**
                 * Define o valor da propriedade cnpjForn.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCNPJForn(String value) {
                    this.cnpjForn = value;
                }

                /**
                 * Obtém o valor da propriedade cnpjPg.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCNPJPg() {
                    return cnpjPg;
                }

                /**
                 * Define o valor da propriedade cnpjPg.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCNPJPg(String value) {
                    this.cnpjPg = value;
                }

                /**
                 * Obtém o valor da propriedade cpfPg.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCPFPg() {
                    return cpfPg;
                }

                /**
                 * Define o valor da propriedade cpfPg.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCPFPg(String value) {
                    this.cpfPg = value;
                }

                /**
                 * Obtém o valor da propriedade nCompra.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNCompra() {
                    return nCompra;
                }

                /**
                 * Define o valor da propriedade nCompra.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNCompra(String value) {
                    this.nCompra = value;
                }

                /**
                 * Obtém o valor da propriedade vValePed.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVValePed() {
                    return vValePed;
                }

                /**
                 * Define o valor da propriedade vValePed.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVValePed(String value) {
                    this.vValePed = value;
                }

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
     *         &lt;element name="nLacre"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="20"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
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
    @XmlType(name = "", propOrder = {
        "nLacre"
    })
    public static class LacRodo {

        @XmlElement(required = true)
        protected String nLacre;

        /**
         * Obtém o valor da propriedade nLacre.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNLacre() {
            return nLacre;
        }

        /**
         * Define o valor da propriedade nLacre.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNLacre(String value) {
            this.nLacre = value;
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
     *         &lt;element name="cInt" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="10"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="placa"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TPlaca"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="RENAVAM" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="9"/&gt;
     *               &lt;maxLength value="11"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="tara"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;pattern value="0|[1-9]{1}[0-9]{0,5}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="capKG"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;pattern value="0|[1-9]{1}[0-9]{0,5}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="capM3" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;pattern value="0|[1-9]{1}[0-9]{0,2}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="prop" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="RNTRC" type="{http://www.portalfiscal.inf.br/mdfe}TRNTRC"/&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;sequence minOccurs="0"&gt;
     *                     &lt;element name="IE"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TIeDest"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
     *                   &lt;/sequence&gt;
     *                   &lt;element name="tpProp"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="0"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="tpCar"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="00"/&gt;
     *               &lt;enumeration value="01"/&gt;
     *               &lt;enumeration value="02"/&gt;
     *               &lt;enumeration value="03"/&gt;
     *               &lt;enumeration value="04"/&gt;
     *               &lt;enumeration value="05"/&gt;
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
        "cInt",
        "placa",
        "renavam",
        "tara",
        "capKG",
        "capM3",
        "prop",
        "tpCar",
        "uf"
    })
    public static class VeicReboque {

        protected String cInt;
        @XmlElement(required = true)
        protected String placa;
        @XmlElement(name = "RENAVAM")
        protected String renavam;
        @XmlElement(required = true)
        protected String tara;
        @XmlElement(required = true)
        protected String capKG;
        protected String capM3;
        protected Rodo.VeicReboque.Prop prop;
        @XmlElement(required = true)
        protected String tpCar;
        @XmlElement(name = "UF", required = true)
        @XmlSchemaType(name = "string")
        protected TUf uf;

        /**
         * Obtém o valor da propriedade cInt.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCInt() {
            return cInt;
        }

        /**
         * Define o valor da propriedade cInt.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCInt(String value) {
            this.cInt = value;
        }

        /**
         * Obtém o valor da propriedade placa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlaca() {
            return placa;
        }

        /**
         * Define o valor da propriedade placa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlaca(String value) {
            this.placa = value;
        }

        /**
         * Obtém o valor da propriedade renavam.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRENAVAM() {
            return renavam;
        }

        /**
         * Define o valor da propriedade renavam.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRENAVAM(String value) {
            this.renavam = value;
        }

        /**
         * Obtém o valor da propriedade tara.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTara() {
            return tara;
        }

        /**
         * Define o valor da propriedade tara.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTara(String value) {
            this.tara = value;
        }

        /**
         * Obtém o valor da propriedade capKG.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCapKG() {
            return capKG;
        }

        /**
         * Define o valor da propriedade capKG.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCapKG(String value) {
            this.capKG = value;
        }

        /**
         * Obtém o valor da propriedade capM3.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCapM3() {
            return capM3;
        }

        /**
         * Define o valor da propriedade capM3.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCapM3(String value) {
            this.capM3 = value;
        }

        /**
         * Obtém o valor da propriedade prop.
         * 
         * @return
         *     possible object is
         *     {@link Rodo.VeicReboque.Prop }
         *     
         */
        public Rodo.VeicReboque.Prop getProp() {
            return prop;
        }

        /**
         * Define o valor da propriedade prop.
         * 
         * @param value
         *     allowed object is
         *     {@link Rodo.VeicReboque.Prop }
         *     
         */
        public void setProp(Rodo.VeicReboque.Prop value) {
            this.prop = value;
        }

        /**
         * Obtém o valor da propriedade tpCar.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTpCar() {
            return tpCar;
        }

        /**
         * Define o valor da propriedade tpCar.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTpCar(String value) {
            this.tpCar = value;
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
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="RNTRC" type="{http://www.portalfiscal.inf.br/mdfe}TRNTRC"/&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;sequence minOccurs="0"&gt;
         *           &lt;element name="IE"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TIeDest"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *           &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
         *         &lt;/sequence&gt;
         *         &lt;element name="tpProp"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="0"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
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
        @XmlType(name = "", propOrder = {
            "cpf",
            "cnpj",
            "rntrc",
            "xNome",
            "ie",
            "uf",
            "tpProp"
        })
        public static class Prop {

            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(name = "CNPJ")
            protected String cnpj;
            @XmlElement(name = "RNTRC", required = true)
            protected String rntrc;
            @XmlElement(required = true)
            protected String xNome;
            @XmlElement(name = "IE")
            protected String ie;
            @XmlElement(name = "UF")
            @XmlSchemaType(name = "string")
            protected TUf uf;
            @XmlElement(required = true)
            protected String tpProp;

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
             * Obtém o valor da propriedade rntrc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRNTRC() {
                return rntrc;
            }

            /**
             * Define o valor da propriedade rntrc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRNTRC(String value) {
                this.rntrc = value;
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
             * Obtém o valor da propriedade ie.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIE() {
                return ie;
            }

            /**
             * Define o valor da propriedade ie.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIE(String value) {
                this.ie = value;
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

            /**
             * Obtém o valor da propriedade tpProp.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTpProp() {
                return tpProp;
            }

            /**
             * Define o valor da propriedade tpProp.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTpProp(String value) {
                this.tpProp = value;
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
     *         &lt;element name="cInt" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="10"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="placa"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TPlaca"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="RENAVAM" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="9"/&gt;
     *               &lt;maxLength value="11"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="tara"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;pattern value="0|[1-9]{1}[0-9]{0,5}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="capKG" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;pattern value="0|[1-9]{1}[0-9]{0,5}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="capM3" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;pattern value="0|[1-9]{1}[0-9]{0,2}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="prop" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="RNTRC" type="{http://www.portalfiscal.inf.br/mdfe}TRNTRC"/&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;sequence minOccurs="0"&gt;
     *                     &lt;element name="IE"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TIeDest"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
     *                   &lt;/sequence&gt;
     *                   &lt;element name="tpProp"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="0"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="condutor" maxOccurs="10"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="tpRod"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="01"/&gt;
     *               &lt;enumeration value="02"/&gt;
     *               &lt;enumeration value="03"/&gt;
     *               &lt;enumeration value="04"/&gt;
     *               &lt;enumeration value="05"/&gt;
     *               &lt;enumeration value="06"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="tpCar"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="00"/&gt;
     *               &lt;enumeration value="01"/&gt;
     *               &lt;enumeration value="02"/&gt;
     *               &lt;enumeration value="03"/&gt;
     *               &lt;enumeration value="04"/&gt;
     *               &lt;enumeration value="05"/&gt;
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
        "cInt",
        "placa",
        "renavam",
        "tara",
        "capKG",
        "capM3",
        "prop",
        "condutor",
        "tpRod",
        "tpCar",
        "uf"
    })
    public static class VeicTracao {

        protected String cInt;
        @XmlElement(required = true)
        protected String placa;
        @XmlElement(name = "RENAVAM")
        protected String renavam;
        @XmlElement(required = true)
        protected String tara;
        protected String capKG;
        protected String capM3;
        protected Rodo.VeicTracao.Prop prop;
        @XmlElement(required = true)
        protected List<Rodo.VeicTracao.Condutor> condutor;
        @XmlElement(required = true)
        protected String tpRod;
        @XmlElement(required = true)
        protected String tpCar;
        @XmlElement(name = "UF", required = true)
        @XmlSchemaType(name = "string")
        protected TUf uf;

        /**
         * Obtém o valor da propriedade cInt.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCInt() {
            return cInt;
        }

        /**
         * Define o valor da propriedade cInt.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCInt(String value) {
            this.cInt = value;
        }

        /**
         * Obtém o valor da propriedade placa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlaca() {
            return placa;
        }

        /**
         * Define o valor da propriedade placa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlaca(String value) {
            this.placa = value;
        }

        /**
         * Obtém o valor da propriedade renavam.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRENAVAM() {
            return renavam;
        }

        /**
         * Define o valor da propriedade renavam.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRENAVAM(String value) {
            this.renavam = value;
        }

        /**
         * Obtém o valor da propriedade tara.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTara() {
            return tara;
        }

        /**
         * Define o valor da propriedade tara.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTara(String value) {
            this.tara = value;
        }

        /**
         * Obtém o valor da propriedade capKG.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCapKG() {
            return capKG;
        }

        /**
         * Define o valor da propriedade capKG.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCapKG(String value) {
            this.capKG = value;
        }

        /**
         * Obtém o valor da propriedade capM3.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCapM3() {
            return capM3;
        }

        /**
         * Define o valor da propriedade capM3.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCapM3(String value) {
            this.capM3 = value;
        }

        /**
         * Obtém o valor da propriedade prop.
         * 
         * @return
         *     possible object is
         *     {@link Rodo.VeicTracao.Prop }
         *     
         */
        public Rodo.VeicTracao.Prop getProp() {
            return prop;
        }

        /**
         * Define o valor da propriedade prop.
         * 
         * @param value
         *     allowed object is
         *     {@link Rodo.VeicTracao.Prop }
         *     
         */
        public void setProp(Rodo.VeicTracao.Prop value) {
            this.prop = value;
        }

        /**
         * Gets the value of the condutor property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the condutor property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCondutor().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Rodo.VeicTracao.Condutor }
         * 
         * 
         */
        public List<Rodo.VeicTracao.Condutor> getCondutor() {
            if (condutor == null) {
                condutor = new ArrayList<Rodo.VeicTracao.Condutor>();
            }
            return this.condutor;
        }

        /**
         * Obtém o valor da propriedade tpRod.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTpRod() {
            return tpRod;
        }

        /**
         * Define o valor da propriedade tpRod.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTpRod(String value) {
            this.tpRod = value;
        }

        /**
         * Obtém o valor da propriedade tpCar.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTpCar() {
            return tpCar;
        }

        /**
         * Define o valor da propriedade tpCar.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTpCar(String value) {
            this.tpCar = value;
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
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
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
            "xNome",
            "cpf"
        })
        public static class Condutor {

            @XmlElement(required = true)
            protected String xNome;
            @XmlElement(name = "CPF", required = true)
            protected String cpf;

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
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="RNTRC" type="{http://www.portalfiscal.inf.br/mdfe}TRNTRC"/&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;sequence minOccurs="0"&gt;
         *           &lt;element name="IE"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TIeDest"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *           &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
         *         &lt;/sequence&gt;
         *         &lt;element name="tpProp"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="0"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
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
        @XmlType(name = "", propOrder = {
            "cpf",
            "cnpj",
            "rntrc",
            "xNome",
            "ie",
            "uf",
            "tpProp"
        })
        public static class Prop {

            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(name = "CNPJ")
            protected String cnpj;
            @XmlElement(name = "RNTRC", required = true)
            protected String rntrc;
            @XmlElement(required = true)
            protected String xNome;
            @XmlElement(name = "IE")
            protected String ie;
            @XmlElement(name = "UF")
            @XmlSchemaType(name = "string")
            protected TUf uf;
            @XmlElement(required = true)
            protected String tpProp;

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
             * Obtém o valor da propriedade rntrc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRNTRC() {
                return rntrc;
            }

            /**
             * Define o valor da propriedade rntrc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRNTRC(String value) {
                this.rntrc = value;
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
             * Obtém o valor da propriedade ie.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIE() {
                return ie;
            }

            /**
             * Define o valor da propriedade ie.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIE(String value) {
                this.ie = value;
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

            /**
             * Obtém o valor da propriedade tpProp.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTpProp() {
                return tpProp;
            }

            /**
             * Define o valor da propriedade tpProp.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTpProp(String value) {
                this.tpProp = value;
            }

        }

    }

}
