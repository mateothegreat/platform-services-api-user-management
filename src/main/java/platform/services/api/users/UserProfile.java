package platform.services.api.users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;

@Log4j2
@Entity @Getter @Setter @ToString
@Table(name = "user_profile")
//@IdClass(UserProfileFK.class)
//public class UserProfile extends BaseEntity<UserProfile> {
public class UserProfile implements Serializable {

    //    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
//    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "parentId", insertable = true, updatable = true)
//    @MapsId
//    @OneToOne(mappedBy = "profile")
//    @OneToOne(cascade = CascadeType.ALL)
//    @MapsId
//    @OneToOne(fetch= FetchType.LAZY, mappedBy="profile")
//    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//    @JoinColumn(name = "user", referencedColumnName = "userid2")
//    @Id
//    @OneToOne(targetEntity = User.class, optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="testId", referencedColumnName = "parentId", nullable = false)
//    @JoinColumn(name = "parentId", insertable = false, updatable = false)
//    @OneToOne
//        @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
//    @JoinColumn(name = "parentId", insertable = false, updatable = false)

    //    @OneToOne(optional = true, fetch = FetchType.LAZY)
//    @JoinColumns({
//                     @JoinColumn(name = "parentId", insertable = false, updatable = false,referencedColumnName = "id"),
//                 })

    //    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "id")

//    @JoinColumn(name = "user_id")
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "profile")

//    public User user;
//@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)

    private static final long serialVersionUID = 2861993966732630305L;

    private User user;

    private String avatar;
    private Long userId;

    public UserProfile() {

    }

    public UserProfile(final String avatar) {

        this.avatar = avatar;

    }

    public UserProfile(final String avatar, final Long parentId) {

        this.avatar = avatar;
//        this.parentId = parentId;

    }

//    @Id
//    @Column(name = "user_id")
//    @GeneratedValue(generator = "gen")
//    @GenericGenerator(name = "gen", strategy = "foreign",
//                      parameters = @Parameter(name = "property", value = "user"))
//    private Long userId;

    @OneToOne(cascade={javax.persistence.CascadeType.ALL})
    @JoinColumn(name = "userId")
    public User getUser() {

        return user;

    }

    public void setUser(final User user) {

        this.user = user;

        if(user != null) {

            this.userId = user.getId();

        }

    }

    @Id
    @GeneratedValue(generator = "myGenerator")
    @GenericGenerator(name = "myGenerator", strategy = "foreign", parameters = @Parameter(value = "user", name = "property"))
    @Column(unique = true, nullable = false)
    public Long getUserId() {

        return userId;

    }

//    @Id
//    @GeneratedValue(generator = "foreignGenerator")
//    @org.hibernate.annotations.GenericGenerator(name = "foreignGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "atData"))
//    @Column(name = "userId")
//    private Long userId;
//

    public void setUserId(final Long userId) {

        this.userId = userId;

    }

}
