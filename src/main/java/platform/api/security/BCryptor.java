package platform.api.security;

import org.springframework.security.crypto.bcrypt.*;

public class BCryptor {

    public static String encode(String str) {

        if(isEncoded(str)) {

            return str;

        } else {

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

            return bCryptPasswordEncoder.encode(str);

        }

    }

    public static boolean isEncoded(String str) {

        return str.startsWith("$2a$");

    }

}
