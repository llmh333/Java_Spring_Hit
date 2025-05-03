package com.hit.week8.util;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptionPassword {
    static BCrypt bCrypt = new BCrypt();
    public static boolean checkPassword(String password) {
        return bCrypt.checkpw(password, password);
    }

    public static String encryptPassword(String password) {
        return bCrypt.hashpw(password, BCrypt.gensalt(12));
    }
}
