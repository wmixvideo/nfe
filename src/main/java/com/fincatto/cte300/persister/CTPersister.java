package com.fincatto.cte300.persister;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.cte300.transformers.CTRegistryMatcher;

public class CTPersister extends Persister {

    public CTPersister() {
        super(new AnnotationStrategy(), new CTRegistryMatcher(), new Format(0));
    }
}