package platform.services.api.users;

import org.hibernate.StatelessSession;

public interface IStatelessRequest<T> {

    T doInTransaction(StatelessSession session);

}

