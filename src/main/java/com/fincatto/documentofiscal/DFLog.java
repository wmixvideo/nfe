package com.fincatto.documentofiscal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface DFLog {
    
    default Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }
    
    static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}