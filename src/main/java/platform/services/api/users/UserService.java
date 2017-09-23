package platform.services.api.users;

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

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.services.GenericService;
import platform.services.api.users.profiles.UserProfileService;

@Log4j2
@Service
//public class UserService<R extends UserRepository<User, I>, I extends Long, E extends User> extends GenericService<R, E> {
public class UserService extends GenericService<UserRepository, User, Long> {

    private final UserRepository userRepository;
    private final UserProfileService userProfileService;

    @Autowired
    public UserService(final UserRepository userRepository, final UserProfileService userProfileService) {

        super(userRepository);

        this.userRepository = userRepository;
        this.userProfileService = userProfileService;

    }

    public User getByUsername(final String username) {

        return userRepository.getByUsername(username);

    }

    public User getByEmail(final String email) {

        return userRepository.getByEmail(email);

    }

    public User saveEntity(final User entity) {

        User result = null;

        try {

            if(entity.getPassword() != null) {

                entity.setPassword(entity.getPassword());

            }

            result = userRepository.save(entity);

        } catch(final DataIntegrityViolationException e) {

            final Throwable t = e.getRootCause();

            log.trace("saveEntity->DataIntegrityViolationException: {}", e.toString());

            if(t != null) {

                if(t.getMessage()
                    .contains("Duplicate entry")) {

                    log.trace("saveEntity->DataIntegrityViolationException: duplicate entry");

                    throw new DuplicateKeyException("DUPLICATE", e);

                }

            } else {

                throw new InternalError(e);

            }

        }

        return result;

    }

}
