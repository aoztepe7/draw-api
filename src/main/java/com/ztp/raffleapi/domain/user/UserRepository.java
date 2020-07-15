package com.ztp.raffleapi.domain.user;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    User findByIdAndDeletedFalseAndEnabled(UUID id,Boolean enabled);

    User findByMailAndDeletedFalseAndEnabled(String mail,Boolean enabled);
}
