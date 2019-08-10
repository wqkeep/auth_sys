package com.wqkeep.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeUtils {

    @Autowired
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return  bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String encodePassword = encodePassword("123456");
        System.out.println(encodePassword);
    }

}
