package com.vito16.shop.common;

public class Exceptions {

    public static RuntimeException runtimeException(Exception e) {
        return unchecked(e);
    }


    /** 将CheckedException转换为UncheckedException. */
    public static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }
}
