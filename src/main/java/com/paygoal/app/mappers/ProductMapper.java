package com.paygoal.app.mappers;

import com.paygoal.app.dto.request.ProductRequestDto;
import com.paygoal.app.dto.response.ProductResponseDto;
import com.paygoal.app.entities.ProductEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductMapper {

    private final ModelMapper modelMapper;

    public ProductResponseDto fromEntityToDto(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductResponseDto.class);
    }

    public ProductEntity fromDtoToEntity(ProductRequestDto productRequestDto) {
        return modelMapper.map(productRequestDto, ProductEntity.class);
    }

}
