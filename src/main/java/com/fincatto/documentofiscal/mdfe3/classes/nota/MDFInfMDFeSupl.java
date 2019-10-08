/*
 * Copyright 2019 Edivaldo Merlo Stens.
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

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * Edivaldo Merlo Stens on 07/10/19.
 */
@Root(name = "infMDFeSupl")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfMDFeSupl extends DFBase {

    @Element(name = "qrCodMDFe", required = true)
    private String qrCodMDFe;

    /**
     * Obtém o valor da propriedade qrCodMDFe.
     *
     * @return possible object is {@link String }
     *
     */
    public String getQrCodMDFe() {
        return qrCodMDFe;
    }

    /**
     * Define o valor da propriedade qrCodMDFe.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setQrCodMDFe(String value) {
        this.qrCodMDFe = value;
    }
}
