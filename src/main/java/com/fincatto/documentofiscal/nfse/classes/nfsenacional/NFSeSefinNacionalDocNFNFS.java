
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "DocNFNFS")
public class NFSeSefinNacionalDocNFNFS {

    @Element(name = "nNFS")
    protected String numero;
    @Element(name = "modNFS")
    protected String modelo;
    @Element(name = "serieNFS")
    protected String serie;

    /**
     * @return Número da Nota Fiscal NF ou NFS
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero Número da Nota Fiscal NF ou NFS
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return Modelo da Nota Fiscal NF ou NFS
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo Modelo da Nota Fiscal NF ou NFS
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return Série Nota Fiscal NF ou NFS
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie Série Nota Fiscal NF ou NFS
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

}
