

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

package com.streamingplatform.api.sessions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import javax.annotation.PostConstruct;

//
// http://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis:connectors:lettuce
//
@ConditionalOnProperty(name = "spring.session.store-type", havingValue = "redis")
@EnableRedisHttpSession
public class SessionConfiguration extends AbstractHttpSessionApplicationInitializer {
    
    private Logger logger = LogManager.getLogger(SessionConfiguration.class);
    
    @Value("${spring.session.store-type}")
    private String sessionStoreType;
    
    @PostConstruct
    public void init() {
        
        logger.trace("Redis Session Replication is turned {}.", sessionStoreType.equals("redis") ? "ON" : "OFF");
        
    }
    
    @Bean
    public ConfigureRedisAction configureRedisAction() {
        
        logger.trace("Preventing auto-configuration in secured environments.");
        
        return ConfigureRedisAction.NO_OP;
        
    }
    
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        
        return new HeaderHttpSessionStrategy();
        
    }
    
}
