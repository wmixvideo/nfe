package com.fincatto.documentofiscal.nfe310.converters;

import org.junit.Assert;
import org.junit.Test;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.Position;

import com.fincatto.documentofiscal.nfe310.converters.StringNullConverter;

public class StringNullConverterTest {

    @Test
    public void deveRetornarStringVaziaCasoSejaValorNulo() throws Exception {
        final StringNullConverter stringConverter = new StringNullConverter();
        Assert.assertEquals("", stringConverter.read(new InputNodeMock()));
    }

    class InputNodeMock implements InputNode {

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getValue() throws Exception {
            return null;
        }

        @Override
        public boolean isRoot() {
            return false;
        }

        @Override
        public boolean isElement() {
            return false;
        }

        @Override
        public String getPrefix() {
            return null;
        }

        @Override
        public String getReference() {
            return null;
        }

        @Override
        public Position getPosition() {
            return null;
        }

        @Override
        public InputNode getAttribute(final String name) {
            return null;
        }

        @Override
        public NodeMap<InputNode> getAttributes() {
            return null;
        }

        @Override
        public InputNode getParent() {
            return null;
        }

        @Override
        public Object getSource() {
            return null;
        }

        @Override
        public InputNode getNext() throws Exception {
            return null;
        }

        @Override
        public InputNode getNext(final String name) throws Exception {
            return null;
        }

        @Override
        public void skip() throws Exception {
        }

        @Override
        public boolean isEmpty() throws Exception {
            return false;
        }
    }
}