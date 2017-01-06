package com.fincatto.cte200.persister;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.cte200.transformers.CTRegistryMatcher;

public class CTPersister extends Persister {

    public CTPersister() {
        super(new AnnotationStrategy(), new CTRegistryMatcher(), new Format(0));
    }
}