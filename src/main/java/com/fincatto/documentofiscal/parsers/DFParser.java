package com.fincatto.documentofiscal.parsers;

import com.fincatto.documentofiscal.cte300.classes.nota.CTeProcessado;
import org.simpleframework.xml.core.Persister;

import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLote;
import com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento.NFEnviaEventoCancelamento;
import com.fincatto.documentofiscal.nfe310.classes.evento.cartacorrecao.NFEnviaEventoCartaCorrecao;
import com.fincatto.documentofiscal.nfe310.classes.evento.inutilizacao.NFEnviaEventoInutilizacao;
import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteEnvio;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoItem;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaProcessada;
import com.fincatto.documentofiscal.persister.DFPersister;

import java.io.File;

public class DFParser {

    private final Persister persister;

    public DFParser() {
        this.persister = new DFPersister();
    }

    // NFe/NFCe
    public NFNota notaParaObjeto(final File xml) {
        try {
            return this.persister.read(NFNota.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFNota notaParaObjeto(final String xml) {
        try {
            return this.persister.read(NFNota.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFLoteEnvio loteParaObjeto(final File xml) {
        try {
            return this.persister.read(NFLoteEnvio.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFLoteEnvio loteParaObjeto(final String xml) {
        try {
            return this.persister.read(NFLoteEnvio.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFNotaProcessada notaProcessadaParaObjeto(final String xml) {
        try {
            return this.persister.read(NFNotaProcessada.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFNotaProcessada notaProcessadaParaObjeto(final File xml) {
        try {
            return this.persister.read(NFNotaProcessada.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFEnviaEventoCartaCorrecao enviaEventoCartaCorrecaoParaObjeto(final File xml) {
        try {
            return this.persister.read(NFEnviaEventoCartaCorrecao.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFEnviaEventoCartaCorrecao enviaEventoCartaCorrecaoParaObjeto(final String xml) {
        try {
            return this.persister.read(NFEnviaEventoCartaCorrecao.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFEnviaEventoCancelamento enviaEventoCancelamentoParaObjeto(final File xml) {
        try {
            return this.persister.read(NFEnviaEventoCancelamento.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFEnviaEventoCancelamento enviaEventoCancelamentoParaObjeto(final String xml) {
        try {
            return this.persister.read(NFEnviaEventoCancelamento.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFEnviaEventoInutilizacao enviaEventoInutilizacaoParaObjeto(final File xml) {
        try {
            return this.persister.read(NFEnviaEventoInutilizacao.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFEnviaEventoInutilizacao enviaEventoInutilizacaoParaObjeto(final String xml) {
        try {
            return this.persister.read(NFEnviaEventoInutilizacao.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public NFNotaInfoItem notaInfoItemParaObjeto(final String xml) {
        try {
            return this.persister.read(NFNotaInfoItem.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    //CTe
    public CTeEnvioLote cteRecepcaoParaObjeto(final String xml) {
        try {
            return this.persister.read(CTeEnvioLote.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

    public CTeProcessado cteProcessadoParaObjeto(final String xml) {
        try {
            return this.persister.read(CTeProcessado.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
    }

}
