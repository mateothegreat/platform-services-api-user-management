package platform.platform.api.users;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserFaked {

    public static final int USERNAME_LENGTH_MIN = 4;
    public static final int USERNAME_LENGTH_MAX = 32;
    public static final int PASSWORD_LEGNTH_MIN = 8;
    public static final int PASSWORD_LEGNTH_MAX = 60;
    public static final int STATUS_RANGE_MIN    = 0;
    public static final int STATUS_RANGE_MAX    = 9;

    @Column(unique = true) @NotEmpty @Email
    private String email;

    @NotEmpty @Length(min = USERNAME_LENGTH_MIN, max = USERNAME_LENGTH_MAX)
    private String username;

    @NotEmpty @Length(min = PASSWORD_LEGNTH_MIN, max = PASSWORD_LEGNTH_MAX)
    private String password;

    @NotNull @Range(min = STATUS_RANGE_MIN, max = STATUS_RANGE_MAX)
    private int status;

    public UserFaked() {

    }

    public UserFaked(@NotEmpty @Email final String email, @NotEmpty @Length(min = 4, max = 32) final String username, @NotEmpty @Length(min = 8, max = 60) final String password, @NotNull @Range(min = 0, max = 9) final int status) {

        this.email = email;
        this.username = username;
        this.password = password;
        this.status = status;

    }

}
