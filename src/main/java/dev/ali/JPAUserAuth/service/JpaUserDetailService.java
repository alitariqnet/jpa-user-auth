package dev.ali.JPAUserAuth.service;

import dev.ali.JPAUserAuth.entity.User;
import dev.ali.JPAUserAuth.misc.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaUserDetailService implements UserDetailsService {

    private UserService userService;

    public JpaUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found in the database: "+ username));
//            Optional<User> user = userService.findByUsername(username);
//        return org.springframework.security.core.userdetails.User.builder().username(user.get().getUsername())
//                .password(user.get().getPassword()).roles(user.get().getRoles()).build();
    }
}
