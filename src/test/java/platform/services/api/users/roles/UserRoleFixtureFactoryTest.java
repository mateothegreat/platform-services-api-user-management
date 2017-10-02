package platform.services.api.users.roles;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.TestingFixtureFactory;

import static org.assertj.core.api.Assertions.assertThat;

@TestingFixtureFactory
public class UserRoleFixtureFactoryTest {

    @Autowired
    private UserRoleFixtureFactory factory;

    @BeforeEach public void beforeEach() {

        assertThat(factory).isNotNull();

    }

    @Test
    public void createValidEntity() {

        assertThat(factory.generate().getId()).isNotZero();

    }

}
