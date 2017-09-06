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

package platform.services.api.common.jpa.repositories;

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

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

//@Repository
@NoRepositoryBean
//public interface BaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {//public interface BaseRepository<BaseEntity, Long> extends PagingAndSortingRepository<BaseEntity, Long> {
//public interface BaseRepository extends org.springframework.data.repository.Repository<BaseEntity, Long> {
//public interface BaseRepository<BaseEntity, Long> extends PagingAndSortingRepository<BaseEntity, Long> {
//public interface BaseRepository extends PagingAndSortingRepository {
//public interface BaseRepository<BaseEntity, ID extends Serializable> extends PagingAndSortingRepository<platform.services.api.common.jpa.entities.BaseEntity, ID> {
//public interface BaseRepository<T, Long> extends PagingAndSortingRepository<BaseEntity, Long> {
public interface BaseRepository<BaseEntity, Long> extends PagingAndSortingRepository<BaseEntity, Long> {


    BaseEntity getById(Long id);
//    T getById(Long id);

    //    BaseEntity findById(Long id);

    BaseRepositoryPage<BaseEntity> findAll(Pageable pageable);

//    /**s
//     * Returns all entities sorted by the given options.
//     *
//     * @param sort
//     *
//     * @return all entities sorted by the given options
//     */
//    Iterable findAll(Sort sort);
//
//    /**
//     * Returns a {@link org.springframework.data.domain.Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
//     *
//     * @param pageable
//     *
//     * @return a page of entities
//     */
//    Page findAll(Pageable pageable);
//
//    /**
//     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the entity instance completely.
//     *
//     * @param entity must not be {@literal null}.
//     *
//     * @return the saved entity will never be {@literal null}.
//     */
//    Object save(Object entity);
//
//    /**
//     * Saves all given entities.
//     *
//     * @param entities must not be {@literal null}.
//     *
//     * @return the saved entities will never be {@literal null}.
//     *
//     * @throws IllegalArgumentException in case the given entity is {@literal null}.
//     */
//    Iterable saveAll(Iterable entities);
//
//    /**
//     * Retrieves an entity by its id.
//     *
//     * @param o must not be {@literal null}.
//     *
//     * @return the entity with the given id or {@literal Optional#empty()} if none found
//     *
//     * @throws IllegalArgumentException if {@code id} is {@literal null}.
//     */
//    Optional findById(Object o);

//    Logger log = LogManager.getLogger(AbstractRestController.class);

    //    /**
//     * Returns whether an entity with the given id exists.
//     *
//     * @param o must not be {@literal null}.
//     *
//     * @return {@literal true} if an entity with the given id exists, {@literal false} otherwise.
//     *
//     * @throws IllegalArgumentException if {@code id} is {@literal null}.
//     */
    boolean existsById(Long entityId);
//
//    /**
//     * Returns all instances of the type.
//     *
//     * @return all entities
//     */
//    default Iterable findAll() {
//
//        return null;
//    }

//    /**
//     * Returns all instances of the type with the given IDs.
//     *
//     * @param iterable
//     *
//     * @return
//     */
//    Iterable findAllById(Iterable iterable);
//
//    /**
//     * Deletes the entity with the given id.
//     *
//     * @param o must not be {@literal null}.
//     *
//     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
//     */
//    void deleteById(Object o);
//
//    /**
//     * Deletes a given entity.
//     *
//     * @param entity
//     *
//     * @throws IllegalArgumentException in case the given entity is {@literal null}.
//     */
//    void delete(Object entity);
//
//    /**
//     * Deletes the given entities.
//     *
//     * @param entities
//     *
//     * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
//     */
//    void deleteAll(Iterable entities);
//
//    /**
//     * Deletes all entities managed by the baseRepository.
//     */
//    void deleteAll();

//     void delete(BaseEntity entity);
//    Page<T> findAll(Pageable pageable);

    // Optional<T> findOne(ID id);

    //    Object save(Object persisted);

    //    Object save(Object persisted);
//    BaseEntity save(BaseEntity entity);

    void deleteById(Long id);

}
