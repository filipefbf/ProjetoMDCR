package com.application.creditorural.entities.converter;

import com.application.creditorural.DTO.FilterDto;
import com.application.creditorural.entities.CusteioMunicipio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilterDtoConverter {

    FilterDtoConverter converter = Mappers.getMapper(FilterDtoConverter.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "municipio", target = "municipio")
    @Mapping(source = "nomeProduto", target = "nomeProduto")
    @Mapping(source = "codCadMu", target = "codCadMu")
    @Mapping(source = "cdProduto", target = "cdProduto")
    @Mapping(source = "anoEmissao", target = "anoEmissao")
    @Mapping(source = "vlCusteio", target = "vlCusteio")
    CusteioMunicipio getEntity(FilterDto filterDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "municipio", target = "municipio")
    @Mapping(source = "nomeProduto", target = "nomeProduto")
    @Mapping(source = "codCadMu", target = "codCadMu")
    @Mapping(source = "cdProduto", target = "cdProduto")
    @Mapping(source = "anoEmissao", target = "anoEmissao")
    @Mapping(source = "vlCusteio", target = "vlCusteio")
    FilterDto getDto(CusteioMunicipio CusteioMunicipio);

}
