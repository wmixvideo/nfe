//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.02.05 às 01:30:48 PM BRT 
//


package br.inf.portalfiscal.cte;

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
 * Tipo Conhecimento de Transporte Eletrônico (Modelo 57)
 * 
 * <p>Classe Java de TCTe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCTe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infCte"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ide"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/cte}TCodUfIBGE"/&gt;
 *                             &lt;element name="cCT"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;pattern value="[0-9]{8}"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="CFOP" type="{http://www.portalfiscal.inf.br/cte}TCfop"/&gt;
 *                             &lt;element name="natOp"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModCT"/&gt;
 *                             &lt;element name="serie"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TSerie"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="nCT" type="{http://www.portalfiscal.inf.br/cte}TNF"/&gt;
 *                             &lt;element name="dhEmi"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="tpImp"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="tpEmis"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="4"/&gt;
 *                                   &lt;enumeration value="5"/&gt;
 *                                   &lt;enumeration value="7"/&gt;
 *                                   &lt;enumeration value="8"/&gt;
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
 *                             &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/cte}TAmb"/&gt;
 *                             &lt;element name="tpCTe" type="{http://www.portalfiscal.inf.br/cte}TFinCTe"/&gt;
 *                             &lt;element name="procEmi" type="{http://www.portalfiscal.inf.br/cte}TProcEmi"/&gt;
 *                             &lt;element name="verProc"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="20"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="indGlobalizado" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="cMunEnv" type="{http://www.portalfiscal.inf.br/cte}TCodMunIBGE"/&gt;
 *                             &lt;element name="xMunEnv"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="UFEnv" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
 *                             &lt;element name="modal" type="{http://www.portalfiscal.inf.br/cte}TModTransp"/&gt;
 *                             &lt;element name="tpServ"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="0"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                   &lt;enumeration value="3"/&gt;
 *                                   &lt;enumeration value="4"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="cMunIni" type="{http://www.portalfiscal.inf.br/cte}TCodMunIBGE"/&gt;
 *                             &lt;element name="xMunIni"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="UFIni" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
 *                             &lt;element name="cMunFim" type="{http://www.portalfiscal.inf.br/cte}TCodMunIBGE"/&gt;
 *                             &lt;element name="xMunFim"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="UFFim" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
 *                             &lt;element name="retira"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="0"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xDetRetira" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="160"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="indIEToma"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                   &lt;enumeration value="9"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="toma3"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="toma"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                               &lt;whiteSpace value="preserve"/&gt;
 *                                               &lt;enumeration value="0"/&gt;
 *                                               &lt;enumeration value="1"/&gt;
 *                                               &lt;enumeration value="2"/&gt;
 *                                               &lt;enumeration value="3"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="toma4"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="toma"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                               &lt;whiteSpace value="preserve"/&gt;
 *                                               &lt;enumeration value="4"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;choice&gt;
 *                                           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
 *                                           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *                                         &lt;/choice&gt;
 *                                         &lt;element name="IE" minOccurs="0"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element name="xNome"&gt;
 *                                             &lt;simpleType&gt;
 *                                               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                 &lt;maxLength value="60"/&gt;
 *                                                 &lt;minLength value="2"/&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/simpleType&gt;
 *                                           &lt;/element&gt;
 *                                           &lt;element name="xFant" minOccurs="0"&gt;
 *                                             &lt;simpleType&gt;
 *                                               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                 &lt;maxLength value="60"/&gt;
 *                                                 &lt;minLength value="2"/&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/simpleType&gt;
 *                                           &lt;/element&gt;
 *                                           &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
 *                                           &lt;element name="enderToma" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
 *                                           &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/choice&gt;
 *                             &lt;sequence minOccurs="0"&gt;
 *                               &lt;element name="dhCont" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC"/&gt;
 *                               &lt;element name="xJust"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                     &lt;minLength value="15"/&gt;
 *                                     &lt;maxLength value="256"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="compl" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="xCaracAd" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="15"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xCaracSer" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="30"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xEmi" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="20"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="fluxo" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="xOrig" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="60"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="pass" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="xPass" minOccurs="0"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                       &lt;minLength value="1"/&gt;
 *                                                       &lt;maxLength value="15"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="xDest" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="60"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="xRota" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Entrega" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;choice&gt;
 *                                         &lt;element name="semData"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;element name="tpPer"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                         &lt;whiteSpace value="preserve"/&gt;
 *                                                         &lt;enumeration value="0"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="comData"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;element name="tpPer"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                         &lt;whiteSpace value="preserve"/&gt;
 *                                                         &lt;enumeration value="1"/&gt;
 *                                                         &lt;enumeration value="2"/&gt;
 *                                                         &lt;enumeration value="3"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                   &lt;element name="dProg" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="noPeriodo"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;element name="tpPer"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                         &lt;whiteSpace value="preserve"/&gt;
 *                                                         &lt;enumeration value="4"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                   &lt;element name="dIni" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *                                                   &lt;element name="dFim" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/choice&gt;
 *                                       &lt;choice&gt;
 *                                         &lt;element name="semHora"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;element name="tpHor"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                         &lt;whiteSpace value="preserve"/&gt;
 *                                                         &lt;enumeration value="0"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="comHora"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;element name="tpHor"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                         &lt;whiteSpace value="preserve"/&gt;
 *                                                         &lt;enumeration value="1"/&gt;
 *                                                         &lt;enumeration value="2"/&gt;
 *                                                         &lt;enumeration value="3"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                   &lt;element name="hProg" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="noInter"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;element name="tpHor"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                         &lt;whiteSpace value="preserve"/&gt;
 *                                                         &lt;enumeration value="4"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                   &lt;element name="hIni" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
 *                                                   &lt;element name="hFim" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/choice&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="origCalc" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                   &lt;maxLength value="40"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="destCalc" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                   &lt;maxLength value="40"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xObs" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="2000"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ObsCont" maxOccurs="10" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="xTexto"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="160"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name="xCampo" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                           &lt;minLength value="1"/&gt;
 *                                           &lt;maxLength value="20"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ObsFisco" maxOccurs="10" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="xTexto"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="60"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name="xCampo" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                           &lt;minLength value="1"/&gt;
 *                                           &lt;maxLength value="20"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
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
 *                             &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
 *                             &lt;element name="IE"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIe"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="IEST" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIe"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xFant" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="enderEmit" type="{http://www.portalfiscal.inf.br/cte}TEndeEmi"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="rem" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="IE" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xFant" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
 *                             &lt;element name="enderReme" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
 *                             &lt;element name="email" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TEmail"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="exped" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="IE" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
 *                             &lt;element name="enderExped" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
 *                             &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="receb" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="IE" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
 *                             &lt;element name="enderReceb" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
 *                             &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="dest" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="IE" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
 *                             &lt;element name="ISUF" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;pattern value="[0-9]{8,9}"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="enderDest" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
 *                             &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="vPrest"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="vTPrest" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                             &lt;element name="vRec" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                             &lt;element name="Comp" maxOccurs="unbounded" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="xNome"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                             &lt;maxLength value="15"/&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="vComp" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
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
 *                   &lt;element name="imp"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ICMS" type="{http://www.portalfiscal.inf.br/cte}TImp"/&gt;
 *                             &lt;element name="vTotTrib" type="{http://www.portalfiscal.inf.br/cte}TDec_1302" minOccurs="0"/&gt;
 *                             &lt;element name="infAdFisco" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;maxLength value="2000"/&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ICMSUFFim" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="vBCUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                       &lt;element name="pFCPUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
 *                                       &lt;element name="pICMSUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
 *                                       &lt;element name="pICMSInter" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
 *                                       &lt;element name="pICMSInterPart" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
 *                                       &lt;element name="vFCPUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                       &lt;element name="vICMSUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                       &lt;element name="vICMSUFIni" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
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
 *                   &lt;choice&gt;
 *                     &lt;element name="infCTeNorm"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="infCarga"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="vCarga" type="{http://www.portalfiscal.inf.br/cte}TDec_1302" minOccurs="0"/&gt;
 *                                         &lt;element name="proPred"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                               &lt;minLength value="1"/&gt;
 *                                               &lt;maxLength value="60"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="xOutCat" minOccurs="0"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                               &lt;minLength value="1"/&gt;
 *                                               &lt;maxLength value="30"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="infQ" maxOccurs="unbounded"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;element name="cUnid"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                         &lt;whiteSpace value="preserve"/&gt;
 *                                                         &lt;enumeration value="00"/&gt;
 *                                                         &lt;enumeration value="01"/&gt;
 *                                                         &lt;enumeration value="02"/&gt;
 *                                                         &lt;enumeration value="03"/&gt;
 *                                                         &lt;enumeration value="04"/&gt;
 *                                                         &lt;enumeration value="05"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                   &lt;element name="tpMed"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                         &lt;minLength value="1"/&gt;
 *                                                         &lt;maxLength value="20"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                   &lt;element name="qCarga" type="{http://www.portalfiscal.inf.br/cte}TDec_1104"/&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="vCargaAverb" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="infDoc" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;choice&gt;
 *                                           &lt;element name="infNF" maxOccurs="unbounded"&gt;
 *                                             &lt;complexType&gt;
 *                                               &lt;complexContent&gt;
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                   &lt;sequence&gt;
 *                                                     &lt;element name="nRoma" minOccurs="0"&gt;
 *                                                       &lt;simpleType&gt;
 *                                                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                           &lt;minLength value="1"/&gt;
 *                                                           &lt;maxLength value="20"/&gt;
 *                                                         &lt;/restriction&gt;
 *                                                       &lt;/simpleType&gt;
 *                                                     &lt;/element&gt;
 *                                                     &lt;element name="nPed" minOccurs="0"&gt;
 *                                                       &lt;simpleType&gt;
 *                                                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                           &lt;minLength value="1"/&gt;
 *                                                           &lt;maxLength value="20"/&gt;
 *                                                         &lt;/restriction&gt;
 *                                                       &lt;/simpleType&gt;
 *                                                     &lt;/element&gt;
 *                                                     &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModNF"/&gt;
 *                                                     &lt;element name="serie"&gt;
 *                                                       &lt;simpleType&gt;
 *                                                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                           &lt;minLength value="1"/&gt;
 *                                                           &lt;maxLength value="3"/&gt;
 *                                                         &lt;/restriction&gt;
 *                                                       &lt;/simpleType&gt;
 *                                                     &lt;/element&gt;
 *                                                     &lt;element name="nDoc"&gt;
 *                                                       &lt;simpleType&gt;
 *                                                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                           &lt;minLength value="1"/&gt;
 *                                                           &lt;maxLength value="20"/&gt;
 *                                                         &lt;/restriction&gt;
 *                                                       &lt;/simpleType&gt;
 *                                                     &lt;/element&gt;
 *                                                     &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *                                                     &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                                     &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                                     &lt;element name="vBCST" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                                     &lt;element name="vST" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                                     &lt;element name="vProd" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                                     &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                                     &lt;element name="nCFOP" type="{http://www.portalfiscal.inf.br/cte}TCfop"/&gt;
 *                                                     &lt;element name="nPeso" type="{http://www.portalfiscal.inf.br/cte}TDec_1203Opc" minOccurs="0"/&gt;
 *                                                     &lt;element name="PIN" minOccurs="0"&gt;
 *                                                       &lt;simpleType&gt;
 *                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                           &lt;whiteSpace value="preserve"/&gt;
 *                                                           &lt;minLength value="2"/&gt;
 *                                                           &lt;maxLength value="9"/&gt;
 *                                                           &lt;pattern value="[1-9]{1}[0-9]{1,8}"/&gt;
 *                                                         &lt;/restriction&gt;
 *                                                       &lt;/simpleType&gt;
 *                                                     &lt;/element&gt;
 *                                                     &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
 *                                                     &lt;choice&gt;
 *                                                       &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                                       &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                                     &lt;/choice&gt;
 *                                                   &lt;/sequence&gt;
 *                                                 &lt;/restriction&gt;
 *                                               &lt;/complexContent&gt;
 *                                             &lt;/complexType&gt;
 *                                           &lt;/element&gt;
 *                                           &lt;element name="infNFe" maxOccurs="unbounded"&gt;
 *                                             &lt;complexType&gt;
 *                                               &lt;complexContent&gt;
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                   &lt;sequence&gt;
 *                                                     &lt;element name="chave" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
 *                                                     &lt;element name="PIN" minOccurs="0"&gt;
 *                                                       &lt;simpleType&gt;
 *                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                           &lt;whiteSpace value="preserve"/&gt;
 *                                                           &lt;minLength value="2"/&gt;
 *                                                           &lt;maxLength value="9"/&gt;
 *                                                           &lt;pattern value="[1-9]{1}[0-9]{1,8}"/&gt;
 *                                                         &lt;/restriction&gt;
 *                                                       &lt;/simpleType&gt;
 *                                                     &lt;/element&gt;
 *                                                     &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
 *                                                     &lt;choice&gt;
 *                                                       &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                                       &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                                     &lt;/choice&gt;
 *                                                   &lt;/sequence&gt;
 *                                                 &lt;/restriction&gt;
 *                                               &lt;/complexContent&gt;
 *                                             &lt;/complexType&gt;
 *                                           &lt;/element&gt;
 *                                           &lt;element name="infOutros" maxOccurs="unbounded"&gt;
 *                                             &lt;complexType&gt;
 *                                               &lt;complexContent&gt;
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                   &lt;sequence&gt;
 *                                                     &lt;element name="tpDoc"&gt;
 *                                                       &lt;simpleType&gt;
 *                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                           &lt;whiteSpace value="preserve"/&gt;
 *                                                           &lt;enumeration value="00"/&gt;
 *                                                           &lt;enumeration value="10"/&gt;
 *                                                           &lt;enumeration value="59"/&gt;
 *                                                           &lt;enumeration value="65"/&gt;
 *                                                           &lt;enumeration value="99"/&gt;
 *                                                         &lt;/restriction&gt;
 *                                                       &lt;/simpleType&gt;
 *                                                     &lt;/element&gt;
 *                                                     &lt;element name="descOutros" minOccurs="0"&gt;
 *                                                       &lt;simpleType&gt;
 *                                                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                           &lt;minLength value="1"/&gt;
 *                                                           &lt;maxLength value="100"/&gt;
 *                                                         &lt;/restriction&gt;
 *                                                       &lt;/simpleType&gt;
 *                                                     &lt;/element&gt;
 *                                                     &lt;element name="nDoc" minOccurs="0"&gt;
 *                                                       &lt;simpleType&gt;
 *                                                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                           &lt;minLength value="1"/&gt;
 *                                                           &lt;maxLength value="20"/&gt;
 *                                                         &lt;/restriction&gt;
 *                                                       &lt;/simpleType&gt;
 *                                                     &lt;/element&gt;
 *                                                     &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
 *                                                     &lt;element name="vDocFisc" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
 *                                                     &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
 *                                                     &lt;choice&gt;
 *                                                       &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                                       &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                                     &lt;/choice&gt;
 *                                                   &lt;/sequence&gt;
 *                                                 &lt;/restriction&gt;
 *                                               &lt;/complexContent&gt;
 *                                             &lt;/complexType&gt;
 *                                           &lt;/element&gt;
 *                                         &lt;/choice&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="docAnt" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="emiDocAnt" maxOccurs="unbounded"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;choice&gt;
 *                                                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
 *                                                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *                                                   &lt;/choice&gt;
 *                                                   &lt;sequence minOccurs="0"&gt;
 *                                                     &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe"/&gt;
 *                                                     &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
 *                                                   &lt;/sequence&gt;
 *                                                   &lt;element name="xNome"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                         &lt;maxLength value="60"/&gt;
 *                                                         &lt;minLength value="1"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                   &lt;element name="idDocAnt" maxOccurs="2"&gt;
 *                                                     &lt;complexType&gt;
 *                                                       &lt;complexContent&gt;
 *                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                           &lt;choice&gt;
 *                                                             &lt;element name="idDocAntPap" maxOccurs="unbounded"&gt;
 *                                                               &lt;complexType&gt;
 *                                                                 &lt;complexContent&gt;
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                     &lt;sequence&gt;
 *                                                                       &lt;element name="tpDoc"&gt;
 *                                                                         &lt;simpleType&gt;
 *                                                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDocAssoc"&gt;
 *                                                                           &lt;/restriction&gt;
 *                                                                         &lt;/simpleType&gt;
 *                                                                       &lt;/element&gt;
 *                                                                       &lt;element name="serie"&gt;
 *                                                                         &lt;simpleType&gt;
 *                                                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                                             &lt;minLength value="1"/&gt;
 *                                                                             &lt;maxLength value="3"/&gt;
 *                                                                           &lt;/restriction&gt;
 *                                                                         &lt;/simpleType&gt;
 *                                                                       &lt;/element&gt;
 *                                                                       &lt;element name="subser" minOccurs="0"&gt;
 *                                                                         &lt;simpleType&gt;
 *                                                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                                             &lt;minLength value="1"/&gt;
 *                                                                             &lt;maxLength value="2"/&gt;
 *                                                                           &lt;/restriction&gt;
 *                                                                         &lt;/simpleType&gt;
 *                                                                       &lt;/element&gt;
 *                                                                       &lt;element name="nDoc"&gt;
 *                                                                         &lt;simpleType&gt;
 *                                                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                                             &lt;minLength value="1"/&gt;
 *                                                                             &lt;maxLength value="30"/&gt;
 *                                                                           &lt;/restriction&gt;
 *                                                                         &lt;/simpleType&gt;
 *                                                                       &lt;/element&gt;
 *                                                                       &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *                                                                     &lt;/sequence&gt;
 *                                                                   &lt;/restriction&gt;
 *                                                                 &lt;/complexContent&gt;
 *                                                               &lt;/complexType&gt;
 *                                                             &lt;/element&gt;
 *                                                             &lt;element name="idDocAntEle" maxOccurs="unbounded"&gt;
 *                                                               &lt;complexType&gt;
 *                                                                 &lt;complexContent&gt;
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                     &lt;sequence&gt;
 *                                                                       &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
 *                                                                     &lt;/sequence&gt;
 *                                                                   &lt;/restriction&gt;
 *                                                                 &lt;/complexContent&gt;
 *                                                               &lt;/complexType&gt;
 *                                                             &lt;/element&gt;
 *                                                           &lt;/choice&gt;
 *                                                         &lt;/restriction&gt;
 *                                                       &lt;/complexContent&gt;
 *                                                     &lt;/complexType&gt;
 *                                                   &lt;/element&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="infModal"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;any processContents='skip'/&gt;
 *                                       &lt;/sequence&gt;
 *                                       &lt;attribute name="versaoModal" use="required"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;whiteSpace value="preserve"/&gt;
 *                                             &lt;pattern value="3\.(0[0-9]|[1-9][0-9])"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/attribute&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="veicNovos" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="chassi"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                               &lt;whiteSpace value="preserve"/&gt;
 *                                               &lt;length value="17"/&gt;
 *                                               &lt;pattern value="[A-Z0-9]+"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="cCor"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                               &lt;minLength value="1"/&gt;
 *                                               &lt;maxLength value="4"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="xCor"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                               &lt;minLength value="1"/&gt;
 *                                               &lt;maxLength value="40"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="cMod"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                               &lt;minLength value="1"/&gt;
 *                                               &lt;maxLength value="6"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="vUnit" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                         &lt;element name="vFrete" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="cobr" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="fat" minOccurs="0"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;element name="nFat" minOccurs="0"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                         &lt;minLength value="1"/&gt;
 *                                                         &lt;maxLength value="60"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                   &lt;element name="vOrig" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
 *                                                   &lt;element name="vDesc" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
 *                                                   &lt;element name="vLiq" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="dup" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;element name="nDup" minOccurs="0"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                                         &lt;maxLength value="60"/&gt;
 *                                                         &lt;minLength value="1"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                   &lt;element name="dVenc" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
 *                                                   &lt;element name="vDup" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="infCteSub" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="chCte"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                               &lt;pattern value="[0-9]{44}"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;choice&gt;
 *                                           &lt;element name="refCteAnu"&gt;
 *                                             &lt;simpleType&gt;
 *                                               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TChNFe"&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/simpleType&gt;
 *                                           &lt;/element&gt;
 *                                           &lt;element name="tomaICMS"&gt;
 *                                             &lt;complexType&gt;
 *                                               &lt;complexContent&gt;
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                   &lt;choice&gt;
 *                                                     &lt;element name="refNFe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
 *                                                     &lt;element name="refNF"&gt;
 *                                                       &lt;complexType&gt;
 *                                                         &lt;complexContent&gt;
 *                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                             &lt;sequence&gt;
 *                                                               &lt;choice&gt;
 *                                                                 &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
 *                                                                 &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *                                                               &lt;/choice&gt;
 *                                                               &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModDoc"/&gt;
 *                                                               &lt;element name="serie" type="{http://www.portalfiscal.inf.br/cte}TSerie"/&gt;
 *                                                               &lt;element name="subserie" type="{http://www.portalfiscal.inf.br/cte}TSerie" minOccurs="0"/&gt;
 *                                                               &lt;element name="nro"&gt;
 *                                                                 &lt;simpleType&gt;
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                     &lt;whiteSpace value="preserve"/&gt;
 *                                                                     &lt;pattern value="[0-9]{1,6}"/&gt;
 *                                                                   &lt;/restriction&gt;
 *                                                                 &lt;/simpleType&gt;
 *                                                               &lt;/element&gt;
 *                                                               &lt;element name="valor" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                                                               &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *                                                             &lt;/sequence&gt;
 *                                                           &lt;/restriction&gt;
 *                                                         &lt;/complexContent&gt;
 *                                                       &lt;/complexType&gt;
 *                                                     &lt;/element&gt;
 *                                                     &lt;element name="refCte" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
 *                                                   &lt;/choice&gt;
 *                                                 &lt;/restriction&gt;
 *                                               &lt;/complexContent&gt;
 *                                             &lt;/complexType&gt;
 *                                           &lt;/element&gt;
 *                                         &lt;/choice&gt;
 *                                         &lt;element name="indAlteraToma" minOccurs="0"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                               &lt;enumeration value="1"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="infGlobalizado" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="xObs"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                               &lt;minLength value="15"/&gt;
 *                                               &lt;maxLength value="256"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="infServVinc" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="infCTeMultimodal" maxOccurs="unbounded"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;element name="chCTeMultimodal" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="infCteComp"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="infCteAnu"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="chCte"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                     &lt;pattern value="[0-9]{44}"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="autXML" maxOccurs="10" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *                             &lt;/choice&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="versao" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TVerCTe"&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;attribute name="Id" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID"&gt;
 *                       &lt;pattern value="CTe[0-9]{44}"/&gt;
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
@XmlType(name = "TCTe", propOrder = {
    "infCte",
    "signature"
})
public class TCTe {

    @XmlElement(required = true)
    protected TCTe.InfCte infCte;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    protected SignatureType signature;

    /**
     * Obtém o valor da propriedade infCte.
     * 
     * @return
     *     possible object is
     *     {@link TCTe.InfCte }
     *     
     */
    public TCTe.InfCte getInfCte() {
        return infCte;
    }

    /**
     * Define o valor da propriedade infCte.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTe.InfCte }
     *     
     */
    public void setInfCte(TCTe.InfCte value) {
        this.infCte = value;
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
     *                   &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/cte}TCodUfIBGE"/&gt;
     *                   &lt;element name="cCT"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;pattern value="[0-9]{8}"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="CFOP" type="{http://www.portalfiscal.inf.br/cte}TCfop"/&gt;
     *                   &lt;element name="natOp"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModCT"/&gt;
     *                   &lt;element name="serie"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TSerie"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="nCT" type="{http://www.portalfiscal.inf.br/cte}TNF"/&gt;
     *                   &lt;element name="dhEmi"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="tpImp"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="tpEmis"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="4"/&gt;
     *                         &lt;enumeration value="5"/&gt;
     *                         &lt;enumeration value="7"/&gt;
     *                         &lt;enumeration value="8"/&gt;
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
     *                   &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/cte}TAmb"/&gt;
     *                   &lt;element name="tpCTe" type="{http://www.portalfiscal.inf.br/cte}TFinCTe"/&gt;
     *                   &lt;element name="procEmi" type="{http://www.portalfiscal.inf.br/cte}TProcEmi"/&gt;
     *                   &lt;element name="verProc"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="20"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="indGlobalizado" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="cMunEnv" type="{http://www.portalfiscal.inf.br/cte}TCodMunIBGE"/&gt;
     *                   &lt;element name="xMunEnv"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="2"/&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="UFEnv" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
     *                   &lt;element name="modal" type="{http://www.portalfiscal.inf.br/cte}TModTransp"/&gt;
     *                   &lt;element name="tpServ"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="0"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                         &lt;enumeration value="3"/&gt;
     *                         &lt;enumeration value="4"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="cMunIni" type="{http://www.portalfiscal.inf.br/cte}TCodMunIBGE"/&gt;
     *                   &lt;element name="xMunIni"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="2"/&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="UFIni" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
     *                   &lt;element name="cMunFim" type="{http://www.portalfiscal.inf.br/cte}TCodMunIBGE"/&gt;
     *                   &lt;element name="xMunFim"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="2"/&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="UFFim" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
     *                   &lt;element name="retira"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="0"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xDetRetira" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="160"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="indIEToma"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                         &lt;enumeration value="9"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="toma3"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="toma"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                     &lt;whiteSpace value="preserve"/&gt;
     *                                     &lt;enumeration value="0"/&gt;
     *                                     &lt;enumeration value="1"/&gt;
     *                                     &lt;enumeration value="2"/&gt;
     *                                     &lt;enumeration value="3"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="toma4"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="toma"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                     &lt;whiteSpace value="preserve"/&gt;
     *                                     &lt;enumeration value="4"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;choice&gt;
     *                                 &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
     *                                 &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
     *                               &lt;/choice&gt;
     *                               &lt;element name="IE" minOccurs="0"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;sequence&gt;
     *                                 &lt;element name="xNome"&gt;
     *                                   &lt;simpleType&gt;
     *                                     &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                       &lt;maxLength value="60"/&gt;
     *                                       &lt;minLength value="2"/&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/simpleType&gt;
     *                                 &lt;/element&gt;
     *                                 &lt;element name="xFant" minOccurs="0"&gt;
     *                                   &lt;simpleType&gt;
     *                                     &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                       &lt;maxLength value="60"/&gt;
     *                                       &lt;minLength value="2"/&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/simpleType&gt;
     *                                 &lt;/element&gt;
     *                                 &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
     *                                 &lt;element name="enderToma" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
     *                                 &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
     *                               &lt;/sequence&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/choice&gt;
     *                   &lt;sequence minOccurs="0"&gt;
     *                     &lt;element name="dhCont" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC"/&gt;
     *                     &lt;element name="xJust"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                           &lt;minLength value="15"/&gt;
     *                           &lt;maxLength value="256"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="compl" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="xCaracAd" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="15"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xCaracSer" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="30"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xEmi" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="20"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="fluxo" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="xOrig" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="60"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="pass" maxOccurs="unbounded" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="xPass" minOccurs="0"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                             &lt;minLength value="1"/&gt;
     *                                             &lt;maxLength value="15"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="xDest" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="60"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="xRota" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Entrega" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;choice&gt;
     *                               &lt;element name="semData"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="tpPer"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                               &lt;whiteSpace value="preserve"/&gt;
     *                                               &lt;enumeration value="0"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="comData"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="tpPer"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                               &lt;whiteSpace value="preserve"/&gt;
     *                                               &lt;enumeration value="1"/&gt;
     *                                               &lt;enumeration value="2"/&gt;
     *                                               &lt;enumeration value="3"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                         &lt;element name="dProg" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="noPeriodo"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="tpPer"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                               &lt;whiteSpace value="preserve"/&gt;
     *                                               &lt;enumeration value="4"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                         &lt;element name="dIni" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
     *                                         &lt;element name="dFim" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/choice&gt;
     *                             &lt;choice&gt;
     *                               &lt;element name="semHora"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="tpHor"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                               &lt;whiteSpace value="preserve"/&gt;
     *                                               &lt;enumeration value="0"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="comHora"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="tpHor"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                               &lt;whiteSpace value="preserve"/&gt;
     *                                               &lt;enumeration value="1"/&gt;
     *                                               &lt;enumeration value="2"/&gt;
     *                                               &lt;enumeration value="3"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                         &lt;element name="hProg" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="noInter"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="tpHor"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                               &lt;whiteSpace value="preserve"/&gt;
     *                                               &lt;enumeration value="4"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                         &lt;element name="hIni" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
     *                                         &lt;element name="hFim" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/choice&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="origCalc" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="2"/&gt;
     *                         &lt;maxLength value="40"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="destCalc" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="2"/&gt;
     *                         &lt;maxLength value="40"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xObs" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="2000"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ObsCont" maxOccurs="10" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="xTexto"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="160"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;attribute name="xCampo" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                 &lt;minLength value="1"/&gt;
     *                                 &lt;maxLength value="20"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ObsFisco" maxOccurs="10" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="xTexto"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="60"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;attribute name="xCampo" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                 &lt;minLength value="1"/&gt;
     *                                 &lt;maxLength value="20"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
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
     *                   &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
     *                   &lt;element name="IE"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIe"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="IEST" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIe"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xFant" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="enderEmit" type="{http://www.portalfiscal.inf.br/cte}TEndeEmi"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="rem" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="IE" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xFant" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
     *                   &lt;element name="enderReme" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
     *                   &lt;element name="email" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TEmail"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="exped" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="IE" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
     *                   &lt;element name="enderExped" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
     *                   &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="receb" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="IE" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
     *                   &lt;element name="enderReceb" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
     *                   &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="dest" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="IE" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
     *                   &lt;element name="ISUF" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;pattern value="[0-9]{8,9}"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="enderDest" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
     *                   &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="vPrest"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="vTPrest" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                   &lt;element name="vRec" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                   &lt;element name="Comp" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="xNome"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                   &lt;maxLength value="15"/&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="vComp" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
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
     *         &lt;element name="imp"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ICMS" type="{http://www.portalfiscal.inf.br/cte}TImp"/&gt;
     *                   &lt;element name="vTotTrib" type="{http://www.portalfiscal.inf.br/cte}TDec_1302" minOccurs="0"/&gt;
     *                   &lt;element name="infAdFisco" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;maxLength value="2000"/&gt;
     *                         &lt;minLength value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ICMSUFFim" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="vBCUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                             &lt;element name="pFCPUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
     *                             &lt;element name="pICMSUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
     *                             &lt;element name="pICMSInter" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
     *                             &lt;element name="pICMSInterPart" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
     *                             &lt;element name="vFCPUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                             &lt;element name="vICMSUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                             &lt;element name="vICMSUFIni" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
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
     *         &lt;choice&gt;
     *           &lt;element name="infCTeNorm"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="infCarga"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="vCarga" type="{http://www.portalfiscal.inf.br/cte}TDec_1302" minOccurs="0"/&gt;
     *                               &lt;element name="proPred"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                     &lt;minLength value="1"/&gt;
     *                                     &lt;maxLength value="60"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="xOutCat" minOccurs="0"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                     &lt;minLength value="1"/&gt;
     *                                     &lt;maxLength value="30"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="infQ" maxOccurs="unbounded"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="cUnid"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                               &lt;whiteSpace value="preserve"/&gt;
     *                                               &lt;enumeration value="00"/&gt;
     *                                               &lt;enumeration value="01"/&gt;
     *                                               &lt;enumeration value="02"/&gt;
     *                                               &lt;enumeration value="03"/&gt;
     *                                               &lt;enumeration value="04"/&gt;
     *                                               &lt;enumeration value="05"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                         &lt;element name="tpMed"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                               &lt;minLength value="1"/&gt;
     *                                               &lt;maxLength value="20"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                         &lt;element name="qCarga" type="{http://www.portalfiscal.inf.br/cte}TDec_1104"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="vCargaAverb" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="infDoc" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;choice&gt;
     *                                 &lt;element name="infNF" maxOccurs="unbounded"&gt;
     *                                   &lt;complexType&gt;
     *                                     &lt;complexContent&gt;
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                         &lt;sequence&gt;
     *                                           &lt;element name="nRoma" minOccurs="0"&gt;
     *                                             &lt;simpleType&gt;
     *                                               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                                 &lt;minLength value="1"/&gt;
     *                                                 &lt;maxLength value="20"/&gt;
     *                                               &lt;/restriction&gt;
     *                                             &lt;/simpleType&gt;
     *                                           &lt;/element&gt;
     *                                           &lt;element name="nPed" minOccurs="0"&gt;
     *                                             &lt;simpleType&gt;
     *                                               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                                 &lt;minLength value="1"/&gt;
     *                                                 &lt;maxLength value="20"/&gt;
     *                                               &lt;/restriction&gt;
     *                                             &lt;/simpleType&gt;
     *                                           &lt;/element&gt;
     *                                           &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModNF"/&gt;
     *                                           &lt;element name="serie"&gt;
     *                                             &lt;simpleType&gt;
     *                                               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                                 &lt;minLength value="1"/&gt;
     *                                                 &lt;maxLength value="3"/&gt;
     *                                               &lt;/restriction&gt;
     *                                             &lt;/simpleType&gt;
     *                                           &lt;/element&gt;
     *                                           &lt;element name="nDoc"&gt;
     *                                             &lt;simpleType&gt;
     *                                               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                                 &lt;minLength value="1"/&gt;
     *                                                 &lt;maxLength value="20"/&gt;
     *                                               &lt;/restriction&gt;
     *                                             &lt;/simpleType&gt;
     *                                           &lt;/element&gt;
     *                                           &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
     *                                           &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                                           &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                                           &lt;element name="vBCST" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                                           &lt;element name="vST" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                                           &lt;element name="vProd" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                                           &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                                           &lt;element name="nCFOP" type="{http://www.portalfiscal.inf.br/cte}TCfop"/&gt;
     *                                           &lt;element name="nPeso" type="{http://www.portalfiscal.inf.br/cte}TDec_1203Opc" minOccurs="0"/&gt;
     *                                           &lt;element name="PIN" minOccurs="0"&gt;
     *                                             &lt;simpleType&gt;
     *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                 &lt;whiteSpace value="preserve"/&gt;
     *                                                 &lt;minLength value="2"/&gt;
     *                                                 &lt;maxLength value="9"/&gt;
     *                                                 &lt;pattern value="[1-9]{1}[0-9]{1,8}"/&gt;
     *                                               &lt;/restriction&gt;
     *                                             &lt;/simpleType&gt;
     *                                           &lt;/element&gt;
     *                                           &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
     *                                           &lt;choice&gt;
     *                                             &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                                             &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                                           &lt;/choice&gt;
     *                                         &lt;/sequence&gt;
     *                                       &lt;/restriction&gt;
     *                                     &lt;/complexContent&gt;
     *                                   &lt;/complexType&gt;
     *                                 &lt;/element&gt;
     *                                 &lt;element name="infNFe" maxOccurs="unbounded"&gt;
     *                                   &lt;complexType&gt;
     *                                     &lt;complexContent&gt;
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                         &lt;sequence&gt;
     *                                           &lt;element name="chave" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
     *                                           &lt;element name="PIN" minOccurs="0"&gt;
     *                                             &lt;simpleType&gt;
     *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                 &lt;whiteSpace value="preserve"/&gt;
     *                                                 &lt;minLength value="2"/&gt;
     *                                                 &lt;maxLength value="9"/&gt;
     *                                                 &lt;pattern value="[1-9]{1}[0-9]{1,8}"/&gt;
     *                                               &lt;/restriction&gt;
     *                                             &lt;/simpleType&gt;
     *                                           &lt;/element&gt;
     *                                           &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
     *                                           &lt;choice&gt;
     *                                             &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                                             &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                                           &lt;/choice&gt;
     *                                         &lt;/sequence&gt;
     *                                       &lt;/restriction&gt;
     *                                     &lt;/complexContent&gt;
     *                                   &lt;/complexType&gt;
     *                                 &lt;/element&gt;
     *                                 &lt;element name="infOutros" maxOccurs="unbounded"&gt;
     *                                   &lt;complexType&gt;
     *                                     &lt;complexContent&gt;
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                         &lt;sequence&gt;
     *                                           &lt;element name="tpDoc"&gt;
     *                                             &lt;simpleType&gt;
     *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                 &lt;whiteSpace value="preserve"/&gt;
     *                                                 &lt;enumeration value="00"/&gt;
     *                                                 &lt;enumeration value="10"/&gt;
     *                                                 &lt;enumeration value="59"/&gt;
     *                                                 &lt;enumeration value="65"/&gt;
     *                                                 &lt;enumeration value="99"/&gt;
     *                                               &lt;/restriction&gt;
     *                                             &lt;/simpleType&gt;
     *                                           &lt;/element&gt;
     *                                           &lt;element name="descOutros" minOccurs="0"&gt;
     *                                             &lt;simpleType&gt;
     *                                               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                                 &lt;minLength value="1"/&gt;
     *                                                 &lt;maxLength value="100"/&gt;
     *                                               &lt;/restriction&gt;
     *                                             &lt;/simpleType&gt;
     *                                           &lt;/element&gt;
     *                                           &lt;element name="nDoc" minOccurs="0"&gt;
     *                                             &lt;simpleType&gt;
     *                                               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                                 &lt;minLength value="1"/&gt;
     *                                                 &lt;maxLength value="20"/&gt;
     *                                               &lt;/restriction&gt;
     *                                             &lt;/simpleType&gt;
     *                                           &lt;/element&gt;
     *                                           &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
     *                                           &lt;element name="vDocFisc" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
     *                                           &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
     *                                           &lt;choice&gt;
     *                                             &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                                             &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                                           &lt;/choice&gt;
     *                                         &lt;/sequence&gt;
     *                                       &lt;/restriction&gt;
     *                                     &lt;/complexContent&gt;
     *                                   &lt;/complexType&gt;
     *                                 &lt;/element&gt;
     *                               &lt;/choice&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="docAnt" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="emiDocAnt" maxOccurs="unbounded"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;choice&gt;
     *                                           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
     *                                           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
     *                                         &lt;/choice&gt;
     *                                         &lt;sequence minOccurs="0"&gt;
     *                                           &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe"/&gt;
     *                                           &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
     *                                         &lt;/sequence&gt;
     *                                         &lt;element name="xNome"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                               &lt;maxLength value="60"/&gt;
     *                                               &lt;minLength value="1"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                         &lt;element name="idDocAnt" maxOccurs="2"&gt;
     *                                           &lt;complexType&gt;
     *                                             &lt;complexContent&gt;
     *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                 &lt;choice&gt;
     *                                                   &lt;element name="idDocAntPap" maxOccurs="unbounded"&gt;
     *                                                     &lt;complexType&gt;
     *                                                       &lt;complexContent&gt;
     *                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                           &lt;sequence&gt;
     *                                                             &lt;element name="tpDoc"&gt;
     *                                                               &lt;simpleType&gt;
     *                                                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDocAssoc"&gt;
     *                                                                 &lt;/restriction&gt;
     *                                                               &lt;/simpleType&gt;
     *                                                             &lt;/element&gt;
     *                                                             &lt;element name="serie"&gt;
     *                                                               &lt;simpleType&gt;
     *                                                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                                                   &lt;minLength value="1"/&gt;
     *                                                                   &lt;maxLength value="3"/&gt;
     *                                                                 &lt;/restriction&gt;
     *                                                               &lt;/simpleType&gt;
     *                                                             &lt;/element&gt;
     *                                                             &lt;element name="subser" minOccurs="0"&gt;
     *                                                               &lt;simpleType&gt;
     *                                                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                                                   &lt;minLength value="1"/&gt;
     *                                                                   &lt;maxLength value="2"/&gt;
     *                                                                 &lt;/restriction&gt;
     *                                                               &lt;/simpleType&gt;
     *                                                             &lt;/element&gt;
     *                                                             &lt;element name="nDoc"&gt;
     *                                                               &lt;simpleType&gt;
     *                                                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                                                   &lt;minLength value="1"/&gt;
     *                                                                   &lt;maxLength value="30"/&gt;
     *                                                                 &lt;/restriction&gt;
     *                                                               &lt;/simpleType&gt;
     *                                                             &lt;/element&gt;
     *                                                             &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
     *                                                           &lt;/sequence&gt;
     *                                                         &lt;/restriction&gt;
     *                                                       &lt;/complexContent&gt;
     *                                                     &lt;/complexType&gt;
     *                                                   &lt;/element&gt;
     *                                                   &lt;element name="idDocAntEle" maxOccurs="unbounded"&gt;
     *                                                     &lt;complexType&gt;
     *                                                       &lt;complexContent&gt;
     *                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                           &lt;sequence&gt;
     *                                                             &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
     *                                                           &lt;/sequence&gt;
     *                                                         &lt;/restriction&gt;
     *                                                       &lt;/complexContent&gt;
     *                                                     &lt;/complexType&gt;
     *                                                   &lt;/element&gt;
     *                                                 &lt;/choice&gt;
     *                                               &lt;/restriction&gt;
     *                                             &lt;/complexContent&gt;
     *                                           &lt;/complexType&gt;
     *                                         &lt;/element&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="infModal"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;any processContents='skip'/&gt;
     *                             &lt;/sequence&gt;
     *                             &lt;attribute name="versaoModal" use="required"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;whiteSpace value="preserve"/&gt;
     *                                   &lt;pattern value="3\.(0[0-9]|[1-9][0-9])"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/attribute&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="veicNovos" maxOccurs="unbounded" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="chassi"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                     &lt;whiteSpace value="preserve"/&gt;
     *                                     &lt;length value="17"/&gt;
     *                                     &lt;pattern value="[A-Z0-9]+"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="cCor"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                     &lt;minLength value="1"/&gt;
     *                                     &lt;maxLength value="4"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="xCor"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                     &lt;minLength value="1"/&gt;
     *                                     &lt;maxLength value="40"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="cMod"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                     &lt;minLength value="1"/&gt;
     *                                     &lt;maxLength value="6"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="vUnit" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                               &lt;element name="vFrete" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="cobr" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="fat" minOccurs="0"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="nFat" minOccurs="0"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                               &lt;minLength value="1"/&gt;
     *                                               &lt;maxLength value="60"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                         &lt;element name="vOrig" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
     *                                         &lt;element name="vDesc" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
     *                                         &lt;element name="vLiq" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="dup" maxOccurs="unbounded" minOccurs="0"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="nDup" minOccurs="0"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                               &lt;maxLength value="60"/&gt;
     *                                               &lt;minLength value="1"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                         &lt;element name="dVenc" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
     *                                         &lt;element name="vDup" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="infCteSub" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="chCte"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                     &lt;pattern value="[0-9]{44}"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;choice&gt;
     *                                 &lt;element name="refCteAnu"&gt;
     *                                   &lt;simpleType&gt;
     *                                     &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TChNFe"&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/simpleType&gt;
     *                                 &lt;/element&gt;
     *                                 &lt;element name="tomaICMS"&gt;
     *                                   &lt;complexType&gt;
     *                                     &lt;complexContent&gt;
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                         &lt;choice&gt;
     *                                           &lt;element name="refNFe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
     *                                           &lt;element name="refNF"&gt;
     *                                             &lt;complexType&gt;
     *                                               &lt;complexContent&gt;
     *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                   &lt;sequence&gt;
     *                                                     &lt;choice&gt;
     *                                                       &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
     *                                                       &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
     *                                                     &lt;/choice&gt;
     *                                                     &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModDoc"/&gt;
     *                                                     &lt;element name="serie" type="{http://www.portalfiscal.inf.br/cte}TSerie"/&gt;
     *                                                     &lt;element name="subserie" type="{http://www.portalfiscal.inf.br/cte}TSerie" minOccurs="0"/&gt;
     *                                                     &lt;element name="nro"&gt;
     *                                                       &lt;simpleType&gt;
     *                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                           &lt;whiteSpace value="preserve"/&gt;
     *                                                           &lt;pattern value="[0-9]{1,6}"/&gt;
     *                                                         &lt;/restriction&gt;
     *                                                       &lt;/simpleType&gt;
     *                                                     &lt;/element&gt;
     *                                                     &lt;element name="valor" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *                                                     &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
     *                                                   &lt;/sequence&gt;
     *                                                 &lt;/restriction&gt;
     *                                               &lt;/complexContent&gt;
     *                                             &lt;/complexType&gt;
     *                                           &lt;/element&gt;
     *                                           &lt;element name="refCte" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
     *                                         &lt;/choice&gt;
     *                                       &lt;/restriction&gt;
     *                                     &lt;/complexContent&gt;
     *                                   &lt;/complexType&gt;
     *                                 &lt;/element&gt;
     *                               &lt;/choice&gt;
     *                               &lt;element name="indAlteraToma" minOccurs="0"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                     &lt;enumeration value="1"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="infGlobalizado" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="xObs"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                     &lt;minLength value="15"/&gt;
     *                                     &lt;maxLength value="256"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="infServVinc" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="infCTeMultimodal" maxOccurs="unbounded"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="chCTeMultimodal" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="infCteComp"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="infCteAnu"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="chCte"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                           &lt;pattern value="[0-9]{44}"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="autXML" maxOccurs="10" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
     *                   &lt;/choice&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="versao" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TVerCTe"&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="Id" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID"&gt;
     *             &lt;pattern value="CTe[0-9]{44}"/&gt;
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
        "compl",
        "emit",
        "rem",
        "exped",
        "receb",
        "dest",
        "vPrest",
        "imp",
        "infCTeNorm",
        "infCteComp",
        "infCteAnu",
        "autXML"
    })
    public static class InfCte {

        @XmlElement(required = true)
        protected TCTe.InfCte.Ide ide;
        protected TCTe.InfCte.Compl compl;
        @XmlElement(required = true)
        protected TCTe.InfCte.Emit emit;
        protected TCTe.InfCte.Rem rem;
        protected TCTe.InfCte.Exped exped;
        protected TCTe.InfCte.Receb receb;
        protected TCTe.InfCte.Dest dest;
        @XmlElement(required = true)
        protected TCTe.InfCte.VPrest vPrest;
        @XmlElement(required = true)
        protected TCTe.InfCte.Imp imp;
        protected TCTe.InfCte.InfCTeNorm infCTeNorm;
        protected TCTe.InfCte.InfCteComp infCteComp;
        protected TCTe.InfCte.InfCteAnu infCteAnu;
        protected List<TCTe.InfCte.AutXML> autXML;
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
         *     {@link TCTe.InfCte.Ide }
         *     
         */
        public TCTe.InfCte.Ide getIde() {
            return ide;
        }

        /**
         * Define o valor da propriedade ide.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.Ide }
         *     
         */
        public void setIde(TCTe.InfCte.Ide value) {
            this.ide = value;
        }

        /**
         * Obtém o valor da propriedade compl.
         * 
         * @return
         *     possible object is
         *     {@link TCTe.InfCte.Compl }
         *     
         */
        public TCTe.InfCte.Compl getCompl() {
            return compl;
        }

        /**
         * Define o valor da propriedade compl.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.Compl }
         *     
         */
        public void setCompl(TCTe.InfCte.Compl value) {
            this.compl = value;
        }

        /**
         * Obtém o valor da propriedade emit.
         * 
         * @return
         *     possible object is
         *     {@link TCTe.InfCte.Emit }
         *     
         */
        public TCTe.InfCte.Emit getEmit() {
            return emit;
        }

        /**
         * Define o valor da propriedade emit.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.Emit }
         *     
         */
        public void setEmit(TCTe.InfCte.Emit value) {
            this.emit = value;
        }

        /**
         * Obtém o valor da propriedade rem.
         * 
         * @return
         *     possible object is
         *     {@link TCTe.InfCte.Rem }
         *     
         */
        public TCTe.InfCte.Rem getRem() {
            return rem;
        }

        /**
         * Define o valor da propriedade rem.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.Rem }
         *     
         */
        public void setRem(TCTe.InfCte.Rem value) {
            this.rem = value;
        }

        /**
         * Obtém o valor da propriedade exped.
         * 
         * @return
         *     possible object is
         *     {@link TCTe.InfCte.Exped }
         *     
         */
        public TCTe.InfCte.Exped getExped() {
            return exped;
        }

        /**
         * Define o valor da propriedade exped.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.Exped }
         *     
         */
        public void setExped(TCTe.InfCte.Exped value) {
            this.exped = value;
        }

        /**
         * Obtém o valor da propriedade receb.
         * 
         * @return
         *     possible object is
         *     {@link TCTe.InfCte.Receb }
         *     
         */
        public TCTe.InfCte.Receb getReceb() {
            return receb;
        }

        /**
         * Define o valor da propriedade receb.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.Receb }
         *     
         */
        public void setReceb(TCTe.InfCte.Receb value) {
            this.receb = value;
        }

        /**
         * Obtém o valor da propriedade dest.
         * 
         * @return
         *     possible object is
         *     {@link TCTe.InfCte.Dest }
         *     
         */
        public TCTe.InfCte.Dest getDest() {
            return dest;
        }

        /**
         * Define o valor da propriedade dest.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.Dest }
         *     
         */
        public void setDest(TCTe.InfCte.Dest value) {
            this.dest = value;
        }

        /**
         * Obtém o valor da propriedade vPrest.
         * 
         * @return
         *     possible object is
         *     {@link TCTe.InfCte.VPrest }
         *     
         */
        public TCTe.InfCte.VPrest getVPrest() {
            return vPrest;
        }

        /**
         * Define o valor da propriedade vPrest.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.VPrest }
         *     
         */
        public void setVPrest(TCTe.InfCte.VPrest value) {
            this.vPrest = value;
        }

        /**
         * Obtém o valor da propriedade imp.
         * 
         * @return
         *     possible object is
         *     {@link TCTe.InfCte.Imp }
         *     
         */
        public TCTe.InfCte.Imp getImp() {
            return imp;
        }

        /**
         * Define o valor da propriedade imp.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.Imp }
         *     
         */
        public void setImp(TCTe.InfCte.Imp value) {
            this.imp = value;
        }

        /**
         * Obtém o valor da propriedade infCTeNorm.
         * 
         * @return
         *     possible object is
         *     {@link TCTe.InfCte.InfCTeNorm }
         *     
         */
        public TCTe.InfCte.InfCTeNorm getInfCTeNorm() {
            return infCTeNorm;
        }

        /**
         * Define o valor da propriedade infCTeNorm.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.InfCTeNorm }
         *     
         */
        public void setInfCTeNorm(TCTe.InfCte.InfCTeNorm value) {
            this.infCTeNorm = value;
        }

        /**
         * Obtém o valor da propriedade infCteComp.
         * 
         * @return
         *     possible object is
         *     {@link TCTe.InfCte.InfCteComp }
         *     
         */
        public TCTe.InfCte.InfCteComp getInfCteComp() {
            return infCteComp;
        }

        /**
         * Define o valor da propriedade infCteComp.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.InfCteComp }
         *     
         */
        public void setInfCteComp(TCTe.InfCte.InfCteComp value) {
            this.infCteComp = value;
        }

        /**
         * Obtém o valor da propriedade infCteAnu.
         * 
         * @return
         *     possible object is
         *     {@link TCTe.InfCte.InfCteAnu }
         *     
         */
        public TCTe.InfCte.InfCteAnu getInfCteAnu() {
            return infCteAnu;
        }

        /**
         * Define o valor da propriedade infCteAnu.
         * 
         * @param value
         *     allowed object is
         *     {@link TCTe.InfCte.InfCteAnu }
         *     
         */
        public void setInfCteAnu(TCTe.InfCte.InfCteAnu value) {
            this.infCteAnu = value;
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
         * {@link TCTe.InfCte.AutXML }
         * 
         * 
         */
        public List<TCTe.InfCte.AutXML> getAutXML() {
            if (autXML == null) {
                autXML = new ArrayList<TCTe.InfCte.AutXML>();
            }
            return this.autXML;
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
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
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
         *         &lt;element name="xCaracAd" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="15"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xCaracSer" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="30"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xEmi" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="20"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="fluxo" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="xOrig" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="60"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="pass" maxOccurs="unbounded" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="xPass" minOccurs="0"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                   &lt;minLength value="1"/&gt;
         *                                   &lt;maxLength value="15"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="xDest" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="60"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="xRota" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Entrega" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;choice&gt;
         *                     &lt;element name="semData"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="tpPer"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                     &lt;whiteSpace value="preserve"/&gt;
         *                                     &lt;enumeration value="0"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="comData"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="tpPer"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                     &lt;whiteSpace value="preserve"/&gt;
         *                                     &lt;enumeration value="1"/&gt;
         *                                     &lt;enumeration value="2"/&gt;
         *                                     &lt;enumeration value="3"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="dProg" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="noPeriodo"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="tpPer"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                     &lt;whiteSpace value="preserve"/&gt;
         *                                     &lt;enumeration value="4"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="dIni" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
         *                               &lt;element name="dFim" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                   &lt;/choice&gt;
         *                   &lt;choice&gt;
         *                     &lt;element name="semHora"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="tpHor"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                     &lt;whiteSpace value="preserve"/&gt;
         *                                     &lt;enumeration value="0"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="comHora"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="tpHor"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                     &lt;whiteSpace value="preserve"/&gt;
         *                                     &lt;enumeration value="1"/&gt;
         *                                     &lt;enumeration value="2"/&gt;
         *                                     &lt;enumeration value="3"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="hProg" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="noInter"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="tpHor"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                     &lt;whiteSpace value="preserve"/&gt;
         *                                     &lt;enumeration value="4"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="hIni" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
         *                               &lt;element name="hFim" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                   &lt;/choice&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="origCalc" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="2"/&gt;
         *               &lt;maxLength value="40"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="destCalc" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="2"/&gt;
         *               &lt;maxLength value="40"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xObs" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="2000"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ObsCont" maxOccurs="10" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="xTexto"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="160"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *                 &lt;attribute name="xCampo" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                       &lt;minLength value="1"/&gt;
         *                       &lt;maxLength value="20"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ObsFisco" maxOccurs="10" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="xTexto"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="60"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *                 &lt;attribute name="xCampo" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                       &lt;minLength value="1"/&gt;
         *                       &lt;maxLength value="20"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
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
            "xCaracAd",
            "xCaracSer",
            "xEmi",
            "fluxo",
            "entrega",
            "origCalc",
            "destCalc",
            "xObs",
            "obsCont",
            "obsFisco"
        })
        public static class Compl {

            protected String xCaracAd;
            protected String xCaracSer;
            protected String xEmi;
            protected TCTe.InfCte.Compl.Fluxo fluxo;
            @XmlElement(name = "Entrega")
            protected TCTe.InfCte.Compl.Entrega entrega;
            protected String origCalc;
            protected String destCalc;
            protected String xObs;
            @XmlElement(name = "ObsCont")
            protected List<TCTe.InfCte.Compl.ObsCont> obsCont;
            @XmlElement(name = "ObsFisco")
            protected List<TCTe.InfCte.Compl.ObsFisco> obsFisco;

            /**
             * Obtém o valor da propriedade xCaracAd.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXCaracAd() {
                return xCaracAd;
            }

            /**
             * Define o valor da propriedade xCaracAd.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXCaracAd(String value) {
                this.xCaracAd = value;
            }

            /**
             * Obtém o valor da propriedade xCaracSer.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXCaracSer() {
                return xCaracSer;
            }

            /**
             * Define o valor da propriedade xCaracSer.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXCaracSer(String value) {
                this.xCaracSer = value;
            }

            /**
             * Obtém o valor da propriedade xEmi.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXEmi() {
                return xEmi;
            }

            /**
             * Define o valor da propriedade xEmi.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXEmi(String value) {
                this.xEmi = value;
            }

            /**
             * Obtém o valor da propriedade fluxo.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.Compl.Fluxo }
             *     
             */
            public TCTe.InfCte.Compl.Fluxo getFluxo() {
                return fluxo;
            }

            /**
             * Define o valor da propriedade fluxo.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.Compl.Fluxo }
             *     
             */
            public void setFluxo(TCTe.InfCte.Compl.Fluxo value) {
                this.fluxo = value;
            }

            /**
             * Obtém o valor da propriedade entrega.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.Compl.Entrega }
             *     
             */
            public TCTe.InfCte.Compl.Entrega getEntrega() {
                return entrega;
            }

            /**
             * Define o valor da propriedade entrega.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.Compl.Entrega }
             *     
             */
            public void setEntrega(TCTe.InfCte.Compl.Entrega value) {
                this.entrega = value;
            }

            /**
             * Obtém o valor da propriedade origCalc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOrigCalc() {
                return origCalc;
            }

            /**
             * Define o valor da propriedade origCalc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOrigCalc(String value) {
                this.origCalc = value;
            }

            /**
             * Obtém o valor da propriedade destCalc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDestCalc() {
                return destCalc;
            }

            /**
             * Define o valor da propriedade destCalc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDestCalc(String value) {
                this.destCalc = value;
            }

            /**
             * Obtém o valor da propriedade xObs.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXObs() {
                return xObs;
            }

            /**
             * Define o valor da propriedade xObs.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXObs(String value) {
                this.xObs = value;
            }

            /**
             * Gets the value of the obsCont property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the obsCont property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getObsCont().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TCTe.InfCte.Compl.ObsCont }
             * 
             * 
             */
            public List<TCTe.InfCte.Compl.ObsCont> getObsCont() {
                if (obsCont == null) {
                    obsCont = new ArrayList<TCTe.InfCte.Compl.ObsCont>();
                }
                return this.obsCont;
            }

            /**
             * Gets the value of the obsFisco property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the obsFisco property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getObsFisco().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TCTe.InfCte.Compl.ObsFisco }
             * 
             * 
             */
            public List<TCTe.InfCte.Compl.ObsFisco> getObsFisco() {
                if (obsFisco == null) {
                    obsFisco = new ArrayList<TCTe.InfCte.Compl.ObsFisco>();
                }
                return this.obsFisco;
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
             *           &lt;element name="semData"&gt;
             *             &lt;complexType&gt;
             *               &lt;complexContent&gt;
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                   &lt;sequence&gt;
             *                     &lt;element name="tpPer"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                           &lt;whiteSpace value="preserve"/&gt;
             *                           &lt;enumeration value="0"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                   &lt;/sequence&gt;
             *                 &lt;/restriction&gt;
             *               &lt;/complexContent&gt;
             *             &lt;/complexType&gt;
             *           &lt;/element&gt;
             *           &lt;element name="comData"&gt;
             *             &lt;complexType&gt;
             *               &lt;complexContent&gt;
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                   &lt;sequence&gt;
             *                     &lt;element name="tpPer"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                           &lt;whiteSpace value="preserve"/&gt;
             *                           &lt;enumeration value="1"/&gt;
             *                           &lt;enumeration value="2"/&gt;
             *                           &lt;enumeration value="3"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="dProg" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
             *                   &lt;/sequence&gt;
             *                 &lt;/restriction&gt;
             *               &lt;/complexContent&gt;
             *             &lt;/complexType&gt;
             *           &lt;/element&gt;
             *           &lt;element name="noPeriodo"&gt;
             *             &lt;complexType&gt;
             *               &lt;complexContent&gt;
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                   &lt;sequence&gt;
             *                     &lt;element name="tpPer"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                           &lt;whiteSpace value="preserve"/&gt;
             *                           &lt;enumeration value="4"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="dIni" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
             *                     &lt;element name="dFim" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
             *                   &lt;/sequence&gt;
             *                 &lt;/restriction&gt;
             *               &lt;/complexContent&gt;
             *             &lt;/complexType&gt;
             *           &lt;/element&gt;
             *         &lt;/choice&gt;
             *         &lt;choice&gt;
             *           &lt;element name="semHora"&gt;
             *             &lt;complexType&gt;
             *               &lt;complexContent&gt;
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                   &lt;sequence&gt;
             *                     &lt;element name="tpHor"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                           &lt;whiteSpace value="preserve"/&gt;
             *                           &lt;enumeration value="0"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                   &lt;/sequence&gt;
             *                 &lt;/restriction&gt;
             *               &lt;/complexContent&gt;
             *             &lt;/complexType&gt;
             *           &lt;/element&gt;
             *           &lt;element name="comHora"&gt;
             *             &lt;complexType&gt;
             *               &lt;complexContent&gt;
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                   &lt;sequence&gt;
             *                     &lt;element name="tpHor"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                           &lt;whiteSpace value="preserve"/&gt;
             *                           &lt;enumeration value="1"/&gt;
             *                           &lt;enumeration value="2"/&gt;
             *                           &lt;enumeration value="3"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="hProg" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
             *                   &lt;/sequence&gt;
             *                 &lt;/restriction&gt;
             *               &lt;/complexContent&gt;
             *             &lt;/complexType&gt;
             *           &lt;/element&gt;
             *           &lt;element name="noInter"&gt;
             *             &lt;complexType&gt;
             *               &lt;complexContent&gt;
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                   &lt;sequence&gt;
             *                     &lt;element name="tpHor"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                           &lt;whiteSpace value="preserve"/&gt;
             *                           &lt;enumeration value="4"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="hIni" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
             *                     &lt;element name="hFim" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
             *                   &lt;/sequence&gt;
             *                 &lt;/restriction&gt;
             *               &lt;/complexContent&gt;
             *             &lt;/complexType&gt;
             *           &lt;/element&gt;
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
                "semData",
                "comData",
                "noPeriodo",
                "semHora",
                "comHora",
                "noInter"
            })
            public static class Entrega {

                protected TCTe.InfCte.Compl.Entrega.SemData semData;
                protected TCTe.InfCte.Compl.Entrega.ComData comData;
                protected TCTe.InfCte.Compl.Entrega.NoPeriodo noPeriodo;
                protected TCTe.InfCte.Compl.Entrega.SemHora semHora;
                protected TCTe.InfCte.Compl.Entrega.ComHora comHora;
                protected TCTe.InfCte.Compl.Entrega.NoInter noInter;

                /**
                 * Obtém o valor da propriedade semData.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TCTe.InfCte.Compl.Entrega.SemData }
                 *     
                 */
                public TCTe.InfCte.Compl.Entrega.SemData getSemData() {
                    return semData;
                }

                /**
                 * Define o valor da propriedade semData.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TCTe.InfCte.Compl.Entrega.SemData }
                 *     
                 */
                public void setSemData(TCTe.InfCte.Compl.Entrega.SemData value) {
                    this.semData = value;
                }

                /**
                 * Obtém o valor da propriedade comData.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TCTe.InfCte.Compl.Entrega.ComData }
                 *     
                 */
                public TCTe.InfCte.Compl.Entrega.ComData getComData() {
                    return comData;
                }

                /**
                 * Define o valor da propriedade comData.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TCTe.InfCte.Compl.Entrega.ComData }
                 *     
                 */
                public void setComData(TCTe.InfCte.Compl.Entrega.ComData value) {
                    this.comData = value;
                }

                /**
                 * Obtém o valor da propriedade noPeriodo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TCTe.InfCte.Compl.Entrega.NoPeriodo }
                 *     
                 */
                public TCTe.InfCte.Compl.Entrega.NoPeriodo getNoPeriodo() {
                    return noPeriodo;
                }

                /**
                 * Define o valor da propriedade noPeriodo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TCTe.InfCte.Compl.Entrega.NoPeriodo }
                 *     
                 */
                public void setNoPeriodo(TCTe.InfCte.Compl.Entrega.NoPeriodo value) {
                    this.noPeriodo = value;
                }

                /**
                 * Obtém o valor da propriedade semHora.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TCTe.InfCte.Compl.Entrega.SemHora }
                 *     
                 */
                public TCTe.InfCte.Compl.Entrega.SemHora getSemHora() {
                    return semHora;
                }

                /**
                 * Define o valor da propriedade semHora.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TCTe.InfCte.Compl.Entrega.SemHora }
                 *     
                 */
                public void setSemHora(TCTe.InfCte.Compl.Entrega.SemHora value) {
                    this.semHora = value;
                }

                /**
                 * Obtém o valor da propriedade comHora.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TCTe.InfCte.Compl.Entrega.ComHora }
                 *     
                 */
                public TCTe.InfCte.Compl.Entrega.ComHora getComHora() {
                    return comHora;
                }

                /**
                 * Define o valor da propriedade comHora.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TCTe.InfCte.Compl.Entrega.ComHora }
                 *     
                 */
                public void setComHora(TCTe.InfCte.Compl.Entrega.ComHora value) {
                    this.comHora = value;
                }

                /**
                 * Obtém o valor da propriedade noInter.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TCTe.InfCte.Compl.Entrega.NoInter }
                 *     
                 */
                public TCTe.InfCte.Compl.Entrega.NoInter getNoInter() {
                    return noInter;
                }

                /**
                 * Define o valor da propriedade noInter.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TCTe.InfCte.Compl.Entrega.NoInter }
                 *     
                 */
                public void setNoInter(TCTe.InfCte.Compl.Entrega.NoInter value) {
                    this.noInter = value;
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
                 *         &lt;element name="tpPer"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;whiteSpace value="preserve"/&gt;
                 *               &lt;enumeration value="1"/&gt;
                 *               &lt;enumeration value="2"/&gt;
                 *               &lt;enumeration value="3"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="dProg" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
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
                    "tpPer",
                    "dProg"
                })
                public static class ComData {

                    @XmlElement(required = true)
                    protected String tpPer;
                    @XmlElement(required = true)
                    protected String dProg;

                    /**
                     * Obtém o valor da propriedade tpPer.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTpPer() {
                        return tpPer;
                    }

                    /**
                     * Define o valor da propriedade tpPer.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTpPer(String value) {
                        this.tpPer = value;
                    }

                    /**
                     * Obtém o valor da propriedade dProg.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDProg() {
                        return dProg;
                    }

                    /**
                     * Define o valor da propriedade dProg.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDProg(String value) {
                        this.dProg = value;
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
                 *         &lt;element name="tpHor"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;whiteSpace value="preserve"/&gt;
                 *               &lt;enumeration value="1"/&gt;
                 *               &lt;enumeration value="2"/&gt;
                 *               &lt;enumeration value="3"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="hProg" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
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
                    "tpHor",
                    "hProg"
                })
                public static class ComHora {

                    @XmlElement(required = true)
                    protected String tpHor;
                    @XmlElement(required = true)
                    protected String hProg;

                    /**
                     * Obtém o valor da propriedade tpHor.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTpHor() {
                        return tpHor;
                    }

                    /**
                     * Define o valor da propriedade tpHor.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTpHor(String value) {
                        this.tpHor = value;
                    }

                    /**
                     * Obtém o valor da propriedade hProg.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getHProg() {
                        return hProg;
                    }

                    /**
                     * Define o valor da propriedade hProg.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setHProg(String value) {
                        this.hProg = value;
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
                 *         &lt;element name="tpHor"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;whiteSpace value="preserve"/&gt;
                 *               &lt;enumeration value="4"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="hIni" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
                 *         &lt;element name="hFim" type="{http://www.portalfiscal.inf.br/cte}TTime"/&gt;
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
                    "tpHor",
                    "hIni",
                    "hFim"
                })
                public static class NoInter {

                    @XmlElement(required = true)
                    protected String tpHor;
                    @XmlElement(required = true)
                    protected String hIni;
                    @XmlElement(required = true)
                    protected String hFim;

                    /**
                     * Obtém o valor da propriedade tpHor.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTpHor() {
                        return tpHor;
                    }

                    /**
                     * Define o valor da propriedade tpHor.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTpHor(String value) {
                        this.tpHor = value;
                    }

                    /**
                     * Obtém o valor da propriedade hIni.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getHIni() {
                        return hIni;
                    }

                    /**
                     * Define o valor da propriedade hIni.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setHIni(String value) {
                        this.hIni = value;
                    }

                    /**
                     * Obtém o valor da propriedade hFim.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getHFim() {
                        return hFim;
                    }

                    /**
                     * Define o valor da propriedade hFim.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setHFim(String value) {
                        this.hFim = value;
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
                 *         &lt;element name="tpPer"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;whiteSpace value="preserve"/&gt;
                 *               &lt;enumeration value="4"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="dIni" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
                 *         &lt;element name="dFim" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
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
                    "tpPer",
                    "dIni",
                    "dFim"
                })
                public static class NoPeriodo {

                    @XmlElement(required = true)
                    protected String tpPer;
                    @XmlElement(required = true)
                    protected String dIni;
                    @XmlElement(required = true)
                    protected String dFim;

                    /**
                     * Obtém o valor da propriedade tpPer.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTpPer() {
                        return tpPer;
                    }

                    /**
                     * Define o valor da propriedade tpPer.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTpPer(String value) {
                        this.tpPer = value;
                    }

                    /**
                     * Obtém o valor da propriedade dIni.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDIni() {
                        return dIni;
                    }

                    /**
                     * Define o valor da propriedade dIni.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDIni(String value) {
                        this.dIni = value;
                    }

                    /**
                     * Obtém o valor da propriedade dFim.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDFim() {
                        return dFim;
                    }

                    /**
                     * Define o valor da propriedade dFim.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDFim(String value) {
                        this.dFim = value;
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
                 *         &lt;element name="tpPer"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;whiteSpace value="preserve"/&gt;
                 *               &lt;enumeration value="0"/&gt;
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
                    "tpPer"
                })
                public static class SemData {

                    @XmlElement(required = true)
                    protected String tpPer;

                    /**
                     * Obtém o valor da propriedade tpPer.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTpPer() {
                        return tpPer;
                    }

                    /**
                     * Define o valor da propriedade tpPer.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTpPer(String value) {
                        this.tpPer = value;
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
                 *         &lt;element name="tpHor"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;whiteSpace value="preserve"/&gt;
                 *               &lt;enumeration value="0"/&gt;
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
                    "tpHor"
                })
                public static class SemHora {

                    @XmlElement(required = true)
                    protected String tpHor;

                    /**
                     * Obtém o valor da propriedade tpHor.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTpHor() {
                        return tpHor;
                    }

                    /**
                     * Define o valor da propriedade tpHor.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTpHor(String value) {
                        this.tpHor = value;
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
             *         &lt;element name="xOrig" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="60"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="pass" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="xPass" minOccurs="0"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                         &lt;minLength value="1"/&gt;
             *                         &lt;maxLength value="15"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="xDest" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="60"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="xRota" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="10"/&gt;
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
                "xOrig",
                "pass",
                "xDest",
                "xRota"
            })
            public static class Fluxo {

                protected String xOrig;
                protected List<TCTe.InfCte.Compl.Fluxo.Pass> pass;
                protected String xDest;
                protected String xRota;

                /**
                 * Obtém o valor da propriedade xOrig.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXOrig() {
                    return xOrig;
                }

                /**
                 * Define o valor da propriedade xOrig.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXOrig(String value) {
                    this.xOrig = value;
                }

                /**
                 * Gets the value of the pass property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the pass property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getPass().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TCTe.InfCte.Compl.Fluxo.Pass }
                 * 
                 * 
                 */
                public List<TCTe.InfCte.Compl.Fluxo.Pass> getPass() {
                    if (pass == null) {
                        pass = new ArrayList<TCTe.InfCte.Compl.Fluxo.Pass>();
                    }
                    return this.pass;
                }

                /**
                 * Obtém o valor da propriedade xDest.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXDest() {
                    return xDest;
                }

                /**
                 * Define o valor da propriedade xDest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXDest(String value) {
                    this.xDest = value;
                }

                /**
                 * Obtém o valor da propriedade xRota.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXRota() {
                    return xRota;
                }

                /**
                 * Define o valor da propriedade xRota.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXRota(String value) {
                    this.xRota = value;
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
                 *         &lt;element name="xPass" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *               &lt;minLength value="1"/&gt;
                 *               &lt;maxLength value="15"/&gt;
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
                    "xPass"
                })
                public static class Pass {

                    protected String xPass;

                    /**
                     * Obtém o valor da propriedade xPass.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getXPass() {
                        return xPass;
                    }

                    /**
                     * Define o valor da propriedade xPass.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setXPass(String value) {
                        this.xPass = value;
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
             *         &lt;element name="xTexto"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="160"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *       &lt;attribute name="xCampo" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *             &lt;minLength value="1"/&gt;
             *             &lt;maxLength value="20"/&gt;
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
                "xTexto"
            })
            public static class ObsCont {

                @XmlElement(required = true)
                protected String xTexto;
                @XmlAttribute(name = "xCampo", required = true)
                protected String xCampo;

                /**
                 * Obtém o valor da propriedade xTexto.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXTexto() {
                    return xTexto;
                }

                /**
                 * Define o valor da propriedade xTexto.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXTexto(String value) {
                    this.xTexto = value;
                }

                /**
                 * Obtém o valor da propriedade xCampo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXCampo() {
                    return xCampo;
                }

                /**
                 * Define o valor da propriedade xCampo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXCampo(String value) {
                    this.xCampo = value;
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
             *         &lt;element name="xTexto"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="60"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *       &lt;attribute name="xCampo" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *             &lt;minLength value="1"/&gt;
             *             &lt;maxLength value="20"/&gt;
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
                "xTexto"
            })
            public static class ObsFisco {

                @XmlElement(required = true)
                protected String xTexto;
                @XmlAttribute(name = "xCampo", required = true)
                protected String xCampo;

                /**
                 * Obtém o valor da propriedade xTexto.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXTexto() {
                    return xTexto;
                }

                /**
                 * Define o valor da propriedade xTexto.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXTexto(String value) {
                    this.xTexto = value;
                }

                /**
                 * Obtém o valor da propriedade xCampo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXCampo() {
                    return xCampo;
                }

                /**
                 * Define o valor da propriedade xCampo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXCampo(String value) {
                    this.xCampo = value;
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
         *         &lt;choice&gt;
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="IE" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
         *         &lt;element name="ISUF" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;pattern value="[0-9]{8,9}"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="enderDest" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
         *         &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
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
            "ie",
            "xNome",
            "fone",
            "isuf",
            "enderDest",
            "email"
        })
        public static class Dest {

            @XmlElement(name = "CNPJ")
            protected String cnpj;
            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(name = "IE")
            protected String ie;
            @XmlElement(required = true)
            protected String xNome;
            protected String fone;
            @XmlElement(name = "ISUF")
            protected String isuf;
            @XmlElement(required = true)
            protected TEndereco enderDest;
            protected String email;

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
             * Obtém o valor da propriedade fone.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFone() {
                return fone;
            }

            /**
             * Define o valor da propriedade fone.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFone(String value) {
                this.fone = value;
            }

            /**
             * Obtém o valor da propriedade isuf.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getISUF() {
                return isuf;
            }

            /**
             * Define o valor da propriedade isuf.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setISUF(String value) {
                this.isuf = value;
            }

            /**
             * Obtém o valor da propriedade enderDest.
             * 
             * @return
             *     possible object is
             *     {@link TEndereco }
             *     
             */
            public TEndereco getEnderDest() {
                return enderDest;
            }

            /**
             * Define o valor da propriedade enderDest.
             * 
             * @param value
             *     allowed object is
             *     {@link TEndereco }
             *     
             */
            public void setEnderDest(TEndereco value) {
                this.enderDest = value;
            }

            /**
             * Obtém o valor da propriedade email.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmail() {
                return email;
            }

            /**
             * Define o valor da propriedade email.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmail(String value) {
                this.email = value;
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
         *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
         *         &lt;element name="IE"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIe"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="IEST" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIe"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xFant" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="enderEmit" type="{http://www.portalfiscal.inf.br/cte}TEndeEmi"/&gt;
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
            "iest",
            "xNome",
            "xFant",
            "enderEmit"
        })
        public static class Emit {

            @XmlElement(name = "CNPJ", required = true)
            protected String cnpj;
            @XmlElement(name = "IE", required = true)
            protected String ie;
            @XmlElement(name = "IEST")
            protected String iest;
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
             * Obtém o valor da propriedade iest.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIEST() {
                return iest;
            }

            /**
             * Define o valor da propriedade iest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIEST(String value) {
                this.iest = value;
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
         *         &lt;choice&gt;
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="IE" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
         *         &lt;element name="enderExped" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
         *         &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
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
            "ie",
            "xNome",
            "fone",
            "enderExped",
            "email"
        })
        public static class Exped {

            @XmlElement(name = "CNPJ")
            protected String cnpj;
            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(name = "IE")
            protected String ie;
            @XmlElement(required = true)
            protected String xNome;
            protected String fone;
            @XmlElement(required = true)
            protected TEndereco enderExped;
            protected String email;

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
             * Obtém o valor da propriedade fone.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFone() {
                return fone;
            }

            /**
             * Define o valor da propriedade fone.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFone(String value) {
                this.fone = value;
            }

            /**
             * Obtém o valor da propriedade enderExped.
             * 
             * @return
             *     possible object is
             *     {@link TEndereco }
             *     
             */
            public TEndereco getEnderExped() {
                return enderExped;
            }

            /**
             * Define o valor da propriedade enderExped.
             * 
             * @param value
             *     allowed object is
             *     {@link TEndereco }
             *     
             */
            public void setEnderExped(TEndereco value) {
                this.enderExped = value;
            }

            /**
             * Obtém o valor da propriedade email.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmail() {
                return email;
            }

            /**
             * Define o valor da propriedade email.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmail(String value) {
                this.email = value;
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
         *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/cte}TCodUfIBGE"/&gt;
         *         &lt;element name="cCT"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;pattern value="[0-9]{8}"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="CFOP" type="{http://www.portalfiscal.inf.br/cte}TCfop"/&gt;
         *         &lt;element name="natOp"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="60"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModCT"/&gt;
         *         &lt;element name="serie"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TSerie"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="nCT" type="{http://www.portalfiscal.inf.br/cte}TNF"/&gt;
         *         &lt;element name="dhEmi"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="tpImp"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="tpEmis"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="4"/&gt;
         *               &lt;enumeration value="5"/&gt;
         *               &lt;enumeration value="7"/&gt;
         *               &lt;enumeration value="8"/&gt;
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
         *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/cte}TAmb"/&gt;
         *         &lt;element name="tpCTe" type="{http://www.portalfiscal.inf.br/cte}TFinCTe"/&gt;
         *         &lt;element name="procEmi" type="{http://www.portalfiscal.inf.br/cte}TProcEmi"/&gt;
         *         &lt;element name="verProc"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="20"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="indGlobalizado" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="cMunEnv" type="{http://www.portalfiscal.inf.br/cte}TCodMunIBGE"/&gt;
         *         &lt;element name="xMunEnv"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="2"/&gt;
         *               &lt;maxLength value="60"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="UFEnv" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
         *         &lt;element name="modal" type="{http://www.portalfiscal.inf.br/cte}TModTransp"/&gt;
         *         &lt;element name="tpServ"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="0"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *               &lt;enumeration value="3"/&gt;
         *               &lt;enumeration value="4"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="cMunIni" type="{http://www.portalfiscal.inf.br/cte}TCodMunIBGE"/&gt;
         *         &lt;element name="xMunIni"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="2"/&gt;
         *               &lt;maxLength value="60"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="UFIni" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
         *         &lt;element name="cMunFim" type="{http://www.portalfiscal.inf.br/cte}TCodMunIBGE"/&gt;
         *         &lt;element name="xMunFim"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="2"/&gt;
         *               &lt;maxLength value="60"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="UFFim" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
         *         &lt;element name="retira"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="0"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xDetRetira" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="160"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="indIEToma"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *               &lt;enumeration value="9"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;choice&gt;
         *           &lt;element name="toma3"&gt;
         *             &lt;complexType&gt;
         *               &lt;complexContent&gt;
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="toma"&gt;
         *                       &lt;simpleType&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                           &lt;whiteSpace value="preserve"/&gt;
         *                           &lt;enumeration value="0"/&gt;
         *                           &lt;enumeration value="1"/&gt;
         *                           &lt;enumeration value="2"/&gt;
         *                           &lt;enumeration value="3"/&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleType&gt;
         *                     &lt;/element&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/restriction&gt;
         *               &lt;/complexContent&gt;
         *             &lt;/complexType&gt;
         *           &lt;/element&gt;
         *           &lt;element name="toma4"&gt;
         *             &lt;complexType&gt;
         *               &lt;complexContent&gt;
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="toma"&gt;
         *                       &lt;simpleType&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                           &lt;whiteSpace value="preserve"/&gt;
         *                           &lt;enumeration value="4"/&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleType&gt;
         *                     &lt;/element&gt;
         *                     &lt;choice&gt;
         *                       &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
         *                       &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
         *                     &lt;/choice&gt;
         *                     &lt;element name="IE" minOccurs="0"&gt;
         *                       &lt;simpleType&gt;
         *                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleType&gt;
         *                     &lt;/element&gt;
         *                     &lt;sequence&gt;
         *                       &lt;element name="xNome"&gt;
         *                         &lt;simpleType&gt;
         *                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                             &lt;maxLength value="60"/&gt;
         *                             &lt;minLength value="2"/&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/simpleType&gt;
         *                       &lt;/element&gt;
         *                       &lt;element name="xFant" minOccurs="0"&gt;
         *                         &lt;simpleType&gt;
         *                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                             &lt;maxLength value="60"/&gt;
         *                             &lt;minLength value="2"/&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/simpleType&gt;
         *                       &lt;/element&gt;
         *                       &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
         *                       &lt;element name="enderToma" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
         *                       &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
         *                     &lt;/sequence&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/restriction&gt;
         *               &lt;/complexContent&gt;
         *             &lt;/complexType&gt;
         *           &lt;/element&gt;
         *         &lt;/choice&gt;
         *         &lt;sequence minOccurs="0"&gt;
         *           &lt;element name="dhCont" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC"/&gt;
         *           &lt;element name="xJust"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                 &lt;minLength value="15"/&gt;
         *                 &lt;maxLength value="256"/&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *         &lt;/sequence&gt;
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
            "cct",
            "cfop",
            "natOp",
            "mod",
            "serie",
            "nct",
            "dhEmi",
            "tpImp",
            "tpEmis",
            "cdv",
            "tpAmb",
            "tpCTe",
            "procEmi",
            "verProc",
            "indGlobalizado",
            "cMunEnv",
            "xMunEnv",
            "ufEnv",
            "modal",
            "tpServ",
            "cMunIni",
            "xMunIni",
            "ufIni",
            "cMunFim",
            "xMunFim",
            "ufFim",
            "retira",
            "xDetRetira",
            "indIEToma",
            "toma3",
            "toma4",
            "dhCont",
            "xJust"
        })
        public static class Ide {

            @XmlElement(name = "cUF", required = true)
            protected String cuf;
            @XmlElement(name = "cCT", required = true)
            protected String cct;
            @XmlElement(name = "CFOP", required = true)
            protected String cfop;
            @XmlElement(required = true)
            protected String natOp;
            @XmlElement(required = true)
            protected String mod;
            @XmlElement(required = true)
            protected String serie;
            @XmlElement(name = "nCT", required = true)
            protected String nct;
            @XmlElement(required = true)
            protected String dhEmi;
            @XmlElement(required = true)
            protected String tpImp;
            @XmlElement(required = true)
            protected String tpEmis;
            @XmlElement(name = "cDV", required = true)
            protected String cdv;
            @XmlElement(required = true)
            protected String tpAmb;
            @XmlElement(required = true)
            protected String tpCTe;
            @XmlElement(required = true)
            protected String procEmi;
            @XmlElement(required = true)
            protected String verProc;
            protected String indGlobalizado;
            @XmlElement(required = true)
            protected String cMunEnv;
            @XmlElement(required = true)
            protected String xMunEnv;
            @XmlElement(name = "UFEnv", required = true)
            @XmlSchemaType(name = "string")
            protected TUf ufEnv;
            @XmlElement(required = true)
            protected String modal;
            @XmlElement(required = true)
            protected String tpServ;
            @XmlElement(required = true)
            protected String cMunIni;
            @XmlElement(required = true)
            protected String xMunIni;
            @XmlElement(name = "UFIni", required = true)
            @XmlSchemaType(name = "string")
            protected TUf ufIni;
            @XmlElement(required = true)
            protected String cMunFim;
            @XmlElement(required = true)
            protected String xMunFim;
            @XmlElement(name = "UFFim", required = true)
            @XmlSchemaType(name = "string")
            protected TUf ufFim;
            @XmlElement(required = true)
            protected String retira;
            protected String xDetRetira;
            @XmlElement(required = true)
            protected String indIEToma;
            protected TCTe.InfCte.Ide.Toma3 toma3;
            protected TCTe.InfCte.Ide.Toma4 toma4;
            protected String dhCont;
            protected String xJust;

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
             * Obtém o valor da propriedade cct.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCCT() {
                return cct;
            }

            /**
             * Define o valor da propriedade cct.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCCT(String value) {
                this.cct = value;
            }

            /**
             * Obtém o valor da propriedade cfop.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCFOP() {
                return cfop;
            }

            /**
             * Define o valor da propriedade cfop.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCFOP(String value) {
                this.cfop = value;
            }

            /**
             * Obtém o valor da propriedade natOp.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNatOp() {
                return natOp;
            }

            /**
             * Define o valor da propriedade natOp.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNatOp(String value) {
                this.natOp = value;
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
             * Obtém o valor da propriedade nct.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNCT() {
                return nct;
            }

            /**
             * Define o valor da propriedade nct.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNCT(String value) {
                this.nct = value;
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
             * Obtém o valor da propriedade tpImp.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTpImp() {
                return tpImp;
            }

            /**
             * Define o valor da propriedade tpImp.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTpImp(String value) {
                this.tpImp = value;
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
             * Obtém o valor da propriedade tpCTe.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTpCTe() {
                return tpCTe;
            }

            /**
             * Define o valor da propriedade tpCTe.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTpCTe(String value) {
                this.tpCTe = value;
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
             * Obtém o valor da propriedade indGlobalizado.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIndGlobalizado() {
                return indGlobalizado;
            }

            /**
             * Define o valor da propriedade indGlobalizado.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIndGlobalizado(String value) {
                this.indGlobalizado = value;
            }

            /**
             * Obtém o valor da propriedade cMunEnv.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCMunEnv() {
                return cMunEnv;
            }

            /**
             * Define o valor da propriedade cMunEnv.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCMunEnv(String value) {
                this.cMunEnv = value;
            }

            /**
             * Obtém o valor da propriedade xMunEnv.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXMunEnv() {
                return xMunEnv;
            }

            /**
             * Define o valor da propriedade xMunEnv.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXMunEnv(String value) {
                this.xMunEnv = value;
            }

            /**
             * Obtém o valor da propriedade ufEnv.
             * 
             * @return
             *     possible object is
             *     {@link TUf }
             *     
             */
            public TUf getUFEnv() {
                return ufEnv;
            }

            /**
             * Define o valor da propriedade ufEnv.
             * 
             * @param value
             *     allowed object is
             *     {@link TUf }
             *     
             */
            public void setUFEnv(TUf value) {
                this.ufEnv = value;
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
             * Obtém o valor da propriedade tpServ.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTpServ() {
                return tpServ;
            }

            /**
             * Define o valor da propriedade tpServ.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTpServ(String value) {
                this.tpServ = value;
            }

            /**
             * Obtém o valor da propriedade cMunIni.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCMunIni() {
                return cMunIni;
            }

            /**
             * Define o valor da propriedade cMunIni.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCMunIni(String value) {
                this.cMunIni = value;
            }

            /**
             * Obtém o valor da propriedade xMunIni.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXMunIni() {
                return xMunIni;
            }

            /**
             * Define o valor da propriedade xMunIni.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXMunIni(String value) {
                this.xMunIni = value;
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
             * Obtém o valor da propriedade cMunFim.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCMunFim() {
                return cMunFim;
            }

            /**
             * Define o valor da propriedade cMunFim.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCMunFim(String value) {
                this.cMunFim = value;
            }

            /**
             * Obtém o valor da propriedade xMunFim.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXMunFim() {
                return xMunFim;
            }

            /**
             * Define o valor da propriedade xMunFim.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXMunFim(String value) {
                this.xMunFim = value;
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
             * Obtém o valor da propriedade retira.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRetira() {
                return retira;
            }

            /**
             * Define o valor da propriedade retira.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRetira(String value) {
                this.retira = value;
            }

            /**
             * Obtém o valor da propriedade xDetRetira.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXDetRetira() {
                return xDetRetira;
            }

            /**
             * Define o valor da propriedade xDetRetira.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXDetRetira(String value) {
                this.xDetRetira = value;
            }

            /**
             * Obtém o valor da propriedade indIEToma.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIndIEToma() {
                return indIEToma;
            }

            /**
             * Define o valor da propriedade indIEToma.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIndIEToma(String value) {
                this.indIEToma = value;
            }

            /**
             * Obtém o valor da propriedade toma3.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.Ide.Toma3 }
             *     
             */
            public TCTe.InfCte.Ide.Toma3 getToma3() {
                return toma3;
            }

            /**
             * Define o valor da propriedade toma3.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.Ide.Toma3 }
             *     
             */
            public void setToma3(TCTe.InfCte.Ide.Toma3 value) {
                this.toma3 = value;
            }

            /**
             * Obtém o valor da propriedade toma4.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.Ide.Toma4 }
             *     
             */
            public TCTe.InfCte.Ide.Toma4 getToma4() {
                return toma4;
            }

            /**
             * Define o valor da propriedade toma4.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.Ide.Toma4 }
             *     
             */
            public void setToma4(TCTe.InfCte.Ide.Toma4 value) {
                this.toma4 = value;
            }

            /**
             * Obtém o valor da propriedade dhCont.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDhCont() {
                return dhCont;
            }

            /**
             * Define o valor da propriedade dhCont.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDhCont(String value) {
                this.dhCont = value;
            }

            /**
             * Obtém o valor da propriedade xJust.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXJust() {
                return xJust;
            }

            /**
             * Define o valor da propriedade xJust.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXJust(String value) {
                this.xJust = value;
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
             *         &lt;element name="toma"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;whiteSpace value="preserve"/&gt;
             *               &lt;enumeration value="0"/&gt;
             *               &lt;enumeration value="1"/&gt;
             *               &lt;enumeration value="2"/&gt;
             *               &lt;enumeration value="3"/&gt;
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
                "toma"
            })
            public static class Toma3 {

                @XmlElement(required = true)
                protected String toma;

                /**
                 * Obtém o valor da propriedade toma.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getToma() {
                    return toma;
                }

                /**
                 * Define o valor da propriedade toma.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setToma(String value) {
                    this.toma = value;
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
             *         &lt;element name="toma"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;whiteSpace value="preserve"/&gt;
             *               &lt;enumeration value="4"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;choice&gt;
             *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
             *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
             *         &lt;/choice&gt;
             *         &lt;element name="IE" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;sequence&gt;
             *           &lt;element name="xNome"&gt;
             *             &lt;simpleType&gt;
             *               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                 &lt;maxLength value="60"/&gt;
             *                 &lt;minLength value="2"/&gt;
             *               &lt;/restriction&gt;
             *             &lt;/simpleType&gt;
             *           &lt;/element&gt;
             *           &lt;element name="xFant" minOccurs="0"&gt;
             *             &lt;simpleType&gt;
             *               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                 &lt;maxLength value="60"/&gt;
             *                 &lt;minLength value="2"/&gt;
             *               &lt;/restriction&gt;
             *             &lt;/simpleType&gt;
             *           &lt;/element&gt;
             *           &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
             *           &lt;element name="enderToma" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
             *           &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
             *         &lt;/sequence&gt;
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
                "toma",
                "cnpj",
                "cpf",
                "ie",
                "xNome",
                "xFant",
                "fone",
                "enderToma",
                "email"
            })
            public static class Toma4 {

                @XmlElement(required = true)
                protected String toma;
                @XmlElement(name = "CNPJ")
                protected String cnpj;
                @XmlElement(name = "CPF")
                protected String cpf;
                @XmlElement(name = "IE")
                protected String ie;
                @XmlElement(required = true)
                protected String xNome;
                protected String xFant;
                protected String fone;
                @XmlElement(required = true)
                protected TEndereco enderToma;
                protected String email;

                /**
                 * Obtém o valor da propriedade toma.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getToma() {
                    return toma;
                }

                /**
                 * Define o valor da propriedade toma.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setToma(String value) {
                    this.toma = value;
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
                 * Obtém o valor da propriedade fone.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFone() {
                    return fone;
                }

                /**
                 * Define o valor da propriedade fone.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFone(String value) {
                    this.fone = value;
                }

                /**
                 * Obtém o valor da propriedade enderToma.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TEndereco }
                 *     
                 */
                public TEndereco getEnderToma() {
                    return enderToma;
                }

                /**
                 * Define o valor da propriedade enderToma.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TEndereco }
                 *     
                 */
                public void setEnderToma(TEndereco value) {
                    this.enderToma = value;
                }

                /**
                 * Obtém o valor da propriedade email.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEmail() {
                    return email;
                }

                /**
                 * Define o valor da propriedade email.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEmail(String value) {
                    this.email = value;
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
         *         &lt;element name="ICMS" type="{http://www.portalfiscal.inf.br/cte}TImp"/&gt;
         *         &lt;element name="vTotTrib" type="{http://www.portalfiscal.inf.br/cte}TDec_1302" minOccurs="0"/&gt;
         *         &lt;element name="infAdFisco" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;maxLength value="2000"/&gt;
         *               &lt;minLength value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ICMSUFFim" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="vBCUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                   &lt;element name="pFCPUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
         *                   &lt;element name="pICMSUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
         *                   &lt;element name="pICMSInter" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
         *                   &lt;element name="pICMSInterPart" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
         *                   &lt;element name="vFCPUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                   &lt;element name="vICMSUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                   &lt;element name="vICMSUFIni" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
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
            "icms",
            "vTotTrib",
            "infAdFisco",
            "icmsufFim"
        })
        public static class Imp {

            @XmlElement(name = "ICMS", required = true)
            protected TImp icms;
            protected String vTotTrib;
            protected String infAdFisco;
            @XmlElement(name = "ICMSUFFim")
            protected TCTe.InfCte.Imp.ICMSUFFim icmsufFim;

            /**
             * Obtém o valor da propriedade icms.
             * 
             * @return
             *     possible object is
             *     {@link TImp }
             *     
             */
            public TImp getICMS() {
                return icms;
            }

            /**
             * Define o valor da propriedade icms.
             * 
             * @param value
             *     allowed object is
             *     {@link TImp }
             *     
             */
            public void setICMS(TImp value) {
                this.icms = value;
            }

            /**
             * Obtém o valor da propriedade vTotTrib.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVTotTrib() {
                return vTotTrib;
            }

            /**
             * Define o valor da propriedade vTotTrib.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVTotTrib(String value) {
                this.vTotTrib = value;
            }

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
             * Obtém o valor da propriedade icmsufFim.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.Imp.ICMSUFFim }
             *     
             */
            public TCTe.InfCte.Imp.ICMSUFFim getICMSUFFim() {
                return icmsufFim;
            }

            /**
             * Define o valor da propriedade icmsufFim.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.Imp.ICMSUFFim }
             *     
             */
            public void setICMSUFFim(TCTe.InfCte.Imp.ICMSUFFim value) {
                this.icmsufFim = value;
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
             *         &lt;element name="vBCUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
             *         &lt;element name="pFCPUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
             *         &lt;element name="pICMSUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
             *         &lt;element name="pICMSInter" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
             *         &lt;element name="pICMSInterPart" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
             *         &lt;element name="vFCPUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
             *         &lt;element name="vICMSUFFim" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
             *         &lt;element name="vICMSUFIni" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
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
                "vbcufFim",
                "pfcpufFim",
                "picmsufFim",
                "picmsInter",
                "picmsInterPart",
                "vfcpufFim",
                "vicmsufFim",
                "vicmsufIni"
            })
            public static class ICMSUFFim {

                @XmlElement(name = "vBCUFFim", required = true)
                protected String vbcufFim;
                @XmlElement(name = "pFCPUFFim", required = true)
                protected String pfcpufFim;
                @XmlElement(name = "pICMSUFFim", required = true)
                protected String picmsufFim;
                @XmlElement(name = "pICMSInter", required = true)
                protected String picmsInter;
                @XmlElement(name = "pICMSInterPart", required = true)
                protected String picmsInterPart;
                @XmlElement(name = "vFCPUFFim", required = true)
                protected String vfcpufFim;
                @XmlElement(name = "vICMSUFFim", required = true)
                protected String vicmsufFim;
                @XmlElement(name = "vICMSUFIni", required = true)
                protected String vicmsufIni;

                /**
                 * Obtém o valor da propriedade vbcufFim.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVBCUFFim() {
                    return vbcufFim;
                }

                /**
                 * Define o valor da propriedade vbcufFim.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVBCUFFim(String value) {
                    this.vbcufFim = value;
                }

                /**
                 * Obtém o valor da propriedade pfcpufFim.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPFCPUFFim() {
                    return pfcpufFim;
                }

                /**
                 * Define o valor da propriedade pfcpufFim.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPFCPUFFim(String value) {
                    this.pfcpufFim = value;
                }

                /**
                 * Obtém o valor da propriedade picmsufFim.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPICMSUFFim() {
                    return picmsufFim;
                }

                /**
                 * Define o valor da propriedade picmsufFim.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPICMSUFFim(String value) {
                    this.picmsufFim = value;
                }

                /**
                 * Obtém o valor da propriedade picmsInter.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPICMSInter() {
                    return picmsInter;
                }

                /**
                 * Define o valor da propriedade picmsInter.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPICMSInter(String value) {
                    this.picmsInter = value;
                }

                /**
                 * Obtém o valor da propriedade picmsInterPart.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPICMSInterPart() {
                    return picmsInterPart;
                }

                /**
                 * Define o valor da propriedade picmsInterPart.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPICMSInterPart(String value) {
                    this.picmsInterPart = value;
                }

                /**
                 * Obtém o valor da propriedade vfcpufFim.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVFCPUFFim() {
                    return vfcpufFim;
                }

                /**
                 * Define o valor da propriedade vfcpufFim.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVFCPUFFim(String value) {
                    this.vfcpufFim = value;
                }

                /**
                 * Obtém o valor da propriedade vicmsufFim.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVICMSUFFim() {
                    return vicmsufFim;
                }

                /**
                 * Define o valor da propriedade vicmsufFim.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVICMSUFFim(String value) {
                    this.vicmsufFim = value;
                }

                /**
                 * Obtém o valor da propriedade vicmsufIni.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVICMSUFIni() {
                    return vicmsufIni;
                }

                /**
                 * Define o valor da propriedade vicmsufIni.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVICMSUFIni(String value) {
                    this.vicmsufIni = value;
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
         *         &lt;element name="chCte"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;pattern value="[0-9]{44}"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
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
            "chCte",
            "dEmi"
        })
        public static class InfCteAnu {

            @XmlElement(required = true)
            protected String chCte;
            @XmlElement(required = true)
            protected String dEmi;

            /**
             * Obtém o valor da propriedade chCte.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getChCte() {
                return chCte;
            }

            /**
             * Define o valor da propriedade chCte.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setChCte(String value) {
                this.chCte = value;
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
         *         &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
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
            "chCTe"
        })
        public static class InfCteComp {

            @XmlElement(required = true)
            protected String chCTe;

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
         *         &lt;element name="infCarga"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="vCarga" type="{http://www.portalfiscal.inf.br/cte}TDec_1302" minOccurs="0"/&gt;
         *                   &lt;element name="proPred"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="60"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="xOutCat" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="30"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="infQ" maxOccurs="unbounded"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="cUnid"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                   &lt;whiteSpace value="preserve"/&gt;
         *                                   &lt;enumeration value="00"/&gt;
         *                                   &lt;enumeration value="01"/&gt;
         *                                   &lt;enumeration value="02"/&gt;
         *                                   &lt;enumeration value="03"/&gt;
         *                                   &lt;enumeration value="04"/&gt;
         *                                   &lt;enumeration value="05"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="tpMed"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                   &lt;minLength value="1"/&gt;
         *                                   &lt;maxLength value="20"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="qCarga" type="{http://www.portalfiscal.inf.br/cte}TDec_1104"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="vCargaAverb" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="infDoc" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;choice&gt;
         *                     &lt;element name="infNF" maxOccurs="unbounded"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="nRoma" minOccurs="0"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                     &lt;minLength value="1"/&gt;
         *                                     &lt;maxLength value="20"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="nPed" minOccurs="0"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                     &lt;minLength value="1"/&gt;
         *                                     &lt;maxLength value="20"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModNF"/&gt;
         *                               &lt;element name="serie"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                     &lt;minLength value="1"/&gt;
         *                                     &lt;maxLength value="3"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="nDoc"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                     &lt;minLength value="1"/&gt;
         *                                     &lt;maxLength value="20"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
         *                               &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                               &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                               &lt;element name="vBCST" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                               &lt;element name="vST" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                               &lt;element name="vProd" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                               &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                               &lt;element name="nCFOP" type="{http://www.portalfiscal.inf.br/cte}TCfop"/&gt;
         *                               &lt;element name="nPeso" type="{http://www.portalfiscal.inf.br/cte}TDec_1203Opc" minOccurs="0"/&gt;
         *                               &lt;element name="PIN" minOccurs="0"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                     &lt;whiteSpace value="preserve"/&gt;
         *                                     &lt;minLength value="2"/&gt;
         *                                     &lt;maxLength value="9"/&gt;
         *                                     &lt;pattern value="[1-9]{1}[0-9]{1,8}"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
         *                               &lt;choice&gt;
         *                                 &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                                 &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                               &lt;/choice&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="infNFe" maxOccurs="unbounded"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="chave" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
         *                               &lt;element name="PIN" minOccurs="0"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                     &lt;whiteSpace value="preserve"/&gt;
         *                                     &lt;minLength value="2"/&gt;
         *                                     &lt;maxLength value="9"/&gt;
         *                                     &lt;pattern value="[1-9]{1}[0-9]{1,8}"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
         *                               &lt;choice&gt;
         *                                 &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                                 &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                               &lt;/choice&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="infOutros" maxOccurs="unbounded"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="tpDoc"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                     &lt;whiteSpace value="preserve"/&gt;
         *                                     &lt;enumeration value="00"/&gt;
         *                                     &lt;enumeration value="10"/&gt;
         *                                     &lt;enumeration value="59"/&gt;
         *                                     &lt;enumeration value="65"/&gt;
         *                                     &lt;enumeration value="99"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="descOutros" minOccurs="0"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                     &lt;minLength value="1"/&gt;
         *                                     &lt;maxLength value="100"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="nDoc" minOccurs="0"&gt;
         *                                 &lt;simpleType&gt;
         *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                     &lt;minLength value="1"/&gt;
         *                                     &lt;maxLength value="20"/&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
         *                               &lt;element name="vDocFisc" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
         *                               &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
         *                               &lt;choice&gt;
         *                                 &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                                 &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                               &lt;/choice&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                   &lt;/choice&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="docAnt" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="emiDocAnt" maxOccurs="unbounded"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;choice&gt;
         *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
         *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
         *                             &lt;/choice&gt;
         *                             &lt;sequence minOccurs="0"&gt;
         *                               &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe"/&gt;
         *                               &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
         *                             &lt;/sequence&gt;
         *                             &lt;element name="xNome"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                   &lt;maxLength value="60"/&gt;
         *                                   &lt;minLength value="1"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="idDocAnt" maxOccurs="2"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;choice&gt;
         *                                       &lt;element name="idDocAntPap" maxOccurs="unbounded"&gt;
         *                                         &lt;complexType&gt;
         *                                           &lt;complexContent&gt;
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                               &lt;sequence&gt;
         *                                                 &lt;element name="tpDoc"&gt;
         *                                                   &lt;simpleType&gt;
         *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDocAssoc"&gt;
         *                                                     &lt;/restriction&gt;
         *                                                   &lt;/simpleType&gt;
         *                                                 &lt;/element&gt;
         *                                                 &lt;element name="serie"&gt;
         *                                                   &lt;simpleType&gt;
         *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                                       &lt;minLength value="1"/&gt;
         *                                                       &lt;maxLength value="3"/&gt;
         *                                                     &lt;/restriction&gt;
         *                                                   &lt;/simpleType&gt;
         *                                                 &lt;/element&gt;
         *                                                 &lt;element name="subser" minOccurs="0"&gt;
         *                                                   &lt;simpleType&gt;
         *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                                       &lt;minLength value="1"/&gt;
         *                                                       &lt;maxLength value="2"/&gt;
         *                                                     &lt;/restriction&gt;
         *                                                   &lt;/simpleType&gt;
         *                                                 &lt;/element&gt;
         *                                                 &lt;element name="nDoc"&gt;
         *                                                   &lt;simpleType&gt;
         *                                                     &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                                       &lt;minLength value="1"/&gt;
         *                                                       &lt;maxLength value="30"/&gt;
         *                                                     &lt;/restriction&gt;
         *                                                   &lt;/simpleType&gt;
         *                                                 &lt;/element&gt;
         *                                                 &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
         *                                               &lt;/sequence&gt;
         *                                             &lt;/restriction&gt;
         *                                           &lt;/complexContent&gt;
         *                                         &lt;/complexType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="idDocAntEle" maxOccurs="unbounded"&gt;
         *                                         &lt;complexType&gt;
         *                                           &lt;complexContent&gt;
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                               &lt;sequence&gt;
         *                                                 &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
         *                                               &lt;/sequence&gt;
         *                                             &lt;/restriction&gt;
         *                                           &lt;/complexContent&gt;
         *                                         &lt;/complexType&gt;
         *                                       &lt;/element&gt;
         *                                     &lt;/choice&gt;
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
         *         &lt;element name="veicNovos" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="chassi"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;whiteSpace value="preserve"/&gt;
         *                         &lt;length value="17"/&gt;
         *                         &lt;pattern value="[A-Z0-9]+"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="cCor"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="4"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="xCor"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="40"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="cMod"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="6"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="vUnit" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                   &lt;element name="vFrete" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="cobr" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="fat" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="nFat" minOccurs="0"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                   &lt;minLength value="1"/&gt;
         *                                   &lt;maxLength value="60"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="vOrig" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
         *                             &lt;element name="vDesc" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
         *                             &lt;element name="vLiq" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="dup" maxOccurs="unbounded" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="nDup" minOccurs="0"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                                   &lt;maxLength value="60"/&gt;
         *                                   &lt;minLength value="1"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="dVenc" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
         *                             &lt;element name="vDup" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
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
         *         &lt;element name="infCteSub" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="chCte"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;pattern value="[0-9]{44}"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;choice&gt;
         *                     &lt;element name="refCteAnu"&gt;
         *                       &lt;simpleType&gt;
         *                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TChNFe"&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="tomaICMS"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                             &lt;choice&gt;
         *                               &lt;element name="refNFe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
         *                               &lt;element name="refNF"&gt;
         *                                 &lt;complexType&gt;
         *                                   &lt;complexContent&gt;
         *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                       &lt;sequence&gt;
         *                                         &lt;choice&gt;
         *                                           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
         *                                           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
         *                                         &lt;/choice&gt;
         *                                         &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModDoc"/&gt;
         *                                         &lt;element name="serie" type="{http://www.portalfiscal.inf.br/cte}TSerie"/&gt;
         *                                         &lt;element name="subserie" type="{http://www.portalfiscal.inf.br/cte}TSerie" minOccurs="0"/&gt;
         *                                         &lt;element name="nro"&gt;
         *                                           &lt;simpleType&gt;
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                               &lt;whiteSpace value="preserve"/&gt;
         *                                               &lt;pattern value="[0-9]{1,6}"/&gt;
         *                                             &lt;/restriction&gt;
         *                                           &lt;/simpleType&gt;
         *                                         &lt;/element&gt;
         *                                         &lt;element name="valor" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *                                         &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
         *                                       &lt;/sequence&gt;
         *                                     &lt;/restriction&gt;
         *                                   &lt;/complexContent&gt;
         *                                 &lt;/complexType&gt;
         *                               &lt;/element&gt;
         *                               &lt;element name="refCte" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
         *                             &lt;/choice&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                   &lt;/choice&gt;
         *                   &lt;element name="indAlteraToma" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;enumeration value="1"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="infGlobalizado" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="xObs"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="15"/&gt;
         *                         &lt;maxLength value="256"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="infServVinc" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="infCTeMultimodal" maxOccurs="unbounded"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="chCTeMultimodal" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
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
            "infCarga",
            "infDoc",
            "docAnt",
            "infModal",
            "veicNovos",
            "cobr",
            "infCteSub",
            "infGlobalizado",
            "infServVinc"
        })
        public static class InfCTeNorm {

            @XmlElement(required = true)
            protected TCTe.InfCte.InfCTeNorm.InfCarga infCarga;
            protected TCTe.InfCte.InfCTeNorm.InfDoc infDoc;
            protected TCTe.InfCte.InfCTeNorm.DocAnt docAnt;
            @XmlElement(required = true)
            protected TCTe.InfCte.InfCTeNorm.InfModal infModal;
            protected List<TCTe.InfCte.InfCTeNorm.VeicNovos> veicNovos;
            protected TCTe.InfCte.InfCTeNorm.Cobr cobr;
            protected TCTe.InfCte.InfCTeNorm.InfCteSub infCteSub;
            protected TCTe.InfCte.InfCTeNorm.InfGlobalizado infGlobalizado;
            protected TCTe.InfCte.InfCTeNorm.InfServVinc infServVinc;

            /**
             * Obtém o valor da propriedade infCarga.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfCarga }
             *     
             */
            public TCTe.InfCte.InfCTeNorm.InfCarga getInfCarga() {
                return infCarga;
            }

            /**
             * Define o valor da propriedade infCarga.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfCarga }
             *     
             */
            public void setInfCarga(TCTe.InfCte.InfCTeNorm.InfCarga value) {
                this.infCarga = value;
            }

            /**
             * Obtém o valor da propriedade infDoc.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfDoc }
             *     
             */
            public TCTe.InfCte.InfCTeNorm.InfDoc getInfDoc() {
                return infDoc;
            }

            /**
             * Define o valor da propriedade infDoc.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfDoc }
             *     
             */
            public void setInfDoc(TCTe.InfCte.InfCTeNorm.InfDoc value) {
                this.infDoc = value;
            }

            /**
             * Obtém o valor da propriedade docAnt.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.InfCTeNorm.DocAnt }
             *     
             */
            public TCTe.InfCte.InfCTeNorm.DocAnt getDocAnt() {
                return docAnt;
            }

            /**
             * Define o valor da propriedade docAnt.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.InfCTeNorm.DocAnt }
             *     
             */
            public void setDocAnt(TCTe.InfCte.InfCTeNorm.DocAnt value) {
                this.docAnt = value;
            }

            /**
             * Obtém o valor da propriedade infModal.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfModal }
             *     
             */
            public TCTe.InfCte.InfCTeNorm.InfModal getInfModal() {
                return infModal;
            }

            /**
             * Define o valor da propriedade infModal.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfModal }
             *     
             */
            public void setInfModal(TCTe.InfCte.InfCTeNorm.InfModal value) {
                this.infModal = value;
            }

            /**
             * Gets the value of the veicNovos property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the veicNovos property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVeicNovos().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TCTe.InfCte.InfCTeNorm.VeicNovos }
             * 
             * 
             */
            public List<TCTe.InfCte.InfCTeNorm.VeicNovos> getVeicNovos() {
                if (veicNovos == null) {
                    veicNovos = new ArrayList<TCTe.InfCte.InfCTeNorm.VeicNovos>();
                }
                return this.veicNovos;
            }

            /**
             * Obtém o valor da propriedade cobr.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.InfCTeNorm.Cobr }
             *     
             */
            public TCTe.InfCte.InfCTeNorm.Cobr getCobr() {
                return cobr;
            }

            /**
             * Define o valor da propriedade cobr.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.InfCTeNorm.Cobr }
             *     
             */
            public void setCobr(TCTe.InfCte.InfCTeNorm.Cobr value) {
                this.cobr = value;
            }

            /**
             * Obtém o valor da propriedade infCteSub.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfCteSub }
             *     
             */
            public TCTe.InfCte.InfCTeNorm.InfCteSub getInfCteSub() {
                return infCteSub;
            }

            /**
             * Define o valor da propriedade infCteSub.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfCteSub }
             *     
             */
            public void setInfCteSub(TCTe.InfCte.InfCTeNorm.InfCteSub value) {
                this.infCteSub = value;
            }

            /**
             * Obtém o valor da propriedade infGlobalizado.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfGlobalizado }
             *     
             */
            public TCTe.InfCte.InfCTeNorm.InfGlobalizado getInfGlobalizado() {
                return infGlobalizado;
            }

            /**
             * Define o valor da propriedade infGlobalizado.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfGlobalizado }
             *     
             */
            public void setInfGlobalizado(TCTe.InfCte.InfCTeNorm.InfGlobalizado value) {
                this.infGlobalizado = value;
            }

            /**
             * Obtém o valor da propriedade infServVinc.
             * 
             * @return
             *     possible object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfServVinc }
             *     
             */
            public TCTe.InfCte.InfCTeNorm.InfServVinc getInfServVinc() {
                return infServVinc;
            }

            /**
             * Define o valor da propriedade infServVinc.
             * 
             * @param value
             *     allowed object is
             *     {@link TCTe.InfCte.InfCTeNorm.InfServVinc }
             *     
             */
            public void setInfServVinc(TCTe.InfCte.InfCTeNorm.InfServVinc value) {
                this.infServVinc = value;
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
             *         &lt;element name="fat" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="nFat" minOccurs="0"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                         &lt;minLength value="1"/&gt;
             *                         &lt;maxLength value="60"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="vOrig" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
             *                   &lt;element name="vDesc" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
             *                   &lt;element name="vLiq" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="dup" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="nDup" minOccurs="0"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                         &lt;maxLength value="60"/&gt;
             *                         &lt;minLength value="1"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="dVenc" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
             *                   &lt;element name="vDup" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
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
                "fat",
                "dup"
            })
            public static class Cobr {

                protected TCTe.InfCte.InfCTeNorm.Cobr.Fat fat;
                protected List<TCTe.InfCte.InfCTeNorm.Cobr.Dup> dup;

                /**
                 * Obtém o valor da propriedade fat.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TCTe.InfCte.InfCTeNorm.Cobr.Fat }
                 *     
                 */
                public TCTe.InfCte.InfCTeNorm.Cobr.Fat getFat() {
                    return fat;
                }

                /**
                 * Define o valor da propriedade fat.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TCTe.InfCte.InfCTeNorm.Cobr.Fat }
                 *     
                 */
                public void setFat(TCTe.InfCte.InfCTeNorm.Cobr.Fat value) {
                    this.fat = value;
                }

                /**
                 * Gets the value of the dup property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the dup property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getDup().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TCTe.InfCte.InfCTeNorm.Cobr.Dup }
                 * 
                 * 
                 */
                public List<TCTe.InfCte.InfCTeNorm.Cobr.Dup> getDup() {
                    if (dup == null) {
                        dup = new ArrayList<TCTe.InfCte.InfCTeNorm.Cobr.Dup>();
                    }
                    return this.dup;
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
                 *         &lt;element name="nDup" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *               &lt;maxLength value="60"/&gt;
                 *               &lt;minLength value="1"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="dVenc" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
                 *         &lt;element name="vDup" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
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
                    "nDup",
                    "dVenc",
                    "vDup"
                })
                public static class Dup {

                    protected String nDup;
                    protected String dVenc;
                    protected String vDup;

                    /**
                     * Obtém o valor da propriedade nDup.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNDup() {
                        return nDup;
                    }

                    /**
                     * Define o valor da propriedade nDup.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNDup(String value) {
                        this.nDup = value;
                    }

                    /**
                     * Obtém o valor da propriedade dVenc.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDVenc() {
                        return dVenc;
                    }

                    /**
                     * Define o valor da propriedade dVenc.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDVenc(String value) {
                        this.dVenc = value;
                    }

                    /**
                     * Obtém o valor da propriedade vDup.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getVDup() {
                        return vDup;
                    }

                    /**
                     * Define o valor da propriedade vDup.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setVDup(String value) {
                        this.vDup = value;
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
                 *         &lt;element name="nFat" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *               &lt;minLength value="1"/&gt;
                 *               &lt;maxLength value="60"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="vOrig" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
                 *         &lt;element name="vDesc" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
                 *         &lt;element name="vLiq" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
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
                    "nFat",
                    "vOrig",
                    "vDesc",
                    "vLiq"
                })
                public static class Fat {

                    protected String nFat;
                    protected String vOrig;
                    protected String vDesc;
                    protected String vLiq;

                    /**
                     * Obtém o valor da propriedade nFat.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNFat() {
                        return nFat;
                    }

                    /**
                     * Define o valor da propriedade nFat.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNFat(String value) {
                        this.nFat = value;
                    }

                    /**
                     * Obtém o valor da propriedade vOrig.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getVOrig() {
                        return vOrig;
                    }

                    /**
                     * Define o valor da propriedade vOrig.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setVOrig(String value) {
                        this.vOrig = value;
                    }

                    /**
                     * Obtém o valor da propriedade vDesc.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getVDesc() {
                        return vDesc;
                    }

                    /**
                     * Define o valor da propriedade vDesc.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setVDesc(String value) {
                        this.vDesc = value;
                    }

                    /**
                     * Obtém o valor da propriedade vLiq.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getVLiq() {
                        return vLiq;
                    }

                    /**
                     * Define o valor da propriedade vLiq.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setVLiq(String value) {
                        this.vLiq = value;
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
             *         &lt;element name="emiDocAnt" maxOccurs="unbounded"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;choice&gt;
             *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
             *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
             *                   &lt;/choice&gt;
             *                   &lt;sequence minOccurs="0"&gt;
             *                     &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe"/&gt;
             *                     &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
             *                   &lt;/sequence&gt;
             *                   &lt;element name="xNome"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                         &lt;maxLength value="60"/&gt;
             *                         &lt;minLength value="1"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="idDocAnt" maxOccurs="2"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;choice&gt;
             *                             &lt;element name="idDocAntPap" maxOccurs="unbounded"&gt;
             *                               &lt;complexType&gt;
             *                                 &lt;complexContent&gt;
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                     &lt;sequence&gt;
             *                                       &lt;element name="tpDoc"&gt;
             *                                         &lt;simpleType&gt;
             *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDocAssoc"&gt;
             *                                           &lt;/restriction&gt;
             *                                         &lt;/simpleType&gt;
             *                                       &lt;/element&gt;
             *                                       &lt;element name="serie"&gt;
             *                                         &lt;simpleType&gt;
             *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                                             &lt;minLength value="1"/&gt;
             *                                             &lt;maxLength value="3"/&gt;
             *                                           &lt;/restriction&gt;
             *                                         &lt;/simpleType&gt;
             *                                       &lt;/element&gt;
             *                                       &lt;element name="subser" minOccurs="0"&gt;
             *                                         &lt;simpleType&gt;
             *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                                             &lt;minLength value="1"/&gt;
             *                                             &lt;maxLength value="2"/&gt;
             *                                           &lt;/restriction&gt;
             *                                         &lt;/simpleType&gt;
             *                                       &lt;/element&gt;
             *                                       &lt;element name="nDoc"&gt;
             *                                         &lt;simpleType&gt;
             *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                                             &lt;minLength value="1"/&gt;
             *                                             &lt;maxLength value="30"/&gt;
             *                                           &lt;/restriction&gt;
             *                                         &lt;/simpleType&gt;
             *                                       &lt;/element&gt;
             *                                       &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
             *                                     &lt;/sequence&gt;
             *                                   &lt;/restriction&gt;
             *                                 &lt;/complexContent&gt;
             *                               &lt;/complexType&gt;
             *                             &lt;/element&gt;
             *                             &lt;element name="idDocAntEle" maxOccurs="unbounded"&gt;
             *                               &lt;complexType&gt;
             *                                 &lt;complexContent&gt;
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                     &lt;sequence&gt;
             *                                       &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
             *                                     &lt;/sequence&gt;
             *                                   &lt;/restriction&gt;
             *                                 &lt;/complexContent&gt;
             *                               &lt;/complexType&gt;
             *                             &lt;/element&gt;
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
                "emiDocAnt"
            })
            public static class DocAnt {

                @XmlElement(required = true)
                protected List<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt> emiDocAnt;

                /**
                 * Gets the value of the emiDocAnt property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the emiDocAnt property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getEmiDocAnt().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt }
                 * 
                 * 
                 */
                public List<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt> getEmiDocAnt() {
                    if (emiDocAnt == null) {
                        emiDocAnt = new ArrayList<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt>();
                    }
                    return this.emiDocAnt;
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
                 *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
                 *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
                 *         &lt;/choice&gt;
                 *         &lt;sequence minOccurs="0"&gt;
                 *           &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe"/&gt;
                 *           &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
                 *         &lt;/sequence&gt;
                 *         &lt;element name="xNome"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *               &lt;maxLength value="60"/&gt;
                 *               &lt;minLength value="1"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="idDocAnt" maxOccurs="2"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;choice&gt;
                 *                   &lt;element name="idDocAntPap" maxOccurs="unbounded"&gt;
                 *                     &lt;complexType&gt;
                 *                       &lt;complexContent&gt;
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                           &lt;sequence&gt;
                 *                             &lt;element name="tpDoc"&gt;
                 *                               &lt;simpleType&gt;
                 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDocAssoc"&gt;
                 *                                 &lt;/restriction&gt;
                 *                               &lt;/simpleType&gt;
                 *                             &lt;/element&gt;
                 *                             &lt;element name="serie"&gt;
                 *                               &lt;simpleType&gt;
                 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *                                   &lt;minLength value="1"/&gt;
                 *                                   &lt;maxLength value="3"/&gt;
                 *                                 &lt;/restriction&gt;
                 *                               &lt;/simpleType&gt;
                 *                             &lt;/element&gt;
                 *                             &lt;element name="subser" minOccurs="0"&gt;
                 *                               &lt;simpleType&gt;
                 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *                                   &lt;minLength value="1"/&gt;
                 *                                   &lt;maxLength value="2"/&gt;
                 *                                 &lt;/restriction&gt;
                 *                               &lt;/simpleType&gt;
                 *                             &lt;/element&gt;
                 *                             &lt;element name="nDoc"&gt;
                 *                               &lt;simpleType&gt;
                 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *                                   &lt;minLength value="1"/&gt;
                 *                                   &lt;maxLength value="30"/&gt;
                 *                                 &lt;/restriction&gt;
                 *                               &lt;/simpleType&gt;
                 *                             &lt;/element&gt;
                 *                             &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
                 *                           &lt;/sequence&gt;
                 *                         &lt;/restriction&gt;
                 *                       &lt;/complexContent&gt;
                 *                     &lt;/complexType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="idDocAntEle" maxOccurs="unbounded"&gt;
                 *                     &lt;complexType&gt;
                 *                       &lt;complexContent&gt;
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                           &lt;sequence&gt;
                 *                             &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
                 *                           &lt;/sequence&gt;
                 *                         &lt;/restriction&gt;
                 *                       &lt;/complexContent&gt;
                 *                     &lt;/complexType&gt;
                 *                   &lt;/element&gt;
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
                    "cnpj",
                    "cpf",
                    "ie",
                    "uf",
                    "xNome",
                    "idDocAnt"
                })
                public static class EmiDocAnt {

                    @XmlElement(name = "CNPJ")
                    protected String cnpj;
                    @XmlElement(name = "CPF")
                    protected String cpf;
                    @XmlElement(name = "IE")
                    protected String ie;
                    @XmlElement(name = "UF")
                    @XmlSchemaType(name = "string")
                    protected TUf uf;
                    @XmlElement(required = true)
                    protected String xNome;
                    @XmlElement(required = true)
                    protected List<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt> idDocAnt;

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
                     * Gets the value of the idDocAnt property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the idDocAnt property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getIdDocAnt().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt }
                     * 
                     * 
                     */
                    public List<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt> getIdDocAnt() {
                        if (idDocAnt == null) {
                            idDocAnt = new ArrayList<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt>();
                        }
                        return this.idDocAnt;
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
                     *         &lt;element name="idDocAntPap" maxOccurs="unbounded"&gt;
                     *           &lt;complexType&gt;
                     *             &lt;complexContent&gt;
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                 &lt;sequence&gt;
                     *                   &lt;element name="tpDoc"&gt;
                     *                     &lt;simpleType&gt;
                     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDocAssoc"&gt;
                     *                       &lt;/restriction&gt;
                     *                     &lt;/simpleType&gt;
                     *                   &lt;/element&gt;
                     *                   &lt;element name="serie"&gt;
                     *                     &lt;simpleType&gt;
                     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                     *                         &lt;minLength value="1"/&gt;
                     *                         &lt;maxLength value="3"/&gt;
                     *                       &lt;/restriction&gt;
                     *                     &lt;/simpleType&gt;
                     *                   &lt;/element&gt;
                     *                   &lt;element name="subser" minOccurs="0"&gt;
                     *                     &lt;simpleType&gt;
                     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                     *                         &lt;minLength value="1"/&gt;
                     *                         &lt;maxLength value="2"/&gt;
                     *                       &lt;/restriction&gt;
                     *                     &lt;/simpleType&gt;
                     *                   &lt;/element&gt;
                     *                   &lt;element name="nDoc"&gt;
                     *                     &lt;simpleType&gt;
                     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                     *                         &lt;minLength value="1"/&gt;
                     *                         &lt;maxLength value="30"/&gt;
                     *                       &lt;/restriction&gt;
                     *                     &lt;/simpleType&gt;
                     *                   &lt;/element&gt;
                     *                   &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
                     *                 &lt;/sequence&gt;
                     *               &lt;/restriction&gt;
                     *             &lt;/complexContent&gt;
                     *           &lt;/complexType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="idDocAntEle" maxOccurs="unbounded"&gt;
                     *           &lt;complexType&gt;
                     *             &lt;complexContent&gt;
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                 &lt;sequence&gt;
                     *                   &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
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
                    @XmlType(name = "", propOrder = {
                        "idDocAntPap",
                        "idDocAntEle"
                    })
                    public static class IdDocAnt {

                        protected List<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt.IdDocAntPap> idDocAntPap;
                        protected List<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt.IdDocAntEle> idDocAntEle;

                        /**
                         * Gets the value of the idDocAntPap property.
                         * 
                         * <p>
                         * This accessor method returns a reference to the live list,
                         * not a snapshot. Therefore any modification you make to the
                         * returned list will be present inside the JAXB object.
                         * This is why there is not a <CODE>set</CODE> method for the idDocAntPap property.
                         * 
                         * <p>
                         * For example, to add a new item, do as follows:
                         * <pre>
                         *    getIdDocAntPap().add(newItem);
                         * </pre>
                         * 
                         * 
                         * <p>
                         * Objects of the following type(s) are allowed in the list
                         * {@link TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt.IdDocAntPap }
                         * 
                         * 
                         */
                        public List<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt.IdDocAntPap> getIdDocAntPap() {
                            if (idDocAntPap == null) {
                                idDocAntPap = new ArrayList<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt.IdDocAntPap>();
                            }
                            return this.idDocAntPap;
                        }

                        /**
                         * Gets the value of the idDocAntEle property.
                         * 
                         * <p>
                         * This accessor method returns a reference to the live list,
                         * not a snapshot. Therefore any modification you make to the
                         * returned list will be present inside the JAXB object.
                         * This is why there is not a <CODE>set</CODE> method for the idDocAntEle property.
                         * 
                         * <p>
                         * For example, to add a new item, do as follows:
                         * <pre>
                         *    getIdDocAntEle().add(newItem);
                         * </pre>
                         * 
                         * 
                         * <p>
                         * Objects of the following type(s) are allowed in the list
                         * {@link TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt.IdDocAntEle }
                         * 
                         * 
                         */
                        public List<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt.IdDocAntEle> getIdDocAntEle() {
                            if (idDocAntEle == null) {
                                idDocAntEle = new ArrayList<TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt.IdDocAntEle>();
                            }
                            return this.idDocAntEle;
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
                         *         &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
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
                            "chCTe"
                        })
                        public static class IdDocAntEle {

                            @XmlElement(required = true)
                            protected String chCTe;

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
                         *         &lt;element name="tpDoc"&gt;
                         *           &lt;simpleType&gt;
                         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDocAssoc"&gt;
                         *             &lt;/restriction&gt;
                         *           &lt;/simpleType&gt;
                         *         &lt;/element&gt;
                         *         &lt;element name="serie"&gt;
                         *           &lt;simpleType&gt;
                         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                         *               &lt;minLength value="1"/&gt;
                         *               &lt;maxLength value="3"/&gt;
                         *             &lt;/restriction&gt;
                         *           &lt;/simpleType&gt;
                         *         &lt;/element&gt;
                         *         &lt;element name="subser" minOccurs="0"&gt;
                         *           &lt;simpleType&gt;
                         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                         *               &lt;minLength value="1"/&gt;
                         *               &lt;maxLength value="2"/&gt;
                         *             &lt;/restriction&gt;
                         *           &lt;/simpleType&gt;
                         *         &lt;/element&gt;
                         *         &lt;element name="nDoc"&gt;
                         *           &lt;simpleType&gt;
                         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                         *               &lt;minLength value="1"/&gt;
                         *               &lt;maxLength value="30"/&gt;
                         *             &lt;/restriction&gt;
                         *           &lt;/simpleType&gt;
                         *         &lt;/element&gt;
                         *         &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
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
                            "tpDoc",
                            "serie",
                            "subser",
                            "nDoc",
                            "dEmi"
                        })
                        public static class IdDocAntPap {

                            @XmlElement(required = true)
                            protected String tpDoc;
                            @XmlElement(required = true)
                            protected String serie;
                            protected String subser;
                            @XmlElement(required = true)
                            protected String nDoc;
                            @XmlElement(required = true)
                            protected String dEmi;

                            /**
                             * Obtém o valor da propriedade tpDoc.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getTpDoc() {
                                return tpDoc;
                            }

                            /**
                             * Define o valor da propriedade tpDoc.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setTpDoc(String value) {
                                this.tpDoc = value;
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
                             * Obtém o valor da propriedade subser.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getSubser() {
                                return subser;
                            }

                            /**
                             * Define o valor da propriedade subser.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setSubser(String value) {
                                this.subser = value;
                            }

                            /**
                             * Obtém o valor da propriedade nDoc.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getNDoc() {
                                return nDoc;
                            }

                            /**
                             * Define o valor da propriedade nDoc.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setNDoc(String value) {
                                this.nDoc = value;
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
             *         &lt;element name="vCarga" type="{http://www.portalfiscal.inf.br/cte}TDec_1302" minOccurs="0"/&gt;
             *         &lt;element name="proPred"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="60"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="xOutCat" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="30"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="infQ" maxOccurs="unbounded"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="cUnid"&gt;
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
             *                   &lt;element name="tpMed"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                         &lt;minLength value="1"/&gt;
             *                         &lt;maxLength value="20"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="qCarga" type="{http://www.portalfiscal.inf.br/cte}TDec_1104"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="vCargaAverb" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
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
                "vCarga",
                "proPred",
                "xOutCat",
                "infQ",
                "vCargaAverb"
            })
            public static class InfCarga {

                protected String vCarga;
                @XmlElement(required = true)
                protected String proPred;
                protected String xOutCat;
                @XmlElement(required = true)
                protected List<TCTe.InfCte.InfCTeNorm.InfCarga.InfQ> infQ;
                protected String vCargaAverb;

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
                 * Obtém o valor da propriedade proPred.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProPred() {
                    return proPred;
                }

                /**
                 * Define o valor da propriedade proPred.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProPred(String value) {
                    this.proPred = value;
                }

                /**
                 * Obtém o valor da propriedade xOutCat.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXOutCat() {
                    return xOutCat;
                }

                /**
                 * Define o valor da propriedade xOutCat.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXOutCat(String value) {
                    this.xOutCat = value;
                }

                /**
                 * Gets the value of the infQ property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the infQ property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getInfQ().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TCTe.InfCte.InfCTeNorm.InfCarga.InfQ }
                 * 
                 * 
                 */
                public List<TCTe.InfCte.InfCTeNorm.InfCarga.InfQ> getInfQ() {
                    if (infQ == null) {
                        infQ = new ArrayList<TCTe.InfCte.InfCTeNorm.InfCarga.InfQ>();
                    }
                    return this.infQ;
                }

                /**
                 * Obtém o valor da propriedade vCargaAverb.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVCargaAverb() {
                    return vCargaAverb;
                }

                /**
                 * Define o valor da propriedade vCargaAverb.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVCargaAverb(String value) {
                    this.vCargaAverb = value;
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
                 *         &lt;element name="cUnid"&gt;
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
                 *         &lt;element name="tpMed"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *               &lt;minLength value="1"/&gt;
                 *               &lt;maxLength value="20"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="qCarga" type="{http://www.portalfiscal.inf.br/cte}TDec_1104"/&gt;
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
                    "cUnid",
                    "tpMed",
                    "qCarga"
                })
                public static class InfQ {

                    @XmlElement(required = true)
                    protected String cUnid;
                    @XmlElement(required = true)
                    protected String tpMed;
                    @XmlElement(required = true)
                    protected String qCarga;

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
                     * Obtém o valor da propriedade tpMed.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTpMed() {
                        return tpMed;
                    }

                    /**
                     * Define o valor da propriedade tpMed.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTpMed(String value) {
                        this.tpMed = value;
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
             *         &lt;element name="chCte"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;pattern value="[0-9]{44}"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;choice&gt;
             *           &lt;element name="refCteAnu"&gt;
             *             &lt;simpleType&gt;
             *               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TChNFe"&gt;
             *               &lt;/restriction&gt;
             *             &lt;/simpleType&gt;
             *           &lt;/element&gt;
             *           &lt;element name="tomaICMS"&gt;
             *             &lt;complexType&gt;
             *               &lt;complexContent&gt;
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                   &lt;choice&gt;
             *                     &lt;element name="refNFe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
             *                     &lt;element name="refNF"&gt;
             *                       &lt;complexType&gt;
             *                         &lt;complexContent&gt;
             *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                             &lt;sequence&gt;
             *                               &lt;choice&gt;
             *                                 &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
             *                                 &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
             *                               &lt;/choice&gt;
             *                               &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModDoc"/&gt;
             *                               &lt;element name="serie" type="{http://www.portalfiscal.inf.br/cte}TSerie"/&gt;
             *                               &lt;element name="subserie" type="{http://www.portalfiscal.inf.br/cte}TSerie" minOccurs="0"/&gt;
             *                               &lt;element name="nro"&gt;
             *                                 &lt;simpleType&gt;
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                     &lt;whiteSpace value="preserve"/&gt;
             *                                     &lt;pattern value="[0-9]{1,6}"/&gt;
             *                                   &lt;/restriction&gt;
             *                                 &lt;/simpleType&gt;
             *                               &lt;/element&gt;
             *                               &lt;element name="valor" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
             *                               &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
             *                             &lt;/sequence&gt;
             *                           &lt;/restriction&gt;
             *                         &lt;/complexContent&gt;
             *                       &lt;/complexType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="refCte" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
             *                   &lt;/choice&gt;
             *                 &lt;/restriction&gt;
             *               &lt;/complexContent&gt;
             *             &lt;/complexType&gt;
             *           &lt;/element&gt;
             *         &lt;/choice&gt;
             *         &lt;element name="indAlteraToma" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;enumeration value="1"/&gt;
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
                "chCte",
                "refCteAnu",
                "tomaICMS",
                "indAlteraToma"
            })
            public static class InfCteSub {

                @XmlElement(required = true)
                protected String chCte;
                protected String refCteAnu;
                protected TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS tomaICMS;
                protected String indAlteraToma;

                /**
                 * Obtém o valor da propriedade chCte.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChCte() {
                    return chCte;
                }

                /**
                 * Define o valor da propriedade chCte.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChCte(String value) {
                    this.chCte = value;
                }

                /**
                 * Obtém o valor da propriedade refCteAnu.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRefCteAnu() {
                    return refCteAnu;
                }

                /**
                 * Define o valor da propriedade refCteAnu.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRefCteAnu(String value) {
                    this.refCteAnu = value;
                }

                /**
                 * Obtém o valor da propriedade tomaICMS.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS }
                 *     
                 */
                public TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS getTomaICMS() {
                    return tomaICMS;
                }

                /**
                 * Define o valor da propriedade tomaICMS.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS }
                 *     
                 */
                public void setTomaICMS(TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS value) {
                    this.tomaICMS = value;
                }

                /**
                 * Obtém o valor da propriedade indAlteraToma.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getIndAlteraToma() {
                    return indAlteraToma;
                }

                /**
                 * Define o valor da propriedade indAlteraToma.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setIndAlteraToma(String value) {
                    this.indAlteraToma = value;
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
                 *         &lt;element name="refNFe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
                 *         &lt;element name="refNF"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;choice&gt;
                 *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
                 *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
                 *                   &lt;/choice&gt;
                 *                   &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModDoc"/&gt;
                 *                   &lt;element name="serie" type="{http://www.portalfiscal.inf.br/cte}TSerie"/&gt;
                 *                   &lt;element name="subserie" type="{http://www.portalfiscal.inf.br/cte}TSerie" minOccurs="0"/&gt;
                 *                   &lt;element name="nro"&gt;
                 *                     &lt;simpleType&gt;
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                         &lt;whiteSpace value="preserve"/&gt;
                 *                         &lt;pattern value="[0-9]{1,6}"/&gt;
                 *                       &lt;/restriction&gt;
                 *                     &lt;/simpleType&gt;
                 *                   &lt;/element&gt;
                 *                   &lt;element name="valor" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
                 *                   &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
                 *                 &lt;/sequence&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/complexContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="refCte" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
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
                    "refNFe",
                    "refNF",
                    "refCte"
                })
                public static class TomaICMS {

                    protected String refNFe;
                    protected TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS.RefNF refNF;
                    protected String refCte;

                    /**
                     * Obtém o valor da propriedade refNFe.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getRefNFe() {
                        return refNFe;
                    }

                    /**
                     * Define o valor da propriedade refNFe.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setRefNFe(String value) {
                        this.refNFe = value;
                    }

                    /**
                     * Obtém o valor da propriedade refNF.
                     * 
                     * @return
                     *     possible object is
                     *     {@link TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS.RefNF }
                     *     
                     */
                    public TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS.RefNF getRefNF() {
                        return refNF;
                    }

                    /**
                     * Define o valor da propriedade refNF.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS.RefNF }
                     *     
                     */
                    public void setRefNF(TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS.RefNF value) {
                        this.refNF = value;
                    }

                    /**
                     * Obtém o valor da propriedade refCte.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getRefCte() {
                        return refCte;
                    }

                    /**
                     * Define o valor da propriedade refCte.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setRefCte(String value) {
                        this.refCte = value;
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
                     *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
                     *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
                     *         &lt;/choice&gt;
                     *         &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModDoc"/&gt;
                     *         &lt;element name="serie" type="{http://www.portalfiscal.inf.br/cte}TSerie"/&gt;
                     *         &lt;element name="subserie" type="{http://www.portalfiscal.inf.br/cte}TSerie" minOccurs="0"/&gt;
                     *         &lt;element name="nro"&gt;
                     *           &lt;simpleType&gt;
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *               &lt;whiteSpace value="preserve"/&gt;
                     *               &lt;pattern value="[0-9]{1,6}"/&gt;
                     *             &lt;/restriction&gt;
                     *           &lt;/simpleType&gt;
                     *         &lt;/element&gt;
                     *         &lt;element name="valor" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
                     *         &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
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
                        "mod",
                        "serie",
                        "subserie",
                        "nro",
                        "valor",
                        "dEmi"
                    })
                    public static class RefNF {

                        @XmlElement(name = "CNPJ")
                        protected String cnpj;
                        @XmlElement(name = "CPF")
                        protected String cpf;
                        @XmlElement(required = true)
                        protected String mod;
                        @XmlElement(required = true)
                        protected String serie;
                        protected String subserie;
                        @XmlElement(required = true)
                        protected String nro;
                        @XmlElement(required = true)
                        protected String valor;
                        @XmlElement(required = true)
                        protected String dEmi;

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
                         * Obtém o valor da propriedade subserie.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getSubserie() {
                            return subserie;
                        }

                        /**
                         * Define o valor da propriedade subserie.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setSubserie(String value) {
                            this.subserie = value;
                        }

                        /**
                         * Obtém o valor da propriedade nro.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNro() {
                            return nro;
                        }

                        /**
                         * Define o valor da propriedade nro.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNro(String value) {
                            this.nro = value;
                        }

                        /**
                         * Obtém o valor da propriedade valor.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getValor() {
                            return valor;
                        }

                        /**
                         * Define o valor da propriedade valor.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setValor(String value) {
                            this.valor = value;
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
             *         &lt;choice&gt;
             *           &lt;element name="infNF" maxOccurs="unbounded"&gt;
             *             &lt;complexType&gt;
             *               &lt;complexContent&gt;
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                   &lt;sequence&gt;
             *                     &lt;element name="nRoma" minOccurs="0"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                           &lt;minLength value="1"/&gt;
             *                           &lt;maxLength value="20"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="nPed" minOccurs="0"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                           &lt;minLength value="1"/&gt;
             *                           &lt;maxLength value="20"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModNF"/&gt;
             *                     &lt;element name="serie"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                           &lt;minLength value="1"/&gt;
             *                           &lt;maxLength value="3"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="nDoc"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                           &lt;minLength value="1"/&gt;
             *                           &lt;maxLength value="20"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
             *                     &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
             *                     &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
             *                     &lt;element name="vBCST" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
             *                     &lt;element name="vST" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
             *                     &lt;element name="vProd" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
             *                     &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
             *                     &lt;element name="nCFOP" type="{http://www.portalfiscal.inf.br/cte}TCfop"/&gt;
             *                     &lt;element name="nPeso" type="{http://www.portalfiscal.inf.br/cte}TDec_1203Opc" minOccurs="0"/&gt;
             *                     &lt;element name="PIN" minOccurs="0"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                           &lt;whiteSpace value="preserve"/&gt;
             *                           &lt;minLength value="2"/&gt;
             *                           &lt;maxLength value="9"/&gt;
             *                           &lt;pattern value="[1-9]{1}[0-9]{1,8}"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
             *                     &lt;choice&gt;
             *                       &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
             *                       &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
             *                     &lt;/choice&gt;
             *                   &lt;/sequence&gt;
             *                 &lt;/restriction&gt;
             *               &lt;/complexContent&gt;
             *             &lt;/complexType&gt;
             *           &lt;/element&gt;
             *           &lt;element name="infNFe" maxOccurs="unbounded"&gt;
             *             &lt;complexType&gt;
             *               &lt;complexContent&gt;
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                   &lt;sequence&gt;
             *                     &lt;element name="chave" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
             *                     &lt;element name="PIN" minOccurs="0"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                           &lt;whiteSpace value="preserve"/&gt;
             *                           &lt;minLength value="2"/&gt;
             *                           &lt;maxLength value="9"/&gt;
             *                           &lt;pattern value="[1-9]{1}[0-9]{1,8}"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
             *                     &lt;choice&gt;
             *                       &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
             *                       &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
             *                     &lt;/choice&gt;
             *                   &lt;/sequence&gt;
             *                 &lt;/restriction&gt;
             *               &lt;/complexContent&gt;
             *             &lt;/complexType&gt;
             *           &lt;/element&gt;
             *           &lt;element name="infOutros" maxOccurs="unbounded"&gt;
             *             &lt;complexType&gt;
             *               &lt;complexContent&gt;
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                   &lt;sequence&gt;
             *                     &lt;element name="tpDoc"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                           &lt;whiteSpace value="preserve"/&gt;
             *                           &lt;enumeration value="00"/&gt;
             *                           &lt;enumeration value="10"/&gt;
             *                           &lt;enumeration value="59"/&gt;
             *                           &lt;enumeration value="65"/&gt;
             *                           &lt;enumeration value="99"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="descOutros" minOccurs="0"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                           &lt;minLength value="1"/&gt;
             *                           &lt;maxLength value="100"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="nDoc" minOccurs="0"&gt;
             *                       &lt;simpleType&gt;
             *                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *                           &lt;minLength value="1"/&gt;
             *                           &lt;maxLength value="20"/&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleType&gt;
             *                     &lt;/element&gt;
             *                     &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
             *                     &lt;element name="vDocFisc" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
             *                     &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
             *                     &lt;choice&gt;
             *                       &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
             *                       &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
             *                     &lt;/choice&gt;
             *                   &lt;/sequence&gt;
             *                 &lt;/restriction&gt;
             *               &lt;/complexContent&gt;
             *             &lt;/complexType&gt;
             *           &lt;/element&gt;
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
                "infNF",
                "infNFe",
                "infOutros"
            })
            public static class InfDoc {

                protected List<TCTe.InfCte.InfCTeNorm.InfDoc.InfNF> infNF;
                protected List<TCTe.InfCte.InfCTeNorm.InfDoc.InfNFe> infNFe;
                protected List<TCTe.InfCte.InfCTeNorm.InfDoc.InfOutros> infOutros;

                /**
                 * Gets the value of the infNF property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the infNF property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getInfNF().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TCTe.InfCte.InfCTeNorm.InfDoc.InfNF }
                 * 
                 * 
                 */
                public List<TCTe.InfCte.InfCTeNorm.InfDoc.InfNF> getInfNF() {
                    if (infNF == null) {
                        infNF = new ArrayList<TCTe.InfCte.InfCTeNorm.InfDoc.InfNF>();
                    }
                    return this.infNF;
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
                 * {@link TCTe.InfCte.InfCTeNorm.InfDoc.InfNFe }
                 * 
                 * 
                 */
                public List<TCTe.InfCte.InfCTeNorm.InfDoc.InfNFe> getInfNFe() {
                    if (infNFe == null) {
                        infNFe = new ArrayList<TCTe.InfCte.InfCTeNorm.InfDoc.InfNFe>();
                    }
                    return this.infNFe;
                }

                /**
                 * Gets the value of the infOutros property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the infOutros property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getInfOutros().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TCTe.InfCte.InfCTeNorm.InfDoc.InfOutros }
                 * 
                 * 
                 */
                public List<TCTe.InfCte.InfCTeNorm.InfDoc.InfOutros> getInfOutros() {
                    if (infOutros == null) {
                        infOutros = new ArrayList<TCTe.InfCte.InfCTeNorm.InfDoc.InfOutros>();
                    }
                    return this.infOutros;
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
                 *         &lt;element name="nRoma" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *               &lt;minLength value="1"/&gt;
                 *               &lt;maxLength value="20"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="nPed" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *               &lt;minLength value="1"/&gt;
                 *               &lt;maxLength value="20"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModNF"/&gt;
                 *         &lt;element name="serie"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *               &lt;minLength value="1"/&gt;
                 *               &lt;maxLength value="3"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="nDoc"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *               &lt;minLength value="1"/&gt;
                 *               &lt;maxLength value="20"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
                 *         &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
                 *         &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
                 *         &lt;element name="vBCST" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
                 *         &lt;element name="vST" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
                 *         &lt;element name="vProd" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
                 *         &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
                 *         &lt;element name="nCFOP" type="{http://www.portalfiscal.inf.br/cte}TCfop"/&gt;
                 *         &lt;element name="nPeso" type="{http://www.portalfiscal.inf.br/cte}TDec_1203Opc" minOccurs="0"/&gt;
                 *         &lt;element name="PIN" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;whiteSpace value="preserve"/&gt;
                 *               &lt;minLength value="2"/&gt;
                 *               &lt;maxLength value="9"/&gt;
                 *               &lt;pattern value="[1-9]{1}[0-9]{1,8}"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
                 *         &lt;choice&gt;
                 *           &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
                 *           &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
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
                    "nRoma",
                    "nPed",
                    "mod",
                    "serie",
                    "nDoc",
                    "dEmi",
                    "vbc",
                    "vicms",
                    "vbcst",
                    "vst",
                    "vProd",
                    "vnf",
                    "ncfop",
                    "nPeso",
                    "pin",
                    "dPrev",
                    "infUnidCarga",
                    "infUnidTransp"
                })
                public static class InfNF {

                    protected String nRoma;
                    protected String nPed;
                    @XmlElement(required = true)
                    protected String mod;
                    @XmlElement(required = true)
                    protected String serie;
                    @XmlElement(required = true)
                    protected String nDoc;
                    @XmlElement(required = true)
                    protected String dEmi;
                    @XmlElement(name = "vBC", required = true)
                    protected String vbc;
                    @XmlElement(name = "vICMS", required = true)
                    protected String vicms;
                    @XmlElement(name = "vBCST", required = true)
                    protected String vbcst;
                    @XmlElement(name = "vST", required = true)
                    protected String vst;
                    @XmlElement(required = true)
                    protected String vProd;
                    @XmlElement(name = "vNF", required = true)
                    protected String vnf;
                    @XmlElement(name = "nCFOP", required = true)
                    protected String ncfop;
                    protected String nPeso;
                    @XmlElement(name = "PIN")
                    protected String pin;
                    protected String dPrev;
                    protected List<TUnidCarga> infUnidCarga;
                    protected List<TUnidadeTransp> infUnidTransp;

                    /**
                     * Obtém o valor da propriedade nRoma.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNRoma() {
                        return nRoma;
                    }

                    /**
                     * Define o valor da propriedade nRoma.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNRoma(String value) {
                        this.nRoma = value;
                    }

                    /**
                     * Obtém o valor da propriedade nPed.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNPed() {
                        return nPed;
                    }

                    /**
                     * Define o valor da propriedade nPed.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNPed(String value) {
                        this.nPed = value;
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
                     * Obtém o valor da propriedade nDoc.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNDoc() {
                        return nDoc;
                    }

                    /**
                     * Define o valor da propriedade nDoc.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNDoc(String value) {
                        this.nDoc = value;
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
                     * Obtém o valor da propriedade vbc.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getVBC() {
                        return vbc;
                    }

                    /**
                     * Define o valor da propriedade vbc.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setVBC(String value) {
                        this.vbc = value;
                    }

                    /**
                     * Obtém o valor da propriedade vicms.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getVICMS() {
                        return vicms;
                    }

                    /**
                     * Define o valor da propriedade vicms.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setVICMS(String value) {
                        this.vicms = value;
                    }

                    /**
                     * Obtém o valor da propriedade vbcst.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getVBCST() {
                        return vbcst;
                    }

                    /**
                     * Define o valor da propriedade vbcst.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setVBCST(String value) {
                        this.vbcst = value;
                    }

                    /**
                     * Obtém o valor da propriedade vst.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getVST() {
                        return vst;
                    }

                    /**
                     * Define o valor da propriedade vst.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setVST(String value) {
                        this.vst = value;
                    }

                    /**
                     * Obtém o valor da propriedade vProd.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getVProd() {
                        return vProd;
                    }

                    /**
                     * Define o valor da propriedade vProd.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setVProd(String value) {
                        this.vProd = value;
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
                     * Obtém o valor da propriedade ncfop.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNCFOP() {
                        return ncfop;
                    }

                    /**
                     * Define o valor da propriedade ncfop.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNCFOP(String value) {
                        this.ncfop = value;
                    }

                    /**
                     * Obtém o valor da propriedade nPeso.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNPeso() {
                        return nPeso;
                    }

                    /**
                     * Define o valor da propriedade nPeso.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNPeso(String value) {
                        this.nPeso = value;
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
                     * Obtém o valor da propriedade dPrev.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDPrev() {
                        return dPrev;
                    }

                    /**
                     * Define o valor da propriedade dPrev.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDPrev(String value) {
                        this.dPrev = value;
                    }

                    /**
                     * Gets the value of the infUnidCarga property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the infUnidCarga property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getInfUnidCarga().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link TUnidCarga }
                     * 
                     * 
                     */
                    public List<TUnidCarga> getInfUnidCarga() {
                        if (infUnidCarga == null) {
                            infUnidCarga = new ArrayList<TUnidCarga>();
                        }
                        return this.infUnidCarga;
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
                 *         &lt;element name="chave" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
                 *         &lt;element name="PIN" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;whiteSpace value="preserve"/&gt;
                 *               &lt;minLength value="2"/&gt;
                 *               &lt;maxLength value="9"/&gt;
                 *               &lt;pattern value="[1-9]{1}[0-9]{1,8}"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
                 *         &lt;choice&gt;
                 *           &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
                 *           &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
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
                    "chave",
                    "pin",
                    "dPrev",
                    "infUnidCarga",
                    "infUnidTransp"
                })
                public static class InfNFe {

                    @XmlElement(required = true)
                    protected String chave;
                    @XmlElement(name = "PIN")
                    protected String pin;
                    protected String dPrev;
                    protected List<TUnidCarga> infUnidCarga;
                    protected List<TUnidadeTransp> infUnidTransp;

                    /**
                     * Obtém o valor da propriedade chave.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getChave() {
                        return chave;
                    }

                    /**
                     * Define o valor da propriedade chave.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setChave(String value) {
                        this.chave = value;
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
                     * Obtém o valor da propriedade dPrev.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDPrev() {
                        return dPrev;
                    }

                    /**
                     * Define o valor da propriedade dPrev.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDPrev(String value) {
                        this.dPrev = value;
                    }

                    /**
                     * Gets the value of the infUnidCarga property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the infUnidCarga property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getInfUnidCarga().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link TUnidCarga }
                     * 
                     * 
                     */
                    public List<TUnidCarga> getInfUnidCarga() {
                        if (infUnidCarga == null) {
                            infUnidCarga = new ArrayList<TUnidCarga>();
                        }
                        return this.infUnidCarga;
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
                 *         &lt;element name="tpDoc"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *               &lt;whiteSpace value="preserve"/&gt;
                 *               &lt;enumeration value="00"/&gt;
                 *               &lt;enumeration value="10"/&gt;
                 *               &lt;enumeration value="59"/&gt;
                 *               &lt;enumeration value="65"/&gt;
                 *               &lt;enumeration value="99"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="descOutros" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *               &lt;minLength value="1"/&gt;
                 *               &lt;maxLength value="100"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="nDoc" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
                 *               &lt;minLength value="1"/&gt;
                 *               &lt;maxLength value="20"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
                 *         &lt;element name="vDocFisc" type="{http://www.portalfiscal.inf.br/cte}TDec_1302Opc" minOccurs="0"/&gt;
                 *         &lt;element name="dPrev" type="{http://www.portalfiscal.inf.br/cte}TData" minOccurs="0"/&gt;
                 *         &lt;choice&gt;
                 *           &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
                 *           &lt;element name="infUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TUnidadeTransp" maxOccurs="unbounded" minOccurs="0"/&gt;
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
                    "tpDoc",
                    "descOutros",
                    "nDoc",
                    "dEmi",
                    "vDocFisc",
                    "dPrev",
                    "infUnidCarga",
                    "infUnidTransp"
                })
                public static class InfOutros {

                    @XmlElement(required = true)
                    protected String tpDoc;
                    protected String descOutros;
                    protected String nDoc;
                    protected String dEmi;
                    protected String vDocFisc;
                    protected String dPrev;
                    protected List<TUnidCarga> infUnidCarga;
                    protected List<TUnidadeTransp> infUnidTransp;

                    /**
                     * Obtém o valor da propriedade tpDoc.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTpDoc() {
                        return tpDoc;
                    }

                    /**
                     * Define o valor da propriedade tpDoc.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTpDoc(String value) {
                        this.tpDoc = value;
                    }

                    /**
                     * Obtém o valor da propriedade descOutros.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDescOutros() {
                        return descOutros;
                    }

                    /**
                     * Define o valor da propriedade descOutros.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDescOutros(String value) {
                        this.descOutros = value;
                    }

                    /**
                     * Obtém o valor da propriedade nDoc.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNDoc() {
                        return nDoc;
                    }

                    /**
                     * Define o valor da propriedade nDoc.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNDoc(String value) {
                        this.nDoc = value;
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
                     * Obtém o valor da propriedade vDocFisc.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getVDocFisc() {
                        return vDocFisc;
                    }

                    /**
                     * Define o valor da propriedade vDocFisc.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setVDocFisc(String value) {
                        this.vDocFisc = value;
                    }

                    /**
                     * Obtém o valor da propriedade dPrev.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDPrev() {
                        return dPrev;
                    }

                    /**
                     * Define o valor da propriedade dPrev.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDPrev(String value) {
                        this.dPrev = value;
                    }

                    /**
                     * Gets the value of the infUnidCarga property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the infUnidCarga property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getInfUnidCarga().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link TUnidCarga }
                     * 
                     * 
                     */
                    public List<TUnidCarga> getInfUnidCarga() {
                        if (infUnidCarga == null) {
                            infUnidCarga = new ArrayList<TUnidCarga>();
                        }
                        return this.infUnidCarga;
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
             *         &lt;element name="xObs"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="15"/&gt;
             *               &lt;maxLength value="256"/&gt;
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
                "xObs"
            })
            public static class InfGlobalizado {

                @XmlElement(required = true)
                protected String xObs;

                /**
                 * Obtém o valor da propriedade xObs.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXObs() {
                    return xObs;
                }

                /**
                 * Define o valor da propriedade xObs.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXObs(String value) {
                    this.xObs = value;
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
             *         &lt;element name="infCTeMultimodal" maxOccurs="unbounded"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="chCTeMultimodal" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
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
                "infCTeMultimodal"
            })
            public static class InfServVinc {

                @XmlElement(required = true)
                protected List<TCTe.InfCte.InfCTeNorm.InfServVinc.InfCTeMultimodal> infCTeMultimodal;

                /**
                 * Gets the value of the infCTeMultimodal property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the infCTeMultimodal property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getInfCTeMultimodal().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TCTe.InfCte.InfCTeNorm.InfServVinc.InfCTeMultimodal }
                 * 
                 * 
                 */
                public List<TCTe.InfCte.InfCTeNorm.InfServVinc.InfCTeMultimodal> getInfCTeMultimodal() {
                    if (infCTeMultimodal == null) {
                        infCTeMultimodal = new ArrayList<TCTe.InfCte.InfCTeNorm.InfServVinc.InfCTeMultimodal>();
                    }
                    return this.infCTeMultimodal;
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
                 *         &lt;element name="chCTeMultimodal" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
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
                    "chCTeMultimodal"
                })
                public static class InfCTeMultimodal {

                    @XmlElement(required = true)
                    protected String chCTeMultimodal;

                    /**
                     * Obtém o valor da propriedade chCTeMultimodal.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getChCTeMultimodal() {
                        return chCTeMultimodal;
                    }

                    /**
                     * Define o valor da propriedade chCTeMultimodal.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setChCTeMultimodal(String value) {
                        this.chCTeMultimodal = value;
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
             *         &lt;element name="chassi"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;whiteSpace value="preserve"/&gt;
             *               &lt;length value="17"/&gt;
             *               &lt;pattern value="[A-Z0-9]+"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="cCor"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="4"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="xCor"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="40"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="cMod"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="6"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="vUnit" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
             *         &lt;element name="vFrete" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
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
                "chassi",
                "cCor",
                "xCor",
                "cMod",
                "vUnit",
                "vFrete"
            })
            public static class VeicNovos {

                @XmlElement(required = true)
                protected String chassi;
                @XmlElement(required = true)
                protected String cCor;
                @XmlElement(required = true)
                protected String xCor;
                @XmlElement(required = true)
                protected String cMod;
                @XmlElement(required = true)
                protected String vUnit;
                @XmlElement(required = true)
                protected String vFrete;

                /**
                 * Obtém o valor da propriedade chassi.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChassi() {
                    return chassi;
                }

                /**
                 * Define o valor da propriedade chassi.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChassi(String value) {
                    this.chassi = value;
                }

                /**
                 * Obtém o valor da propriedade cCor.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCCor() {
                    return cCor;
                }

                /**
                 * Define o valor da propriedade cCor.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCCor(String value) {
                    this.cCor = value;
                }

                /**
                 * Obtém o valor da propriedade xCor.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getXCor() {
                    return xCor;
                }

                /**
                 * Define o valor da propriedade xCor.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setXCor(String value) {
                    this.xCor = value;
                }

                /**
                 * Obtém o valor da propriedade cMod.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCMod() {
                    return cMod;
                }

                /**
                 * Define o valor da propriedade cMod.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCMod(String value) {
                    this.cMod = value;
                }

                /**
                 * Obtém o valor da propriedade vUnit.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVUnit() {
                    return vUnit;
                }

                /**
                 * Define o valor da propriedade vUnit.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVUnit(String value) {
                    this.vUnit = value;
                }

                /**
                 * Obtém o valor da propriedade vFrete.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVFrete() {
                    return vFrete;
                }

                /**
                 * Define o valor da propriedade vFrete.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVFrete(String value) {
                    this.vFrete = value;
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
         *         &lt;choice&gt;
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="IE" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
         *         &lt;element name="enderReceb" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
         *         &lt;element name="email" type="{http://www.portalfiscal.inf.br/cte}TEmail" minOccurs="0"/&gt;
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
            "ie",
            "xNome",
            "fone",
            "enderReceb",
            "email"
        })
        public static class Receb {

            @XmlElement(name = "CNPJ")
            protected String cnpj;
            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(name = "IE")
            protected String ie;
            @XmlElement(required = true)
            protected String xNome;
            protected String fone;
            @XmlElement(required = true)
            protected TEndereco enderReceb;
            protected String email;

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
             * Obtém o valor da propriedade fone.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFone() {
                return fone;
            }

            /**
             * Define o valor da propriedade fone.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFone(String value) {
                this.fone = value;
            }

            /**
             * Obtém o valor da propriedade enderReceb.
             * 
             * @return
             *     possible object is
             *     {@link TEndereco }
             *     
             */
            public TEndereco getEnderReceb() {
                return enderReceb;
            }

            /**
             * Define o valor da propriedade enderReceb.
             * 
             * @param value
             *     allowed object is
             *     {@link TEndereco }
             *     
             */
            public void setEnderReceb(TEndereco value) {
                this.enderReceb = value;
            }

            /**
             * Obtém o valor da propriedade email.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmail() {
                return email;
            }

            /**
             * Define o valor da propriedade email.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmail(String value) {
                this.email = value;
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
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="IE" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xFant" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
         *         &lt;element name="enderReme" type="{http://www.portalfiscal.inf.br/cte}TEndereco"/&gt;
         *         &lt;element name="email" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TEmail"&gt;
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
            "cnpj",
            "cpf",
            "ie",
            "xNome",
            "xFant",
            "fone",
            "enderReme",
            "email"
        })
        public static class Rem {

            @XmlElement(name = "CNPJ")
            protected String cnpj;
            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(name = "IE")
            protected String ie;
            @XmlElement(required = true)
            protected String xNome;
            protected String xFant;
            protected String fone;
            @XmlElement(required = true)
            protected TEndereco enderReme;
            protected String email;

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
             * Obtém o valor da propriedade fone.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFone() {
                return fone;
            }

            /**
             * Define o valor da propriedade fone.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFone(String value) {
                this.fone = value;
            }

            /**
             * Obtém o valor da propriedade enderReme.
             * 
             * @return
             *     possible object is
             *     {@link TEndereco }
             *     
             */
            public TEndereco getEnderReme() {
                return enderReme;
            }

            /**
             * Define o valor da propriedade enderReme.
             * 
             * @param value
             *     allowed object is
             *     {@link TEndereco }
             *     
             */
            public void setEnderReme(TEndereco value) {
                this.enderReme = value;
            }

            /**
             * Obtém o valor da propriedade email.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmail() {
                return email;
            }

            /**
             * Define o valor da propriedade email.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmail(String value) {
                this.email = value;
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
         *         &lt;element name="vTPrest" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *         &lt;element name="vRec" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
         *         &lt;element name="Comp" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="xNome"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;maxLength value="15"/&gt;
         *                         &lt;minLength value="1"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="vComp" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
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
            "vtPrest",
            "vRec",
            "comp"
        })
        public static class VPrest {

            @XmlElement(name = "vTPrest", required = true)
            protected String vtPrest;
            @XmlElement(required = true)
            protected String vRec;
            @XmlElement(name = "Comp")
            protected List<TCTe.InfCte.VPrest.Comp> comp;

            /**
             * Obtém o valor da propriedade vtPrest.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVTPrest() {
                return vtPrest;
            }

            /**
             * Define o valor da propriedade vtPrest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVTPrest(String value) {
                this.vtPrest = value;
            }

            /**
             * Obtém o valor da propriedade vRec.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVRec() {
                return vRec;
            }

            /**
             * Define o valor da propriedade vRec.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVRec(String value) {
                this.vRec = value;
            }

            /**
             * Gets the value of the comp property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the comp property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getComp().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TCTe.InfCte.VPrest.Comp }
             * 
             * 
             */
            public List<TCTe.InfCte.VPrest.Comp> getComp() {
                if (comp == null) {
                    comp = new ArrayList<TCTe.InfCte.VPrest.Comp>();
                }
                return this.comp;
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
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;maxLength value="15"/&gt;
             *               &lt;minLength value="1"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="vComp" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
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
                "vComp"
            })
            public static class Comp {

                @XmlElement(required = true)
                protected String xNome;
                @XmlElement(required = true)
                protected String vComp;

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
                 * Obtém o valor da propriedade vComp.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVComp() {
                    return vComp;
                }

                /**
                 * Define o valor da propriedade vComp.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVComp(String value) {
                    this.vComp = value;
                }

            }

        }

    }

}
