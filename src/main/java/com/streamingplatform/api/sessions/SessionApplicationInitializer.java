

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
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class SessionApplicationInitializer extends AbstractHttpSessionApplicationInitializer {
    
    protected static final Logger log = LogManager.getLogger(SessionApplicationInitializer.class);
    
    public SessionApplicationInitializer() {
        
        super(SessionConfiguration.class);
        
        log.trace("AppInitializer()");
        
    }
    
}
