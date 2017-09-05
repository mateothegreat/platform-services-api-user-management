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

package platform.services.api.common.jpa.entities;

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

import org.hibernate.validator.constraints.Range;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

//@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {
//public class BaseEntity {
//public class BaseEntity implements Serializable {

    public BaseEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected @NotNull @Range(min = 0) Long parentId;

//    @Version
//    private Integer version;

    public Long getParentId() {

        return parentId;
    }

    public void setParentId(final Long parentId) {

        this.parentId = parentId;

    }

    public Long getId() {

        return id;

    }

    public void setId(final Long id) {

        this.id = id;

    }

//    public Integer getVersion() {
//
//        return version;
//    }

//    public void setVersion(final Integer version) {
//
//        this.version = version;
//
//    }

    // @Column(name = "createdByUser", nullable = false)
    // @CreatedBy
    // private String createdByUser;
    //
//    @Temporal(TemporalType.DATE) private Date
    // @Column(name = "creationTime", nullable = false)
    // @CreatedDate
    // private ZonedDateTime creationTime;
    //
    // @Column(name = "modifiedByUser", nullable = false)
    // @LastModifiedBy
    // private String modifiedByUser;
    //
    // @Column(name = "modificationTime", nullable = false)
    // @LastModifiedDate
    // private ZonedDateTime modificationTime;

}
