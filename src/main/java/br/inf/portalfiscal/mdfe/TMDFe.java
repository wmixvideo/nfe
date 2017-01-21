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
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2000._09.xmldsig_.SignatureType;
import org.w3c.dom.Element;


/**
 * Tipo Manifesto de Documentos Fiscais Eletrônicos
 * 
 * <p>Classe Java de TMDFe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TMDFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infMDFe"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ide"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/mdfe}TCodUfIBGE"/&gt;
 *                             &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/mdfe}TAmb"/&gt;
 *                             &lt;element name="tpEmit" type="{http://www.portalfiscal.inf.br/mdfe}TEmit"/&gt;
 *                             &lt;element name="tpTransp" type="{http://www.portalfiscal.inf.br/mdfe}TTransp" minOccurs="0"/&gt;
 *                             &lt;element name="mod" type="{http://www.portalfiscal.inf.br/mdfe}TModMD"/&gt;
 *                             &lt;element name="serie" type="{http://www.portalfiscal.inf.br/mdfe}TSerie"/&gt;
 *                             &lt;element name="nMDF" type="{http://www.portalfiscal.inf.br/mdfe}TNF"/&gt;
 *                             &lt;element name="cMDF"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;pattern value="[0-9]{8}"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="cDV"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;pattern value="[0-9]{1}"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="modal" type="{http://www.portalfiscal.inf.br/mdfe}TModalMD"/&gt;
 *                             &lt;element name="dhEmi" type="{http://www.portalfiscal.inf.br/mdfe}TDateTimeUTC"/&gt;
 *                             &lt;element name="tpEmis"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="procEmi"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TProcEmi"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="verProc"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="20"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="UFIni" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *                             &lt;element name="UFFim" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *                             &lt;element name="infMunCarrega" maxOccurs="50"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="cMunCarrega" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
 *                                       &lt;element name="xMunCarrega"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                             &lt;minLength value="2"/&gt;
 *                                             &lt;maxLength value="60"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="infPercurso" maxOccurs="25" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="UFPer" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="dhIniViagem" type="{http://www.portalfiscal.inf.br/mdfe}TDateTimeUTC" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="emit"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
 *                             &lt;element name="IE"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TIe"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xFant" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="enderEmit" type="{http://www.portalfiscal.inf.br/mdfe}TEndeEmi"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="infModal"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;any processContents='skip'/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="versaoModal" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;whiteSpace value="preserve"/&gt;
 *                                 &lt;pattern value="3\.(0[0-9]|[1-9][0-9])"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="infDoc"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="infMunDescarga" maxOccurs="100"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="cMunDescarga" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
 *                                       &lt;element name="xMunDescarga"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                             &lt;minLength value="2"/&gt;
 *                                             &lt;maxLength value="60"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="infCTe" maxOccurs="4000" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/mdfe}TChCTe"/&gt;
 *                                                 &lt;element name="SegCodBarra" type="{http://www.portalfiscal.inf.br/mdfe}TSegCodBarra" minOccurs="0"/&gt;
 *                                                 &lt;element name="indReentrega" minOccurs="0"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                       &lt;enumeration value="1"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                                 &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="nONU"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                 &lt;whiteSpace value="preserve"/&gt;
 *                                                                 &lt;pattern value="[0-9]{4}|ND"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="xNomeAE" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="150"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="xClaRisco" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="40"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="grEmb" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="6"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="qTotProd"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="20"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="qVolTipo" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="60"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                         &lt;/sequence&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="infNFe" maxOccurs="4000" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
 *                                                 &lt;element name="SegCodBarra" type="{http://www.portalfiscal.inf.br/mdfe}TSegCodBarra" minOccurs="0"/&gt;
 *                                                 &lt;element name="indReentrega" minOccurs="0"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                       &lt;enumeration value="1"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                                 &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="nONU"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                 &lt;whiteSpace value="preserve"/&gt;
 *                                                                 &lt;pattern value="[0-9]{4}|ND"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="xNomeAE" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="150"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="xClaRisco" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="40"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="grEmb" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="6"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="qTotProd"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="20"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="qVolTipo" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="60"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                         &lt;/sequence&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="infMDFeTransp" maxOccurs="4000" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="chMDFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
 *                                                 &lt;element name="indReentrega" minOccurs="0"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                       &lt;enumeration value="1"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                                 &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="nONU"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                 &lt;whiteSpace value="preserve"/&gt;
 *                                                                 &lt;pattern value="[0-9]{4}|ND"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="xNomeAE" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="150"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="xClaRisco" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="40"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="grEmb" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="6"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="qTotProd"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="20"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="qVolTipo" minOccurs="0"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                                                 &lt;minLength value="1"/&gt;
 *                                                                 &lt;maxLength value="60"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                         &lt;/sequence&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
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
 *                   &lt;element name="seg" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="infResp"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="respSeg"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;whiteSpace value="preserve"/&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="1"/&gt;
 *                                             &lt;enumeration value="1"/&gt;
 *                                             &lt;enumeration value="2"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;choice minOccurs="0"&gt;
 *                                         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
 *                                         &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                                       &lt;/choice&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="infSeg" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="xSeg"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="30"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="nApol" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="20"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="nAver" maxOccurs="unbounded" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="40"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="tot"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="qCTe" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;pattern value="[0-9]{1,6}"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="qNFe" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;pattern value="[0-9]{1,6}"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="qMDFe" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;pattern value="[0-9]{1,6}"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="vCarga" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
 *                             &lt;element name="cUnid"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="01"/&gt;
 *                                   &lt;enumeration value="02"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="qCarga" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1104"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="lacres" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="nLacre"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="autXML" maxOccurs="10" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                             &lt;/choice&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="infAdic" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="infAdFisco" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="2000"/&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="infCpl" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="5000"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerMDe" /&gt;
 *                 &lt;attribute name="Id" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID"&gt;
 *                       &lt;pattern value="MDFe[0-9]{44}"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TMDFe", propOrder = {
    "infMDFe",
    "signature"
})
public class TMDFe {

    @XmlElement(required = true)
    protected TMDFe.InfMDFe infMDFe;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    protected SignatureType signature;

    /**
     * Obtém o valor da propriedade infMDFe.
     * 
     * @return
     *     possible object is
     *     {@link TMDFe.InfMDFe }
     *     
     */
    public TMDFe.InfMDFe getInfMDFe() {
        return infMDFe;
    }

    /**
     * Define o valor da propriedade infMDFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TMDFe.InfMDFe }
     *     
     */
    public void setInfMDFe(TMDFe.InfMDFe value) {
        this.infMDFe = value;
    }

    /**
     * Obtém o valor da propriedade signature.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Define o valor da propriedade signature.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
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
     *         &lt;element name="ide"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/mdfe}TCodUfIBGE"/&gt;
     *                   &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/mdfe}TAmb"/&gt;
     *                   &lt;element name="tpEmit" type="{http://www.portalfiscal.inf.br/mdfe}TEmit"/&gt;
     *                   &lt;element name="tpTransp" type="{http://www.portalfiscal.inf.br/mdfe}TTransp" minOccurs="0"/&gt;
     *                   &lt;element name="mod" type="{http://www.portalfiscal.inf.br/mdfe}TModMD"/&gt;
     *                   &lt;element name="serie" type="{http://www.portalfiscal.inf.br/mdfe}TSerie"/&gt;
     *                   &lt;element name="nMDF" type="{http://www.portalfiscal.inf.br/mdfe}TNF"/&gt;
     *                   &lt;element name="cMDF"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;pattern value="[0-9]{8}"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="cDV"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;pattern value="[0-9]{1}"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="modal" type="{http://www.portalfiscal.inf.br/mdfe}TModalMD"/&gt;
     *                   &lt;element name="dhEmi" type="{http://www.portalfiscal.inf.br/mdfe}TDateTimeUTC"/&gt;
     *                   &lt;element name="tpEmis"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="procEmi"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TProcEmi"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="verProc"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="20"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="UFIni" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
     *                   &lt;element name="UFFim" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
     *                   &lt;element name="infMunCarrega" maxOccurs="50"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="cMunCarrega" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
     *                             &lt;element name="xMunCarrega"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                   &lt;minLength value="2"/&gt;
     *                                   &lt;maxLength value="60"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="infPercurso" maxOccurs="25" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="UFPer" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="dhIniViagem" type="{http://www.portalfiscal.inf.br/mdfe}TDateTimeUTC" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="emit"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
     *                   &lt;element name="IE"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TIe"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xFant" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="enderEmit" type="{http://www.portalfiscal.inf.br/mdfe}TEndeEmi"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="infModal"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;any processContents='skip'/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="versaoModal" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;whiteSpace value="preserve"/&gt;
     *                       &lt;pattern value="3\.(0[0-9]|[1-9][0-9])"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="infDoc"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="infMunDescarga" maxOccurs="100"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="cMunDescarga" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
     *                             &lt;element name="xMunDescarga"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                   &lt;minLength value="2"/&gt;
     *                                   &lt;maxLength value="60"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="infCTe" maxOccurs="4000" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/mdfe}TChCTe"/&gt;
     *                                       &lt;element name="SegCodBarra" type="{http://www.portalfiscal.inf.br/mdfe}TSegCodBarra" minOccurs="0"/&gt;
     *                                       &lt;element name="indReentrega" minOccurs="0"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                             &lt;enumeration value="1"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                                       &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="nONU"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                       &lt;whiteSpace value="preserve"/&gt;
     *                                                       &lt;pattern value="[0-9]{4}|ND"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="xNomeAE" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="150"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="xClaRisco" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="40"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="grEmb" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="6"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="qTotProd"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="20"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="qVolTipo" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="60"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                               &lt;/sequence&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="infNFe" maxOccurs="4000" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
     *                                       &lt;element name="SegCodBarra" type="{http://www.portalfiscal.inf.br/mdfe}TSegCodBarra" minOccurs="0"/&gt;
     *                                       &lt;element name="indReentrega" minOccurs="0"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                             &lt;enumeration value="1"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                                       &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="nONU"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                       &lt;whiteSpace value="preserve"/&gt;
     *                                                       &lt;pattern value="[0-9]{4}|ND"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="xNomeAE" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="150"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="xClaRisco" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="40"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="grEmb" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="6"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="qTotProd"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="20"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="qVolTipo" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="60"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                               &lt;/sequence&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="infMDFeTransp" maxOccurs="4000" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="chMDFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
     *                                       &lt;element name="indReentrega" minOccurs="0"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                             &lt;enumeration value="1"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                                       &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="nONU"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                       &lt;whiteSpace value="preserve"/&gt;
     *                                                       &lt;pattern value="[0-9]{4}|ND"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="xNomeAE" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="150"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="xClaRisco" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="40"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="grEmb" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="6"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="qTotProd"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="20"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="qVolTipo" minOccurs="0"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                                       &lt;minLength value="1"/&gt;
     *                                                       &lt;maxLength value="60"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                               &lt;/sequence&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
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
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="seg" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="infResp"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="respSeg"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;whiteSpace value="preserve"/&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="1"/&gt;
     *                                   &lt;enumeration value="1"/&gt;
     *                                   &lt;enumeration value="2"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;choice minOccurs="0"&gt;
     *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
     *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *                             &lt;/choice&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="infSeg" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="xSeg"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="30"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="nApol" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="20"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="nAver" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="40"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="tot"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="qCTe" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;pattern value="[0-9]{1,6}"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="qNFe" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;pattern value="[0-9]{1,6}"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="qMDFe" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;pattern value="[0-9]{1,6}"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="vCarga" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
     *                   &lt;element name="cUnid"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="01"/&gt;
     *                         &lt;enumeration value="02"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="qCarga" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1104"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="lacres" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="nLacre"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="autXML" maxOccurs="10" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *                   &lt;/choice&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="infAdic" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="infAdFisco" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="2000"/&gt;
     *                         &lt;minLength value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="infCpl" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="5000"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerMDe" /&gt;
     *       &lt;attribute name="Id" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID"&gt;
     *             &lt;pattern value="MDFe[0-9]{44}"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ide",
        "emit",
        "infModal",
        "infDoc",
        "seg",
        "tot",
        "lacres",
        "autXML",
        "infAdic"
    })
    public static class InfMDFe {

        @XmlElement(required = true)
        protected TMDFe.InfMDFe.Ide ide;
        @XmlElement(required = true)
        protected TMDFe.InfMDFe.Emit emit;
        @XmlElement(required = true)
        protected TMDFe.InfMDFe.InfModal infModal;
        @XmlElement(required = true)
        protected TMDFe.InfMDFe.InfDoc infDoc;
        protected List<TMDFe.InfMDFe.Seg> seg;
        @XmlElement(required = true)
        protected TMDFe.InfMDFe.Tot tot;
        protected List<TMDFe.InfMDFe.Lacres> lacres;
        protected List<TMDFe.InfMDFe.AutXML> autXML;
        protected TMDFe.InfMDFe.InfAdic infAdic;
        @XmlAttribute(name = "versao", required = true)
        protected String versao;
        @XmlAttribute(name = "Id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        protected String id;

        /**
         * Obtém o valor da propriedade ide.
         * 
         * @return
         *     possible object is
         *     {@link TMDFe.InfMDFe.Ide }
         *     
         */
        public TMDFe.InfMDFe.Ide getIde() {
            return ide;
        }

        /**
         * Define o valor da propriedade ide.
         * 
         * @param value
         *     allowed object is
         *     {@link TMDFe.InfMDFe.Ide }
         *     
         */
        public void setIde(TMDFe.InfMDFe.Ide value) {
            this.ide = value;
        }

        /**
         * Obtém o valor da propriedade emit.
         * 
         * @return
         *     possible object is
         *     {@link TMDFe.InfMDFe.Emit }
         *     
         */
        public TMDFe.InfMDFe.Emit getEmit() {
            return emit;
        }

        /**
         * Define o valor da propriedade emit.
         * 
         * @param value
         *     allowed object is
         *     {@link TMDFe.InfMDFe.Emit }
         *     
         */
        public void setEmit(TMDFe.InfMDFe.Emit value) {
            this.emit = value;
        }

        /**
         * Obtém o valor da propriedade infModal.
         * 
         * @return
         *     possible object is
         *     {@link TMDFe.InfMDFe.InfModal }
         *     
         */
        public TMDFe.InfMDFe.InfModal getInfModal() {
            return infModal;
        }

        /**
         * Define o valor da propriedade infModal.
         * 
         * @param value
         *     allowed object is
         *     {@link TMDFe.InfMDFe.InfModal }
         *     
         */
        public void setInfModal(TMDFe.InfMDFe.InfModal value) {
            this.infModal = value;
        }

        /**
         * Obtém o valor da propriedade infDoc.
         * 
         * @return
         *     possible object is
         *     {@link TMDFe.InfMDFe.InfDoc }
         *     
         */
        public TMDFe.InfMDFe.InfDoc getInfDoc() {
            return infDoc;
        }

        /**
         * Define o valor da propriedade infDoc.
         * 
         * @param value
         *     allowed object is
         *     {@link TMDFe.InfMDFe.InfDoc }
         *     
         */
        public void setInfDoc(TMDFe.InfMDFe.InfDoc value) {
            this.infDoc = value;
        }

        /**
         * Gets the value of the seg property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the seg property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSeg().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TMDFe.InfMDFe.Seg }
         * 
         * 
         */
        public List<TMDFe.InfMDFe.Seg> getSeg() {
            if (seg == null) {
                seg = new ArrayList<TMDFe.InfMDFe.Seg>();
            }
            return this.seg;
        }

        /**
         * Obtém o valor da propriedade tot.
         * 
         * @return
         *     possible object is
         *     {@link TMDFe.InfMDFe.Tot }
         *     
         */
        public TMDFe.InfMDFe.Tot getTot() {
            return tot;
        }

        /**
         * Define o valor da propriedade tot.
         * 
         * @param value
         *     allowed object is
         *     {@link TMDFe.InfMDFe.Tot }
         *     
         */
        public void setTot(TMDFe.InfMDFe.Tot value) {
            this.tot = value;
        }

        /**
         * Gets the value of the lacres property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the lacres property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLacres().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TMDFe.InfMDFe.Lacres }
         * 
         * 
         */
        public List<TMDFe.InfMDFe.Lacres> getLacres() {
            if (lacres == null) {
                lacres = new ArrayList<TMDFe.InfMDFe.Lacres>();
            }
            return this.lacres;
        }

        /**
         * Gets the value of the autXML property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the autXML property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAutXML().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TMDFe.InfMDFe.AutXML }
         * 
         * 
         */
        public List<TMDFe.InfMDFe.AutXML> getAutXML() {
            if (autXML == null) {
                autXML = new ArrayList<TMDFe.InfMDFe.AutXML>();
            }
            return this.autXML;
        }

        /**
         * Obtém o valor da propriedade infAdic.
         * 
         * @return
         *     possible object is
         *     {@link TMDFe.InfMDFe.InfAdic }
         *     
         */
        public TMDFe.InfMDFe.InfAdic getInfAdic() {
            return infAdic;
        }

        /**
         * Define o valor da propriedade infAdic.
         * 
         * @param value
         *     allowed object is
         *     {@link TMDFe.InfMDFe.InfAdic }
         *     
         */
        public void setInfAdic(TMDFe.InfMDFe.InfAdic value) {
            this.infAdic = value;
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
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
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
            "cnpj",
            "cpf"
        })
        public static class AutXML {

            @XmlElement(name = "CNPJ")
            protected String cnpj;
            @XmlElement(name = "CPF")
            protected String cpf;

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
         *         &lt;element name="IE"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TIe"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xFant" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="enderEmit" type="{http://www.portalfiscal.inf.br/mdfe}TEndeEmi"/&gt;
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
            "ie",
            "xNome",
            "xFant",
            "enderEmit"
        })
        public static class Emit {

            @XmlElement(name = "CNPJ", required = true)
            protected String cnpj;
            @XmlElement(name = "IE", required = true)
            protected String ie;
            @XmlElement(required = true)
            protected String xNome;
            protected String xFant;
            @XmlElement(required = true)
            protected TEndeEmi enderEmit;

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
             * Obtém o valor da propriedade xFant.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXFant() {
                return xFant;
            }

            /**
             * Define o valor da propriedade xFant.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXFant(String value) {
                this.xFant = value;
            }

            /**
             * Obtém o valor da propriedade enderEmit.
             * 
             * @return
             *     possible object is
             *     {@link TEndeEmi }
             *     
             */
            public TEndeEmi getEnderEmit() {
                return enderEmit;
            }

            /**
             * Define o valor da propriedade enderEmit.
             * 
             * @param value
             *     allowed object is
             *     {@link TEndeEmi }
             *     
             */
            public void setEnderEmit(TEndeEmi value) {
                this.enderEmit = value;
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
         *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/mdfe}TCodUfIBGE"/&gt;
         *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/mdfe}TAmb"/&gt;
         *         &lt;element name="tpEmit" type="{http://www.portalfiscal.inf.br/mdfe}TEmit"/&gt;
         *         &lt;element name="tpTransp" type="{http://www.portalfiscal.inf.br/mdfe}TTransp" minOccurs="0"/&gt;
         *         &lt;element name="mod" type="{http://www.portalfiscal.inf.br/mdfe}TModMD"/&gt;
         *         &lt;element name="serie" type="{http://www.portalfiscal.inf.br/mdfe}TSerie"/&gt;
         *         &lt;element name="nMDF" type="{http://www.portalfiscal.inf.br/mdfe}TNF"/&gt;
         *         &lt;element name="cMDF"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;pattern value="[0-9]{8}"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="cDV"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;pattern value="[0-9]{1}"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="modal" type="{http://www.portalfiscal.inf.br/mdfe}TModalMD"/&gt;
         *         &lt;element name="dhEmi" type="{http://www.portalfiscal.inf.br/mdfe}TDateTimeUTC"/&gt;
         *         &lt;element name="tpEmis"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="procEmi"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TProcEmi"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="verProc"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="20"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="UFIni" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
         *         &lt;element name="UFFim" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
         *         &lt;element name="infMunCarrega" maxOccurs="50"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="cMunCarrega" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
         *                   &lt;element name="xMunCarrega"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                         &lt;minLength value="2"/&gt;
         *                         &lt;maxLength value="60"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="infPercurso" maxOccurs="25" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="UFPer" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="dhIniViagem" type="{http://www.portalfiscal.inf.br/mdfe}TDateTimeUTC" minOccurs="0"/&gt;
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
            "cuf",
            "tpAmb",
            "tpEmit",
            "tpTransp",
            "mod",
            "serie",
            "nmdf",
            "cmdf",
            "cdv",
            "modal",
            "dhEmi",
            "tpEmis",
            "procEmi",
            "verProc",
            "ufIni",
            "ufFim",
            "infMunCarrega",
            "infPercurso",
            "dhIniViagem"
        })
        public static class Ide {

            @XmlElement(name = "cUF", required = true)
            protected String cuf;
            @XmlElement(required = true)
            protected String tpAmb;
            @XmlElement(required = true)
            protected String tpEmit;
            protected String tpTransp;
            @XmlElement(required = true)
            protected String mod;
            @XmlElement(required = true)
            protected String serie;
            @XmlElement(name = "nMDF", required = true)
            protected String nmdf;
            @XmlElement(name = "cMDF", required = true)
            protected String cmdf;
            @XmlElement(name = "cDV", required = true)
            protected String cdv;
            @XmlElement(required = true)
            protected String modal;
            @XmlElement(required = true)
            protected String dhEmi;
            @XmlElement(required = true)
            protected String tpEmis;
            @XmlElement(required = true)
            protected String procEmi;
            @XmlElement(required = true)
            protected String verProc;
            @XmlElement(name = "UFIni", required = true)
            @XmlSchemaType(name = "string")
            protected TUf ufIni;
            @XmlElement(name = "UFFim", required = true)
            @XmlSchemaType(name = "string")
            protected TUf ufFim;
            @XmlElement(required = true)
            protected List<TMDFe.InfMDFe.Ide.InfMunCarrega> infMunCarrega;
            protected List<TMDFe.InfMDFe.Ide.InfPercurso> infPercurso;
            protected String dhIniViagem;

            /**
             * Obtém o valor da propriedade cuf.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCUF() {
                return cuf;
            }

            /**
             * Define o valor da propriedade cuf.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCUF(String value) {
                this.cuf = value;
            }

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
             * Obtém o valor da propriedade tpEmit.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTpEmit() {
                return tpEmit;
            }

            /**
             * Define o valor da propriedade tpEmit.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTpEmit(String value) {
                this.tpEmit = value;
            }

            /**
             * Obtém o valor da propriedade tpTransp.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTpTransp() {
                return tpTransp;
            }

            /**
             * Define o valor da propriedade tpTransp.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTpTransp(String value) {
                this.tpTransp = value;
            }

            /**
             * Obtém o valor da propriedade mod.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMod() {
                return mod;
            }

            /**
             * Define o valor da propriedade mod.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMod(String value) {
                this.mod = value;
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
             * Obtém o valor da propriedade nmdf.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNMDF() {
                return nmdf;
            }

            /**
             * Define o valor da propriedade nmdf.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNMDF(String value) {
                this.nmdf = value;
            }

            /**
             * Obtém o valor da propriedade cmdf.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCMDF() {
                return cmdf;
            }

            /**
             * Define o valor da propriedade cmdf.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCMDF(String value) {
                this.cmdf = value;
            }

            /**
             * Obtém o valor da propriedade cdv.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCDV() {
                return cdv;
            }

            /**
             * Define o valor da propriedade cdv.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCDV(String value) {
                this.cdv = value;
            }

            /**
             * Obtém o valor da propriedade modal.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getModal() {
                return modal;
            }

            /**
             * Define o valor da propriedade modal.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setModal(String value) {
                this.modal = value;
            }

            /**
             * Obtém o valor da propriedade dhEmi.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDhEmi() {
                return dhEmi;
            }

            /**
             * Define o valor da propriedade dhEmi.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDhEmi(String value) {
                this.dhEmi = value;
            }

            /**
             * Obtém o valor da propriedade tpEmis.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTpEmis() {
                return tpEmis;
            }

            /**
             * Define o valor da propriedade tpEmis.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTpEmis(String value) {
                this.tpEmis = value;
            }

            /**
             * Obtém o valor da propriedade procEmi.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProcEmi() {
                return procEmi;
            }

            /**
             * Define o valor da propriedade procEmi.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProcEmi(String value) {
                this.procEmi = value;
            }

            /**
             * Obtém o valor da propriedade verProc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVerProc() {
                return verProc;
            }

            /**
             * Define o valor da propriedade verProc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVerProc(String value) {
                this.verProc = value;
            }

            /**
             * Obtém o valor da propriedade ufIni.
             * 
             * @return
             *     possible object is
             *     {@link TUf }
             *     
             */
            public TUf getUFIni() {
                return ufIni;
            }

            /**
             * Define o valor da propriedade ufIni.
             * 
             * @param value
             *     allowed object is
             *     {@link TUf }
             *     
             */
            public void setUFIni(TUf value) {
                this.ufIni = value;
            }

            /**
             * Obtém o valor da propriedade ufFim.
             * 
             * @return
             *     possible object is
             *     {@link TUf }
             *     
             */
            public TUf getUFFim() {
                return ufFim;
            }

            /**
             * Define o valor da propriedade ufFim.
             * 
             * @param value
             *     allowed object is
             *     {@link TUf }
             *     
             */
            public void setUFFim(TUf value) {
                this.ufFim = value;
            }

            /**
             * Gets the value of the infMunCarrega property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the infMunCarrega property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInfMunCarrega().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TMDFe.InfMDFe.Ide.InfMunCarrega }
             * 
             * 
             */
            public List<TMDFe.InfMDFe.Ide.InfMunCarrega> getInfMunCarrega() {
                if (infMunCarrega == null) {
                    infMunCarrega = new ArrayList<TMDFe.InfMDFe.Ide.InfMunCarrega>();
                }
                return this.infMunCarrega;
            }

            /**
             * Gets the value of the infPercurso property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the infPercurso property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInfPercurso().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TMDFe.InfMDFe.Ide.InfPercurso }
             * 
             * 
             */
            public List<TMDFe.InfMDFe.Ide.InfPercurso> getInfPercurso() {
                if (infPercurso == null) {
                    infPercurso = new ArrayList<TMDFe.InfMDFe.Ide.InfPercurso>();
                }
                return this.infPercurso;
            }

            /**
             * Obtém o valor da propriedade dhIniViagem.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDhIniViagem() {
                return dhIniViagem;
            }

            /**
             * Define o valor da propriedade dhIniViagem.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDhIniViagem(String value) {
                this.dhIniViagem = value;
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
             *         &lt;element name="cMunCarrega" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
             *         &lt;element name="xMunCarrega"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *               &lt;minLength value="2"/&gt;
             *               &lt;maxLength value="60"/&gt;
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
                "cMunCarrega",
                "xMunCarrega"
            })
            public static class InfMunCarrega {

                @XmlElement(required = true)
                protected String cMunCarrega;
                @XmlElement(required = true)
                protected String xMunCarrega;

                /**
                 * Obtém o valor da propriedade cMunCarrega.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCMunCarrega() {
                    return cMunCarrega;
                }

                /**
                 * Define o valor da propriedade cMunCarrega.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCMunCarrega(String value) {
                    this.cMunCarrega = value;
                }

                /**
                 * Obtém o valor da propriedade xMunCarrega.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXMunCarrega() {
                    return xMunCarrega;
                }

                /**
                 * Define o valor da propriedade xMunCarrega.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXMunCarrega(String value) {
                    this.xMunCarrega = value;
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
             *         &lt;element name="UFPer" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
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
                "ufPer"
            })
            public static class InfPercurso {

                @XmlElement(name = "UFPer", required = true)
                @XmlSchemaType(name = "string")
                protected TUf ufPer;

                /**
                 * Obtém o valor da propriedade ufPer.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TUf }
                 *     
                 */
                public TUf getUFPer() {
                    return ufPer;
                }

                /**
                 * Define o valor da propriedade ufPer.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TUf }
                 *     
                 */
                public void setUFPer(TUf value) {
                    this.ufPer = value;
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
         *         &lt;element name="infAdFisco" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="2000"/&gt;
         *               &lt;minLength value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="infCpl" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="5000"/&gt;
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
            "infAdFisco",
            "infCpl"
        })
        public static class InfAdic {

            protected String infAdFisco;
            protected String infCpl;

            /**
             * Obtém o valor da propriedade infAdFisco.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInfAdFisco() {
                return infAdFisco;
            }

            /**
             * Define o valor da propriedade infAdFisco.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInfAdFisco(String value) {
                this.infAdFisco = value;
            }

            /**
             * Obtém o valor da propriedade infCpl.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInfCpl() {
                return infCpl;
            }

            /**
             * Define o valor da propriedade infCpl.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInfCpl(String value) {
                this.infCpl = value;
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
         *         &lt;element name="infMunDescarga" maxOccurs="100"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="cMunDescarga" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
         *                   &lt;element name="xMunDescarga"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                         &lt;minLength value="2"/&gt;
         *                         &lt;maxLength value="60"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="infCTe" maxOccurs="4000" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/mdfe}TChCTe"/&gt;
         *                             &lt;element name="SegCodBarra" type="{http://www.portalfiscal.inf.br/mdfe}TSegCodBarra" minOccurs="0"/&gt;
         *                             &lt;element name="indReentrega" minOccurs="0"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                   &lt;enumeration value="1"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                             &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="nONU"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                             &lt;whiteSpace value="preserve"/&gt;
         *                                             &lt;pattern value="[0-9]{4}|ND"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="xNomeAE" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="150"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="xClaRisco" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="40"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="grEmb" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="6"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="qTotProd"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="20"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="qVolTipo" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="60"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
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
         *                   &lt;element name="infNFe" maxOccurs="4000" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
         *                             &lt;element name="SegCodBarra" type="{http://www.portalfiscal.inf.br/mdfe}TSegCodBarra" minOccurs="0"/&gt;
         *                             &lt;element name="indReentrega" minOccurs="0"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                   &lt;enumeration value="1"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                             &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="nONU"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                             &lt;whiteSpace value="preserve"/&gt;
         *                                             &lt;pattern value="[0-9]{4}|ND"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="xNomeAE" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="150"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="xClaRisco" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="40"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="grEmb" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="6"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="qTotProd"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="20"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="qVolTipo" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="60"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
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
         *                   &lt;element name="infMDFeTransp" maxOccurs="4000" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="chMDFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
         *                             &lt;element name="indReentrega" minOccurs="0"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                   &lt;enumeration value="1"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                             &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="nONU"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                             &lt;whiteSpace value="preserve"/&gt;
         *                                             &lt;pattern value="[0-9]{4}|ND"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="xNomeAE" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="150"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="xClaRisco" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="40"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="grEmb" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="6"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="qTotProd"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="20"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="qVolTipo" minOccurs="0"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                                             &lt;minLength value="1"/&gt;
         *                                             &lt;maxLength value="60"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
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
            "infMunDescarga"
        })
        public static class InfDoc {

            @XmlElement(required = true)
            protected List<TMDFe.InfMDFe.InfDoc.InfMunDescarga> infMunDescarga;

            /**
             * Gets the value of the infMunDescarga property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the infMunDescarga property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInfMunDescarga().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TMDFe.InfMDFe.InfDoc.InfMunDescarga }
             * 
             * 
             */
            public List<TMDFe.InfMDFe.InfDoc.InfMunDescarga> getInfMunDescarga() {
                if (infMunDescarga == null) {
                    infMunDescarga = new ArrayList<TMDFe.InfMDFe.InfDoc.InfMunDescarga>();
                }
                return this.infMunDescarga;
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
             *         &lt;element name="cMunDescarga" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
             *         &lt;element name="xMunDescarga"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *               &lt;minLength value="2"/&gt;
             *               &lt;maxLength value="60"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="infCTe" maxOccurs="4000" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/mdfe}TChCTe"/&gt;
             *                   &lt;element name="SegCodBarra" type="{http://www.portalfiscal.inf.br/mdfe}TSegCodBarra" minOccurs="0"/&gt;
             *                   &lt;element name="indReentrega" minOccurs="0"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                         &lt;enumeration value="1"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
             *                   &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="nONU"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                   &lt;whiteSpace value="preserve"/&gt;
             *                                   &lt;pattern value="[0-9]{4}|ND"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="xNomeAE" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="150"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="xClaRisco" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="40"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="grEmb" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="6"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="qTotProd"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="20"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="qVolTipo" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="60"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
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
             *         &lt;element name="infNFe" maxOccurs="4000" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
             *                   &lt;element name="SegCodBarra" type="{http://www.portalfiscal.inf.br/mdfe}TSegCodBarra" minOccurs="0"/&gt;
             *                   &lt;element name="indReentrega" minOccurs="0"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                         &lt;enumeration value="1"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
             *                   &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="nONU"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                   &lt;whiteSpace value="preserve"/&gt;
             *                                   &lt;pattern value="[0-9]{4}|ND"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="xNomeAE" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="150"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="xClaRisco" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="40"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="grEmb" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="6"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="qTotProd"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="20"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="qVolTipo" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="60"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
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
             *         &lt;element name="infMDFeTransp" maxOccurs="4000" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="chMDFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
             *                   &lt;element name="indReentrega" minOccurs="0"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                         &lt;enumeration value="1"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
             *                   &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="nONU"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                   &lt;whiteSpace value="preserve"/&gt;
             *                                   &lt;pattern value="[0-9]{4}|ND"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="xNomeAE" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="150"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="xClaRisco" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="40"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="grEmb" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="6"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="qTotProd"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="20"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="qVolTipo" minOccurs="0"&gt;
             *                               &lt;simpleType&gt;
             *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *                                   &lt;minLength value="1"/&gt;
             *                                   &lt;maxLength value="60"/&gt;
             *                                 &lt;/restriction&gt;
             *                               &lt;/simpleType&gt;
             *                             &lt;/element&gt;
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
                "cMunDescarga",
                "xMunDescarga",
                "infCTe",
                "infNFe",
                "infMDFeTransp"
            })
            public static class InfMunDescarga {

                @XmlElement(required = true)
                protected String cMunDescarga;
                @XmlElement(required = true)
                protected String xMunDescarga;
                protected List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfCTe> infCTe;
                protected List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfNFe> infNFe;
                protected List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfMDFeTransp> infMDFeTransp;

                /**
                 * Obtém o valor da propriedade cMunDescarga.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCMunDescarga() {
                    return cMunDescarga;
                }

                /**
                 * Define o valor da propriedade cMunDescarga.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCMunDescarga(String value) {
                    this.cMunDescarga = value;
                }

                /**
                 * Obtém o valor da propriedade xMunDescarga.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXMunDescarga() {
                    return xMunDescarga;
                }

                /**
                 * Define o valor da propriedade xMunDescarga.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXMunDescarga(String value) {
                    this.xMunDescarga = value;
                }

                /**
                 * Gets the value of the infCTe property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the infCTe property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getInfCTe().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfCTe }
                 * 
                 * 
                 */
                public List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfCTe> getInfCTe() {
                    if (infCTe == null) {
                        infCTe = new ArrayList<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfCTe>();
                    }
                    return this.infCTe;
                }

                /**
                 * Gets the value of the infNFe property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the infNFe property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getInfNFe().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfNFe }
                 * 
                 * 
                 */
                public List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfNFe> getInfNFe() {
                    if (infNFe == null) {
                        infNFe = new ArrayList<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfNFe>();
                    }
                    return this.infNFe;
                }

                /**
                 * Gets the value of the infMDFeTransp property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the infMDFeTransp property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getInfMDFeTransp().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfMDFeTransp }
                 * 
                 * 
                 */
                public List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfMDFeTransp> getInfMDFeTransp() {
                    if (infMDFeTransp == null) {
                        infMDFeTransp = new ArrayList<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfMDFeTransp>();
                    }
                    return this.infMDFeTransp;
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
                 *         &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/mdfe}TChCTe"/&gt;
                 *         &lt;element name="SegCodBarra" type="{http://www.portalfiscal.inf.br/mdfe}TSegCodBarra" minOccurs="0"/&gt;
                 *         &lt;element name="indReentrega" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;enumeration value="1"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
                 *         &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="nONU"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                         &lt;whiteSpace value="preserve"/&gt;
                 *                         &lt;pattern value="[0-9]{4}|ND"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="xNomeAE" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="150"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="xClaRisco" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="40"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="grEmb" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="6"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="qTotProd"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="20"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="qVolTipo" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="60"/&gt;
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
                    "chCTe",
                    "segCodBarra",
                    "indReentrega",
                    "infUnidTransp",
                    "peri"
                })
                public static class InfCTe {

                    @XmlElement(required = true)
                    protected String chCTe;
                    @XmlElement(name = "SegCodBarra")
                    protected String segCodBarra;
                    protected String indReentrega;
                    protected List<TUnidadeTransp> infUnidTransp;
                    protected List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfCTe.Peri> peri;

                    /**
                     * Obtém o valor da propriedade chCTe.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getChCTe() {
                        return chCTe;
                    }

                    /**
                     * Define o valor da propriedade chCTe.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setChCTe(String value) {
                        this.chCTe = value;
                    }

                    /**
                     * Obtém o valor da propriedade segCodBarra.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getSegCodBarra() {
                        return segCodBarra;
                    }

                    /**
                     * Define o valor da propriedade segCodBarra.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setSegCodBarra(String value) {
                        this.segCodBarra = value;
                    }

                    /**
                     * Obtém o valor da propriedade indReentrega.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getIndReentrega() {
                        return indReentrega;
                    }

                    /**
                     * Define o valor da propriedade indReentrega.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setIndReentrega(String value) {
                        this.indReentrega = value;
                    }

                    /**
                     * Gets the value of the infUnidTransp property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the infUnidTransp property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getInfUnidTransp().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link TUnidadeTransp }
                     * 
                     * 
                     */
                    public List<TUnidadeTransp> getInfUnidTransp() {
                        if (infUnidTransp == null) {
                            infUnidTransp = new ArrayList<TUnidadeTransp>();
                        }
                        return this.infUnidTransp;
                    }

                    /**
                     * Gets the value of the peri property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the peri property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getPeri().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfCTe.Peri }
                     * 
                     * 
                     */
                    public List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfCTe.Peri> getPeri() {
                        if (peri == null) {
                            peri = new ArrayList<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfCTe.Peri>();
                        }
                        return this.peri;
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
                     *         &lt;element name="nONU"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *               &lt;whiteSpace value="preserve"/&gt;
                     *               &lt;pattern value="[0-9]{4}|ND"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="xNomeAE" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="150"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="xClaRisco" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="40"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="grEmb" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="6"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="qTotProd"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="20"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="qVolTipo" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="60"/&gt;
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
                        "nonu",
                        "xNomeAE",
                        "xClaRisco",
                        "grEmb",
                        "qTotProd",
                        "qVolTipo"
                    })
                    public static class Peri {

                        @XmlElement(name = "nONU", required = true)
                        protected String nonu;
                        protected String xNomeAE;
                        protected String xClaRisco;
                        protected String grEmb;
                        @XmlElement(required = true)
                        protected String qTotProd;
                        protected String qVolTipo;

                        /**
                         * Obtém o valor da propriedade nonu.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNONU() {
                            return nonu;
                        }

                        /**
                         * Define o valor da propriedade nonu.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNONU(String value) {
                            this.nonu = value;
                        }

                        /**
                         * Obtém o valor da propriedade xNomeAE.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getXNomeAE() {
                            return xNomeAE;
                        }

                        /**
                         * Define o valor da propriedade xNomeAE.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setXNomeAE(String value) {
                            this.xNomeAE = value;
                        }

                        /**
                         * Obtém o valor da propriedade xClaRisco.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getXClaRisco() {
                            return xClaRisco;
                        }

                        /**
                         * Define o valor da propriedade xClaRisco.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setXClaRisco(String value) {
                            this.xClaRisco = value;
                        }

                        /**
                         * Obtém o valor da propriedade grEmb.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getGrEmb() {
                            return grEmb;
                        }

                        /**
                         * Define o valor da propriedade grEmb.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setGrEmb(String value) {
                            this.grEmb = value;
                        }

                        /**
                         * Obtém o valor da propriedade qTotProd.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getQTotProd() {
                            return qTotProd;
                        }

                        /**
                         * Define o valor da propriedade qTotProd.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setQTotProd(String value) {
                            this.qTotProd = value;
                        }

                        /**
                         * Obtém o valor da propriedade qVolTipo.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getQVolTipo() {
                            return qVolTipo;
                        }

                        /**
                         * Define o valor da propriedade qVolTipo.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setQVolTipo(String value) {
                            this.qVolTipo = value;
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
                 *         &lt;element name="chMDFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
                 *         &lt;element name="indReentrega" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;enumeration value="1"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
                 *         &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="nONU"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                         &lt;whiteSpace value="preserve"/&gt;
                 *                         &lt;pattern value="[0-9]{4}|ND"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="xNomeAE" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="150"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="xClaRisco" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="40"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="grEmb" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="6"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="qTotProd"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="20"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="qVolTipo" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="60"/&gt;
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
                    "chMDFe",
                    "indReentrega",
                    "infUnidTransp",
                    "peri"
                })
                public static class InfMDFeTransp {

                    @XmlElement(required = true)
                    protected String chMDFe;
                    protected String indReentrega;
                    protected List<TUnidadeTransp> infUnidTransp;
                    protected List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfMDFeTransp.Peri> peri;

                    /**
                     * Obtém o valor da propriedade chMDFe.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getChMDFe() {
                        return chMDFe;
                    }

                    /**
                     * Define o valor da propriedade chMDFe.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setChMDFe(String value) {
                        this.chMDFe = value;
                    }

                    /**
                     * Obtém o valor da propriedade indReentrega.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getIndReentrega() {
                        return indReentrega;
                    }

                    /**
                     * Define o valor da propriedade indReentrega.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setIndReentrega(String value) {
                        this.indReentrega = value;
                    }

                    /**
                     * Gets the value of the infUnidTransp property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the infUnidTransp property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getInfUnidTransp().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link TUnidadeTransp }
                     * 
                     * 
                     */
                    public List<TUnidadeTransp> getInfUnidTransp() {
                        if (infUnidTransp == null) {
                            infUnidTransp = new ArrayList<TUnidadeTransp>();
                        }
                        return this.infUnidTransp;
                    }

                    /**
                     * Gets the value of the peri property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the peri property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getPeri().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfMDFeTransp.Peri }
                     * 
                     * 
                     */
                    public List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfMDFeTransp.Peri> getPeri() {
                        if (peri == null) {
                            peri = new ArrayList<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfMDFeTransp.Peri>();
                        }
                        return this.peri;
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
                     *         &lt;element name="nONU"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *               &lt;whiteSpace value="preserve"/&gt;
                     *               &lt;pattern value="[0-9]{4}|ND"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="xNomeAE" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="150"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="xClaRisco" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="40"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="grEmb" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="6"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="qTotProd"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="20"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="qVolTipo" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="60"/&gt;
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
                        "nonu",
                        "xNomeAE",
                        "xClaRisco",
                        "grEmb",
                        "qTotProd",
                        "qVolTipo"
                    })
                    public static class Peri {

                        @XmlElement(name = "nONU", required = true)
                        protected String nonu;
                        protected String xNomeAE;
                        protected String xClaRisco;
                        protected String grEmb;
                        @XmlElement(required = true)
                        protected String qTotProd;
                        protected String qVolTipo;

                        /**
                         * Obtém o valor da propriedade nonu.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNONU() {
                            return nonu;
                        }

                        /**
                         * Define o valor da propriedade nonu.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNONU(String value) {
                            this.nonu = value;
                        }

                        /**
                         * Obtém o valor da propriedade xNomeAE.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getXNomeAE() {
                            return xNomeAE;
                        }

                        /**
                         * Define o valor da propriedade xNomeAE.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setXNomeAE(String value) {
                            this.xNomeAE = value;
                        }

                        /**
                         * Obtém o valor da propriedade xClaRisco.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getXClaRisco() {
                            return xClaRisco;
                        }

                        /**
                         * Define o valor da propriedade xClaRisco.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setXClaRisco(String value) {
                            this.xClaRisco = value;
                        }

                        /**
                         * Obtém o valor da propriedade grEmb.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getGrEmb() {
                            return grEmb;
                        }

                        /**
                         * Define o valor da propriedade grEmb.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setGrEmb(String value) {
                            this.grEmb = value;
                        }

                        /**
                         * Obtém o valor da propriedade qTotProd.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getQTotProd() {
                            return qTotProd;
                        }

                        /**
                         * Define o valor da propriedade qTotProd.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setQTotProd(String value) {
                            this.qTotProd = value;
                        }

                        /**
                         * Obtém o valor da propriedade qVolTipo.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getQVolTipo() {
                            return qVolTipo;
                        }

                        /**
                         * Define o valor da propriedade qVolTipo.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setQVolTipo(String value) {
                            this.qVolTipo = value;
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
                 *         &lt;element name="SegCodBarra" type="{http://www.portalfiscal.inf.br/mdfe}TSegCodBarra" minOccurs="0"/&gt;
                 *         &lt;element name="indReentrega" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;enumeration value="1"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/mdfe}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
                 *         &lt;element name="peri" maxOccurs="unbounded" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="nONU"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                         &lt;whiteSpace value="preserve"/&gt;
                 *                         &lt;pattern value="[0-9]{4}|ND"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="xNomeAE" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="150"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="xClaRisco" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="40"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="grEmb" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="6"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="qTotProd"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="20"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="qVolTipo" minOccurs="0"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                 *                         &lt;minLength value="1"/&gt;
                 *                         &lt;maxLength value="60"/&gt;
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
                    "chNFe",
                    "segCodBarra",
                    "indReentrega",
                    "infUnidTransp",
                    "peri"
                })
                public static class InfNFe {

                    @XmlElement(required = true)
                    protected String chNFe;
                    @XmlElement(name = "SegCodBarra")
                    protected String segCodBarra;
                    protected String indReentrega;
                    protected List<TUnidadeTransp> infUnidTransp;
                    protected List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfNFe.Peri> peri;

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
                     * Obtém o valor da propriedade segCodBarra.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getSegCodBarra() {
                        return segCodBarra;
                    }

                    /**
                     * Define o valor da propriedade segCodBarra.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setSegCodBarra(String value) {
                        this.segCodBarra = value;
                    }

                    /**
                     * Obtém o valor da propriedade indReentrega.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getIndReentrega() {
                        return indReentrega;
                    }

                    /**
                     * Define o valor da propriedade indReentrega.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setIndReentrega(String value) {
                        this.indReentrega = value;
                    }

                    /**
                     * Gets the value of the infUnidTransp property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the infUnidTransp property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getInfUnidTransp().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link TUnidadeTransp }
                     * 
                     * 
                     */
                    public List<TUnidadeTransp> getInfUnidTransp() {
                        if (infUnidTransp == null) {
                            infUnidTransp = new ArrayList<TUnidadeTransp>();
                        }
                        return this.infUnidTransp;
                    }

                    /**
                     * Gets the value of the peri property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the peri property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getPeri().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfNFe.Peri }
                     * 
                     * 
                     */
                    public List<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfNFe.Peri> getPeri() {
                        if (peri == null) {
                            peri = new ArrayList<TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfNFe.Peri>();
                        }
                        return this.peri;
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
                     *         &lt;element name="nONU"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *               &lt;whiteSpace value="preserve"/&gt;
                     *               &lt;pattern value="[0-9]{4}|ND"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="xNomeAE" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="150"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="xClaRisco" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="40"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="grEmb" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="6"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="qTotProd"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="20"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="qVolTipo" minOccurs="0"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
                     *               &lt;minLength value="1"/&gt;
                     *               &lt;maxLength value="60"/&gt;
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
                        "nonu",
                        "xNomeAE",
                        "xClaRisco",
                        "grEmb",
                        "qTotProd",
                        "qVolTipo"
                    })
                    public static class Peri {

                        @XmlElement(name = "nONU", required = true)
                        protected String nonu;
                        protected String xNomeAE;
                        protected String xClaRisco;
                        protected String grEmb;
                        @XmlElement(required = true)
                        protected String qTotProd;
                        protected String qVolTipo;

                        /**
                         * Obtém o valor da propriedade nonu.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNONU() {
                            return nonu;
                        }

                        /**
                         * Define o valor da propriedade nonu.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNONU(String value) {
                            this.nonu = value;
                        }

                        /**
                         * Obtém o valor da propriedade xNomeAE.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getXNomeAE() {
                            return xNomeAE;
                        }

                        /**
                         * Define o valor da propriedade xNomeAE.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setXNomeAE(String value) {
                            this.xNomeAE = value;
                        }

                        /**
                         * Obtém o valor da propriedade xClaRisco.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getXClaRisco() {
                            return xClaRisco;
                        }

                        /**
                         * Define o valor da propriedade xClaRisco.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setXClaRisco(String value) {
                            this.xClaRisco = value;
                        }

                        /**
                         * Obtém o valor da propriedade grEmb.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getGrEmb() {
                            return grEmb;
                        }

                        /**
                         * Define o valor da propriedade grEmb.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setGrEmb(String value) {
                            this.grEmb = value;
                        }

                        /**
                         * Obtém o valor da propriedade qTotProd.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getQTotProd() {
                            return qTotProd;
                        }

                        /**
                         * Define o valor da propriedade qTotProd.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setQTotProd(String value) {
                            this.qTotProd = value;
                        }

                        /**
                         * Obtém o valor da propriedade qVolTipo.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getQVolTipo() {
                            return qVolTipo;
                        }

                        /**
                         * Define o valor da propriedade qVolTipo.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setQVolTipo(String value) {
                            this.qVolTipo = value;
                        }

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
         *         &lt;any processContents='skip'/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="versaoModal" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;whiteSpace value="preserve"/&gt;
         *             &lt;pattern value="3\.(0[0-9]|[1-9][0-9])"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
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
        public static class InfModal {

            @XmlAnyElement
            protected Element any;
            @XmlAttribute(name = "versaoModal", required = true)
            protected String versaoModal;

            /**
             * Obtém o valor da propriedade any.
             * 
             * @return
             *     possible object is
             *     {@link Element }
             *     
             */
            public Element getAny() {
                return any;
            }

            /**
             * Define o valor da propriedade any.
             * 
             * @param value
             *     allowed object is
             *     {@link Element }
             *     
             */
            public void setAny(Element value) {
                this.any = value;
            }

            /**
             * Obtém o valor da propriedade versaoModal.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVersaoModal() {
                return versaoModal;
            }

            /**
             * Define o valor da propriedade versaoModal.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVersaoModal(String value) {
                this.versaoModal = value;
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
         *               &lt;maxLength value="60"/&gt;
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
        public static class Lacres {

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
         *         &lt;element name="infResp"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="respSeg"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;whiteSpace value="preserve"/&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="1"/&gt;
         *                         &lt;enumeration value="1"/&gt;
         *                         &lt;enumeration value="2"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;choice minOccurs="0"&gt;
         *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
         *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
         *                   &lt;/choice&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="infSeg" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="xSeg"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="30"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="nApol" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="20"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="nAver" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="40"/&gt;
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
            "infResp",
            "infSeg",
            "nApol",
            "nAver"
        })
        public static class Seg {

            @XmlElement(required = true)
            protected TMDFe.InfMDFe.Seg.InfResp infResp;
            protected TMDFe.InfMDFe.Seg.InfSeg infSeg;
            protected String nApol;
            protected List<String> nAver;

            /**
             * Obtém o valor da propriedade infResp.
             * 
             * @return
             *     possible object is
             *     {@link TMDFe.InfMDFe.Seg.InfResp }
             *     
             */
            public TMDFe.InfMDFe.Seg.InfResp getInfResp() {
                return infResp;
            }

            /**
             * Define o valor da propriedade infResp.
             * 
             * @param value
             *     allowed object is
             *     {@link TMDFe.InfMDFe.Seg.InfResp }
             *     
             */
            public void setInfResp(TMDFe.InfMDFe.Seg.InfResp value) {
                this.infResp = value;
            }

            /**
             * Obtém o valor da propriedade infSeg.
             * 
             * @return
             *     possible object is
             *     {@link TMDFe.InfMDFe.Seg.InfSeg }
             *     
             */
            public TMDFe.InfMDFe.Seg.InfSeg getInfSeg() {
                return infSeg;
            }

            /**
             * Define o valor da propriedade infSeg.
             * 
             * @param value
             *     allowed object is
             *     {@link TMDFe.InfMDFe.Seg.InfSeg }
             *     
             */
            public void setInfSeg(TMDFe.InfMDFe.Seg.InfSeg value) {
                this.infSeg = value;
            }

            /**
             * Obtém o valor da propriedade nApol.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNApol() {
                return nApol;
            }

            /**
             * Define o valor da propriedade nApol.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNApol(String value) {
                this.nApol = value;
            }

            /**
             * Gets the value of the nAver property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the nAver property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getNAver().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getNAver() {
                if (nAver == null) {
                    nAver = new ArrayList<String>();
                }
                return this.nAver;
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
             *         &lt;element name="respSeg"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;whiteSpace value="preserve"/&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="1"/&gt;
             *               &lt;enumeration value="1"/&gt;
             *               &lt;enumeration value="2"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;choice minOccurs="0"&gt;
             *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
             *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
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
                "respSeg",
                "cnpj",
                "cpf"
            })
            public static class InfResp {

                @XmlElement(required = true)
                protected String respSeg;
                @XmlElement(name = "CNPJ")
                protected String cnpj;
                @XmlElement(name = "CPF")
                protected String cpf;

                /**
                 * Obtém o valor da propriedade respSeg.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRespSeg() {
                    return respSeg;
                }

                /**
                 * Define o valor da propriedade respSeg.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRespSeg(String value) {
                    this.respSeg = value;
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
             *         &lt;element name="xSeg"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="30"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
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
                "xSeg",
                "cnpj"
            })
            public static class InfSeg {

                @XmlElement(required = true)
                protected String xSeg;
                @XmlElement(name = "CNPJ", required = true)
                protected String cnpj;

                /**
                 * Obtém o valor da propriedade xSeg.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXSeg() {
                    return xSeg;
                }

                /**
                 * Define o valor da propriedade xSeg.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXSeg(String value) {
                    this.xSeg = value;
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
         *         &lt;element name="qCTe" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;pattern value="[0-9]{1,6}"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="qNFe" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;pattern value="[0-9]{1,6}"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="qMDFe" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;pattern value="[0-9]{1,6}"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="vCarga" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
         *         &lt;element name="cUnid"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="01"/&gt;
         *               &lt;enumeration value="02"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="qCarga" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1104"/&gt;
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
            "qcTe",
            "qnFe",
            "qmdFe",
            "vCarga",
            "cUnid",
            "qCarga"
        })
        public static class Tot {

            @XmlElement(name = "qCTe")
            protected String qcTe;
            @XmlElement(name = "qNFe")
            protected String qnFe;
            @XmlElement(name = "qMDFe")
            protected String qmdFe;
            @XmlElement(required = true)
            protected String vCarga;
            @XmlElement(required = true)
            protected String cUnid;
            @XmlElement(required = true)
            protected String qCarga;

            /**
             * Obtém o valor da propriedade qcTe.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQCTe() {
                return qcTe;
            }

            /**
             * Define o valor da propriedade qcTe.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQCTe(String value) {
                this.qcTe = value;
            }

            /**
             * Obtém o valor da propriedade qnFe.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQNFe() {
                return qnFe;
            }

            /**
             * Define o valor da propriedade qnFe.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQNFe(String value) {
                this.qnFe = value;
            }

            /**
             * Obtém o valor da propriedade qmdFe.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQMDFe() {
                return qmdFe;
            }

            /**
             * Define o valor da propriedade qmdFe.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQMDFe(String value) {
                this.qmdFe = value;
            }

            /**
             * Obtém o valor da propriedade vCarga.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVCarga() {
                return vCarga;
            }

            /**
             * Define o valor da propriedade vCarga.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVCarga(String value) {
                this.vCarga = value;
            }

            /**
             * Obtém o valor da propriedade cUnid.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCUnid() {
                return cUnid;
            }

            /**
             * Define o valor da propriedade cUnid.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCUnid(String value) {
                this.cUnid = value;
            }

            /**
             * Obtém o valor da propriedade qCarga.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQCarga() {
                return qCarga;
            }

            /**
             * Define o valor da propriedade qCarga.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQCarga(String value) {
                this.qCarga = value;
            }

        }

    }

}
