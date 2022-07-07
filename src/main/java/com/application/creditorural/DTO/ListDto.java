package com.application.creditorural.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonRootName(value = "value")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ListDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("Municipio")
    private String municipio;
    private String nomeProduto;
    @JsonProperty("MesEmissao")
    private String mesEmissao;
    @JsonProperty("AnoEmissao")
    private String anoEmissao;
    private String cdPrograma;
    private String cdSubPrograma;
    private String cdFonteRecurso;
    private String cdTipoSeguro;
    private String cdEstado;
    @JsonProperty("VlCusteio")
    private double vlCusteio;
    private String cdProduto;
    private String codCadMu;
    @JsonProperty("Atividade")
    private String atividade;
    private String cdModalidade;
    private String codIbge;
    @JsonProperty("AreaCusteio")
    private int areaCusteio;
}
