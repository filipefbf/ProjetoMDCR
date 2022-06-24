package com.application.creditorural.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@JsonRootName(value = "value")
@Entity
@Table(name = "Custeio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PostDto {


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int userId;
//    public int id;
//    public String title;
//    public String body;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Municipio")
    public String municipio;
    public String nomeProduto;
    @JsonProperty("MesEmissao")
    public String mesEmissao;
    @JsonProperty("AnoEmissao")
    public String anoEmissao;
    public String cdPrograma;
    public String cdSubPrograma;
    public String cdFonteRecurso;
    public String cdTipoSeguro;
    public String cdEstado;
    @JsonProperty("VlCusteio")
    public double vlCusteio;
    public String cdProduto;
    public String codCadMu;
    @JsonProperty("Atividade")
    public String atividade;
    public String cdModalidade;
    public String codIbge;
    @JsonProperty("AreaCusteio")
    public int areaCusteio;
}
