package com.fincatto.documentofiscal.nfe310.persister;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;

public class NFPersister extends Persister {

    private NFPersister() {
        super(new AnnotationStrategy(), new DFRegistryMatcher(), new Format(0));
    }
}