package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;

// UB15
public class NFNotaInfoItemImpostoIBSCBSTIBS extends DFBase {

  private static final long serialVersionUID = -366528394939416672L;

  @Element(required = true)
  private String vBC; // UB16

  @Element(required = true)
  private GIBSUF gIBSUF; // UB17

  @Element(required = true)
  private GIBSMun gIBSMun; // UB36

  @Element(required = true)
  private GCBS gCBS; // UB55

  @Element(required = false)
  private GTribRegular gTribRegular; // UB68

  @Element(required = false)
  private GCredPres gIBSCredPres; // UB73

  @Element(required = false)
  private GCredPres gCBSCredPres; // UB78

  @Element(required = false)
  private GTribCompraGov gTribCompraGov; // UB82a

  public String getVBC() {
    return vBC;
  }

  public void setVBC(BigDecimal vBC) {
    this.vBC = DFBigDecimalValidador.tamanho15Com4CasasDecimais(vBC, "Base de cálculo do IBS e CBS");
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

  public GTribRegular getGTribRegular() {
    return gTribRegular;
  }

  public void setGTribRegular(GTribRegular gTribRegular) {
    this.gTribRegular = gTribRegular;
  }

  public GCredPres getGIBSCredPres() {
    return gIBSCredPres;
  }

  public void setGIBSCredPres(GCredPres gIBSCredPres) {
    this.gIBSCredPres = gIBSCredPres;
  }

  public GCredPres getGCBSCredPres() {
    return gCBSCredPres;
  }

  public void setGCBSCredPres(GCredPres gCBSCredPres) {
    this.gCBSCredPres = gCBSCredPres;
  }

  public GTribCompraGov getGTribCompraGov() {
    return gTribCompraGov;
  }

  public void setGTribCompraGov(GTribCompraGov gTribCompraGov) {
    this.gTribCompraGov = gTribCompraGov;
  }

  // UB17
  public class GIBSUF extends DFBase {

    @Element(required = true)
    private String pIBSUF; // UB18

    @Element(required = false)
    private GDif gDif; // UB21

    @Element(required = false)
    private GDevTrib gDevTrib; // UB24

    @Element(required = false)
    private GRed gRed; // UB26

    @Element(required = true)
    private String vIBSUF; // UB35

    public String getPIBSUF() {
      return pIBSUF;
    }

    public void setPIBSUF(BigDecimal pIBSUF) {
      this.pIBSUF = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pIBSUF, "Alíquota do IBS de competência das UF");
    }

    public GDif getGDif() {
      return gDif;
    }

    public void setGDif(GDif gDif) {
      this.gDif = gDif;
    }

    public GDevTrib getGDevTrib() {
      return gDevTrib;
    }

    public void setGDevTrib(GDevTrib gDevTrib) {
      this.gDevTrib = gDevTrib;
    }

    public GRed getGRed() {
      return gRed;
    }

    public void setGRed(GRed gRed) {
      this.gRed = gRed;
    }

    public String getVIBSUF() {
      return vIBSUF;
    }

    public void setVIBSUF(BigDecimal vIBSUF) {
      this.vIBSUF = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSUF, "Valor do IBS de competência da UF");
    }

  }

  // UB36
  public class GIBSMun extends DFBase {

    private static final long serialVersionUID = -366528394939456789L;

    @Element(required = true)
    private String pIBSMun; // UB37

    @Element(required = false)
    private GDif gDif; // UB40

    @Element(required = false)
    private GDevTrib gDevTrib; // UB43

    @Element(required = false)
    private GRed gRed; // UB45

    @Element(required = true)
    private String vIBSMun; // UB54

    public String getPIBSMun() {
      return pIBSMun;
    }

    public void setPIBSMun(BigDecimal pIBSMun) {
      this.pIBSMun = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pIBSMun, "Valor do IBS de competência do Município");
    }

    public GDif getGDif() {
      return gDif;
    }

    public void setGDif(GDif gDif) {
      this.gDif = gDif;
    }

    public GDevTrib getGDevTrib() {
      return gDevTrib;
    }

    public void setGDevTrib(GDevTrib gDevTrib) {
      this.gDevTrib = gDevTrib;
    }

    public GRed getGRed() {
      return gRed;
    }

    public void setGRed(GRed gRed) {
      this.gRed = gRed;
    }

    public String getVIBSMun() {
      return vIBSMun;
    }

    public void setVIBSMun(BigDecimal vIBSMun) {
      this.vIBSMun = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMun, "Alíquota do IBS de competência do Município");
    }

  }

  // UB55
  public class GCBS extends DFBase {

    private static final long serialVersionUID = -366528394939456790L;

    @Element(required = true)
    private String pCBS; // UB56

    @Element(required = false)
    private GDif gDif; // UB59

    @Element(required = false)
    private GDevTrib gDevTrib; // UB62

    @Element(required = false)
    private GRed gRed; // UB64

    @Element(required = true)
    private String vCBS; // UB67

    public String getPCBS() {
      return pCBS;
    }

    public void setPCBS(BigDecimal pCBS) {
      this.pCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pCBS, "Alíquota da CBS");
    }

    public GDif getGDif() {
      return gDif;
    }

    public void setGDif(GDif gDif) {
      this.gDif = gDif;
    }

    public GDevTrib getGDevTrib() {
      return gDevTrib;
    }

    public void setGDevTrib(GDevTrib gDevTrib) {
      this.gDevTrib = gDevTrib;
    }

    public GRed getGRed() {
      return gRed;
    }

    public void setGRed(GRed gRed) {
      this.gRed = gRed;
    }

    public String getVCBS() {
      return vCBS;
    }

    public void setVCBS(BigDecimal vCBS) {
      this.vCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBS, "Valor da CBS");
    }
  }

  // UB68
  public class GTribRegular extends DFBase {

    private static final long serialVersionUID = -366528394939456791L;

    @Element(name = "CSTReg", required = true)
    private NFNotaInfoImpostoTributacaoIBSCBS cstReg; // UB69

    @Element(required = true)
    private String cClassTribReg; // UB70

    @Element(required = true)
    private String pAliqEfetRegIBSUF; // UB71

    @Element(required = true)
    private String vTribRegIBSUF; // UB72

    @Element(required = true)
    private String pAliqEfetRegIBSMun; // UB72a

    @Element(required = true)
    private String vTribRegIBSMun; // UB72b

    @Element(required = true)
    private String pAliqEfetRegCBS; // UB72c

    @Element(required = true)
    private String vTribRegCBS; // UB72d

    public NFNotaInfoImpostoTributacaoIBSCBS getCstReg() {
      return cstReg;
    }

    public void setCstReg(NFNotaInfoImpostoTributacaoIBSCBS cstReg) {
      this.cstReg = cstReg;
    }

    public String getCClassTribReg() {
      return cClassTribReg;
    }

    public void setCClassTribReg(String cClassTribReg) {
      this.cClassTribReg = cClassTribReg;
    }

    public String getPAliqEfetRegIBSUF() {
      return pAliqEfetRegIBSUF;
    }

    public void setPAliqEfetRegIBSUF(BigDecimal pAliqEfetRegIBSUF) {
      this.pAliqEfetRegIBSUF = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqEfetRegIBSUF, "Valor da alíquota do IBS da UF");
    }

    public String getVTribRegIBSUF() {
      return vTribRegIBSUF;
    }

    public void setVTribRegIBSUF(BigDecimal vTribRegIBSUF) {
      this.vTribRegIBSUF = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTribRegIBSUF, "Valor do Tributo do IBS da UF");
    }

    public String getPAliqEfetRegIBSMun() {
      return pAliqEfetRegIBSMun;
    }

    public void setPAliqEfetRegIBSMun(BigDecimal pAliqEfetRegIBSMun) {
      this.pAliqEfetRegIBSMun = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqEfetRegIBSMun, "Valor da alíquota do IBS do Município");
    }

    public String getVTribRegIBSMun() {
      return vTribRegIBSMun;
    }

    public void setVTribRegIBSMun(BigDecimal vTribRegIBSMun) {
      this.vTribRegIBSMun = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTribRegIBSMun, "Valor do Tributo do IBS do Município");
    }

    public String getPAliqEfetRegCBS() {
      return pAliqEfetRegCBS;
    }

    public void setPAliqEfetRegCBS(BigDecimal pAliqEfetRegCBS) {
      this.pAliqEfetRegCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqEfetRegCBS, "Valor da alíquota da CBS");
    }

    public String getVTribRegCBS() {
      return vTribRegCBS;
    }

    public void setVTribRegCBS(BigDecimal vTribRegCBS) {
      this.vTribRegCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTribRegCBS, "Valor do Tributo da CBS");
    }

  }

  // UB73 // UB78
  public class GCredPres extends DFBase {

    private static final long serialVersionUID = -366528394939456792L;

    @Element(required = true)
    private String cCredPres; // UB74 // UB79

    @Element(required = true)
    private String pCredPres; // UB75 // UB80

    @Element(required = true)
    private String vCredPres; // UB76 // UB81

    @Element(required = true)
    private String vCredPresCondSus; // UB77 // UB82

    public String getcCredPres() {
      return cCredPres;
    }

    public void setcCredPres(String cCredPres) {
      this.cCredPres = cCredPres;
    }

    public String getPCredPres() {
      return pCredPres;
    }

    public void setPCredPres(BigDecimal pCredPres) {
      this.pCredPres = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pCredPres, "Percentual do Crédito Presumido");
    }

    public String getVCredPres() {
      return vCredPres;
    }

    public void setVCredPres(BigDecimal vCredPres) {
      this.vCredPres = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCredPres, "Valor do Crédito Presumido");
    }

    public String getVCredPresCondSus() {
      return vCredPresCondSus;
    }

    public void setVCredPresCondSus(BigDecimal vCredPresCondSus) {
      this.vCredPresCondSus = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCredPresCondSus, "Valor do Crédito Presumido em condição suspensiva");
    }

  }

  // UB82a
  public class GTribCompraGov extends DFBase {

    private static final long serialVersionUID = -366528394939456794L;

    @Element(required = true)
    private String pIBSUF; // UB82b

    @Element(required = true)
    private String vIBSUF; // UB82c

    @Element(required = true)
    private String pIBSMun; // UB82d

    @Element(required = true)
    private String vIBSMun; // UB82e

    @Element(required = true)
    private String pCBS; // UB82f

    @Element(required = true)
    private String vCBS; // UB82g

    public String getPIBSUF() {
      return pIBSUF;
    }

    public void setPIBSUF(BigDecimal pIBSUF) {
      this.pIBSUF = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pIBSUF, "Alíquota do IBS de competência do Estado");
    }

    public String getVIBSUF() {
      return vIBSUF;
    }

    public void setVIBSUF(BigDecimal vIBSUF) {
      this.vIBSUF = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSUF, "Valor do Tributo do IBS da UF calculado");
    }

    public String getPIBSMun() {
      return pIBSMun;
    }

    public void setPIBSMun(BigDecimal pIBSMun) {
      this.pIBSMun = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pIBSMun, "Alíquota do IBS de competência do Município");
    }

    public String getVIBSMun() {
      return vIBSMun;
    }

    public void setVIBSMun(BigDecimal vIBSMun) {
      this.vIBSMun = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMun, "Valor do Tributo do IBS do Município calculado");
    }

    public String getPCBS() {
      return pCBS;
    }

    public void setPCBS(BigDecimal pCBS) {
      this.pCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pCBS, "Alíquota da CBS ");
    }

    public String getVCBS() {
      return vCBS;
    }

    public void setVCBS(BigDecimal vCBS) {
      this.vCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBS, "Valor do Tributo da CBS calculado");
    }

  }

// UB21 // UB40
  public class GDif extends DFBase {

    private static final long serialVersionUID = -366528394939455687L;

    @Element(required = true)
    private String pDif; // UB22 // UB41

    @Element(required = true)
    private String vDif; // UB23 // UB42

    public String getPDif() {
      return pDif;
    }

    public void setPDif(BigDecimal pDif) {
      this.pDif = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pDif, "Percentual do diferimento");
    }

    public String getVDif() {
      return vDif;
    }

    public void setVDif(BigDecimal vDif) {
      this.vDif = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDif, "Valor do Diferimento");
    }

  }

// UB24 // UB43
  public class GDevTrib extends DFBase {

    private static final long serialVersionUID = -366525684939456789L;

    @Element(required = true)
    private String vDevTrib; // UB25 // UB44

    public String getVDevTrib() {
      return vDevTrib;
    }

    public void setVDevTrib(BigDecimal vDevTrib) {
      this.vDevTrib = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDevTrib, "Valor do tributo devolvido");
    }

  }

// UB26 // UB45
  public class GRed extends DFBase {

    private static final long serialVersionUID = -366528394939258789L;

    @Element(required = true)
    private String pRedAliq; // UB27 // UB46

    @Element(required = true)
    private String pAliqEfet; // UB28 // UB47

    public String getPRedAliq() {
      return pRedAliq;
    }

    public void setPRedAliq(BigDecimal pRedAliq) {
      this.pRedAliq = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pRedAliq, "Percentual da redução de alíquota do cClassTrib");
    }

    public String getPAliqEfet() {
      return pAliqEfet;
    }

    public void setPAliqEfet(BigDecimal pAliqEfet) {
      this.pAliqEfet = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqEfet, "Alíquota Efetiva do IBS de competência das UF que será aplicada a Base de Cálculo");
    }

  }
}
