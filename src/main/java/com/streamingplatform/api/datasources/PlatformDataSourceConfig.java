
//
// package com.streamingplatform.api.datasources;

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





// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.jpa.repos.config.EnableJpaRepositories;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
// import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
// import org.springframework.transaction.PlatformTransactionManager;
// import org.springframework.transaction.annotation.EnableTransactionManagement;
//
// import javax.sql.DataSource;
//
// @Configuration
// @EnableJpaRepositories
// @EnableTransactionManagement
// public class PlatformDataSourceConfig {
//
//     @Bean
//     public DataSource dataSource() {
//
//         EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//         return builder.setType(EmbeddedDatabaseType.HSQL)
//                       .build();
//     }
//
//     @Bean
//     public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//         HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//         vendorAdapter.setGenerateDdl(true);
//
//         LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//         factory.setJpaVendorAdapter(vendorAdapter);
//         factory.setPackagesToScan("com.acme.domain");
//         factory.setDataSource(dataSource());
//         return factory;
//     }
//
//     @Bean
//     public PlatformTransactionManager transactionManager() {
//
//         JpaTransactionManager txManager = new JpaTransactionManager();
//         txManager.setEntityManagerFactory(entityManagerFactory());
//         return txManager;
//     }
// }
