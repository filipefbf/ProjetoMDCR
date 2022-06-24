package com.application.creditorural.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class DTORoot {

    @JsonProperty("@odata.context")
    public String odataContext;
    public ArrayList<PostDto> value;
}
