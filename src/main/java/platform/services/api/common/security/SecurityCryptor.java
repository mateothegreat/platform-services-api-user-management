package platform.services.api.common.security;

import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.*;

@Service
public class SecurityCryptor {

    public static String encode(final String str) {

        final String result;

        if(isEncoded(str)) {

            result = str;

        } else {

            final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

            result = bCryptPasswordEncoder.encode(str);

        }

        return result;

    }

    @SuppressWarnings("WeakerAccess")
    public static boolean isEncoded(final String str) {

        return str.startsWith("$2a$");

    }

}
