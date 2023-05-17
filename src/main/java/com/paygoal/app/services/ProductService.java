package com.paygoal.app.services;

import com.paygoal.app.dto.request.ProductRequestDto;
import com.paygoal.app.dto.response.ProductResponseDto;
import com.paygoal.app.entities.ProductEntity;
import com.paygoal.app.mappers.ProductMapper;
import com.paygoal.app.repositories.IProductRepository;
import com.paygoal.app.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    Utils utils;

    public List<ProductResponseDto> getProducts() {
        List<ProductEntity> productEntityList = utils.verifyEmptyList().stream()
                .sorted(Comparator.comparing(ProductEntity::getPrecio))
                .collect(Collectors.toList());

        return productMapper.toListDto(productEntityList);
    }

    public ProductResponseDto getProductById(Long id) {
        ProductEntity productEntity = utils.verifyProductId(id);

        return productMapper.fromEntityToDto(productEntity);
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        ProductEntity productEntity = productMapper.fromDtoToEntity(productRequestDto);
        productRepository.save(productEntity);
        log.info("Producto creado: " + productEntity.getNombre());

        return productMapper.fromEntityToDto(productEntity);
    }

    public ProductResponseDto updateProduct(ProductRequestDto productRequestDto, Long id) {
        utils.verifyProductId(id);
        ProductEntity productEntity = productMapper.fromDtoToEntity(productRequestDto);
        productEntity.setId(id);
        productRepository.save(productEntity);

        return productMapper.fromEntityToDto(productEntity);
    }

    public ProductResponseDto deleteProduct(Long id) {
        ProductEntity productEntity = utils.verifyProductId(id);
        productRepository.deleteById(id);

        return productMapper.fromEntityToDto(productEntity);
    }
}
