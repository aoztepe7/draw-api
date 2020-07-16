package com.ztp.raffleapi.domain.user;

import com.ztp.raffleapi.exception.domain.UserNotFoundException;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private static final String ROLE = "ROLE_";

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByMailAndDeletedFalseAndEnabled(mail, true);
            if(user == null) {
                throw new UsernameNotFoundException(mail);
            }
            return new org.springframework.security.core.userdetails.User(user.getMail(), user.getPassword(),
                    getAuthority(user));
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(mail);
        }
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(String.format("%s%s", ROLE, user.getRole())));
        return authorities;
    }
}
