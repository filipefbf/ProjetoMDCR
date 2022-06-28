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
    public long id;
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
