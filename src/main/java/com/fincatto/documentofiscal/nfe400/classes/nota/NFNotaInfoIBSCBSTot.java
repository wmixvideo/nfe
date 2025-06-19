package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;

/**
 * W34
 *
 * @author Edivaldo Merlo Stens
 */
public class NFNotaInfoIBSCBSTot extends DFBase {

  private static final long serialVersionUID = 1644701343314751237L;

  @Element(name = "vBCIBSCBS")
  private String vBCIBSCBS; // W35

  @Element(name = "gIBS")
  private NFNotaInfoIBSCBSTot.GIBS gIBS; // W36

  @Element(name = "gCBS")
  private NFNotaInfoIBSCBSTot.GCBS gCBS; // W50

  @Element(name = "gMono")
  private NFNotaInfoIBSCBSTot.GMono gMono; // W57

  public String getVBCIBSCBS() {
    return vBCIBSCBS;
  }

  public void setVBCIBSCBS(BigDecimal vBCIBSCBS) {
    this.vBCIBSCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vBCIBSCBS, "Valor total da BC do IBS e da CBS");;
  }

  public NFNotaInfoIBSCBSTot.GIBS getGIBS() {
    return gIBS;
  }

  public void setGIBS(NFNotaInfoIBSCBSTot.GIBS gIBS) {
    this.gIBS = gIBS;
  }

  public NFNotaInfoIBSCBSTot.GCBS getGCBS() {
    return gCBS;
  }

  public void setGCBS(NFNotaInfoIBSCBSTot.GCBS gCBS) {
    this.gCBS = gCBS;
  }

  public NFNotaInfoIBSCBSTot.GMono getGMono() {
    return gMono;
  }

  public void setGMono(NFNotaInfoIBSCBSTot.GMono gMono) {
    this.gMono = gMono;
  }

  // W36
  public class GIBS extends DFBase {

    private static final long serialVersionUID = 6387739393518311458L;

    @Element(name = "gIBSUF", required = true)
    private GIBS.GIBSUF gIBSUF; // W37

    @Element(name = "gIBSMun", required = true)
    private GIBS.GIBSMun gIBSMun; // W42

    @Element(name = "vIBS", required = true)
    private String vIBS; // W47

    @Element(name = "vCredPres", required = true)
    private String vCredPres; // W48

    @Element(name = "vCredPresCondSus", required = true)
    private String vCredPresCondSus; // W49

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

    public String getVIBS() {
      return vIBS;
    }

    public void setVIBS(BigDecimal vIBS) {
      this.vIBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBS, "Valor total do IBS");
    }

    public String getVCredPres() {
      return vCredPres;
    }

    public void setVCredPres(BigDecimal vCredPres) {
      this.vCredPres = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCredPres, "Valor total do crédito presumido");
    }

    public String getVCredPresCondSus() {
      return vCredPresCondSus;
    }

    public void setVCredPresCondSus(BigDecimal vCredPresCondSus) {
      this.vCredPresCondSus = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCredPresCondSus, "Valor total do crédito presumido em condição suspensiva");
    }

    // W37
    public class GIBSUF extends DFBase {

      @Element(name = "vDif", required = true)
      private String vDif; // W38

      @Element(name = "vDevTrib", required = true)
      private String vDevTrib; // W39

      @Element(name = "vIBSUF", required = true)
      private String vIBSUF; // W41

      public String getVDif() {
        return vDif;
      }

      public void setVDif(BigDecimal vDif) {
        this.vDif = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDif, "Valor total do diferimento");
      }

      public String getVDevTrib() {
        return vDevTrib;
      }

      public void setVDevTrib(BigDecimal vDevTrib) {
        this.vDevTrib = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDevTrib, "Valor total de devolução de tributos");
      }

      public String getVIBSUF() {
        return vIBSUF;
      }

      public void setVIBSUF(BigDecimal vIBSUF) {
        this.vIBSUF = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSUF, "Valor total do IBS da UF");;
      }

    }

    // W42
    public class GIBSMun extends DFBase {

      @Element(required = true)
      private String vDif; // W43

      @Element(required = true)
      private String vDevTrib; // W44

      @Element(required = true)
      private String vIBSMun; // W46

      public String getVDif() {
        return vDif;
      }

      public void setVDif(BigDecimal vDif) {
        this.vDif = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDif, "Valor total do diferimento");
      }

      public String getVDevTrib() {
        return vDevTrib;
      }

      public void setVDevTrib(BigDecimal vDevTrib) {
        this.vDevTrib = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDevTrib, "Valor total de devolução de tributos");
      }

      public String getVIBSMun() {
        return vIBSMun;
      }

      public void setVIBSMun(BigDecimal vIBSMun) {
        this.vIBSMun = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMun, "Valor total do IBS do Município");
      }

    }

  }

  // W50
  public class GCBS extends DFBase {

    @Element(required = true)
    private String vDif; // W53

    @Element(required = true)
    private String vDevTrib; // W54

    @Element(required = true)
    private String vCBS; // W56

    @Element(required = true)
    private String vCredPres; // W56a

    @Element(required = true)
    private String vCredPresCondSus; // W56b

    public String getVDif() {
      return vDif;
    }

    public void setVDif(BigDecimal vDif) {
      this.vDif = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDif, "Valor total do diferimento");
    }

    public String getVDevTrib() {
      return vDevTrib;
    }

    public void setVDevTrib(BigDecimal vDevTrib) {
      this.vDevTrib = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDevTrib, "Valor total de devolução de tributos");
    }

    public String getVCBS() {
      return vCBS;
    }

    public void setVCBS(BigDecimal vCBS) {
      this.vCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBS, "Valor total da CBS");
    }

    public String getVCredPres() {
      return vCredPres;
    }

    public void setVCredPres(BigDecimal vCredPres) {
      this.vCredPres = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCredPres, "Valor total do crédito presumido");
    }

    public String getVCredPresCondSus() {
      return vCredPresCondSus;
    }

    public void setVCredPresCondSus(BigDecimal vCredPresCondSus) {
      this.vCredPresCondSus = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCredPresCondSus, "Valor total do crédito presumido em condição suspensiva");
    }

  }

  // W57
  public class GMono extends DFBase {

    @Element(required = true)
    private String vIBSMono; // W58

    @Element(required = true)
    private String vCBSMono; // W59

    @Element(required = true)
    private String vIBSMonoReten; // W59a

    @Element(required = true)
    private String vCBSMonoReten; // W59b

    @Element(required = true)
    private String vIBSMonoRet; // W59c

    @Element(required = true)
    private String vCBSMonoRet; // W59d

    public String getVIBSMono() {
      return vIBSMono;
    }

    public void setVIBSMono(BigDecimal vIBSMono) {
      this.vIBSMono = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMono, "Valor do IBS monofásico");
    }

    public String getVCBSMono() {
      return vCBSMono;
    }

    public void setVCBSMono(BigDecimal vCBSMono) {
      this.vCBSMono = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBSMono, "Valor da CBS monofásica");
    }

    public String getVIBSMonoReten() {
      return vIBSMonoReten;
    }

    public void setVIBSMonoReten(BigDecimal vIBSMonoReten) {
      this.vIBSMonoReten = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMonoReten, "Total do IBS monofásico sujeito a retenção");
    }

    public String getVCBSMonoReten() {
      return vCBSMonoReten;
    }

    public void setVCBSMonoReten(BigDecimal vCBSMonoReten) {
      this.vCBSMonoReten = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBSMonoReten, "Total da CBS monofásica sujeita a retenção");
    }

    public String getVIBSMonoRet() {
      return vIBSMonoRet;
    }

    public void setVIBSMonoRet(BigDecimal vIBSMonoRet) {
      this.vIBSMonoRet = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMonoRet, "Total do IBS monofásico retido anteriormente");
    }

    public String getVCBSMonoRet() {
      return vCBSMonoRet;
    }

    public void setVCBSMonoRet(BigDecimal vCBSMonoRet) {
      this.vCBSMonoRet = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBSMonoRet, "Total da CBS monofásica retida anteriormente");
    }

  }
}
