package com.fincatto.dfe.classes.statusservico.consulta;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFUnidadeFederativa;

public interface IStatusServicoConsultaRetorno {

    /**
     * @return a versão do layout
     */
    String getVersao();

    /**
     * @return a identificação do ambiente
     * (1 - Produção / 2 - Homologação)
     */
    DFAmbiente getAmbiente();

    /**
     * @return a versão do aplicativo que processou
     * a consulta. A versão deve ser iniciada com a
     * sigla da UF nos casos de WS próprio ou a sigla
     * SVAN ou SVRS nos demais casos.
     */
    String getVersaoAplicacao();

    /**
     * @return o código do status da resposta.
     */
    String getStatus();

    /**
     * @return a descrição literal do status da resposta.
     */
    String getMotivo();

    /**
     * @return UF que atendeu a solicitação
     */
    DFUnidadeFederativa getUf();

    /**
     * @return data e hora do processamento na SEFAZ.
     */
    String getDataRecebimentoString();

    /**
     * @return data e hora do retorno do Web Service
     */
    String getDataRetornoString();

    /**
     * @return informações adicionais para o contribuinte
     */
    String getObservacao();

    /**
     * @return tempo médio de resposta do serviço
     * (em segundos) dos últimos 5 minutos
     */
    String getTempoMedio();

}
