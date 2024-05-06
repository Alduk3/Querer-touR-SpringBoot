package com.riwi.querertourapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "branchCompany")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch_Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 100, nullable = false)
    private String name;
    private String id_site;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id" , referencedColumnName = "id" )
    private Company company;
}
