package com.covinoc.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;

    @Column(name = "identification", length = 10, nullable = false)
    private String identification;

    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "modification_date")
    private LocalDateTime modificationDate;
}
