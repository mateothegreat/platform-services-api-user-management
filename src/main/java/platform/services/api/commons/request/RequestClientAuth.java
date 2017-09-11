package platform.services.api.commons.request;

import org.apache.commons.codec.binary.Base64;

public class RequestClientAuth {

    protected String username;
    protected String password;
    protected String token;

    public RequestClientAuth(final String username, final String password) {

        this.username = username;
        this.password = password;

    }

    public RequestClientAuth(final String token) {

        this.token = token;

    }

    @Override public String toString() {

        return String.format("RequestClientAuth{username='%s', password='%s', token='%s'}", username, password, token);

    }

    public HttpHeader build() {

        HttpHeader header = null;

        if(username != null && password != null) {

            final String plain  = String.format("%s:%s", username, password);
            final byte[] base64 = Base64.encodeBase64(plain.getBytes());

            header = new HttpHeader(HttpHeader.AUTHORIZATION_NAME, String.format(HttpHeader.AUTHORIZATION_FORMAT, new String(base64)));

        } else if(token != null) {

            header = new HttpHeader(HttpHeader.X_AUTH_TOKEN_NAME, token);

        }

        return header;

    }

}

