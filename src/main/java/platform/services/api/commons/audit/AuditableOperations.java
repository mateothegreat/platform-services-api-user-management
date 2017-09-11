package platform.services.api.commons.audit;

import org.hibernate.Session;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditQuery;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unchecked")
public class AuditableOperations<T extends Serializable> implements AuditableOperation<T> {

    private Class<?> clazz;

    @Override
    public List<T> getEntitiesAtRevision(final Number revision) {

        final AuditReader auditReader = AuditReaderFactory.get(getCurrentSession());
        final AuditQuery query = auditReader.createQuery()
                                            .forEntitiesAtRevision(clazz, revision);
        final List<T> resultList = query.getResultList();

        return resultList;

    }

    private Session getCurrentSession() {

        return null;
    }

    @Override
    public List<T> getEntitiesModifiedAtRevision(final Number revision) {

        final AuditReader auditReader = AuditReaderFactory.get(getCurrentSession());
        final AuditQuery query = auditReader.createQuery()
                                            .forEntitiesModifiedAtRevision(clazz, revision);
        final List<T> resultList = query.getResultList();

        return resultList;

    }

    @Override
    public List<T> getRevisions() {

        final AuditReader auditReader = AuditReaderFactory.get(getCurrentSession());
        final AuditQuery query = auditReader.createQuery()
                                            .forRevisionsOfEntity(clazz, true, true);
        final List<T> resultList = query.getResultList();

        return resultList;

    }

}
