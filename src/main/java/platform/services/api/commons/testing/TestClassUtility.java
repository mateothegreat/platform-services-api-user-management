package platform.services.api.commons.testing;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class TestClassUtility {

    public static void assertUtilityClassWellDefined(final Class<?> clazz)
        throws NoSuchMethodException, InvocationTargetException,
               InstantiationException, IllegalAccessException {

        // "class must be final"
        assertThat(Modifier.isFinal(clazz.getModifiers())).isTrue();

        // "There must be only one constructor"
        assertThat(clazz.getDeclaredConstructors().length).isEqualTo(1);

        final Constructor<?> constructor = clazz.getDeclaredConstructor();

        if(constructor.isAccessible() || !Modifier.isPrivate(constructor.getModifiers())) {

            fail("constructor is not private");

        }

        constructor.setAccessible(true);
        constructor.newInstance();
        constructor.setAccessible(false);

        for(final Method method : clazz.getMethods()) {

            if(!Modifier.isStatic(method.getModifiers()) && method.getDeclaringClass().equals(clazz)) {

                fail(String.format("there exists a non-static method:%s", method));

            }

        }

    }

}
