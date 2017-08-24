

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

package com.streamingplatform.api.common.audit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuditApplicationEventListener {
    
    private static final Logger logger = LogManager.getLogger(AuditApplicationEventListener.class);
    
    @EventListener
    public void onAuditEvent(AuditApplicationEvent event) {
        
        AuditEvent actualAuditEvent = event.getAuditEvent();
        
        logger.trace("onAuditEvent: timestamp: {}, principal: {}, type: {}, " + "data: {}",
                     actualAuditEvent.getTimestamp(), actualAuditEvent.getPrincipal(), actualAuditEvent.getType(),
                     actualAuditEvent.getData());
    }
}
