package com.kncm.repository;

import com.kncm.entity.RoleEntity;

public interface RoleRepository extends EntityRepository<RoleEntity> {
    boolean existsByName(String name);
}
