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
package platform.services.api.streams.recordings.sequences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import platform.services.api.commons.services.GenericService;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.recordings.StreamRecording;
import platform.services.api.streams.recordings.StreamRecordingService;

@Service
public class StreamRecordingSequenceService extends GenericService<StreamRecordingSequenceRepository, StreamRecordingSequence> {

    private final StreamRecordingSequenceRepository repository;
    private final StreamRecordingService            streamRecordingService;

    @Autowired
    public StreamRecordingSequenceService(final StreamRecordingSequenceRepository repository, final StreamRecordingService streamRecordingService) {

        super(repository);

        this.repository = repository;
        this.streamRecordingService = streamRecordingService;

    }

//    public Page<StreamRecordingSequence> getAllByRecordingId(final Long recordingId) {
//
//        return getAllByRecordingId(recordingId, new PageRequest(0, 5));
//
//    }
//
//    public Page<StreamRecordingSequence> getAllByRecordingId(final Long recordingId, final Pageable pageable) {
//
//        return repository.getAllByRecordingId(recordingId, pageable);
//
//    }

    //    @Override
    public StreamRecordingSequence save(final UUID recording_uuid, final StreamRecordingSequence entity) throws ValidationError {

        final StreamRecording streamRecording = streamRecordingService.getByUuid(recording_uuid);

        entity.setRecording(streamRecording);

        return save(entity);

    }

}
