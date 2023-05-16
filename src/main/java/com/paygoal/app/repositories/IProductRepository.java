package com.paygoal.app.repositories;

import com.paygoal.app.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
}
