package com.fincatto.cte200.classes;

import java.util.Arrays;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public enum CTAutorizador {

	MT {
		@Override
		public String getCteStatusServico(final DFAmbiente ambiente) {
			return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews/services/CteStatusServico" : "https://cte.sefaz.mt.gov.br/ctews/services/CteStatusServico";
		}

                @Override
                public String efetuaConsultaStatus(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
                    return new CTStatusServico().efetuaConsultaStatusMT(ambiente, xml, unidadeFederativa, modelo);
                }

		@Override
		public DFUnidadeFederativa[] getUFs() {
			return new DFUnidadeFederativa[] { DFUnidadeFederativa.MT };
		}
	},
	MS {
		@Override
		public String getCteStatusServico(final DFAmbiente ambiente) {
			return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CteStatusServico" : "https://producao.cte.ms.gov.br/ws/CteStatusServico";
		}

                @Override
                public String efetuaConsultaStatus(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
                    return new CTStatusServico().efetuaConsultaStatusSVRS(ambiente, xml, unidadeFederativa, modelo);
                }

		@Override
		public DFUnidadeFederativa[] getUFs() {
			return new DFUnidadeFederativa[] { DFUnidadeFederativa.MS };
		}
	},
	MG {
		@Override
		public String getCteStatusServico(final DFAmbiente ambiente) {
			return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CteStatusServico" : "https://cte.fazenda.mg.gov.br/cte/services/CteStatusServico";
		}

                @Override
                public String efetuaConsultaStatus(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
                    return new CTStatusServico().efetuaConsultaStatusSVRS(ambiente, xml, unidadeFederativa, modelo);
                }

		@Override
		public DFUnidadeFederativa[] getUFs() {
			return new DFUnidadeFederativa[] { DFUnidadeFederativa.MG };
		}
	},
	PR {
		@Override
		public String getCteStatusServico(final DFAmbiente ambiente) {
			return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte/CteStatusServico?wsdl" : "https://cte.fazenda.pr.gov.br/cte/CteStatusServico?wsdl";
		}

                @Override
                public String efetuaConsultaStatus(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
                    return new CTStatusServico().efetuaConsultaStatusPR(ambiente, xml, unidadeFederativa, modelo);
                }

		@Override
		public DFUnidadeFederativa[] getUFs() {
			return new DFUnidadeFederativa[] { DFUnidadeFederativa.PR };
		}
	},
	RS {
		@Override
		public String getCteStatusServico(final DFAmbiente ambiente) {
			return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx" : "https://cte.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx";
		}

                @Override
                public String efetuaConsultaStatus(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
                    return new CTStatusServico().efetuaConsultaStatusSVRS(ambiente, xml, unidadeFederativa, modelo);
                }

		@Override
		public DFUnidadeFederativa[] getUFs() {
			return new DFUnidadeFederativa[] { DFUnidadeFederativa.RS };
		}
	},
	SP {
		@Override
		public String getCteStatusServico(final DFAmbiente ambiente) {
			return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteStatusServico.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteStatusServico.asmx";
		}

                @Override
                public String efetuaConsultaStatus(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
                    return new CTStatusServico().efetuaConsultaStatusSVRS(ambiente, xml, unidadeFederativa, modelo);
                }

		@Override
		public DFUnidadeFederativa[] getUFs() {
			return new DFUnidadeFederativa[] { DFUnidadeFederativa.SP };
		}
	},
	SVRS {
		@Override
		public String getCteStatusServico(final DFAmbiente ambiente) {
			return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx" : "https://cte.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx";
		}

                @Override
                public String efetuaConsultaStatus(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
                    return new CTStatusServico().efetuaConsultaStatusSVRS(ambiente, xml, unidadeFederativa, modelo);
                }

		@Override
		public DFUnidadeFederativa[] getUFs() {
			return new DFUnidadeFederativa[] { DFUnidadeFederativa.AC, DFUnidadeFederativa.AL, DFUnidadeFederativa.AM, DFUnidadeFederativa.BA, DFUnidadeFederativa.CE, DFUnidadeFederativa.DF, DFUnidadeFederativa.ES, DFUnidadeFederativa.GO, DFUnidadeFederativa.MA, DFUnidadeFederativa.PA, DFUnidadeFederativa.PB, DFUnidadeFederativa.PI, DFUnidadeFederativa.RJ, DFUnidadeFederativa.RN, DFUnidadeFederativa.RO, DFUnidadeFederativa.SC, DFUnidadeFederativa.SE, DFUnidadeFederativa.TO };
		}
	},
	SVSP {
		@Override
		public String getCteStatusServico(final DFAmbiente ambiente) {
			return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CteStatusServico.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/CteStatusServico.asmx";
		}

                @Override
                public String efetuaConsultaStatus(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
                    return new CTStatusServico().efetuaConsultaStatusSVRS(ambiente, xml, unidadeFederativa, modelo);
                }

		@Override
		public DFUnidadeFederativa[] getUFs() {
                    return new DFUnidadeFederativa[] { DFUnidadeFederativa.AP, DFUnidadeFederativa.PE, DFUnidadeFederativa.RR };
		}
	};

	public static String getCteRecepcao(final DFAmbiente ambiente) {
		throw new UnsupportedOperationException("Ainda não implementado serviço para recepção de CT-e");
	}

	public static String getCteRetRecepcao(final DFAmbiente ambiente) {
		throw new UnsupportedOperationException("Ainda não implementado serviço para retorno de recepção de CT-e");
	}

	public static String getCteCancelamento(final DFAmbiente ambiente) {
		throw new UnsupportedOperationException("Ainda não implementado serviço para cancelamento de CT-e");
	}

	public static String getCteInutilizacao(final DFAmbiente ambiente) {
		throw new UnsupportedOperationException("Ainda não implementado serviço para inutilização de CT-e");
	}

	public static String getCteConsultaProtocolo(DFAmbiente ambiente) {
		throw new UnsupportedOperationException("Ainda não implementado serviço para consultar protocolo de CT-e");
	}

	public abstract String getCteStatusServico(final DFAmbiente ambiente);

	public static String getCteConsultaCadastro(final DFAmbiente ambiente) {
		throw new UnsupportedOperationException("Ainda não implementado serviço para consulta cadastro de CT-e");
	}

	public static String getRecepcaoEvento(final DFAmbiente ambiente) {
		throw new UnsupportedOperationException("Ainda não implementado serviço para recepção de evento de CT-e");
	}

	public static String getCteDownloadCT(final DFAmbiente ambiente) {
		throw new UnsupportedOperationException("Ainda não implementado serviço para download de CT-e");
	}

	public abstract DFUnidadeFederativa[] getUFs();

        public abstract String efetuaConsultaStatus(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException;

	public static CTAutorizador valueOfCodigoUF(final DFUnidadeFederativa uf) {
		for (final CTAutorizador aut : CTAutorizador.values()) {
			if (Arrays.asList(aut.getUFs()).contains(uf)) {
				return aut;
			}
		}
		throw new IllegalStateException(String.format("N\u00e3o existe autorizador para a UF %s", uf.getCodigo()));
	}
}