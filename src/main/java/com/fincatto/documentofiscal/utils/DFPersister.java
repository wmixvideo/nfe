package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.InputNode;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

/**
 * Classe responsavel por fazer a serializacao e desserializacao dos objetos.
 * Por padrao ela se encontra cacheada na classe {@link com.fincatto.documentofiscal.DFConfig} e deve ser usada de la.
 */
public class DFPersister extends Persister {
    
    /**
     * Define o modo de leitura (desserializacao) do XML, repassado ao Simple XML em todos os metodos {@code read}.
     * <ul>
     * <li>{@code true}: o XML deve corresponder exatamente ao modelo. Tags ou atributos que nao existem nas classes
     * (por exemplo, campos de um leiaute mais novo que a biblioteca ainda nao implementa) lancam
     * {@link org.simpleframework.xml.core.PersistenceException}.</li>
     * <li>{@code false}: tags e atributos desconhecidos sao ignorados silenciosamente e o restante do XML e lido normalmente.</li>
     * </ul>
     * Nao afeta a escrita (serializacao) do XML.
     */
    private final boolean strict;

    /**
     * Cria um persister em modo estrito, equivalente a {@code new DFPersister(true)}.
     */
    public DFPersister() {
        this(true);
    }

    /**
     * @param strict {@code true} para falhar ao encontrar tags/atributos nao mapeados no XML lido;
     *               {@code false} para ignora-los. Util para ler XMLs de terceiros ou de leiautes mais novos,
     *               com o risco de perder campos desconhecidos sem aviso.
     */
    public DFPersister(final boolean strict) {
        super(new AnnotationStrategy(), new DFRegistryMatcher(), new Format(0));
        this.strict = strict;
    }
    
    @Override
    public <T> T read(Class<? extends T> type, String source) throws Exception {
        return super.read(type, source, this.strict);
    }
    
    @Override
    public <T> T read(Class<? extends T> type, File source) throws Exception {
        return super.read(type, source, this.strict);
    }
    
    @Override
    public <T> T read(Class<? extends T> type, InputStream source) throws Exception {
        return super.read(type, source, this.strict);
    }
    
    @Override
    public <T> T read(Class<? extends T> type, Reader source) throws Exception {
        return super.read(type, source, this.strict);
    }
    
    @Override
    public <T> T read(Class<? extends T> type, InputNode source) throws Exception {
        return super.read(type, source, this.strict);
    }
    
    @Override
    public <T> T read(T value, String source) throws Exception {
        return super.read(value, source, this.strict);
    }
    
    @Override
    public <T> T read(T value, File source) throws Exception {
        return super.read(value, source, this.strict);
    }
    
    @Override
    public <T> T read(T value, InputStream source) throws Exception {
        return super.read(value, source, this.strict);
    }
    
    @Override
    public <T> T read(T value, Reader source) throws Exception {
        return super.read(value, source, this.strict);
    }
    
    @Override
    public <T> T read(T value, InputNode source) throws Exception {
        return super.read(value, source, this.strict);
    }

	/**
	 * @return {@code true} se a leitura do XML e estrita (falha com tags/atributos desconhecidos),
	 *         {@code false} se eles sao ignorados.
	 */
	public boolean isStrict() {
		return strict;
	}
    
}