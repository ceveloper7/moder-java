package ch03;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
    // especificamos el descriptor de funcion. Cualquier funcion lambda que quiera implementar process debera cumplir con esta firma.
    void process(BufferedReader b) throws IOException;
}
