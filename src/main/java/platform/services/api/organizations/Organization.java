package platform.services.api.organizations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

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
@Entity
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

    @JsonIgnore
    public Set<User> getUsers() {

        return this.users;

    }
}