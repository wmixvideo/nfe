package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.validadores.StringValidador;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;

/**
 *
 * Created by Eldevan Nery Junior on 07/11/17.
 *
 * Preenchido quando for  transporte de produtos classificados pela ONU como perigosos.
 *
 */
public  class MDFInfoPerigosos {

    /**
     * Número ONU/UN
     * Ver a legislação de transporte de produtos perigosos aplicadas ao modal.
     * 
     */
    @Element(name = "nONU")
    private String numeroONU;

    /**
     * 	Nome apropriado para embarque do produto
     * Ver a legislação de transporte de produtos perigosos aplicada ao modo de transporte
     */
    @Element(name = "xNomeAE", required = false)
    private String nomeEmbarque;

    /**
     * Classe ou subclasse/divisão, e risco subsidiário/risco secundário
     * Ver a legislação de transporte de produtos perigosos aplicadas ao modal
     */
    @Element(name = "xClaRisco", required = false)
    private String classeRisco;

    /**
     * 	Grupo de Embalagem
     * Ver a legislação de transporte de produtos perigosos aplicadas ao modal
     * Preenchimento obrigatório para o modal aéreo.
     * A legislação para o modal rodoviário e ferroviário não atribui grupo de embalagem para todos os produtos
     * , portanto haverá casos de não preenchimento desse campo.
     */
    @Element(name = "grEmb", required = false)
    private String grupoEmbalagem;

    /**
     * Quantidade total por produto
     * Preencher conforme a legislação de transporte de produtos perigosos aplicada ao modal
     */
    @Element(name = "qTotProd")
    private String qTotProd;

    /**
     * Quantidade e Tipo de volumes
     * Preencher conforme a legislação de transporte de produtos perigosos aplicada ao modal
     */
    @Element(name = "qVolTipo", required = false)
    private String qtdeTipoVolume;

    public String getNumeroONU() {
        return numeroONU;
    }

    public void setNumeroONU(String numeroONU) {
        if(StringUtils.isNumeric(numeroONU)){
            StringValidador.validaIntervalo()
        }else{

        }
        this.numeroONU = numeroONU;
    }

    public String getNomeEmbarque() {
        return nomeEmbarque;
    }

    public void setNomeEmbarque(String nomeEmbarque) {
        this.nomeEmbarque = nomeEmbarque;
    }

    public String getClasseRisco() {
        return classeRisco;
    }

    public void setClasseRisco(String classeRisco) {
        this.classeRisco = classeRisco;
    }

    public String getGrupoEmbalagem() {
        return grupoEmbalagem;
    }

    public void setGrupoEmbalagem(String grupoEmbalagem) {
        this.grupoEmbalagem = grupoEmbalagem;
    }

    public String getqTotProd() {
        return qTotProd;
    }

    public void setqTotProd(String qTotProd) {
        this.qTotProd = qTotProd;
    }

    public String getQtdeTipoVolume() {
        return qtdeTipoVolume;
    }

    public void setQtdeTipoVolume(String qtdeTipoVolume) {
        this.qtdeTipoVolume = qtdeTipoVolume;
    }
}