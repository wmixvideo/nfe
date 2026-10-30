package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfo;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoIBSCBS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoIBSCBSTIBS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoIS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoIBSCBSTot;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoISTot;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;

import java.math.BigDecimal;

/**
 * Notas completas (serializaveis) para os testes do DANFE.
 *
 * @author Marcos Lombardi de Andrade
 */
public final class DanfeFixtures {

    private DanfeFixtures() {
    }

    public static NFNotaProcessada notaProcessada() {
        final NFNotaProcessada nota = FabricaDeObjetosFake.getNFNotaProcessada();
        nota.getNota().getInfo().setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        return nota;
    }

    /** Nota com os totais da Reforma Tributaria; os valores sao distintos para identificar cada campo no texto. */
    static NFNotaInfo infoComIbsCbs(final boolean comMonofasico) {
        final NFNotaInfo info = notaProcessada().getNota().getInfo();
        final NFNotaInfoIBSCBSTot tot = new NFNotaInfoIBSCBSTot();
        tot.setVBCIBSCBS(new BigDecimal("100.00"));
        final NFNotaInfoIBSCBSTot.GIBS gibs = new NFNotaInfoIBSCBSTot.GIBS();
        final NFNotaInfoIBSCBSTot.GIBS.GIBSUF uf = new NFNotaInfoIBSCBSTot.GIBS.GIBSUF();
        uf.setVDif(BigDecimal.ZERO);
        uf.setVDevTrib(BigDecimal.ZERO);
        uf.setVIBSUF(new BigDecimal("111.11"));
        gibs.setGIBSUF(uf);
        final NFNotaInfoIBSCBSTot.GIBS.GIBSMun mun = new NFNotaInfoIBSCBSTot.GIBS.GIBSMun();
        mun.setVDif(BigDecimal.ZERO);
        mun.setVDevTrib(BigDecimal.ZERO);
        mun.setVIBSMun(new BigDecimal("222.22"));
        gibs.setGIBSMun(mun);
        gibs.setVIBS(new BigDecimal("333.33"));
        gibs.setVCredPres(BigDecimal.ZERO);
        gibs.setVCredPresCondSus(BigDecimal.ZERO);
        tot.setGIBS(gibs);
        final NFNotaInfoIBSCBSTot.GCBS cbs = new NFNotaInfoIBSCBSTot.GCBS();
        cbs.setVDif(BigDecimal.ZERO);
        cbs.setVDevTrib(BigDecimal.ZERO);
        cbs.setVCBS(new BigDecimal("444.44"));
        cbs.setVCredPres(BigDecimal.ZERO);
        cbs.setVCredPresCondSus(BigDecimal.ZERO);
        tot.setGCBS(cbs);
        if (comMonofasico) {
            final NFNotaInfoIBSCBSTot.GMono mono = new NFNotaInfoIBSCBSTot.GMono();
            mono.setVIBSMono(new BigDecimal("555.55"));
            mono.setVCBSMono(new BigDecimal("666.66"));
            mono.setVIBSMonoReten(new BigDecimal("777.77"));
            mono.setVCBSMonoReten(new BigDecimal("888.88"));
            mono.setVIBSMonoRet(BigDecimal.ZERO);
            mono.setVCBSMonoRet(BigDecimal.ZERO);
            tot.setGMono(mono);
        }
        info.getTotal().setIbscbsTot(tot);
        final NFNotaInfoISTot is = new NFNotaInfoISTot();
        is.setVIS(new BigDecimal("999.99"));
        info.getTotal().setIsTot(is);
        return info;
    }

    private static NFNotaInfoItemImpostoIBSCBSTIBS.GRed gRed(final String efetiva) {
        final NFNotaInfoItemImpostoIBSCBSTIBS.GRed gRed = new NFNotaInfoItemImpostoIBSCBSTIBS.GRed();
        gRed.setPRedAliq(new BigDecimal("1.1111"));
        gRed.setPAliqEfet(new BigDecimal(efetiva));
        return gRed;
    }

    /** Item com IBS/CBS e IS; com gRed, a aliquota efetiva (3,3333 / 2,2222 / 4,4444) difere da nominal (7,7777 / 6,6666 / 5,5555). */
    static NFNotaInfoItem itemComIbsCbs(final boolean comGRed) {
        final NFNotaInfoItem item = FabricaDeObjetosFake.getNFNotaInfoItem();
        final NFNotaInfoItemImpostoIBSCBS ibscbs = new NFNotaInfoItemImpostoIBSCBS();
        ibscbs.setCst(NFNotaInfoImpostoTributacaoIBSCBS.CST_000);
        ibscbs.setcClassTrib("123456");
        final NFNotaInfoItemImpostoIBSCBSTIBS grupo = new NFNotaInfoItemImpostoIBSCBSTIBS();
        grupo.setVBC(new BigDecimal("1000.00"));
        final NFNotaInfoItemImpostoIBSCBSTIBS.GIBSUF uf = new NFNotaInfoItemImpostoIBSCBSTIBS.GIBSUF();
        uf.setPIBSUF(new BigDecimal("7.7777"));
        uf.setVIBSUF(new BigDecimal("77.77"));
        final NFNotaInfoItemImpostoIBSCBSTIBS.GIBSMun mun = new NFNotaInfoItemImpostoIBSCBSTIBS.GIBSMun();
        mun.setPIBSMun(new BigDecimal("6.6666"));
        mun.setVIBSMun(new BigDecimal("66.66"));
        final NFNotaInfoItemImpostoIBSCBSTIBS.GCBS cbs = new NFNotaInfoItemImpostoIBSCBSTIBS.GCBS();
        cbs.setPCBS(new BigDecimal("5.5555"));
        cbs.setVCBS(new BigDecimal("55.55"));
        if (comGRed) {
            uf.setGRed(gRed("3.3333"));
            mun.setGRed(gRed("2.2222"));
            cbs.setGRed(gRed("4.4444"));
        }
        grupo.setGIBSUF(uf);
        grupo.setGIBSMun(mun);
        grupo.setGCBS(cbs);
        grupo.setVIBS(new BigDecimal("144.43"));
        ibscbs.setGIBSCBS(grupo);
        item.getImposto().setIbsCbs(ibscbs);
        final NFNotaInfoItemImpostoIS is = new NFNotaInfoItemImpostoIS();
        is.setCstIS(com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIS.TRIBUTACAO_INTEGRAL);
        is.setCClassTribIS("654321");
        is.setVBCIS(new BigDecimal("900.00"));
        is.setPIS(new BigDecimal("9.9999"));
        is.setVIS(new BigDecimal("88.88"));
        item.getImposto().setIs(is);
        return item;
    }

    public static String xml() {
        return notaProcessada().toString();
    }

    public static String xmlSemProtocolo() {
        return xml().replaceAll("(?s)<protNFe.*?</protNFe>", "");
    }
}
