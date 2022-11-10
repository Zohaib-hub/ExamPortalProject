package com.exam.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "role")
public class Role {
    @Id
    private Long roleId;
    private String roleName;


    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();

}
