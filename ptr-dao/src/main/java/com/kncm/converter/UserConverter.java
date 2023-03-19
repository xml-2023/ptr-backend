package com.kncm.converter;

import com.kncm.entity.UserEntity;
import com.kncm.model.User;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserConverter implements GenericConverter<User, UserEntity> {
    private final RoleConverter roleConverter;

    @Override
    public User toModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setSurname(userEntity.getSurname());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setRole(roleConverter.toModel(userEntity.getRole()));

        return user;
    }

    @Override
    public List<User> toModel(List<UserEntity> userEntities) {
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            User user = new User();
            user.setId(userEntity.getId());
            user.setName(userEntity.getName());
            user.setSurname(userEntity.getSurname());
            user.setEmail(userEntity.getEmail());
            user.setPassword(userEntity.getPassword());
            user.setRole(roleConverter.toModel(userEntity.getRole()));
            users.add(user);
        }

        return users;
    }

    @Override
    public UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setSurname(user.getSurname());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(roleConverter.toEntity(user.getRole()));

        return userEntity;
    }

    @Override
    public List<UserEntity> toEntity(List<User> users) {
        List<UserEntity> userEntities = new ArrayList<>();
        for (User user : users) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(user.getId());
            userEntity.setName(user.getName());
            userEntity.setSurname(user.getSurname());
            userEntity.setEmail(user.getEmail());
            userEntity.setPassword(user.getPassword());
            userEntity.setRole(roleConverter.toEntity(user.getRole()));
            userEntities.add(userEntity);
        }

        return userEntities;
    }
}
