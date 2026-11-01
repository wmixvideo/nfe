package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFEndereco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFEnderecoTest {

    @Test
    public void naoDevePermitirBairroComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFEndereco().setBairro("");
            } catch (final IllegalStateException e) {
                new NFEndereco().setBairro("67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU1");
            }
        });
    }

    @Test
    public void naoDevePermitirTelefoneComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFEndereco().setTelefone("12345");
            } catch (final IllegalStateException e) {
                new NFEndereco().setTelefone("123456789012345");
            }
        });
    }

    @Test
    public void naoDevePermitirNumeroComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFEndereco().setNumero("");
            } catch (final IllegalStateException e) {
                new NFEndereco().setNumero("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y1");
            }
        });
    }

    @Test
    public void naoDevePermitirLogradouroComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFEndereco().setLogradouro("");
            } catch (final IllegalStateException e) {
                new NFEndereco().setLogradouro("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y1");
            }
        });
    }

    @Test
    public void naoDevePermitirDescricaoMunicipioComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFEndereco().setDescricaoMunicipio("");
            } catch (final IllegalStateException e) {
                new NFEndereco().setDescricaoMunicipio("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y1");
            }
        });
    }

    @Test
    public void naoDevePermitirComplementoComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFEndereco().setComplemento("");
            } catch (final IllegalStateException e) {
                new NFEndereco().setComplemento("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y1");
            }
        });
    }

    @Test
    public void naoDevePermitirCodigoMunicipioComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFEndereco().setCodigoMunicipio("999999");
            } catch (final IllegalStateException e) {
                new NFEndereco().setCodigoMunicipio("10000000");
            }
        });
    }

    @Test
    public void deveObterCepComoFoiSetado() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setCep("88095550");
        Assertions.assertEquals("88095550", endereco.getCep());
    }

    @Test
    public void deveObterBairroComoFoiSetado() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setBairro("Principal");
        Assertions.assertEquals("Principal", endereco.getBairro());
    }

    @Test
    public void deveObterCodigoMunicipioComoFoiSetado() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setCodigoMunicipio("9999999");
        Assertions.assertEquals("9999999", endereco.getCodigoMunicipio());
    }

    @Test
    public void deveObterCodigoPaisComoFoiSetado() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setCodigoPais("999");
        Assertions.assertEquals("999", endereco.getCodigoPais());
    }

    @Test
    public void deveObterComplementoComoFoiSetado() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setComplemento("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
        Assertions.assertEquals("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw", endereco.getComplemento());
    }

    @Test
    public void deveObterDescricaoMunicipioComoFoiSetado() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setDescricaoMunicipio("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
        Assertions.assertEquals("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw", endereco.getDescricaoMunicipio());
    }

    @Test
    public void deveObterLogradouroComoFoiSetado() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setLogradouro("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
        Assertions.assertEquals("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw", endereco.getLogradouro());
    }

    @Test
    public void deveObterNumeroComoFoiSetado() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setNumero("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y");
        Assertions.assertEquals("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y", endereco.getNumero());
    }

    @Test
    public void deveObterTelefoneComoFoiSetado() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setTelefone("12345678901324");
        Assertions.assertEquals("12345678901324", endereco.getTelefone());
    }

    @Test
    public void deveObterUfComoFoiSetado() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setUf(DFUnidadeFederativa.SC);
        Assertions.assertEquals("SC", endereco.getUf());
    }

    @Test
    public void naoDevePermitirBairroNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEndereco endereco = new NFEndereco();
            endereco.setCep("88095550");
            endereco.setCodigoMunicipio("9999999");
            endereco.setCodigoPais("999");
            endereco.setComplemento("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
            endereco.setDescricaoMunicipio("s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG");
            endereco.setLogradouro("NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV");
            endereco.setNumero("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y");
            endereco.setTelefone("12345678901324");
            endereco.setUf(DFUnidadeFederativa.SC);
            endereco.toString();
        });
    }

    @Test
    public void devePermitirCepNulo() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setBairro("67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU");
        endereco.setCodigoMunicipio("9999999");
        endereco.setCodigoPais("999");
        endereco.setComplemento("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
        endereco.setDescricaoMunicipio("s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG");
        endereco.setLogradouro("NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV");
        endereco.setNumero("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y");
        endereco.setTelefone("12345678901324");
        endereco.setUf(DFUnidadeFederativa.SC);
        Assertions.assertNotNull(endereco.toString());
    }

    @Test
    public void naoDevePermitirCodigoMunicipioNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEndereco endereco = new NFEndereco();
            endereco.setBairro("67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU");
            endereco.setCep("88095550");
            endereco.setCodigoPais("999");
            endereco.setComplemento("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
            endereco.setDescricaoMunicipio("s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG");
            endereco.setLogradouro("NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV");
            endereco.setNumero("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y");
            endereco.setTelefone("12345678901324");
            endereco.setUf(DFUnidadeFederativa.SC);
            endereco.toString();
        });
    }

    @Test
    public void devePermitirCodigoPaisNulo() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setBairro("67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU");
        endereco.setCep("88095550");
        endereco.setCodigoMunicipio("9999999");
        endereco.setComplemento("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
        endereco.setDescricaoMunicipio("s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG");
        endereco.setLogradouro("NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV");
        endereco.setNumero("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y");
        endereco.setTelefone("12345678901324");
        endereco.setUf(DFUnidadeFederativa.SC);
        Assertions.assertNotNull(endereco.toString());
    }

    @Test
    public void devePermitirComplementoNulo() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setBairro("67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU");
        endereco.setCep("88095550");
        endereco.setCodigoMunicipio("9999999");
        endereco.setCodigoPais("999");
        endereco.setDescricaoMunicipio("s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG");
        endereco.setLogradouro("NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV");
        endereco.setNumero("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y");
        endereco.setTelefone("12345678901324");
        endereco.setUf(DFUnidadeFederativa.SC);
        endereco.toString();
    }

    @Test
    public void naoDevePermitirDescricaoMunicipioNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEndereco endereco = new NFEndereco();
            endereco.setBairro("67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU");
            endereco.setCep("88095550");
            endereco.setCodigoMunicipio("9999999");
            endereco.setCodigoPais("999");
            endereco.setComplemento("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
            endereco.setLogradouro("NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV");
            endereco.setNumero("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y");
            endereco.setTelefone("12345678901324");
            endereco.setUf(DFUnidadeFederativa.SC);
            endereco.toString();
        });
    }

    @Test
    public void naoDevePermitirLogradouroNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEndereco endereco = new NFEndereco();
            endereco.setBairro("67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU");
            endereco.setCep("88095550");
            endereco.setCodigoMunicipio("9999999");
            endereco.setCodigoPais("999");
            endereco.setComplemento("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
            endereco.setDescricaoMunicipio("s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG");
            endereco.setNumero("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y");
            endereco.setTelefone("12345678901324");
            endereco.setUf(DFUnidadeFederativa.SC);
            endereco.toString();
        });
    }

    @Test
    public void naoDevePermitirNumeroNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEndereco endereco = new NFEndereco();
            endereco.setBairro("67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU");
            endereco.setCep("88095550");
            endereco.setCodigoMunicipio("9999999");
            endereco.setCodigoPais("999");
            endereco.setComplemento("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
            endereco.setDescricaoMunicipio("s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG");
            endereco.setLogradouro("NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV");
            endereco.setTelefone("12345678901324");
            endereco.setUf(DFUnidadeFederativa.SC);
            endereco.toString();
        });
    }

    @Test
    public void devePermitirTelefoneNulo() {
        final NFEndereco endereco = new NFEndereco();
        endereco.setBairro("67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU");
        endereco.setCep("88095550");
        endereco.setCodigoMunicipio("9999999");
        endereco.setCodigoPais("999");
        endereco.setComplemento("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
        endereco.setDescricaoMunicipio("s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG");
        endereco.setLogradouro("NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV");
        endereco.setNumero("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y");
        endereco.setUf(DFUnidadeFederativa.SC);
        endereco.toString();
    }

    @Test
    public void naoDevePermitirUFNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEndereco endereco = new NFEndereco();
            endereco.setBairro("67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU");
            endereco.setCep("88095550");
            endereco.setCodigoMunicipio("9999999");
            endereco.setCodigoPais("999");
            endereco.setComplemento("Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw");
            endereco.setDescricaoMunicipio("s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG");
            endereco.setLogradouro("NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV");
            endereco.setNumero("11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y");
            endereco.setTelefone("12345678901324");
            endereco.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFEndereco><xLgr>NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV</xLgr><nro>11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y</nro><xCpl>Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw</xCpl><xBairro>67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU</xBairro><cMun>9999999</cMun><xMun>s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG</xMun><UF>RS</UF><CEP>88095550</CEP><cPais>1058</cPais><fone>12345678901324</fone></NFEndereco>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFEndereco().toString());
    }
}