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

import com.streamingplatform.api.common.entities.*;
import com.streamingplatform.api.common.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.data.domain.*;
import platform.api.common.entities.*;
import platform.api.common.repositories.*;

//@Service
public class GenericServiceImpl<T, D, ID> implements GenericService<T, D, ID> {

    private final BaseRepository baseRepository;

    @Autowired
    public GenericServiceImpl(final BaseRepository baseRepository) {

        log.trace("GenericServiceImpl(BaseRepository): {}", baseRepository.toString());

        this.baseRepository = baseRepository;

    }

    public BaseEntity saveEntity(BaseEntity entity) throws DuplicateKeyException {

        log.fatal("saveEntity: {}", entity.toString());

        try {

            return (BaseEntity) baseRepository.save(entity);

        } catch(DataIntegrityViolationException e) {

            Throwable t = e.getRootCause();

            if(t != null) {

                if(t.getMessage()
                    .contains("Duplicate entry")) {

                    throw new DuplicateKeyException("DUPLICATE", e);

                }

            } else {

                throw new InternalError(e);

            }

        }

        return null;

    }

    public Page getAll(final Pageable pageable) {

        return baseRepository.findAll(pageable);

    }

    public boolean delete(final BaseEntity entity) {

        baseRepository.delete(entity);

        return !baseRepository.existsById(entity.getId());

    }

    public void deleteById(final long entityId) {

        baseRepository.deleteById(entityId);

    }

//    //    @Autowired
//    public GenericServiceImpl(BaseRepository baseRepository) {
//
//        this.baseRepository = baseRepository;
//
//        log = LogManager.getLogger(super.getClass());
//
//        log.trace("GenericServiceImpl: {}", super.getClass());
//
//    }
//
//    @Override
//    public BaseEntity save(Object entity) throws DuplicateKeyException {
//
//        log.trace("save: {}", entity.toString());
//
//        try {
//
//            if(entity.getId() == null) {
//
//            }
//
//            Object result = baseRepository.save(entity);
//
//            return result;
//
//        } catch(DataIntegrityViolationException e) {
//
//            if(e.getRootCause()
//                .getMessage()
//                .contains("Duplicate entry")) {
//
//                throw new DuplicateKeyException("DUPLICATE", e);
//
//            }
//
//        }
//
//        return entity;
//
//    }
//
//    @Override
//    public void deleteById(final long entityId) {
//
//        log.trace("GenericServiceImpl.deleteById: {}", entityId);
//
//        baseRepository.deleteById(entityId);
//
//    }
}
