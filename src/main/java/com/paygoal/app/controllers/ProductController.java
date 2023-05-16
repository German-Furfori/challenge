package com.paygoal.app.controllers;

import com.paygoal.app.dto.request.ProductRequestDto;
import com.paygoal.app.dto.response.ProductResponseDto;
import com.paygoal.app.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class ProductController {

    ProductService productService;

    @GetMapping(value = "/products")
    public List<ProductResponseDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(value = "/products/{id}")
    public ProductResponseDto getProductById(@PathVariable(name = "id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping(value = "/create")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @PutMapping(value = "/update/{id}")
    public ProductResponseDto updateProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable(name = "id") Long id) {
        return productService.updateProduct(productRequestDto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ProductResponseDto deleteProduct(@PathVariable(name = "id") Long id) {
        return productService.deleteProduct(id);
    }

}
