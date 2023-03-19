package com.kncm.store;

import com.kncm.model.Role;

public interface RoleStore {
    Role save(Role role);

    Role find(Long id);

    boolean exists(String name);
}
