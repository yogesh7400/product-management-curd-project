package com.product.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.modal.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{

}
