package platform.services.api.networking.hosts;

import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented

@ContextConfiguration(classes = {

        DataSourceConfig.class,

        NetworkHostFactory.class,

        NetworkHostRepository.class,
        NetworkHostService.class,

})

//@Import({
//
//        DataSourceConfig.class,
//
//        NetworkHostFactory.class,
//
//        NetworkHostRepository.class,
//        NetworkHostService.class,
//
//})
public @interface NetworkHostFactorySetup {

}
