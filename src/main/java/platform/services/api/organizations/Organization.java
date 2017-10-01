package platform.services.api.organizations;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import lombok.Data;

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
@Entity @Data
@Table(name = "organizations")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
//@JsonIdentityReference(alwaysAsId = true)
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")

public class Organization extends BaseEntity<Organization> {

    private String name;
    private String description;

//    @JsonIgnore/**/
//    @JsonManagedReference
//    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "parentId")
//@JsonIgnoreProperties("organization")
//@JsonManagedReference
@JsonIgnore
//    @JsonBackReference
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
