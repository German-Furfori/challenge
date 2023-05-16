package com.paygoal.app.mappers;

import com.paygoal.app.dto.request.ProductRequestDto;
import com.paygoal.app.dto.response.ProductResponseDto;
import com.paygoal.app.entities.ProductEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<ProductResponseDto> toListDto(List<ProductEntity> productEntityList) {
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        productEntityList.forEach(productEntity -> {
            ProductResponseDto productResponseDto = this.fromEntityToDto(productEntity);
            productResponseDtoList.add(productResponseDto);
        });

        return productResponseDtoList;
    }

}
