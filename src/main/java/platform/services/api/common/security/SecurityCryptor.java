package platform.services.api.common.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import platform.services.api.common.utilities.Tracing;

@Log4j2
@Service
public class SecurityCryptor {

    private static boolean trace = true;

    public static String encode(final String str) {

        final String result;

        if(isEncoded(str)) {

            if(trace) {

                log.trace("encode: {} = (already encoded)", str);

            }

            result = str;

        } else {

            final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

            result = bCryptPasswordEncoder.encode(str);

            if(trace) {

                log.trace("encode: {} = {} ({})", str, result, result.length());

            }

        }

        return result;

    }

    @SuppressWarnings("WeakerAccess")
    public static boolean isEncoded(final String str) {

        if(trace) {

//            log.trace("isEncoded: {} = {} (len: {})", Boolean.valueOf(str.startsWith("$2a$")), str, str.length());

        }

        return str.startsWith("$2a$");

    }

    public static boolean matches(String rawPassword, String encodedPassword) {

        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder( 10);

        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);

    }

    private static boolean isTrace() {

        return trace;
    }

    public static void setTrace(final boolean trace) {

        SecurityCryptor.trace = trace;

    }

}
