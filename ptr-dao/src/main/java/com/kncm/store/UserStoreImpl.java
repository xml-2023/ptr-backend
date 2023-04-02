package com.kncm.store;

import com.kncm.converter.UserConverter;
import com.kncm.model.User;
import com.kncm.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserStoreImpl implements UserStore {
    private final UserRepository repository;
    private final UserConverter converter;

    @Override
    public User save(User user) {
        return converter.toModel(repository.save(converter.toEntity(user)));
    }

    @Override
    public User find(Long id) {
        return converter.toModel(repository.findOne(id));
    }

    @Override
    public boolean exists(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public User find(String email) {
        return converter.toModel(repository.findByEmail(email));
    }

    @Override
    public boolean exists(Long id) {
        return repository.existsById(id);
    }
}
