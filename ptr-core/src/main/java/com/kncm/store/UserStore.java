package com.kncm.store;

import com.kncm.model.User;

public interface UserStore {
    User save(User user);

    User find(Long id);

    boolean exists(String email);
}
