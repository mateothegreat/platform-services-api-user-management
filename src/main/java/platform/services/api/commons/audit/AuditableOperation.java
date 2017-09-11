package platform.services.api.commons.audit;

import java.io.Serializable;
import java.util.List;

public interface AuditableOperation<T extends Serializable> {

    List<T> getEntitiesAtRevision(Number revision);

    List<T> getEntitiesModifiedAtRevision(Number revision);

    List<T> getRevisions();

}
