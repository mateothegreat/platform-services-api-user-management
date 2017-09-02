

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

package platform.api.common.utils.logging;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// http://www.journaldev.com/7128/log4j2-example-tutorial-configuration-levels-appenders
public class Log {
    
    // private static final Logger logger;
    private final String contextName;
    
    private Log(LogBuilder builder) {
        
        this.contextName = builder.contextName;
        
    }
    
    public static Logger getLogger(Object classRef) {
        
        return LogManager.getLogger(classRef.getClass()
                                            .getName());
        
    }
    
    public String getContextName() {
        
        return contextName;
    }
    
    public static class LogBuilder {
        
        private String contextName;
        
        public String getContextName() {
            
            return contextName;
        }
        
        public void setContextName(final String contextName) {
            
            this.contextName = contextName;
        }
        
        public LogBuilder(Object classRef) {
            
            this.contextName = classRef.getClass()
                                       .getName();
            
        }
        
        public Log build() {
            
            return new Log(this);
            
        }
        
    }
    
}
