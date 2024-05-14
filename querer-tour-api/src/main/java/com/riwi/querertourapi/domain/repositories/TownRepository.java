package com.riwi.querertourapi.domain.repositories;

import com.riwi.querertourapi.domain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** La interface TownRepository extiende de JpaRepository
 * que es la que nos da toda la funcionalidad.
 * JpaRepository nos pide dos cosas: la entidad que va a
 * controlar y el tipo de dato de la llave primaria de
 * esa entidad */
@Repository
public interface TownRepository extends JpaRepository<Town, String> {

}
