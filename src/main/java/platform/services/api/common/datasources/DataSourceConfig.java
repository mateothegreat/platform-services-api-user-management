/*
 * Copyright (C) 2017 Matthew Davis <matthew@appsoa.io>
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package platform.services.api.common.datasources;

/*-
 * $$SoftwareLicense
 * Streaming Platform Users API
 * %%
 * Copyright (C) 2017 streamnvr
 * %%
 * __
 *       /\ \__
 *   ____\ \ ,_\  _ __    __     __      ___ ___     ___   __  __   _ __
 *  /',__\\ \ \/ /\`'__\/'__`\ /'__`\  /' __` __`\ /' _ `\/\ \/\ \ /\`'__\
 * /\__, `\\ \ \_\ \ \//\  __//\ \L\.\_/\ \/\ \/\ \/\ \/\ \ \ \_/ |\ \ \/
 * \/\____/ \ \__\\ \_\\ \____\ \__/.\_\ \_\ \_\ \_\ \_\ \_\ \___/  \ \_\
 *  \/___/   \/__/ \/_/ \/____/\/__/\/_/\/_/\/_/\/_/\/_/\/_/\/__/    \/_/
 * 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * streaming-platform.com
 */

import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;

import java.io.IOException;
import java.util.Properties;

import platform.services.api.common.audit.AuditingDateTimeProvider;
import platform.services.api.common.audit.AuditorAwareable;
import platform.services.api.common.audit.CurrentTimeDateTimeService;
import platform.services.api.common.audit.DateTimeService;
import platform.services.api.users.ApplicationConfig;

@Log4j2
@Configuration
//@Import({SecurityConfiguration.class})
@EnableJpaRepositories(basePackages = ApplicationConfig.PLATFORM_SERVICES_API_USERS_JPA)
//@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
//@EnableTransactionManagement
//@EnableSpringDataWebSupport
//@Transactional
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider", dateTimeProviderRef = "dateTimeProvider")
//@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
//
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
// This registers two HandlerMethodArgumentResolver objects that are described in the following:
//
//    The SortHandlerMethodArgumentResolver can extract sorting information from the request or from the @SortDefault annotation.
//    The PageableHandlerMethodArgumentResolver extracts the information of the requested page from the request.

//@ComponentScan(basePackages = { "platform.services.api.users", "platform.services.api.*", "platform.services.api.users.services"})
public class DataSourceConfig {

    @Autowired
    protected Environment environment;

//    public DataSourceConfig(final Environment env) {
//
//        this.env = env;
//
//    }

//    public final class HibernatePropertiesTable extends Properties {
//
//        private static final long serialVersionUID = 4587335114731065424L;
//
//        private HibernatePropertiesTable() {
//
//            setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//            setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//            setProperty("hibernate.globally_quoted_identifiers", "true");
//
//            log.trace("HibernatePropertiesTable(): {}", this);
//
//        }
//
//    }

//    @Bean
//    public SessionFactory sessionFactory() {
////    public LocalSessionFactoryBean sessionFactory() {
//
//        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        sessionFactory.setDataSource(platformBaseDataSource());
//        sessionFactory.setPackagesToScan(ApplicationConfig.PLATFORM_SERVICES_API);
//        sessionFactory.setHibernateProperties(hibernateProperties());
//
//        try {
//
//            sessionFactory.afterPropertiesSet();
//
//        } catch(IOException e) {
//
//            e.printStackTrace();
//
//        }
//
//        return sessionFactory.getObject();
//
//    }

    //    protected Properties hibernateProperties() {
//
//        return new HibernatePropertiesTable();
//
//    }
    private static Properties hibernateProperties() {

        final Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.ddl-auto", "create");

        return properties;
    }

    @Bean(name = ApplicationConfig.DATA_SOURCE_PLATFORM_BASE_BEAN_NAME)
    public DriverManagerDataSource platformBaseDataSource() {

        final DriverManagerDataSource managerDataSource = new DriverManagerDataSource();

        managerDataSource.setDriverClassName(ApplicationConfig.DATA_SOURCE_PLATFORM_BASE_DRIVER);
        managerDataSource.setUrl(ApplicationConfig.DATA_SOURCE_PLATFORM_BASE_URL);
        managerDataSource.setUsername(ApplicationConfig.DATA_SOURCE_PLATFORM_BASE_USER);
        managerDataSource.setPassword(ApplicationConfig.DATA_SOURCE_PLATFORM_BASE_PASS);

        return managerDataSource;

    }

//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//
//        txManager.setSessionFactory(sessionFactory);
//
//        return txManager;
//
//    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {

        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        final EntityManagerFactory factory = this.entityManagerFactory();

        return new JpaTransactionManager(factory);

    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);

        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(ApplicationConfig.PLATFORM_SERVICES_API_USERS_JPA);
        factory.setDataSource(platformBaseDataSource());
        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());

        return factory.getObject();

    }

    @Bean
    AuditorAware<String> auditorProvider() {

//        return new UsernameAuditorAware();
        return new AuditorAwareable();

    }

    @Bean
    DateTimeProvider dateTimeProvider(DateTimeService dateTimeService) {

        return new AuditingDateTimeProvider(dateTimeService);

    }

    @Bean
    DateTimeService currentTimeDateTimeService() {

        return new CurrentTimeDateTimeService();

    }

}
