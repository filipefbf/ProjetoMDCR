package com.application.creditorural.DTO;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class DtoRoot {
    private List<ListDto> value;
}
