package platform.services.api.users.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import platform.services.api.commons.services.GenericService;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.users.User;
import platform.services.api.users.UserService;

@Service
public class UserRoleService extends GenericService<UserRoleRepository, UserRole> {

    private final UserRoleRepository repository;

    @Autowired
    private UserService userService;


    @Autowired
    public UserRoleService(final UserRoleRepository repository) {

        super(repository);

        this.repository = repository;

    }

    public UserRole save(final UUID uuid, final UserRole entity) throws ValidationError {

        final User parent = userService.getByUuid(uuid);

        if(parent == null) {

            throw new ValidationError("Invalid user");

        }

        entity.setUser(parent);

        return repository.save(entity);

    }

}
