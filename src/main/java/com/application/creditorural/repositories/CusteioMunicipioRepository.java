package com.application.creditorural.repositories;

import com.application.creditorural.entities.CusteioMunicipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CusteioMunicipioRepository extends JpaRepository<CusteioMunicipio, Long> {
}
