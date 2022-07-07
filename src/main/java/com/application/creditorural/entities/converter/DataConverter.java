package com.application.creditorural.entities.converter;

import com.application.creditorural.DTO.ListDto;
import com.application.creditorural.entities.CusteioMunicipio;

public class
DataConverter {

    public static CusteioMunicipio getEntity(ListDto dto) {
       return CusteioMunicipio.builder()
               .municipio(dto.getMunicipio())
               .nomeProduto(dto.getNomeProduto())
               .mesEmissao(dto.getMesEmissao())
               .anoEmissao(dto.getAnoEmissao())
               .cdPrograma(dto.getCdPrograma())
               .cdSubPrograma(dto.getCdSubPrograma())
               .cdFonteRecurso(dto.getCdFonteRecurso())
               .cdTipoSeguro(dto.getCdTipoSeguro())
               .cdEstado(dto.getCdEstado())
               .vlCusteio(dto.getVlCusteio())
               .cdProduto(dto.getCdProduto())
               .codCadMu(dto.getCodCadMu())
               .atividade(dto.getAtividade())
               .cdModalidade(dto.getCdModalidade())
               .codIbge(dto.getCodIbge())
                .areaCusteio(dto.getAreaCusteio())
                .build();
    };
}
