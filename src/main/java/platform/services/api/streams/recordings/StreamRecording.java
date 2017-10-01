package platform.services.api.streams.recordings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequence;

@Entity @Data
@Table(name = "stream_recordings")
public class StreamRecording extends BaseEntity<StreamRecording> {

    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private Long          duration;

    //    @OneToMany(cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinColumn(name = "parentId")
//    @Column(updatable = false, nullable = false)
//    @JsonIgnore
    @JsonManagedReference
//    @OneToMany(mappedBy = "recording", fetch = FetchType.LAZY)
        @OneToMany(mappedBy = "recording", cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)

    private Set<StreamRecordingSequence> sequences = new HashSet<>(0);

    public static StreamRecording create() {

        final StreamRecording fixture = new StreamRecording();

        fixture.setDateStart(LocalDateTime.now().minusSeconds(60L));
        fixture.setDateEnd(LocalDateTime.now());
        fixture.setDuration(60L);

//        fixture.sequences.add(new StreamRecordingSequence().create());
//        fixture.sequences.add(new StreamRecordingSequence().create());
//        fixture.sequences.add(new StreamRecordingSequence().create());

        return fixture;

    }

}
