package com.application.creditorural.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Custeio")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CusteioMunicipio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
    private Double vlCusteio;
    private String cdProduto;
    private String codCadMu;
    @JsonProperty("Atividade")
    private String atividade;
    private String cdModalidade;
    private String codIbge;
    @JsonProperty("AreaCusteio")
    private Integer areaCusteio;
}
