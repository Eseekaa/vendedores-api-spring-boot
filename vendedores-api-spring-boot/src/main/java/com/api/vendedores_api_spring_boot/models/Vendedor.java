package com.api.vendedores_api_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "Vendedor")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer ID_Vendedor;
    private String Sucursal;

}
