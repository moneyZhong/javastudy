package com.study.javastudy.obpool.simple;

import org.apache.commons.pool2.ObjectPool;

import java.io.IOException;
import java.io.Reader;

public class ReaderWithPoolUtil {
    private ObjectPool<StringBuffer> pool;
    public ReaderWithPoolUtil(ObjectPool objectPool){
        this.pool = objectPool;
    }

    public String readToString(Reader in) throws IOException {
        StringBuffer sb = null;
        try {
            sb = pool.borrowObject();
            for(int c = in.read(); c!=-1; c=in.read()){
                sb.append((char)c);
            }
            return sb.toString();
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("unable to borrow buffer from pool"+e.toString());
        }finally {
            try {
                in.close();
            } catch (IOException e) {
               //ignored
            }
            try {
                if(null!=sb){
                    pool.returnObject(sb);
                }
            } catch (Exception e) {
                //ignored
            }
        }
    }
}
