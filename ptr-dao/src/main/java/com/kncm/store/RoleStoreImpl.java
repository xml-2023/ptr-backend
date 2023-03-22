package com.kncm.store;

import com.kncm.converter.RoleConverter;
import com.kncm.model.Role;
import com.kncm.repository.RoleRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RoleStoreImpl implements RoleStore {
    private final RoleRepository repository;
    private final RoleConverter converter;

    @Override
    public Role save(Role role) {
        return converter.toModel(repository.save(converter.toEntity(role)));
    }

    @Override
    public Role find(Long id) {
        return converter.toModel(repository.findOne(id));
    }

    @Override
    public boolean exists(String name) {
        return repository.existsByName(name);
    }

    @Override
    public Role find(String name) {
        return converter.toModel(repository.findByName(name));
    }
}
