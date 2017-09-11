package platform.services.api.commons.request;

public final class HttpHeader {

    public static final String AUTHORIZATION_NAME      = "Authorization";
    public static final String AUTHORIZATION_VALUE     = "Basic";
    public static final String AUTHORIZATION_FORMAT    = String.format("%s %%s", AUTHORIZATION_VALUE);
    public static final String HEADER_WWW_AUTHENTICATE = "WWW-Authenticate";
    public static final String BASIC_REALM             = "Basic realm";
    public static final String X_AUTH_TOKEN_NAME       = "X-Auth-Token";

    private final String name;
    private final String value;

    public HttpHeader(final String name, final String value) {

        this.name = name;
        this.value = value;

    }

    public String format() {

        return String.format("%s: %s", name, value);

    }

    public String getName() {

        return name;

    }

    public String getValue() {

        return value;

    }

    @Override public String toString() {

        return String.format("HttpHeader{name='%s', value='%s'}", name, value);

    }

}
