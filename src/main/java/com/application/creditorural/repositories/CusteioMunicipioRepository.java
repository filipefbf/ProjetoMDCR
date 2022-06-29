package com.application.creditorural.repositories;

import com.application.creditorural.entities.CusteioMunicipio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CusteioMunicipioRepository extends JpaRepository<CusteioMunicipio, Long> {
   @Query("SELECT obj FROM CusteioMunicipio obj WHERE LOWER(obj.anoEmissao) LIKE LOWER(CONCAT('%',:anoEmissao,'%'))")
    Page<CusteioMunicipio> searchAno(String anoEmissao, Pageable pageable);
}
