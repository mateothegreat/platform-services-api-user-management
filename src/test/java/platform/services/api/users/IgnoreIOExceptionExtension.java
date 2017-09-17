package platform.services.api.users;

import org.junit.jupiter.api.extension.*;

import java.io.IOException;

public class IgnoreIOExceptionExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(final ExtensionContext context, final Throwable throwable)

        throws Throwable {

        if(throwable instanceof IOException) {

            return;

        }

        throw throwable;

    }

}
