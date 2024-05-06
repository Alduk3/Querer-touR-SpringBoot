package com.riwi.querertourapi.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 12, nullable = false)
    private String nit;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 12, nullable = false)
    private String phone;
    @Column(length = 100, nullable = false)
    private String address;
    @Column(length = 100)
    private String email;
    @Column(length = 100, nullable = false)
    private String area;

    //relationship OneToMany
    //if the father is update, the son is updated too, or if the father got erased, all son are erased
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude

    private List<Branch_Company> branchCompanies;
}
