package com.paygoal.app.repositories;

import com.paygoal.app.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("Select PE from ProductEntity PE where PE.nombre = :nombre")
    Optional<ProductEntity> findByName(@Param("nombre") String nombre);
}
