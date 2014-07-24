package com.fincatto.nfe.classes.nota;

import org.junit.Test;

public class NFNotaInfoTransportadorTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setCnpj("34843274000164");
        transportador.setEnderecoComplemento("D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY");
        transportador.setInscricaoEstadual("");
    }
}