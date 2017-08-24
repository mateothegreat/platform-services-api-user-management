

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

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionEventListener implements HttpSessionListener {
    
    private static int    activeSessions = 0;
    private        Logger logger         = LogManager.getLogger(SessionEventListener.class);
    
    @Override
    public void sessionCreated(final HttpSessionEvent se) {
        
        activeSessions++;
        
        logger.trace("sessionCreated: {} (activeSessions: {})", se.getSession()
                                                                  .getId(), activeSessions);
        
    }
    
    @Override
    public void sessionDestroyed(final HttpSessionEvent se) {
        
        activeSessions--;
        
        logger.trace("sessionDestroyed: {} (activeSessions: {})", se.getSession()
                                                                    .getId(), activeSessions);
        
    }
    
}
