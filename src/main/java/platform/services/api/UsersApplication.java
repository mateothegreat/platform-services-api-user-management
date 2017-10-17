/**
 * ====
 *     Copyright 2017 Pivotal Software, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 * ====
 *
 * Copyright 2017 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package platform.services.api;

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

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import platform.services.api.commons.configuration.CommonsConfig;

@SpringBootApplication(

        scanBasePackages = {

                CommonsConfig.PLATFORM_SERVICES_API,
                CommonsConfig.PLATFORM_SERVICES_API_COMMONS_SESSION,
                UsersConfig.PLATFORM_SERVICES_API_COMMONS,
                "platform.services.api.organizations"

        }
//
//        exclude = {
//
//                AopAutoConfiguration.class,
//                ErrorMvcAutoConfiguration.class,
//                MultipartAutoConfiguration.class,
//                RedisAutoConfiguration.class,
////                WebMvcAutoConfiguration.class,
//                WebSocketAutoConfiguration.class,
//                JdbcTemplateAutoConfiguration.class
//
//        }
        )
//@EnableDiscoveryClient
@EnableConfigurationProperties
//@OverrideAutoConfiguration(enabled = true)
//@SpringBootApplication(exclude = {
//
////        AuditAutoConfiguration.class,
////        EndpointAutoConfiguration.class,
//        SessionAutoConfiguration.class,
//
//})
@EnableAutoConfiguration
public class UsersApplication {

    private static final Logger GrayLogLogger = Logger.getLogger("graylogLogger");

    public static void main(final String[] args) {

        SpringApplication.run(UsersApplication.class, args);

//        final GelfConfiguration config = new GelfConfiguration("graylog.ops.streaming-platform.com", 12201).transport(GelfTransports.TCP)
//                                                                .queueSize(1024)
//                                                                .reconnectDelay(5000);
//
//        final GelfTransport transport = GelfTransports.create(config);
//
//        int count = 0;
//        while(true) {
//            final GelfMessage msg = new GelfMessage("Hello world! " + count + " " + config.getTransport().toString());
//            count++;
//
//            msg.addAdditionalField("_count", count);
//            msg.addAdditionalField("_oink", 1.231);
//            msg.addAdditionalField("_objecttest", new Object());
//
//            try {
//                transport.send(msg);
//                TimeUnit.SECONDS.sleep(2);
//
//                GrayLogLogger.error(msg);
////                GrayLogLogger.debug(msg);
//
//            } catch(InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }

}
