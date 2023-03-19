package com.kncm.repository;

import com.kncm.entity.UserEntity;

public interface UserRepository extends EntityRepository<UserEntity> {
    boolean existsByEmail(String email);
}
