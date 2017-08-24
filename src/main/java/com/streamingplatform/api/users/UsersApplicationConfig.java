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

package com.streamingplatform.api.users;

import com.streamingplatform.api.security.config.SecurityConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({SecurityConfiguration.class})
@EnableTransactionManagement
@ComponentScan({"com.streamingplatform"})
public class UsersApplicationConfig {
    
    @Bean(name = "platformBaseDataSource")
    public DriverManagerDataSource platformBaseDataSource() {
        
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl(
            "jdbc:mysql://192.168.152.128:3306/platform_base?useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false");
        driverManagerDataSource.setUsername("user");
        driverManagerDataSource.setPassword("agaeq14");
        
        return driverManagerDataSource;
        
    }
    
}
