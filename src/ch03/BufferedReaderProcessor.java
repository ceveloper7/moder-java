package ch03;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
    void process(BufferedReader b) throws IOException;
}
