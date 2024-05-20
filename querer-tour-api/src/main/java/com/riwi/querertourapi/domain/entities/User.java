package com.riwi.querertourapi.domain.entities;

import com.riwi.querertourapi.utils.enums.DocType;
import com.riwi.querertourapi.utils.enums.RoleUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    private String id;
    @Column(nullable = false, length = 40)
    private String name;
    @Column(nullable = false, length = 50)
    private String lastname;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DocType documentType;
    @Column(nullable = false, length = 20)
    private Integer document;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleUser roleUser;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "")
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = false)
    private List<Comment> commentList;
}
