package platform.services.api.streams.functions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.streams.Stream;

@Entity @Getter
@Table(name = "stream_functions")
public class StreamFunction extends BaseEntity<StreamFunction> {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "streamId")
    @JsonIgnore
    private Stream stream;


    private StreamFunctions function;

    public static StreamFunction create() {

        final StreamFunction fixture = new StreamFunction();

        fixture.function = StreamFunctions.MONITOR;

        return fixture;

    }

    public StreamFunction setStream(final Stream stream) {

        this.stream = stream;

        return this;

    }
    public StreamFunction setFunction(final StreamFunctions function) {

        this.function = function;

        return this;

    }

}
