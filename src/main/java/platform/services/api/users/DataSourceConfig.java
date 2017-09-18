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

package platform.services.api.users;

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
 * streaming-main.platform.com
 */

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

import java.util.Properties;

import platform.services.api.commons.CommonsConfig;
import platform.services.api.commons.audit.AuditingDateTimeProvider;
import platform.services.api.commons.audit.AuditorAwareable;
import platform.services.api.commons.audit.CurrentTimeDateTimeService;
import platform.services.api.commons.audit.DateTimeService;

@Log4j2
@Configuration
//@Import({SecurityConfiguration.class})
//@EnableJpaRepositories(basePackages = { CommonsConfig.PLATFORM_SERVICES_API })
//@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
@EnableTransactionManagement
//@EnableSpringDataWebSupport
//@Transactional
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = { CommonsConfig.PLATFORM_SERVICES_API })
//@EnableJpaRepositories(basePackages = { CommonsConfig.PLATFORM_SERVICES_API_USERS })
//
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})

//@ComponentScan(basePackages = { "platform.services.api.users", "platform.services.api.*", "platform.services.api.users.services"})
public class DataSourceConfig {

    public static final String DATA_SOURCE_PLATFORM_BASE_BEAN_NAME = "platformBaseDataSource";
    public static final String DATA_SOURCE_PLATFORM_BASE_DRIVER    = "com.mysql.jdbc.Driver";
    public static final String DATA_SOURCE_PLATFORM_BASE_USER      = "root";
    public static final String DATA_SOURCE_PLATFORM_BASE_PASS      = "asdfasdf";
    public static final String DATA_SOURCE_PLATFORM_BASE_URL       = "jdbc:mysql://localhost:3306/platform_base?useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    public static final String AUTHENTICATION_REALM_NAME           = "PlatformAPI";

    @Autowired
    protected Environment environment;

    @Bean(name = DATA_SOURCE_PLATFORM_BASE_BEAN_NAME) public DriverManagerDataSource platformBaseDataSource() {

        final DriverManagerDataSource managerDataSource = new DriverManagerDataSource();

        managerDataSource.setDriverClassName(DATA_SOURCE_PLATFORM_BASE_DRIVER);
        managerDataSource.setUrl(DATA_SOURCE_PLATFORM_BASE_URL);
        managerDataSource.setUsername(DATA_SOURCE_PLATFORM_BASE_USER);
        managerDataSource.setPassword(DATA_SOURCE_PLATFORM_BASE_PASS);

//        TomcatDataSourceConfiguration p = new TomcatDataSourceConfiguration();


        return managerDataSource;

    }

    @Bean public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {

        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean public PlatformTransactionManager transactionManager() {

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
        factory.setPackagesToScan(CommonsConfig.PLATFORM_SERVICES_API_USERS, CommonsConfig.PLATFORM_SERVICES_API_STREAMS);
//        factory.setPackagesToScan("platform.services.api.*");
        factory.setDataSource(platformBaseDataSource());
        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());

        return factory.getObject();

    }

    private static Properties hibernateProperties() {

        final Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.ddl-auto", "create");

        return properties;
    }

    @Bean AuditorAware<String> auditorProvider() {

        return new AuditorAwareable();

    }

    @Bean DateTimeProvider dateTimeProvider(DateTimeService dateTimeService) {

        return new AuditingDateTimeProvider(dateTimeService);

    }

    @Bean DateTimeService currentTimeDateTimeService() {

        return new CurrentTimeDateTimeService();

    }

}
