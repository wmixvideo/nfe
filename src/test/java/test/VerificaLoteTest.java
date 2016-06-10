package test;

import com.fincatto.nfe310.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.nfe310.webservices.WSFacade;

public class VerificaLoteTest {

	public static void main(String[] args) throws Exception {
		WSFacade s = new WSFacade(new Config());
		NFLoteConsultaRetorno consultaLote = s.consultaLote("214000004931118");
		System.out.println(consultaLote);
	}
}
