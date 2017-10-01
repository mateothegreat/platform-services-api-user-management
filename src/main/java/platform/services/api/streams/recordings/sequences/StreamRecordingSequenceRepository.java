package platform.services.api.streams.recordings.sequences;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import platform.services.api.commons.jpa.repositories.BaseRepository;

@Repository
public interface StreamRecordingSequenceRepository extends BaseRepository<StreamRecordingSequence> {

//    Page<StreamRecordingSequence> getAllByRecordingId(final Long recordingId, final Pageable pageable);

}
