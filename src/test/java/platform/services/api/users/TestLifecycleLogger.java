package platform.services.api.users;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.*;

import java.util.logging.Logger;

@TestInstance(Lifecycle.PER_CLASS)
interface TestLifecycleLogger {

    Logger LOG = Logger.getLogger(TestLifecycleLogger.class.getName());

    @BeforeAll
    default void beforeAllTests() {

        LOG.info("Before all tests");

    }

    @AfterAll
    default void afterAllTests() {

        LOG.info("After all tests");

    }

    @BeforeEach
    default void beforeEachTest(final TestInfo testInfo) {

        LOG.info(() -> String.format("About to execute [%s]", testInfo.getDisplayName()));
    }

    @AfterEach
    default void afterEachTest(final TestInfo testInfo) {

        LOG.info(() -> String.format("Finished executing [%s]", testInfo.getDisplayName()));

    }

}
