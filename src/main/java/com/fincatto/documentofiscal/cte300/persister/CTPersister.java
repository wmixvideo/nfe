package com.fincatto.documentofiscal.cte300.persister;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;

public class CTPersister extends Persister {

    public CTPersister() {
        super(new AnnotationStrategy(), new DFRegistryMatcher(), new Format(0));
    }
}