package platform.services.api.users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

/**
 * This class holds a Hibernate session factory. The simplest way to create a session factory:
 * <p>
 * {@code Fluent.factory().build(); } <br> Don't forget to destroy it with
 * <p>
 * {@code Fluent.factory().close(); }
 *
 * @author V.Ladynev
 */
public final class HibernateSessionFactory {

    /** Session factory. */
    private static volatile SessionFactory  sessionFactory = null;
    private static          ISessionControl sessionControl = null;

    private HibernateSessionFactory() {

    }

    public static <T> T doInTransaction(final IRequest<T> request) {

        Transaction   txn     = null;
        final Session session = openSession();
        T             result;

        try {

            txn = session.beginTransaction();

            result = request.doInTransaction(session);

            txn.commit();

        } catch(final Throwable th) {

            rollback(txn);

            throw InternalUtils.toRuntimeException(th);

        } finally {

            sessionControl.close(session);

        }

        return result;
    }

    /**
     * It is need to use for only simply persisten objects. It can work incorrect for associations.
     *
     * @return result of request
     */
    public static <T> T doInStatlessTransaction(final IStatelessRequest<T> request) throws RuntimeException {

        Transaction            txn     = null;
        final StatelessSession session = openStatelessSession();

        T result;

        try {

            txn = session.beginTransaction();

            result = request.doInTransaction(session);

            txn.commit();

        } catch(final Throwable th) {

            rollback(txn);

            throw new RuntimeException(th);

        } finally {

            sessionControl.close(session);

        }

        return result;

    }

    /**
     * Open a {@link Session}.
     *
     * @return the created session
     */
    private static Session openSession() {

        assertSessionFactory();

        return sessionFactory.openSession();

    }

    /**
     * Open a new stateless session.
     *
     * @return the created stateless session
     */
    private static StatelessSession openStatelessSession() {

        assertSessionFactory();

        return sessionFactory.openStatelessSession();

    }

    private static void assertSessionFactory() {

        if(sessionFactory == null) {

            throw new IllegalStateException("Firstly create a session factory with Fluent.factory().build()");

        }

    }

    private static void rollback(final Transaction txn) {

        if(txn != null) {

            txn.rollback();

        }

    }

    /**
     * Destroy {@link SessionFactory} and release all resources (caches, connection pools, etc).
     */
     static synchronized void closeSessionFactory() {

        if(sessionFactory != null) {

            sessionFactory.close();

            sessionFactory = null;

        }
    }

    static synchronized void setExistingSessionFactory(final SessionFactory sessionFactory,
                                                       final ISessionControl sessionControl) {

        HibernateSessionFactory.sessionControl = sessionControl;

        closeSessionFactory();

        HibernateSessionFactory.sessionFactory = sessionFactory;

    }

}
