package com.kncm.role;

import com.kncm.constant.RoleConstant;
import com.kncm.constant.TestConstant;
import com.kncm.model.Role;

public class RoleBuilder {
    public Role initializeRole() {
        Role role = new Role();
        role.setId(TestConstant.TEST_ID);
        role.setName(RoleConstant.EMPLOYEE);
        return role;
    }
}
