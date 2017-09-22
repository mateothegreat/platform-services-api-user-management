package platform.services.api.users;

import lombok.Getter;
import org.springframework.http.HttpMethod;

import platform.services.api.commons.enums.Role;

@Getter
public class RoleMethod {

    private final Role       role;
    private final HttpMethod httpMethod;
    private final String     path;

    public RoleMethod(final Role role, final HttpMethod httpMethod, final String path) {

        this.role = role;
        this.httpMethod = httpMethod;
        this.path = path;

    }

}
