package com.application.creditorural.repositories;

import com.application.creditorural.DTO.FilterDto;
import com.application.creditorural.entities.CusteioMunicipio;
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

//    @Query("SELECT obj.anoEmissão as anoEmissão, " +
//            "obj.municipio as municipio, " +
//            "obj.nomeProduto as nomeProduto," +
//            "obj.codCadMu as codCadMu," +
//            "SUM(obj.vlCusteio) as vlCusteio" +
//            "FROM CusteioMunicipio obj" +
//            "WHERE obj.anoEmissao = :anoEmissao AND obj.cdProduto IN ('7100', '6720', '3560', '5080', '1840') " +
//            "GROUP BY obj.anoEmissão, obj.municipio, obj.nomeProduto")
//    List<CusteioMunicipio> searchAnoFilter(String anoEmissao);

    @Query("SELECT obj FROM CusteioMunicipio obj WHERE LOWER(obj.anoEmissao) LIKE LOWER(CONCAT('%',:anoEmissao,'%'))")
    Page<CusteioMunicipio> searchAnoFilter(String anoEmissao, Pageable pageable);



}
