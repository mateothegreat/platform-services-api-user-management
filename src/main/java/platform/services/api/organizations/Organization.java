/**
 * ====
 *     Copyright 2017 Pivotal Software, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 * ====
 *
 * Copyright 2017 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package platform.services.api.organizations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import java.util.HashSet;
import java.util.Set;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.users.User;

@Transactional
@Entity @Getter
@Table(name = "organizations")
public class Organization extends BaseEntity<Organization> {

    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "organization", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>(0);

    public static Organization create() {

        final Organization fixture = new Organization();

        fixture.name = new Faker().company().name();
        fixture.description = new Faker().company().catchPhrase();

        return fixture;

    }

    public Organization setDescription(final String description) {

        this.description = description;

        return this;

    }
    public Organization setName(final String name) {

        this.name = name;

        return this;

    }
    public Organization setUsers(final Set<User> users) {

        this.users = users;

        return this;

    }

}
