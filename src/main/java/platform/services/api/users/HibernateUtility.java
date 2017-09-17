package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import platform.services.api.DataSourceConfig;

/**
 * https://docs.jboss.org/hibernate/orm/3.3/reference/en-US/html/session-configuration.html
 */
@Log4j2
public class HibernateUtility {

    private static final ThreadLocal<Session> sessions = new ThreadLocal<>();

    private static class SessionFactoryHolder {

        private static final SessionFactory sessionFactory = buildSessionFactory();

    }

    public static Session getSession() {

        Session session = sessions.get();

        if(session == null) {

            session = getSessionFactory().openSession();

            sessions.set(session);

        }

        log.trace("getSession: {}", session);

        return session;

    }

    private static SessionFactory getSessionFactory() {

        log.trace("buildSessionFactory: {}", SessionFactoryHolder.sessionFactory);

        return SessionFactoryHolder.sessionFactory;

    }


    private static SessionFactory buildSessionFactory() {

//        final Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//        final Configuration configuration = new Configuration().addClass(User.class).setProperty("");

//        final StandardServiceRegistry standardRegistry      = new StandardServiceRegistryBuilder().applySettings()configure("hibernate.cfg.xml").build();
        final StandardServiceRegistry standardRegistry      =  new StandardServiceRegistryBuilder().applySettings(DataSourceConfig.buildHibernateConfiguration()).build();
        final Metadata                metadata              = new MetadataSources(standardRegistry).getMetadataBuilder().build();
        final SessionFactoryBuilder   sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
        final SessionFactory          sessionFactory        = sessionFactoryBuilder.build();

        log.trace("buildSessionFactory: {}", sessionFactory);

        return sessionFactory;

    }

}
