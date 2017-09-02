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

package platform.services.api.users.services;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import platform.services.api.common.jpa.entities.BaseEntity;
import platform.services.api.common.security.SecurityCryptor;
import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.jpa.User;
import platform.services.api.users.jpa.UserRepository;

@Service
//public class UserServiceImpl implements GenericService {
public class UserService extends GenericServiceImpl  {
//public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {

        super(userRepository);

        Tracing.trace("UserServiceImpl(UserRepository): {}", userRepository.toString());

        this.userRepository = userRepository;

    }

    @Override
    public boolean delete(final BaseEntity entity) {

        userRepository.deleteById(entity.getId());

        return !userRepository.existsById(entity.getId());

    }

    public User save(final User entity) {

        entity.setPassword(SecurityCryptor.encode(entity.getPassword()));

        return (User) this.saveEntity(entity);

    }
//    public User getUserByUsername(String username) {
//
//        return baseRepository.getUserByUsername(username);
//
//    }
//
//    public User getUserByEmail(String email) {
//
//        return baseRepository.getUserByEmail(email);
//
//    }

    public List<String> getPermissions(String username) {

        Tracing.trace("getPermissions: {}", username);

        return new ArrayList<>();

    }

    public User getUserByUsername(final String username) {

        return null;
    }

    public User getUserByEmail(final String email) {

        return null;
    }

    // public User getUserInfo(String username) {
    //
    //     String sql = "SELECT u.username name, u.password pass, a.authority role FROM " + "comp_users u INNER JOIN comp_authorities a on u.username=a
    // .username WHERE " + "u.enabled =1 and u.username = ?";
    //     UserInfo userInfo = (UserInfo) jdbcTemplate.queryForObject(sql, new Object[]{username},
    //                                                                new RowMapper<UserInfo>() {
    //
    //                                                                    public UserInfo mapRow(ResultSet rs,
    //                                                                                           int rowNum) throws
    //                                                                                                       SQLException {
    //
    //                                                                        UserInfo user = new UserInfo();
    //                                                                        user.setUsername(rs.getString("name"));
    //                                                                        user.setPassword(rs.getString("pass"));
    //                                                                        user.setRole(rs.getString("role"));
    //                                                                        return user;
    //                                                                    }
    //                                                                });
    //     return userInfo;
    // }

}
