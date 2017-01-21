package com.fincatto.cte200;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.fincatto.cte200.classes.statusservico.consulta.CTStatusServicoConsulta;
import com.fincatto.cte200.classes.statusservico.consulta.CTStatusServicoConsultaRetorno;
import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFUnidadeFederativa;

public class FabricaDeObjetosFakeCTe {

	public static CTStatusServicoConsulta getCTStatusServicoConsulta() {
		final CTStatusServicoConsulta consulta = new CTStatusServicoConsulta();
		consulta.setVersao("2.00");
		consulta.setAmbiente(DFAmbiente.PRODUCAO);
		consulta.setServico("STATUS");
		return consulta;
	}

	public static CTStatusServicoConsultaRetorno getCTStatusServicoConsultaRetorno() throws ParseException {
		final CTStatusServicoConsultaRetorno consultaRetorno = new CTStatusServicoConsultaRetorno();
		consultaRetorno.setVersao("2.00");
		consultaRetorno.setAmbiente(DFAmbiente.PRODUCAO);
		consultaRetorno.setVersaoAplicacao("1.01");
		consultaRetorno.setStatus("107");
		consultaRetorno.setMotivo("Servico em Operacao");
		consultaRetorno.setUf(DFUnidadeFederativa.GO);
		consultaRetorno.setDataRecebimento(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse("2017-01-05T19:19:09"));
		consultaRetorno.setTempoMedio("10");
		consultaRetorno.setDataRetorno(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse("2017-01-05T19:19:09"));
		consultaRetorno.setObservacao("Teste");
		return consultaRetorno;
	}
}