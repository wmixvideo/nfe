
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações relativas a atividades de Locação, sublocação, arrendamento, direito de passagem ou permissão de uso,
 * compartilhado ou não, de ferrovia, rodovia, postes, cabos, dutos e condutos de qualquer natureza
 */

@Root(name = "LocacaoSublocacao")
public class NFSeSefinNacionalLocacaoSublocacao {

    @Element(name="categ")
    protected NFSeSefinNacionalLocacaoSublocacaoCategoriaServico categoria;
    @Element(name="objeto")
    protected NFSeSefinNacionalLocacaoSublocacaoObjeto objeto;
    @Element(name="extensao")
    protected String extensao;
    @Element(name="nPostes")
    protected String numeroDePostes;

    /**
     * @return Categoria do serviço
     */
    public NFSeSefinNacionalLocacaoSublocacaoCategoriaServico getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do serviço
     *
     * @param categoria Categoria do serviço
     */
    public void setCategoria(NFSeSefinNacionalLocacaoSublocacaoCategoriaServico categoria) {
        this.categoria = categoria;
    }

    /**
     * Tipo de objetos da locação, sublocação, arrendamento, direito de passagem ou permissão de uso
     *
     * @return Objeto da locação/sublocação
     */
    public NFSeSefinNacionalLocacaoSublocacaoObjeto getObjeto() {
        return objeto;
    }

    /**
     * Define o tipo de objetos da locação, sublocação, arrendamento, direito de passagem ou permissão de uso
     *
     * @param objeto Objeto da locação/sublocação
     */
    public void setObjeto(NFSeSefinNacionalLocacaoSublocacaoObjeto objeto) {
        this.objeto = objeto;
    }

    /**
     * Extensão total da ferrovia, rodovia, cabos, dutos ou condutos
     *
     * @return Extensão da locação/sublocação
     */
    public String getExtensao() {
        return extensao;
    }

    /**
     * Define a extensão total da ferrovia, rodovia, cabos, dutos ou condutos
     *
     * @param value Extensão da locação/sublocação
     */
    public void setExtensao(String value) {
        this.extensao = value;
    }

    /**
     * Número de postes objeto da locação, sublocação, arrendamento, direito de passagem ou permissão de uso
     * @return Número de postes
     */
    public String getNumeroPostes() {
        return numeroDePostes;
    }

    /**
     * Define o número de postes objeto da locação, sublocação, arrendamento, direito de passagem ou permissão de uso
     * @param value Número de postes
     */
    public void setNumeroPostes(String value) {
        this.numeroDePostes = value;
    }

}
