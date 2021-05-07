/*
 * Copyright 2020 Edivaldo Merlo Stens.
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
 * @author Edivaldo Merlo Stens on 29/06/20.
 */
public class MDFInfSolicNFF {

    /**
     * Solicitação do Pedido da Emissão NFF. Dados no formato Json
     */
    @Element(name="xSolic", required = true)
    protected String xSolic;

    public String getXSolic() {
        return xSolic;
    }

    public void setXSolic(String xSolic) {
        this.xSolic = xSolic;
    }
    
}
