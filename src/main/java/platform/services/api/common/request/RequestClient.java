/*
 * Copyright (C) 2017 Matthew Davis <matthew@appsoa.io>
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package platform.services.api.common.request;

/*-
 * $$SoftwareLicense
 * Streaming Platform Users API
 * %%
 * Copyright (C) 2017 streamnvr
 * %%
 * __
 *       /\ \__
 *   ____\ \ ,_\  _ __    __     __      ___ ___     ___   __  __   _ __
 *  /',__\\ \ \/ /\`'__\/'__`\ /'__`\  /' __` __`\ /' _ `\/\ \/\ \ /\`'__\
 * /\__, `\\ \ \_\ \ \//\  __//\ \L\.\_/\ \/\ \/\ \/\ \/\ \ \ \_/ |\ \ \/
 * \/\____/ \ \__\\ \_\\ \____\ \__/.\_\ \_\ \_\ \_\ \_\ \_\ \___/  \ \_\
 *  \/___/   \/__/ \/_/ \/____/\/__/\/_/\/_/\/_/\/_/\/_/\/_/\/__/    \/_/
 * 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * streaming-platform.com
 */

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import java.util.ArrayList;
import java.util.List;

import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.jpa.User;

public class RequestClient {

    private final Object            body;
    private final RestTemplate      client;
    private final HttpHeaders       httpHeaders;
    private final HttpEntity        httpEntity;
    private final UriComponents     url;
    private final RequestClientAuth auth;
    private       MediaType         mediaType;

    private RequestClient(final RequestClientBuilder builder) {

        this.body = builder.body;
        this.url = builder.url;
        this.client = builder.client;
        this.auth = builder.auth;
        this.mediaType = builder.mediaType;

        this.httpHeaders = this.buildHeaders();

        this.httpEntity = buildEntity(this.httpHeaders, this.body);

    }

    private HttpHeaders buildHeaders() {

        final HttpHeaders headers = new HttpHeaders();

        if(mediaType != null) {

            headers.add(HttpHeaders.CONTENT_TYPE, mediaType.toString());

        }

        final HttpHeader authHeader = auth.build();

        if(authHeader != null) {

            Tracing.trace("authHeader: {}", authHeader.toString());

            headers.add(authHeader.getName(), authHeader.getValue());

        }

        return headers;

    }

    private static HttpEntity<Object> buildEntity(final HttpHeaders httpHeaders, final Object body) {

        if(body == null) {

            return new HttpEntity<>(httpHeaders);

        } else {

            return new HttpEntity<>(body, httpHeaders);

        }

    }

    public static class RequestClientBuilder {

        private final MediaType         mediaType;
        private       RestTemplate      client;
        private       UriComponents     url;
        private       RequestClientAuth auth;
        private       Object            body;

        public RequestClientBuilder(final UriComponents url, final RequestClientAuth auth, final MediaType mediaType, final Object body) {

            this.url = url;
            this.auth = auth;
            this.body = body;
            this.mediaType = mediaType;

            this.client = new RestTemplate();

//            client.setMessageConverters(getMessageConverters());

        }

        private List<HttpMessageConverter<?>> getMessageConverters() {

            List<HttpMessageConverter<?>> converters =
                    new ArrayList<HttpMessageConverter<?>>();
            converters.add(new MappingJackson2HttpMessageConverter());
            return converters;
        }

        public RequestClient build() {

            return new RequestClient(this);

        }

        public RestTemplate getClient() {

            return client;
        }

        public RequestClientBuilder setClient(final RestTemplate client) {

            this.client = client;

            return this;

        }

        public UriComponents getUrl() {

            return url;
        }

        public void setUrl(final UriComponents url) {

            this.url = url;
        }

        public RequestClientAuth getAuth() {

            return auth;
        }

        public void setAuth(final RequestClientAuth auth) {

            this.auth = auth;
        }

        public Object getBody() {

            return body;
        }

        public RequestClientBuilder setBody(final Object body) {

            this.body = body;

            return this;

        }
    }

    public HttpEntity<?> getHttpEntity() {

        return httpEntity;
    }

    //    public ResponseEntity getResponseEntity(final HttpMethod httpMethod, final String urlPath) {
//    public ResponseEntity getResponseEntity(final HttpMethod httpMethod, final String urlPath) {
    public ResponseEntity<String> exchange(final HttpMethod httpMethod, final Class<User[]> responseType) {

        return client.exchange(url.toUri(), httpMethod, httpEntity, String.class);

//        return client.exchange(url.toUri(), httpMethod, httpEntity, User.class);
//        return getClient().exchange(url.toUri(), httpMethod, httpEntity, responseType);

    }

//    public ResponseEntity exchange() {
//
//
//    }

    public RestTemplate getClient() {

        return client;

    }

    public Object getBody() {

        return body;

    }

    public MediaType getMediaType() {

        return mediaType;

    }

    public void setMediaType(final MediaType mediaType) {

        this.mediaType = mediaType;

    }

    @Override public String toString() {

        return String.format("RequestClient{body=%s, client=%s, httpHeaders=%s, httpEntity=%s, url=%s, auth=%s, mediaType=%s}", body,
                client, httpHeaders, httpEntity, url, auth, mediaType);

    }

}
