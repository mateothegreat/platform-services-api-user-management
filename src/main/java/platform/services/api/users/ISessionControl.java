package platform.services.api.users;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

interface ISessionControl {

    void close(Session session);

    void close(StatelessSession session);

}

