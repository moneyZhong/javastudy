package com.study.javastudy.obpool.simple;

import java.io.IOException;
import java.io.Reader;

public class ReaderUtil {
    public String readToString(Reader in) throws IOException {
        StringBuffer sb = new StringBuffer();
        try {
            for(int c = in.read(); c!= -1; c=in.read()){
                sb.append((char)c);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
