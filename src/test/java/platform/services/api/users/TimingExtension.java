package platform.services.api.users;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.ExtensionContext.*;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final Logger LOG = Logger.getLogger(TimingExtension.class.getName());

    @Override
    public void beforeTestExecution(final ExtensionContext context) throws Exception {

        getStore(context).put(context.getRequiredTestMethod(), System.currentTimeMillis());

    }

    @Override
    public void afterTestExecution(final ExtensionContext context) throws Exception {

        final Method testMethod = context.getRequiredTestMethod();
        final long   start      = getStore(context).remove(testMethod, long.class);
        final long   duration   = System.currentTimeMillis() - start;

        LOG.info(() -> String.format("Method [%s] took %s ms.", testMethod.getName(), duration));

    }

    private Store getStore(final ExtensionContext context) {

        return context.getStore(Namespace.create(getClass(), context));

    }

}
