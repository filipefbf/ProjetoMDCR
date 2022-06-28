package com.application.creditorural.entities.converter;

import com.application.creditorural.DTO.PostDto;
import com.application.creditorural.entities.CusteioMunicipio;

public class
DataConverter {

    public static CusteioMunicipio getEntity(PostDto dto) {
       return CusteioMunicipio.builder()
                .nomeProduto(dto.getNomeProduto())
                .cdPrograma(dto.getCdPrograma())
                .cdSubPrograma(dto.getCdSubPrograma())
                .cdFonteRecurso(dto.getCdFonteRecurso())
                .cdTipoSeguro(dto.getCdTipoSeguro())
                .cdEstado(dto.getCdEstado())
                .cdProduto(dto.getCdProduto())
                .codCadMu(dto.getCodCadMu())
                .cdModalidade(dto.getCdModalidade())
                .codIbge(dto.getCodIbge())
                .municipio(dto.getMunicipio())
                .mesEmissao(dto.getMesEmissao())
                .anoEmissao(dto.getAnoEmissao())
                .vlCusteio(dto.getVlCusteio())
                .atividade(dto.getAtividade())
                .areaCusteio(dto.getAreaCusteio())
                .build();
    };
}
