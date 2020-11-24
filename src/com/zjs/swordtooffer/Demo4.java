package com.zjs.swordtooffer;

import java.io.IOException;

/**
 * @ClassName Demo4
 * @Description TODO
 * @Author zhangjusheng
 * @Date 2020/10/14 11:04
 * @Version 1.0
 **/
public class Demo4 {
    public static void main(String[] args) {
        try {
            int a = 5 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void throwException() {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new UncheckedException("IO异常", e);
        }
    }

    public static class UncheckedException extends RuntimeException {
        static final long serialVersionUID = 7818375828146090155L;

        public UncheckedException()
        {
            super();
        }

        public UncheckedException(String message)
        {
            super(message);
        }

        public UncheckedException(String message, Throwable cause)
        {
            super(message, cause);
        }

        public UncheckedException(Throwable cause)
        {
            super(cause);
        }
    }
}
