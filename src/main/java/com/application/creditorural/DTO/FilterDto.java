package com.application.creditorural.DTO;

import com.application.creditorural.entities.CusteioMunicipio;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;


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
