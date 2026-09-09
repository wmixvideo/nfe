package com.fincatto.documentofiscal.lookup;

import java.io.IOException;

/**
 * Abstração mínima de transporte HTTP usada pela {@link CpfCnpjComBrLookup}.
 *
 * <p>Existe por dois motivos: manter a implementação de referência desacoplada de uma
 * stack HTTP específica (a padrão usa o cliente da JDK 11, sem dependência nova) e
 * permitir testes com respostas simuladas, sem subir um servidor. Quem preferir pode
 * fornecer a própria implementação, por exemplo sobre o httpclient5 já presente no
 * classpath.</p>
 */
public interface HttpTransport {

    /**
     * Executa um GET e devolve o corpo da resposta como texto.
     *
     * <p>O corpo deve ser devolvido mesmo em respostas com código de erro HTTP, pois a
     * API cpfcnpj.com.br sinaliza documento inválido com corpo JSON ({@code status:0})
     * acompanhado de código HTTP 400.</p>
     *
     * @param url URL completa a consultar.
     * @return corpo da resposta.
     * @throws IOException em caso de falha de comunicação.
     */
    String get(String url) throws IOException;
}
