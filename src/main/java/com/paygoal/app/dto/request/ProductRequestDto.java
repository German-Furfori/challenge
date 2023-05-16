package com.paygoal.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String nombre;

    private String descripcion;

    private Double precio;

    private Integer cantidad;

}
