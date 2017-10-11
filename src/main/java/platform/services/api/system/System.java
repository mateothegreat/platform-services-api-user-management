package platform.services.api.system;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

import platform.services.api.commons.jpa.entities.BaseEntity;

@Entity @Data
@Table(name = "systems")
public class System extends BaseEntity<System> {

    public static System create() {

        final System fixture = new System();

        return fixture;

    }

}
