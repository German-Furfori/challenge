package com.paygoal.app.utils;

import com.paygoal.app.entities.ProductEntity;
import com.paygoal.app.exceptions.RepositoryAccessException;
import com.paygoal.app.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.paygoal.app.constants.ExceptionStrings.*;

@Component
public class Utils {

    @Autowired
    IProductRepository productRepository;

    public ProductEntity verifyProductId(Long id) throws RepositoryAccessException {
        if(id == null || id <= 0) {
            throw new RepositoryAccessException(READ_ACCESS_EXCEPTION_INCORRECT_ID);
        }
        Optional<ProductEntity> entity = productRepository.findById(id);
        if(entity.isEmpty()) {
            throw new RepositoryAccessException(READ_ACCESS_EXCEPTION_PRODUCT_ID_NOT_FOUND);
        }

        return entity.get();
    }

    public ProductEntity verifyProductName(String nombre) {
        if(nombre == null) {
            throw new RepositoryAccessException(READ_ACCESS_EXCEPTION_INCORRECT_NAME);
        }
        Optional<ProductEntity> entity = productRepository.findByName(nombre);
        if(entity.isEmpty()) {
            throw new RepositoryAccessException(READ_ACCESS_EXCEPTION_PRODUCT_NAME_NOT_FOUND);
        }

        return entity.get();
    }

    public void verifyIntegrityName(String nombre) {
        Optional<ProductEntity> entity = productRepository.findByName(nombre);
        if(entity.isPresent()) {
            throw new RepositoryAccessException(READ_ACCESS_EXCEPTION_INCORRECT_INPUT_NAME);
        }
    }

    public List<ProductEntity> verifyEmptyList() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        if(productEntityList.isEmpty()) {
            throw new RepositoryAccessException(READ_ACCESS_EXCEPTION_NOT_FOUND);
        }

        return productEntityList;
    }
}
