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

package platform.services.api.users.jpa;

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

import org.springframework.stereotype.Repository;

import platform.services.api.common.jpa.repositories.BaseRepository;

@Repository
//public interface UserRepository extends PagingAndSortingRepository {
public interface UserRepository extends BaseRepository<User, Long> {//public interface UserRepository extends BaseRepository<User, Long> {
//    public interface UserRepository<User, Long> extends PagingAndSortingRepository<BaseEntity, Long> {
//    public interface UserRepository<User, Long> extends PagingAndSortingRepository<BaseEntity, Long> {

//    User getById(Long id);
//    User findById(Long id);

    User getUserByEmail(String email);
    User getUserByUsername(String username);

//    @Override Iterable<BaseEntity> findAll(Sort sort);

//    @Override Page<BaseEntity> findAll(Pageable pageable);

//    @Override <S extends T> S save(S entity);

//    @Override <S extends T> Iterable<S> saveAll(Iterable<S> entities);

//    @Override Optional<BaseEntity> findById(java.lang.Long aLong);

//    @Override boolean existsById(java.lang.Long aLong);

//    @Override Iterable<BaseEntity> findAll();
//
//    @Override long count();
//
//    @Override void delete(BaseEntity entity);
//
//    @Override void deleteAll();
//
//    @Override void deleteById(java.lang.Long aLong);
//
//    @Override void deleteAll(Iterable<? extends platform.services.api.common.jpa.entities.BaseEntity> entities);
//
//    @Override Iterable<platform.services.api.common.jpa.entities.BaseEntity> findAllById(Iterable<java.lang.Long> longs);

//    void delete(final BaseEntity entity);
//    void deleteById(final long entityId);

//    User save(User user);

}
