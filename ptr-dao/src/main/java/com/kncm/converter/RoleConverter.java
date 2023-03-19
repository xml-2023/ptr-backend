package com.kncm.converter;

import com.kncm.entity.RoleEntity;
import com.kncm.model.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleConverter implements GenericConverter<Role, RoleEntity> {
    @Override
    public Role toModel(RoleEntity roleEntity) {
        Role role = new Role();
        role.setId(roleEntity.getId());
        role.setName(roleEntity.getName());

        return role;
    }

    @Override
    public List<Role> toModel(List<RoleEntity> roleEntities) {
        List<Role> roles = new ArrayList<>();
        for (RoleEntity roleEntity : roleEntities) {
            Role role = new Role();
            role.setId(roleEntity.getId());
            role.setName(roleEntity.getName());
            roles.add(role);
        }

        return roles;
    }

    @Override
    public RoleEntity toEntity(Role role) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(role.getId());
        roleEntity.setName(role.getName());

        return roleEntity;
    }

    @Override
    public List<RoleEntity> toEntity(List<Role> roles) {
        List<RoleEntity> roleEntities = new ArrayList<>();
        for (Role role : roles) {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setId(role.getId());
            roleEntity.setName(role.getName());
            roleEntities.add(roleEntity);
        }

        return roleEntities;
    }
}
