package com.paygoal.app.controllers;

import com.paygoal.app.dto.request.ProductRequestDto;
import com.paygoal.app.dto.response.ProductResponseDto;
import com.paygoal.app.exceptions.RepositoryAccessException;
import com.paygoal.app.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.paygoal.app.constants.HashMapStrings.ERROR_CODE;
import static com.paygoal.app.constants.HashMapStrings.ERROR_MESSAGE;

@AllArgsConstructor
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class ProductController {

    ProductService productService;

    @GetMapping(value = "/products")
    public ResponseEntity<?> getProducts() {
        Map<String, Object> response = new HashMap<>();
        List<ProductResponseDto> productResponseDtoList;
        try {
            productResponseDtoList = productService.getProducts();
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(productResponseDtoList);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        ProductResponseDto productResponseDto;
        try {
            productResponseDto = productService.getProductById(id);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(productResponseDto);
    }

    @GetMapping(value = "/products/name/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable(name = "name") String nombre) {
        Map<String, Object> response = new HashMap<>();
        ProductResponseDto productResponseDto;
        try {
            productResponseDto = productService.getProductByName(nombre);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(productResponseDto);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
        Map<String, Object> response = new HashMap<>();
        ProductResponseDto productResponseDto;
        try {
            productResponseDto = productService.createProduct(productRequestDto);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(productResponseDto);
    }

    @PutMapping(value = "/product/{id}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductRequestDto productRequestDto, @PathVariable(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        ProductResponseDto productResponseDto;
        try {
            productResponseDto = productService.updateProduct(productRequestDto, id);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(productResponseDto);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        ProductResponseDto productResponseDto;
        try {
            productResponseDto = productService.deleteProduct(id);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(productResponseDto);
    }

}