package com.github.afterloe.inter;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by afterloe on 4/24/2017.
 */
public interface BufferedReaderProcess {
    String process(BufferedReader br) throws IOException;
}
