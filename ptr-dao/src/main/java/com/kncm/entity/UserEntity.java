package com.kncm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("users")
public class UserEntity {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private RoleEntity role;
}
