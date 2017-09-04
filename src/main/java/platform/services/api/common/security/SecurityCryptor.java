package platform.services.api.common.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import platform.services.api.common.utilities.Tracing;

@Service
public class SecurityCryptor {

    private static boolean trace = false;

    public static String encode(final String str) {

        final String result;

        if(isEncoded(str)) {

            if(trace) {

                Tracing.trace("encode: {} = (already encoded)", str);

            }

            result = str;

        } else {

            final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            if(trace) {

                Tracing.trace("encode: {} = {}", str, bCryptPasswordEncoder.encode(str));

            }

            result = bCryptPasswordEncoder.encode(str);

        }

        return result;

    }

    @SuppressWarnings("WeakerAccess")
    public static boolean isEncoded(final String str) {

        if(trace) {

            Tracing.trace("isEncoded: {} = TRUE", str);

        }

        return str.startsWith("$2a$");

    }

    public static boolean matches(String rawPassword, String encodedPassword) {

        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);

    }

    private static boolean isTrace() {

        return trace;
    }

    public static void setTrace(final boolean trace) {

        SecurityCryptor.trace = trace;

    }

}
