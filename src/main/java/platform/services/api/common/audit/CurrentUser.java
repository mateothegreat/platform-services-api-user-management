package platform.services.api.common.audit;

import org.springframework.security.core.userdetails.User;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 7828419298616811182L;

    private User user;

    public CurrentUser(User user) {

        super(user.getUsername(), user.getPassword(),
                user.getAuthorities());
        this.user = user;
    }

    public User getUser() {

        return user;
    }

    public String getFullName() {

        return user.getUsername();
    }

//    public Long getId() {
//
//        return user.getId();
//    }

//    public String getProfileIconUrl() {
//
//        String iconUrl = "/images/user32x32.png";
//        if(this.user.hasAvatar()) {
//            iconUrl = applicationSettings.getProfileIconUrlRoot() + user.getUserKey();
//        }
//        return iconUrl;
//    }
//
//    public String getProfileImageUrl() {
//
//        String iconUrl = "/images/user.png";
//        if(this.user.hasAvatar()) {
//            iconUrl = applicationSettings.getProfileImageUrlRoot() + user.getUserKey();
//        }
//        return iconUrl;
//    }

    @Override
    public String toString() {

        return "CurrentUser{" +
                "user=" + user +
                '}' + super.toString();
    }
}
