// /*
//  * Copyright (C) 2017 Matthew Davis <matthew@appsoa.io>
//  *
//  * This library is free software: you can redistribute it and/or
//  * modify it under the terms of the GNU Lesser General Public
//  * License as published by the Free Software Foundation; either
//  * version 3 of the License, or (at your option) any later version.
//  *
//  * This library is distributed in the hope that it will be useful,
//  * but WITHOUT ANY WARRANTY; without even the implied warranty of
//  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  * Library General Public License for more details.
//  *
//  * You should have received a copy of the GNU Lesser General Public
//  * License along with this library.  If not, see
//  * <http://www.gnu.org/licenses/>.
//  */
//
// package com.streamingplatform.api.common.config;
//
// import com.codahale.metrics.*;
// import com.codahale.metrics.graphite.GraphiteReporter;
// import com.codahale.metrics.health.HealthCheckRegistry;
// import com.codahale.metrics.jvm.*;
// import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
// import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
// import org.springframework.boot.bind.RelaxedPropertyResolver;
// import org.springframework.context.EnvironmentAware;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.env.Environment;
//
// import javax.annotation.PostConstruct;
// import java.lang.management.ManagementFactory;
// import java.net.InetSocketAddress;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.concurrent.TimeUnit;
//
// // https://www.programcreek.com/java-api-examples/index.php?source_dir=MyPal-master/src/main/java/com/in6kj/config/MetricsConfiguration.java
// @Configuration
// @EnableMetrics(proxyTargetClass = true)
// public class MetricsConfiguration extends MetricsConfigurerAdapter implements EnvironmentAware {
//
//     private static final String ENV_METRICS           = "metrics.";
//     private static final String ENV_METRICS_GRAPHITE  = "metrics.graphite.";
//     private static final String PROP_JMX_ENABLED      = "jmx.enabled";
//     private static final String PROP_GRAPHITE_ENABLED = "enabled";
//     private static final String PROP_GRAPHITE_PREFIX  = "";
//
//     private static final String PROP_PORT                   = "port";
//     private static final String PROP_HOST                   = "host";
//     private static final String PROP_METRIC_REG_JVM_MEMORY  = "jvm.memory";
//     private static final String PROP_METRIC_REG_JVM_GARBAGE = "jvm.garbage";
//     private static final String PROP_METRIC_REG_JVM_THREADS = "jvm.threads";
//     private static final String PROP_METRIC_REG_JVM_FILES   = "jvm.files";
//     private static final String PROP_METRIC_REG_JVM_BUFFERS = "jvm.buffers";
//
//     private final Logger log = LoggerFactory.getLogger(MetricsConfiguration.class);
//
//     private MetricRegistry metricRegistry = new MetricRegistry();
//
//     private HealthCheckRegistry healthCheckRegistry = new HealthCheckRegistry();
//
//     private RelaxedPropertyResolver propertyResolver;
//
//     @Override
//     public void setEnvironment(Environment environment) {
//
//         this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_METRICS);
//     }
//
//     @Override
//     @Bean
//     public MetricRegistry getMetricRegistry() {
//
//         return metricRegistry;
//     }
//
//     @Override
//     @Bean
//     public HealthCheckRegistry getHealthCheckRegistry() {
//
//         return healthCheckRegistry;
//     }
//
//     @PostConstruct
//     public void init() {
//
//         log.debug("Registering JVM gauges");
//
//         metricRegistry.register(PROP_METRIC_REG_JVM_MEMORY, new MemoryUsageGaugeSet());
//         metricRegistry.register(PROP_METRIC_REG_JVM_GARBAGE, new GarbageCollectorMetricSet());
//         metricRegistry.register(PROP_METRIC_REG_JVM_THREADS, new ThreadStatesGaugeSet());
//         metricRegistry.register(PROP_METRIC_REG_JVM_FILES, new FileDescriptorRatioGauge());
//         metricRegistry.register(PROP_METRIC_REG_JVM_BUFFERS,
//                                 new BufferPoolMetricSet(ManagementFactory.getPlatformMBeanServer()));
//
//         if(propertyResolver.getProperty(PROP_JMX_ENABLED, Boolean.class, false)) {
//
//             log.info("Initializing Metrics JMX reporting");
//
//             JmxReporter jmxReporter = JmxReporter.forRegistry(metricRegistry)
//                                                  .build();
//
//             jmxReporter.start();
//
//         }
//
//     }
//
//     /*
//      * Create reporter bean and tell Spring to call stop() when shutting down
//      */
//     @Bean(destroyMethod = "stop")
//     GraphiteReporter graphiteReporter() {
//         // add some JVM metrics (wrap in MetricSet to add better key prefixes)
//         MetricSet jvmMetrics = new MetricSet() {
//
//             @Override
//             public Map<String, Metric> getMetrics() {
//
//                 Map<String, com.codahale.metrics.Metric> metrics = new HashMap<String, Metric>();
//                 metrics.put("gc", new GarbageCollectorMetricSet());
//                 metrics.put("file-descriptors", new FileDescriptorRatioGauge());
//                 metrics.put("memory-usage", new MemoryUsageGaugeSet());
//                 metrics.put("threads", new ThreadStatesGaugeSet());
//                 return metrics;
//             }
//         };
//         metricRegistry.registerAll(jvmMetrics);
//
//         // create and start reporter
//         final GraphiteSender graphite = new GraphiteUDP(new InetSocketAddress("localhost", 2003));
//         final GraphiteReporter reporter = GraphiteReporter.forRegistry(metricRegistry)
//                                                           .prefixedWith("spring-boot")
//                                                           .convertRatesTo(TimeUnit.SECONDS)
//                                                           .convertDurationsTo(TimeUnit.MILLISECONDS)
//                                                           .filter(MetricFilter.ALL)
//                                                           .build(graphite);
//         reporter.start(1, TimeUnit.MINUTES);
//         return reporter;
//     }
//
//     @Configuration
//     @ConditionalOnClass(Graphite.class)
//     // @Profile("!" + Constants.SPRING_PROFILE_FAST)
//     public static class GraphiteRegistry implements EnvironmentAware {
//
//         private final Logger log = LoggerFactory.getLogger(GraphiteRegistry.class);
//
//         @Autowired
//         private MetricRegistry metricRegistry;
//
//         private RelaxedPropertyResolver propertyResolver;
//
//         @PostConstruct
//         private void init() {
//
//             Boolean graphiteEnabled = propertyResolver.getProperty(PROP_GRAPHITE_ENABLED, Boolean.class, false);
//             if(graphiteEnabled) {
//                 log.info("Initializing Metrics Graphite reporting");
//                 String  graphiteHost   = propertyResolver.getRequiredProperty(PROP_HOST);
//                 Integer graphitePort   = propertyResolver.getRequiredProperty(PROP_PORT, Integer.class);
//                 String  graphitePrefix = propertyResolver.getProperty(PROP_GRAPHITE_PREFIX, String.class, "");
//
//                 Graphite graphite = new Graphite(new InetSocketAddress(graphiteHost, graphitePort));
//                 GraphiteReporter graphiteReporter = GraphiteReporter.forRegistry(metricRegistry)
//                                                                     .convertRatesTo(TimeUnit.SECONDS)
//                                                                     .convertDurationsTo(TimeUnit.MILLISECONDS)
//                                                                     .prefixedWith(graphitePrefix)
//                                                                     .build(graphite);
//                 graphiteReporter.start(1, TimeUnit.MINUTES);
//             }
//         }
//
//         @Override
//         public void setEnvironment(Environment environment) {
//
//             this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_METRICS_GRAPHITE);
//         }
//
//     }
// }
