package platform.services.api.commons.testing;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ClassWellFormed {

    private static final ResourceBundle R = ResourceBundle.getBundle("ClassWellFormedTestMessages");

    public static Integer classCountConstructors(final Class<?> clazz) {

        return clazz.getDeclaredConstructors().length;

    }

    public static Boolean classHasOneConstructor(final Class<?> clazz) throws ReflectiveOperationException {

        final int total = classCountConstructors(clazz);

        if(total != 1) {

            throw new AssertionError(
                MessageFormat.format(R.getString("ClassWellFormedTestMessages.notOneConstructor"), clazz.getName(), total));

        }

        return true;
    }

    public static Boolean classHasMoreThanOneConstructor(final Class<?> clazz) throws ReflectiveOperationException {

        final int total = classCountConstructors(clazz);

        if(total < 1) {

            throw new AssertionError(
                MessageFormat.format(R.getString("ClassWellFormedTestMessages.moreThanOneConstructor"), clazz.getName(), total));

        }

        return true;

    }

    public static Boolean classHasPrivateConstructor(final Class<?> clazz) throws ReflectiveOperationException {

        final Constructor<?> constructor = clazz.getDeclaredConstructor();

        if(!Modifier.isPrivate(constructor.getModifiers())) {

            throw new AssertionError(MessageFormat.format(R.getString("ClassWellFormedTestMessages.constructorNotPrivate"), constructor));

        }

        return true;

    }

    public static Boolean classHasPublicConstructor(final Class<?> clazz) throws ReflectiveOperationException {

        final Constructor<?> constructor = clazz.getDeclaredConstructor();

        if(!Modifier.isPublic(constructor.getModifiers())) {

            throw new AssertionError(MessageFormat.format(R.getString("ClassWellFormedTestMessages.constructorNotPublic"), constructor));

        }

        return true;

    }

    public static Boolean classHasFinalConstructor(final Class<?> clazz) {

        if(!Modifier.isFinal(clazz.getModifiers())) {

            throw new AssertionError(MessageFormat.format(R.getString("ClassWellFormedTestMessages.constructorNotFinal"), clazz.getName()));

        }

        return true;

    }

    public static Boolean classHasAllStaticMethods(final Class<?> clazz) {

        for(final Method method : clazz.getMethods()) {

            if(!Modifier.isStatic(method.getModifiers()) && method.getDeclaringClass().equals(clazz)) {

                throw new AssertionError(MessageFormat.format(R.getString("ClassWellFormedTestMessages.methodNotStatic"), method));

            }

        }

        return true;

    }

}
