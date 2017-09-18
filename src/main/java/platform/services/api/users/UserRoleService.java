package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import platform.services.api.commons.services.GenericServiceImpl;

@Log4j2
@Service
public class UserRoleService extends GenericServiceImpl<UserRoleRestRepository, UserRole> {

    private final UserRoleRestRepository repository;

    @Autowired
    public UserRoleService(final UserRoleRestRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
