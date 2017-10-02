package platform.services.api.users.roles;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import platform.services.api.commons.validation.ValidationError;

@Service
@Getter @Setter
@Transactional
public class UserRoleFixtureFactory {

    private final UserRole fixture = UserRole.create();

    @Autowired
    private UserRoleService service;

    public UserRole generate() {

        try {

            return service.getById(service.save(fixture).getId());

        } catch(final ValidationError error) {

            error.printStackTrace();

        }

        return null;

    }

}
