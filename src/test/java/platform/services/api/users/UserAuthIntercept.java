package platform.services.api.users;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@Service @Getter
public class UserAuthIntercept extends AbstractTestNGSpringContextTests {

    private User        userEntity;
    private UserFactory userFactory;

    @Autowired
    public UserAuthIntercept(UserFactory userFactory) {

        this.userFactory = userFactory;

        userEntity = userFactory.persistNewUser();

    }

}
