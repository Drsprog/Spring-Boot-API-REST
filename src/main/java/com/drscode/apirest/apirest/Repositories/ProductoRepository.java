package com.drscode.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drscode.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
