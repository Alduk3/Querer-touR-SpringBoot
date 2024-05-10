package com.querertour.QuerertouR.domain.entities;

import com.querertour.QuerertouR.utils.enums.DocType;
import com.querertour.QuerertouR.utils.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comments;
import org.hibernate.sql.results.graph.Fetch;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    private Role role;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = false)
//    private List<Comment> comments;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "")
//    private List<Comment> commentList;
}
