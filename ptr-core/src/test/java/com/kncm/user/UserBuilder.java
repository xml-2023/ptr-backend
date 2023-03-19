package com.kncm.user;

import com.kncm.constant.TestConstant;
import com.kncm.constant.UserConstant;
import com.kncm.model.User;
import com.kncm.role.RoleBuilder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserBuilder {
    private final RoleBuilder roleBuilder;

    public User initializeUser() {
        User user = new User();
        user.setId(TestConstant.TEST_ID);
        user.setName(UserConstant.NAME);
        user.setSurname(UserConstant.SURNAME);
        user.setEmail(UserConstant.EMAIL);
        user.setPassword(UserConstant.PASSWORD);
        user.setRole(roleBuilder.initializeRole());
        return user;
    }
}
