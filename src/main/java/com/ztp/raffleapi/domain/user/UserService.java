package com.ztp.raffleapi.domain.user;

import java.util.UUID;

public interface UserService {
    User getById(UUID id, Boolean enabled);

    User getByMail(String mail,Boolean enabled);
}
