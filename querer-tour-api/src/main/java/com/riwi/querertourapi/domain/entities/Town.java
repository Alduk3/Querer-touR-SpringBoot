package com.riwi.querertourapi.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "town")
@Data /** Crea los getters, setters y el to string */
@AllArgsConstructor /** Crea constructor lleno */
@NoArgsConstructor /** Crea constructor vacío */
public class Town {
    @Id
    /** @GeneratedValue Para que autogenere el id */
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 50, nullable = false) /** nullable = false significa que es un atributo obligatorio */
    private String name;
    @Column(nullable = false)
    private String img;
    private String audio;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String short_description;
    @Column(nullable = false)
    private String qr;

    // Connection to site
    @OneToMany(mappedBy = "town", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Site> sites;
}
