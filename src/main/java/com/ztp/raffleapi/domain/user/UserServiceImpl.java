package com.ztp.raffleapi.domain.user;

import com.ztp.raffleapi.exception.domain.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getById(UUID id, Boolean enabled) {
        return Optional.ofNullable(userRepository.findByIdAndDeletedFalseAndEnabled(id, enabled))
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User getByMail(String mail, Boolean enabled) {
        return Optional.ofNullable(userRepository.findByMailAndDeletedFalseAndEnabled(mail, enabled))
                .orElseThrow(UserNotFoundException::new);
    }
}
