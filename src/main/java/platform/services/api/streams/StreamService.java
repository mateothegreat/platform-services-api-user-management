package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import platform.services.api.commons.services.GenericService;

@Service
@Transactional
public class StreamService extends GenericService<StreamRepository, Stream> {

    private final StreamRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(final Stream stream) {

        entityManager.persist(stream);

    }

    @Autowired
    public StreamService(final StreamRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
