package com.fincatto.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class TesteUtil {

    public static File[] getArquivosParaTestes(final File caminhoArquivos) throws Exception {
        if (!caminhoArquivos.exists() || !caminhoArquivos.isDirectory()) {
            return new File[] {};
        }
        final Set<File> arquivos = new TreeSet<>();
        for (final File arquivo : caminhoArquivos.listFiles(TesteUtil.getFilter())) {
            if (arquivo.isFile() && !arquivo.getName().startsWith("._")) {
                arquivos.add(arquivo);
            }
        }
        return arquivos.toArray(new File[arquivos.size()]);
    }

    public static String filepathToString(final String caminho) throws IOException {
        final byte[] bytes = Files.readAllBytes(Paths.get(caminho));
        return new String(bytes, Charset.defaultCharset());
    }

    private static FilenameFilter getFilter() {
        return new FilenameFilter() {
            @Override
            public boolean accept(final File dir, final String nome) {
                return nome.matches(".*\\.(xml|XML)");
            }
        };
    }
}