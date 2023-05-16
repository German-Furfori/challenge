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

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public List<ProductResponseDto> getProducts() {
        return productMapper.toListDto(productRepository.findAll());
    }

    public ProductResponseDto getProductById(Long id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        if(productEntityOptional.isPresent()) {
            return productMapper.fromEntityToDto(productEntityOptional.get());
        } else {
            throw new RuntimeException();
        }
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        ProductEntity productEntity = productMapper.fromDtoToEntity(productRequestDto);
        productRepository.save(productEntity);
        log.info("Producto creado: " + productEntity.getNombre());
        return productMapper.fromEntityToDto(productEntity);
    }

    public ProductResponseDto updateProduct(ProductRequestDto productRequestDto, Long id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        if(productEntityOptional.isPresent()) {
            ProductEntity productEntity = productMapper.fromDtoToEntity(productRequestDto);
            productEntity.setId(id);
            productRepository.save(productEntity);
            return productMapper.fromEntityToDto(productEntity);
        } else {
            throw new RuntimeException();
        }
    }

    public ProductResponseDto deleteProduct(Long id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        if(productEntityOptional.isPresent()) {
            productRepository.deleteById(id);
            return productMapper.fromEntityToDto(productEntityOptional.get());
        } else {
            throw new RuntimeException();
        }
    }
}
