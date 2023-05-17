package com.paygoal.app.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    @NotNull(message = "El nombre no puede ser null")
    private String nombre;

    @NotNull(message = "La descripción no puede ser null")
    private String descripcion;

    @NotNull(message = "El precio no puede ser null")
    private Double precio;

    @NotNull(message = "La cantidad no puede ser null")
    private Integer cantidad;

}
