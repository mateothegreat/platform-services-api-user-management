package platform.services.api.common.jpa.repositories;

import org.springframework.data.domain.*;

/**
 *
 */
public class BaseRepositoryOperations {

    public static PageRequest pageRequestFactory() {

        return new PageRequest(0, 5);

    }

}
