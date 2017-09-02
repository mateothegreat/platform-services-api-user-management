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
import org.apache.logging.log4j.*;
import org.springframework.data.domain.*;
import platform.api.common.entities.*;

//@Service
public interface GenericService<T, D, ID> {

    Logger log = LogManager.getLogger(GenericServiceImpl.class);

    Page getAll(Pageable pageable);

    boolean delete(final BaseEntity entity);
//        T save(T entity) throws DuplicateKeyException;
//    Object save(BaseEntity entity) throws DuplicateKeyException;

    //
//    T findOne(final long id);
//
//    List<T> findAll();
//    Page<T> getAll(Pageable pageable);

//    void create(final T entity) throws DuplicateKeyException;

//    T update(final T entity) throws DuplicateKeyException;

//    boolean delete(final BaseEntity entity);

//    void deleteById(final long entityId);

}
