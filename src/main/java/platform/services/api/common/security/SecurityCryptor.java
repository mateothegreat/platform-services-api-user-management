package platform.services.api.common.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Log4j2
@Service
public class SecurityCryptor {

    private static final Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");
    private static       boolean trace          = true;

    public static String encode(final String str) {

        final String result;

        if(isEncoded(str)) {

            if(trace) {

                log.trace("encode: {} = (already encoded)", str);

            }

            result = str;

        } else {

            final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            result = bCryptPasswordEncoder.encode(str);

            if(trace) {

                log.trace("encode: {} = {} ({})", str, result, result.length());

            }

        }

        return result;

    }

    @SuppressWarnings("WeakerAccess")
    public static boolean isEncoded(final String str) {

        return BCRYPT_PATTERN.matcher(str)
                             .matches();

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
