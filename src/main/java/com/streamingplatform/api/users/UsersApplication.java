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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class UsersApplication {

    private static final Logger log = LoggerFactory.getLogger(UsersApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(UsersApplication.class, args);

    }

//    @Bean
//    CommandLineRunner init(UsersRepository userRepository) {
//
//        log.info("CommandLineRunner init(UsersRepository userRepository):");
//
//        return (args) -> Arrays.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
//                               .forEach(a -> {
//
//                                   log.info("  creating user: " + a);
//
//                                   User user = userRepository.save(new User(1, a, "password", 1));
//
//                                   //bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + a, "A description"));
//
//                               });
//
//    }

//    @Bean
//    public CommandLineRunner findByUsername(UsersRepository repository) {
//
//        return (args) -> {
//
//            log.info("findByUsername:");
//
//            for (User user : repository.findByUsername("a")) {
//
//                log.info(user.toString());
//            }
//
//        };
//
//    }

}
