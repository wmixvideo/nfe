package com.fincatto.nfe200.classes;

import java.util.Arrays;

public enum NFAutorizador {
	
	AM {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta2" : "https://nfe.sefaz.am.gov.br/services2/services/NfeConsulta2";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeStatusServico2" : "https://nfe.sefaz.am.gov.br/services2/services/NfeStatusServico2";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.AM };
		}
	},
	BA {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/nfenw/NfeConsulta2.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/nfenw/NfeConsulta2.asmx";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/nfenw/NfeStatusServico2.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/nfenw/NfeStatusServico2.asmx";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.BA };
		}
	},
	CE {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeConsulta2" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeConsulta2";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.CE };
		}
	},
	GO {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.GO };
		}
	},
	MG {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeStatusServico2" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeStatusServico2";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.MG };
		}
	},
	MS {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeConsulta2" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeConsulta2";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeStatusServico2" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeStatusServico2";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.MS };
		}
	},
	MT {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.MT };
		}
	},
	PE {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.PE };
		}
	},
	PR {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe2.fazenda.pr.gov.br/nfe/NFeConsulta2?wsdl" : "https://nfe2.fazenda.pr.gov.br/nfe/NFeConsulta2?wsdl";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe2.fazenda.pr.gov.br/nfe/NFeStatusServico2?wsdl" : "https://nfe2.fazenda.pr.gov.br/nfe/NFeStatusServico2?wsdl";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.PR };
		}
	},
	RS {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfe.sefaz.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfe.sefaz.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.RS };
		}
	},
	SP {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeConsulta2.asmx" : "https://nfe.fazenda.sp.gov.br/nfeweb/services/nfeconsulta2.asmx";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeStatusServico2.asmx" : "https://nfe.fazenda.sp.gov.br/nfeweb/services/nfestatusservico2.asmx";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.SP };
		}
	},
	SVAN {
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx";
		}
		
		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.ES, NFUnidadeFederativa.MA, NFUnidadeFederativa.PA, NFUnidadeFederativa.PI, NFUnidadeFederativa.RN };
		}
	},
	SVRS {
		@Override
		public String getNfeRecepcao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/Nferecepcao/NFeRecepcao2.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/Nferecepcao/NFeRecepcao2.asmx";
		}
		
		@Override
		public String getNfeRetRecepcao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeRetRecepcao/NfeRetRecepcao2.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeRetRecepcao/NfeRetRecepcao2.asmx";
		}
		
		@Override
		public String getNfeCancelamento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeCancelamento/NfeCancelamento2.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeCancelamento/NfeCancelamento2.asmx";
		}
		
		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
		}
		
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
		}
		
		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.AC, NFUnidadeFederativa.AL, NFUnidadeFederativa.AM, NFUnidadeFederativa.AP, NFUnidadeFederativa.DF, NFUnidadeFederativa.MS, NFUnidadeFederativa.PB, NFUnidadeFederativa.RJ, NFUnidadeFederativa.RO, NFUnidadeFederativa.RR, NFUnidadeFederativa.SC, NFUnidadeFederativa.SE, NFUnidadeFederativa.TO };
		}
	},
	SCAN {
		@Override
		public String getNfeRecepcao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/SCAN/NfeRecepcao2/NfeRecepcao2.asmx" : "https://www.scan.fazenda.gov.br/NfeRecepcao2/NfeRecepcao2.asmx";
		}
		
		@Override
		public String getNfeRetRecepcao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/SCAN/NfeRetRecepcao2/NfeRetRecepcao2.asmx" : "https://www.scan.fazenda.gov.br/NfeRetRecepcao2/NfeRetRecepcao2.asmx";
		}
		
		@Override
		public String getNfeCancelamento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/SCAN/NfeCancelamento2/NfeCancelamento2.asmx" : "https://www.scan.fazenda.gov.br/NfeCancelamento2/NfeCancelamento2.asmx";
		}
		
		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/SCAN/NfeInutilizacao2/NfeInutilizacao2.asmx" : "https://www.scan.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx";
		}
		
		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/SCAN/NfeConsulta2/NfeConsulta2.asmx" : "https://www.scan.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx";
		}
		
		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/SCAN/NfeStatusServico2/NfeStatusServico2.asmx" : "https://www.scan.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx";
		}
		
		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/SCAN/RecepcaoEvento/RecepcaoEvento.asmx" : "https://www.scan.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx";
		}
		
		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] {};
		}
	};
	
	public String getNfeRecepcao(final NFAmbiente ambiente) {
		throw new UnsupportedOperationException();
	}
	
	public String getNfeRetRecepcao(final NFAmbiente ambiente) {
		throw new UnsupportedOperationException();
	}
	
	public String getNfeCancelamento(final NFAmbiente ambiente) {
		throw new UnsupportedOperationException();
	}
	
	public String getNfeInutilizacao(final NFAmbiente ambiente) {
		throw new UnsupportedOperationException();
	}
	
	public abstract String getNfeConsultaProtocolo(NFAmbiente ambiente);
	
	public abstract String getNfeStatusServico(final NFAmbiente ambiente);
	
	public String getNfeConsultaCadastro(final NFAmbiente ambiente) {
		throw new UnsupportedOperationException();
	}
	
	public String getRecepcaoEvento(final NFAmbiente ambiente) {
		throw new UnsupportedOperationException();
	}
	
	public String getNfeDownloadNF(final NFAmbiente ambiente) {
		throw new UnsupportedOperationException();
	}
	
	public abstract NFUnidadeFederativa[] getUFs();
	
	public static NFAutorizador valueOfCodigoUF(final NFUnidadeFederativa uf) {
		if (uf != null) {
			for (final NFAutorizador aut : NFAutorizador.values()) {
				if (Arrays.asList(aut.getUFs()).contains(uf)) {
					return aut;
				}
			}
		}
		return null;
	}
	
	public static NFAutorizador valueOfChaveAcesso(final String chaveAcesso) {
		final NFChaveInterpretador chaveInterpretador = new NFChaveInterpretador(chaveAcesso);
		if (chaveInterpretador.isEmitidaContingenciaSCAN()) {
			return NFAutorizador.SCAN;
		}
		return NFAutorizador.valueOfCodigoUF(chaveInterpretador.getUnidadeFederativa());
	}
}
