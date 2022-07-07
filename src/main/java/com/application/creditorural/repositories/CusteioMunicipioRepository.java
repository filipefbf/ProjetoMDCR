package com.application.creditorural.repositories;

import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.entities.converter.FilterConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CusteioMunicipioRepository extends JpaRepository<CusteioMunicipio, Long> {
   @Query("SELECT obj FROM CusteioMunicipio obj WHERE LOWER(obj.anoEmissao) LIKE LOWER(CONCAT('%',:anoEmissao,'%'))")
    Page<CusteioMunicipio> searchAno(String anoEmissao, Pageable pageable);

    @Query(value = "SELECT obj.anoEmissao as anoEmissao, " +
            "obj.municipio as municipio, " +
            "obj.nomeProduto as nomeProduto, " +
            "obj.codCadMu as codCadMu, " +
            "SUM(obj.vlCusteio) as vlCusteioSum " +
            "FROM CusteioMunicipio obj " +
            "WHERE obj.anoEmissao = :anoEmissao AND obj.cdProduto IN ('7100', '6720', '3560', '5080', '1840') " +
            "GROUP BY obj.anoEmissao, obj.municipio, obj.nomeProduto")
    List<FilterConverter> searchYearFilter(String anoEmissao);
}
