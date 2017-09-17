package platform.services.api.users;

import org.hibernate.Session;

public interface IRequest<T> {

    T doInTransaction(Session session);

}
