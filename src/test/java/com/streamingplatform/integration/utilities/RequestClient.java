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

package com.streamingplatform.integration.utilities;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class RequestClient {
    
    private final String       contentType;
    private final String       token;
    private final String       username;
    private final String       password;
    private final Object       body;
    private final RestTemplate client;
    private final HttpHeaders  httpHeaders;
    private final HttpEntity   httpEntity;
    
    private RequestClient(RequestClientBuilder builder) {
        
        this.contentType = builder.contentType;
        this.token = builder.token;
        this.username = builder.username;
        this.password = builder.password;
        this.body = builder.body;
        
        if(builder.client == null) {
            
            this.client = new RestTemplate();
            
        } else {
            
            this.client = builder.client;
            
        }
        
        this.httpHeaders = this.buildHeaders();
        this.httpEntity = this.buildEntity(this.httpHeaders, this.body);
        
    }
    
    private HttpHeaders buildHeaders() {
        
        HttpHeaders headers = new HttpHeaders();
        
        if(!contentType.isEmpty()) {
            
            headers.add(HttpHeaders.CONTENT_TYPE, contentType);
            
        }
        
        if(username != null && password != null) {
            
            String plainClientCredentials  = username + ":" + password;
            String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
            
            headers.add("Authorization", "Basic " + base64ClientCredentials);
            
        }
        
        if(token != null) {
            
            headers.add("X-Auth-Token", token);
            
        }
        
        return headers;
        
    }
    
    private HttpEntity<Object> buildEntity(HttpHeaders httpHeaders, Object body) {
        
        if(body == null) {
            
            return new HttpEntity<>(httpHeaders);
            
        } else {
            
            return new HttpEntity<>(body, httpHeaders);
            
        }
        
    }
    
    public HttpHeaders getHttpHeaders() {
        
        return httpHeaders;
    }
    
    public HttpEntity getHttpEntity() {
        
        return httpEntity;
    }
    
    public String getContentType() {
        
        return contentType;
    }
    
    public String getToken() {
        
        return token;
    }
    
    public String getUsername() {
        
        return username;
    }
    
    public String getPassword() {
        
        return password;
    }
    
    public Object getBody() {
        
        return body;
    }
    
    public RestTemplate getClient() {
        
        return client;
    }
    
    public static class RequestClientBuilder {
        
        private String contentType = MediaType.APPLICATION_JSON_VALUE;
        private String       token;
        private String       username;
        private String       password;
        private Object       body;
        private RestTemplate client;
        
        public RequestClientBuilder(String username, String password) {
            
            this.username = username;
            this.password = password;
            
        }
        
        public RequestClientBuilder(String token) {
            
            this.token = token;
            
        }
        
        public RequestClient build() {
            
            return new RequestClient(this);
            
        }
        
        public RequestClientBuilder setContentType(String contentType) {
            
            this.contentType = contentType;
            
            return this;
            
        }
        
        public RequestClientBuilder setToken(String token) {
            
            this.token = token;
            
            return this;
            
        }
        
        public RequestClientBuilder setUsername(String username) {
            
            this.username = username;
            
            return this;
            
        }
        
        public RequestClientBuilder setPassword(String password) {
            
            this.password = password;
            
            return this;
            
        }
        
        public RequestClientBuilder setBody(Object body) {
            
            this.body = body;
            
            return this;
            
        }
        
        public RequestClientBuilder setClient(RestTemplate client) {
            
            this.client = client;
            
            return this;
            
        }
        
    }
    
}
