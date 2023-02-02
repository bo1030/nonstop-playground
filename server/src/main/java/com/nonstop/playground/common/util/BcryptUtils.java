package com.nonstop.playground.common.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BcryptUtils {

    private BcryptUtils() {
        throw new IllegalStateException("Utility class");
    }
    public static String encodePassword(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(10));
    }

    public static boolean checkPassword(String rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword,encodedPassword);
    }
}
