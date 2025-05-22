package com.mg.solidaritynetwork.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    public String encoder(String senha) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

       return bCryptPasswordEncoder.encode(senha);
    }
}
