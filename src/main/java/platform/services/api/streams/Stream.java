package platform.services.api.streams;

import com.github.javafaker.Faker;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.jpa.entities.BaseEntityFixtureFunction;
import platform.services.api.commons.testing.Randomizers;

@Entity @Data
@Table(name = "streams")
public class Stream extends BaseEntity {

    protected String name;
    protected String description;

    private String hostname;
    private int port;
    private String path;

    private StreamProtocol protcol;

    private String username;
    private String password;


    public static Stream create() {

        final Stream stream = new Stream();

        stream.setName(Randomizers.username());
        stream.setDescription(new Faker().company().catchPhrase());

        return stream;

    }

}
