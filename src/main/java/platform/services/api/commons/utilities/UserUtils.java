package platform.services.api.commons.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserUtils {

    public static String bcryptedPassword(String rawPassword) {

        return new BCryptPasswordEncoder().encode(rawPassword);

    }

}
