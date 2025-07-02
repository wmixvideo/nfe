package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Implementação Nota Técnica 2025.001 – Reforma Tributária do Consumo, Versão
 * 1.05 de 06 de junho de 2025
 *
 * 15/06/2025
 *
 * @author Edivaldo Merlo Stens
 */
@Root(name = "IBSCBS")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoInformacoesRelativasImpostosIBSCBS extends DFBase {

  private static final long serialVersionUID = -3330020091021955690L;

  @Element(name = "CST", required = true)
  private String cst;

  @Element(name = "cClassTrib", required = true)
  private String cClassTrib;

  @Element(name = "gIBSCBS", required = false)
  private TCIBS gIBSCBS;

  public String getCST() {
    return cst;
  }

  public void setCST(String cst) {
    this.cst = cst;
  }

  public String getCClassTrib() {
    return cClassTrib;
  }

  public void setCClassTrib(String cClassTrib) {
    this.cClassTrib = cClassTrib;
  }

  public TCIBS getGIBSCBS() {
    return gIBSCBS;
  }

  public void setGIBSCBS(TCIBS gIBSCBS) {
    this.gIBSCBS = gIBSCBS;
  }

  @Root(name = "gIBSCBS")
  @Namespace(reference = CTeConfig.NAMESPACE)
  public class TCIBS extends DFBase {

    private static final long serialVersionUID = 6387739393518311269L;

    @Element(name = "vBC", required = true)
    private String vBC;

    @Element(name = "gIBSUF", required = true)
    private TCIBS.GIBSUF gIBSUF;

    @Element(name = "gIBSMun", required = true)
    private TCIBS.GIBSMun gIBSMun;

    @Element(name = "gCBS", required = true)
    private TCIBS.GCBS gCBS;

    @Element()
    private CTeTTribRegular gTribRegular;

    @Element(name = "gIBSCredPres")
    private CTeTCredPres gIBSCredPres;

    @Element(name = "gCBSCredPres")
    private CTeTCredPres gCBSCredPres;

    @Element()
    private CTeTTribCompraGov gTribCompraGov;

    public String getVBC() {
      return vBC;
    }

    public void setVBC(BigDecimal vBC) {
      this.vBC = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vBC, "Valor da Base de cálculo comum a IBS/CBS");
    }

    public GIBSUF getGIBSUF() {
      return gIBSUF;
    }

    public void setGIBSUF(GIBSUF gIBSUF) {
      this.gIBSUF = gIBSUF;
    }

    public GIBSMun getGIBSMun() {
      return gIBSMun;
    }

    public void setGIBSMun(GIBSMun gIBSMun) {
      this.gIBSMun = gIBSMun;
    }

    public GCBS getGCBS() {
      return gCBS;
    }

    public void setGCBS(GCBS gCBS) {
      this.gCBS = gCBS;
    }

    public CTeTTribRegular getGTribRegular() {
      return gTribRegular;
    }

    public void setGTribRegular(CTeTTribRegular gTribRegular) {
      this.gTribRegular = gTribRegular;
    }

    public CTeTCredPres getGIBSCredPres() {
      return gIBSCredPres;
    }

    public void setGIBSCredPres(CTeTCredPres gIBSCredPres) {
      this.gIBSCredPres = gIBSCredPres;
    }

    public CTeTCredPres getGCBSCredPres() {
      return gCBSCredPres;
    }

    public void setGCBSCredPres(CTeTCredPres gCBSCredPres) {
      this.gCBSCredPres = gCBSCredPres;
    }

    public CTeTTribCompraGov getGTribCompraGov() {
      return gTribCompraGov;
    }

    public void setGTribCompraGov(CTeTTribCompraGov gTribCompraGov) {
      this.gTribCompraGov = gTribCompraGov;
    }

    @Root(name = "gIBSUF")
    @Namespace(reference = CTeConfig.NAMESPACE)
    public class GIBSUF extends DFBase {

      @Element(name = "pIBSUF", required = true)
      private String pIBSUF;

      @Element()
      private CTeTDifIBS gDif;

      @Element()
      private CTeTDevTrib gDevTrib;

      @Element()
      private CTeTRed gRed;

      @Element(name = "vIBSUF", required = true)
      private String vIBSUF;

      public String getPIBSUF() {
        return pIBSUF;
      }

      public void setPIBSUF(BigDecimal pIBSUF) {
        this.pIBSUF = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pIBSUF, "Alíquota do IBS Estadual ");
      }

      public CTeTDifIBS getGDif() {
        return gDif;
      }

      public void setGDif(CTeTDifIBS gDif) {
        this.gDif = gDif;
      }

      public CTeTDevTrib getGDevTrib() {
        return gDevTrib;
      }

      public void setGDevTrib(CTeTDevTrib gDevTrib) {
        this.gDevTrib = gDevTrib;
      }

      public CTeTRed getGRed() {
        return gRed;
      }

      public void setGRed(CTeTRed gRed) {
        this.gRed = gRed;
      }

      public String getVIBSUF() {
        return vIBSUF;
      }

      public void setVIBSUF(BigDecimal vIBSUF) {
        this.vIBSUF = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSUF, "Valor do IBS de competência da UF ");
      }

    }

    @Root(name = "gIBSMun")
    @Namespace(reference = CTeConfig.NAMESPACE)
    public class GIBSMun extends DFBase {

      @Element(name = "pIBSMun", required = true)
      private String pIBSMun;

      @Element()
      private CTeTDifIBS gDif;

      @Element()
      private CTeTDevTrib gDevTrib;

      @Element()
      private CTeTRed gRed;

      @Element(name = "vIBSMun", required = true)
      private String vIBSMun;

      public String getPIBSMun() {
        return pIBSMun;
      }

      public void setPIBSMun(BigDecimal pIBSMun) {
        this.pIBSMun = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pIBSMun, "Alíquota do IBS Municipal");
      }

      public CTeTDifIBS getGDif() {
        return gDif;
      }

      public void setGDif(CTeTDifIBS gDif) {
        this.gDif = gDif;
      }

      public CTeTDevTrib getGDevTrib() {
        return gDevTrib;
      }

      public void setGDevTrib(CTeTDevTrib gDevTrib) {
        this.gDevTrib = gDevTrib;
      }

      public CTeTRed getGRed() {
        return gRed;
      }

      public void setGRed(CTeTRed gRed) {
        this.gRed = gRed;
      }

      public String getVIBSMun() {
        return vIBSMun;
      }

      public void setVIBSMun(BigDecimal vIBSMun) {
        this.vIBSMun = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMun, "Valor do IBS de competência do município");
      }

    }

    @Root(name = "gCBS")
    @Namespace(reference = CTeConfig.NAMESPACE)
    public class GCBS extends DFBase {

      @Element(name = "pCBS", required = true)
      private String pCBS;

      @Element()
      private CTeTDifCBS gDif;

      @Element()
      private CTeTDevTrib gDevTrib;

      @Element()
      private CTeTRed gRed;

      @Element(name = "vCBS", required = true)
      private String vCBS;

      public String getPCBS() {
        return pCBS;
      }

      public void setPCBS(BigDecimal pCBS) {
        this.pCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pCBS, "Alíquota da CBS");
      }

      public CTeTDifCBS getGDif() {
        return gDif;
      }

      public void setGDif(CTeTDifCBS gDif) {
        this.gDif = gDif;
      }

      public CTeTDevTrib getGDevTrib() {
        return gDevTrib;
      }

      public void setGDevTrib(CTeTDevTrib gDevTrib) {
        this.gDevTrib = gDevTrib;
      }

      public CTeTRed getGRed() {
        return gRed;
      }

      public void setGRed(CTeTRed gRed) {
        this.gRed = gRed;
      }

      public String getVCBS() {
        return vCBS;
      }

      public void setVCBS(BigDecimal vCBS) {
        this.vCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBS, "Valor da CBS");
      }
    }
  }
}
