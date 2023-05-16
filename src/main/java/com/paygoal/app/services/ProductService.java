package com.paygoal.app.services;

import com.paygoal.app.dto.request.ProductRequestDto;
import com.paygoal.app.dto.response.ProductResponseDto;
import com.paygoal.app.entities.ProductEntity;
import com.paygoal.app.mappers.ProductMapper;
import com.paygoal.app.repositories.IProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        ProductEntity productEntity = productMapper.fromDtoToEntity(productRequestDto);
        productRepository.save(productEntity);
        log.info("Producto creado: " + productEntity.getNombre());
        return productMapper.fromEntityToDto(productEntity);
    }

}
