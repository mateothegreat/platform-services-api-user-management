///*
// * Copyright (C) 2017 Matthew Davis <matthew@appsoa.io>
// *
// * This library is free software: you can redistribute it and/or
// * modify it under the terms of the GNU Lesser General Public
// * License as published by the Free Software Foundation; either
// * version 3 of the License, or (at your option) any later version.
// *
// * This library is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// * Library General Public License for more details.
// *
// * You should have received a copy of the GNU Lesser General Public
// * License along with this library.  If not, see
// * <http://www.gnu.org/licenses/>.
// */
//
//package com.streamingplatform.api.users.repositories;
//
//import com.streamingplatform.api.users.models.User;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//import java.util.List;
//
//@RepositoryRestResource(path = "users", collectionResourceRel = "users")
//public interface UserRestRepository extends PagingAndSortingRepository<User, Long> {
//
//    /**
//     * @param username
//     *
//     * @return
//     */
//    List<User> findByUsername(@Param("username") String username);
//
//}