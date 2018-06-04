package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFIndicadorFormaPagamento;
import org.simpleframework.xml.transform.Transform;

/**
 * Class: NFIndicadorFormaPagamentoTransformer.
 *
 * <p>
 * Insert description here.
 * </p>
 *
 * <p>
 * History:<br><br>
 *      - walter - May 3, 2018: Criação do Arquivo<br>
 * <p>
 *
 * @author walter
 * @since 1.0
 *
 */

public class NFIndicadorFormaPagamentoTransformer implements Transform<NFIndicadorFormaPagamento> {

    @Override
    public NFIndicadorFormaPagamento read(final String codigo) {
        return NFIndicadorFormaPagamento.valueOfCodigo(codigo);
    }

    @Override
    public String write(NFIndicadorFormaPagamento indicadorFormaPagamento) {
        return indicadorFormaPagamento.getCodigo();
    }

}
