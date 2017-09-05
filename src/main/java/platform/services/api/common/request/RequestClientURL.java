package platform.services.api.common.request;

import org.springframework.http.HttpMethod;

public class RequestClientURL {

    private final String                   base;
    private final int                      port;
    private final HttpMethod               method;
    private final String                   path;
    private final RequestClientURLProtocol protocol;

    public RequestClientURL(final RequestClientURLProtocol protocol, final String base, final int port, final String path, final HttpMethod method, final String media) {

        this.protocol = protocol;
        this.path = path;
        this.base = base;
        this.method = method;
        this.port = port;

    }

    public String format() {

        return String.format("%s://%s:%d/%s", protocol.toString(), base, port, path);

    }

    public String getBase() {

        return base;

    }

    public int getPort() {

        return port;

    }

    public String getPath() {

        return path;

    }

    public HttpMethod getMethod() {

        return method;

    }

    @Override public String toString() {

        return String.format("RequestClientURL{base='%s', port=%d, method=%s, path='%s', protocol=%s}", base, port, method, path, protocol);

    }

}
