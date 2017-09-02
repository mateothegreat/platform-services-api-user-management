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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import platform.services.api.common.jpa.entities.BaseEntity;
import platform.services.api.common.jpa.repositories.BaseRepository;
import platform.services.api.common.utilities.Tracing;

//@Service
public class GenericServiceImpl implements GenericService {

    private BaseRepository baseRepository;

    @Autowired
    public GenericServiceImpl(final BaseRepository baseRepository) {

        Tracing.trace("GenericServiceImpl(BaseRepository): {}", baseRepository.toString());

        this.baseRepository = baseRepository;

    }

    public GenericServiceImpl() {}

    public BaseEntity saveEntity(final BaseEntity entity) {

        Tracing.trace("saveEntity: {}", entity.toString());

        BaseEntity result = null;

        try {

            result = (BaseEntity) baseRepository.save(entity);

        } catch(final DataIntegrityViolationException e) {

            final Throwable t = e.getRootCause();

            if(t != null) {

                if(t.getMessage()
                    .contains("Duplicate entry")) {

                    throw new DuplicateKeyException("DUPLICATE", e);

                }

            } else {

                throw new InternalError(e);

            }

        }

        return result;

    }

    public Page<?> getAll(final Pageable pageable) {

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
