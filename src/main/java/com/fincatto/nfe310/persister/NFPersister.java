package com.fincatto.nfe310.persister;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe310.transformers.NFRegistryMatcher;

public class NFPersister extends Persister {

    public NFPersister() {
        super(new AnnotationStrategy(), new NFRegistryMatcher(), new Format(0));
    }
}