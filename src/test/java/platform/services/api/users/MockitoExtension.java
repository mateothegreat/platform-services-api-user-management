package platform.services.api.users;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.ExtensionContext.*;

import java.lang.reflect.Parameter;

import static org.mockito.Mockito.mock;

/**
 * {@code MockitoExtension} showcases the {@link TestInstancePostProcessor} and {@link ParameterResolver} extension APIs of JUnit 5 by
 * providing dependency injection support at the field level and at the method parameter level via Mockito 2.x's {@link Mock @Mock}
 * annotation.
 *
 * @since 5.0
 */
public class MockitoExtension implements TestInstancePostProcessor, ParameterResolver {

    @Override
    public void postProcessTestInstance(final Object testInstance, final ExtensionContext context) {

        MockitoAnnotations.initMocks(testInstance);

    }

    @Override
    public boolean supportsParameter(final ParameterContext parameterContext, final ExtensionContext extensionContext) {

        return parameterContext.getParameter().isAnnotationPresent(Mock.class);

    }

    @Override
    public Object resolveParameter(final ParameterContext parameterContext, final ExtensionContext extensionContext) {

        return getMock(parameterContext.getParameter(), extensionContext);

    }

    private Object getMock(final Parameter parameter, final ExtensionContext extensionContext) {

        final Class<?> mockType = parameter.getType();
        final Store    mocks    = extensionContext.getStore(Namespace.create(MockitoExtension.class, mockType));
        final String   mockName = getMockName(parameter);

        if(mockName != null) {

            return mocks.getOrComputeIfAbsent(mockName, key -> mock(mockType, mockName));

        } else {

            return mocks.getOrComputeIfAbsent(mockType.getCanonicalName(), key -> mock(mockType));

        }

    }

    private String getMockName(final Parameter parameter) {

        final String explicitMockName = parameter.getAnnotation(Mock.class).name().trim();

        if(!explicitMockName.isEmpty()) {

            return explicitMockName;

        } else if(parameter.isNamePresent()) {

            return parameter.getName();

        }

        return null;

    }

}
