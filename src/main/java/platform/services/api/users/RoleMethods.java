package platform.services.api.users;

import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

import platform.services.api.commons.enums.Role;

/**
 * Maps roles to http paths for authorization.
 *
 * @author yomateod
 */
public enum RoleMethods {

    GET(new RoleMethod(Role.ROLE_USER_GET, HttpMethod.GET, "/users/{id}"));

    private static final Map<String, RoleMethods> mappings = new HashMap<>(10);

    RoleMethods(final RoleMethod method) {


    }

    static {

        for(final RoleMethods roleMethods : values()) {

            mappings.put(roleMethods.name(), roleMethods);

        }

    }

    /**
     * Resolve the given method value to an {@code UserRoleMap}.
     *
     * @param method the method value as a String
     *
     * @return the corresponding {@code UserRoleMap}, or {@code null} if not found
     */
    @Nullable
    public static RoleMethods resolve(@Nullable final String method) {

        return (method != null ? mappings.get(method) : null);

    }

    /**
     * Determine whether this {@code UserRoleMap} matches the given method value.
     *
     * @param method the method value as a String
     *
     * @return {@code true} if it matches, {@code false} otherwise
     */
    public boolean matches(final String method) {

        return (this == resolve(method));

    }

}
