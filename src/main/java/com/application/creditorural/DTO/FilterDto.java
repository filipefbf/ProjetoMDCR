package com.application.creditorural.DTO;

import com.application.creditorural.entities.CusteioMunicipio;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilterDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String municipio;
    private String nomeProduto;
    private String codCadMu;
    private String cdProduto;
    @JsonProperty("AnoEmissao")
    private String anoEmissao;
    @JsonProperty("VlCusteio")
    private double vlCusteio;

    public FilterDto(CusteioMunicipio custeioMunicipio) {
        id = custeioMunicipio.getId();
        municipio = custeioMunicipio.getMunicipio();
        nomeProduto = custeioMunicipio.getNomeProduto();
        codCadMu = custeioMunicipio.getCodCadMu();
        cdProduto = custeioMunicipio.getCdProduto();
        anoEmissao = custeioMunicipio.getAnoEmissao();
        vlCusteio = custeioMunicipio.getVlCusteio();
    }
}
