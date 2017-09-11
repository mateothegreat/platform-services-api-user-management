

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

package platform.services.api.commons.utilities;

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
 * streaming-main.platform.com
 */
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//https://stackoverflow.com/questions/4772425/change-date-format-in-a-java-string?answertab=votes#tab-top

public final class DateTimeUtils implements Serializable {
    
    private static final long serialVersionUID = -3301695478208950415L;
    
    public static final String FORMAT_MYSQL_TIMESTAMP = "yyyy-MM-dd hh:mm:ss";
    
    public static String getMYSQL() {
        
        return getFormatted(FORMAT_MYSQL_TIMESTAMP);
        
    }
    
    public static String getFormatted(String formatPattern) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);
        
        return dateFormat.format(now());
        
    }
    
    public static Date now() {
        
        return new Date();
        
    }
    
    public static Date getISO(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date) {
        
        return date;
        
    }
    
    public static Date parseDateStr(SimpleDateFormat simpleDateFormat, final String dateString) {
        
        try {
            
            return simpleDateFormat.parse(dateString);
            
        } catch (final ParseException e) {
            
            return new Date();
            
        }
    }
    
}
