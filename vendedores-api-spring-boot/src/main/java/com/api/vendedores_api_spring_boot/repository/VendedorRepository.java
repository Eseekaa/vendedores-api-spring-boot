package com.api.vendedores_api_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vendedores_api_spring_boot.models.Vendedor;

@Repository

public interface VendedorRepository extends JpaRepository <Vendedor, Integer> {

}
