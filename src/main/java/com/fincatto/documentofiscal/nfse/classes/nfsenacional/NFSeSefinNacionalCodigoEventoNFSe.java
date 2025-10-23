
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Root;

@Root(name = "TSCodigoEventoNFSe")
public enum NFSeSefinNacionalCodigoEventoNFSe {

        E_101101("e101101"),
        E_105102("e105102"),
        E_105104("e105104"),
        E_105105("e105105"),
        E_305101("e305101"),
        E_907202("e907202"),
        E_967203("e967203");
    private final String value;

    NFSeSefinNacionalCodigoEventoNFSe(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NFSeSefinNacionalCodigoEventoNFSe fromValue(String v) {
        for (NFSeSefinNacionalCodigoEventoNFSe c: NFSeSefinNacionalCodigoEventoNFSe.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
