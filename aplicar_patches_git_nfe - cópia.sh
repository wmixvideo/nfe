#!/bin/bash
#
# Script para aplicar automaticamente as modificações locais na biblioteca Fincatto NFe.
#

set -e
echo "================================================="
echo "Iniciando a aplicação de patches locais..."
echo "================================================="

# --- 1. Modificações no pom.xml ---
echo "[1/4] Modificando pom.xml..."

# Altera a versão do Java para 1.8
sed -i.bak 's|<java.version>.*</java.version>|<java.version>1.8</java.version>|' pom.xml

# Altera a versão do Apache Santuario (xmlsec) para 3.0.6
sed -i.bak '/<artifactId>xmlsec<\/artifactId>/{N;s/<version>.*<\/version>/<version>3.0.6<\/version>/;}' pom.xml

echo "pom.xml modificado com sucesso."

# --- 2. Adicionar enum PA em NFAutorizador400.java ---
echo "[2/4] Modificando NFAutorizador400.java..."

cat > pa_enum.tmp <<'EOF'

    PA {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfeAutorizacao(ambiente);
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfeRetAutorizacao(ambiente);
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return SVRS.getNfeConsultaProtocolo(ambiente);
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return SVRS.getNfeStatusServico(ambiente);
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return SVRS.getRecepcaoEvento(ambiente);
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return SVRS.getConsultaCadastro(ambiente);
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return SVRS.getNfeInutilizacao(ambiente);
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceAutorizacao(ambiente);
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceRetAutorizacao(ambiente);
        }

        @Override
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return SVRS.getNfceConsultaProtocolo(ambiente);
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return SVRS.getNfceStatusServico(ambiente);
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return SVRS.getNfceRecepcaoEvento(ambiente);
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceInutilizacao(ambiente);
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.PA};
        }
    },
EOF

PA_BLOCK=$(cat pa_enum.tmp)
export PA_BLOCK
perl -i.bak -0777 -pe 's/(^\s*PE\s*\{)/$ENV{PA_BLOCK}$1/m' src/main/java/com/fincatto/documentofiscal/nfe400/classes/NFAutorizador400.java

rm pa_enum.tmp

echo "NFAutorizador400.java modificado com sucesso."

# --- 3. Criar parsers ---
echo "[3/4] Criando parsers..."
mkdir -p src/main/java/com/fincatto/documentofiscal/nfe400/parsers
cat > src/main/java/com/fincatto/documentofiscal/nfe400/parsers/DFParser.java <<'EOF'
package com.fincatto.documentofiscal.nfe400.parsers;

import java.io.File;

import org.simpleframework.xml.core.Persister;

import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLote;
import com.fincatto.documentofiscal.cte300.classes.nota.CTeProcessado;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLote;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento.NFEnviaEventoCancelamento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cartacorrecao.NFEnviaEventoCartaCorrecao;
import com.fincatto.documentofiscal.nfe400.classes.evento.inutilizacao.NFEnviaEventoInutilizacao;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvio;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import com.fincatto.documentofiscal.utils.DFPersister;

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

    // CTe
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

    // MDFe
    public MDFEnvioLote mdfeRecepcaoParaObjeto(final String xml) {
        try {
            return this.persister.read(MDFEnvioLote.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml do Lote MDFe: %s", e.getMessage()));
        }
    }

}
EOF
cat > src/main/java/com/fincatto/documentofiscal/nfe400/parsers/NotaFiscalChaveParser.java <<'EOF'
package com.fincatto.documentofiscal.nfe400.parsers;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

public class NotaFiscalChaveParser {

    private final String chave;

    public NotaFiscalChaveParser(final String chave) {
        this.chave = StringUtils.stripToEmpty(chave).replaceAll("\\D", "");
        if (this.chave.length() != 44) {
            throw new IllegalArgumentException(String.format("A chave deve ter exatos 44 caracteres numericos: %s", chave));
        }
    }

    public String getChave() {
        return this.chave;
    }

    public DFUnidadeFederativa getNFUnidadeFederativa() {
        return DFUnidadeFederativa.valueOfCodigo(this.chave.substring(0, 2));
    }

    public LocalDate getDataEmissao() {
        return LocalDate.of(this.getDataEmissaoAno(), this.getDataEmissaoMes(), 1);
    }

    private int getDataEmissaoMes() {
        return Integer.parseInt(this.chave.substring(4, 6));
    }

    private int getDataEmissaoAno() {
        return 2000 + Integer.parseInt(this.chave.substring(2, 4));
    }

    public String getCnpjEmitente() {
        return this.chave.substring(6, 20);
    }

    public DFModelo getModelo() {
        return DFModelo.valueOfCodigo(this.chave.substring(20, 22));
    }

    public String getSerie() {
        return this.chave.substring(22, 25);
    }

    public String getNumero() {
        return this.chave.substring(25, 34);
    }

    public NFTipoEmissao getFormaEmissao() {
        return NFTipoEmissao.valueOfCodigo(this.chave.substring(34, 35));
    }

    public String getCodigoNumerico() {
        return this.chave.substring(35, 43);
    }

    public String getDV() {
        return this.chave.substring(43, 44);
    }

    public boolean isEmitidaContingenciaSCAN() {
        return this.getSerie().matches("9[0-9]{2}");
    }

    public boolean isEmitidaContingenciaSCVAN() {
        return this.chave.matches("\\d{34}6\\d{9}");
    }

    public boolean isEmitidaContingenciaSCVRS() {
        return this.chave.matches("\\d{34}7\\d{9}");
    }

    public String getFormatado() {
        return this.chave.replaceFirst("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})", "$1 $2 $3 $4 $5 $6 $7 $8 $9 $10 $11");
    }
}
EOF
echo "Parsers criados com sucesso."

# --- 4. Tornar o script executável ---
echo "[4/4] Tornando o script executável..."
chmod +x aplicar_patches_git_nfe.sh

echo "================================================="
echo "Script 'aplicar_patches_git_nfe.sh' criado com sucesso!"
echo "================================================="
echo ""
echo "Para usar, siga estes passos:"
echo "1. Atualize seu código: git fetch upstream && git checkout main && git reset --hard upstream/main"
echo "2. Execute este script:   ./aplicar_patches_git_nfe.sh"
echo "3. Compile o projeto:     mvn clean install"

# Limpa os arquivos de backup .bak criados pelo sed
find . -name "*.bak" -type f -delete
