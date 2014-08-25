package com.fincatto.nfe;

import java.io.IOException;
import java.io.InputStream;

public interface NFEConfig {

    public InputStream getCertificado() throws IOException;

    public String getCertificadoSenha();
}