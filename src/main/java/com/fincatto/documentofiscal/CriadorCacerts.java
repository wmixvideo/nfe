package com.fincatto.documentofiscal;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.utils.DFCadeiaCertificados;

import java.io.File;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Eric
 */

public class CriadorCacerts {

    public static void main(String args[]) {
        try {
        FileUtils.writeByteArrayToFile(new File("/Users/ericgravescamollez/Dev/Projects/NetBeansProjects/producao.cacerts"), DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.PRODUCAO, "senha"));
        FileUtils.writeByteArrayToFile(new File("/Users/ericgravescamollez/Dev/Projects/NetBeansProjects/homologacao.cacerts"), DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.HOMOLOGACAO, "senha"));
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
