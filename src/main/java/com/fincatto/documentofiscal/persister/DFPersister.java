package com.fincatto.documentofiscal.persister;

import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.InputNode;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.util.TimeZone;

/**
 * Classe responsavel por fazer a serializacao e desserializacao dos objetos.
 * Por padrao ela se encontra cacheada na classe {@link com.fincatto.documentofiscal.DFConfig} e deve ser usada de la.
 */
public class DFPersister extends Persister {
    
    private boolean strict;
    
    public DFPersister(TimeZone timeZone) {
        super(new AnnotationStrategy(), new DFRegistryMatcher(timeZone), new Format(0));
        this.strict = true;
    }
    
    public DFPersister setStrict(boolean strict) {
        this.strict = strict;
        return this;
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
}