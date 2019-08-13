package com.hwua.storesystem.util;

import org.springframework.util.DigestUtils;

public class MD5Util {

    public static String getMd5(String str){
        String s = DigestUtils.md5DigestAsHex(str.getBytes());
        for (int i = 0; i < 9; i++){
            s = DigestUtils.md5DigestAsHex(s.getBytes());
        }
        return s;
    }

}
