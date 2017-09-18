package platform.services.api.users.authentication;

import lombok.extern.log4j.Log4j2;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.lang.Nullable;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.intercept.RunAsManagerImpl;
import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import platform.services.api.commons.jpa.enums.Role;

@Log4j2
public class AuthenticatedRunAsManager extends RunAsManagerImpl {

    public static void runAs(final String username, final Role... roles) {

        Assert.notNull(username, "Username must not be null!");

        log.trace("runAs(String username, String password, String... roles): {}, {}", username, roles);


        SecurityContextHolder.getContext().setAuthentication(buildAuthToken(username, roles));

    }

    protected static UsernamePasswordAuthenticationToken buildAuthToken(final String username, final Role... roles) {

        String[] list = new String[roles.length];

        for(int i = 0, length = roles.length; i < length; i++) {

            list[i] =roles[i].name();

        }

        return new UsernamePasswordAuthenticationToken(username, "asdfasdf", AuthorityUtils.createAuthorityList(list));

    }

    @Override
    @Nullable
    public Authentication buildRunAs(final Authentication authentication, final Object object, final Collection<ConfigAttribute> attributes) {

        if(!(object instanceof ReflectiveMethodInvocation) || ((ReflectiveMethodInvocation) object).getMethod().getAnnotation(

            AuthenticatedRunAsRole.class) == null) {

            return super.buildRunAs(authentication, object, attributes);

        }

        final String roleName = ((ReflectiveMethodInvocation) object).getMethod().getAnnotation(AuthenticatedRunAsRole.class).value();

        if(roleName.isEmpty()) {

            return null;

        }

        final GrantedAuthority       runAsAuthority = new SimpleGrantedAuthority(roleName);
        final List<GrantedAuthority> newAuthorities = new ArrayList<>(5);

        // Add existing authorities
        newAuthorities.addAll(authentication.getAuthorities());

        // Add the new run-as authority
        newAuthorities.add(runAsAuthority);

        return new RunAsUserToken(

            getKey(),
            authentication.getPrincipal(),
            authentication.getCredentials(), newAuthorities,
            authentication.getClass()

        );

    }
//
//    public static User getPrincipal() {
//
//        User user = null;
//
//        final Authentication authentication = SecurityContextHolder.getContext()
//                                                                   .getAuthentication();
//
//        if(authentication != null) {
//
//            final Object principal = authentication.getPrincipal();
//
//            // principal can be "anonymousUser" (String)
////            if(principal instanceof CustomUserDetails) {
//
//                final CustomUserDetails userDetails = (CustomUserDetails) principal;
//
//                user = userDetails.getUser();
//
////            }
//
//        }
//
//        log.trace("getPrincipal(): {}", user.toString());
//
//        return user;
//
//    }

}
