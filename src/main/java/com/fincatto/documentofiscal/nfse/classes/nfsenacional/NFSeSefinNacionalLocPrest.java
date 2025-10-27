
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Grupo de informações relativas ao local da prestação do serviço
 */

@Root(name = "locPrest")
public class NFSeSefinNacionalLocPrest {

    @Element(name = "cLocPrestacao", required = false)
    protected String codigoMunicipio;
    @Element(name = "cPaisPrestacao", required = false)
    protected String codigoPais;
    @Element(name = "opConsumServ", required = false)
    protected NFSeSefinNacionalLocPrestOpcaoConsumoServico opcaoConsumoServico;

    /**
     * <a href="https://www.gov.br/nfse/pt-br/biblioteca/documentacao-tecnica/documentacao-atual">Documentações e anexos</a>
     *
     * @return código do município de emissão na tabela do IBGE
     */
    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    /**
     * <a href="https://www.gov.br/nfse/pt-br/biblioteca/documentacao-tecnica/documentacao-atual">Documentações e anexos</a>
     *
     * @param codigoMunicipio código do município de emissão na tabela do IBGE
     */
    public NFSeSefinNacionalLocPrest setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
        return this;
    }

    /**
     * @return Código do país (Tabela de Países ISO)
     */
    public String getCodigoPais() {
        return codigoPais;
    }

    /**
     * @param codigoPais Código do país (Tabela de Países ISO)
     */
    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    /**
     * @return Opção para que o emitente informe onde ocorreu o consumo do serviço prestado.
     */
    public NFSeSefinNacionalLocPrestOpcaoConsumoServico getOpcaoConsumoServico() {
        return opcaoConsumoServico;
    }

    /**
     * @param opcaoConsumoServico Opção para que o emitente informe onde ocorreu o consumo do serviço prestado.
     */
    public void setOpcaoConsumoServico(NFSeSefinNacionalLocPrestOpcaoConsumoServico opcaoConsumoServico) {
        this.opcaoConsumoServico = opcaoConsumoServico;
    }

}
