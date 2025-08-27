/*
 * Copyright 2019 Edivaldo Merlo Stens..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;

/**
 *
 * @author Edivaldo Merlo Stens on 07/10/19.
 */
public class MDFRespTec {

    @Element(name = "CNPJ", required = true)
    private String cnpj;
    
    @Element(name = "xContato", required = true)
    private String xContato;
    
    @Element(name = "email", required = true)
    private String email;
    
    @Element(name = "fone", required = true)
    private String fone;
    
    @Element(name = "idCSRT", required = false)
    private String idCSRT;
    
    @Element(name = "hashCSRT", required = false)
    private byte[] hashCSRT;

    /**
     * Obtém o valor da propriedade cnpj.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * Define o valor da propriedade cnpj.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    /**
     * Obtém o valor da propriedade xContato.
     *
     * @return possible object is {@link String }
     *
     */
    public String getXContato() {
        return xContato;
    }

    /**
     * Define o valor da propriedade xContato.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setXContato(String value) {
        this.xContato = value;
    }

    /**
     * Obtém o valor da propriedade email.
     *
     * @return possible object is {@link String }
     *
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o valor da propriedade email.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtém o valor da propriedade fone.
     *
     * @return possible object is {@link String }
     *
     */
    public String getFone() {
        return fone;
    }

    /**
     * Define o valor da propriedade fone.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setFone(String value) {
        this.fone = value;
    }

    /**
     * Obtém o valor da propriedade idCSRT.
     *
     * @return possible object is {@link String }
     *
     */
    public String getIdCSRT() {
        return idCSRT;
    }

    /**
     * Define o valor da propriedade idCSRT.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setIdCSRT(String value) {
        this.idCSRT = value;
    }

    /**
     * Obtém o valor da propriedade hashCSRT.
     *
     * @return possible object is byte[]
     */
    public byte[] getHashCSRT() {
        return hashCSRT;
    }

    /**
     * Define o valor da propriedade hashCSRT.
     *
     * @param value allowed object is byte[]
     */
    public void setHashCSRT(byte[] value) {
        this.hashCSRT = value;
    }
}
