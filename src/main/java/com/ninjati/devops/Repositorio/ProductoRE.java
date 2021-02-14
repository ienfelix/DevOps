package com.ninjati.devops.Repositorio;

import com.ninjati.devops.Modelo.ProductoMO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRE extends JpaRepository<ProductoMO, Long> {
}
