package com.ztp.raffleapi.event;

import com.ztp.raffleapi.domain.user.User;
import com.ztp.raffleapi.domain.user.UserRepository;
import com.ztp.raffleapi.domain.user.UserService;
import com.ztp.raffleapi.domain.user.UserType;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AutoCreateEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        User user = new User();
        user.setMail("aliztp7@gmail.com");
        user.setName("Ali Oztepe");
        user.setPassword(bCryptPasswordEncoder.encode("12345678"));
        user.setPrefix("ADMIN");
        user.setUserType(UserType.SYSTEM_ADMIN);
        user.setDeleted(false);
        user.setEnabled(true);
        userRepository.save(user);
    }
}
