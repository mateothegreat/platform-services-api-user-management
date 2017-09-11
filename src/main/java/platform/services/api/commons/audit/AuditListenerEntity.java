package platform.services.api.commons.audit;

import lombok.extern.log4j.Log4j2;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Log4j2
public class AuditListenerEntity {

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyOperation(Object object) {

       log.trace("beforeAnyOperation: {}", object.toString());

    }

}
